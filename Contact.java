package system;

public class Contact {
	
	private String customer_number;
	private String email;
	
	public Contact() {
		this.customer_number = "";
		this.email = "";
	}

	public String getCustomer_number() {
		return customer_number;
	}

	public void setCustomer_number(String customer_number) {
		this.customer_number = customer_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
