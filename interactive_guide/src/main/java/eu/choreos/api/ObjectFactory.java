
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

    private final static QName _GetFlightInfoArg0_QNAME = new QName("http://api.choreos.eu/", "arg0");
    private final static QName _GetFlightInfo_QNAME = new QName("http://api.choreos.eu/", "getFlightInfo");
    private final static QName _GetFlightInfoResponse_QNAME = new QName("http://api.choreos.eu/", "getFlightInfoResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: eu.choreos.api
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetFlightInfo }
     * 
     */
    public GetFlightInfo createGetFlightInfo() {
        return new GetFlightInfo();
    }

    /**
     * Create an instance of {@link GetFlightInfoResponse }
     * 
     */
    public GetFlightInfoResponse createGetFlightInfoResponse() {
        return new GetFlightInfoResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.choreos.eu/", name = "arg0", scope = GetFlightInfo.class)
    public JAXBElement<String> createGetFlightInfoArg0(String value) {
        return new JAXBElement<String>(_GetFlightInfoArg0_QNAME, String.class, GetFlightInfo.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFlightInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.choreos.eu/", name = "getFlightInfo")
    public JAXBElement<GetFlightInfo> createGetFlightInfo(GetFlightInfo value) {
        return new JAXBElement<GetFlightInfo>(_GetFlightInfo_QNAME, GetFlightInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFlightInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.choreos.eu/", name = "getFlightInfoResponse")
    public JAXBElement<GetFlightInfoResponse> createGetFlightInfoResponse(GetFlightInfoResponse value) {
        return new JAXBElement<GetFlightInfoResponse>(_GetFlightInfoResponse_QNAME, GetFlightInfoResponse.class, null, value);
    }

}
