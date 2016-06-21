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

import org.springframework.social.orcid.jaxb.beans.Applications;
import org.springframework.social.orcid.jaxb.beans.Biography;
import org.springframework.social.orcid.jaxb.beans.ContactDetails;
import org.springframework.social.orcid.jaxb.beans.Delegation;
import org.springframework.social.orcid.jaxb.beans.ExternalIdentifiers;
import org.springframework.social.orcid.jaxb.beans.Keywords;
import org.springframework.social.orcid.jaxb.beans.OrcidBio;
import org.springframework.social.orcid.jaxb.beans.PersonalDetails;
import org.springframework.social.orcid.jaxb.beans.ResearcherUrls;
import org.springframework.social.orcid.jaxb.beans.Scope;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "personalDetails",
    "biography",
    "researcherUrls",
    "contactDetails",
    "keywords",
    "externalIdentifiers",
    "delegation",
    "applications"
})
@XmlRootElement(name = "orcid-bio")
public class OrcidBioImpl
    implements OrcidBio
{

    @XmlElement(name = "personal-details", type = PersonalDetailsImpl.class)
    protected PersonalDetailsImpl personalDetails;
    @XmlElement(type = BiographyImpl.class)
    protected BiographyImpl biography;
    @XmlElement(name = "researcher-urls", type = ResearcherUrlsImpl.class)
    protected ResearcherUrlsImpl researcherUrls;
    @XmlElement(name = "contact-details", type = ContactDetailsImpl.class)
    protected ContactDetailsImpl contactDetails;
    @XmlElement(type = KeywordsImpl.class)
    protected KeywordsImpl keywords;
    @XmlElement(name = "external-identifiers", type = ExternalIdentifiersImpl.class)
    protected ExternalIdentifiersImpl externalIdentifiers;
    @XmlElement(type = DelegationImpl.class)
    protected DelegationImpl delegation;
    @XmlElement(type = ApplicationsImpl.class)
    protected ApplicationsImpl applications;
    @XmlAttribute(name = "scope")
    protected Scope scope;

    public PersonalDetails getPersonalDetails() {
        return personalDetails;
    }

    public void setPersonalDetails(PersonalDetails value) {
        this.personalDetails = ((PersonalDetailsImpl) value);
    }

    public Biography getBiography() {
        return biography;
    }

    public void setBiography(Biography value) {
        this.biography = ((BiographyImpl) value);
    }

    public ResearcherUrls getResearcherUrls() {
        return researcherUrls;
    }

    public void setResearcherUrls(ResearcherUrls value) {
        this.researcherUrls = ((ResearcherUrlsImpl) value);
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactDetails value) {
        this.contactDetails = ((ContactDetailsImpl) value);
    }

    public Keywords getKeywords() {
        return keywords;
    }

    public void setKeywords(Keywords value) {
        this.keywords = ((KeywordsImpl) value);
    }

    public ExternalIdentifiers getExternalIdentifiers() {
        return externalIdentifiers;
    }

    public void setExternalIdentifiers(ExternalIdentifiers value) {
        this.externalIdentifiers = ((ExternalIdentifiersImpl) value);
    }

    public Delegation getDelegation() {
        return delegation;
    }

    public void setDelegation(Delegation value) {
        this.delegation = ((DelegationImpl) value);
    }

    public Applications getApplications() {
        return applications;
    }

    public void setApplications(Applications value) {
        this.applications = ((ApplicationsImpl) value);
    }

    public Scope getScope() {
        return scope;
    }

    public void setScope(Scope value) {
        this.scope = value;
    }

}