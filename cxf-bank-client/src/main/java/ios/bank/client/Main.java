package ios.bank.client;

import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import ios.bank.generated.CustomerAlreadyExistException_Exception;
import ios.bank.generated.CustomerNoExistException_Exception;
import ios.bank.generated.WebServiceBankInterface;

public class Main {

	public static void main(String[] args) throws DatatypeConfigurationException {
		// TODO Auto-generated method stub
		GregorianCalendar c = new GregorianCalendar(1995,05,13);
		XMLGregorianCalendar birth =  DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		
		BankServiceClient client = new BankServiceClient();
		WebServiceBankInterface port = client.getService();
		
		try {
			//port.createCustomer("Thibault", "Coilliaux", birth);
			System.out.println(port.getCustomer("Thibault", "Coilliaux", birth));
		} catch (CustomerNoExistException_Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
