package ios.bank.server.domain;

public abstract class BankAccount {

	private Customer customer;
	private double balance;
	
	protected BankAccount(Customer c) {
		this.customer = c;
	}
}
