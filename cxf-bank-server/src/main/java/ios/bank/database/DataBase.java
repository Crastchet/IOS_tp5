package ios.bank.database;

import java.util.ArrayList;
import java.util.Calendar;

import ios.bank.server.domain.BankAccount;
import ios.bank.server.domain.BankAccountCheques;
import ios.bank.server.domain.BankAccountLivretA;
import ios.bank.server.domain.BankAccountLivretDeveloppementDurable;
import ios.bank.server.domain.BankAccountLivretJeune;
import ios.bank.server.domain.Customer;

public final class DataBase {
	
	private ArrayList<Customer> customers;
	private ArrayList<BankAccount> bankAccounts;
	private enum accountsTypesEnum { CHEQUES, LIVRET_A, LIVRET_JEUNE, LIVRET_DEVELOPPEMENT_DURABLE };
	
	private static DataBase DB;
	private DataBase() { 
		this.customers = new ArrayList<Customer>();
		this.bankAccounts = new ArrayList<>();
	}
	
	public static DataBase instanceDataBase() {
		if(DB == null )
			DB = new DataBase();
		return DB;
	}
	
	public void clearData() {
		this.bankAccounts.clear();
		this.customers.clear();
	}
	
	public void addCustomer(Customer customer) {
		this.customers.add(customer);
	}
	
	public void removeCustomer(Customer customer) {
		this.customers.remove(customer);
	}
	
	public boolean findCustomer(Customer customer) { // because we overrode the .equals(Object o) method of Customer
		return this.customers.contains(customer);
	}
	
	public boolean findCustomer(String firstname, String lastname, Calendar birth) { // because we overrode the .equals(Object o) method of Customer
		return this.findCustomer(new Customer(firstname, lastname, birth));
	}
	
	public Customer getCustomer(String firstname, String lastname, Calendar birth) { // tricky
		return this.customers.get(
				this.customers.indexOf( new Customer(firstname,lastname,birth) )
				);
	}
	
	public void addBankAccount(BankAccount bankAccount) {
		this.bankAccounts.add(bankAccount);
	}
	
	public void removeBankAccount(BankAccount bankAccount) {
		this.bankAccounts.remove(bankAccount);
	}
	
	public boolean findBankAccount(BankAccount bankAccount) { // because we overrode the .equals(Object o) method of BankAccount's subclasses and the .equals(Object o) method of Customer
		return this.bankAccounts.contains(bankAccount);
	}
	
	public boolean findBankAccount(Customer customer, String accountType) { // because we overrode the .equals(Object o) method of BankAccount's subclasses and the .equals(Object o) method of Customer
		if (accountsTypesEnum.CHEQUES.name().equals(accountType)) 
			return this.findBankAccount(new BankAccountCheques(customer));
		if (accountsTypesEnum.LIVRET_A.name().equals(accountType)) 
			return this.findBankAccount(new BankAccountLivretA(customer));
		if (accountsTypesEnum.LIVRET_JEUNE.name().equals(accountType)) 
			return this.findBankAccount(new BankAccountLivretJeune(customer));
		if (accountsTypesEnum.LIVRET_DEVELOPPEMENT_DURABLE.name().equals(accountType)) 
			return this.findBankAccount(new BankAccountLivretDeveloppementDurable(customer));
		return false;
	}
	
	public BankAccount getBankAccount(Customer customer, String accountType) { // tricky
		BankAccount ba = null;
		if (accountsTypesEnum.CHEQUES.name().equals(accountType)) 
			ba = new BankAccountCheques(customer);
		if (accountsTypesEnum.LIVRET_A.name().equals(accountType)) 
			ba = new BankAccountLivretA(customer);
		if (accountsTypesEnum.LIVRET_JEUNE.name().equals(accountType)) 
			ba = new BankAccountLivretJeune(customer);
		if (accountsTypesEnum.LIVRET_DEVELOPPEMENT_DURABLE.name().equals(accountType)) 
			ba = new BankAccountLivretDeveloppementDurable(customer);
		
		if(ba == null)
			return null;
		
		return this.bankAccounts.get(
				this.bankAccounts.indexOf( ba )
				);
	}
	
	public boolean findAccountType(String accountType) {
		for(accountsTypesEnum bat : accountsTypesEnum.values()) {
			if(accountType.equals(bat.name()))
				return true;
		}
		return false;
	}
	
}
