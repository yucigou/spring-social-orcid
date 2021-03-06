//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.07.06 at 01:57:48 PM BST 
//


package org.springframework.social.orcid.jaxb.beans.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import org.springframework.social.orcid.jaxb.beans.Iso3166Country;
import org.springframework.social.orcid.jaxb.beans.OrganizationAddress;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "organization-address", propOrder = {
    "city",
    "region",
    "country"
})
public class OrganizationAddressImpl
    implements OrganizationAddress
{

    @XmlElement(required = true)
    protected String city;
    protected String region;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected Iso3166Country country;

    public String getCity() {
        return city;
    }

    public void setCity(String value) {
        this.city = value;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String value) {
        this.region = value;
    }

    public Iso3166Country getCountry() {
        return country;
    }

    public void setCountry(Iso3166Country value) {
        this.country = value;
    }

}
