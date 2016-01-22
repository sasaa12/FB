package rs;

public class hardDisk {
	
	private String sifra,tip,proizvodjac,kapacitet,akcija,slika;
	private int garancija;
	private float cena;
	
	public hardDisk() {
		super();
		// TODO Auto-generated constructor stub
	}
	public hardDisk(String sifra, String tip, String proizvodjac,
			String kapacitet, String akcija, String slika, int garancija,
			float cena) {
		super();
		this.sifra = sifra;
		this.tip = tip;
		this.proizvodjac = proizvodjac;
		this.kapacitet = kapacitet;
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
	public String getTip() {
		return tip;
	}
	public void setTip(String tip) {
		this.tip = tip;
	}
	public String getProizvodjac() {
		return proizvodjac;
	}
	public void setProizvodjac(String proizvodjac) {
		this.proizvodjac = proizvodjac;
	}
	public String getKapacitet() {
		return kapacitet;
	}
	public void setKapacitet(String kapacitet) {
		this.kapacitet = kapacitet;
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
