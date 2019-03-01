package almata.daw;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class LlistarAction  extends DBAction implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Collection<Usuari> usuaris;
	
	private Usuari user;
	
	private String inici;
	
	private String fi;
	
	private Collection<Producte> productes;
	
	private int minim;
	private int maxim;
	
	private String minDate;
	private String maxDate;
	

	
	

	public Collection<Producte> getProductes() {
		return productes;
	}

	public void setProductes(Collection<Producte> productes) {
		this.productes = productes;
	}

	public String getFi() {
		return fi;
	}

	public void setFi(String fi) {
		this.fi = fi;
	}

	public String getInici() {
		return inici;
	}

	public void setInici(String inici) {
		this.inici = inici;
	}

	public Usuari getUser() {
		return user;
	}

	public void setUser(Usuari user) {
		this.user = user;
	}

	private SessionMap<String, Object> session;
	
	

	public SessionMap<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = (SessionMap<String, Object>) session;
	}
	
	public Collection<Usuari> getUsuaris() {
		return usuaris;
	}

	public void setUsuaris(Collection<Usuari> usuaris) {
		this.usuaris = usuaris;
	}
	
	public String llistarProductes() throws SQLException {

		// Aquí hem d'agafar de session la llista d'usuaris
		// En cas que no existeixi el crearem i el posarem 
		// en l'àmbit session.
		// si existeix ho passarem a una Collection
		
		/*inici =(String) session.get("dataInici");
		user = (Usuari) session.get("loginId");
		
		Hashtable<String,Usuari> users = (Hashtable<String,Usuari>)application.get("usuaris");
		
			numero =users.size();*/
		
		
		/*Hashtable<String,Usuari> llistaUsuaris = (Hashtable<String,Usuari>)application.get("llistatUsuaris");
		
		if(llistaUsuaris==null) {
			
			
			llistaUsuaris= new Hashtable<String,Usuari>();
			application.put("llistatUsuaris", llistaUsuaris);
			
		}*/
		
		/*Usuari userLogin = (Usuari) session.get("loginId");
		Enumeration<Usuari> user =llistaUsuaris.elements();
		while(user.hasMoreElements()) {
			if(user.nextElement().getLogin().equals(userLogin.getLogin())==true) {
				user.nextElement().setData("actiu");
			}
			
		}*/
		
		//Usuari userLogin = (Usuari) session.get("loginId");
		
		//Usuari user=llistaUsuaris.get(userLogin.getLogin());
		if(db==null) {
			this.loadDB();
		}
		
		if(maxim==0 && minim==0 && maxDate==null && minDate==null) {
		try {
			productes=db.obtenirProductes();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else if(maxim!=0) {
			productes=db.obtenirProductesFiltrats(maxim,minim);
		}else if(minDate!=null && maxDate!=null){
			
			
			
			minDate=minDate.replace("/", " ");
			maxDate=maxDate.replace("/", " ");
			productes=db.obtenirProductesPerData(minDate,maxDate);
			
		}
		
		
		
		
		
		return SUCCESS;
	}
	
	

	public int getMaxim() {
		return maxim;
	}

	public void setMaxim(int maxim) {
		this.maxim = maxim;
	}

	public int getMinim() {
		return minim;
	}

	public void setMinim(int minim) {
		this.minim = minim;
	}

	public String getMaxDate() {
		return maxDate;
	}

	public void setMaxDate(String maxDate) {
		this.maxDate = maxDate;
	}

	public String getMinDate() {
		return minDate;
	}

	public void setMinDate(String minDate) {
		this.minDate = minDate;
	}

	
	
	
	

}
