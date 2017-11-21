package ios.bank.test.client;

import org.apache.cxf.frontend.ClientProxyFactoryBean;
import org.apache.cxf.jaxws.JaxWsClientFactoryBean;

import ios.bank.test.generated.TestHandlerInterface;

public class TestHandlerServiceClient {

	
private TestHandlerInterface service;
	
	public TestHandlerServiceClient() {
		ClientProxyFactoryBean factory = new ClientProxyFactoryBean(new JaxWsClientFactoryBean());
		factory.setServiceClass(TestHandlerInterface.class);
		factory.setAddress("http://localhost:8080/cxf-bank-server/Test");
		this.service = (TestHandlerInterface) factory.create();
	}
	
	public TestHandlerInterface getService() {
		return this.service;
	}
}
