
package ios.bank.generated;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.0
 * 2017-11-20T12:17:43.167+01:00
 * Generated source version: 3.2.0
 */

@WebFault(name = "CustomerNoExistException", targetNamespace = "http://server.bank.ios/")
public class CustomerNoExistException_Exception extends Exception {
    
    private ios.bank.generated.CustomerNoExistException customerNoExistException;

    public CustomerNoExistException_Exception() {
        super();
    }
    
    public CustomerNoExistException_Exception(String message) {
        super(message);
    }
    
    public CustomerNoExistException_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomerNoExistException_Exception(String message, ios.bank.generated.CustomerNoExistException customerNoExistException) {
        super(message);
        this.customerNoExistException = customerNoExistException;
    }

    public CustomerNoExistException_Exception(String message, ios.bank.generated.CustomerNoExistException customerNoExistException, Throwable cause) {
        super(message, cause);
        this.customerNoExistException = customerNoExistException;
    }

    public ios.bank.generated.CustomerNoExistException getFaultInfo() {
        return this.customerNoExistException;
    }
}
