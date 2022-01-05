package system;

public class Contact implements Constants{
	
	private String customer_number;
	private String email;
	
	public Contact() {
		this.customer_number = "";
		this.email = "";
	}

	public Contact(String customer_number, String email) throws AccountException { 
		setCustomer_number(customer_number);
		setEmail(email);
	}

	public String getCustomer_number() {
		return customer_number;
	}

	public void setCustomer_number(String customer_number) throws AccountException {
		if(checkNumber(customer_number))
			this.customer_number = customer_number;
		else
			throw new AccountException(CONTACT_NUMBER_ERROR);
		
	}

	private boolean checkNumber(String customer_number) {
		return customer_number.length() >= MIN_CUS_NUM && customer_number.length() <= MAX_CUS_NUM;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws AccountException {
		if(checkEmail(email))
			this.email = email;
		else
			throw new AccountException(EMAIL_ERROR);
		
	}

	private boolean checkEmail(String email) {
		return email.contains("@") || email.contains(".") || email.length() > ACCOUNT_NUM;
	}

}
