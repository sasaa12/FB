package rs;

public class flashMemorija {
	
		private String sifra,proizvodjac,model,kapacitet,akcija,slika;
		private float cena;
		private int garancija;
		
		public flashMemorija() {
			super();
			// TODO Auto-generated constructor stub
		}

		public flashMemorija(String sifra, String proizvodjac, String model,
				String kapacitet, String akcija, String slika, float cena,
				int garancija) {
			super();
			this.sifra = sifra;
			this.proizvodjac = proizvodjac;
			this.model = model;
			this.kapacitet = kapacitet;
			this.akcija = akcija;
			this.slika = slika;
			this.cena = cena;
			this.garancija = garancija;
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
