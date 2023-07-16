package org.sid.web;

import java.util.List;

import org.sid.entities.Users;
import org.sid.entities.commandes;
import org.sid.entities.Articles_Prix;
import org.sid.entities.Articles_Stock;
import org.sid.service.ICatalogueService;
import org.sid.service.IUserService;
import org.sid.service.SingletonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
@Component
public class ProduitAction extends ActionSupport{
	// Properties
	public Articles_Stock produit= new Articles_Stock();//1
	public Articles_Prix produitp=new Articles_Prix();//2
	public int codeUser; public String login; public String pass;
	public Users user=new Users();
	public List<Articles_Stock> produits;
	public List<Articles_Prix> produitsP;//3
	private String username;
	private String password;
	public List<Users> users;
	public commandes commande =new commandes();
	public List<commandes> commandes;
	public int code;
	public int codeU;
	
	// Services
	@Autowired
	private ICatalogueService catalogueService;
	
	@Autowired
	private IUserService userService;
	
	//Getters and Setters
	public String getUsername() {
		return username;
	}
 
	public void setUsername(String username) {
		this.username = username;
	}
 
	public String getPassword() {
		return password;
	}
 
	public void setPassword(String password) {
		this.password = password;
	}
	
	// Actions
	public String indexH() {
		users=userService.listsUsers();
		return SUCCESS;
	}
	
	public String indexP() {
		users=userService.listsUsers();
		return SUCCESS;
	}
	
	public String cos() {
		produits=catalogueService.listsProduits();
		return SUCCESS;
	}

	public String index() {
		produits=catalogueService.listsProduits();
		produitsP=catalogueService.listsProduitsP();
		users=userService.listsUsers();
		return SUCCESS;
	}


	

}
