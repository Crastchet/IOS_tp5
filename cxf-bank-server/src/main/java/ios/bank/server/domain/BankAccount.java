package ios.bank.server.domain;

public class BankAccount {

	protected Customer customer;
	protected double balance;
	protected boolean settled;
	
	public BankAccount() {}
	
	public BankAccount(Customer c) {
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
	
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public double settle() {
		this.settled = true;
		double to_Return = this.getBalance();
		this.balance = 0;
		return to_Return;
	}
	
}
