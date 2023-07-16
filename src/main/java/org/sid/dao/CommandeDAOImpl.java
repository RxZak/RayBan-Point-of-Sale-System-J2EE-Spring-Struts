package org.sid.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.sid.entities.commandes;

public class CommandeDAOImpl implements ICommandeDAO{
	// Entity Manager
	@PersistenceContext
	private EntityManager em;
	
	// Implementations
	@Override
	public void addCommande(commandes c) {
		em.persist(c);
	}

	@Override
	public List<commandes> listsCommandes() {
		Query req=em.createQuery("SELECT c from commandes c");
		return req.getResultList();
	}

	@Override
	public commandes getCommande(int codeCmd) {
		return em.find(commandes.class, codeCmd);
	}

	@Override
	public void deleteCommande(int codeCmd) {
		commandes c=getCommande(codeCmd);
		em.remove(c);
	}

	@Override
	public void updateCommande(commandes c) {
		em.merge(c);
	}
	
}
