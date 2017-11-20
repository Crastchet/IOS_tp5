package ios.bank.client;

import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import ios.bank.generated.Customer;
import ios.bank.generated.CustomerAlreadyExistException_Exception;
import ios.bank.generated.CustomerNoExistException_Exception;
import ios.bank.generated.WebServiceBankInterface;

public class Main {

	public static void main(String[] args) throws DatatypeConfigurationException {
		/**
		// TODO Auto-generated method stub
		GregorianCalendar c = new GregorianCalendar(1995,05,13);
		XMLGregorianCalendar birth =  DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		
		GregorianCalendar c2 = new GregorianCalendar(1997,04,17);
		XMLGregorianCalendar birth2 =  DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		
		BankServiceClient client = new BankServiceClient();
		WebServiceBankInterface port = client.getService();
		
		
		/** Methods : 
		 * 			createCustomer(String firstname, String lastname, Calendar birth)
		 * 			getCustomer(String firstname, String lastname, Calendar birth)
		 *
		//Récupération de clients qui existent
		try {
			//On crée 1 client, puis on le récupère
			Customer customer1 = port.createCustomer("Thibault", "Coilliaux", birth);
			Customer customerGot1 = port.getCustomer("Thibault", "Coilliaux", birth);
			assertEquals(customer1,customerGot1);
			
			Customer customer2 = port.createCustomer("Antoine", "Coilliaux", birth2);
			Customer customerGot2 = port.getCustomer("Antoine", "Coilliaux", birth2);
			assertEquals(customer2,customerGot2);
			
			assertNotEquals(customerGot1, customerGot2);
			
		} catch (CustomerAlreadyExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		} catch (CustomerNoExistException_Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		}
		
		
		**/
	}
}
