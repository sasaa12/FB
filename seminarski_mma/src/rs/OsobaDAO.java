package rs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.util.ArrayList;
public class OsobaDAO {
      private DataSource ds;

// DEFINICIJA KONEKCIONIH STRINGOVA
	private static String INSERTOSOBA = "INSERT INTO osoba (korisnickoIme,email,sifra) VALUES (?,?,?)";
	private static String EXISTOSOBA = "SELECT * FROM osoba where korisnickoIme=? and sifra=?";
	private static String OSOBAEXIST = "SELECT * FROM osoba where korisnickoIme=? ";
	
	// DEFINICIJA KONSTRUKTORA ZA PODESAVNJE KONEKCIJE – UVEK ISTO
	public OsobaDAO(){
	try {
		InitialContext cxt = new InitialContext();
		if ( cxt == null ) { 
		} 
		ds = (DataSource) cxt.lookup( "java:/comp/env/jdbc/mysql" ); 
		if ( ds == null ) { 
		} 		
		} catch (NamingException e) {
		}
	}
	// DEFINICIJA METODE 
	public void insertOsoba(Osoba osoba){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		
		
				
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(INSERTOSOBA);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setString(1,osoba.getKorisnickoIme());
			pstm.setString(2,osoba.getEmail());
			pstm.setString(3,osoba.getSifra());
			pstm.execute();

//****POCETAK	AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			
//****KRAJ		KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean existOsoba(String korisnickoIme, String sifra){
			Connection con = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
			// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		
			Osoba osoba = null;
					
	            try {
				con = ds.getConnection();
				pstm = con.prepareStatement(EXISTOSOBA);

				// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
				pstm.setString(1, korisnickoIme);
				pstm.setString(2, sifra);
				pstm.execute();

	//****POCETAK	AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
				rs = pstm.getResultSet();

				if(rs.next()){ // if AKO UPIT VRACA JEDAN REZULTAT
					osoba = new Osoba();

					osoba.setKorisnickoIme(rs.getString("korisnickoIme"));
					osoba.setEmail(rs.getString("email"));
					osoba.setSifra(rs.getString("sifra"));
					
					
					return true;
				}
	//****KRAJ		KRAJ OBRADE ResultSet-a	
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false; 
		}
	
	public boolean getKorisnickoIme(String korisnickoIme){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
	
		Osoba osoba = null;
				
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(OSOBAEXIST);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setString(1, korisnickoIme);
			
			pstm.execute();

//****POCETAK	AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			if(rs.next()){ // if AKO UPIT VRACA JEDAN REZULTAT
				osoba = new Osoba();

				osoba.setKorisnickoIme(rs.getString("korisnickoIme"));
				osoba.setEmail(rs.getString("email"));
				osoba.setSifra(rs.getString("sifra"));
				
				
				return true;
			}
//****KRAJ		KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; 
	}
	// DEFINICIJA OSTALIH METODA ... 
	
	}


