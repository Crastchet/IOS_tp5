package ios.bank.server.domain;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Customer {

	private String firstname;
	private String lastname;
	private Calendar birth;
	private Set<BankAccount> accounts;
	
	public Customer() {
		
	}
	
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
	
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setBirth(Calendar birth) {
		this.birth = birth;
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
				this.getFirstname().equals( ((Customer)o).getFirstname() )
			&&	this.getLastname().equals( ((Customer)o).getLastname() )
			&&	this.getBirth().getTimeInMillis() ==( ((Customer)o).getBirth().getTimeInMillis() );
	}
	
	@Override
	public String toString() {
		return "Firstname : " + this.firstname + "\nLastName : " + this.lastname + "\nBirth : " + this.getBirth().YEAR + "/" + this.getBirth().MONTH + "/" + this.getBirth().DAY_OF_MONTH;
	}
}
