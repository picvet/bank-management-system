package system;

import java.util.ArrayList;

public class AccountManager {

      Account account;
	 ArrayList<Account> listAccount;

	public AccountManager() {
		this.account = new Account();
		this.listAccount = new ArrayList<>();
	}

	

	public void createAccount(Account account, ArrayList<Account> listAccount) {
		listAccount.add(account);
	}

	public String printDetails(String username, ArrayList<Account> listAccount) {
		for (Account f : listAccount)
			if (f.getCustomer().getCustomer_username().equals(username))
				return "Username :" + f.getCustomer().getCustomer_username() + "ID: "
						+ f.getCustomer().getCustomer_id();

		return null;
	}

}
