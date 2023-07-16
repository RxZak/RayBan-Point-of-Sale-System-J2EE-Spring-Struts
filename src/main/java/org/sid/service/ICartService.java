package org.sid.service;

import java.math.BigInteger;
import java.util.List;

import org.sid.entities.Articles_Stock;
import org.sid.entities.Cart;
import org.sid.entities.commandes;

public interface ICartService {
	public boolean addToCart(String login, int codePdt);
	public Articles_Stock getArticleByCode(int codePdt);
	public List<Cart> getUserCart(String username);
	public double sumCart(String username);
	public List<Cart> commander(String login, String address, BigInteger mobileNumber, String payementMethod);
	public List<commandes> getUserCommandes(String username);
	public void removeFromCart(String login, int codePdt);
}
