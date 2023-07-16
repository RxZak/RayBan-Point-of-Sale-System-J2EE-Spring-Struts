package org.sid.entities;

import java.io.Serializable;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Cart")
public class Cart implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdCart;
	private String login;
	private int codePdt;
	private int qteCart;
	private int prixCart;
	private double total;
	private String adresse;
	private BigInteger mobileNumber;
	private String orderDate;
	private String deliveryDate;
	private String statut;
	private String payementMethod;
	public Cart() {
		super();
	}
	public Cart(int idCart, String login, int codePdt, int qteCart, int prixCart, double total, String adresse,
			BigInteger mobileNumber, String orderDate, String deliveryDate, String statut, String payementMethod) {
		super();
		IdCart = idCart;
		this.login = login;
		this.codePdt = codePdt;
		this.qteCart = qteCart;
		this.prixCart = prixCart;
		this.total = total;
		this.adresse = adresse;
		this.mobileNumber = mobileNumber;
		this.orderDate = orderDate;
		this.deliveryDate = deliveryDate;
		this.statut = statut;
		this.payementMethod = payementMethod;
	}
	public int getIdCart() {
		return IdCart;
	}
	public void setIdCart(int idCart) {
		IdCart = idCart;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public int getCodePdt() {
		return codePdt;
	}
	public void setCodePdt(int codePdt) {
		this.codePdt = codePdt;
	}
	public int getQteCart() {
		return qteCart;
	}
	public void setQteCart(int qteCart) {
		this.qteCart = qteCart;
	}
	public int getPrixCart() {
		return prixCart;
	}
	public void setPrixCart(double d) {
		this.prixCart = (int) d;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public BigInteger getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(BigInteger mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public String getPayementMethod() {
		return payementMethod;
	}
	public void setPayementMethod(String payementMethod) {
		this.payementMethod = payementMethod;
	}
	
	
	
}
