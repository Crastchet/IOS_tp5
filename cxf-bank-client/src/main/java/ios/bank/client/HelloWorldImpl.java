
package ios.bank.client;

import javax.jws.WebService;

@WebService(endpointInterface = "ios.bank.client.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    public String sayHi(String text) {
        return "Hello " + text;
    }
}

