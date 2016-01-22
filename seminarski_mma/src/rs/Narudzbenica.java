package rs;

import java.sql.Timestamp;

public class Narudzbenica {
	
	private int id;
	private String ime;
	private float cena;
	
	private Timestamp vreme;

	public Narudzbenica(int id, String ime, float cena,
			Timestamp vreme) {
		super();
		this.id = id;
		this.ime = ime;
		
		this.cena = cena;
		this.vreme = vreme;
	}

	public Narudzbenica() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}



	public float getCena() {
		return cena;
	}

	public void setCena(float cena) {
		this.cena = cena;
	}

	public Timestamp getVreme() {
		return vreme;
	}

	public void setVreme(Timestamp vreme) {
		this.vreme = vreme;
	}
	
	
	
	

}
