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

	public void setInterest_rate(double interest_rate) {
		this.interest_rate = interest_rate;
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

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public String getAccount_number() {
		return account_number;
	}

	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

}
