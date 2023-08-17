package restful_chaining;

import java.io.File;

import org.testng.annotations.BeforeTest;

import io.restassured.RestAssured;

public class BaseClass {
	
	public static String baseUri ="https://restful-booker.herokuapp.com/";
	public File file = new File("./src/test/resources/Payload.json");
	public static int booking_id;
	String token;
	
	@BeforeTest
	public void setup()
	{
		RestAssured.baseURI=baseUri;
	}
}
