package bussiness;

import java.util.ArrayList;
import java.util.LinkedList;

import javax.ejb.Stateless;

import dao.FunctionaryDAO;
import dao.ProductDAO;
import domain.Administrator;
import domain.Functionary;
import domain.Product;

@Stateless
public class RegisterFunctionaryBean implements RegisterFunctionaryRemote {

	@Override
	public LinkedList<Functionary> ListOfFuncs() {
		return (LinkedList<Functionary>)FunctionaryDAO.ReturnList();
	}

	@Override
	public void RegisterBoss(String login, String password) {
		Administrator boss = new Administrator();
		boss.setIdFunc(ListOfFuncs().size() + 1);
		boss.setLogin(login);
		boss.setPassword(password);
		FunctionaryDAO.AddFunc(boss);
	}

	@Override
	public void RegisterFunc(String name, String email, String login, String password) {
		Functionary func = new Functionary();
		func.setIdFunc(ListOfFuncs().size() + 1);
		func.setName(name);
		func.setLogin(login);
		func.setEmail(email);
		func.setPassword(password);
		FunctionaryDAO.AddFunc(func);
	}

	
	@Override
	public Functionary GetFuncByID(int id) {
		for(Functionary f : ListOfFuncs()) {
			if(f.getIdFunc() == id) {
				return f;
			}
		}
		return null;
	}


	@Override
	public boolean deleteByLogin(String login) {
		Functionary toRemove = getFuncByLogin(login);
		ListOfFuncs().remove(toRemove);
		return true;
	}

	@Override
	public Functionary getFuncByLogin(String login) {
		for(Functionary func : ListOfFuncs()) {
			if(func.getLogin().equals(login)) {
				return func;
			}
		}
		return null;
	}
	
	@Override
	public void updateByLogin(String login, Functionary f) {
		Functionary fUpdated = getFuncByLogin(login);
		fUpdated.setIdFunc(f.getIdFunc());
		fUpdated.setName(f.getName());
		fUpdated.setLogin(f.getLogin());
		fUpdated.setEmail(f.getEmail());
		fUpdated.setPassword(f.getPassword());
		deleteByLogin(login);
		FunctionaryDAO.AddFunc(fUpdated);
		
	}
}