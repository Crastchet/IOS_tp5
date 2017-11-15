
package ios.bank.generated;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.2.0
 * 2017-11-15T16:40:50.907+01:00
 * Generated source version: 3.2.0
 * 
 */
public final class WebServiceBankInterface_WebServiceBankPort_Client {

    private static final QName SERVICE_NAME = new QName("http://server.bank.ios/", "WebServiceBankService");

    private WebServiceBankInterface_WebServiceBankPort_Client() {
    }

    public static void main(String args[]) throws java.lang.Exception {
        URL wsdlURL = WebServiceBankService.WSDL_LOCATION;
        if (args.length > 0 && args[0] != null && !"".equals(args[0])) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        WebServiceBankService ss = new WebServiceBankService(wsdlURL, SERVICE_NAME);
        WebServiceBankInterface port = ss.getWebServiceBankPort();  
        
        {
        System.out.println("Invoking creditMoney...");
        ios.bank.generated.BankAccount _creditMoney_arg0 = null;
        double _creditMoney_arg1 = 0.0;
        try {
            double _creditMoney__return = port.creditMoney(_creditMoney_arg0, _creditMoney_arg1);
            System.out.println("creditMoney.result=" + _creditMoney__return);

        } catch (BankAccountNoExistException_Exception e) { 
            System.out.println("Expected exception: BankAccountNoExistException has occurred.");
            System.out.println(e.toString());
        } catch (IncorrectAmountException_Exception e) { 
            System.out.println("Expected exception: IncorrectAmountException has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking removeCustomer...");
        ios.bank.generated.Customer _removeCustomer_arg0 = null;
        try {
            port.removeCustomer(_removeCustomer_arg0);

        } catch (CustomerNoExistException_Exception e) { 
            System.out.println("Expected exception: CustomerNoExistException has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking wireTransfer...");
        ios.bank.generated.Customer _wireTransfer_arg0 = null;
        ios.bank.generated.BankAccount _wireTransfer_arg1 = null;
        ios.bank.generated.Customer _wireTransfer_arg2 = null;
        ios.bank.generated.BankAccount _wireTransfer_arg3 = null;
        double _wireTransfer_arg4 = 0.0;
        try {
            port.wireTransfer(_wireTransfer_arg0, _wireTransfer_arg1, _wireTransfer_arg2, _wireTransfer_arg3, _wireTransfer_arg4);

        } catch (BankAccountNoExistException_Exception e) { 
            System.out.println("Expected exception: BankAccountNoExistException has occurred.");
            System.out.println(e.toString());
        } catch (CustomerNoExistException_Exception e) { 
            System.out.println("Expected exception: CustomerNoExistException has occurred.");
            System.out.println(e.toString());
        } catch (IncorrectAmountException_Exception e) { 
            System.out.println("Expected exception: IncorrectAmountException has occurred.");
            System.out.println(e.toString());
        } catch (BankAccountNoBelongToCustomer_Exception e) { 
            System.out.println("Expected exception: BankAccountNoBelongToCustomer has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking getCustomer...");
        java.lang.String _getCustomer_arg0 = "";
        java.lang.String _getCustomer_arg1 = "";
        javax.xml.datatype.XMLGregorianCalendar _getCustomer_arg2 = null;
        try {
            ios.bank.generated.Customer _getCustomer__return = port.getCustomer(_getCustomer_arg0, _getCustomer_arg1, _getCustomer_arg2);
            System.out.println("getCustomer.result=" + _getCustomer__return);

        } catch (CustomerNoExistException_Exception e) { 
            System.out.println("Expected exception: CustomerNoExistException has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking settleAccount...");
        ios.bank.generated.BankAccount _settleAccount_arg0 = null;
        try {
            double _settleAccount__return = port.settleAccount(_settleAccount_arg0);
            System.out.println("settleAccount.result=" + _settleAccount__return);

        } catch (BankAccountNoExistException_Exception e) { 
            System.out.println("Expected exception: BankAccountNoExistException has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking getBalance...");
        ios.bank.generated.BankAccount _getBalance_arg0 = null;
        try {
            double _getBalance__return = port.getBalance(_getBalance_arg0);
            System.out.println("getBalance.result=" + _getBalance__return);

        } catch (BankAccountNoExistException_Exception e) { 
            System.out.println("Expected exception: BankAccountNoExistException has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking getBankAccount...");
        ios.bank.generated.Customer _getBankAccount_arg0 = null;
        java.lang.String _getBankAccount_arg1 = "";
        try {
            ios.bank.generated.BankAccount _getBankAccount__return = port.getBankAccount(_getBankAccount_arg0, _getBankAccount_arg1);
            System.out.println("getBankAccount.result=" + _getBankAccount__return);

        } catch (BankAccountNoExistException_Exception e) { 
            System.out.println("Expected exception: BankAccountNoExistException has occurred.");
            System.out.println(e.toString());
        } catch (CustomerNoExistException_Exception e) { 
            System.out.println("Expected exception: CustomerNoExistException has occurred.");
            System.out.println(e.toString());
        } catch (BankAccountTypeNoExistException_Exception e) { 
            System.out.println("Expected exception: BankAccountTypeNoExistException has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking debitMoney...");
        ios.bank.generated.BankAccount _debitMoney_arg0 = null;
        double _debitMoney_arg1 = 0.0;
        try {
            double _debitMoney__return = port.debitMoney(_debitMoney_arg0, _debitMoney_arg1);
            System.out.println("debitMoney.result=" + _debitMoney__return);

        } catch (BankAccountNoExistException_Exception e) { 
            System.out.println("Expected exception: BankAccountNoExistException has occurred.");
            System.out.println(e.toString());
        } catch (IncorrectAmountException_Exception e) { 
            System.out.println("Expected exception: IncorrectAmountException has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking internTransfer...");
        ios.bank.generated.Customer _internTransfer_arg0 = null;
        java.lang.String _internTransfer_arg1 = "";
        java.lang.String _internTransfer_arg2 = "";
        double _internTransfer_arg3 = 0.0;
        try {
            port.internTransfer(_internTransfer_arg0, _internTransfer_arg1, _internTransfer_arg2, _internTransfer_arg3);

        } catch (CustomerNoExistException_Exception e) { 
            System.out.println("Expected exception: CustomerNoExistException has occurred.");
            System.out.println(e.toString());
        } catch (BankAccountTypeNoExistForCustomerException_Exception e) { 
            System.out.println("Expected exception: BankAccountTypeNoExistForCustomerException has occurred.");
            System.out.println(e.toString());
        } catch (BankAccountTypeNoExistException_Exception e) { 
            System.out.println("Expected exception: BankAccountTypeNoExistException has occurred.");
            System.out.println(e.toString());
        } catch (IncorrectAmountException_Exception e) { 
            System.out.println("Expected exception: IncorrectAmountException has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking createBankAccount...");
        ios.bank.generated.Customer _createBankAccount_arg0 = null;
        java.lang.String _createBankAccount_arg1 = "";
        try {
            ios.bank.generated.BankAccount _createBankAccount__return = port.createBankAccount(_createBankAccount_arg0, _createBankAccount_arg1);
            System.out.println("createBankAccount.result=" + _createBankAccount__return);

        } catch (BankAccountAlreadyExistException_Exception e) { 
            System.out.println("Expected exception: BankAccountAlreadyExistException has occurred.");
            System.out.println(e.toString());
        } catch (CustomerNoExistException_Exception e) { 
            System.out.println("Expected exception: CustomerNoExistException has occurred.");
            System.out.println(e.toString());
        } catch (BankAccountTypeNoExistException_Exception e) { 
            System.out.println("Expected exception: BankAccountTypeNoExistException has occurred.");
            System.out.println(e.toString());
        }
            }
        {
        System.out.println("Invoking createCustomer...");
        java.lang.String _createCustomer_arg0 = "";
        java.lang.String _createCustomer_arg1 = "";
        javax.xml.datatype.XMLGregorianCalendar _createCustomer_arg2 = null;
        try {
            ios.bank.generated.Customer _createCustomer__return = port.createCustomer(_createCustomer_arg0, _createCustomer_arg1, _createCustomer_arg2);
            System.out.println("createCustomer.result=" + _createCustomer__return);

        } catch (CustomerAlreadyExistException_Exception e) { 
            System.out.println("Expected exception: CustomerAlreadyExistException has occurred.");
            System.out.println(e.toString());
        }
            }

        System.exit(0);
    }

}