package restful_chaining;

import java.io.File;

import org.hamcrest.Matcher;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateAuth extends BaseClass {
	
	@Test
	public void createAuth()
	{
		//RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		//RestAssured.authentication = RestAssured.basic("admin", "password123");
				Response resp =	RestAssured.given()
											.basePath("auth")
											.contentType("application/json")
											.when()
											.body("{\r\n"
													+ "    \"username\" : \"admin\",\r\n"
													+ "    \"password\" : \"password123\"\r\n"
													+ "}")
											.log()
											.all()
											.post();
				token = resp.jsonPath().get("token");
				System.out.println("Token is:"+token);
				resp.prettyPrint();
				resp.then().assertThat().statusCode(200);				
				   
	}
	
	@Test
	public void createBooking()
	{
		/*
		 * Response resp = RestAssured.given() .basePath("auth")
		 * .contentType("application/json") .when() .body("{\r\n" +
		 * "    \"firstname\" : \"Jim\",\r\n" + "    \"lastname\" : \"Brown\",\r\n" +
		 * "    \"totalprice\" : 111,\r\n" + "    \"depositpaid\" : true,\r\n" +
		 * "    \"bookingdates\" : {\r\n" + "        \"checkin\" : \"2018-01-01\",\r\n"
		 * + "        \"checkout\" : \"2019-01-01\"\r\n" + "    },\r\n" +
		 * "    \"additionalneeds\" : \"Breakfast\"\r\n" + "}") .post();
		 * resp.prettyPrint(); booking_id = resp.jsonPath().get("bookingid");
		 * System.out.println(resp.getStatusCode());
		 * resp.then().assertThat().statusCode(200);
		 */
		
		RestAssured.basePath ="booking";
		Response response = RestAssured.given().contentType("application/json")
				.when()
				.body(file)
				.post();
		
		booking_id =response.jsonPath().get("bookingid");
		System.out.println("Booking Id is "+ booking_id);
	}
	
	@Test
	public void getBooking()
	{
		Response resp = RestAssured.given()
				   .basePath("booking")
				   .contentType("application/json")
				   .queryParam("id", booking_id)
				   .accept("application/json")
				   .get();
		System.out.println(resp.getStatusCode());
		//resp.then().assertThat().statusCode(201);
				   
	}
	
	@Test
	public void deleteBooking()
	{
		Response resp = RestAssured.given()
						.basePath("booking"+"/booking_ID")
						.cookie(token)
						.delete();
		System.out.println(resp.getStatusCode());
	}
	

}
