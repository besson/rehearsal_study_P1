
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

    private final static QName _CalculateLocationsResponse_QNAME = new QName("http://api.choreos.eu/", "calculateLocationsResponse");
    private final static QName _GetFlightAndCarParkLocation_QNAME = new QName("http://api.choreos.eu/", "getFlightAndCarParkLocation");
    private final static QName _CalculateLocations_QNAME = new QName("http://api.choreos.eu/", "calculateLocations");
    private final static QName _SetCarParkInfoResponse_QNAME = new QName("http://api.choreos.eu/", "setCarParkInfoResponse");
    private final static QName _GetFlightAndCarParkLocationResponse_QNAME = new QName("http://api.choreos.eu/", "getFlightAndCarParkLocationResponse");
    private final static QName _SetCarParkInfo_QNAME = new QName("http://api.choreos.eu/", "setCarParkInfo");
    private final static QName _CalculateLocationsResponseReturn_QNAME = new QName("http://api.choreos.eu/", "return");
    private final static QName _GetFlightAndCarParkLocationArg0_QNAME = new QName("http://api.choreos.eu/", "arg0");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: eu.choreos.api
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetFlightAndCarParkLocation }
     * 
     */
    public GetFlightAndCarParkLocation createGetFlightAndCarParkLocation() {
        return new GetFlightAndCarParkLocation();
    }

    /**
     * Create an instance of {@link CalculateLocationsResponse }
     * 
     */
    public CalculateLocationsResponse createCalculateLocationsResponse() {
        return new CalculateLocationsResponse();
    }

    /**
     * Create an instance of {@link SetCarParkInfoResponse }
     * 
     */
    public SetCarParkInfoResponse createSetCarParkInfoResponse() {
        return new SetCarParkInfoResponse();
    }

    /**
     * Create an instance of {@link SetCarParkInfo }
     * 
     */
    public SetCarParkInfo createSetCarParkInfo() {
        return new SetCarParkInfo();
    }

    /**
     * Create an instance of {@link GetFlightAndCarParkLocationResponse }
     * 
     */
    public GetFlightAndCarParkLocationResponse createGetFlightAndCarParkLocationResponse() {
        return new GetFlightAndCarParkLocationResponse();
    }

    /**
     * Create an instance of {@link CalculateLocations }
     * 
     */
    public CalculateLocations createCalculateLocations() {
        return new CalculateLocations();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculateLocationsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.choreos.eu/", name = "calculateLocationsResponse")
    public JAXBElement<CalculateLocationsResponse> createCalculateLocationsResponse(CalculateLocationsResponse value) {
        return new JAXBElement<CalculateLocationsResponse>(_CalculateLocationsResponse_QNAME, CalculateLocationsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFlightAndCarParkLocation }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.choreos.eu/", name = "getFlightAndCarParkLocation")
    public JAXBElement<GetFlightAndCarParkLocation> createGetFlightAndCarParkLocation(GetFlightAndCarParkLocation value) {
        return new JAXBElement<GetFlightAndCarParkLocation>(_GetFlightAndCarParkLocation_QNAME, GetFlightAndCarParkLocation.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CalculateLocations }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.choreos.eu/", name = "calculateLocations")
    public JAXBElement<CalculateLocations> createCalculateLocations(CalculateLocations value) {
        return new JAXBElement<CalculateLocations>(_CalculateLocations_QNAME, CalculateLocations.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetCarParkInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.choreos.eu/", name = "setCarParkInfoResponse")
    public JAXBElement<SetCarParkInfoResponse> createSetCarParkInfoResponse(SetCarParkInfoResponse value) {
        return new JAXBElement<SetCarParkInfoResponse>(_SetCarParkInfoResponse_QNAME, SetCarParkInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFlightAndCarParkLocationResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.choreos.eu/", name = "getFlightAndCarParkLocationResponse")
    public JAXBElement<GetFlightAndCarParkLocationResponse> createGetFlightAndCarParkLocationResponse(GetFlightAndCarParkLocationResponse value) {
        return new JAXBElement<GetFlightAndCarParkLocationResponse>(_GetFlightAndCarParkLocationResponse_QNAME, GetFlightAndCarParkLocationResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SetCarParkInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.choreos.eu/", name = "setCarParkInfo")
    public JAXBElement<SetCarParkInfo> createSetCarParkInfo(SetCarParkInfo value) {
        return new JAXBElement<SetCarParkInfo>(_SetCarParkInfo_QNAME, SetCarParkInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.choreos.eu/", name = "return", scope = CalculateLocationsResponse.class)
    public JAXBElement<String> createCalculateLocationsResponseReturn(String value) {
        return new JAXBElement<String>(_CalculateLocationsResponseReturn_QNAME, String.class, CalculateLocationsResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.choreos.eu/", name = "arg0", scope = GetFlightAndCarParkLocation.class)
    public JAXBElement<String> createGetFlightAndCarParkLocationArg0(String value) {
        return new JAXBElement<String>(_GetFlightAndCarParkLocationArg0_QNAME, String.class, GetFlightAndCarParkLocation.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.choreos.eu/", name = "return", scope = GetFlightAndCarParkLocationResponse.class)
    public JAXBElement<String> createGetFlightAndCarParkLocationResponseReturn(String value) {
        return new JAXBElement<String>(_CalculateLocationsResponseReturn_QNAME, String.class, GetFlightAndCarParkLocationResponse.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://api.choreos.eu/", name = "arg0", scope = CalculateLocations.class)
    public JAXBElement<String> createCalculateLocationsArg0(String value) {
        return new JAXBElement<String>(_GetFlightAndCarParkLocationArg0_QNAME, String.class, CalculateLocations.class, value);
    }

}
