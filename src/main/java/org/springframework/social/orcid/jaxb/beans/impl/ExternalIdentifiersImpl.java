//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2015.07.06 at 01:57:48 PM BST 
//


package org.springframework.social.orcid.jaxb.beans.impl;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.social.orcid.jaxb.beans.ExternalIdentifier;
import org.springframework.social.orcid.jaxb.beans.ExternalIdentifiers;
import org.springframework.social.orcid.jaxb.beans.Visibility;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "externalIdentifiers"
})
@XmlRootElement(name = "external-identifiers")
public class ExternalIdentifiersImpl
    implements ExternalIdentifiers
{

    @XmlElement(name = "external-identifier", type = ExternalIdentifierImpl.class)
    protected List<ExternalIdentifier> externalIdentifiers;
    @XmlAttribute(name = "visibility")
    protected Visibility visibility;

    public List<ExternalIdentifier> getExternalIdentifiers() {
        if (externalIdentifiers == null) {
            externalIdentifiers = new ArrayList<ExternalIdentifier>();
        }
        return this.externalIdentifiers;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility value) {
        this.visibility = value;
    }

}
