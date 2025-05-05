
package org.donstu.async;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.donstu.async package. 
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

    private final static QName _GetAvailableEmployersResponse_QNAME = new QName("https://donstu.org/bank", "getAvailableEmployersResponse");
    private final static QName _GetAvailableEmployers_QNAME = new QName("https://donstu.org/bank", "getAvailableEmployers");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.donstu.async
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetAvailableEmployersResponse }
     * 
     */
    public GetAvailableEmployersResponse createGetAvailableEmployersResponse() {
        return new GetAvailableEmployersResponse();
    }

    /**
     * Create an instance of {@link GetAvailableEmployers }
     * 
     */
    public GetAvailableEmployers createGetAvailableEmployers() {
        return new GetAvailableEmployers();
    }

    /**
     * Create an instance of {@link ContactReason }
     * 
     */
    public ContactReason createContactReason() {
        return new ContactReason();
    }

    /**
     * Create an instance of {@link Place }
     * 
     */
    public Place createPlace() {
        return new Place();
    }

    /**
     * Create an instance of {@link Employee }
     * 
     */
    public Employee createEmployee() {
        return new Employee();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAvailableEmployersResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://donstu.org/bank", name = "getAvailableEmployersResponse")
    public JAXBElement<GetAvailableEmployersResponse> createGetAvailableEmployersResponse(GetAvailableEmployersResponse value) {
        return new JAXBElement<GetAvailableEmployersResponse>(_GetAvailableEmployersResponse_QNAME, GetAvailableEmployersResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetAvailableEmployers }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "https://donstu.org/bank", name = "getAvailableEmployers")
    public JAXBElement<GetAvailableEmployers> createGetAvailableEmployers(GetAvailableEmployers value) {
        return new JAXBElement<GetAvailableEmployers>(_GetAvailableEmployers_QNAME, GetAvailableEmployers.class, null, value);
    }

}
