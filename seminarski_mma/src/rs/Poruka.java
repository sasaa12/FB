package rs;

public class Poruka {
	private int idporuke;
private String ime;
private String email;
private String tema;
private String poruka;
public Poruka(String ime, String email, String tema, String poruka) {
	super();
	this.ime = ime;
	this.email = email;
	this.tema = tema;
	this.poruka = poruka;
}
public Poruka(){
	ime = "";
	email = "";
	tema = "";
	poruka = "";
}

public int getIdporuke() {
	return idporuke;
}
public void setIdporuke(int idporuke) {
	this.idporuke = idporuke;
}
public String getIme() {
	return ime;
}
public void setIme(String ime) {
	this.ime = ime;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getTema() {
	return tema;
}
public void setTema(String tema) {
	this.tema = tema;
}
public String getPoruka() {
	return poruka;
}
public void setPoruka(String poruka) {
	this.poruka = poruka;
}


}
