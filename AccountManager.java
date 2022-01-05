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

}
