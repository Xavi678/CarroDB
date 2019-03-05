package almata.daw;

public class Usuari {

	protected String login;
	protected String password;
	protected String password2;
	
	
	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	public Usuari() {}
	
	public Usuari(String login, String password,String password2) {
		super();
		this.login = login;
		this.password = password;
		this.password2 = password2;
	}
	
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
