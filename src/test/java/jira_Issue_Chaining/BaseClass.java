package jira_Issue_Chaining;

import java.io.File;

import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;

public class BaseClass {

	public static String baseUri = "https://testjirafeb2023.atlassian.net/rest/api/2";
	public File file = new File("./src/test/resources/createissue_payload.json");
	public File file1 = new File("./src/test/resources/update_payload.json");
	public static String id;
	public static String key;
	// public stat

	@BeforeMethod
	public void setUp() {
		RestAssured.baseURI = baseUri;
		RestAssured.authentication= RestAssured.preemptive().basic
				("Feb2023restAPI@gmail.com", "ATATT3xFfGF0d39TsozfFQWR0Hvr0UfPqKKtyFJxQvnaGGtSvez8FvOvhfzSTapOBEUGx0ZAd"
						+ "IbWfM5tjeU8rFw7Rh72pbanmBdYhtysnC3yH89HMn-lXz9PTGKVKtWFV2vp6GyZ_"
						+ "75P27LqLCAbHxqOjYds1SNn5oFZQFDi3ufeUI3cJwdCy20=5543D93F");
	}

}
