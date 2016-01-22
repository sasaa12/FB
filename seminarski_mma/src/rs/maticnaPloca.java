package rs;

public class maticnaPloca {
	
	private String sifra,proizvodjac,model,socket,maxmemorija,akcija,slika;
	private int garancija;
	private float cena;
	
	public maticnaPloca(String sifra, String proizvodjac, String model,
			String socket, String maxmemorija, String akcija, String slika,
			int garancija, float cena) {
		super();
		this.sifra = sifra;
		this.proizvodjac = proizvodjac;
		this.model = model;
		this.socket = socket;
		this.maxmemorija = maxmemorija;
		this.akcija = akcija;
		this.slika = slika;
		this.garancija = garancija;
		this.cena = cena;
	}

	public maticnaPloca() {
		super();
		// TODO Auto-generated constructor stub
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

	public String getSocket() {
		return socket;
	}

	public void setSocket(String socket) {
		this.socket = socket;
	}

	public String getMaxmemorija() {
		return maxmemorija;
	}

	public void setMaxmemorija(String maxmemorija) {
		this.maxmemorija = maxmemorija;
	}

	public String getAkcija() {
		return akcija;
	}

	public void setAkcija(String akcija) {
		this.akcija = akcija;
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

	public float getCena() {
		return cena;
	}

	public void setCena(float cena) {
		this.cena = cena;
	}
	
	
	
	

}
