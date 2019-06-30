package bussiness;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.ejb.Remote;

import domain.Product;
import domain.Sell;

@Remote
public interface RegisterSellRemote {

	public ArrayList<Sell> listOfSell();
	 
	public void registerSell(int id, Product produtos, int quantity, float totalValue);
	
	public Sell findById(int id);
}
