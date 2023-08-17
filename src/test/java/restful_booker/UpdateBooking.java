package restful_booker;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UpdateBooking extends BaseC{
	
	@Test (dependsOnMethods = {"restful_booker.CreateToken.createtoken","restful_booker.CreateBooking.createBooking"})
	//"restful_booker.CreateToken.createToken"
	public void updateBooking()
	{
		
		Response resp = RestAssured.given()
		.accept("application/json")
		.contentType("application/json")
		.headers("Cookie","token="+tokenVal)
		.body("{\r\n"
				+ "    \"firstname\" : \"James\",\r\n"
				+ "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}")
		.log()
		.all()
		.put("booking/"+bookingIdVal);
		System.out.println(resp.getStatusCode());
		resp.then().assertThat().statusCode(200);
		
	}

}
