package dao;

import java.util.ArrayList;

import domain.Product;
import domain.Sell;

public class SellDAO {


	private static final ArrayList<Sell> listOfSells = new ArrayList<Sell>();
	
	public static final Sell getSellById(int ID) {
		for(Sell toFind : listOfSells) {
			if(toFind.getId() == ID) {
				return toFind;
			}
		}
		return null;
	}
	
	
	public static Sell addSell(Sell newSell) {
		listOfSells.add(newSell);
		newSell.setId(listOfSells.size());
		return newSell;
	}
	
	public static boolean removeSell(int ID) {
		Sell toRemove = getSellById(ID);
		return listOfSells.remove(toRemove);
	}

	public static ArrayList<Sell> returnList() {
		return listOfSells;
	}

	
}
