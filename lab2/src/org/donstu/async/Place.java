
package org.donstu.async;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for place complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="place">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="contactReasons" type="{https://donstu.org/bank}contactReason" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="number" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "place", propOrder = {
    "contactReasons",
    "number"
})
public class Place {

    @XmlElement(nillable = true)
    protected List<ContactReason> contactReasons;
    protected Integer number;

    /**
     * Gets the value of the contactReasons property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contactReasons property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContactReasons().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContactReason }
     * 
     * 
     */
    public List<ContactReason> getContactReasons() {
        if (contactReasons == null) {
            contactReasons = new ArrayList<ContactReason>();
        }
        return this.contactReasons;
    }

    /**
     * Gets the value of the number property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getNumber() {
        return number;
    }

    /**
     * Sets the value of the number property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setNumber(Integer value) {
        this.number = value;
    }

}
