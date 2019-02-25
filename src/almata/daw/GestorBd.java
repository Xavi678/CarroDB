package almata.daw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


public class GestorBd {
	
	private String hostname;
	private String database;
	private String port;
	private String userLogin;
	private String userPasswd;
	private String temps;
	private Connection conn;
	
	public GestorBd(){
		super();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException ex) {
			System.out.println("Error: unable to load driver class!");
		}
		this.temps="?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false";
	}
	
	public GestorBd(String hostname, String database, String port, String user, String passwd) {
		this(hostname,database,user,passwd);
		this.port=port;
	}


	public GestorBd(String hostname, String database, String user, String passwd) {
		this();
		this.hostname = hostname;
		this.database = database;
		this.userLogin = user;
		this.userPasswd = passwd;
		
	}
	

	public String getHostname() {
		return hostname;
	}


	public void setHostname(String hostname) {
		this.hostname = hostname;
	}


	public String getDatabase() {
		return database;
	}


	public void setDatabase(String database) {
		this.database = database;
	}


	public String getPort() {
		return port;
	}


	public void setPort(String port) {
		this.port = port;
	}

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public String getUserPasswd() {
		return userPasswd;
	}

	public void setUserPasswd(String userPasswd) {
		this.userPasswd = userPasswd;
	}
	
	public void crearTaulasSiNoCreada() {
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://"+this.hostname+"/"+this.database+this.temps,this.userLogin,this.userPasswd)){
			
			String sql = "CREATE TABLE IF NOT EXISTS Usuaris (\n" + 
					"    nom VARCHAR(100),\n" + 
					"password VARCHAR(100),\n" +
					"    login VARCHAR(20), "
					+ "PRIMARY KEY(login) )\n";
			
			try(PreparedStatement pstmt = conn.prepareStatement(sql)){
				
				pstmt.executeUpdate();
				
			}catch(SQLException pstmte){
				pstmte.printStackTrace();
			}
		
		}catch(SQLException conne){
			conne.printStackTrace();
		}
	}
	
	public void eliminarTaula() {
		
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://"+this.hostname+"/"+this.database+this.temps,this.userLogin,this.userPasswd)){
			
			String sql = "DROP TABLE IF EXISTS Usuaris";
			
			try(PreparedStatement pstmt = conn.prepareStatement(sql)){
				
				pstmt.executeUpdate();
				
			}catch(SQLException pstmte){
				pstmte.printStackTrace();
			}
		
		}catch(SQLException conne){
			conne.printStackTrace();
		}
	}
	
	public Collection<Usuari> obtenirUsuaris(){
		
		
		ArrayList<Usuari> usuaris = new ArrayList<Usuari>();
		
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://"+this.hostname+"/"+this.database+this.temps,this.userLogin,this.userPasswd)){
			
			String sql = "SELECT * FROM "+database+".Usuaris;";
			try(PreparedStatement usersFound = conn.prepareStatement(sql)){
				
				
				try(ResultSet rs = usersFound.executeQuery()){
					
					while(rs.next()){
						Usuari usuari = new Usuari(rs.getString("login"),rs.getString("nom"));
						usuaris.add(usuari);
					}
					
				}catch(SQLException rse){
					rse.printStackTrace();
				}
			}catch(SQLException stmte){
				stmte.printStackTrace();
			}

		} catch (SQLException conne) {
			conne.printStackTrace();
		}
		return usuaris;
		
	}
	
	
	public void crearUsuaris() {
		int retorn = 0;
		try(Connection conn = DriverManager.getConnection("jdbc:mysql://"+this.hostname+"/"+this.database+this.temps,this.userLogin,this.userPasswd)){

			String sql = "INSERT INTO "+database+".Usuaris VALUES(?,?,?);";
			try(PreparedStatement insertedUser = conn.prepareStatement(sql)){
				
				for(int i = 0;i<10;i++) {
					insertedUser.setString(1,"Nom_"+ i);
					insertedUser.setString(2,"Passwd_"+i);
					insertedUser.setString(3, "Login_"+ i);
					insertedUser.addBatch();
				}
				
				insertedUser.executeBatch();
			
			}catch(SQLException stmte){
				stmte.printStackTrace();
			}

		} catch (SQLException conne) {
			conne.printStackTrace();
		}
		
	}
	
	public Usuari obtenirUser(Usuari user) throws SQLException {
		
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://"+this.hostname+"/"+this.database+this.temps,this.userLogin,this.userPasswd);
		
		String sql="select * from usuaris where login=?";
		
		PreparedStatement selectUser=conn.prepareStatement(sql);
		
		selectUser.setString(1, user.login);
		
		ResultSet rs = selectUser.executeQuery();
		
		Usuari userFound = null;
		
		while(rs.next()) {
			userFound = new Usuari(rs.getString("login"),rs.getString("passwd"));
			

				
		/*
				String sqlInserir="insert into Usuaris Values(?,?)";
				PreparedStatement insertUser=conn.prepareStatement(sqlInserir);
				insertUser.setString(1, user.login);
				insertUser.setString(2, user.password);
				insertUser.executeBatch();
				
				return null;
				
				*/
			
		
		}
		
		return userFound;
		
		
	}

	public void crearUsuari(Usuari usuari) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://"+this.hostname+"/"+this.database+this.temps,this.userLogin,this.userPasswd);
		
		String sqlInserir="insert into usuaris Values(?,?)";
		PreparedStatement insertUser=conn.prepareStatement(sqlInserir);
		insertUser.setString(1, usuari.login);
		insertUser.setString(2, usuari.password);
		insertUser.executeUpdate();
	}

	public ArrayList<Producte> obtenirProductes() throws SQLException {
		
		ArrayList<Producte> productes= new ArrayList<Producte>();
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://"+this.hostname+"/"+this.database+this.temps,this.userLogin,this.userPasswd);
		
		String sql ="Select * from Productes";
		
		PreparedStatement selectP= conn.prepareStatement(sql);
		ResultSet rs=selectP.executeQuery();
		while(rs.next()) {
			
			productes.add(new Producte(rs.getString("nom"),rs.getInt("disponbilitat"),rs.getString("descripcio"),rs.getInt("preu")));
			
		}
		
		return productes;
	}

	public void inserirProducte(Producte producte) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://"+this.hostname+"/"+this.database+this.temps,this.userLogin,this.userPasswd);
		String sqlInserir="insert into productes Values(?,?,?,?,?)";
		PreparedStatement insert=conn.prepareStatement(sqlInserir);
		insert.setString(1, producte.getNom());
		insert.setInt(2, producte.getDisponibilitat());
		insert.setString(3, producte.getDescripcio());
		insert.setInt(4, producte.getPreu());
		insert.setString(5, producte.getPropietari());
	}

	public void crearCarro(Usuari usuari) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:mysql://"+this.hostname+"/"+this.database+this.temps,this.userLogin,this.userPasswd);
		String sql="CREATE TABLE carro_"+usuari.getLogin()+"(\n" + 
				"id int not null primary key auto_increment,\n" + 
				"nom varchar(100) not null,\n" + 
				"disponibilitat int not null,\n" + 
				"descripcio varchar(100) not null,\n" + 
				"propietari varchar(100) not null,\n" + 
				"\n" + 
				"foreign key(propietari) references usuaris(login)\n" + 
				" on update cascade\n" + 
				" on delete cascade)ENGINE=INNODB;";
		
		PreparedStatement prst=conn.prepareStatement(sql);
		prst.executeUpdate();
	}
	
	

}