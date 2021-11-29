package system;

import java.util.*;

public class AccountApp {

	
	
	public static void main(String[] args) {
		
		AccountManager man = new AccountManager();
		
		ArrayList<Account> listAccount = new ArrayList<>();
		
		Account a = new Account(
				12345, 
				"savings",
				"098765432135",
				999.00,
				6.75,
				"description",
				new Customer(
						3456, 
						"TIme JOhnson",
						new Contact(
								"9087657546",
								"email.com"),
						"password1234", 
						new Address(
								"street name",
								34,
								"ZIP45"),
						"myUsername"));
		
		try {
			man.createAccount(a, listAccount);
			String username = "myUsername";
			String sol = man.printDetails(username, listAccount);
			System.out.println(sol);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
