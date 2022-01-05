package system;

public class Address implements Constants{
	
	private String street_name;
	private int street_number;
	private String zip_code;
	
	public Address() {
		this.street_name = "";
		this.street_number = 0000;
		this.zip_code = "";
	}

	public Address(String street_name, int street_number, String zip_code) throws AccountException { 
		setStreet_name(street_name);
		setStreet_number(street_number);
		setZip_code(zip_code);
	}

	public String getStreet_name() {
		return street_name;
	}

	public void setStreet_name(String street_name) throws AccountException {
		if(checkName(street_name))
			this.street_name = street_name;
		else
			throw new AccountException(STREET_NAME_ERROR);
		
	}

	private boolean checkName(String street_name) {
		return street_name != null;
	}

	public int getStreet_number() {
		return street_number;
	}

	public void setStreet_number(int street_number) throws AccountException {
		if(checkNumber(street_number))
			this.street_number = street_number;
		else
			throw new AccountException(STREET_NUMBER_ERROR);
	}

	private boolean checkNumber(int street_number) {
		return street_number > LEN;
	}

	public String getZip_code() {
		return zip_code;
	}

	public void setZip_code(String zip_code) throws AccountException {
		if(checkZip(zip_code))
			this.zip_code = zip_code;
		else
			throw new AccountException(ZIP_CODE_ERROR);
	}

	private boolean checkZip(String zip_code) {
		return zip_code.length() >= MIN_ZIP_CODE && zip_code.length() <= MAX_ZIP_CODE;
	}
	
	

}
