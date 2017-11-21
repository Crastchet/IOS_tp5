
package ios.bank.test.generated;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ios.bank.test.generated package. 
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

    private final static QName _ClearDB_QNAME = new QName("http://server.bank.ios/", "clearDB");
    private final static QName _ClearDBResponse_QNAME = new QName("http://server.bank.ios/", "clearDBResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ios.bank.test.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ClearDB }
     * 
     */
    public ClearDB createClearDB() {
        return new ClearDB();
    }

    /**
     * Create an instance of {@link ClearDBResponse }
     * 
     */
    public ClearDBResponse createClearDBResponse() {
        return new ClearDBResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClearDB }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.bank.ios/", name = "clearDB")
    public JAXBElement<ClearDB> createClearDB(ClearDB value) {
        return new JAXBElement<ClearDB>(_ClearDB_QNAME, ClearDB.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ClearDBResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://server.bank.ios/", name = "clearDBResponse")
    public JAXBElement<ClearDBResponse> createClearDBResponse(ClearDBResponse value) {
        return new JAXBElement<ClearDBResponse>(_ClearDBResponse_QNAME, ClearDBResponse.class, null, value);
    }

}
