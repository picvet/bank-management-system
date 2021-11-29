package system;

public class Customer{
  
 private int customer_id;
 private String customer_name;
 private Contact customer_contact;
 private String customer_password;
 private Address customer_address;
 private String customer_username;

 public Customer(){
  this.customer_id = 00000;
  this.customer_name = "";
  this.customer_contact = new Contact();
  this.customer_password = "";
  this.customer_address = new Address();
  this.customer_username = "";
 }

 public Customer(int customer_id, String customer_name,
     Contact customer_contact, String customer_password
     ,Address customer_address, String customer_username){
  this.customer_id = customer_id;
  this.customer_name = customer_name;
  this.customer_contact = customer_contact;
  this.customer_password = customer_password;
  this.customer_address = customer_address;
  this.customer_username = customer_username;
 }

public int getCustomer_id() {
	return customer_id;
}

public void setCustomer_id(int customer_id) throws AccountException {
	if(checkCustomerID(customer_id))
		this.customer_id = customer_id;
	else
		throw new AccountException("Customer ID must have 5 characters");
}

private boolean checkCustomerID(int customer_id) {
	return Integer.toString(customer_id).length() == 5;
}

public String getCustomer_name() {
	return customer_name;
}

public void setCustomer_name(String customer_name) throws AccountException {
	if(checkName(customer_name))
		this.customer_name = customer_name;
	else
		throw new AccountException("Name can't be left empty!");
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
		throw new AccountException("Password length must be 7 characters or more!");
}

private boolean checkPassword(String customer_password) {
	return (customer_password.length() > 6);
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
		throw new AccountException("Username can't be empty!");
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
