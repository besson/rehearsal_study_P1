
package eu.choreos.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the eu.choreos.service package. 
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

    private final static QName _GetLatitude_QNAME = new QName("http://service.choreos.eu/", "getLatitude");
    private final static QName _GetLongitude_QNAME = new QName("http://service.choreos.eu/", "getLongitude");
    private final static QName _GetCarParkCodeResponse_QNAME = new QName("http://service.choreos.eu/", "getCarParkCodeResponse");
    private final static QName _GetLatitudeResponse_QNAME = new QName("http://service.choreos.eu/", "getLatitudeResponse");
    private final static QName _GetCarParkCode_QNAME = new QName("http://service.choreos.eu/", "getCarParkCode");
    private final static QName _GetLongitudeResponse_QNAME = new QName("http://service.choreos.eu/", "getLongitudeResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: eu.choreos.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetLatitude }
     * 
     */
    public GetLatitude createGetLatitude() {
        return new GetLatitude();
    }

    /**
     * Create an instance of {@link GetCarParkCodeResponse }
     * 
     */
    public GetCarParkCodeResponse createGetCarParkCodeResponse() {
        return new GetCarParkCodeResponse();
    }

    /**
     * Create an instance of {@link GetLongitudeResponse }
     * 
     */
    public GetLongitudeResponse createGetLongitudeResponse() {
        return new GetLongitudeResponse();
    }

    /**
     * Create an instance of {@link GetCarParkCode }
     * 
     */
    public GetCarParkCode createGetCarParkCode() {
        return new GetCarParkCode();
    }

    /**
     * Create an instance of {@link GetLongitude }
     * 
     */
    public GetLongitude createGetLongitude() {
        return new GetLongitude();
    }

    /**
     * Create an instance of {@link GetLatitudeResponse }
     * 
     */
    public GetLatitudeResponse createGetLatitudeResponse() {
        return new GetLatitudeResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLatitude }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.choreos.eu/", name = "getLatitude")
    public JAXBElement<GetLatitude> createGetLatitude(GetLatitude value) {
        return new JAXBElement<GetLatitude>(_GetLatitude_QNAME, GetLatitude.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLongitude }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.choreos.eu/", name = "getLongitude")
    public JAXBElement<GetLongitude> createGetLongitude(GetLongitude value) {
        return new JAXBElement<GetLongitude>(_GetLongitude_QNAME, GetLongitude.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCarParkCodeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.choreos.eu/", name = "getCarParkCodeResponse")
    public JAXBElement<GetCarParkCodeResponse> createGetCarParkCodeResponse(GetCarParkCodeResponse value) {
        return new JAXBElement<GetCarParkCodeResponse>(_GetCarParkCodeResponse_QNAME, GetCarParkCodeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLatitudeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.choreos.eu/", name = "getLatitudeResponse")
    public JAXBElement<GetLatitudeResponse> createGetLatitudeResponse(GetLatitudeResponse value) {
        return new JAXBElement<GetLatitudeResponse>(_GetLatitudeResponse_QNAME, GetLatitudeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCarParkCode }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.choreos.eu/", name = "getCarParkCode")
    public JAXBElement<GetCarParkCode> createGetCarParkCode(GetCarParkCode value) {
        return new JAXBElement<GetCarParkCode>(_GetCarParkCode_QNAME, GetCarParkCode.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetLongitudeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.choreos.eu/", name = "getLongitudeResponse")
    public JAXBElement<GetLongitudeResponse> createGetLongitudeResponse(GetLongitudeResponse value) {
        return new JAXBElement<GetLongitudeResponse>(_GetLongitudeResponse_QNAME, GetLongitudeResponse.class, null, value);
    }

}
