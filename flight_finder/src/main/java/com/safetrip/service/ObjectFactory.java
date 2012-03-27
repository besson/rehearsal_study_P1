
package com.safetrip.service;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.safetrip.service package. 
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

    private final static QName _GetFlightResponse_QNAME = new QName("http://service.safetrip.com/", "getFlightResponse");
    private final static QName _GetFlight_QNAME = new QName("http://service.safetrip.com/", "getFlight");
    private final static QName _AddFlight_QNAME = new QName("http://service.safetrip.com/", "addFlight");
    private final static QName _AddFlightResponse_QNAME = new QName("http://service.safetrip.com/", "addFlightResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.safetrip.service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddFlight }
     * 
     */
    public AddFlight createAddFlight() {
        return new AddFlight();
    }

    /**
     * Create an instance of {@link GetFlight }
     * 
     */
    public GetFlight createGetFlight() {
        return new GetFlight();
    }

    /**
     * Create an instance of {@link Flight }
     * 
     */
    public Flight createFlight() {
        return new Flight();
    }

    /**
     * Create an instance of {@link GetFlightResponse }
     * 
     */
    public GetFlightResponse createGetFlightResponse() {
        return new GetFlightResponse();
    }

    /**
     * Create an instance of {@link AddFlightResponse }
     * 
     */
    public AddFlightResponse createAddFlightResponse() {
        return new AddFlightResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFlightResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.safetrip.com/", name = "getFlightResponse")
    public JAXBElement<GetFlightResponse> createGetFlightResponse(GetFlightResponse value) {
        return new JAXBElement<GetFlightResponse>(_GetFlightResponse_QNAME, GetFlightResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFlight }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.safetrip.com/", name = "getFlight")
    public JAXBElement<GetFlight> createGetFlight(GetFlight value) {
        return new JAXBElement<GetFlight>(_GetFlight_QNAME, GetFlight.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddFlight }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.safetrip.com/", name = "addFlight")
    public JAXBElement<AddFlight> createAddFlight(AddFlight value) {
        return new JAXBElement<AddFlight>(_AddFlight_QNAME, AddFlight.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddFlightResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service.safetrip.com/", name = "addFlightResponse")
    public JAXBElement<AddFlightResponse> createAddFlightResponse(AddFlightResponse value) {
        return new JAXBElement<AddFlightResponse>(_AddFlightResponse_QNAME, AddFlightResponse.class, null, value);
    }

}
