package rs;

public class Tastatura {
	
	private String sifra,proizvodjac,model,tip,akcija,slika;
	private float cena;
	private int garancija;
	public Tastatura(String sifra, String proizvodjac, String model,
			String tip, String akcija, String slika, float cena, int garancija) {
		super();
		this.sifra = sifra;
		this.proizvodjac = proizvodjac;
		this.model = model;
		this.tip = tip;
		this.akcija = akcija;
		this.slika = slika;
		this.cena = cena;
		this.garancija = garancija;
	}
	public Tastatura() {
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
	
	
	
	

}
