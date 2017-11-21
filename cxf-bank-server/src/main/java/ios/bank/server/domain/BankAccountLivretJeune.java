package ios.bank.server.domain;

public class BankAccountLivretJeune extends BankAccount {

	public BankAccountLivretJeune() {}
	
	public BankAccountLivretJeune(Customer c) {
		super(c);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public boolean equals(Object o) { //DANGEROUS : Admitting only one type of account for one customer can be created
		return	this.customer.equals( ((BankAccount)o).getCustomer() )
				&&	o instanceof BankAccountLivretJeune;
	}
}
