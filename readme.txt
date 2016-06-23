Spring Social ORCID Reference

The Spring Social ORCID project is an extension to Spring Social that enables integration with ORCID.

Introduction

ORCID provides a persistent digital identifier that distinguishes one researcher from another and, 
through integration in key research workflows such as manuscript and grant submission, 
supports automated linkages between a researcher and his/her professional activities ensuring that 
his/her work is recognized.

ORCID has been globally adopted, and at the time of writing (10 May 2016), there are over two 
millions of ORCID iDs registered.

Spring Social ORCID enables integration with ORCID with OrcidConnectionFactory, a connection 
factory that can be plugged into Spring Social¡¯s service provider connection framework, and with an
API binding to ORCID¡¯s REST API.

How to get

The following Maven dependency will add Spring Social ORCID to your project:

<dependency>
  <groupId>org.springframework.social</groupId>
  <artifactId>spring-social-orcid</artifactId>
  <version>1.0.0</version>
</dependency>

As an extension to Spring Social, Spring Social ORCID depends on Spring Social.
Spring Social¡¯s core module will be transitively resolved from the Spring Social ORCID dependency. 
If you¡¯ll be using Spring Social¡¯s web module, you¡¯ll need to add that dependency yourself.

In Maven:

pom.xml
<dependency>
  <groupId>org.springframework.social</groupId>
  <artifactId>spring-social-web</artifactId>
  <version>1.1.3.RELEASE</version>
</dependency>

Note that Spring Social ORCID releases on a different schedule than Spring Social. Consequently, 
Spring Social¡¯s version differs from that of Spring Social ORCID.

Configuring ORCID Connectivity



References:

1. Spring Social
http://docs.spring.io/spring-social/docs/1.1.0.RELEASE/reference/htmlsingle/#section_implementing

2. ORCID
http://members.orcid.org/api/tokens-through-3-legged-oauth-authorization
https://members.orcid.org/api/tutorial-retrieve-data-orcid-record-curl-12-and-earlier