package almata.daw;

import java.sql.SQLException;

public class Registrar extends DBAction {
	
	private Usuari usuari;
	
	
	
	public Usuari getUsuari() {
		return usuari;
	}



	public void setUsuari(Usuari usuari) {
		this.usuari = usuari;
	}



	public String registrar() throws SQLException {
		
		if(db==null) {
			this.loadDB();
		}
		
		if(usuari.getPassword().equals(usuari.getPassword2())) {
		
		
		db.crearUsuari(usuari);
		addActionMessage(getText("password.success"));
		return SUCCESS;
		
		}else {
			addActionError(getText("password.error"));
			return INPUT;
		}
		
	}

}
