package almata.daw;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;

public class nouProducte extends DBAction {
	
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
	
	public String nouProducte() {
		
		Usuari propietari=(Usuari) session.get("loginId");
		
		this.producte.setPropietari(propietari);
		
		db.inserirProducte(this.producte);
		
		
		
		
		
		return SUCCESS;
		
	}

}
