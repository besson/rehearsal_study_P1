
package br.batcave;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.batcave package. 
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

    private final static QName _SayhowResponse_QNAME = new QName("http://batcave.br/", "sayhowResponse");
    private final static QName _Sayhow_QNAME = new QName("http://batcave.br/", "sayhow");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.batcave
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Sayhow }
     * 
     */
    public Sayhow createSayhow() {
        return new Sayhow();
    }

    /**
     * Create an instance of {@link SayhowResponse }
     * 
     */
    public SayhowResponse createSayhowResponse() {
        return new SayhowResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayhowResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://batcave.br/", name = "sayhowResponse")
    public JAXBElement<SayhowResponse> createSayhowResponse(SayhowResponse value) {
        return new JAXBElement<SayhowResponse>(_SayhowResponse_QNAME, SayhowResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Sayhow }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://batcave.br/", name = "sayhow")
    public JAXBElement<Sayhow> createSayhow(Sayhow value) {
        return new JAXBElement<Sayhow>(_Sayhow_QNAME, Sayhow.class, null, value);
    }

}
