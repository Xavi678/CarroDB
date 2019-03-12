package almata.daw;

public class Producte {
	
	private int id;
	private String nom;
	private int disponibilitat;
	private String descripcio;
	private int preu;
	private String propietari;
	private String data;

	
	public Producte() {
		
	}
	
	
	
	public Producte(int id, String nom, int disponibilitat, String descripcio, int preu, String propietari,
			String data) {
		super();
		this.id = id;
		this.nom = nom;
		this.disponibilitat = disponibilitat;
		this.descripcio = descripcio;
		this.preu = preu;
		this.propietari = propietari;
		this.data = data;
	}



	public String getData() {
		return data;
	}



	public void setData(String data) {
		this.data = data;
	}



	public Producte(String nom, int disponibilitat, String descripcio, int preu) {
		super();
		
		this.nom = nom;
		this.disponibilitat = disponibilitat;
		this.descripcio = descripcio;
		this.preu = preu;
	}
	
	
	
	
	public Producte( String nom, int disponibilitat, String descripcio, int preu, String propietari) {
		super();
		
		this.nom = nom;
		this.disponibilitat = disponibilitat;
		this.descripcio = descripcio;
		this.preu = preu;
		this.setPropietari(propietari);
	}
	
	public Producte(int id, String nom, int disponibilitat, String descripcio, int preu, String propietari) {
		super();
		this.id=id;
		this.nom = nom;
		this.disponibilitat = disponibilitat;
		this.descripcio = descripcio;
		this.preu = preu;
		this.setPropietari(propietari);
	}


	
	
	
	



	public Producte(int id, String nom, int disponibilitat, String descripcio, int preu) {
		super();
		this.id = id;
		this.nom = nom;
		this.disponibilitat = disponibilitat;
		this.descripcio = descripcio;
		this.preu = preu;
	}



	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getDisponibilitat() {
		return disponibilitat;
	}
	public void setDisponibilitat(int disponibilitat) {
		this.disponibilitat = disponibilitat;
	}
	public String getDescripcio() {
		return descripcio;
	}
	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}
	public int getPreu() {
		return preu;
	}
	public void setPreu(int preu) {
		this.preu = preu;
	}


	public String getPropietari() {
		return propietari;
	}


	public void setPropietari(String propietari) {
		this.propietari = propietari;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}



	
	
	

}
