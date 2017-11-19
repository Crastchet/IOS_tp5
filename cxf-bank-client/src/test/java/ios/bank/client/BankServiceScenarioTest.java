package ios.bank.client;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import ios.bank.generated.Customer;
import ios.bank.generated.CustomerAlreadyExistException;
import ios.bank.generated.CustomerAlreadyExistException_Exception;
import ios.bank.generated.CustomerNoExistException_Exception;
import ios.bank.generated.WebServiceBankInterface;

import static org.junit.Assert.*;

import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class BankServiceScenarioTest {
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();

	@Test
	public void createCustomerTest() {
		BankServiceClient client = new BankServiceClient();
		WebServiceBankInterface port = client.getService();
		
		try {
			Customer customer1 = port.createCustomer("Thibault", "Coilliaux", toCalendar(1995, 05, 13));
			Customer customer2 = port.createCustomer("Antoine", "Coilliaux", toCalendar(1997, 04, 17));
			assertNotNull(customer1);
			assertNotNull(customer2);
			assertNotEquals(customer1, customer2);
		} catch (CustomerAlreadyExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("createCustomerTest() : CustomerAlreadyExistException raised but was not supposed to");
		}
		
		
//		Customer customer2 = port.createCustomer("Antoine", "Coilliaux", toCalendar(1997, 04, 17));
//		Customer customerGot2 = port.getCustomer("Antoine", "Coilliaux", toCalendar(1997, 04, 17));
//		assertEquals(customer2,customerGot2);
//		
//		assertNotEquals(customerGot1, customerGot2);
	}
	
	@Test
	public void createCustomerAlreadyExistExceptionTest() {
		BankServiceClient client = new BankServiceClient();
		WebServiceBankInterface port = client.getService();
		
		exception.expect(CustomerAlreadyExistException_Exception.class);
		try {
			Customer customer1 = port.createCustomer("Thibault", "Coilliaux", toCalendar(1995, 05, 13));
			Customer customer2 = port.createCustomer("Thibault", "Coilliaux", toCalendar(1995, 05, 13));
		} catch (CustomerAlreadyExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	/**
	 * On test avec deux clients pour éviter les "faux test validés".
	 * Il m'est déjà arrivé d'avoir des tests validés car la méthode 
	 * 	se contentait de renvoyer le dernier élément créé dans une liste.
	 */
	@Test
	public void getCustomerTest() {
		BankServiceClient client = new BankServiceClient();
		WebServiceBankInterface port = client.getService();
		
		try {
			Customer customer1 = port.createCustomer("Thibault", "Coilliaux", toCalendar(1995, 05, 13));
			Customer customer2 = port.createCustomer("Antoine", "Coilliaux", toCalendar(1997, 04, 17));
			
			Customer customerGot1 = port.getCustomer("Thibault", "Coilliaux", toCalendar(1995, 05, 13));
			Customer customerGot2 = port.getCustomer("Antoine", "Coilliaux", toCalendar(1997, 04, 17));

			assertEquals(customer1,customerGot1);
			assertEquals(customer2,customerGot2);
			assertNotEquals(customerGot1, customerGot2);
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
	public void getCustomerNoExistExceptionTest() {
		BankServiceClient client = new BankServiceClient();
		WebServiceBankInterface port = client.getService();
		
		exception.expect(CustomerNoExistException_Exception.class);
		try {
			port.createCustomer("Thibault", "Coilliaux", toCalendar(1995, 05, 13));
			port.getCustomer("Thibault", "Coilliaux", toCalendar(1997, 04, 17));
		} catch (CustomerAlreadyExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail("getCustomerTest() : CustomerAlreadyExistException raised but was not supposed to");
		} catch (CustomerNoExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
