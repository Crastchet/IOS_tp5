package ios.bank.database;

import java.util.ArrayList;

import ios.bank.server.domain.BankAccount;
import ios.bank.server.domain.Customer;

public final class DataBase {
	
	private ArrayList<Customer> customers;
	private ArrayList<BankAccount> bankAccounts; 
	
	
	private static DataBase DB;
	private DataBase() { 
		this.customers = new ArrayList<Customer>();
		this.bankAccounts = new ArrayList<>();
	}
	
	public static DataBase instanceDataBase() {
		if(DB == null )
			return new DataBase();
		return DB;
	}
	
	
	public void addCustomer(Customer customer) {
		this.customers.add(customer);
	}
	
	public void removeCustomer(Customer customer) {
		this.customers.remove(customer);
	}
	
	public void addBankAccount(BankAccount bankAccount) {
		this.bankAccounts.add(bankAccount);
	}
	
	public void removeBankAccount(BankAccount bankAccount) {
		this.bankAccounts.remove(bankAccount);
	}
}
