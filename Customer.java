package system;

public class Customer implements Constants{
  
 private String customer_id;
 private String customer_name;
 private Contact customer_contact;
 private String customer_password;
 private Address customer_address;
 private String customer_username;
 private String gender;

 public Customer(){
  this.customer_id = "";
  this.customer_name = "";
  this.customer_contact = new Contact();
  this.customer_password = "";
  this.customer_address = new Address();
  this.customer_username = "";
  this.gender= "";
 }

 public Customer(String customer_id, String customer_name,
     Contact customer_contact, String customer_password
     ,Address customer_address, String customer_username, String gender) throws AccountException{
	 
  setCustomer_id(customer_id);
  setCustomer_name(customer_name);
  setCustomer_contact(customer_contact);
  setCustomer_password(customer_password);
  setCustomer_address(customer_address);
  setCustomer_username(customer_username);
  setGender(gender);
  
 }

public String getGender() {
	return gender;
}

public void setGender(String gender) throws AccountException {
	if(checkGender(gender))
		this.gender = gender;
	else
		throw new AccountException(GENDER_ERROR);
}

private boolean checkGender(String gender) {
	return gender.equalsIgnoreCase("male") || gender.equalsIgnoreCase("female") || gender != null;
}

public String getCustomer_id() {
	return customer_id;
}

public void setCustomer_id(String customer_id) throws AccountException {
	if(checkID(customer_id))
		this.customer_id = customer_id;
	else
		throw new AccountException(CUS_ID_ERROR);
	
}

private boolean checkID(String customer_id) {
	return customer_id.length() == CUS_ID_FIN;
}

public String getCustomer_name() {
	return customer_name;
}

public void setCustomer_name(String customer_name) throws AccountException {
	if(checkName(customer_name))
		this.customer_name = customer_name;
	else
		throw new AccountException(CUS_NAME_ERROR);
	
}

private boolean checkName(String customer_name) {
	return customer_name != null;
}

public Contact getCustomer_contact() {
	return customer_contact;
}

public void setCustomer_contact(Contact customer_contact) {
	this.customer_contact = customer_contact;
}

public String getCustomer_password() {
	return customer_password;
}

public void setCustomer_password(String customer_password) throws AccountException {
	if(checkPassword(customer_password))
		this.customer_password = customer_password;
	else
		throw new AccountException(CUS_PASSWORD_ERROR);
	
}

private boolean checkPassword(String customer_password) {
	return customer_password.length() > LEN;
}

public Address getCustomer_address() {
	return customer_address;
}

public void setCustomer_address(Address customer_address) {
		this.customer_address = customer_address;
	
}

public String getCustomer_username() {
	return customer_username;
}

public void setCustomer_username(String customer_username) throws AccountException {
	if(checkUsername(customer_username))
		this.customer_username = customer_username;
	else
		throw new AccountException(CUS_USERNAME_ERROR);
	
}

 private boolean checkUsername(String customer_username) {
	return customer_username != null;
}

@Override
	public String toString() {
		return getCustomer_name() + "#" + getCustomer_username() + "#" +
				getCustomer_password() + "#" + getCustomer_id() + "#" + 
				getCustomer_address().getStreet_name() + "#" + 
				getCustomer_address().getStreet_number() + "#" +
				getCustomer_address().getZip_code() + "#" +
				getCustomer_contact().getCustomer_number() + "#" +
				getCustomer_contact().getEmail();
	}

}
