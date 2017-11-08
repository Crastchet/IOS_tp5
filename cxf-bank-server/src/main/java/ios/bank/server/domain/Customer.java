package ios.bank.server.domain;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Customer {

	private String firstname;
	private String lastname;
	private Calendar birth;
	private Set<BankAccount> accounts;
	
	public Customer(String fn, String ln, Calendar b) {
		this.firstname = fn;
		this.lastname = ln;
		this.birth = b;
		this.accounts = new HashSet<BankAccount>();
	}
	
	public void addAccount(BankAccount account) {
		this.accounts.add(account);
	}

}
