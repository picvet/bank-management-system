package system;

import java.util.*;

public class AccountApp {

	
	
	public static void main(String[] args) {
		
		AccountManager man = new AccountManager();
		
		ArrayList<Account> listAccount = new ArrayList<>();
		
		try {
			man.createAccount(new Account(), listAccount);
			String username = "username";
			man.printDetails(username, listAccount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
