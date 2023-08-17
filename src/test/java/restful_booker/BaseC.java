package restful_booker;

import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.authentication.AuthenticationScheme;

public class BaseC {
	
	public static String baseUri = "https://restful-booker.herokuapp.com";
	public static String tokenVal;
	public static int bookingIdVal;
	
	@BeforeMethod
	public void setUp()
	{
		RestAssured.baseURI=baseUri;
		RestAssured.authentication = RestAssured.preemptive().basic("admin", "password123");
		
	}

}
