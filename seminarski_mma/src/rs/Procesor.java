package rs;

public class Procesor {
	
	private String sifra;
	private String proizvodjac,model;
	private float cena;
	private String radniTakt,socket,slika,akcija;
	private int garancija;
	
	public Procesor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Procesor(String sifra, String proizvodjac, String model, float cena,
			String radniTakt, String socket, String slika, int garancija,
			String akcija) {
		super();
		this.sifra = sifra;
		this.proizvodjac = proizvodjac;
		this.model = model;
		this.cena = cena;
		this.radniTakt = radniTakt;
		this.socket = socket;
		this.slika = slika;
		this.garancija = garancija;
		this.akcija = akcija;
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public String getProizvodjac() {
		return proizvodjac;
	}

	public void setProizvodjac(String proizvodjac) {
		this.proizvodjac = proizvodjac;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public float getCena() {
		return cena;
	}

	public void setCena(float cena) {
		this.cena = cena;
	}

	public String getRadniTakt() {
		return radniTakt;
	}

	public void setRadniTakt(String radniTakt) {
		this.radniTakt = radniTakt;
	}

	public String getSocket() {
		return socket;
	}

	public void setSocket(String socket) {
		this.socket = socket;
	}

	public String getSlika() {
		return slika;
	}

	public void setSlika(String slika) {
		this.slika = slika;
	}

	public int getGarancija() {
		return garancija;
	}

	public void setGarancija(int garancija) {
		this.garancija = garancija;
	}

	public String getAkcija() {
		return akcija;
	}

	public void setAkcija(String akcija) {
		this.akcija = akcija;
	}

	
	
	
	
	
}
