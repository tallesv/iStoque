package dao;

import java.util.LinkedList;
import java.util.List;

import domain.Functionary;

public class FunctionaryDAO {
	private static final List<Functionary> ListOfFuncs = new LinkedList<Functionary>();
	
	public static void AddFunc(Functionary NewFunc) {
		ListOfFuncs.add(NewFunc);
		NewFunc.setIdFunc(ListOfFuncs.size());
	}
	
	public static void EditFunc() {
		// to create...
	}
	
	public static void RemoveFunc(int id) {
		Functionary ToRemoveFunc = getFuncByID(id);
		ListOfFuncs.remove(ToRemoveFunc);
	}
	
	public static final Functionary getFuncByID(int ID) {
		for(Functionary func : ListOfFuncs) {
			if(func.getIdFunc() == ID) {
				return func;
			}
		}
		return null;
	}
	
	public static final Functionary getFuncByLogin(String login) {
		for(Functionary func : ListOfFuncs) {
			if(func.getLogin() == login) {
				return func;
			}
		}
		return null;
	}

	public static LinkedList<Functionary> ReturnList() {
		return (LinkedList<Functionary>) ListOfFuncs;
	}
}
