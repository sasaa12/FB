package rs.FB;

public class Token {
	private String token;
	private String ID;
	
	public Token(String token, String iD) {
		super();
		this.token = token;
		this.ID = iD;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public Token(){
		
	}

	public Token(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	

}
