//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.07.06 at 01:57:48 PM BST 
//


package org.springframework.social.orcid.jaxb.beans;

import java.math.BigInteger;


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
 *         &lt;element name="type" type="{http://www.orcid.org/ns/orcid}affiliation-type"/>
 *         &lt;element name="department-name" type="{http://www.orcid.org/ns/orcid}non-empty-string" minOccurs="0"/>
 *         &lt;element name="role-title" type="{http://www.orcid.org/ns/orcid}non-empty-string" minOccurs="0"/>
 *         &lt;element name="start-date" type="{http://www.orcid.org/ns/orcid}fuzzy-date" minOccurs="0"/>
 *         &lt;element name="end-date" type="{http://www.orcid.org/ns/orcid}fuzzy-date" minOccurs="0"/>
 *         &lt;element ref="{http://www.orcid.org/ns/orcid}organization"/>
 *         &lt;element ref="{http://www.orcid.org/ns/orcid}source" minOccurs="0"/>
 *         &lt;element ref="{http://www.orcid.org/ns/orcid}created-date" minOccurs="0"/>
 *         &lt;element ref="{http://www.orcid.org/ns/orcid}last-modified-date" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attGroup ref="{http://www.orcid.org/ns/orcid}visibility"/>
 *       &lt;attGroup ref="{http://www.orcid.org/ns/orcid}put-code"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public interface Affiliation {


    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link AffiliationType }
     *     
     */
    AffiliationType getType();

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link AffiliationType }
     *     
     */
    void setType(AffiliationType value);

    /**
     * Gets the value of the departmentName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getDepartmentName();

    /**
     * Sets the value of the departmentName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setDepartmentName(String value);

    /**
     * Gets the value of the roleTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getRoleTitle();

    /**
     * Sets the value of the roleTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setRoleTitle(String value);

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link FuzzyDate }
     *     
     */
    FuzzyDate getStartDate();

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link FuzzyDate }
     *     
     */
    void setStartDate(FuzzyDate value);

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link FuzzyDate }
     *     
     */
    FuzzyDate getEndDate();

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link FuzzyDate }
     *     
     */
    void setEndDate(FuzzyDate value);

    /**
     * Gets the value of the organization property.
     * 
     * @return
     *     possible object is
     *     {@link Organization }
     *     
     */
    Organization getOrganization();

    /**
     * Sets the value of the organization property.
     * 
     * @param value
     *     allowed object is
     *     {@link Organization }
     *     
     */
    void setOrganization(Organization value);

    /**
     * Gets the value of the source property.
     * 
     * @return
     *     possible object is
     *     {@link Source }
     *     
     */
    Source getSource();

    /**
     * Sets the value of the source property.
     * 
     * @param value
     *     allowed object is
     *     {@link Source }
     *     
     */
    void setSource(Source value);

    /**
     * Gets the value of the createdDate property.
     * 
     * @return
     *     possible object is
     *     {@link CreatedDate }
     *     
     */
    CreatedDate getCreatedDate();

    /**
     * Sets the value of the createdDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreatedDate }
     *     
     */
    void setCreatedDate(CreatedDate value);

    /**
     * Gets the value of the lastModifiedDate property.
     * 
     * @return
     *     possible object is
     *     {@link LastModifiedDate }
     *     
     */
    LastModifiedDate getLastModifiedDate();

    /**
     * Sets the value of the lastModifiedDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link LastModifiedDate }
     *     
     */
    void setLastModifiedDate(LastModifiedDate value);

    /**
     * Gets the value of the visibility property.
     * 
     * @return
     *     possible object is
     *     {@link Visibility }
     *     
     */
    Visibility getVisibility();

    /**
     * Sets the value of the visibility property.
     * 
     * @param value
     *     allowed object is
     *     {@link Visibility }
     *     
     */
    void setVisibility(Visibility value);

    /**
     * Gets the value of the putCode property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    BigInteger getPutCode();

    /**
     * Sets the value of the putCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    void setPutCode(BigInteger value);

}