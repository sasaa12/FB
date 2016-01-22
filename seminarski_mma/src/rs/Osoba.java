package rs;

public class Osoba {
	
	private int idosobe;
	private String korisnickoIme,email,sifra;
	private String statusLogovanja;
	
	

	public Osoba(String korisnickoIme, String email, String sifra) {
		super();
		this.korisnickoIme = korisnickoIme;
		this.email = email;
		this.sifra = sifra;
	}

	public Osoba() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdosobe() {
		return idosobe;
	}

	public void setIdosobe(int idosobe) {
		this.idosobe = idosobe;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public String getStatusLogovanja() {
		return statusLogovanja;
	}

	public void setStatusLogovanja(String statusLogovanja) {
		this.statusLogovanja = statusLogovanja;
	}
	
	
	

}
