package bussiness;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.ejb.Remote;

import domain.Product;

@Remote
public interface RegisterProductRemote {
	public ArrayList<Product> ListOfProd();
	 
	public void RegisterProduct(String name, String category,
			float value, int quantity);
	
	public Product findById(int id);
	public boolean deleteById(int id);
	public void updateById(int id, Product p);
	public void decreaseQuantity(int id,int q);
}
