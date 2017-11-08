
package ios.bank.server;

import javax.jws.WebService;

@WebService(endpointInterface = "ios.bank.server.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    public String sayHi(String text) {
        return "Hello " + text;
    }
}

