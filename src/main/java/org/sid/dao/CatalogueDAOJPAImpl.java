package org.sid.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.sid.entities.Users;
import org.sid.entities.commandes;
import org.sid.entities.Article_Approvisionnement;
import org.sid.entities.Articles_Prix;
import org.sid.entities.Articles_Stock;
import org.sid.entities.Users;

public class CatalogueDAOJPAImpl  implements ICatalogueDAO{
	// Entity Manager
	@PersistenceContext
	private EntityManager em;
	
	// Implementations
	@Override
	public List<Articles_Stock> listsProduits() {
		Query req=em.createQuery("SELECT p from Articles_Stock p where p.qtePdt>0");
		return req.getResultList();
	}

	@Override
	public List<Articles_Prix> listsProduitsP() {
		Query req=em.createQuery("SELECT p from Articles_Prix p");
		return req.getResultList();
	}

	@Override
	public Articles_Stock getProduits(int codePdt) {
        return em.find(Articles_Stock.class, codePdt);
	}

}
