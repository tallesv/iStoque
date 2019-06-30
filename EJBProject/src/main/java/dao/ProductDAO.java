package dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import domain.Product;

public class ProductDAO {
	private static final ArrayList<Product> ListOfProducts = new ArrayList<Product>();
	//private static final ArrayList<Product> ListOfProducts = (ArrayList<Product>) Collections.unmodifiableList(
		//	new ArrayList<Product>() {{
		//		add(new Product(1,"tenis nike", "tenis", 1, 250));
		//	}});
			
	

	
	public static final Product GetProductById(int ID) {
		for(Product toFind : ListOfProducts) {
			if(toFind.getId() == ID) {
				return toFind;
			}
		}
		return null;
	}
	
	public static final Product GetProductByName(String name) {
		for(Product toFind : ListOfProducts) {
			if(toFind.getProductName().contains(name)) {
				return toFind;
			}
		}
		return null;
	}
	
	public static Product AddProduct(Product newProd) {
		ListOfProducts.add(newProd);
		newProd.setId(ListOfProducts.size());
		return newProd;
	}
	
	public static boolean RemoveProduct(int ID) {
		Product toRemove = GetProductById(ID);
		return ListOfProducts.remove(toRemove);
	}

	public static ArrayList<Product> ReturnList() {
		return ListOfProducts;
	}
	
}
