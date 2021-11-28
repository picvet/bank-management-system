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

	public String getStreet_name() {
		return street_name;
	}

	public void setStreet_name(String street_name) {
		this.street_name = street_name;
	}

	public int getStreet_number() {
		return street_number;
	}

	public void setStreet_number(int street_number) {
		this.street_number = street_number;
	}

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	
	

}
