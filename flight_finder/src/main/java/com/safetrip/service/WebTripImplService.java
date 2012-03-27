
/*
 * 
 */

package com.safetrip.service;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.4.0
 * 2012-03-27T18:27:34.521-03:00
 * Generated source version: 2.4.0
 * 
 */


@WebServiceClient(name = "WebTripImplService", 
                  wsdlLocation = "http://localhost:8084/petals/services/webTripMock?wsdl",
                  targetNamespace = "http://service.safetrip.com/") 
public class WebTripImplService extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://service.safetrip.com/", "WebTripImplService");
    public final static QName WebTripImplPort = new QName("http://service.safetrip.com/", "WebTripImplPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8084/petals/services/webTripMock?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(WebTripImplService.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8084/petals/services/webTripMock?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public WebTripImplService(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public WebTripImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WebTripImplService() {
        super(WSDL_LOCATION, SERVICE);
    }
    

    /**
     * 
     * @return
     *     returns WebTrip
     */
    @WebEndpoint(name = "WebTripImplPort")
    public WebTrip getWebTripImplPort() {
        return super.getPort(WebTripImplPort, WebTrip.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WebTrip
     */
    @WebEndpoint(name = "WebTripImplPort")
    public WebTrip getWebTripImplPort(WebServiceFeature... features) {
        return super.getPort(WebTripImplPort, WebTrip.class, features);
    }

}