package domain;

import java.io.Serializable;

public class Product  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String productName;
	private String category;
	private float value;
	private int quantity;
	
	public Product() {
		
	}
	
	public Product(int id, String productName, String category, float value, int quantity) {
		this.id = id;
		this.productName = productName;
		this.category = category;
		this.value = value;
		this.quantity = quantity;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public float getValue() {
		return value;
	}
	public void setValue(float value) {
		this.value = value;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public void decreaseQuantity(int q) {
		this.quantity -= q;
	}
}
