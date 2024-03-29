
/*
 * 
 */

package eu.choreos.api;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;
import javax.xml.ws.Service;

/**
 * This class was generated by Apache CXF 2.4.0
 * 2012-03-28T12:03:17.806-03:00
 * Generated source version: 2.4.0
 * 
 */


@WebServiceClient(name = "FlightFinder", 
                  wsdlLocation = "http://localhost:8002/services/flightFinder?wsdl",
                  targetNamespace = "http://api.choreos.eu/") 
public class FlightFinder extends Service {

    public final static URL WSDL_LOCATION;

    public final static QName SERVICE = new QName("http://api.choreos.eu/", "FlightFinder");
    public final static QName FlightFinderPort = new QName("http://api.choreos.eu/", "FlightFinderPort");
    static {
        URL url = null;
        try {
            url = new URL("http://localhost:8002/services/flightFinder?wsdl");
        } catch (MalformedURLException e) {
            java.util.logging.Logger.getLogger(FlightFinder.class.getName())
                .log(java.util.logging.Level.INFO, 
                     "Can not initialize the default wsdl from {0}", "http://localhost:8002/services/flightFinder?wsdl");
        }
        WSDL_LOCATION = url;
    }

    public FlightFinder(URL wsdlLocation) {
        super(wsdlLocation, SERVICE);
    }

    public FlightFinder(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public FlightFinder() {
        super(WSDL_LOCATION, SERVICE);
    }
    

    /**
     * 
     * @return
     *     returns FlightFinderPortType
     */
    @WebEndpoint(name = "FlightFinderPort")
    public FlightFinderPortType getFlightFinderPort() {
        return super.getPort(FlightFinderPort, FlightFinderPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns FlightFinderPortType
     */
    @WebEndpoint(name = "FlightFinderPort")
    public FlightFinderPortType getFlightFinderPort(WebServiceFeature... features) {
        return super.getPort(FlightFinderPort, FlightFinderPortType.class, features);
    }

}
