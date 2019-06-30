package view;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import bussiness.RegisterProductRemote;
import domain.Product;

@Named(value = "regProductMB")
@RequestScoped
public class RegProductMB {
	
	private String pName;
	private String pCategory;
	private int pQuantity;
	private float pValue;
	
	@EJB
	private RegisterProductRemote ejb;
	
	
	public String regProd() {
		ejb.RegisterProduct(pName, pCategory, pValue, pQuantity);
		return "principal";
	}
	
	public String editProduct(int id) {
		
		Map<String,Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		
		Product productEdit = ejb.findById(id);
		
		sessionMapObj.put("product", productEdit);	
		
		return "editProduct";
	}
	
	public String updateProduct(int id, Product p) {
		ejb.updateById(id, p);
		return "ProductList";
		
	}
	
	public String deleteProduct(int id) {
		if(ejb.deleteById(id)) {
			return "ProductList";
		}
		return "";
	}
	
	public ArrayList<Product> getProductList() {
		return ejb.ListOfProd();
	}
	
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpCategory() {
		return pCategory;
	}
	public void setpCategory(String pCategory) {
		this.pCategory = pCategory;
	}
	public int getpQuantity() {
		return pQuantity;
	}
	public void setpQuantity(int pQuantity) {
		this.pQuantity = pQuantity;
	}
	public float getpValue() {
		return pValue;
	}
	public void setpValue(float pValue) {
		this.pValue = pValue;
	}
}