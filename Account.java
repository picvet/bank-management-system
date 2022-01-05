package system;

public class Account implements Constants{
	
	private int account_id;
	private String account_type;
	private String account_number;
	private double balance;
	private String description;
	private double interest_rate;
	
	public Account() {
		this.account_id = 0000;
		this.account_type = "";
		this.account_number = "";
		this.balance = 000.00;
		this.interest_rate = 00.00;
		this.description = "";
	}

	
	/**
	 * Creating an account using paramerized inputs
	 * @param account_id, unique identifier for the account
	 * @param account_type, can be saving, debit or credit
	 * @param account_number, 6 digits number
	 * @param balance, how much an account has
	 * @param interest_rate, how much percentage a user will get
	 * @param description, reason of opening that account
	 * @param customer, details of the account holder
	 * @throws AccountException 
	 */
	public Account(int account_id, String account_type, 
			String account_number, double balance,double interest_rate,
			String descriptionr) throws AccountException { 
		
		setAccount_id(account_id);
		setAccount_type(account_type);
		setAccount_number(account_number);
		setBalance(balance);
		setDescription(descriptionr);
		setInterest_rate(interest_rate);
	}
	

	public double getInterest_rate() {
		return interest_rate;
	}

	public void setInterest_rate(double interest_rate) throws AccountException {
		if(checkRate(interest_rate))
			this.interest_rate = interest_rate;
		else
			throw new AccountException(INTEREST_RATE_ERROR);
	}

	private boolean checkRate(double interest_rate) {
		return interest_rate > MIN_INTEREST && interest_rate < MAX_INTEREST;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) throws AccountException {
		if(checkID(account_id))
			this.account_id = account_id;
		else
			throw new AccountException(ACCOUNT_ID_ERROR);
		
	}

	private boolean checkID(int account_id) {
		return account_id != LEN;
	}


	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) throws AccountException {
			if(checkType(account_type))
				this.account_type = account_type;
			else
				throw new AccountException(ACCOUNT_TYPE_ERROR);
	}

	private boolean checkType(String account_type) {
		return account_type != null;
	}


	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) throws AccountException {
		if(checkNumber(account_number))
			this.account_number = account_number;
		else
			throw new AccountException(ACCOUNT_NUMBER_ERROR);
	}

	private boolean checkNumber(String account_number) {
		return account_number.length() == ACCOUNT_NUM;
	}


	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) throws AccountException {
		if(checkBalance(balance))
			this.balance = balance;
		else
			throw new AccountException(BALANCE_ERROR);
		
	}

	private boolean checkBalance(double balance) {
		return (balance >= LEN);
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) throws AccountException {
		if(checkDesc(description))
			this.description = description;
		else 
			throw new AccountException(DESC_ERROR);
	}


	private boolean checkDesc(String description) {
		return description != null;
	}
	

}
