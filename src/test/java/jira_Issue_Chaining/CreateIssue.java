package jira_Issue_Chaining;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateIssue extends BaseClass {
	
	@Test
	public void createIss()
	{
		//RestAssured.baseURI = baseUri;
		
		Response resp = RestAssured.given()
		.contentType("application/json")
		.when()
		.body(file)
		.log()
		.all()
		.post("/issue");
		int statuscode = resp.getStatusCode();
		System.out.println(statuscode);
		resp.then().assertThat().statusCode(201);
		resp.prettyPrint();
		id = resp.jsonPath().get("id");
		key = resp.jsonPath().get("key");
		System.out.println(id);
		System.out.println(key);
		//System.out.println(resp.jsonPath().prettyPrint());
	}

}
