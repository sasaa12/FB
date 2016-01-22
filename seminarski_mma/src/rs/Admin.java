package rs;

public class Admin {
	
	private int id;
	private String korisnickoime;
	private String sifra;
	
	public Admin(String korisnickoime, String sifra) {
		super();
		this.korisnickoime = korisnickoime;
		this.sifra = sifra;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getKorisnickoime() {
		return korisnickoime;
	}
	public void setKorisnickoime(String korisnickoime) {
		this.korisnickoime = korisnickoime;
	}
	public String getSifra() {
		return sifra;
	}
	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
