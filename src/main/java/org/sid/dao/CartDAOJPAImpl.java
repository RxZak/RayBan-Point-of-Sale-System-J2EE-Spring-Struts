package org.sid.dao;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.sid.entities.Articles_Stock;
import org.sid.entities.Cart;
import org.sid.entities.commandes;

public class CartDAOJPAImpl implements ICartDAO{
	// EntityManager
	@PersistenceContext
	private EntityManager em;
	
	// Implementations
	@Override
	public boolean addToCart(String login, int codePdt) {
		int quantity = 1;
		double product_price = 0;
		double product_total = 0;
		    try {
		    	Query productQuery = em.createQuery("from Articles_Stock where codePdt = :codePdt");
				productQuery.setParameter("codePdt", codePdt);
			    Articles_Stock A = null;
			    A = (Articles_Stock)productQuery.getSingleResult();
			    System.out.println("PRODUCT : "+A.getNomPdt());
			    product_price = A.getPrixPdt();
			    product_total = product_price;
			    
				Query cartQuery = em.createQuery("from Cart where codePdt = :codeArt and login = :username and statut is NULL");
			    cartQuery.setParameter("codeArt", codePdt);
			    cartQuery.setParameter("username", login);
			    Cart cart = null;
			    cart = (Cart)cartQuery.getSingleResult();	
			    
			    int newQuantity = cart.getQteCart() + 1;
			    double newTotal = cart.getTotal() + product_total;
			    if(newQuantity > A.getQtePdt()) {
			    	return false;
			    } else {
				    cart.setTotal(newTotal);
				    cart.setQteCart(newQuantity);
				    em.merge(cart);
			    }
			    return true;
				} catch (Exception e) {
					Cart cart = new Cart(); // Initialize a new cart object
				    cart.setLogin(login);
				    cart.setCodePdt(codePdt);
				    cart.setQteCart(quantity);
				    cart.setPrixCart(product_price);
				    cart.setTotal(product_total);
				    em.persist(cart);
				    return true;
				}
	}

	@Override
	public Articles_Stock getArticleByCode(int codePdt) {
		return em.find(Articles_Stock.class,codePdt);
		}
	
	@Override
	public List<Cart> getUserCart(String username){
		try {
			Query cartQuery = em.createQuery("from Cart where login = :username and statut is NULL");
			cartQuery.setParameter("username", username);
			return cartQuery.getResultList();
		} catch(Exception e) {
			System.out.println("getusercart error " + e);
			return null;
		}
		
	}
	
	
	@Override
	public List<commandes> getUserCommandes(String username){
		Query cartQuery = em.createQuery("from commandes where client = :username");
		cartQuery.setParameter("username", username);
		return cartQuery.getResultList();
	}
	@Override
	public double sumCart(String username) {
		try {
			Query sumQuery = em.createQuery("select sum(total) from Cart where login = :login and statut is NULL");
			sumQuery.setParameter("login", username);
			return (double)sumQuery.getSingleResult();
		}catch(Exception e) {
			return 0;
		}

	}
	
	@Override
	public List<Cart> commander(String login, String address, BigInteger mobileNumber, String payementMethod) {
		String status="Invoice";
		Date orderDate = new Date();
		SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
		String stringDate= DateFor.format(orderDate);
		Calendar c = Calendar.getInstance(); 
		c.setTime(orderDate); 
		c.add(Calendar.DATE, 7);
		Date orderDelivery = c.getTime();
		String stringOrderDelivery = DateFor.format(orderDelivery);
		
		    try {
		    	Query cartQuery = em.createQuery("from Cart where login = :username and statut is NULL");
			    cartQuery.setParameter("username", login);
			    List<Cart> cartItems = cartQuery.getResultList();
			    for(Cart cart : cartItems){
					commandes cmd = new commandes();
			    	Query articleQuery = em.createQuery("from Articles_Stock where codePdt = :codePdt");
			    	articleQuery.setParameter("codePdt", cart.getCodePdt());
			    	List<Articles_Stock> articles = articleQuery.getResultList();
			    	if (!articles.isEmpty()) {
		                Articles_Stock article = articles.get(0);
		                int updatedQuantity = article.getQtePdt() - cart.getQteCart();
		                
		                if (updatedQuantity >= 0) {
		                    article.setQtePdt(updatedQuantity);
		                    em.merge(article);
		                } else {
		                    throw new IllegalArgumentException("Insufficient quantity for product with code: " + cart.getCodePdt());
		                }
		            } else {
		                throw new IllegalArgumentException("Article not found for product with code: " + cart.getCodePdt());
		            }

			    	cart.setAdresse(address);
			        cart.setMobileNumber(mobileNumber);
			        cart.setPayementMethod(payementMethod);
			        cart.setStatut(status);
			        cart.setOrderDate(stringDate);
			        cart.setDeliveryDate(stringOrderDelivery);
			        cmd.setClient(login);
			        cmd.setCodePdt(cart.getCodePdt());
			        cmd.setDateCmd(stringDate);
			        cmd.setQteCmd(cart.getQteCart());
			        em.persist(cmd);
			        em.merge(cart);
			    }			        
			    return cartItems;
				} catch (Exception e) {
					System.out.println("commander error:"+e);
					return null;
				}
	}
	
	@Override
	public void removeFromCart(String login, int codePdt) {
		try {
			Query cartQuery = em.createQuery("from Cart where codePdt = :codePdt and login = :login and statut is NULL");
			cartQuery.setParameter("codePdt", codePdt);
			cartQuery.setParameter("login", login);
		    Cart cart = (Cart)cartQuery.getSingleResult();	
		    em.remove(cart);
		} catch(Exception e) {
			System.out.println(e);
		}
	}


	
	
}
