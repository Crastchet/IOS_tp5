package ios.bank.server.domain;

public class BankAccountLivretA extends BankAccount {

	public BankAccountLivretA(Customer c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	
	
	@Override
	public boolean equals(Object o) { //DANGEROUS : Admitting only one type of account for one customer can be created
		return	this.customer.equals( ((BankAccount)o).getCustomer() );
	}
}
