
package ios.bank.generated;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 3.2.0
 * 2017-11-15T16:40:50.974+01:00
 * Generated source version: 3.2.0
 */

@WebFault(name = "BankAccountTypeNoExistException", targetNamespace = "http://server.bank.ios/")
public class BankAccountTypeNoExistException_Exception extends Exception {
    
    private ios.bank.generated.BankAccountTypeNoExistException bankAccountTypeNoExistException;

    public BankAccountTypeNoExistException_Exception() {
        super();
    }
    
    public BankAccountTypeNoExistException_Exception(String message) {
        super(message);
    }
    
    public BankAccountTypeNoExistException_Exception(String message, Throwable cause) {
        super(message, cause);
    }

    public BankAccountTypeNoExistException_Exception(String message, ios.bank.generated.BankAccountTypeNoExistException bankAccountTypeNoExistException) {
        super(message);
        this.bankAccountTypeNoExistException = bankAccountTypeNoExistException;
    }

    public BankAccountTypeNoExistException_Exception(String message, ios.bank.generated.BankAccountTypeNoExistException bankAccountTypeNoExistException, Throwable cause) {
        super(message, cause);
        this.bankAccountTypeNoExistException = bankAccountTypeNoExistException;
    }

    public ios.bank.generated.BankAccountTypeNoExistException getFaultInfo() {
        return this.bankAccountTypeNoExistException;
    }
}