package ios.bank.test.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.fail;

import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import ios.bank.client.BankServiceClient;
import ios.bank.generated.BankAccount;
import ios.bank.generated.BankAccountAlreadyExistException_Exception;
import ios.bank.generated.BankAccountNoExistException_Exception;
import ios.bank.generated.BankAccountTypeNoExistException_Exception;
import ios.bank.generated.BankAccountTypeNoExistForCustomerException_Exception;
import ios.bank.generated.Customer;
import ios.bank.generated.CustomerAlreadyExistException_Exception;
import ios.bank.generated.CustomerNoExistException_Exception;
import ios.bank.generated.IncorrectAmountException_Exception;
import ios.bank.generated.WebServiceBankInterface;
import ios.bank.test.generated.TestHandlerInterface;

public class BankServiceScenarioTest {
	
	BankServiceClient client = new BankServiceClient();
	WebServiceBankInterface port = client.getService();
	TestHandlerServiceClient clientAdmin = new TestHandlerServiceClient();
	TestHandlerInterface portAdmin = clientAdmin.getService();
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();

	
	@Test
	public void createCustomerTest() {
		portAdmin.clearDB();
		
		try {
			Customer customer1 = port.createCustomer("Thibault", "Coilliaux", toCalendar(1995, 05, 13));
			Customer customer2 = port.createCustomer("Antoine", "Coilliaux", toCalendar(1997, 04, 17));
			assertNotNull(customer1);
			assertNotNull(customer2);
			assertNotEquals(customer1.getFirstname(), customer2.getFirstname());
		
		} catch (CustomerAlreadyExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("createCustomerTest() : CustomerAlreadyExistException raised but was not supposed to");
		}
	}
	
	@Test
	public void createCustomer_CustomerAlreadyExistException_Test() {
		portAdmin.clearDB();
		
		//exception.expect(CustomerAlreadyExistException_Exception.class);
		try {
			port.createCustomer("Thibault", "Coilliaux", toCalendar(1995, 05, 13));
			port.createCustomer("Thibault", "Coilliaux", toCalendar(1995, 05, 13));
			fail("It should have raised an exception ! (CustomerAlreadyExistException)");
		
		} catch (CustomerAlreadyExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertSame(e.getClass(), CustomerAlreadyExistException_Exception.class);
		}
	}
	
	/**
	 * On crée un client. 
	 * On le supprime. 
	 * On recrée le même client et aucune exception ne devrait être lancée
	 */
	@Test
	public void removeCustomerTest() {
		portAdmin.clearDB();
		
		try {
			Customer customer = port.createCustomer("Thibault", "Coilliaux", toCalendar(1995, 05, 13));
			port.removeCustomer(customer);
			port.createCustomer("Thibault", "Coilliaux", toCalendar(1995, 05, 13));
		
		} catch (CustomerAlreadyExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("removeCustomerTest() : CustomerAlreadyExistException raised but was not supposed to");
		} catch (CustomerNoExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("removeCustomerTest() : CustomerNoExistException raised but was not supposed to");
		}
	}
	
	/**
	 * On crée un client. 
	 * On le supprime. 
	 * On le supprime à nouveau. Une CustomerNoExistException devrait être levée
	 */
	@Test
	public void removeCustomer_CustomerNoExistException_Test() {
		portAdmin.clearDB();
		
			Customer customer;
			try {
				customer = port.createCustomer("Thibault", "Coilliaux", toCalendar(1995, 05, 13));
				port.removeCustomer(customer);
				port.removeCustomer(customer);
				fail("It should have raised an exception ! (CustomerNoExistException)");
				
			} catch (CustomerAlreadyExistException_Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				fail("removeCustomer_CustomerNoExistException_Test() : CustomerAlreadyExistException raised but was not supposed to");
			} catch (CustomerNoExistException_Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				assertSame(e.getClass(), CustomerNoExistException_Exception.class);
			}
	}
	
	
	/**
	 * On test avec deux clients pour éviter les "faux test validés".
	 * Il m'est déjà arrivé d'avoir des tests validés car la méthode 
	 * 	se contentait de renvoyer le dernier élément créé dans une liste.
	 */
	@Test
	public void getCustomerTest() {
		portAdmin.clearDB();
		
		try {
			Customer customer1 = port.createCustomer("Thibault", "Coilliaux", toCalendar(1995, 05, 13));
			Customer customer2 = port.createCustomer("Antoine", "Coilliaux", toCalendar(1997, 04, 17));
			
			Customer customerGot1 = port.getCustomer("Thibault", "Coilliaux", toCalendar(1995, 05, 13));
			Customer customerGot2 = port.getCustomer("Antoine", "Coilliaux", toCalendar(1997, 04, 17));

			assertEquals(customer1.getFirstname(),customerGot1.getFirstname());
			assertEquals(customer2.getFirstname(),customerGot2.getFirstname());
			assertNotEquals(customerGot1.getFirstname(), customerGot2.getFirstname());
		} catch (CustomerAlreadyExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("getCustomerTest() : CustomerAlreadyExistException raised but was not supposed to");
		} catch (CustomerNoExistException_Exception e) {
			// TODO Auto-generated catch block
			fail("getCustomerTest() : CustomerNoExistException raised but was not supposed to");
			e.printStackTrace();
		}
	}
	
	/**
	 * Créer 1 client et tenter de récupérer 1 client avec les mêmes prénom et nom 
	 *  mais une date de naissance différente.
	 * Devrait lancer une exception comme quoi le client n'existe pas 
	 *  (CustomerNoExistException_Exception)
	 */
	@Test
	public void getCustomer_CustomerNoExistException_Test() {
		portAdmin.clearDB();
		
		//exception.expect(CustomerNoExistException_Exception.class);
		try {
			port.createCustomer("Thibault", "Coilliaux", toCalendar(1995, 05, 13));
			port.getCustomer("Thibault", "Coilliaux", toCalendar(1997, 04, 17));
			fail("It should have raised an exception ! (CustomerNoExistException)");
		
		} catch (CustomerAlreadyExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("getCustomer_CustomerNoExistException_Test() : CustomerAlreadyExistException raised but was not supposed to");
		} catch (CustomerNoExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertSame(e.getClass(), CustomerNoExistException_Exception.class);
		}
	}
	
	
	@Test
	public void createBankAccountTest() {
		portAdmin.clearDB();
		
		try {
			Customer customer = port.createCustomer("Thibault", "Coilliaux", toCalendar(1995, 05, 13));
			
			BankAccount bankAccount1 = port.createBankAccount(customer, "CHEQUES");
			BankAccount bankAccount2 = port.createBankAccount(customer, "LIVRET_A");
			BankAccount bankAccount3 = port.createBankAccount(customer, "LIVRET_JEUNE");
			BankAccount bankAccount4 = port.createBankAccount(customer, "LIVRET_DEVELOPPEMENT_DURABLE");
			//je ne peux pas tester mes comptes en Banque comme je l'ai précisé dans le compte rendu.
			
//			assertSame(bankAccount1.getClass(), BankAccountCheques.class);
//			assertSame(bankAccount2.getClass(), BankAccountLivretA.class);
//			assertSame(bankAccount3.getClass(), BankAccountLivretDeveloppementDurable.class);
//			assertSame(bankAccount4.getClass(), BankAccountLivretJeune.class);
			
//			assertEquals(0, bankAccount1.getBalance());
//			assertEquals(0, bankAccount2.getBalance());
//			assertEquals(0, bankAccount3.getBalance());
//			assertEquals(0, bankAccount4.getBalance());
			
		} catch (CustomerAlreadyExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("createBankAccountTest() : CustomerAlreadyExistException raised but was not supposed to");
		} catch (BankAccountAlreadyExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("createBankAccountTest() : BankAccountAlreadyExistException raised but was not supposed to");
		} catch (CustomerNoExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("createBankAccountTest() : CustomerNoExistException raised but was not supposed to");
		} catch (BankAccountTypeNoExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("createBankAccountTest() : BankAccountTypeNoExistException raised but was not supposed to");
		}
	}
	
	@Test
	public void createBankAccount_CustomerNoExistException_Test() {
		portAdmin.clearDB();
		
		try {
			port.createBankAccount(new Customer(), "CHEQUES");
			fail("It should have raised an exception ! (CustomerNoExistException)");
			
		} catch (BankAccountAlreadyExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("createBankAccount_CustomerNoExistException_Test() : BankAccountAlreadyExistException raised but was not supposed to");
		} catch (CustomerNoExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertSame(e.getClass(), CustomerNoExistException_Exception.class);
		} catch (BankAccountTypeNoExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("createBankAccount_CustomerNoExistException_Test() : BankAccountTypeNoExistException raised but was not supposed to");
		}
	}
	
	@Test
	public void createBankAccount_BankAccountTypeNoExistException_Test() {
		portAdmin.clearDB();
		
		try {
			Customer customer = port.createCustomer("Thibault", "Coilliaux", toCalendar(1995, 05, 13));
			port.createBankAccount(customer, "cheques"); //lowerCase
			fail("It should have raised an exception ! (BankAccountTypeNoExistException)");
			
		} catch (BankAccountAlreadyExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("createBankAccount_BankAccountTypeNoExistException_Test() : BankAccountAlreadyExistException raised but was not supposed to");
		} catch (CustomerNoExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("createBankAccount_BankAccountTypeNoExistException_Test() : CustomerNoExistException raised but was not supposed to");
		} catch (BankAccountTypeNoExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertSame(e.getClass(), BankAccountTypeNoExistException_Exception.class);
		} catch (CustomerAlreadyExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("createBankAccount_BankAccountTypeNoExistException_Test() : CustomerAlreadyExistException raised but was not supposed to");
		}
	}
	
	@Test
	public void createBankAccount_BankAccountAlreadyExistException_Test() {
		portAdmin.clearDB();
	
		try {
			Customer customer = port.createCustomer("Thibault", "Coilliaux", toCalendar(1995, 05, 13));
			port.createBankAccount(customer, "CHEQUES");
			port.createBankAccount(customer, "CHEQUES");
			fail("It should have raised an exception ! (BankAccountAlreadyExistException)");
			
		} catch (CustomerAlreadyExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("createBankAccount_BankAccountAlreadyExistException_Test() : CustomerAlreadyExistException raised but was not supposed to");
		} catch (BankAccountAlreadyExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertSame(e.getClass(), BankAccountAlreadyExistException_Exception.class);
		} catch (CustomerNoExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("createBankAccount_BankAccountAlreadyExistException_Test() : CustomerNoExistException raised but was not supposed to");
		} catch (BankAccountTypeNoExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("createBankAccount_BankAccountAlreadyExistException_Test() : BankAccountTypeNoExistException raised but was not supposed to");
		}
	}
	
	
	@Test
	public void getBankAccountTest() {
		portAdmin.clearDB();
		
		try {
			Customer customer = port.createCustomer("Thibault", "Coilliaux", toCalendar(1995, 05, 13));
			port.createBankAccount(customer, "LIVRET_A");
			BankAccount bankAccount = port.getBankAccount(customer, "LIVRET_A");
			
			assertEquals("Thibault", bankAccount.getCustomer().getFirstname());
			//je ne peux pas tester grand chose d'autre, je n'ai accès à rien et les méthodes equals ne sont pas prises en compte ici dans le client
			
		} catch (CustomerAlreadyExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("getBankAccountTest() : CustomerAlreadyExistException raised but was not supposed to");
		} catch (BankAccountAlreadyExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("getBankAccountTest() : BankAccountAlreadyExistException raised but was not supposed to");
		} catch (CustomerNoExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("getBankAccountTest() : CustomerNoExistException raised but was not supposed to");
		} catch (BankAccountTypeNoExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("getBankAccountTest() : BankAccountTypeNoExistException raised but was not supposed to");
		} catch (BankAccountNoExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("getBankAccountTest() : BankAccountNoExistException raised but was not supposed to");
		}
	}
	
	@Test
	public void getBankAccount_CustomerNoExistException_Test() {
		portAdmin.clearDB();
		
		try {
			port.getBankAccount(new Customer(), "LIVRET_A");
			fail("It should have raised an exception ! (CustomerNoExistException)");
			
		} catch (BankAccountNoExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("getBankAccount_CustomerNoExistException_Test() : BankAccountNoExistException raised but was not supposed to");
		} catch (CustomerNoExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertSame(e.getClass(), CustomerNoExistException_Exception.class);
		} catch (BankAccountTypeNoExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("getBankAccount_CustomerNoExistException_Test() : BankAccountTypeNoExistException raised but was not supposed to");
		}
	}
	
	@Test
	public void getBankAccount_BankAccountTypeNoExistException_Test() {
		portAdmin.clearDB();

		try {
			Customer customer = port.createCustomer("Thibault", "Coilliaux", toCalendar(1995, 05, 13));
			port.getBankAccount(customer, "LIVRET_B");
			fail("It should have raised an exception ! (BankAccountTypeNoExistException)");
						
		} catch (CustomerAlreadyExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("getBankAccount_BankAccountTypeNoExistException_Test() : CustomerAlreadyExistException raised but was not supposed to");
		} catch (CustomerNoExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("getBankAccount_BankAccountTypeNoExistException_Test() : CustomerNoExistException raised but was not supposed to");
		} catch (BankAccountTypeNoExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertSame(e.getClass(), BankAccountTypeNoExistException_Exception.class);
		} catch (BankAccountNoExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("getBankAccount_BankAccountTypeNoExistException_Test() : BankAccountNoExistException raised but was not supposed to");
		}
	}
	
	@Test
	public void getBankAccount_BankAccountNoExistException_Test() {
		portAdmin.clearDB();

		try {
			Customer customer = port.createCustomer("Thibault", "Coilliaux", toCalendar(1995, 05, 13));
			port.getBankAccount(customer, "LIVRET_A");
			fail("It should have raised an exception ! (BankAccountNoExistException)");
						
		} catch (CustomerAlreadyExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("getBankAccount_BankAccountNoExistException_Test() : CustomerAlreadyExistException raised but was not supposed to");
		} catch (CustomerNoExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("getBankAccount_BankAccountNoExistException_Test() : CustomerNoExistException raised but was not supposed to");
		} catch (BankAccountTypeNoExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("getBankAccount_BankAccountNoExistException_Test() : BankAccountTypeNoExistException raised but was not supposed to");
		} catch (BankAccountNoExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertSame(e.getClass(), BankAccountNoExistException_Exception.class);
		}
	}
	
	
	@Test
	public void creditMoneyTest() {
		portAdmin.clearDB();
		
		try {
			Customer customer = port.createCustomer("Thibault", "Coilliaux", toCalendar(1995, 05, 13));
			BankAccount bankAccount = port.createBankAccount(customer, "LIVRET_JEUNE");
			double amount = port.creditMoney(bankAccount, 1200.50);
			//ici ça plantera car l'objet bankAccount récupéré n'est pas le même que celui créé sur le serveur
			//tant que les sous-classes de BankAccount ne seront pas connues du client, ça ne fonctionnera pas
			assertEquals(amount, 1200.50);
		
		} catch (CustomerAlreadyExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("creditMoneyTest() : CustomerAlreadyExistException raised but was not supposed to");
		} catch (BankAccountNoExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("creditMoneyTest() : BankAccountNoExistException raised but was not supposed to");
		} catch (CustomerNoExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("creditMoneyTest() : CustomerNoExistException raised but was not supposed to");
		} catch (BankAccountTypeNoExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("creditMoneyTest() : BankAccountTypeNoExistException raised but was not supposed to");
		} catch (IncorrectAmountException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("creditMoneyTest() : IncorrectAmountException raised but was not supposed to");
		} catch (BankAccountAlreadyExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("creditMoneyTest() : BankAccountAlreadyExistException raised but was not supposed to");
		}
	}
	
	@Test
	public void creditMoney_BankAccountNoExistException_Test() {
		portAdmin.clearDB();
		
		try {
			double amount = port.creditMoney(new BankAccount(), 1200.50);
			fail("It should have raised an exception ! (BankAccountNoExistException)");
		
		} catch (BankAccountNoExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertSame(e.getClass(), BankAccountNoExistException_Exception.class);
		} catch (IncorrectAmountException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("creditMoney_BankAccountNoExistException_Test() : IncorrectAmountException raised but was not supposed to");
		}
	}
	
	@Test
	public void creditMoney_IncorrectAmountException_Test() {
		portAdmin.clearDB();
		
		try {
			Customer customer = port.createCustomer("Thibault", "Coilliaux", toCalendar(1995, 05, 13));
			BankAccount bankAccount = port.createBankAccount(customer, "LIVRET_JEUNE");
			port.creditMoney(bankAccount, -5);
			//ici va renvoyer BanAccountNoExistException pour la même raison que les autres tests en échec
			fail("It should have raised an exception ! (IncorrectAmountException)");
			
		} catch (CustomerAlreadyExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("creditMoney_IncorrectAmountException_Test() : CustomerAlreadyExistException raised but was not supposed to");
		} catch (BankAccountAlreadyExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("creditMoney_IncorrectAmountException_Test() : BankAccountAlreadyExistException raised but was not supposed to");
		} catch (CustomerNoExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("creditMoney_IncorrectAmountException_Test() : CustomerNoExistException raised but was not supposed to");
		} catch (BankAccountTypeNoExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("creditMoney_IncorrectAmountException_Test() : BankAccountTypeNoExistException raised but was not supposed to");
		} catch (BankAccountNoExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("creditMoney_IncorrectAmountException_Test() : BankAccountNoExistException raised but was not supposed to");
		} catch (IncorrectAmountException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertSame(e.getClass(), IncorrectAmountException_Exception.class);
		}
	}
	
	
	@Test
	public void internTransferTest() {
		portAdmin.clearDB();
		
		try {
			Customer customer = port.createCustomer("Thibault", "Coilliaux", toCalendar(1995, 05, 13));
			BankAccount bankAccount = port.createBankAccount(customer, "CHEQUES");
			port.creditMoney(bankAccount, 80);
			//ici va renvoyer BanAccountNoExistException pour la même raison que les autres tests en échec
			port.createBankAccount(customer, "LIVRET_A");
			port.internTransfer(customer, "CHEQUES", "LIVRET_A", 15);
			
		} catch (CustomerAlreadyExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("internTransferTest() : CustomerAlreadyExistException raised but was not supposed to");
		} catch (BankAccountAlreadyExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("internTransferTest() : BankAccountAlreadyExistException raised but was not supposed to");
		} catch (CustomerNoExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("internTransferTest() : CustomerNoExistException raised but was not supposed to");
		} catch (BankAccountTypeNoExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("internTransferTest() : BankAccountTypeNoExistException raised but was not supposed to");
		} catch (BankAccountTypeNoExistForCustomerException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("internTransferTest() : BankAccountTypeNoExistForCustomerException raised but was not supposed to");
		} catch (IncorrectAmountException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("internTransferTest() : IncorrectAmountException raised but was not supposed to");
		} catch (BankAccountNoExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("internTransferTest() : BankAccountNoExistException raised but was not supposed to");
		}
			
	}
	
	@Test
	public void internTransfer_CustomerNoExistException_Test() {
		portAdmin.clearDB();
		
		try {
			port.internTransfer(new Customer(), "CHEQUES", "LIVRET_A", 15);
			fail("It should have raised an exception ! (CustomerNoExistException)");
			
		} catch (CustomerNoExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertSame(e.getClass(), CustomerNoExistException_Exception.class);
		} catch (BankAccountTypeNoExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("internTransfer_CustomerNoExistException_Test() : BankAccountTypeNoExistException raised but was not supposed to");
		} catch (BankAccountTypeNoExistForCustomerException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("internTransfer_CustomerNoExistException_Test() : BankAccountTypeNoExistForCustomerException raised but was not supposed to");
		} catch (IncorrectAmountException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("internTransfer_CustomerNoExistException_Test() : IncorrectAmountException raised but was not supposed to");
		}
	}
	
	@Test
	public void internTransfer_BankAccountTypeNoExistException_Test() {
		portAdmin.clearDB();
		
		try {
			Customer customer = port.createCustomer("Thibault", "Coilliaux", toCalendar(1995, 05, 13));
			port.internTransfer(customer, "CHEQUEeS", "LIVRET_A", 15);
			fail("It should have raised an exception ! (BankAccountTypeNoExistException)");
			
		} catch (CustomerNoExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("internTransfer_BankAccountTypeNoExistException_Test() : CustomerNoExistException raised but was not supposed to");
		} catch (BankAccountTypeNoExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertSame(e.getClass(), BankAccountTypeNoExistException_Exception.class);
		} catch (BankAccountTypeNoExistForCustomerException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("internTransfer_BankAccountTypeNoExistException_Test() : BankAccountTypeNoExistForCustomerException raised but was not supposed to");
		} catch (IncorrectAmountException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("internTransfer_BankAccountTypeNoExistException_Test() : IncorrectAmountException raised but was not supposed to");
		} catch (CustomerAlreadyExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("internTransfer_BankAccountTypeNoExistException_Test() : CustomerAlreadyExistException raised but was not supposed to");
		}
	}
	
	@Test
	public void internTransfer_BankAccountTypeNoExistForCustomerException_Test() {
		portAdmin.clearDB();
		
		try {
			Customer customer = port.createCustomer("Thibault", "Coilliaux", toCalendar(1995, 05, 13));
			port.createBankAccount(customer, "CHEQUES");
			port.createBankAccount(customer, "LIVRET_A");
			port.internTransfer(customer, "CHEQUES", "LIVRET_JEUNE", 15);
			fail("It should have raised an exception ! (BankAccountTypeNoExistForCustomerException)");
			
		} catch (CustomerNoExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("internTransfer_BankAccountTypeNoExistForCustomerException_Test() : CustomerNoExistException raised but was not supposed to");
		} catch (BankAccountTypeNoExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("internTransfer_BankAccountTypeNoExistForCustomerException_Test() : BankAccountTypeNoExistException raised but was not supposed to");
		} catch (BankAccountTypeNoExistForCustomerException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertSame(e.getClass(), BankAccountTypeNoExistForCustomerException_Exception.class);
		} catch (IncorrectAmountException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("internTransfer_BankAccountTypeNoExistForCustomerException_Test() : IncorrectAmountException raised but was not supposed to");
		} catch (CustomerAlreadyExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("internTransfer_BankAccountTypeNoExistForCustomerException_Test() : CustomerAlreadyExistException raised but was not supposed to");
		} catch (BankAccountAlreadyExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("internTransfer_BankAccountTypeNoExistForCustomerException_Test() : BankAccountAlreadyExistException raised but was not supposed to");
		}
	}
	
	
	
	public static XMLGregorianCalendar toCalendar(int y, int m, int d) {
		GregorianCalendar c = new GregorianCalendar(y,m,d);
		try {
			return  DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
