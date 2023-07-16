package org.sid.web;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;
import org.sid.entities.Users;
import org.sid.service.ICatalogueService;
import org.sid.service.IUserService;
import org.sid.service.SingletonService;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{
	// Properties
   private int codeUser;
   private String login;
   private String pass;
   private String oldPass;
   private String securityQuestion;
   private String confirmPass;
   private String answer;
   public Users user=new Users();
	public List<Users> users;
	public int codeU;
	SessionMap<String,String> sessionmap;  
	private String message;
	private List<String> secQuestions;

	
	// Getters and Setters
	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	public List<String> getSecQuestions() {
		return secQuestions;
	}

	public void setSecQuestions(List<String> secQuestions) {
		this.secQuestions = secQuestions;
	}

	public String getOldPass() {
		return oldPass;
	}

	public void setOldPass(String oldPass) {
		this.oldPass = oldPass;
	}

	public int getCodeUser() {
		return codeUser;
	}

	public void setCodeUser(int codeUser) {
		this.codeUser = codeUser;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getSecurityQuestion() {
		return securityQuestion;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getConfirmPass() {
		return confirmPass;
	}

	public void setConfirmPass(String confirmPass) {
		this.confirmPass = confirmPass;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public int getCodeU() {
		return codeU;
	}

	public void setCodeU(int codeU) {
		this.codeU = codeU;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}



	// Services
	@Autowired
	private ICatalogueService catalogueService;

	@Autowired
	private IUserService userService;

	
	// Actions
   public String execute() {
	   ActionContext.getContext().getSession().clear();
	    sessionmap.invalidate();
       Map<String, Object> session = ActionContext.getContext().getSession();
       session.put("loggedInUser", null);


	   if (ActionContext.getContext().getSession().containsKey("user")) {
	        return "success";
	    }
	    Users user = userService.getUserByUsernameAndPassword(login, pass);
	    
	    if (user != null) {
	        // User successfully logged in
	        session.put("user", user);
            session.put("loggedInUser", user.getLogin() );
	        ActionContext.getContext().getSession().remove("loginErrorMessage");

	        // Clear the session errors

	        return "success";
	    } else {
	        // Login failed, display error message
	        message = "Nom d'utilisateur ou mot de passe incorrect";
	        ActionContext.getContext().put("message", message);

	        // Store the error message in the session to display it on the login page
	        ActionContext.getContext().getSession().put("loginErrorMessage", message);

	        return "error";
	    }
   }
   
   public String logout() {
	    // Clear the user session
	    ActionContext.getContext().getSession().clear();
	    sessionmap.invalidate();
       Map<String, Object> session = ActionContext.getContext().getSession();
       session.put("loggedInUser", null);

	    // Redirect to the login page
	    return "success";
	}
   
   
   public String addUsers() {
		secQuestions = new ArrayList<String>();
		secQuestions.add("In what city did you meet your spouse/significant other?");
		secQuestions.add("In what city or town did your mother and father meet?");
		secQuestions.add("What was the first exam you failed?");
		secQuestions.add("What is your favorite movie?");

	    message = null;
	    ActionContext.getContext().getSession().remove("message");
	   if(userService.getUserByUsername(login) != null || !pass.equals(confirmPass)) {
			
			if (userService.getUserByUsername(login) != null) {
		        message = "This username is already used. Please choose another.";
		        ActionContext.getContext().put("message", message);
		    }
			if (!pass.equals(confirmPass)) {
		        message = "Passwords do not match.";
		        ActionContext.getContext().put("message", message);
		    }
	        return "error";
		}
	   Users newUser = new Users();
	    newUser.setLogin(login);
	    newUser.setPass(pass);
	    newUser.setSecurityQuestion(securityQuestion);
	    newUser.setAnswer(answer);
        message = "User created successfully, you can login now.";
        ActionContext.getContext().put("message", message);

	   userService.addUser(newUser);
	   return "success";
   }
   
   public String updatePas() {
	   user=userService.getUserByUsername(login);
	   users=userService.listsUsers();
	   return SUCCESS;
   }
   
   public String savePass() {
	    message = null;
	    ActionContext.getContext().getSession().remove("message");
	    Users user = userService.getUserByUsername(login);
	    if(user == null || !user.getPass().equals(oldPass) || !pass.equals(confirmPass)) {
	    	if (!user.getPass().equals(oldPass)) {
	    		message = "Incorrect password.";
			    ActionContext.getContext().put("message", message);
		    }
	    	if (!pass.equals(confirmPass)) {
	    		message = "Passwords do not match.";
		        ActionContext.getContext().put("message", message);
		    }
	        return "error";
	    }
	    user.setPass(pass);

	    if (userService.updateUser(user)) {
	        // Password update successful
	        message = "Your password has been successfully reset. You can login with your new password.";
	        ActionContext.getContext().put("message", message);
	        return "success";
	    } else {
	        // Password update failed
	        message = "Unable to reset password. please try again later.";
	        ActionContext.getContext().put("message", message);
	        return "error";
	    }
		  
	    
	   
   }
   

   

	@Override
	public void setSession(Map map) {
		sessionmap=(SessionMap)map;  
	    sessionmap.put("","true");  
	}
	
	public String forgotPass() {
		secQuestions = new ArrayList<String>();
		secQuestions.add("In what city did you meet your spouse/significant other?");
		secQuestions.add("In what city or town did your mother and father meet?");
		secQuestions.add("What was the first exam you failed?");
		secQuestions.add("What is your favorite movie?");
		message = null;
		 // Check if the provided username, security question, and answer are valid
	    Users user = userService.getUserByUsername(login);
	    if(user == null || !user.getSecurityQuestion().equals(securityQuestion) || !user.getAnswer().equals(answer) || !pass.equals(confirmPass)) {
	    	if (user == null) {
		        message = "Incorrect username.";
		        ActionContext.getContext().put("message", message);
		        return "fail";
		    }
	    	if (!user.getSecurityQuestion().equals(securityQuestion) || !user.getAnswer().equals(answer)) {
			    message = "Incorrect Security Question or Answer.";
			    ActionContext.getContext().put("message", message);
		    }
	    	if (!pass.equals(confirmPass)) {
		        message = "Unmatching Passwords.";
		        ActionContext.getContext().put("message", message);
		    }
	        return "fail";
	    }
	    user.setPass(pass);
	    // Update the user in the database (you need to implement this method)
	    if (userService.updateUser(user)) {
	        // Password update successful
	        message = "Your password has been reset, Please log in using your new password.";
	        ActionContext.getContext().put("message", message);
	        return "success";
	    } else {
	        // Password update failed
	        message = "Could not reset your password, Please try again later.";
	        ActionContext.getContext().put("message", message);
	        return "fail";
	    }
	}
	
	public String forgot() {
		secQuestions = new ArrayList<String>();
		secQuestions.add("In what city did you meet your spouse/significant other?");
		secQuestions.add("In what city or town did your mother and father meet?");
		secQuestions.add("What was the first exam you failed?");
		secQuestions.add("What is your favorite movie?");
		return SUCCESS;
	}
	
	public String New() {
		secQuestions = new ArrayList<String>();
		secQuestions.add("In what city did you meet your spouse/significant other?");
		secQuestions.add("In what city or town did your mother and father meet?");
		secQuestions.add("What was the first exam you failed?");
		secQuestions.add("What is your favorite movie?");
		return SUCCESS;
	}
	
	
	
	
	
}