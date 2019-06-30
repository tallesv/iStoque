package bussiness;

import java.util.ArrayList;
import java.util.LinkedList;

import domain.Functionary;
import domain.Product;

public interface RegisterFunctionaryRemote {
	public LinkedList<Functionary> ListOfFuncs();

	public Functionary GetFuncByID(int id);
	public Functionary getFuncByLogin(String login);
	public void RegisterBoss(String login, String password);
	public void RegisterFunc(String name, String email, String login, String password);
	public boolean deleteByLogin(String login);
	public void updateByLogin(String login, Functionary f);
	
}
