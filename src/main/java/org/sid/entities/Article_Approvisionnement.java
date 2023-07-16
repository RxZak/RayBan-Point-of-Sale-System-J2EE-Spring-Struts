package org.sid.entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Article_Approvisionnement {
	@Id
	private int codePdt;
	private int qteCommande;
	private Date datePrevueLivraison;
	public Article_Approvisionnement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Article_Approvisionnement(int codePdt, int qteCommande, Date datePrevueLivraison) {
		super();
		this.codePdt = codePdt;
		this.qteCommande = qteCommande;
		this.datePrevueLivraison = datePrevueLivraison;
	}
	public int getCodePdt() {
		return codePdt;
	}
	public void setCodePdt(int codePdt) {
		this.codePdt = codePdt;
	}
	public int getQteCommande() {
		return qteCommande;
	}
	public void setQteCommande(int qteCommande) {
		this.qteCommande = qteCommande;
	}
	public Date getDatePrevueLivraison() {
		return datePrevueLivraison;
	}
	public void setDatePrevueLivraison(Date datePrevueLivraison) {
		this.datePrevueLivraison = datePrevueLivraison;
	}
	

}
