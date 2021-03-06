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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import org.springframework.social.orcid.jaxb.beans.EncryptedPassword;
import org.springframework.social.orcid.jaxb.beans.EncryptedSecurityAnswer;
import org.springframework.social.orcid.jaxb.beans.EncryptedVerificationCode;
import org.springframework.social.orcid.jaxb.beans.SecurityDetails;
import org.springframework.social.orcid.jaxb.beans.SecurityQuestionId;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "encryptedPassword",
    "securityQuestionId",
    "encryptedSecurityAnswer",
    "encryptedVerificationCode"
})
@XmlRootElement(name = "security-details")
public class SecurityDetailsImpl
    implements SecurityDetails
{

    @XmlElement(name = "encrypted-password", required = true, type = EncryptedPasswordImpl.class)
    protected EncryptedPasswordImpl encryptedPassword;
    @XmlElement(name = "security-question-id", type = SecurityQuestionIdImpl.class)
    protected SecurityQuestionIdImpl securityQuestionId;
    @XmlElement(name = "encrypted-security-answer", type = EncryptedSecurityAnswerImpl.class)
    protected EncryptedSecurityAnswerImpl encryptedSecurityAnswer;
    @XmlElement(name = "encrypted-verification-code", required = true, type = EncryptedVerificationCodeImpl.class)
    protected EncryptedVerificationCodeImpl encryptedVerificationCode;

    public EncryptedPassword getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(EncryptedPassword value) {
        this.encryptedPassword = ((EncryptedPasswordImpl) value);
    }

    public SecurityQuestionId getSecurityQuestionId() {
        return securityQuestionId;
    }

    public void setSecurityQuestionId(SecurityQuestionId value) {
        this.securityQuestionId = ((SecurityQuestionIdImpl) value);
    }

    public EncryptedSecurityAnswer getEncryptedSecurityAnswer() {
        return encryptedSecurityAnswer;
    }

    public void setEncryptedSecurityAnswer(EncryptedSecurityAnswer value) {
        this.encryptedSecurityAnswer = ((EncryptedSecurityAnswerImpl) value);
    }

    public EncryptedVerificationCode getEncryptedVerificationCode() {
        return encryptedVerificationCode;
    }

    public void setEncryptedVerificationCode(EncryptedVerificationCode value) {
        this.encryptedVerificationCode = ((EncryptedVerificationCodeImpl) value);
    }

}
