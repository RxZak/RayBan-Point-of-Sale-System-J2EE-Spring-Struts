package org.sid.web;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.components.ActionMessage;
import org.apache.struts2.interceptor.SessionAware;
import org.sid.entities.Articles_Stock;
import org.sid.entities.Cart;
import org.sid.entities.commandes;
import org.sid.service.ICartService;
import org.sid.service.ICatalogueService;
import org.sid.service.IUserService;
import org.sid.service.SingletonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

@Component
public class CartAction extends ActionSupport implements SessionAware {
	// Properties
    private int codePdt;
    private String login;
    private List<Cart> carts = new ArrayList<Cart>();
    private List<commandes> commandes = new ArrayList<commandes>();
    private List<Articles_Stock> articles = new ArrayList<Articles_Stock>();
    private double sumCart;
    private String payementMethod;
    private String address;
    private BigInteger mobileNumber;
    private List<Cart> cartsOrder = new ArrayList<Cart>();
    private String message;
    private List<String> payementMethods;

    
    // Services
	@Autowired
	private ICatalogueService catalogueService;
	
	@Autowired
	private IUserService userService;

	@Autowired
	private ICartService cartService;

	
	// Getters and Setters
    public List<String> getPayementMethods() {
		return payementMethods;
	}

	public void setPayementMethods(List<String> payementMethods) {
		this.payementMethods = payementMethods;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<commandes> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<commandes> commandes) {
		this.commandes = commandes;
	}

	public String getPayementMethod() {
		return payementMethod;
	}

	public void setPayementMethod(String payementMethod) {
		this.payementMethod = payementMethod;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BigInteger getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(BigInteger mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public List<Cart> getCartsOrder() {
		return cartsOrder;
	}

	public void setCartsOrder(List<Cart> cartsOrder) {
		this.cartsOrder = cartsOrder;
	}

	public List<Articles_Stock> getArticles() {
		return articles;
	}

	public void setArticles(List<Articles_Stock> articles) {
		this.articles = articles;
	}

	public List<Cart> getCarts() {
		return carts;
	}

	public void setCarts(List<Cart> carts) {
		this.carts = carts;
	}

	public double getSumCart() {
		return sumCart;
	}

	public void setSumCart(double sumCart) {
		this.sumCart = sumCart;
	}

	public List<Cart> getCart() {
        return carts;
    }

    public void setCart(List<Cart> cart) {
        this.carts = cart;
    }

    public int getCodePdt() {
        return codePdt;
    }

    public void setCodePdt(int codePdt) {
        this.codePdt = codePdt;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setCartService(ICartService cartService) {
        this.cartService = cartService;
    }
    
    
    // Actions
    public String ajouter() {
    	boolean added = false;
        Articles_Stock article = cartService.getArticleByCode(codePdt);
        
        if (article == null) {
            // Le produit n'existe pas
            return ERROR;
        }

        // Créer une nouvelle instance de Cart
        Cart cartItem = new Cart();
        cartItem.setLogin(login);
        cartItem.setCodePdt(article.getCodePdt());
        cartItem.setQteCart(1); // Vous pouvez définir la quantité appropriée ici
        cartItem.setPrixCart(article.getPrixPdt());
     
        carts.add(cartItem);
        
        // Appeler la méthode addToCart du service pour ajouter l'objet Cart dans la base de données
        added = cartService.addToCart(login, codePdt);
        if(added) {
            setMessage("added");
        } else {
            setMessage("outofstock");
        }
        return SUCCESS;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        session.put("login", login);
        session.put("codePdt", codePdt);
    }
    

	public String index() {
		payementMethods = new ArrayList<String>();
		payementMethods.add("Cash On Delivery");
		payementMethods.add("Online Payement");
		carts=cartService.getUserCart(login);
		sumCart = cartService.sumCart(login);
		if(!carts.isEmpty()) {
			for(Cart c : carts) {
				Articles_Stock article = catalogueService.getProduits(c.getCodePdt());
				articles.add(article);
				System.out.println(article.getNomPdt());
			}
		}
		return SUCCESS;
	}
	
	public String commandes() {
		commandes=cartService.getUserCommandes(login);
		if(!commandes.isEmpty()) {
			for(commandes c : commandes) {
				Articles_Stock article = catalogueService.getProduits(c.getCodePdt());
				articles.add(article);
				System.out.println(article.getNomPdt());
			}
		}
		return SUCCESS;
	}
	
	public String commander() {
		carts = cartService.commander(login, address, mobileNumber, payementMethod);
		if(!carts.isEmpty()) {
			for(Cart c : carts) {
				Articles_Stock article = catalogueService.getProduits(c.getCodePdt());
				articles.add(article);
				System.out.println(article.getNomPdt());
			}
		}
		return SUCCESS;
	}
	
	public String removeFromCart() {
	    cartService.removeFromCart(login, codePdt);
        setMessage("removed");
	    return SUCCESS;
	}

}
