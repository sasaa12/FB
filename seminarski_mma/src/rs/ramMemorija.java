package rs;

public class ramMemorija {
	
	private String sifra,proizvodjac,model,brzinaRada,kapacitet,tip,akcija,slika;
	private int garancija;
	private float cena;
	
	

	public ramMemorija() {
		super();
		// TODO Auto-generated constructor stub
	}



	public ramMemorija(String sifra, String proizvodjac, String model,
			String brzinaRada, String kapacitet, String tip, String akcija,
			String slika, int garancija, float cena) {
		super();
		this.sifra = sifra;
		this.proizvodjac = proizvodjac;
		this.model = model;
		this.brzinaRada = brzinaRada;
		this.kapacitet = kapacitet;
		this.tip = tip;
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



	public String getBrzinaRada() {
		return brzinaRada;
	}



	public void setBrzinaRada(String brzinaRada) {
		this.brzinaRada = brzinaRada;
	}



	public String getKapacitet() {
		return kapacitet;
	}



	public void setKapacitet(String kapacitet) {
		this.kapacitet = kapacitet;
	}



	public String getTip() {
		return tip;
	}



	public void setTip(String tip) {
		this.tip = tip;
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
