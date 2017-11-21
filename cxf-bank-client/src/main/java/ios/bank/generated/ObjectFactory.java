
package ios.bank.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ios.bank.generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _CreateBankAccount_QNAME = new QName("http://server.bank.ios/", "createBankAccount");
    private final static QName _CreateBankAccountResponse_QNAME = new QName("http://server.bank.ios/", "createBankAccountResponse");
    private final static QName _CreateCustomer_QNAME = new QName("http://server.bank.ios/", "createCustomer");
    private final static QName _CreateCustomerResponse_QNAME = new QName("http://server.bank.ios/", "createCustomerResponse");
    private final static QName _CreditMoney_QNAME = new QName("http://server.bank.ios/", "creditMoney");
    private final static QName _CreditMoneyResponse_QNAME = new QName("http://server.bank.ios/", "creditMoneyResponse");
    private final static QName _DebitMoney_QNAME = new QName("http://server.bank.ios/", "debitMoney");
    private final static QName _DebitMoneyResponse_QNAME = new QName("http://server.bank.ios/", "debitMoneyResponse");
    private final static QName _GetBalance_QNAME = new QName("http://server.bank.ios/", "getBalance");
    private final static QName _GetBalanceResponse_QNAME = new QName("http://server.bank.ios/", "getBalanceResponse");
    private final static QName _GetBankAccount_QNAME = new QName("http://server.bank.ios/", "getBankAccount");
    private final static QName _GetBankAccountResponse_QNAME = new QName("http://server.bank.ios/", "getBankAccountResponse");
    private final static QName _GetCustomer_QNAME = new QName("http://server.bank.ios/", "getCustomer");
    private final static QName _GetCustomerResponse_QNAME = new QName("http://server.bank.ios/", "getCustomerResponse");
    private final static QName _InternTransfer_QNAME = new QName("http://server.bank.ios/", "internTransfer");
    private final static QName _InternTransferResponse_QNAME = new QName("http://server.bank.ios/", "internTransferResponse");
    private final static QName _RemoveCustomer_QNAME = new QName("http://server.bank.ios/", "removeCustomer");
    private final static QName _RemoveCustomerResponse_QNAME = new QName("http://server.bank.ios/", "removeCustomerResponse");
    private final static QName _SettleAccount_QNAME = new QName("http://server.bank.ios/", "settleAccount");
    private final static QName _SettleAccountResponse_QNAME = new QName("http://server.bank.ios/", "settleAccountResponse");
    private final static QName _WireTransfer_QNAME = new QName("http://server.bank.ios/", "wireTransfer");
    private final static QName _WireTransferResponse_QNAME = new QName("http://server.bank.ios/", "wireTransferResponse");
    private final static QName _BankAccountNoExistException_QNAME = new QName("http://server.bank.ios/", "BankAccountNoExistException");
    private final static QName _IncorrectAmountException_QNAME = new QName("http://server.bank.ios/", "IncorrectAmountException");
    private final static QName _CustomerNoExistException_QNAME = new QName("http://server.bank.ios/", "CustomerNoExistException");
    private final static QName _BankAccountNoBelongToCustomer_QNAME = new QName("http://server.bank.ios/", "BankAccountNoBelongToCustomer");
    private final static QName _BankAccountTypeNoExistException_QNAME = new QName("http://server.bank.ios/", "BankAccountTypeNoExistException");
    private final static QName _BankAccountTypeNoExistForCustomerException_QNAME = new QName("http://server.bank.ios/", "BankAccountTypeNoExistForCustomerException");
    private final static QName _BankAccountAlreadyExistException_QNAME = new QName("http://server.bank.ios/", "BankAccountAlreadyExistException");
    private final static QName _CustomerAlreadyExistException_QNAME = new QName("http://server.bank.ios/", "CustomerAlreadyExistException");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ios.bank.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CreateBankAccount }
     * 
     */
    public CreateBankAccount createCreateBankAccount() {
        return new CreateBankAccount();
    }

    /**
     * Create an instance of {@link CreateBankAccountResponse }
     * 
     */
    public CreateBankAccountResponse createCreateBankAccountResponse() {
        return new CreateBankAccountResponse();
    }

    /**
     * Create an instance of {@link CreateCustomer }
     * 
     */
    public CreateCustomer createCreateCustomer() {
        return new CreateCustomer();
    }

    /**
     * Create an instance of {@link CreateCustomerResponse }
     * 
     */
    public CreateCustomerResponse createCreateCustomerResponse() {
        return new CreateCustomerResponse();
    }

    /**
     * Create an instance of {@link CreditMoney }
     * 
     */
    public CreditMoney createCreditMoney() {
        return new CreditMoney();
    }

    /**
     * Create an instance of {@link CreditMoneyResponse }
     * 
     */
    public CreditMoneyResponse createCreditMoneyResponse() {
        return new CreditMoneyResponse();
    }

    /**
     * Create an instance of {@link DebitMoney }
     * 
     */
    public DebitMoney createDebitMoney() {
        return new DebitMoney();
    }

    /**
     * Create an instance of {@link DebitMoneyResponse }
     * 
     */
    public DebitMoneyResponse createDebitMoneyResponse() {
        return new DebitMoneyResponse();
    }

    /**
     * Create an instance of {@link GetBalance }
     * 
     */
    public GetBalance createGetBalance() {
        return new GetBalance();
    }

    /**
     * Create an instance of {@link GetBalanceResponse }
     * 
     */
    public GetBalanceResponse createGetBalanceResponse() {
        return new GetBalanceResponse();
    }

    /**
     * Create an instance of {@link GetBankAccount }
     * 
     */
    public GetBankAccount createGetBankAccount() {
        return new GetBankAccount();
    }

    /**
     * Create an instance of {@link GetBankAccountResponse }
     * 
     */
    public GetBankAccountResponse createGetBankAccountResponse() {
        return new GetBankAccountResponse();
    }

    /**
     * Create an instance of {@link GetCustomer }
     * 
     */
    public GetCustomer createGetCustomer() {
        return new GetCustomer();
    }

    /**
     * Create an instance of {@link GetCustomerResponse }
     * 
     */
    public GetCustomerResponse createGetCustomerResponse() {
        return new GetCustomerResponse();
    }

    /**
     * Create an instance of {@link InternTransfer }
     * 
     */
    public InternTransfer createInternTransfer() {
        return new InternTransfer();
    }

    /**
     * Create an instance of {@link InternTransferResponse }
     * 
     */
    public InternTransferResponse createInternTransferResponse() {
        return new InternTransferResponse();
    }

    /**
     * Create an instance of {@link RemoveCustomer }
     * 
     */
    public RemoveCustomer createRemoveCustomer() {
        return new RemoveCustomer();
    }

    /**
     * Create an instance of {@link RemoveCustomerResponse }
     * 
     */
    public RemoveCustomerResponse createRemoveCustomerResponse() {
        return new RemoveCustomerResponse();
    }

    /**
     * Create an instance of {@link SettleAccount }
     * 
     */
    public SettleAccount createSettleAccount() {
        return new SettleAccount();
    }

    /**
     * Create an instance of {@link SettleAccountResponse }
     * 
     */
    public SettleAccountResponse createSettleAccountResponse() {
        return new SettleAccountResponse();
    }

    /**
     * Create an instance of {@link WireTransfer }
     * 
     */
    public WireTransfer createWireTransfer() {
        return new WireTransfer();
    }

    /**
     * Create an instance of {@link WireTransferResponse }
     * 
     */
    public WireTransferResponse createWireTransferResponse() {
        return new WireTransferResponse();
    }

    /**
     * Create an instance of {@link BankAccountNoExistException }
     * 
     */
    public BankAccountNoExistException createBankAccountNoExistException() {
        return new BankAccountNoExistException();
    }

    /**
     * Create an instance of {@link IncorrectAmountException }
     * 
     */
    public IncorrectAmountException createIncorrectAmountException() {
        return new IncorrectAmountException();
    }

    /**
     * Create an instance of {@link CustomerNoExistException }
     * 
     */
    public CustomerNoExistException createCustomerNoExistException() {
        return new CustomerNoExistException();
    }

    /**
     * Create an instance of {@link BankAccountNoBelongToCustomer }
     * 
     */
    public BankAccountNoBelongToCustomer createBankAccountNoBelongToCustomer() {
        return new BankAccountNoBelongToCustomer();
    }

    /**
     * Create an instance of {@link BankAccountTypeNoExistException }
     * 
     */
    public BankAccountTypeNoExistException createBankAccountTypeNoExistException() {
        return new BankAccountTypeNoExistException();
    }

    /**
     * Create an instance of {@link BankAccountTypeNoExistForCustomerException }
     * 
     */
    public BankAccountTypeNoExistForCustomerException createBankAccountTypeNoExistForCustomerException() {
        return new BankAccountTypeNoExistForCustomerException();
    }

    /**
     * Create an instance of {@link BankAccountAlreadyExistException }
     * 
     */
    public BankAccountAlreadyExistException createBankAccountAlreadyExistException() {
        return new BankAccountAlreadyExistException();
    }

    /**
     * Create an instance of {@link CustomerAlreadyExistException }
     * 
     */
    public CustomerAlreadyExistException createCustomerAlreadyExistException() {
        return new CustomerAlreadyExistException();
    }

    /**
     * Create an instance of {@link BankAccount }
     * 
     */
    public BankAccount createBankAccount() {
        return new BankAccount();
    }

    /**
     * Create an instance of {@link Customer }
     * 
     */
    public Customer createCustomer() {
        return new Customer();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateBankAccount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.bank.ios/", name = "createBankAccount")
    public JAXBElement<CreateBankAccount> createCreateBankAccount(CreateBankAccount value) {
        return new JAXBElement<CreateBankAccount>(_CreateBankAccount_QNAME, CreateBankAccount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateBankAccountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.bank.ios/", name = "createBankAccountResponse")
    public JAXBElement<CreateBankAccountResponse> createCreateBankAccountResponse(CreateBankAccountResponse value) {
        return new JAXBElement<CreateBankAccountResponse>(_CreateBankAccountResponse_QNAME, CreateBankAccountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateCustomer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.bank.ios/", name = "createCustomer")
    public JAXBElement<CreateCustomer> createCreateCustomer(CreateCustomer value) {
        return new JAXBElement<CreateCustomer>(_CreateCustomer_QNAME, CreateCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateCustomerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.bank.ios/", name = "createCustomerResponse")
    public JAXBElement<CreateCustomerResponse> createCreateCustomerResponse(CreateCustomerResponse value) {
        return new JAXBElement<CreateCustomerResponse>(_CreateCustomerResponse_QNAME, CreateCustomerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreditMoney }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.bank.ios/", name = "creditMoney")
    public JAXBElement<CreditMoney> createCreditMoney(CreditMoney value) {
        return new JAXBElement<CreditMoney>(_CreditMoney_QNAME, CreditMoney.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreditMoneyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.bank.ios/", name = "creditMoneyResponse")
    public JAXBElement<CreditMoneyResponse> createCreditMoneyResponse(CreditMoneyResponse value) {
        return new JAXBElement<CreditMoneyResponse>(_CreditMoneyResponse_QNAME, CreditMoneyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DebitMoney }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.bank.ios/", name = "debitMoney")
    public JAXBElement<DebitMoney> createDebitMoney(DebitMoney value) {
        return new JAXBElement<DebitMoney>(_DebitMoney_QNAME, DebitMoney.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DebitMoneyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.bank.ios/", name = "debitMoneyResponse")
    public JAXBElement<DebitMoneyResponse> createDebitMoneyResponse(DebitMoneyResponse value) {
        return new JAXBElement<DebitMoneyResponse>(_DebitMoneyResponse_QNAME, DebitMoneyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBalance }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.bank.ios/", name = "getBalance")
    public JAXBElement<GetBalance> createGetBalance(GetBalance value) {
        return new JAXBElement<GetBalance>(_GetBalance_QNAME, GetBalance.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBalanceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.bank.ios/", name = "getBalanceResponse")
    public JAXBElement<GetBalanceResponse> createGetBalanceResponse(GetBalanceResponse value) {
        return new JAXBElement<GetBalanceResponse>(_GetBalanceResponse_QNAME, GetBalanceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBankAccount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.bank.ios/", name = "getBankAccount")
    public JAXBElement<GetBankAccount> createGetBankAccount(GetBankAccount value) {
        return new JAXBElement<GetBankAccount>(_GetBankAccount_QNAME, GetBankAccount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetBankAccountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.bank.ios/", name = "getBankAccountResponse")
    public JAXBElement<GetBankAccountResponse> createGetBankAccountResponse(GetBankAccountResponse value) {
        return new JAXBElement<GetBankAccountResponse>(_GetBankAccountResponse_QNAME, GetBankAccountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCustomer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.bank.ios/", name = "getCustomer")
    public JAXBElement<GetCustomer> createGetCustomer(GetCustomer value) {
        return new JAXBElement<GetCustomer>(_GetCustomer_QNAME, GetCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCustomerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.bank.ios/", name = "getCustomerResponse")
    public JAXBElement<GetCustomerResponse> createGetCustomerResponse(GetCustomerResponse value) {
        return new JAXBElement<GetCustomerResponse>(_GetCustomerResponse_QNAME, GetCustomerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InternTransfer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.bank.ios/", name = "internTransfer")
    public JAXBElement<InternTransfer> createInternTransfer(InternTransfer value) {
        return new JAXBElement<InternTransfer>(_InternTransfer_QNAME, InternTransfer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InternTransferResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.bank.ios/", name = "internTransferResponse")
    public JAXBElement<InternTransferResponse> createInternTransferResponse(InternTransferResponse value) {
        return new JAXBElement<InternTransferResponse>(_InternTransferResponse_QNAME, InternTransferResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveCustomer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.bank.ios/", name = "removeCustomer")
    public JAXBElement<RemoveCustomer> createRemoveCustomer(RemoveCustomer value) {
        return new JAXBElement<RemoveCustomer>(_RemoveCustomer_QNAME, RemoveCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemoveCustomerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.bank.ios/", name = "removeCustomerResponse")
    public JAXBElement<RemoveCustomerResponse> createRemoveCustomerResponse(RemoveCustomerResponse value) {
        return new JAXBElement<RemoveCustomerResponse>(_RemoveCustomerResponse_QNAME, RemoveCustomerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SettleAccount }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.bank.ios/", name = "settleAccount")
    public JAXBElement<SettleAccount> createSettleAccount(SettleAccount value) {
        return new JAXBElement<SettleAccount>(_SettleAccount_QNAME, SettleAccount.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SettleAccountResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.bank.ios/", name = "settleAccountResponse")
    public JAXBElement<SettleAccountResponse> createSettleAccountResponse(SettleAccountResponse value) {
        return new JAXBElement<SettleAccountResponse>(_SettleAccountResponse_QNAME, SettleAccountResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WireTransfer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.bank.ios/", name = "wireTransfer")
    public JAXBElement<WireTransfer> createWireTransfer(WireTransfer value) {
        return new JAXBElement<WireTransfer>(_WireTransfer_QNAME, WireTransfer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link WireTransferResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.bank.ios/", name = "wireTransferResponse")
    public JAXBElement<WireTransferResponse> createWireTransferResponse(WireTransferResponse value) {
        return new JAXBElement<WireTransferResponse>(_WireTransferResponse_QNAME, WireTransferResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BankAccountNoExistException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.bank.ios/", name = "BankAccountNoExistException")
    public JAXBElement<BankAccountNoExistException> createBankAccountNoExistException(BankAccountNoExistException value) {
        return new JAXBElement<BankAccountNoExistException>(_BankAccountNoExistException_QNAME, BankAccountNoExistException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IncorrectAmountException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.bank.ios/", name = "IncorrectAmountException")
    public JAXBElement<IncorrectAmountException> createIncorrectAmountException(IncorrectAmountException value) {
        return new JAXBElement<IncorrectAmountException>(_IncorrectAmountException_QNAME, IncorrectAmountException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomerNoExistException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.bank.ios/", name = "CustomerNoExistException")
    public JAXBElement<CustomerNoExistException> createCustomerNoExistException(CustomerNoExistException value) {
        return new JAXBElement<CustomerNoExistException>(_CustomerNoExistException_QNAME, CustomerNoExistException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BankAccountNoBelongToCustomer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.bank.ios/", name = "BankAccountNoBelongToCustomer")
    public JAXBElement<BankAccountNoBelongToCustomer> createBankAccountNoBelongToCustomer(BankAccountNoBelongToCustomer value) {
        return new JAXBElement<BankAccountNoBelongToCustomer>(_BankAccountNoBelongToCustomer_QNAME, BankAccountNoBelongToCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BankAccountTypeNoExistException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.bank.ios/", name = "BankAccountTypeNoExistException")
    public JAXBElement<BankAccountTypeNoExistException> createBankAccountTypeNoExistException(BankAccountTypeNoExistException value) {
        return new JAXBElement<BankAccountTypeNoExistException>(_BankAccountTypeNoExistException_QNAME, BankAccountTypeNoExistException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BankAccountTypeNoExistForCustomerException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.bank.ios/", name = "BankAccountTypeNoExistForCustomerException")
    public JAXBElement<BankAccountTypeNoExistForCustomerException> createBankAccountTypeNoExistForCustomerException(BankAccountTypeNoExistForCustomerException value) {
        return new JAXBElement<BankAccountTypeNoExistForCustomerException>(_BankAccountTypeNoExistForCustomerException_QNAME, BankAccountTypeNoExistForCustomerException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link BankAccountAlreadyExistException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.bank.ios/", name = "BankAccountAlreadyExistException")
    public JAXBElement<BankAccountAlreadyExistException> createBankAccountAlreadyExistException(BankAccountAlreadyExistException value) {
        return new JAXBElement<BankAccountAlreadyExistException>(_BankAccountAlreadyExistException_QNAME, BankAccountAlreadyExistException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CustomerAlreadyExistException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.bank.ios/", name = "CustomerAlreadyExistException")
    public JAXBElement<CustomerAlreadyExistException> createCustomerAlreadyExistException(CustomerAlreadyExistException value) {
        return new JAXBElement<CustomerAlreadyExistException>(_CustomerAlreadyExistException_QNAME, CustomerAlreadyExistException.class, null, value);
    }

}
