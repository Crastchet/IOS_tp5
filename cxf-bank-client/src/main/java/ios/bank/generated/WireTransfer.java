
package ios.bank.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour wireTransfer complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="wireTransfer"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="arg0" type="{http://server.bank.ios/}customer" minOccurs="0"/&gt;
 *         &lt;element name="arg1" type="{http://server.bank.ios/}bankAccount" minOccurs="0"/&gt;
 *         &lt;element name="arg2" type="{http://server.bank.ios/}customer" minOccurs="0"/&gt;
 *         &lt;element name="arg3" type="{http://server.bank.ios/}bankAccount" minOccurs="0"/&gt;
 *         &lt;element name="arg4" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wireTransfer", propOrder = {
    "arg0",
    "arg1",
    "arg2",
    "arg3",
    "arg4"
})
public class WireTransfer {

    protected Customer arg0;
    protected BankAccount arg1;
    protected Customer arg2;
    protected BankAccount arg3;
    protected double arg4;

    /**
     * Obtient la valeur de la propriété arg0.
     * 
     * @return
     *     possible object is
     *     {@link Customer }
     *     
     */
    public Customer getArg0() {
        return arg0;
    }

    /**
     * Définit la valeur de la propriété arg0.
     * 
     * @param value
     *     allowed object is
     *     {@link Customer }
     *     
     */
    public void setArg0(Customer value) {
        this.arg0 = value;
    }

    /**
     * Obtient la valeur de la propriété arg1.
     * 
     * @return
     *     possible object is
     *     {@link BankAccount }
     *     
     */
    public BankAccount getArg1() {
        return arg1;
    }

    /**
     * Définit la valeur de la propriété arg1.
     * 
     * @param value
     *     allowed object is
     *     {@link BankAccount }
     *     
     */
    public void setArg1(BankAccount value) {
        this.arg1 = value;
    }

    /**
     * Obtient la valeur de la propriété arg2.
     * 
     * @return
     *     possible object is
     *     {@link Customer }
     *     
     */
    public Customer getArg2() {
        return arg2;
    }

    /**
     * Définit la valeur de la propriété arg2.
     * 
     * @param value
     *     allowed object is
     *     {@link Customer }
     *     
     */
    public void setArg2(Customer value) {
        this.arg2 = value;
    }

    /**
     * Obtient la valeur de la propriété arg3.
     * 
     * @return
     *     possible object is
     *     {@link BankAccount }
     *     
     */
    public BankAccount getArg3() {
        return arg3;
    }

    /**
     * Définit la valeur de la propriété arg3.
     * 
     * @param value
     *     allowed object is
     *     {@link BankAccount }
     *     
     */
    public void setArg3(BankAccount value) {
        this.arg3 = value;
    }

    /**
     * Obtient la valeur de la propriété arg4.
     * 
     */
    public double getArg4() {
        return arg4;
    }

    /**
     * Définit la valeur de la propriété arg4.
     * 
     */
    public void setArg4(double value) {
        this.arg4 = value;
    }

}
