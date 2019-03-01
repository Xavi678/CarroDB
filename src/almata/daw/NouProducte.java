package almata.daw;

import java.sql.SQLException;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

public class NouProducte extends DBAction implements SessionAware {
	
	private Producte producte;
	
private SessionMap<String, Object> session;
	
	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = (SessionMap<String, Object>) session;
	}
	
	

	public Producte getProducte() {
		return producte;
	}

	public void setProducte(Producte producte) {
		this.producte = producte;
	}
	
	public String nouProduct() throws SQLException {
		
		if(db==null) {
			this.loadDB();
		}
		
		
		Usuari propietari=(Usuari) session.get("loginId");
		
		this.producte.setPropietari(propietari.getLogin());
		
		db.inserirProducte(this.producte);
		
		
		
		
		
		return SUCCESS;
		
	}

}
