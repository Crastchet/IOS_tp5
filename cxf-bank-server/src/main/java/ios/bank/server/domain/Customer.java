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
	
	public void removeBankAccount(BankAccount account) {
		this.accounts.remove(account);
	}

	public Set<BankAccount> getAccounts() {
		return this.accounts;
	}
	
	public String getFirstName() {
		return this.firstname;
	}
	
	public String getLastName() {
		return this.lastname;
	}
	
	public Calendar getBirth() {
		return this.birth;
	}
	
	/**
	 * Customers comparison based on firstname, lastname, birth
	 */
	@Override
	public boolean equals(Object o) {
		return
				this.getFirstName() == ((Customer)o).getFirstName()
			&&	this.getLastName() == ((Customer)o).getLastName()
			&&	this.getBirth().equals( ((Customer)o).getBirth() );
	}
}
