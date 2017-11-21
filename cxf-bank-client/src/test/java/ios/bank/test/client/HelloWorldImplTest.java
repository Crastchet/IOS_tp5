
package ios.bank.test.client;

import org.junit.Test;

import ios.bank.client.HelloWorldImpl;

import static org.junit.Assert.assertEquals;

public class HelloWorldImplTest {

    @Test
    public void testSayHi() {
        HelloWorldImpl helloWorldImpl = new HelloWorldImpl();
        String response = helloWorldImpl.sayHi("Sam");
        assertEquals("HelloWorldImpl not properly saying hi", "Hello Sam", response);
    }
}
