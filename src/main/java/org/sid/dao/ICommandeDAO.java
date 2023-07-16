package org.sid.dao;

import java.util.List;

import org.sid.entities.commandes;

public interface ICommandeDAO {
	public void addCommande(commandes c);
	public List<commandes> listsCommandes();	
	public commandes getCommande (int codeCmd);
	public void deleteCommande(int codeCmd);
	public void updateCommande(commandes c);
}
