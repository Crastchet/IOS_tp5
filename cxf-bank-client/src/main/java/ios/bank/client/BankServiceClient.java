package ios.bank.client;

import org.apache.cxf.frontend.ClientProxyFactoryBean;
import org.apache.cxf.jaxws.JaxWsClientFactoryBean;
import org.apache.cxf.service.Service;

import ios.bank.generated.WebServiceBankInterface;
import ios.bank.generated.WebServiceBankInterface_WebServiceBankPort_Client;
import ios.bank.generated.WebServiceBankService;

public class BankServiceClient {

	private WebServiceBankInterface service;
	
	public BankServiceClient() {
		ClientProxyFactoryBean factory = new ClientProxyFactoryBean(new JaxWsClientFactoryBean());
		factory.setServiceClass(WebServiceBankInterface.class);
		factory.setAddress("http://localhost:8080/cxf-bank-server/Bank");
		this.service = (WebServiceBankInterface) factory.create();
	}
	
	public WebServiceBankInterface getService() {
		return this.service;
	}

}
