
package eu.choreos.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the eu.choreos.model package. 
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

    private final static QName _FlightInfoTerminal_QNAME = new QName("http://model.choreos.eu", "terminal");
    private final static QName _FlightInfoCompany_QNAME = new QName("http://model.choreos.eu", "company");
    private final static QName _FlightInfoId_QNAME = new QName("http://model.choreos.eu", "id");
    private final static QName _FlightInfoTime_QNAME = new QName("http://model.choreos.eu", "time");
    private final static QName _FlightInfoDestination_QNAME = new QName("http://model.choreos.eu", "destination");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: eu.choreos.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FlightInfo }
     * 
     */
    public FlightInfo createFlightInfo() {
        return new FlightInfo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.choreos.eu", name = "terminal", scope = FlightInfo.class)
    public JAXBElement<String> createFlightInfoTerminal(String value) {
        return new JAXBElement<String>(_FlightInfoTerminal_QNAME, String.class, FlightInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.choreos.eu", name = "company", scope = FlightInfo.class)
    public JAXBElement<String> createFlightInfoCompany(String value) {
        return new JAXBElement<String>(_FlightInfoCompany_QNAME, String.class, FlightInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.choreos.eu", name = "id", scope = FlightInfo.class)
    public JAXBElement<String> createFlightInfoId(String value) {
        return new JAXBElement<String>(_FlightInfoId_QNAME, String.class, FlightInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.choreos.eu", name = "time", scope = FlightInfo.class)
    public JAXBElement<String> createFlightInfoTime(String value) {
        return new JAXBElement<String>(_FlightInfoTime_QNAME, String.class, FlightInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://model.choreos.eu", name = "destination", scope = FlightInfo.class)
    public JAXBElement<String> createFlightInfoDestination(String value) {
        return new JAXBElement<String>(_FlightInfoDestination_QNAME, String.class, FlightInfo.class, value);
    }

}
