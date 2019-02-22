package almata.daw;

public class Producte {
	
	private String id;
	private String nom;
	private int disponibilitat;
	private String descripcio;
	private int preu;
	private Usuari propietari;
	
	
	public Usuari getPropietari() {
		return propietari;
	}
	public void setPropietari(Usuari propietari) {
		this.propietari = propietari;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	
	
	

}
