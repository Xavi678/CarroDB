package almata.daw;

public class Usuari {

	protected String login;
	protected String password;
	
	
	public Usuari() {}
	
	public Usuari(String login, String password) {
		super();
		this.login = login;
		this.password = password;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean validat(Usuari usuari) {
		return (usuari!=null && login.equals(usuari.login) && password.equals(usuari.password));
	}
	
	
}
