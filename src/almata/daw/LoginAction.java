package almata.daw;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction  extends DBAction implements SessionAware {
	


	public Usuari usuari;
	
	private SessionMap<String, Object> session;
	
	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = (SessionMap<String, Object>) session;
	}
	public Usuari getUsuari() {
		return usuari;
	}

	public void setUsuari(Usuari usuari) {
		this.usuari = usuari;
	}
	
	public String Login() throws SQLException {
		
		if(db==null) {
			this.loadDB();
		}
		
		Usuari user=db.obtenirUser(this.usuari);
		
		if(user==null) {
			db.crearUsuari(this.usuari);
			return SUCCESS;
		}else if(user!=null && user.validat(usuari)){
			
			session.put("loginId", this.usuari);
			return SUCCESS;
		}else {
			return LOGIN;
		}
		
		
	}
	
	public String logOut() {
		
		session.invalidate();
		
		
		return SUCCESS;
	}

}
