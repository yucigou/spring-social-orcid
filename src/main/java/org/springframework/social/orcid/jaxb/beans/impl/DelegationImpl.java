//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.07.06 at 01:57:48 PM BST 
//


package org.springframework.social.orcid.jaxb.beans.impl;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.social.orcid.jaxb.beans.Delegation;
import org.springframework.social.orcid.jaxb.beans.GivenPermissionBy;
import org.springframework.social.orcid.jaxb.beans.GivenPermissionTo;
import org.springframework.social.orcid.jaxb.beans.Visibility;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "givenPermissionTo",
    "givenPermissionBy"
})
@XmlRootElement(name = "delegation")
public class DelegationImpl
    implements Delegation
{

    @XmlElement(name = "given-permission-to", type = GivenPermissionToImpl.class)
    protected GivenPermissionToImpl givenPermissionTo;
    @XmlElement(name = "given-permission-by", type = GivenPermissionByImpl.class)
    protected GivenPermissionByImpl givenPermissionBy;
    @XmlAttribute(name = "visibility")
    protected Visibility visibility;

    public GivenPermissionTo getGivenPermissionTo() {
        return givenPermissionTo;
    }

    public void setGivenPermissionTo(GivenPermissionTo value) {
        this.givenPermissionTo = ((GivenPermissionToImpl) value);
    }

    public GivenPermissionBy getGivenPermissionBy() {
        return givenPermissionBy;
    }

    public void setGivenPermissionBy(GivenPermissionBy value) {
        this.givenPermissionBy = ((GivenPermissionByImpl) value);
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility value) {
        this.visibility = value;
    }

}
