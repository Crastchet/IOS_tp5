package ios.bank.server;

import javax.jws.WebService;

import ios.bank.database.DataBase;


@WebService(endpointInterface = "ios.bank.server.TestHandlerInterface")
public class TestHandler implements TestHandlerInterface {

	private DataBase BDD = DataBase.instanceDataBase();
	
	@Override
	public void clearDB() {
		// TODO Auto-generated method stub
		BDD.clearData();
	}

}
