package restful_booker;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteBooking extends BaseC{
	
	@Test (dependsOnMethods = "restful_booker.PartialUpdateBooking.partialUpdate")
	public void deleteBooking()
	{
		Response resp = RestAssured.given()
		.accept("application/json")
		.contentType("application/json")
		.cookie("token="+tokenVal)
		.log()
		.all()
		.delete("/booking/"+bookingIdVal);
		System.out.println(resp.getStatusCode());
		resp.then().assertThat().statusCode(201);
		
		
	}

}
