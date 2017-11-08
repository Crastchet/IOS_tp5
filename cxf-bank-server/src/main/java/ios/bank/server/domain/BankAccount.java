package ios.bank.server.domain;

public abstract class BankAccount {

	private Customer customer;
	private double balance;
	
	protected BankAccount(Customer c) {
		this.customer = c;
		this.balance = 0;
	}
	
	public void creditMoney(double amount) {
		this.balance += amount;
	}
	
	public void debitMoney(double amount) {
		this.balance -= amount;
	}
	
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public double getBalance() {
		return this.balance;
	}
}
