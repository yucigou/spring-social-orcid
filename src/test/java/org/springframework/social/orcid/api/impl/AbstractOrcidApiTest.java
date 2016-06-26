package org.springframework.social.orcid.api.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.junit.After;
import org.junit.Before;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.social.orcid.api.impl.OrcidApiImpl;
import org.springframework.test.web.client.MockRestServiceServer;

/**
 * @author Yuci Gou
 *
 */
public class AbstractOrcidApiTest {
	protected static final String ACCESS_TOKEN = "546db05c-0990-41eb-accc-9c8047b68051";

	private GenericApplicationContext context;
	protected OrcidApiImpl orcid;
	protected OrcidApiImpl unauthorizedOrcid;
	protected MockRestServiceServer mockServer;
	protected MockRestServiceServer unauthorizedMockServer;

	@Before
	public void setup() {
	    context = new GenericXmlApplicationContext(new FileSystemResource("src/test/resources/spring-social-context.xml"));
	    /*
	     * Create an instance of MockRestServiceServer against the RestTemplate instance used by the API implementation
	     */
		orcid = createOrcidTemplate();
		mockServer = MockRestServiceServer.createServer(orcid.getRestTemplate());
		
		unauthorizedOrcid = new OrcidApiImpl();
		unauthorizedMockServer = MockRestServiceServer.createServer(unauthorizedOrcid.getRestTemplate());
		System.out.println("@Before - setup");
	}
	
	@After
    public void tearDown() {
        context.close();
        System.out.println("@After - tearDown");
    }

	protected OrcidApiImpl createOrcidTemplate() {
		return new OrcidApiImpl(ACCESS_TOKEN);
	}

	protected Resource jsonResource(String filename) {
		return new ClassPathResource(filename + ".json", getClass());
	}

	protected Resource xmlResource(String filename) {
	    return new ClassPathResource(filename + ".xml", getClass());
	}

	protected Date toDate(String dateString) {
		try {
			return FB_DATE_FORMAT.parse(dateString);
		} catch (ParseException e) {
			return null;
		}
	}

	private static final DateFormat FB_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.ENGLISH);

}
