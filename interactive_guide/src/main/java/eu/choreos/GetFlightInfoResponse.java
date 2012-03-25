
package eu.choreos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getFlightInfoResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getFlightInfoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="flightInformation" type="{http://choreos.eu/}flightInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getFlightInfoResponse", propOrder = {
    "flightInformation"
})
public class GetFlightInfoResponse {

    protected FlightInfo flightInformation;

    /**
     * Gets the value of the flightInformation property.
     * 
     * @return
     *     possible object is
     *     {@link FlightInfo }
     *     
     */
    public FlightInfo getFlightInformation() {
        return flightInformation;
    }

    /**
     * Sets the value of the flightInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link FlightInfo }
     *     
     */
    public void setFlightInformation(FlightInfo value) {
        this.flightInformation = value;
    }

}
