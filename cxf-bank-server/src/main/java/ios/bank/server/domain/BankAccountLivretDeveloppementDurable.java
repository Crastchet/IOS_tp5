package ios.bank.server.domain;

public class BankAccountLivretDeveloppementDurable extends BankAccount {

	public BankAccountLivretDeveloppementDurable() {}
	
	public BankAccountLivretDeveloppementDurable(Customer c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public boolean equals(Object o) { //DANGEROUS : Admitting only one type of account for one customer can be created
		return	this.customer.equals( ((BankAccount)o).getCustomer() )
				&&	o instanceof BankAccountLivretDeveloppementDurable;
	}
}
