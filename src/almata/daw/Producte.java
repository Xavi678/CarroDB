package almata.daw;

public class Producte {
	
	private int id;
	private String nom;
	private int disponibilitat;
	private String descripcio;
	private int preu;
	private String propietari;
	
	
	public Producte() {
		
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
