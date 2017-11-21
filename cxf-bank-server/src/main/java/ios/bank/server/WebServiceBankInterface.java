package ios.bank.server;

import java.util.Calendar;

import javax.jws.WebService;

import ios.bank.server.domain.BankAccount;
import ios.bank.server.domain.Customer;
import ios.bank.server.exceptions.BankAccountAlreadyExistException;
import ios.bank.server.exceptions.BankAccountNoBelongToCustomer;
import ios.bank.server.exceptions.BankAccountNoExistException;
import ios.bank.server.exceptions.BankAccountTypeNoExistException;
import ios.bank.server.exceptions.BankAccountTypeNoExistForCustomerException;
import ios.bank.server.exceptions.CustomerAlreadyExistException;
import ios.bank.server.exceptions.CustomerNoExistException;
import ios.bank.server.exceptions.IncorrectAmountException;

@WebService
public interface WebServiceBankInterface {

	public Customer createCustomer(String firstname, String lastname, Calendar birth) 
			throws  CustomerAlreadyExistException;
	
	public Customer getCustomer(String firstname, String lastname, Calendar birth) 
			throws  CustomerNoExistException;
	
	public BankAccount createBankAccount(Customer customer, String accountType) 
			throws  CustomerNoExistException, 
					BankAccountTypeNoExistException, 
					BankAccountAlreadyExistException;
	
	public BankAccount getBankAccount(Customer customer, String accountType) 
			throws  CustomerNoExistException, 
					BankAccountTypeNoExistException, 
					BankAccountNoExistException;
	
	public double creditMoney(BankAccount bankAccount, double amount) 
			throws  BankAccountNoExistException, 
					IncorrectAmountException;
	
	public double getBalance(BankAccount bankAccount) 
			throws  BankAccountNoExistException;
	
	public double debitMoney(BankAccount bankAccount, double amount) 
			throws  BankAccountNoExistException, 
					IncorrectAmountException;
	
	public void internTransfer(Customer customer, String accountType1, String accountType2, double amount) 
			throws  CustomerNoExistException, 
					BankAccountTypeNoExistException, 
					BankAccountTypeNoExistForCustomerException, 
					IncorrectAmountException;
	
	public void wireTransfer(Customer customer1, BankAccount bankAccount1, Customer customer2, BankAccount bankAccount2, double amount) 
			throws  CustomerNoExistException, 
					BankAccountNoExistException, 
					BankAccountNoBelongToCustomer,
					IncorrectAmountException;
	
	public double settleAccount(BankAccount bankAccount)
			throws  BankAccountNoExistException;
	
	public void removeCustomer(Customer customer)
			throws  CustomerNoExistException;
}
