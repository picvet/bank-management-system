package system;

public class Address {
	
	private String street_name;
	private int street_number;
	private String zip_code;
	
	public Address() {
		this.street_name = "";
		this.street_number = 0000;
		this.zip_code = "";
	}

	public Address(String street_name, int street_number, String zip_code) { 
		this.street_name = street_name;
		this.street_number = street_number;
		this.zip_code = zip_code;
	}

	public String getStreet_name() {
		return street_name;
	}

	public void setStreet_name(String street_name) throws AccountException {
		if(checkStreetName(street_name))
			this.street_name = street_name;
		else
			throw new AccountException("Street name is required");
	}

	private boolean checkStreetName(String street_name) { 
		return street_name != null;
	}

	public int getStreet_number() {
		return street_number;
	}

	public void setStreet_number(int street_number) throws AccountException {
		if(checkStreetNumber(street_number))
			this.street_number = street_number;
		else
			throw new AccountException("Street number is required!");
	}

	private boolean checkStreetNumber(int street_number) { 
		return Integer.toString(street_number).length() > 0;
	}

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) throws AccountException {
		if(checkZipCode(zip_code))
			this.zip_code = zip_code;
		else
			throw new AccountException("Zip code must be correct!");
	}

	private boolean checkZipCode(String zip_code) {
		return zip_code.length() >2 && zip_code.length() < 6;
	}
	
	

}
