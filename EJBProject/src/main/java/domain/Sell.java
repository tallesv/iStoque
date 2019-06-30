package domain;

import java.io.Serializable;
import java.util.LinkedList;

public class Sell implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private Product p;
	private int quantity;
	private float totalValue;
	
	public Product getP() {
		return p;
	}
	public void setP(Product p) {
		this.p = p;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Sell(int id, Product produtos, int quantity, float totalValue) {

		this.id = id;
		this.p= produtos;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Product getProdutos() {
		return p;
	}
	public void setProdutos(Product produtos) {
		this.p = produtos;
	}
	
	public String getProductName() {
		return p.getProductName();
	}
	
	public String getProductCategory() {
		return p.getCategory();
	}
	
	public int getProductQuantity() {
		return p.getQuantity();
	}
	
	public float getProductValue() {
		return p.getValue();
	}
	
	public int getProductId() {
		return p.getId();
	}
	
	public float sellValue() {
		float totalValue = getProductQuantity()*getProductValue();
		return totalValue;
	}
	
	
}
