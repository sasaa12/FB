package rs;

public class grafickaKartica {

	private String sifra,proizvodjac,model,memorija,akcija,slika;
	private int garancija;
	private float cena;
	
	public grafickaKartica() {
		super();
		// TODO Auto-generated constructor stub
	}

	public grafickaKartica(String sifra, String proizvodjac, String model,
			String memorija, String akcija, String slika, int garancija,
			float cena) {
		super();
		this.sifra = sifra;
		this.proizvodjac = proizvodjac;
		this.model = model;
		this.memorija = memorija;
		this.akcija = akcija;
		this.slika = slika;
		this.garancija = garancija;
		this.cena = cena;
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

	public String getMemorija() {
		return memorija;
	}

	public void setMemorija(String memorija) {
		this.memorija = memorija;
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
