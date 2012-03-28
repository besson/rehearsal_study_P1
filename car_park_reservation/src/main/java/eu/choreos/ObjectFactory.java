
package eu.choreos;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the eu.choreos package. 
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

    private final static QName _CarParkEntryLatitude_QNAME = new QName("http://choreos.eu", "latitude");
    private final static QName _CarParkEntryLongitude_QNAME = new QName("http://choreos.eu", "longitude");
    private final static QName _CarParkEntryPId_QNAME = new QName("http://choreos.eu", "pId");
    private final static QName _CarParkEntryCpId_QNAME = new QName("http://choreos.eu", "cpId");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: eu.choreos
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link CarParkEntry }
     * 
     */
    public CarParkEntry createCarParkEntry() {
        return new CarParkEntry();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://choreos.eu", name = "latitude", scope = CarParkEntry.class)
    public JAXBElement<String> createCarParkEntryLatitude(String value) {
        return new JAXBElement<String>(_CarParkEntryLatitude_QNAME, String.class, CarParkEntry.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://choreos.eu", name = "longitude", scope = CarParkEntry.class)
    public JAXBElement<String> createCarParkEntryLongitude(String value) {
        return new JAXBElement<String>(_CarParkEntryLongitude_QNAME, String.class, CarParkEntry.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://choreos.eu", name = "pId", scope = CarParkEntry.class)
    public JAXBElement<String> createCarParkEntryPId(String value) {
        return new JAXBElement<String>(_CarParkEntryPId_QNAME, String.class, CarParkEntry.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://choreos.eu", name = "cpId", scope = CarParkEntry.class)
    public JAXBElement<String> createCarParkEntryCpId(String value) {
        return new JAXBElement<String>(_CarParkEntryCpId_QNAME, String.class, CarParkEntry.class, value);
    }

}
