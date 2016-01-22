package rs;

public class Monitor {
	
	private String sifra,proizvodjac,model;
	private float cena;
	private int dijagonala;
	private String tipEkrana,slika;
	private int garancija;
	private String akcija;
	
	public Monitor() {
		super();
		
	}

		public Monitor(String sifra, String proizvodjac, String model, float cena,
			int dijagonala, String tipEkrana, String slika, int garancija,
			String akcija) {
		super();
		this.sifra = sifra;
		this.proizvodjac = proizvodjac;
		this.model = model;
		this.cena = cena;
		this.dijagonala = dijagonala;
		this.tipEkrana = tipEkrana;
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

	public String getTipEkrana() {
		return tipEkrana;
	}

	public void setTipEkrana(String tipEkrana) {
		this.tipEkrana = tipEkrana;
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

	public float getCena() {
		return cena;
	}

	public void setCena(float cena) {
		this.cena = cena;
	}

	public int getGarancija() {
		return garancija;
	}

	public void setGarancija(int garancija) {
		this.garancija = garancija;
	}
	
	public int getDijagonala() {
		return dijagonala;
	}

	public void setDijagonala(int dijagonala) {
		this.dijagonala = dijagonala;
	}
	
	
	
	
}
