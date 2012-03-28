
package eu.choreos.api;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the eu.choreos.api package. 
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

    private final static QName _SetPassengerInfo_QNAME = new QName("http://api.choreos.eu/", "setPassengerInfo");
    private final static QName _SetPassengerInfoResponse_QNAME = new QName("http://api.choreos.eu/", "setPassengerInfoResponse");
    private final static QName _SetPassengerInfoResponseReturn_QNAME = new QName("http://api.choreos.eu/", "return");
    private final static QName _SetPassengerInfoArg1_QNAME = new QName("http://api.choreos.eu/", "arg1");
    private final static QName _SetPassengerInfoArg0_QNAME = new QName("http://api.choreos.eu/", "arg0");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: eu.choreos.api
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SetPassengerInfoResponse }
     * 
     */
    public SetPassengerInfoResponse createSetPassengerInfoResponse() {
        return new SetPassengerInfoResponse();
    }

    /**
     * Create an instance of {@link SetPassengerInfo }
     * 
     */
    public SetPassengerInfo createSetPassengerInfo() {
        return new SetPassengerInfo();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetPassengerInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.choreos.eu/", name = "setPassengerInfo")
    public JAXBElement<SetPassengerInfo> createSetPassengerInfo(SetPassengerInfo value) {
        return new JAXBElement<SetPassengerInfo>(_SetPassengerInfo_QNAME, SetPassengerInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetPassengerInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.choreos.eu/", name = "setPassengerInfoResponse")
    public JAXBElement<SetPassengerInfoResponse> createSetPassengerInfoResponse(SetPassengerInfoResponse value) {
        return new JAXBElement<SetPassengerInfoResponse>(_SetPassengerInfoResponse_QNAME, SetPassengerInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.choreos.eu/", name = "return", scope = SetPassengerInfoResponse.class)
    public JAXBElement<String> createSetPassengerInfoResponseReturn(String value) {
        return new JAXBElement<String>(_SetPassengerInfoResponseReturn_QNAME, String.class, SetPassengerInfoResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.choreos.eu/", name = "arg1", scope = SetPassengerInfo.class)
    public JAXBElement<String> createSetPassengerInfoArg1(String value) {
        return new JAXBElement<String>(_SetPassengerInfoArg1_QNAME, String.class, SetPassengerInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.choreos.eu/", name = "arg0", scope = SetPassengerInfo.class)
    public JAXBElement<String> createSetPassengerInfoArg0(String value) {
        return new JAXBElement<String>(_SetPassengerInfoArg0_QNAME, String.class, SetPassengerInfo.class, value);
    }

}
