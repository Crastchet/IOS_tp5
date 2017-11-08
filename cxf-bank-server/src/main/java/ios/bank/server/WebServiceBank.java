package ios.bank.server;

import java.util.Calendar;

import ios.bank.server.domain.BankAccount;
import ios.bank.server.domain.BankAccountCheques;
import ios.bank.server.domain.Customer;
import ios.bank.server.exceptions.BankAccountAlreadyExistException;
import ios.bank.server.exceptions.BankAccountNoBelongToCustomer;
import ios.bank.server.exceptions.BankAccountNoExistException;
import ios.bank.server.exceptions.BankAccountTypeNoExistException;
import ios.bank.server.exceptions.CustomerAlreadyExistException;
import ios.bank.server.exceptions.CustomerNoExistException;
import ios.bank.server.exceptions.IncorrectAmountException;

public class WebServiceBank implements WebServiceBankInterface {

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
			throw new BankAccountTypeNoExistException();
		
		BankAccount my_bankAccount = BDD.findBankAccount(customer,accountType);
		if(my_bankAccount != null)
			throw new BankAccountAlreadyExistException();
		
		switch(accountType) {
		case "CHEQUES":
			my_bankAccount = new BankAccountCheques(customer);
			break;
		}
	}

	@Override
	public BankAccount getBankAccount(Customer customer, String accountType)
			throws CustomerNoExistException, BankAccountTypeNoExistException, BankAccountNoExistException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double creditMoney(BankAccount bankAccount, double amount)
			throws BankAccountNoExistException, IncorrectAmountException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getBalance(BankAccount bankAccount) throws BankAccountNoExistException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double debitMoney(BankAccount bankAccount, double amount)
			throws BankAccountNoExistException, IncorrectAmountException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void internTransfer(Customer customer, String accountType1, String accountType2, double amount)
			throws CustomerNoExistException, BankAccountTypeNoExistException, IncorrectAmountException {
		// TODO Auto-generated method stub

	}

	@Override
	public void wireTransfer(Customer customer1, BankAccount bankAccount1, Customer customer2, BankAccount bankAccount2,
			double amount) throws CustomerNoExistException, BankAccountNoExistException, BankAccountNoBelongToCustomer,
			IncorrectAmountException {
		// TODO Auto-generated method stub

	}

	@Override
	public double settleAccount(BankAccount bankAccount) throws BankAccountNoExistException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void removeCustomer(Customer customer) throws CustomerNoExistException {
		// TODO Auto-generated method stub

	}

}
