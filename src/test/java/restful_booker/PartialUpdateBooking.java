package restful_booker;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PartialUpdateBooking extends BaseC {
	
	@Test (dependsOnMethods = "restful_booker.UpdateBooking.updateBooking")
	public void partialUpdate()
	{
		Response resp = RestAssured.given()
		.accept("application/json")
		.contentType("application/json")
		.cookie("token="+tokenVal)
		.body("{\r\n"
				+ "    \"firstname\" : \"Naga\",\r\n"
				+ "    \"lastname\" : \"M\"\r\n"
				+ "}")
		.log()
		.all()
		.patch("/booking/"+bookingIdVal);
		
		System.out.println(resp.getStatusCode());
		resp.then().assertThat().statusCode(200);
		resp.jsonPath().prettyPrint();
		
		
	}

}
