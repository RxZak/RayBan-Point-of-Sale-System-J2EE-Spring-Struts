package  org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class Users implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer codeUser;
	
	private String login;
	
	private String pass;
	
	private String securityQuestion;
	
	private String answer;

	public String getSecurityQuestion() {
		return securityQuestion;
	}
	
	public Users() {
	}

	public Users(String login, String pass, String securityQuestion, String answer) {
		super();
		this.login = login;
		this.pass = pass;
		this.securityQuestion = securityQuestion;
		this.answer = answer;
	}

	public Users(Integer codeUser, String login, String pass, String securityQuestion, String answer) {
		super();
		this.codeUser = codeUser;
		this.login = login;
		this.pass = pass;
		this.securityQuestion = securityQuestion;
		this.answer = answer;
	}

	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}


	public Integer getCodeUser() {
		return codeUser;
	}

	public void setCodeUser(Integer codeUser) {
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

}
