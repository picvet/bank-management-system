package system;

import java.util.ArrayList;

public class AccountManager {

	public AccountManager() {
	}


	public void createAccount(Account account, ArrayList<Account> listAccount) {
		listAccount.add(account);
	}

	public String printDetails(String username, ArrayList<Account> listAccount) {
		for (Account f : listAccount)
			if (f.getCustomer().getCustomer_username().equals(username))
				return "Username :" + f.getCustomer().getCustomer_username() + "\t\tID: "
						+ f.getCustomer().getCustomer_id();

		return "account not found!";
	}

}
