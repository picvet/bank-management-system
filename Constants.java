package system;

public interface Constants {
	
	//STRING CONSTRAINTS
	
	//account
	String INTEREST_RATE_ERROR = "Interest rate is invalid!";
	String ACCOUNT_ID_ERROR = "Account ID is invalid!";
	String ACCOUNT_TYPE_ERROR = "Account type is invalid!";
	String ACCOUNT_NUMBER_ERROR = "Account number is invalid!";
	String BALANCE_ERROR = "Amount invalid!";
	String DESC_ERROR = "Description is invalid!";
	
	//address
	String STREET_NAME_ERROR = "Street name is invalid!";
	String STREET_NUMBER_ERROR = "Street number is invalid!";
	String ZIP_CODE_ERROR = "Zip code is invalid!";
	
	//contact
	String CONTACT_NUMBER_ERROR = "Contact number is invalid!";
	String EMAIL_ERROR = "Email is invalid!";
	
	//customer
	String GENDER_ERROR = "Gender is invalid!";
	String CUS_ID_ERROR = "ID is invalid!";
	String CUS_NAME_ERROR = "Name is invalid!";
	String CUS_PASSWORD_ERROR = "Password is invalid!";
	String CUS_USERNAME_ERROR = "Usename is invalid!";
	
	//DOUBLE CONSTRAINTS
	double MIN_INTEREST = 0.00;
	double MAX_INTEREST = 20.00;
	
	
	//INT CONSTRAINTS
	int LEN = 0;
	int ACCOUNT_NUM = 5;
	int MIN_ZIP_CODE = 3;
	int MAX_ZIP_CODE = 5;
	
	//contact
	int MIN_CUS_NUM = 4;
	int MAX_CUS_NUM = 13;
	
	//customer
	int CUS_ID_FIN = 7;
	int CUS_PASS_MIN = 4;

}
