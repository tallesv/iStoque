package bussiness;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.ejb.Stateless;

import dao.SellDAO;
import domain.Product;
import domain.Sell;

@Stateless
public class RegisterSellBean implements RegisterSellRemote {

	@Override
	public ArrayList<Sell> listOfSell() {
		
		return SellDAO.returnList();
	}

	@Override
	public void registerSell(int id, Product produtos, int quantity, float totalValue) {
		SellDAO.addSell(new Sell(id, produtos, quantity, totalValue));		
	}

	@Override
	public Sell findById(int id) {
		if(SellDAO.getSellById(id) != null) {
			return SellDAO.getSellById(id);
		}
		return null;
	}

}
