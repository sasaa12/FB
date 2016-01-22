package rs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import java.util.ArrayList;
public class AdminDAO {
      private DataSource ds;

// DEFINICIJA KONEKCIONIH STRINGOVA
	
	private static String EXISTADMIN = "SELECT * FROM admin where korisnickoime = ? and sifra=?";
	private static String ADMNEXIST = "SELECT * FROM admin where korisnickoime = ? ";
	
	private static String INSERTPROCESOR="INSERT INTO procesor(sifra,proizvodjac,model,cena,radniTakt,socket,slika,garancija,akcija) VALUES(?,?,?,?,?,?,?,?,?)";
	private static String INSERTFLASHMEMORIJA="INSERT INTO flashmemorija(sifra,proizvodjac,model,cena,kapacitet,slika,garancija,akcija) VALUES(?,?,?,?,?,?,?,?)";
	private static String INSERTGRAFICKAKARTICA="INSERT INTO grafickaKartica(sifra,proizvodjac,model,cena,memorija,slika,garancija,akcija) VALUES(?,?,?,?,?,?,?,?)";
	private static String INSERTHARDDISK="INSERT INTO hardDisk(sifra,tip,proizvodjac,cena,kapacitet,slika,garancija,akcija) VALUES(?,?,?,?,?,?,?,?)";
	private static String INSERTMATICNAPLOCA="INSERT INTO maticnaPloca(sifra,proizvodjac,model,cena,socket,maxmemorija,slika,garancija,akcija) VALUES(?,?,?,?,?,?,?,?,?)";
	private static String INSERTMIS="INSERT INTO mis(sifra,proizvodjac,model,cena,tip,slika,garancija,akcija) VALUES(?,?,?,?,?,?,?,?)";
	private static String INSERTMONITOR="INSERT INTO monitor(sifra,proizvodjac,model,cena,dijagonala,tipEkrana,slika,garancija,akcija) VALUES(?,?,?,?,?,?,?,?,?)";
	private static String INSERTRAMMEMORIJA="INSERT INTO ramMemorija(sifra,proizvodjac,model,cena,brzinaRada,kapacitet,tip,slika,garancija,akcija) VALUES(?,?,?,?,?,?,?,?,?,?)";
	private static String INSERTTASTATURA="INSERT INTO tastatura(sifra,proizvodjac,model,cena,tip,slika,garancija,akcija) VALUES(?,?,?,?,?,?,?,?)";
	

	// DEFINICIJA KONSTRUKTORA ZA PODESAVNJE KONEKCIJE – UVEK ISTO
	public AdminDAO(){
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
	
	
	public boolean existAdmin(String korisnickoime, String sifra){
			Connection con = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
			// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		
			Admin admin = null;
					
	            try {
				con = ds.getConnection();
				pstm = con.prepareStatement(EXISTADMIN);

				// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
				pstm.setString(1, korisnickoime);
				pstm.setString(2, sifra);
				pstm.execute();

	//****POCETAK	AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
				rs = pstm.getResultSet();

				if(rs.next()){ // if AKO UPIT VRACA JEDAN REZULTAT
					admin = new Admin();
					admin.setId(rs.getInt("id"));
					admin.setKorisnickoime(rs.getString("korisnickoime"));
					admin.setSifra(rs.getString("sifra"));
					
					
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
	
	public boolean getKorisnickoIme(String korisnickoime){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
	
		Admin admin = null;
				
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(ADMNEXIST);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setString(1, korisnickoime);
			
			pstm.execute();

//****POCETAK	AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			if(rs.next()){ // if AKO UPIT VRACA JEDAN REZULTAT
				admin = new Admin();
				admin.setId(rs.getInt("id"));
				admin.setKorisnickoime(rs.getString("korisnickoime"));
				admin.setSifra(rs.getString("sifra"));
				
				
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

	
	
	public void insertProcesor(Procesor p){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		
	
				
         try {
			con = ds.getConnection();
			pstm = con.prepareStatement(INSERTPROCESOR);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setString(1,p.getSifra());
			pstm.setString(2,p.getProizvodjac());
			pstm.setString(3,p.getModel());
			pstm.setFloat(4,p.getCena());
			pstm.setString(5,p.getRadniTakt());
			pstm.setString(6,p.getSocket());
			pstm.setString(7,p.getSlika());
			pstm.setInt(8,p.getGarancija());
			pstm.setString(9,p.getAkcija());
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

		
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
			
			
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
	 
	public void insertgrafickaKartica(grafickaKartica gk){
			Connection con = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
			// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		
	            try {
				con = ds.getConnection();
				pstm = con.prepareStatement(INSERTGRAFICKAKARTICA);

				// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
				pstm.setString(1,gk.getSifra());
				pstm.setString(2,gk.getProizvodjac());
				pstm.setString(3,gk.getModel());
				pstm.setFloat(4,gk.getCena());
				pstm.setString(5,gk.getMemorija());
				pstm.setString(6,gk.getSlika());
				pstm.setInt(7,gk.getGarancija());
				pstm.setString(8,gk.getAkcija());
				pstm.execute();

	//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
				rs = pstm.getResultSet();

			
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
		
	public void insertflashMemorija(flashMemorija fm){
					Connection con = null;
					PreparedStatement pstm = null;
					ResultSet rs = null;
					// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
				
			            try {
						con = ds.getConnection();
						pstm = con.prepareStatement(INSERTFLASHMEMORIJA);

						// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
						pstm.setString(1,fm.getSifra());
						pstm.setString(2,fm.getProizvodjac());
						pstm.setString(3,fm.getModel());
						pstm.setFloat(4,fm.getCena());
						pstm.setString(5,fm.getKapacitet());
						pstm.setString(6,fm.getSlika());
						pstm.setInt(7,fm.getGarancija());
						pstm.setString(8,fm.getAkcija());
						pstm.execute();

			//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
						rs = pstm.getResultSet();

					
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
				
	public void inserthardDisk(hardDisk hd){
					Connection con = null;
					PreparedStatement pstm = null;
					ResultSet rs = null;
					// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
				
			            try {
						con = ds.getConnection();
						pstm = con.prepareStatement(INSERTHARDDISK);

						// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
						
						pstm.setString(1,hd.getSifra());
						pstm.setString(2,hd.getTip());
						pstm.setString(3,hd.getProizvodjac());
						pstm.setFloat(4,hd.getCena());
						pstm.setString(5,hd.getKapacitet());
						pstm.setString(6,hd.getSlika());
						pstm.setInt(7,hd.getGarancija());
						pstm.setString(8,hd.getAkcija());
						pstm.execute();

			//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
						rs = pstm.getResultSet();

					
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
		
	public void insertmaticnaPloca(maticnaPloca mp){
					Connection con = null;
					PreparedStatement pstm = null;
					ResultSet rs = null;
					// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
				
			            try {
						con = ds.getConnection();
						pstm = con.prepareStatement(INSERTMATICNAPLOCA);

						// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
						
						
						pstm.setString(1,mp.getSifra());
						pstm.setString(2,mp.getProizvodjac());
						pstm.setString(3,mp.getModel());
						pstm.setFloat(4,mp.getCena());
						pstm.setString(5,mp.getSocket());
						pstm.setString(6,mp.getMaxmemorija());
						pstm.setString(7,mp.getSlika());
						pstm.setInt(8,mp.getGarancija());
					    pstm.setString(9,mp.getAkcija());
						pstm.execute();

			//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
						rs = pstm.getResultSet();

					
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
				
	public void insertmis(Mis mis){
					Connection con = null;
					PreparedStatement pstm = null;
					ResultSet rs = null;
					// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
				
			            try {
						con = ds.getConnection();
						pstm = con.prepareStatement(INSERTMIS);

						// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
						pstm.setString(1,mis.getSifra());
						pstm.setString(2,mis.getProizvodjac());
						pstm.setString(3,mis.getModel());
						pstm.setFloat(4,mis.getCena());
						pstm.setString(5,mis.getTip());
						pstm.setString(6,mis.getSlika());
						pstm.setInt(7,mis.getGarancija());
						pstm.setString(8,mis.getAkcija());
						pstm.execute();

			//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
						rs = pstm.getResultSet();

					
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
			
	public void insertmonitor(Monitor mon){
					Connection con = null;
					PreparedStatement pstm = null;
					ResultSet rs = null;
					// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
				
			            try {
						con = ds.getConnection();
						pstm = con.prepareStatement(INSERTMONITOR);

						// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
						pstm.setString(1,mon.getSifra());
						pstm.setString(2,mon.getProizvodjac());
						pstm.setString(3,mon.getModel());
						pstm.setFloat(4,mon.getCena());
						pstm.setInt(5,mon.getDijagonala());
						pstm.setString(6,mon.getTipEkrana());
						pstm.setString(7,mon.getSlika());
						pstm.setInt(8,mon.getGarancija());
						pstm.setString(9,mon.getAkcija());
						
					
						pstm.execute();

			//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
						rs = pstm.getResultSet();

					
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
			
	public void insertramMemorija(ramMemorija rm){
					Connection con = null;
					PreparedStatement pstm = null;
					ResultSet rs = null;
					// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
				
			            try {
						con = ds.getConnection();
						pstm = con.prepareStatement(INSERTRAMMEMORIJA);

						// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
						pstm.setString(1,rm.getSifra());
						pstm.setString(2,rm.getProizvodjac());
						pstm.setString(3,rm.getModel());
						pstm.setFloat(4,rm.getCena());
						pstm.setString(5,rm.getBrzinaRada());
						pstm.setString(6,rm.getKapacitet());
						pstm.setString(7,rm.getTip());
						pstm.setString(8,rm.getSlika());
						pstm.setInt(9,rm.getGarancija());
						pstm.setString(10,rm.getAkcija());
						pstm.execute();

			//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
						rs = pstm.getResultSet();

					
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
			
	public void inserttastatura(Tastatura t){
					Connection con = null;
					PreparedStatement pstm = null;
					ResultSet rs = null;
					// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
				
			            try {
						con = ds.getConnection();
						pstm = con.prepareStatement(INSERTTASTATURA);

						// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
						pstm.setString(1,t.getSifra());
						pstm.setString(2,t.getProizvodjac());
						pstm.setString(3,t.getModel());
						pstm.setFloat(4,t.getCena());
	    				pstm.setString(5,t.getTip());
	    				pstm.setString(6,t.getSlika());
				     	pstm.setInt(7,t.getGarancija());
						pstm.setString(8,t.getAkcija());
						pstm.execute();

			//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
						rs = pstm.getResultSet();

					
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
	
	}


