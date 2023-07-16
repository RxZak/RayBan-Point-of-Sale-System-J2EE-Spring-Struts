package org.sid.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.sid.entities.Users;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UsersDAOJPAImpl implements IUsersDAO {
	//Entity Manager
	@PersistenceContext
	private EntityManager em;

	// Implementations
	@Override
	public boolean addUser(Users user) {
	        em.persist(user);
	        return true;
	}


	@Override
	public Users getUserByUsername(String username) {
	    Users user = null;
		 Query query = em.createQuery("from Users where login = :username");
	        query.setParameter("username", username);

	        // Exécuter la requête et récupérer l'utilisateur correspondant s'il existe
	        List<Users> userList = query.getResultList();
	        if (userList != null && !userList.isEmpty()) {
	            user = userList.get(0);
	        }
		return user;
	}

	@Override
	public Users getUserByUsernameAndPassword(String username, String password) {
	    Users user = null;
	    Query req=em.createQuery("SELECT u from Users u where login = :login and pass = :pass");
	    req.setParameter("login", username);
	    req.setParameter("pass", password);
        List<Users> userList = req.getResultList();
        if (userList != null && !userList.isEmpty()) {
            user = userList.get(0);
        }
        return user;
	}

	@Override
	public boolean updateUser(Users user) {
		em.merge(user);
		return true;
	}

	@Override
	public List<Users> listsUsers() {
		Query req=em.createQuery("SELECT u from Users u");
		return req.getResultList();
	}
}
