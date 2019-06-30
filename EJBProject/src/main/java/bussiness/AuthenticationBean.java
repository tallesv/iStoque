package bussiness;

import javax.ejb.Stateless;

@Stateless
public class AuthenticationBean implements AuthenticationRemote {
	@Override
	public boolean AuthLogin(String login, String password) {
		if(login.equals("login") && password.equals("pass")) {
			return true;
		}
		else {
			return false;
		}			
	}
	
	
}