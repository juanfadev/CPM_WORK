package logic;

public class Usuario {

	private String username;
	private String password;
	
	private String name;
	private String surname;
	private String ID;
	private String phoneNumber;
	private String paypalAccount;
	private String email;
	

	public Usuario(String username, String password, String name, String surname, String iD, String phoneNumber,
			String email) {
		super();
		this.username = username;
		this.password = password;
		//in IGU create another field for password comprobation, and take into account if they are equal before storing.
		this.name = name;
		this.surname = surname;
		ID = iD;
		this.phoneNumber = phoneNumber;
		this.email = email;
		//Paypal Account is optional.
	}
	
	public boolean isUserCorrect(String user, String pass){
		return (user.equalsIgnoreCase(username)&& pass.equals(password));
	}
	
	
	
}
