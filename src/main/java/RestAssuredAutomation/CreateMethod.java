package RestAssuredAutomation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateMethod {

	@Test
	public void createMethod() {
		Response response = RestAssured.given()
				.baseUri("https://restful-booker.herokuapp.com")
				.basePath("auth")
				.contentType("application/json")
				.body("{\"username\" : \"admin\",\r\n" + "    \"password\" : \"password123\"}")
				.log()
				.all()
				.post();
		System.out.println(response.getStatusCode());
	}
}
