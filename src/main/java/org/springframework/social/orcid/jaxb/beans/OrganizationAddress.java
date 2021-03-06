//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.07.06 at 01:57:48 PM BST 
//


package org.springframework.social.orcid.jaxb.beans;



/**
 * Container for organization location information
 * 			
 * 
 * <p>Java class for organization-address complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="organization-address">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="city" type="{http://www.orcid.org/ns/orcid}non-empty-string"/>
 *         &lt;element name="region" type="{http://www.orcid.org/ns/orcid}non-empty-string" minOccurs="0"/>
 *         &lt;element name="country" type="{http://www.orcid.org/ns/orcid}iso-3166-country"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public interface OrganizationAddress {


    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getCity();

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setCity(String value);

    /**
     * Gets the value of the region property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getRegion();

    /**
     * Sets the value of the region property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setRegion(String value);

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link Iso3166Country }
     *     
     */
    Iso3166Country getCountry();

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link Iso3166Country }
     *     
     */
    void setCountry(Iso3166Country value);

}
