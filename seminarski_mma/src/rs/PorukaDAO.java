package rs;

//vazni importi 
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.util.ArrayList;
public class PorukaDAO {
   private DataSource ds;

//DEFINICIJA KONEKCIONIH STRINGOVA
	
	private static String INSERTPORUKA = "INSERT INTO poruka (ime, email, tema, poruka) VALUES (?,?,?,?)";
	private static String PRIKAZPORUKA = "SELECT * FROM  poruka";
	
	// DEFINICIJA KONSTRUKTORA ZA PODESAVNJE KONEKCIJE – UVEK ISTO
	public PorukaDAO(){
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
	public void insertPoruka(Poruka poruke){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		
				
         try {
			con = ds.getConnection();
			pstm = con.prepareStatement(INSERTPORUKA);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setString(1, poruke.getIme());
			pstm.setString(2, poruke.getEmail());
			pstm.setString(3, poruke.getTema());
			pstm.setString(4, poruke.getPoruka());
			pstm.execute();


				
			
//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT
		
	}
	
	public ArrayList<Poruka> getPoruka(){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		ArrayList<Poruka> po = new ArrayList<Poruka>();
		Poruka poruka = null;
				
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(PRIKAZPORUKA);

			pstm.execute();
			


			rs = pstm.getResultSet();

			while(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				poruka = new Poruka();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				poruka.setIdporuke(rs.getInt("idporuke"));
				poruka.setIme(rs.getString("ime"));
				poruka.setEmail(rs.getString("email"));
				poruka.setTema(rs.getString("tema"));
				poruka.setPoruka(rs.getString("poruka"));
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				po.add(poruka);
			}
//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT
		return po; 
	}
}
