package org.sid.service;


import org.sid.dao.CartDAOJPAImpl;
import org.sid.dao.CatalogueDAOJPAImpl;
import org.sid.dao.UsersDAOJPAImpl;
import org.springframework.transaction.annotation.Transactional;
@Transactional

public class SingletonService {
	// Services
	private static CatalogueServiceImpl catalogueService;
	private static UserServiceImpl userService;
	private static CartServiceImpl cartService;
	
	// Instantiation
	static {
		CatalogueDAOJPAImpl catalogueDAO = new CatalogueDAOJPAImpl();
		catalogueService = new CatalogueServiceImpl();
		catalogueService.setCatalogueDAO(catalogueDAO);
		
		UsersDAOJPAImpl usersDAO = new UsersDAOJPAImpl();
		userService = new UserServiceImpl();
		userService.setUsersDAO(usersDAO);
		
		CartDAOJPAImpl cartDAO=new CartDAOJPAImpl();
		cartService=new CartServiceImpl();
		cartService.setCartDAO(cartDAO);
				
	}
	
	// Getters
	public static CatalogueServiceImpl getCatalogueService() {
		return catalogueService;
	}
	
	public static UserServiceImpl getUserServiceImpl() {
		return userService;
	}
	
	public static CartServiceImpl getCartServiceImpl() {
		return cartService;
	}
}
