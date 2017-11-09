package ios.bank.server.domain;

public abstract class BankAccount {

	protected Customer customer;
	protected double balance;
	protected boolean settled;
	
	protected BankAccount(Customer c) {
		this.customer = c;
		this.balance = 0;
		this.settled = false;
	}
	
	public void creditMoney(double amount) {
		this.balance += amount;
	}
	
	public void debitMoney(double amount) {
		this.balance -= amount;
	}
	
	public Customer getCustomer() {
		return this.customer;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public double settle() {
		this.settled = true;
		double to_Return = this.getBalance();
		this.balance = 0;
		return to_Return;
	}
}
