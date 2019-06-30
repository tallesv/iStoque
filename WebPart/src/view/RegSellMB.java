package view;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import bussiness.RegisterProductRemote;
import bussiness.RegisterSellRemote;
import domain.Product;
import domain.Sell;

@Named(value = "regSellMB")
@RequestScoped
public class RegSellMB {

	private int sId;
	private Product sProduto;
	private int quantity;
	private float totalValue;
	
	@EJB
	private RegisterSellRemote ejb;
	
	@EJB 
	private RegisterProductRemote ejbP;
	
	public String regSell() {
		ejb.registerSell(sId, sProduto,quantity,totalValue);
		return "principal";
	}
	
	public ArrayList<Sell> getSellList() {
		return ejb.listOfSell();
	}
	
	public float getTotalValue() {
		ArrayList<Sell>SellList = getSellList();
		float totalValue = 0;
		for(Sell s : SellList) {
			totalValue+= (s.getQuantity())*(s.getProductValue());
			System.out.println(totalValue);
		}
		return totalValue;
	}
	
	public String addProduct(int id, int quantity) {
		if(ejbP.findById(id).getQuantity() < quantity) {
			
		}
		else {
			
		}
		return "sellProduct";	
	}

	public String sellProduct(int id) {
		if(ejbP.findById(id).getQuantity() >= quantity) {
			//sId = 1;
			sProduto = ejbP.findById(id);
			sProduto.setQuantity(quantity);
			ejbP.decreaseQuantity(id,quantity);
			regSell();
			setTotalValue(getTotalValue());
			return "sellProduct";
		}
		return "";
	}
	
	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public Product getsProdutos() {
		return sProduto;
	}

	public void setsProdutos(Product sProdutos) {
		this.sProduto = sProdutos;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setTotalValue(float totalValue) {
		this.totalValue = totalValue;
	}

	
	
	
}
