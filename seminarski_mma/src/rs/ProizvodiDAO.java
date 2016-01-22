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




public class ProizvodiDAO {
   private DataSource ds;

//DEFINICIJA KONEKCIONIH STRINGOVA
   
   private static String INSERTNARUDZBINA = "INSERT INTO `narudzbenica`( `vreme`, `cena`, `ime`) VALUES (CURRENT_TIMESTAMP,?,?)";
   private static String PRIKAZNARUDZBINA = "SELECT * FROM  narudzbenica";
   private static String IZBRISINARUDZBINU = "DELETE FROM  narudzbenica";
   
   private static String GETPROCESORID = "SELECT * FROM procesor where sifra=?";
   private static String SELECTPROCESOR = "SELECT * FROM procesor ";
   private static String GETRPROCESOR =  "SELECT * FROM procesor ORDER BY RAND() LIMIT 1";
   private static String AKCIJAPROCESOR = "SELECT * FROM procesor WHERE akcija='1' ";
   private static String PRETRAGAPROCESOR= "SELECT * FROM procesor where proizvodjac=? OR model=? OR radniTakt=?";
   
   private static String GETRAMMEMORIJAID = "SELECT * FROM ramMemorija where sifra=?";
   private static String SELECTRAMMEMORIJA="SELECT *FROM ramMemorija";
   private static String GETRRAMMEMORIJA =  "SELECT * FROM ramMemorija ORDER BY RAND() LIMIT 1";
   private static String AKCIJARAMMEMORIJA = "SELECT * FROM ramMemorija WHERE akcija='1' ";
   private static String PRETRAGARAMMEMORIJA= "SELECT * FROM ramMemorija where proizvodjac=? OR model=? OR brzinaRada=? OR tip=? OR kapacitet=?";
   
   private static String GETHARDDISKID = "SELECT * FROM hardDisk where sifra=?";
   private static String SELECTHARDDISK="SELECT *FROM hardDisk";
   private static String GETRHARDDISK =  "SELECT * FROM hardDisk ORDER BY RAND() LIMIT 1";
   private static String AKCIJAHARDDISK = "SELECT * FROM hardDisk WHERE akcija='1' ";
   private static String PRETRAGAHARDDISK= "SELECT * FROM hardDisk where proizvodjac=? OR tip=? OR kapacitet=?";
   
   private static String GETTASTATURAID = "SELECT * FROM tastatura where sifra=?";
   private static String SELECTTASTATURA="SELECT *FROM tastatura";
   private static String GETRTASTATURA =  "SELECT * FROM tastatura ORDER BY RAND() LIMIT 1";
   private static String AKCIJATASTATURA = "SELECT * FROM tastatura WHERE akcija='1' ";
   private static String PRETRAGATASTATURA= "SELECT * FROM tastatura where proizvodjac=? OR tip=? OR model=?";
   
   private static String GETMISID = "SELECT * FROM mis where sifra=?";
   private static String SELECTMIS="SELECT *FROM mis";
   private static String GETRMIS =  "SELECT * FROM mis ORDER BY RAND() LIMIT 1";
   private static String AKCIJAMIS = "SELECT * FROM mis WHERE akcija='1' ";
   private static String PRETRAGAMIS= "SELECT * FROM mis where proizvodjac=? OR tip=? OR model=?";
	
   private static String GETMATICNAPLOCAID = "SELECT * FROM maticnaPloca where sifra=?";
   private static String SELECTMATICNAPLOCA="SELECT *FROM maticnaPloca";
   private static String GETRMATICNAPLOCA=  "SELECT * FROM maticnaPloca ORDER BY RAND() LIMIT 1";
   private static String AKCIJAMATICNAPLOCA = "SELECT * FROM maticnaPloca WHERE akcija='1' ";
   private static String PRETRAGAMATICNAPLOCA= "SELECT * FROM maticnaPloca where proizvodjac=? OR socket=? OR model=? OR maxmemorija=?";
	
   private static String GETMONITORID = "SELECT * FROM monitor where sifra=?";
   private static String SELECTMONITOR="SELECT *FROM monitor";
   private static String GETRMONITOR=  "SELECT * FROM monitor ORDER BY RAND() LIMIT 1";
   private static String AKCIJAMONITOR = "SELECT * FROM monitor WHERE akcija='1' ";
   private static String PRETRAGAMONITOR= "SELECT * FROM monitor where proizvodjac=? OR tipEkrana=? OR model=?";
   
   private static String GETFLASHMEMORIJAID = "SELECT * FROM flashMemorija where sifra=?";
   private static String SELECTFLASHMEMORIJA="SELECT *FROM flashMemorija";
   private static String GETRFLASHMEMORIJA=  "SELECT * FROM flashMemorija ORDER BY RAND() LIMIT 1";
   private static String AKCIJAFLASHMEMORIJA = "SELECT * FROM flashMemorija WHERE akcija='1' ";
   private static String PRETRAGAFLASHMEMORIJA= "SELECT * FROM flashMemorija where proizvodjac=? OR kapacitet=? OR model=?";
   
   private static String GETGRAFICKAKARTICAID = "SELECT * FROM grafickaKartica where sifra=?";
   private static String SELECTGRAFICKAKARTICA="SELECT *FROM grafickaKartica";
   private static String GETRGRAFICKAKARTICA=  "SELECT * FROM grafickaKartica ORDER BY RAND() LIMIT 1";
   private static String AKCIJAGRAFICKAKARTICA = "SELECT * FROM grafickaKartica WHERE akcija='1' ";
   private static String PRETRAGAGRAFICKAKARTICA= "SELECT * FROM grafickaKartica where proizvodjac=? OR memorija=? OR model=?";
   
	// DEFINICIJA KONSTRUKTORA ZA PODESAVNJE KONEKCIJE – UVEK ISTO
	public ProizvodiDAO(){
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
	
	// DEFINICIJA METODE 
	public void insertNarudzbenica(Narudzbenica nar){
			Connection con = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
			// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
			
			
					
	            try {
				con = ds.getConnection();
				pstm = con.prepareStatement(INSERTNARUDZBINA);

				// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
				pstm.setFloat(1,nar.getCena());
				pstm.setString(2,nar.getIme());
				
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
	public ArrayList<Narudzbenica> getNarudzbenica(){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		ArrayList<Narudzbenica> po = new ArrayList<Narudzbenica>();
		Narudzbenica nar = null;
				
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(PRIKAZNARUDZBINA);

			pstm.execute();
			


			rs = pstm.getResultSet();

			while(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				nar = new Narudzbenica();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				nar.setId(rs.getInt("id"));
				nar.setIme(rs.getString("ime"));
				nar.setCena(rs.getFloat("cena"));
				nar.setVreme(rs.getTimestamp("vreme"));
				
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				po.add(nar);
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
	public void deleteNarudzbenica(){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		
		
				
         try {
			con = ds.getConnection();
			pstm = con.prepareStatement(IZBRISINARUDZBINU);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			
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

 
	public Procesor getProcesorID (String sifra){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Procesor pr=null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
	
		
				
         try {
			con = ds.getConnection();
			pstm = con.prepareStatement(GETPROCESORID);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setString(1, sifra);
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			if(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				pr = new Procesor();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				pr.setAkcija(rs.getString("akcija"));
				pr.setSifra(rs.getString("sifra"));
				pr.setProizvodjac(rs.getString("proizvodjac"));
				pr.setRadniTakt(rs.getString("radnitakt"));
				pr.setModel(rs.getString("model"));
				pr.setSocket(rs.getString("socket"));
				pr.setSlika(rs.getString("slika"));
				pr.setCena(rs.getFloat("cena"));
				pr.setGarancija(rs.getInt("garancija"));
				
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				
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
		return pr; 
	// DEFINICIJA OSTALIH METODA ... 
	}
	public Procesor getRProcesor(){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Procesor p=null;
				
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(GETRPROCESOR);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			if(rs.next()){ // if AKO UPIT VRACA JEDAN REZULTAT
				p=new Procesor();

				
				p.setProizvodjac(rs.getString("Proizvodjac"));
				p.setModel(rs.getString("Model"));
				p.setCena(rs.getFloat("Cena"));
				p.setSlika(rs.getString("slika"));
				p.setSocket(rs.getString("socket"));
				p.setRadniTakt(rs.getString("radnitakt"));
				p.setSifra(rs.getString("Sifra"));
				
				
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
		return p; 
	}
	public ArrayList<Procesor> selectProcesor(){
			Connection con = null;
			PreparedStatement pstm = null;
			ResultSet rs = null;
			// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
			ArrayList<Procesor> lp = new ArrayList<Procesor>();
			Procesor p = null;
					
	            try {
				con = ds.getConnection();
				pstm = con.prepareStatement(SELECTPROCESOR);

				// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
				
				pstm.execute();

	//****POCETAK	AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
				rs = pstm.getResultSet();

				while(rs.next()){ // if AKO UPIT VRACA JEDAN REZULTAT
					p = new Procesor();

					p.setSifra(rs.getString("sifra"));
					p.setProizvodjac(rs.getString("proizvodjac"));
					p.setModel(rs.getString("model"));
					p.setCena(rs.getFloat("cena"));
					p.setRadniTakt(rs.getString("radniTakt"));
					p.setSocket(rs.getString("socket"));
					p.setSlika(rs.getString("slika"));
					p.setGarancija(rs.getInt("garancija"));
					p.setAkcija(rs.getString("akcija"));
					
					lp.add(p);
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
			return lp; 
		}
	public ArrayList<Procesor> akcijaProcesor(){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		ArrayList<Procesor> procesor = new ArrayList<Procesor>();
		Procesor p;
				
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(AKCIJAPROCESOR);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();
			while(rs.next()){ // if AKO UPIT VRACA JEDAN REZULTAT
				p = new Procesor();

				p.setSifra(rs.getString("sifra"));
				p.setProizvodjac(rs.getString("proizvodjac"));
				p.setModel(rs.getString("model"));
				p.setCena(rs.getFloat("cena"));
				p.setRadniTakt(rs.getString("radniTakt"));
				p.setSocket(rs.getString("socket"));
				p.setSlika(rs.getString("slika"));
				p.setGarancija(rs.getInt("garancija"));
				p.setAkcija(rs.getString("akcija"));
				
				procesor.add(p);
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
		return procesor; 
	}
	public ArrayList<Procesor> pretragaProcesor(String search){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		ArrayList<Procesor> lo = new ArrayList<Procesor>();
		Procesor p = null;
				
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(PRETRAGAPROCESOR);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setString(1, search);
			pstm.setString(2, search);
			pstm.setString(3, search);
			pstm.execute();

//****POCETAK	AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			while(rs.next()){ // if AKO UPIT VRACA JEDAN REZULTAT
				p = new Procesor();
				
				p.setSifra(rs.getString("sifra"));
				p.setProizvodjac(rs.getString("proizvodjac"));
				p.setModel(rs.getString("model"));
				p.setCena(rs.getFloat("cena"));
				p.setRadniTakt(rs.getString("radniTakt"));
				p.setSocket(rs.getString("socket"));
				p.setSlika(rs.getString("slika"));
				p.setGarancija(rs.getInt("garancija"));
				p.setAkcija(rs.getString("akcija"));
				
				lo.add(p);
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
		return lo; 
	}
	

	public ramMemorija getRamMemorijaID (String sifra){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ramMemorija rm=null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
	
		
				
         try {
			con = ds.getConnection();
			pstm = con.prepareStatement(GETRAMMEMORIJAID);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setString(1, sifra);
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			if(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				rm = new ramMemorija();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				rm.setAkcija(rs.getString("akcija"));
				rm.setSifra(rs.getString("sifra"));
				rm.setProizvodjac(rs.getString("proizvodjac"));
				rm.setBrzinaRada(rs.getString("brzinaRada"));
				rm.setModel(rs.getString("model"));
				rm.setKapacitet(rs.getString("kapacitet"));
				rm.setTip(rs.getString("tip"));
				rm.setSlika(rs.getString("slika"));
			    rm.setCena(rs.getFloat("cena"));
				rm.setGarancija(rs.getInt("garancija"));
				
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				
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
		return rm; 
	// DEFINICIJA OSTALIH METODA ... 
	}
	public ArrayList<ramMemorija> selectramMemorija(){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		ArrayList<ramMemorija> lo = new ArrayList<ramMemorija>();
		ramMemorija rm = null;
				
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(SELECTRAMMEMORIJA);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			while(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				rm= new ramMemorija();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				rm.setAkcija(rs.getString("akcija"));
				rm.setSifra(rs.getString("sifra"));
				rm.setProizvodjac(rs.getString("proizvodjac"));
				rm.setBrzinaRada(rs.getString("brzinaRada"));
				rm.setModel(rs.getString("model"));
				rm.setKapacitet(rs.getString("kapacitet"));
				rm.setTip(rs.getString("tip"));
				rm.setSlika(rs.getString("slika"));
			    rm.setCena(rs.getFloat("cena"));
				rm.setGarancija(rs.getInt("garancija"));
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				lo.add(rm);
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
		return lo; 
	}
	public ramMemorija getRramMemorija(){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ramMemorija rm=null;
				
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(GETRRAMMEMORIJA);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			if(rs.next()){ // if AKO UPIT VRACA JEDAN REZULTAT
				rm=new ramMemorija();

				
				rm.setAkcija(rs.getString("akcija"));
				rm.setSifra(rs.getString("sifra"));
				rm.setProizvodjac(rs.getString("proizvodjac"));
				rm.setBrzinaRada(rs.getString("brzinaRada"));
				rm.setModel(rs.getString("model"));
				rm.setKapacitet(rs.getString("kapacitet"));
				rm.setSlika(rs.getString("slika"));
				rm.setTip(rs.getString("tip"));
			    rm.setCena(rs.getFloat("cena"));
				rm.setGarancija(rs.getInt("garancija"));
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				
				
				
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
		return rm; 
	}
	public ArrayList<ramMemorija> akcijaRamMemorija(){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		ArrayList<ramMemorija> ram = new ArrayList<ramMemorija>();
		ramMemorija rm;
				
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(AKCIJARAMMEMORIJA);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();
			while(rs.next()){ // if AKO UPIT VRACA JEDAN REZULTAT
				rm = new ramMemorija();

				rm.setSifra(rs.getString("sifra"));
				rm.setProizvodjac(rs.getString("proizvodjac"));
				rm.setModel(rs.getString("model"));
				rm.setCena(rs.getFloat("cena"));
				rm.setBrzinaRada(rs.getString("brzinarada"));
				rm.setTip(rs.getString("tip"));
				rm.setKapacitet(rs.getString("kapacitet"));
				rm.setSlika(rs.getString("slika"));
				rm.setGarancija(rs.getInt("garancija"));
				rm.setAkcija(rs.getString("akcija"));
				
				ram.add(rm);
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
		return ram; 
	}
	public ArrayList<ramMemorija> pretragaRamMemorija(String search){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		ArrayList<ramMemorija> lo = new ArrayList<ramMemorija>();
		ramMemorija rm = null;
				
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(PRETRAGARAMMEMORIJA);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setString(1, search);
			pstm.setString(2, search);
			pstm.setString(3, search);
			pstm.setString(4, search);
			pstm.setString(5, search);
			pstm.execute();

//****POCETAK	AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			while(rs.next()){ // if AKO UPIT VRACA JEDAN REZULTAT
				rm = new ramMemorija();
				
				rm.setSifra(rs.getString("sifra"));
				rm.setProizvodjac(rs.getString("proizvodjac"));
				rm.setModel(rs.getString("model"));
				rm.setCena(rs.getFloat("cena"));
				rm.setBrzinaRada(rs.getString("brzinarada"));
				rm.setTip(rs.getString("tip"));
				rm.setKapacitet(rs.getString("kapacitet"));
				rm.setSlika(rs.getString("slika"));
				rm.setGarancija(rs.getInt("garancija"));
				rm.setAkcija(rs.getString("akcija"));
				
				
				lo.add(rm);
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
		return lo; 
	}
	
	
	public hardDisk getHardDiskID (String sifra){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		hardDisk hd=null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
	
		
				
         try {
			con = ds.getConnection();
			pstm = con.prepareStatement(GETHARDDISKID);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setString(1, sifra);
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			if(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				hd = new hardDisk();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				hd.setAkcija(rs.getString("akcija"));
				hd.setSifra(rs.getString("sifra"));
				hd.setProizvodjac(rs.getString("proizvodjac"));
				hd.setKapacitet(rs.getString("kapacitet"));
				hd.setTip(rs.getString("tip"));
				hd.setSlika(rs.getString("slika"));
				hd.setCena(rs.getFloat("cena"));
				hd.setGarancija(rs.getInt("garancija"));
				
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				
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
		return hd; 
	// DEFINICIJA OSTALIH METODA ... 
	}
	public ArrayList<hardDisk> selecthardDisk(){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		ArrayList<hardDisk> lo = new ArrayList<hardDisk>();
		hardDisk hd = null;
				
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(SELECTHARDDISK);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			while(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				hd = new hardDisk();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				hd.setAkcija(rs.getString("akcija"));
				hd.setSlika(rs.getString("slika"));
				hd.setSifra(rs.getString("sifra"));
				hd.setProizvodjac(rs.getString("proizvodjac"));
				hd.setTip(rs.getString("tip"));
				hd.setKapacitet(rs.getString("kapacitet"));
				hd.setCena(rs.getFloat("cena"));
				hd.setGarancija(rs.getInt("garancija"));
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				lo.add(hd);
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
		return lo; 
	}
	public hardDisk getRhardDisk(){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		hardDisk hd=null;
				
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(GETRHARDDISK);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			if(rs.next()){ // if AKO UPIT VRACA JEDAN REZULTAT
				hd=new hardDisk();

				
				hd.setAkcija(rs.getString("akcija"));
				hd.setSifra(rs.getString("sifra"));
				hd.setProizvodjac(rs.getString("proizvodjac"));
				
				hd.setKapacitet(rs.getString("kapacitet"));
				hd.setSlika(rs.getString("slika"));
				hd.setTip(rs.getString("tip"));
				hd.setCena(rs.getFloat("cena"));
				hd.setGarancija(rs.getInt("garancija"));
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				
				
				
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
		return hd; 
	}
	public ArrayList<hardDisk> akcijaHardDisk(){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		ArrayList<hardDisk> hdd = new ArrayList<hardDisk>();
		hardDisk hd;
				
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(AKCIJAHARDDISK);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();
			while(rs.next()){ // if AKO UPIT VRACA JEDAN REZULTAT
				hd = new hardDisk();

				hd.setSifra(rs.getString("sifra"));
				hd.setProizvodjac(rs.getString("proizvodjac"));
				hd.setCena(rs.getFloat("cena"));
				hd.setTip(rs.getString("tip"));
				hd.setKapacitet(rs.getString("kapacitet"));
				hd.setSlika(rs.getString("slika"));
				hd.setGarancija(rs.getInt("garancija"));
				hd.setAkcija(rs.getString("akcija"));
				
				hdd.add(hd);
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
		return hdd; 
	}
	public ArrayList<hardDisk> pretragaHardDisk(String search){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		ArrayList<hardDisk> lo = new ArrayList<hardDisk>();
		hardDisk hd = null;
				
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(PRETRAGAHARDDISK);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setString(1, search);
			pstm.setString(2, search);
			pstm.setString(3, search);
			
			pstm.execute();

//****POCETAK	AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			while(rs.next()){ // if AKO UPIT VRACA JEDAN REZULTAT
				hd = new hardDisk();
				
				hd.setSifra(rs.getString("sifra"));
				hd.setProizvodjac(rs.getString("proizvodjac"));
				hd.setCena(rs.getFloat("cena"));
				hd.setTip(rs.getString("tip"));
				hd.setKapacitet(rs.getString("kapacitet"));
				hd.setSlika(rs.getString("slika"));
				hd.setGarancija(rs.getInt("garancija"));
				hd.setAkcija(rs.getString("akcija"));
				
				
				lo.add(hd);
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
		return lo; 
	}
	
	public Tastatura getTastaturaID (String sifra){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Tastatura tas=null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
	
		
				
         try {
			con = ds.getConnection();
			pstm = con.prepareStatement(GETTASTATURAID);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setString(1, sifra);
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			if(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				tas = new Tastatura();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				tas.setAkcija(rs.getString("akcija"));
				tas.setSifra(rs.getString("sifra"));
				tas.setProizvodjac(rs.getString("proizvodjac"));
				tas.setModel(rs.getString("model"));
				tas.setTip(rs.getString("tip"));
				tas.setSlika(rs.getString("slika"));
				tas.setCena(rs.getFloat("cena"));
				tas.setGarancija(rs.getInt("garancija"));
				
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				
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
		return tas; 
	// DEFINICIJA OSTALIH METODA ... 
	}
	public ArrayList<Tastatura> selectTastatura(){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		ArrayList<Tastatura> lo = new ArrayList<Tastatura>();
		Tastatura t = null;
				
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(SELECTTASTATURA);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			while(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				t = new Tastatura();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				t.setAkcija(rs.getString("akcija"));
				t.setSifra(rs.getString("sifra"));
				t.setProizvodjac(rs.getString("proizvodjac"));
				t.setTip(rs.getString("tip"));
				t.setModel(rs.getString("model"));
				t.setSlika(rs.getString("slika"));
			     t.setCena(rs.getFloat("cena"));
				t.setGarancija(rs.getInt("garancija"));
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				lo.add(t);
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
		return lo; 
	}
	public Tastatura getRTastatura(){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Tastatura tas=null;
				
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(GETRTASTATURA);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			if(rs.next()){ // if AKO UPIT VRACA JEDAN REZULTAT
				tas=new Tastatura();

				
				tas.setAkcija(rs.getString("akcija"));
				tas.setSifra(rs.getString("sifra"));
				tas.setProizvodjac(rs.getString("proizvodjac"));
				tas.setModel(rs.getString("model"));
				tas.setSlika(rs.getString("slika"));
				tas.setTip(rs.getString("tip"));
				tas.setCena(rs.getFloat("cena"));
				tas.setGarancija(rs.getInt("garancija"));
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				
				
				
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
		return tas; 
	}
	public ArrayList<Tastatura> akcijaTastatura(){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		ArrayList<Tastatura> ts = new ArrayList<Tastatura>();
		Tastatura tas;
				
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(AKCIJATASTATURA);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();
			while(rs.next()){ // if AKO UPIT VRACA JEDAN REZULTAT
				tas = new Tastatura();

				tas.setSifra(rs.getString("sifra"));
				tas.setProizvodjac(rs.getString("proizvodjac"));
				tas.setCena(rs.getFloat("cena"));
				tas.setTip(rs.getString("tip"));
				tas.setModel(rs.getString("model"));
				tas.setSlika(rs.getString("slika"));
				tas.setGarancija(rs.getInt("garancija"));
				tas.setAkcija(rs.getString("akcija"));
				
				ts.add(tas);
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
		return ts; 
	}
	public ArrayList<Tastatura> pretragaTastatura(String search){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		ArrayList<Tastatura> lo = new ArrayList<Tastatura>();
		Tastatura tas = null;
				
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(PRETRAGATASTATURA);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setString(1, search);
			pstm.setString(2, search);
			pstm.setString(3, search);
			
			pstm.execute();

//****POCETAK	AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			while(rs.next()){ // if AKO UPIT VRACA JEDAN REZULTAT
				tas = new Tastatura();
				
				tas.setSifra(rs.getString("sifra"));
				tas.setProizvodjac(rs.getString("proizvodjac"));
				tas.setCena(rs.getFloat("cena"));
				tas.setTip(rs.getString("tip"));
				tas.setModel(rs.getString("model"));
				tas.setSlika(rs.getString("slika"));
				tas.setGarancija(rs.getInt("garancija"));
				tas.setAkcija(rs.getString("akcija"));
				
				
				lo.add(tas);
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
		return lo; 
	}
	
	
	public Mis getMisID (String sifra){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Mis mis=null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
	
		
				
         try {
			con = ds.getConnection();
			pstm = con.prepareStatement(GETMISID);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setString(1, sifra);
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			if(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				mis = new Mis();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				mis.setAkcija(rs.getString("akcija"));
				mis.setSifra(rs.getString("sifra"));
				mis.setProizvodjac(rs.getString("proizvodjac"));
				mis.setModel(rs.getString("model"));
				mis.setTip(rs.getString("tip"));
				mis.setSlika(rs.getString("slika"));
				mis.setCena(rs.getFloat("cena"));
				mis.setGarancija(rs.getInt("garancija"));
				
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				
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
		return mis; 
	// DEFINICIJA OSTALIH METODA ... 
	}
	public ArrayList<Mis> selectMis(){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		ArrayList<Mis> lo = new ArrayList<Mis>();
		Mis m = null;
				
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(SELECTMIS);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			while(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				m = new Mis();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				m.setAkcija(rs.getString("akcija"));
				m.setSifra(rs.getString("sifra"));
				m.setProizvodjac(rs.getString("proizvodjac"));
				m.setTip(rs.getString("tip"));
				m.setModel(rs.getString("model"));
				m.setSlika(rs.getString("slika"));
			    m.setCena(rs.getFloat("cena"));
				m.setGarancija(rs.getInt("garancija"));
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				lo.add(m);
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
		return lo; 
	}
	public Mis getRMis(){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Mis mis=null;
				
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(GETRMIS);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			if(rs.next()){ // if AKO UPIT VRACA JEDAN REZULTAT
				mis=new Mis();

				
				mis.setAkcija(rs.getString("akcija"));
				mis.setSifra(rs.getString("sifra"));
				mis.setProizvodjac(rs.getString("proizvodjac"));
				mis.setModel(rs.getString("model"));
				mis.setSlika(rs.getString("slika"));
				mis.setTip(rs.getString("tip"));
				mis.setCena(rs.getFloat("cena"));
				mis.setGarancija(rs.getInt("garancija"));
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				
				
				
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
		return mis; 
	}
	public ArrayList<Mis> akcijaMis(){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		ArrayList<Mis> ms = new ArrayList<Mis>();
		Mis mis;
				
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(AKCIJAMIS);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();
			while(rs.next()){ // if AKO UPIT VRACA JEDAN REZULTAT
				mis = new Mis();

				mis.setSifra(rs.getString("sifra"));
				mis.setProizvodjac(rs.getString("proizvodjac"));
				mis.setCena(rs.getFloat("cena"));
				mis.setTip(rs.getString("tip"));
				mis.setModel(rs.getString("model"));
				mis.setSlika(rs.getString("slika"));
				mis.setGarancija(rs.getInt("garancija"));
				mis.setAkcija(rs.getString("akcija"));
				
				ms.add(mis);
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
		return ms; 
	}
	public ArrayList<Mis> pretragaMis(String search){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		ArrayList<Mis> lo = new ArrayList<Mis>();
		Mis mis = null;
				
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(PRETRAGAMIS);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setString(1, search);
			pstm.setString(2, search);
			pstm.setString(3, search);
			
			pstm.execute();

//****POCETAK	AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			while(rs.next()){ // if AKO UPIT VRACA JEDAN REZULTAT
				mis = new Mis();
				
				mis.setSifra(rs.getString("sifra"));
				mis.setProizvodjac(rs.getString("proizvodjac"));
				mis.setCena(rs.getFloat("cena"));
				mis.setTip(rs.getString("tip"));
				mis.setModel(rs.getString("model"));
				mis.setSlika(rs.getString("slika"));
				mis.setGarancija(rs.getInt("garancija"));
				mis.setAkcija(rs.getString("akcija"));
				
				
				lo.add(mis);
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
		return lo; 
	}
	
	public maticnaPloca getMaticnaPlocaID (String sifra){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		maticnaPloca mp=null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
	
		
				
         try {
			con = ds.getConnection();
			pstm = con.prepareStatement(GETMATICNAPLOCAID);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setString(1, sifra);
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			if(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				mp = new maticnaPloca();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				mp.setAkcija(rs.getString("akcija"));
				mp.setSifra(rs.getString("sifra"));
				mp.setProizvodjac(rs.getString("proizvodjac"));
				mp.setModel(rs.getString("model"));
				mp.setSocket(rs.getString("socket"));
				mp.setSlika(rs.getString("slika"));
				mp.setCena(rs.getFloat("cena"));
				mp.setMaxmemorija(rs.getString("maxmemorija"));
				mp.setGarancija(rs.getInt("garancija"));
				
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				
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
		return mp; 
	// DEFINICIJA OSTALIH METODA ... 
	}
	public ArrayList<maticnaPloca> selectmatricnaPloca(){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		ArrayList<maticnaPloca> lo = new ArrayList<maticnaPloca>();
		maticnaPloca mp = null;
				
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(SELECTMATICNAPLOCA);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
		
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			while(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				mp = new maticnaPloca();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				mp.setAkcija(rs.getString("akcija"));
				mp.setSifra(rs.getString("sifra"));
				mp.setProizvodjac(rs.getString("proizvodjac"));
				mp.setSocket(rs.getString("socket"));
				mp.setModel(rs.getString("model"));
				mp.setMaxmemorija(rs.getString("maxmemorija"));
				mp.setSlika(rs.getString("slika"));
				mp.setCena(rs.getFloat("cena"));
				mp.setGarancija(rs.getInt("garancija"));
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				lo.add(mp);
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
		return lo; 
	}
	public maticnaPloca getRmaticnaPloca(){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		maticnaPloca mp=null;
				
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(GETRMATICNAPLOCA);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			if(rs.next()){ // if AKO UPIT VRACA JEDAN REZULTAT
				mp=new maticnaPloca();

				
				mp.setAkcija(rs.getString("akcija"));
				mp.setSifra(rs.getString("sifra"));
				mp.setProizvodjac(rs.getString("proizvodjac"));
				mp.setModel(rs.getString("model"));
				mp.setSlika(rs.getString("slika"));
				mp.setMaxmemorija(rs.getString("maxMemorija"));
				mp.setSocket(rs.getString("socket"));
				mp.setCena(rs.getFloat("cena"));
				mp.setGarancija(rs.getInt("garancija"));
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				
				
				
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
		return mp; 
	}
	public ArrayList<maticnaPloca> akcijaMaticnaPloca(){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		ArrayList<maticnaPloca> map = new ArrayList<maticnaPloca>();
		maticnaPloca mp;
				
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(AKCIJAMATICNAPLOCA);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();
			while(rs.next()){ // if AKO UPIT VRACA JEDAN REZULTAT
				mp = new maticnaPloca();

				mp.setSifra(rs.getString("sifra"));
				mp.setProizvodjac(rs.getString("proizvodjac"));
				mp.setModel(rs.getString("model"));
				mp.setCena(rs.getFloat("cena"));
				mp.setSocket(rs.getString("socket"));
				mp.setMaxmemorija(rs.getString("maxmemorija"));
				mp.setSlika(rs.getString("slika"));
				mp.setGarancija(rs.getInt("garancija"));
				mp.setAkcija(rs.getString("akcija"));
				
				map.add(mp);
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
		return map; 
	}
	public ArrayList<maticnaPloca> pretragaMaticnaPloca(String search){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		ArrayList<maticnaPloca> lo = new ArrayList<maticnaPloca>();
		maticnaPloca mp = null;
				
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(PRETRAGAMATICNAPLOCA);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setString(1, search);
			pstm.setString(2, search);
			pstm.setString(3, search);
			pstm.setString(4, search);
			
			pstm.execute();

//****POCETAK	AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			while(rs.next()){ // if AKO UPIT VRACA JEDAN REZULTAT
				mp = new maticnaPloca();

				mp.setSifra(rs.getString("sifra"));
				mp.setProizvodjac(rs.getString("proizvodjac"));
				mp.setModel(rs.getString("model"));
				mp.setCena(rs.getFloat("cena"));
				mp.setSocket(rs.getString("socket"));
				mp.setMaxmemorija(rs.getString("maxmemorija"));
				mp.setSlika(rs.getString("slika"));
				mp.setGarancija(rs.getInt("garancija"));
				mp.setAkcija(rs.getString("akcija"));
				
				
				lo.add(mp);
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
		return lo; 
	}
	
	
	public Monitor getMonitorID (String sifra){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Monitor mon=null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
	
		
				
         try {
			con = ds.getConnection();
			pstm = con.prepareStatement(GETMONITORID);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setString(1, sifra);
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			if(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				mon = new Monitor();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				mon.setAkcija(rs.getString("akcija"));
				mon.setSifra(rs.getString("sifra"));
				mon.setProizvodjac(rs.getString("proizvodjac"));
				mon.setModel(rs.getString("model"));
				mon.setDijagonala(rs.getInt("dijagonala"));
				mon.setSlika(rs.getString("slika"));
				mon.setCena(rs.getFloat("cena"));
				mon.setTipEkrana(rs.getString("tipekrana"));
				mon.setGarancija(rs.getInt("garancija"));
				
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				
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
		return mon; 
	// DEFINICIJA OSTALIH METODA ... 
	}
	public ArrayList<Monitor> selectMonitor(){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		ArrayList<Monitor> lo = new ArrayList<Monitor>();
		Monitor mon = null;
				
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(SELECTMONITOR);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			while(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				mon = new Monitor();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				mon.setAkcija(rs.getString("akcija"));
				mon.setSifra(rs.getString("sifra"));
				mon.setProizvodjac(rs.getString("proizvodjac"));
				mon.setTipEkrana(rs.getString("tipEkrana"));
				mon.setModel(rs.getString("model"));
				mon.setSlika(rs.getString("slika"));
			    mon.setCena(rs.getFloat("cena"));
				mon.setGarancija(rs.getInt("garancija"));
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				lo.add(mon);
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
		return lo; 
	}
	public Monitor getRMonitor(){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		Monitor mon=null;
				
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(GETRMONITOR);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			if(rs.next()){ // if AKO UPIT VRACA JEDAN REZULTAT
				mon=new Monitor();

				
				mon.setAkcija(rs.getString("akcija"));
				mon.setSifra(rs.getString("sifra"));
				mon.setProizvodjac(rs.getString("proizvodjac"));
				mon.setModel(rs.getString("model"));
				mon.setSlika(rs.getString("slika"));
				mon.setTipEkrana(rs.getString("tipEkrana"));
				mon.setCena(rs.getFloat("cena"));
				mon.setGarancija(rs.getInt("garancija"));
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				
				
				
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
		return mon; 
	}
	public ArrayList<Monitor> akcijaMonitor(){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		ArrayList<Monitor> mon = new ArrayList<Monitor>();
		Monitor mo;
				
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(AKCIJAMONITOR);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();
			while(rs.next()){ // if AKO UPIT VRACA JEDAN REZULTAT
				mo = new Monitor();

				mo.setSifra(rs.getString("sifra"));
				mo.setProizvodjac(rs.getString("proizvodjac"));
				mo.setModel(rs.getString("model"));
				mo.setCena(rs.getFloat("cena"));
				mo.setTipEkrana(rs.getString("tipekrana"));
				mo.setDijagonala(rs.getInt("dijagonala"));
				mo.setSlika(rs.getString("slika"));
				mo.setGarancija(rs.getInt("garancija"));
				mo.setAkcija(rs.getString("akcija"));
				
				mon.add(mo);
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
		return mon; 
	}
	public ArrayList<Monitor> pretragaMonitor(String search){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		ArrayList<Monitor> lo = new ArrayList<Monitor>();
		Monitor mo = null;
				
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(PRETRAGAMONITOR);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setString(1, search);
			pstm.setString(2, search);
			pstm.setString(3, search);
		
			
			pstm.execute();

//****POCETAK	AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			while(rs.next()){ // if AKO UPIT VRACA JEDAN REZULTAT
				mo = new Monitor();

				mo.setSifra(rs.getString("sifra"));
				mo.setProizvodjac(rs.getString("proizvodjac"));
				mo.setModel(rs.getString("model"));
				mo.setCena(rs.getFloat("cena"));
				mo.setTipEkrana(rs.getString("tipekrana"));
				mo.setDijagonala(rs.getInt("dijagonala"));
				mo.setSlika(rs.getString("slika"));
				mo.setGarancija(rs.getInt("garancija"));
				mo.setAkcija(rs.getString("akcija"));
				
				
				lo.add(mo);
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
		return lo; 
	}
	
	
	public flashMemorija getFLASHMemorijaID (String sifra){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		flashMemorija fm=null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
	
		
				
         try {
			con = ds.getConnection();
			pstm = con.prepareStatement(GETFLASHMEMORIJAID);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setString(1, sifra);
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			if(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				fm = new flashMemorija();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				fm.setAkcija(rs.getString("akcija"));
				fm.setSifra(rs.getString("sifra"));
				fm.setProizvodjac(rs.getString("proizvodjac"));
				fm.setModel(rs.getString("model"));
				fm.setKapacitet(rs.getString("kapacitet"));
				fm.setSlika(rs.getString("slika"));
				fm.setCena(rs.getFloat("cena"));
				
				fm.setGarancija(rs.getInt("garancija"));
				
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				
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
		return fm; 
	// DEFINICIJA OSTALIH METODA ... 
	}
	public ArrayList<flashMemorija> selectflashMemorija(){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		ArrayList<flashMemorija> lo = new ArrayList<flashMemorija>();
		flashMemorija fm = null;
				
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(SELECTFLASHMEMORIJA);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			while(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				fm = new flashMemorija();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				fm.setAkcija(rs.getString("akcija"));
				fm.setSifra(rs.getString("sifra"));
				fm.setProizvodjac(rs.getString("proizvodjac"));
				fm.setModel(rs.getString("model"));
				fm.setKapacitet(rs.getString("kapacitet"));
				fm.setSlika(rs.getString("slika"));
				fm.setCena(rs.getFloat("cena"));
				fm.setGarancija(rs.getInt("garancija"));
				
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				lo.add(fm);
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
		return lo; 
	}
	public flashMemorija getRFlasMemorija(){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		flashMemorija fm=null;
				
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(GETRFLASHMEMORIJA);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			if(rs.next()){ // if AKO UPIT VRACA JEDAN REZULTAT
				fm=new flashMemorija();

				
				fm.setAkcija(rs.getString("akcija"));
				fm.setSifra(rs.getString("sifra"));
				fm.setProizvodjac(rs.getString("proizvodjac"));
				fm.setModel(rs.getString("model"));
				fm.setSlika(rs.getString("slika"));
				fm.setKapacitet(rs.getString("kapacitet"));
				fm.setCena(rs.getFloat("cena"));
				fm.setGarancija(rs.getInt("garancija"));
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				
				
				
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
		return fm; 
	}
	public ArrayList<flashMemorija> akcijaFlashMemorija(){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		ArrayList<flashMemorija> fles = new ArrayList<flashMemorija>();
		flashMemorija fm;
				
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(AKCIJAFLASHMEMORIJA);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();
			while(rs.next()){ // if AKO UPIT VRACA JEDAN REZULTAT
				fm = new flashMemorija();

				fm.setSifra(rs.getString("sifra"));
				fm.setProizvodjac(rs.getString("proizvodjac"));
				fm.setModel(rs.getString("model"));
				fm.setCena(rs.getFloat("cena"));
				fm.setKapacitet(rs.getString("kapacitet"));
				fm.setSlika(rs.getString("slika"));
				fm.setGarancija(rs.getInt("garancija"));
				fm.setAkcija(rs.getString("akcija"));
				
				fles.add(fm);
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
		return fles; 
	}
	public ArrayList<flashMemorija> pretragaFlesMemorija(String search){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		ArrayList<flashMemorija> lo = new ArrayList<flashMemorija>();
		flashMemorija fm = null;
				
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(PRETRAGAFLASHMEMORIJA);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setString(1, search);
			pstm.setString(2, search);
			pstm.setString(3, search);
		
			
			pstm.execute();

//****POCETAK	AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			while(rs.next()){ // if AKO UPIT VRACA JEDAN REZULTAT
				fm = new flashMemorija();

				fm.setSifra(rs.getString("sifra"));
				fm.setProizvodjac(rs.getString("proizvodjac"));
				fm.setModel(rs.getString("model"));
				fm.setCena(rs.getFloat("cena"));
				fm.setKapacitet(rs.getString("kapacitet"));
				fm.setSlika(rs.getString("slika"));
				fm.setGarancija(rs.getInt("garancija"));
				fm.setAkcija(rs.getString("akcija"));
				
				
				lo.add(fm);
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
		return lo; 
	}
	
	
	public grafickaKartica getGrafickaKarticaID (String sifra){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		grafickaKartica gk=null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
	
		
				
         try {
			con = ds.getConnection();
			pstm = con.prepareStatement(GETGRAFICKAKARTICAID);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setString(1, sifra);
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			if(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				gk = new grafickaKartica();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				gk.setAkcija(rs.getString("akcija"));
				gk.setSifra(rs.getString("sifra"));
				gk.setProizvodjac(rs.getString("proizvodjac"));
				gk.setModel(rs.getString("model"));
				gk.setMemorija(rs.getString("memorija"));
				gk.setSlika(rs.getString("slika"));
				gk.setCena(rs.getFloat("cena"));
				
				gk.setGarancija(rs.getInt("garancija"));
				
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				
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
		return gk; 
	// DEFINICIJA OSTALIH METODA ... 
	}
	public ArrayList<grafickaKartica>selectgrafickaKartica(){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		ArrayList<grafickaKartica> lo = new ArrayList<grafickaKartica>();
		grafickaKartica gk = null;
				
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(SELECTGRAFICKAKARTICA);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
		
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			while(rs.next()){ // if UMESTO while AKO UPIT VRACA JEDAN REZULTAT
				// KREIRANJE INSTANCE KLASE PREKO PODRAZUMEVANOG KONSTRUKTORA
				gk = new grafickaKartica();
				// SET-OVANJE SVIH ATRIBUTA KLASE SA ODGOVARAJUCIM VREDNOSTIMA IZ RESULTSET-A rs
				gk.setAkcija(rs.getString("akcija"));
				gk.setSifra(rs.getString("sifra"));
				gk.setProizvodjac(rs.getString("proizvodjac"));
				gk.setModel(rs.getString("model"));
				gk.setMemorija(rs.getString("memorija"));
				gk.setSlika(rs.getString("slika"));
				gk.setCena(rs.getFloat("cena"));
				gk.setGarancija(rs.getInt("garancija"));
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				lo.add(gk);
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
		return lo; 
	}
	public grafickaKartica getRGrafickaKartica(){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		grafickaKartica gk=null;
				
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(GETRGRAFICKAKARTICA);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			if(rs.next()){ // if AKO UPIT VRACA JEDAN REZULTAT
				gk=new grafickaKartica();

				
				gk.setAkcija(rs.getString("akcija"));
				gk.setSifra(rs.getString("sifra"));
				gk.setProizvodjac(rs.getString("proizvodjac"));
				gk.setModel(rs.getString("model"));
				gk.setSlika(rs.getString("slika"));
				gk.setMemorija(rs.getString("memorija"));
				gk.setCena(rs.getFloat("cena"));
				gk.setGarancija(rs.getInt("garancija"));
				// DODAVANJE INSTANCE U LISTU AKO METODA VRACA LISTU, AKO NE VRACA ONDA NE TREBA 
				
				
				
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
		return gk; 
	}
	public ArrayList<grafickaKartica> akcijaGrafickaKartica(){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		ArrayList<grafickaKartica> graf = new ArrayList<grafickaKartica>();
		grafickaKartica gk;
				
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(AKCIJAGRAFICKAKARTICA);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			
			pstm.execute();

//****POCETAK AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();
			while(rs.next()){ // if AKO UPIT VRACA JEDAN REZULTAT
				gk = new grafickaKartica();

				gk.setSifra(rs.getString("sifra"));
				gk.setProizvodjac(rs.getString("proizvodjac"));
				gk.setModel(rs.getString("model"));
				gk.setCena(rs.getFloat("cena"));
				gk.setMemorija(rs.getString("memorija"));
				gk.setSlika(rs.getString("slika"));
				gk.setGarancija(rs.getInt("garancija"));
				gk.setAkcija(rs.getString("akcija"));
				
				graf.add(gk);
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
		return graf; 
	}
	public ArrayList<grafickaKartica> pretragaGrafickaKartica(String search){
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 
		ArrayList<grafickaKartica> lo = new ArrayList<grafickaKartica>();
		grafickaKartica gk = null;
				
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(PRETRAGAGRAFICKAKARTICA);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setString(1, search);
			pstm.setString(2, search);
			pstm.setString(3, search);
		
			
			pstm.execute();

//****POCETAK	AKO UPIT VRACA REZULTAT TREBA SLEDECI DEO 
			rs = pstm.getResultSet();

			while(rs.next()){ // if AKO UPIT VRACA JEDAN REZULTAT
				gk = new grafickaKartica();

				gk.setSifra(rs.getString("sifra"));
				gk.setProizvodjac(rs.getString("proizvodjac"));
				gk.setModel(rs.getString("model"));
				gk.setCena(rs.getFloat("cena"));
				gk.setMemorija(rs.getString("memorija"));
				gk.setSlika(rs.getString("slika"));
				gk.setGarancija(rs.getInt("garancija"));
				gk.setAkcija(rs.getString("akcija"));
				
				
				lo.add(gk);
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
		return lo; 
	}

}



	

 
