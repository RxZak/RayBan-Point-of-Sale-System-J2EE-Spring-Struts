package org.sid.service;

import java.util.List;

import org.sid.entities.Users;
import org.sid.entities.commandes;
import org.sid.entities.Article_Approvisionnement;
import org.sid.entities.Articles_Prix;
import org.sid.entities.Articles_Stock;
import org.springframework.transaction.annotation.Transactional;
@Transactional
public interface ICatalogueService {
	public List<Articles_Stock> listsProduits();
	public List<Articles_Prix> listsProduitsP();
	public Articles_Stock getProduits (int codePdt);
}
