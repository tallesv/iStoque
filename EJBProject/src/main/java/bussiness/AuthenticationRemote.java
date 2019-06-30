package bussiness;

import javax.ejb.Remote;

@Remote
public interface AuthenticationRemote {
	public boolean AuthLogin(String login, String password);
}