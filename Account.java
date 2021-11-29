package system;

public class Account {
	
	private int account_id;
	private String account_type;
	private String account_number;
	private double balance;
	private String description;
	private Customer customer;
	private double interest_rate;
	
	public Account() {
		this.account_id = 0000;
		this.account_type = "";
		this.account_number = "";
		this.balance = 000.00;
		this.interest_rate = 00.00;
		this.description = "";
		this.customer = new Customer();
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
	 */
	public Account(int account_id, String account_type, 
			String account_number, double balance,double interest_rate,
			String description, Customer customer) {
		super();
		this.account_id = account_id;
		this.account_type = account_type;
		this.account_number = account_number;
		this.balance = balance;
		this.description = description;
		this.customer = customer;
		this.interest_rate = interest_rate;
	}
	

	public double getInterest_rate() {
		return interest_rate;
	}

	public void setInterest_rate(double interest_rate) throws AccountException {
		if(checkInterestRate(interest_rate))
			this.interest_rate = interest_rate;
		else
			throw new AccountException("Interest rate must be valid");
	}

	private boolean checkInterestRate(double interest_rate) { 
		return ((interest_rate > 0.00) && (interest_rate < 100.00));
	}


	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) throws AccountException {
		if(checkAccountID(account_id))
			this.account_id = account_id;
		else
			throw new AccountException("Account ID must be 5 characters!");
	}

	private boolean checkAccountID(int account_id) { 
		return Integer.toString(account_id).length() == 5;
	}


	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) throws AccountException {
		if(checkAccountType(account_type))
			this.account_type = account_type;
		else
			throw new AccountException("Account type must be entered!");
	}

	private boolean checkAccountType(String account_type) {
		return account_type != null;
	}


	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) throws AccountException {
		if(checkAccountNumber(account_number))
			this.account_number = account_number;
		throw new AccountException("Account number must be 7 characters!");
	}

	private boolean checkAccountNumber(String account_number) { 
		return account_number.length() == 7;
	}


	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) throws AccountException {
		if(checkBalance(balance))
			this.balance = balance;
		else
			throw new AccountException("Balance has to be greater than 0!");
	}

	private boolean checkBalance(double balance) {
		return balance > 0;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) throws AccountException {
		if(checkDescription(description))
			this.description = description;
		throw new AccountException("Can't leave description empty!");
	}


	private boolean checkDescription(String description) {
		return description != null && description.length() > 0;
	}

}
