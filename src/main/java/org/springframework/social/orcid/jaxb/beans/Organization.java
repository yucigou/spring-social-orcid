//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.07.06 at 01:57:48 PM BST 
//


package org.springframework.social.orcid.jaxb.beans;



/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.orcid.org/ns/orcid}non-empty-string"/>
 *         &lt;element name="address" type="{http://www.orcid.org/ns/orcid}organization-address"/>
 *         &lt;element name="disambiguated-organization" type="{http://www.orcid.org/ns/orcid}disambiguated-organization" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public interface Organization {


    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getName();

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setName(String value);

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link OrganizationAddress }
     *     
     */
    OrganizationAddress getAddress();

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link OrganizationAddress }
     *     
     */
    void setAddress(OrganizationAddress value);

    /**
     * Gets the value of the disambiguatedOrganization property.
     * 
     * @return
     *     possible object is
     *     {@link DisambiguatedOrganization }
     *     
     */
    DisambiguatedOrganization getDisambiguatedOrganization();

    /**
     * Sets the value of the disambiguatedOrganization property.
     * 
     * @param value
     *     allowed object is
     *     {@link DisambiguatedOrganization }
     *     
     */
    void setDisambiguatedOrganization(DisambiguatedOrganization value);

}
