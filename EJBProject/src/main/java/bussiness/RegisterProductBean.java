package bussiness;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.ejb.Stateless;

import dao.ProductDAO;
import domain.Product;

@Stateless
public class RegisterProductBean implements RegisterProductRemote{

	@Override
	public void RegisterProduct(String name, String category, float value, int quantity) {
		Product newProd = new Product();
		newProd.setId(ListOfProd().size() + 1);
		newProd.setProductName(name);
		newProd.setCategory(category);
		newProd.setQuantity(quantity);
		newProd.setValue(value);
		ProductDAO.AddProduct(newProd);
	}

	@Override
	public ArrayList<Product> ListOfProd() {
		return (ArrayList<Product>)ProductDAO.ReturnList();
	}

	@Override
	public Product findById(int id) {
		Product found;
		found = ProductDAO.GetProductById(id);
		if(found != null) {
			return found;
		}
		return null;
	}
	
	@Override
	public boolean deleteById(int id) {
		return ProductDAO.RemoveProduct(id);
		
	}

	@Override
	public void updateById(int id, Product p) {
		if(ProductDAO.GetProductById(id) != null) {
			Product pUpdated = ProductDAO.GetProductById(id);
			pUpdated.setId(p.getId());
			pUpdated.setProductName(p.getProductName());
			pUpdated.setCategory(p.getCategory());
			pUpdated.setQuantity(p.getQuantity());
			pUpdated.setValue(p.getValue());
			ProductDAO.RemoveProduct(id);
			ProductDAO.AddProduct(pUpdated);
		}
	}

	@Override
	public void decreaseQuantity(int id,int q) {
		if(ProductDAO.GetProductById(id) != null) {
			ProductDAO.GetProductById(id).decreaseQuantity(q);
		}
		
	}
}
