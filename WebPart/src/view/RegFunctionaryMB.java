package view;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import bussiness.RegisterFunctionaryRemote;
import domain.Functionary;
import domain.Product;

@Named(value = "regFunctionaryMB")
@RequestScoped
public class RegFunctionaryMB {
	private String nameFunc;
	private String emailFunc;
	private String loginFunc;
	private String passFunc;
	
	
	@EJB
	private RegisterFunctionaryRemote ejb;
	
	public String regFunc() {
		ejb.RegisterFunc(nameFunc, emailFunc, loginFunc, passFunc);
		return "principal";
	}
	
	public LinkedList<Functionary> getFunctionaryList(){
		return ejb.ListOfFuncs();
	}
	
	
	public String deleteFunctionary(String login) {
		if(ejb.deleteByLogin(login)) {
			return "FunctionaryList";
		}
		return "";
	}
	
	public String editFunctionary(String login) {
		
		Map<String,Object> sessionMapObj = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
		
		Functionary functionaryEdit = ejb.getFuncByLogin(login);
		
		sessionMapObj.put("functionary", functionaryEdit);	
		
		return "editFunctionary";
	}
	
	public String updateFunctionary(String login, Functionary f) {
		ejb.updateByLogin(login, f);
		return "FunctionaryList";
	}
	
	public String getLoginFunc() {
		return loginFunc == null ? "" : loginFunc;
	}
	public void setLoginFunc(String loginFunc) {
		this.loginFunc = loginFunc;
	}
	public String getPassFunc() {
		return passFunc == null ? "" : passFunc;
	}
	public void setPassFunc(String passFunc) {
		this.passFunc = passFunc;
	}
	public String getemailFunc() {
		return emailFunc == null ? "" : emailFunc;
	}
	public void setemailFunc(String emailFunc) {
		this.emailFunc = emailFunc;
	}

	public String getNameFunc() {
		return nameFunc;
	}

	public void setNameFunc(String nameFunc) {
		this.nameFunc = nameFunc;
	}
	
	
}