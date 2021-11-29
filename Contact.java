package system;

public class Contact {
	
	private String customer_number;
	private String email;
	
	public Contact() {
		this.customer_number = "";
		this.email = "";
	}

	public Contact(String customer_number, String email) {
		super();
		this.customer_number = customer_number;
		this.email = email;
	}

	public String getCustomer_number() {
		return customer_number;
	}

	public void setCustomer_number(String customer_number) throws AccountException {
		if(checkNumber(customer_number))
			this.customer_number = customer_number;
		else
			throw new AccountException("Cellphone must have 10 characters!");
	}

	private boolean checkNumber(String customer_number) { 
		return customer_number.length() == 10;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws AccountException {
		if(checkEmail(email))
			this.email = email;
		else
			throw new AccountException("Enter valid email!");
	}

	private boolean checkEmail(String email) {
		return email.contains("@") && email.contains(".");
	}

}
