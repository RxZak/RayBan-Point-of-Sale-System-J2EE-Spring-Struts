package org.sid.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Articles_Prix implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codePdt;
	public Articles_Prix() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Articles_Prix(int codePdt, String nomPdt, String descPdt, double prixPdt) {
		super();
		this.codePdt = codePdt;
		this.nomPdt = nomPdt;
		this.descPdt = descPdt;
		this.prixPdt = prixPdt;
	}

	public int getCodePdt() {
		return codePdt;
	}
	public void setCodePdt(int codePdt) {
		this.codePdt = codePdt;
	}
	public String getNomPdt() {
		return nomPdt;
	}
	public void setNomPdt(String nomPdt) {
		this.nomPdt = nomPdt;
	}
	public String getDescPdt() {
		return descPdt;
	}
	public void setDescPdt(String descPdt) {
		this.descPdt = descPdt;
	}
	public double getPrixPdt() {
		return prixPdt;
	}
	public void setPrixPdt(double prixPdt) {
		this.prixPdt = prixPdt;
	}
	private String nomPdt;
	private String descPdt;
	private double prixPdt;
	

}
