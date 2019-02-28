package almata.daw;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;



public class CarroAction extends DBAction implements SessionAware{
	
	private ArrayList<Producte> productes= new ArrayList<Producte>();
	private Map<Integer, Boolean> checkboxes;
	private Map<String, Object> session;
	private ArrayList<Producte> carro;

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Collection<Producte> getProductes() {
		return productes;
	}

	public void setProductes(Collection<Producte> productes) {
		this.productes = (ArrayList<Producte>) productes;
	}

	public Map<Integer, Boolean> getCheckboxes() {
		return checkboxes;
	}

	public void setCheckboxes(Map<Integer, Boolean> checkboxes) {
		this.checkboxes = checkboxes;
	}
	

	
	

	public ArrayList<Producte> getCarro() {
		return carro;
	}

	public void setCarro(ArrayList<Producte> carro) {
		this.carro = carro;
	}

	public String afegir() throws SQLException {
		if(db==null) {
			this.loadDB();
		}
		
		try {
			productes=db.obtenirProductes();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setCheckboxes(checkboxes);
		
		printCheckBoxes();
		return SUCCESS;
	}
	
	public String llistar() throws SQLException {
		if(db==null) {
			this.loadDB();
		}
		
		Usuari user=(Usuari) session.get("loginId");
		
		carro=db.obtenirCarroperUsuari(user);
		
		
		
		return SUCCESS;
		
	}
	
	public String buy() throws SQLException {
		
		if(db==null) {
			this.loadDB();
		}
		
		Usuari user=(Usuari) session.get("loginId");
		
		db.Comprar(user);
		
		return SUCCESS;
		
	}
private void printCheckBoxes() throws SQLException {
		
		if(checkboxes!=null){
		Iterator<Map.Entry<Integer, Boolean>> entries = checkboxes.entrySet().iterator();
		while (entries.hasNext()) {
		    Map.Entry<Integer, Boolean> entry = entries.next();
		    System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
		    if(entry.getValue()==true) {
		    	int pos=entry.getKey();
		    	Producte p=db.obtenirProductealCarro(productes.get(pos));
		    	if(p!=null) {
		    		db.actualitzar(p);
		    		
		    	}else {
		    		db.insertCarro(productes.get(pos));
		    	}
		    }
		}
		}
	}

}
