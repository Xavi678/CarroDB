package almata.daw;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class PerfilAction extends DBAction implements SessionAware {
	
	private SessionMap<String, Object> session;
	
	private Usuari usuari;
	

	
	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = (SessionMap<String, Object>) session;
	}
	
	public String perfil() {
		
		usuari=(Usuari) session.get("loginId");
		
		return SUCCESS;
	}
	
	
	public String canviar() throws SQLException {
		
		if(db==null) {
			this.loadDB();
		}
		
		Usuari user=(Usuari) session.get("loginId");
		
		user.setPassword(usuari.getPassword());
		
		session.put("loginId", user);
		
		db.canviar(usuari.getPassword(),user.getLogin());
		
		return SUCCESS;
	}

	public Usuari getUsuari() {
		return usuari;
	}

	public void setUsuari(Usuari usuari) {
		this.usuari = usuari;
	}

}
