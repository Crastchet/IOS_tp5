package ios.bank.server;

import java.util.Calendar;

import ios.bank.database.DataBase;
import ios.bank.server.domain.BankAccount;
import ios.bank.server.domain.BankAccountCheques;
import ios.bank.server.domain.BankAccountLivretA;
import ios.bank.server.domain.BankAccountLivretDeveloppementDurable;
import ios.bank.server.domain.BankAccountLivretJeune;
import ios.bank.server.domain.Customer;
import ios.bank.server.exceptions.BankAccountAlreadyExistException;
import ios.bank.server.exceptions.BankAccountNoBelongToCustomer;
import ios.bank.server.exceptions.BankAccountNoExistException;
import ios.bank.server.exceptions.BankAccountTypeNoExistException;
import ios.bank.server.exceptions.BankAccountTypeNoExistForCustomerException;
import ios.bank.server.exceptions.CustomerAlreadyExistException;
import ios.bank.server.exceptions.CustomerNoExistException;
import ios.bank.server.exceptions.IncorrectAmountException;

public class WebServiceBank implements WebServiceBankInterface {
	
	private DataBase BDD = DataBase.instanceDataBase();

	@Override
	public Customer createCustomer(String firstname, String lastname, Calendar birth)
			throws CustomerAlreadyExistException {
		// TODO Auto-generated method stub
		Customer my_customer = BDD.findCustomer(firstname,lastname,birth);
		if(my_customer != null)
			throw new CustomerAlreadyExistException();
		BDD.addCustomer(my_customer);
		return my_customer;
	}

	@Override
	public Customer getCustomer(String firstname, String lastname, Calendar birth) throws CustomerNoExistException {
		// TODO Auto-generated method stub
		Customer my_customer = BDD.findCustomer(firstname,lastname,birth);
		if(my_customer == null)
			throw new CustomerNoExistException();
		return my_customer;
	}

	@Override
	public BankAccount createBankAccount(Customer customer, String accountType)
			throws CustomerNoExistException, BankAccountTypeNoExistException, BankAccountAlreadyExistException {
		// TODO Auto-generated method stub
		Customer my_customer = BDD.findCustomer(customer);
		if(my_customer == null)
			throw new CustomerNoExistException();
		
		String my_accountType = BDD.findAccountType(accountType);
		if(my_accountType == null)
			throw new BankAccountTypeNoExistException("The type of BankAccount \"" + accountType + "\" does not exist !");
		
		BankAccount my_bankAccount = BDD.findBankAccount(customer,accountType);
		if(my_bankAccount != null)
			throw new BankAccountAlreadyExistException();
		
		switch(accountType) {
		case "CHEQUES":
			my_bankAccount = new BankAccountCheques(customer);
			break;
		case "LIVRET_A":
			my_bankAccount = new BankAccountLivretA(customer);
			break;
		case "LIVRET_D_D":
			my_bankAccount = new BankAccountLivretDeveloppementDurable(customer);
			break;
		case "LIVRET_JEUNE":
			my_bankAccount = new BankAccountLivretJeune(customer);
			break;
		}
		
		my_bankAccount.setCustomer(customer);
		BDD.addBankAccount(my_bankAccount);
		
		return my_bankAccount;
	}

	@Override
	public BankAccount getBankAccount(Customer customer, String accountType)
			throws CustomerNoExistException, BankAccountTypeNoExistException, BankAccountNoExistException {
		// TODO Auto-generated method stub
		Customer my_customer = BDD.findCustomer(customer);
		if(my_customer == null)
			throw new CustomerNoExistException();
		
		String my_accountType = BDD.findAccountType(accountType);
		if(my_accountType == null)
			throw new BankAccountTypeNoExistException("The type of BankAccount \"" + accountType + "\" does not exist !");
		
		BankAccount my_bankAccount = BDD.findBankAccount(customer,accountType);
		if(my_bankAccount == null)
			throw new BankAccountNoExistException();
		
		return my_bankAccount;
	}

	@Override
	public double creditMoney(BankAccount bankAccount, double amount)
			throws BankAccountNoExistException, IncorrectAmountException {
		// TODO Auto-generated method stub
		BankAccount my_bankAccount = BDD.findBankAccount(bankAccount);
		if(my_bankAccount == null)
			throw new BankAccountNoExistException();
		
		if(amount <= 0)
			throw new IncorrectAmountException("Tried to credit the bank account " + bankAccount + " with the amount of " + amount + ". Crediting a bank account with a null or negative amount is not allowed !");
		
		bankAccount.creditMoney(amount); // le save en bd ou pas ? faire des micro tests
		return bankAccount.getBalance();
	}

	@Override
	public double getBalance(BankAccount bankAccount) throws BankAccountNoExistException {
		// TODO Auto-generated method stub
		BankAccount my_bankAccount = BDD.findBankAccount(bankAccount);
		if(my_bankAccount == null)
			throw new BankAccountNoExistException();
		
		return bankAccount.getBalance();
	}

	@Override
	public double debitMoney(BankAccount bankAccount, double amount)
			throws BankAccountNoExistException, IncorrectAmountException {
		// TODO Auto-generated method stub
		BankAccount my_bankAccount = BDD.findBankAccount(bankAccount);
		if(my_bankAccount == null)
			throw new BankAccountNoExistException();
		
		if(amount <= 0)
			throw new IncorrectAmountException("Tried to credit the bank account " + bankAccount + " with the amount of " + amount + ". Crediting a bank account with a null or negative amount is not allowed !");
		if(amount > bankAccount.getBalance())
			throw new IncorrectAmountException("Tried to debit the bank account " + bankAccount + " with the amount of " + amount + ". Debiting a bank account with an amount bigger than its balance is not allowed !");
		
		bankAccount.debitMoney(amount); // le save en bd ou pas ? faire des micro tests
		return bankAccount.getBalance();
	}

	@Override
	public void internTransfer(Customer customer, String accountType1, String accountType2, double amount)
			throws CustomerNoExistException, BankAccountTypeNoExistException, IncorrectAmountException {
		// TODO Auto-generated method stub
		Customer my_customer = BDD.findCustomer(customer);
		if(my_customer == null)
			throw new CustomerNoExistException("Customer " + customer + "(arg -> customer) was not found in the database !");
		
		String my_accountType = BDD.findAccountType(accountType1);
		if(my_accountType == null)
			throw new BankAccountTypeNoExistException("The type of BankAccount \"" + accountType1 + "\"(arg -> accountType1) does not exist !");
		
		my_accountType = BDD.findAccountType(accountType2);
		if(my_accountType == null)
			throw new BankAccountTypeNoExistException("The type of BankAccount \"" + accountType2 + "\"(arg -> accountType2) does not exist !");
	
		BankAccount my_bankAccount1 = BDD.findBankAccount(customer,accountType1);
		if(my_bankAccount1 == null)
			throw new BankAccountTypeNoExistForCustomerException("Customer " + customer + " does not own any " + accountType1 + "(arg -> accountType1) !");
		
		BankAccount my_bankAccount2 = BDD.findBankAccount(customer,accountType2);
		if(my_bankAccount2 == null)
			throw new BankAccountTypeNoExistForCustomerException("Customer " + customer + " does not own any " + accountType2 + "(arg -> accountType2) !");
		
		if(amount <= 0)
			throw new IncorrectAmountException("Tried to transfer " + amount + " from " + my_bankAccount1 + "(arg -> accountType1) to " + my_bankAccount2 + "(arg -> accountType2). Transferring a null or negative amount is not allowed !");
		if(amount > my_bankAccount1.getBalance())
			throw new IncorrectAmountException("Tried to transfer " + amount + " from " + my_bankAccount1 + "(arg -> accountType1) to " + my_bankAccount2 + "(arg -> accountType2). Making a wire transfer from a bank account with an amount bigger than its balance is not allowed !");
		
		// No need to save it in BDD since we use references
		// Not sure it is a good practice though
		my_bankAccount1.debitMoney(amount);
		my_bankAccount2.creditMoney(amount);
	}

	@Override
	public void wireTransfer(Customer customer1, BankAccount bankAccount1, Customer customer2, BankAccount bankAccount2, double amount) 
			throws CustomerNoExistException, BankAccountNoExistException, BankAccountNoBelongToCustomer, IncorrectAmountException {
		// TODO Auto-generated method stub
		Customer my_customer = BDD.findCustomer(customer1);
		if(my_customer == null)
			throw new CustomerNoExistException("Customer " + customer1 + "(arg -> customer1) was not found in the database !");
		
		BankAccount my_bankAccount = BDD.findBankAccount(bankAccount1);
		if(my_bankAccount == null)
			throw new BankAccountNoExistException("BankAccount " + bankAccount1 + "(arg -> bankAccount1) was not found in the database !");
		
		if(customer1 != bankAccount1.getCustomer()) // !!!! partons du principe qu'ils ont les mêmes intances
			throw new BankAccountNoBelongToCustomer("Customer " + customer1 + "(arg -> customer1) does not own BankAccount " + bankAccount1 + "(arg -> bankAccount1) !");
		
		my_customer = BDD.findCustomer(customer2);
		if(my_customer == null)
			throw new CustomerNoExistException("Customer " + customer2 + "(arg -> customer2) was not found in the database !");
		
		my_bankAccount = BDD.findBankAccount(bankAccount2);
		if(my_bankAccount == null)
			throw new BankAccountNoExistException("BankAccount " + bankAccount2 + "(arg -> bankAccount2) was not found in the database !");
		
		if(customer2 != bankAccount2.getCustomer()) // !!!! partons du principe qu'ils ont les mêmes intances
			throw new BankAccountNoBelongToCustomer("Customer " + customer2 + "(arg -> customer2) does not own BankAccount " + bankAccount2 + "(arg -> bankAccount2) !");
		
		if(amount <= 0)
			throw new IncorrectAmountException("Tried to transfer " + amount + " from " + bankAccount1 + "(arg -> bankAccount1) to " + bankAccount2 + "(arg -> bankAccount2). Transferring a null or negative amount is not allowed !");
		if(amount > bankAccount1.getBalance())
			throw new IncorrectAmountException("Tried to transfer " + amount + " from " + bankAccount1 + "(arg -> bankAccount1) to " + bankAccount2 + "(arg -> bankAccount2). Making a wire transfer from a bank account with an amount bigger than its balance is not allowed !");
		
		bankAccount1.debitMoney(amount);
		bankAccount2.creditMoney(amount);
	}

	@Override
	public double settleAccount(BankAccount bankAccount) throws BankAccountNoExistException {
		// TODO Auto-generated method stub
		BankAccount my_bankAccount = BDD.findBankAccount(bankAccount);
		if(my_bankAccount == null)
			throw new BankAccountNoExistException();
		//!!! Que mettre ici ??? Est ça qu'il faut faire ?
		return bankAccount.settle();
	}

	@Override
	public void removeCustomer(Customer customer) throws CustomerNoExistException {
		// TODO Auto-generated method stub
		Customer my_customer = BDD.findCustomer(customer);
		if(my_customer == null)
			throw new CustomerNoExistException("Customer " + customer + " does not exist !");
		
		for(BankAccount ba : customer.getAccounts())
			BDD.removeBankAccount(ba);
		BDD.removeCustomer(customer);
	}

}
