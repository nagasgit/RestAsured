package restful_booker;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetBookingIds extends BaseC{
	@Test
	public void getBookids()
	{
		Response resp = RestAssured.given()
		.headers("Content-Type","application/json")
		.headers("accept","application/json")
		.log()
		.all()
		.get("/booking");
		int statusCode = resp.getStatusCode();
		resp.then().assertThat().statusCode(200);
		resp.jsonPath().prettyPrint();
	}

}
