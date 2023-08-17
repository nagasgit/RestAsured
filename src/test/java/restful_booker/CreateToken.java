package restful_booker;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.deser.Deserializers.Base;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateToken extends BaseC {
	
	@Test
	public void createtoken()
	{
		Response resp = RestAssured.given()
		.headers("Content-Type","application/json")
		.body("{\r\n"
				+ "    \"username\" : \"admin\",\r\n"
				+ "    \"password\" : \"password123\"\r\n"
				+ "}")
		.log()
		.all()
		.post("/auth");
		resp.then().assertThat().statusCode(200);
		resp.jsonPath().prettyPrint();
		tokenVal = resp.jsonPath().get("token");
		System.out.println(tokenVal);
		
	}
}
