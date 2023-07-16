package org.sid.service;

import java.math.BigInteger;
import java.util.List;

import org.sid.dao.ICartDAO;
import org.sid.entities.Articles_Stock;
import org.sid.entities.Cart;
import org.sid.entities.commandes;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CartServiceImpl implements ICartService{
	// DAO
	private ICartDAO cartDAO;
	
	
	// Getter and Setter
	public ICartDAO getCartDAO() {
		return cartDAO;
	}

	public void setCartDAO(ICartDAO cartDAO) {
		this.cartDAO = cartDAO;
	}

	// Implementation
	@Override
	public boolean addToCart(String login, int codePdt) {
		return cartDAO.addToCart(login, codePdt);
		
	}

	@Override
	public Articles_Stock  getArticleByCode(int codePdt) {
		return cartDAO.getArticleByCode(codePdt);
	}

	@Override
	public List<Cart> getUserCart(String username) {
		return cartDAO.getUserCart(username);
	}

	@Override
	public double sumCart(String username) {
		return cartDAO.sumCart(username);
	}

	@Override
	public List<Cart> commander(String login, String address, BigInteger mobileNumber, String payementMethod) {
		return cartDAO.commander(login, address, mobileNumber, payementMethod);
	}

	@Override
	public List<commandes> getUserCommandes(String username) {
		return cartDAO.getUserCommandes(username);
	}

	@Override
	public void removeFromCart(String login, int codePdt) {
		cartDAO.removeFromCart(login, codePdt);
	}
	
}
