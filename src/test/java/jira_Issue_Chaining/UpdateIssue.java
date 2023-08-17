package jira_Issue_Chaining;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class UpdateIssue extends BaseClass{
	
	@Test (dependsOnMethods ="jira_Issue_Chaining.CreateIssue.createIss")
	public void updateIssue()
	{
		Response resp = RestAssured.given()
		.contentType("application/json")
		//.queryParam(baseUri, null)
		.when()
		.body(file1)
		.log()
		.all()
		.put("/issue/"+id);
		resp.prettyPrint();
		int stsCode = resp.getStatusCode();
		System.out.println(stsCode);
		resp.then().assertThat().statusCode(204);	
		
	}
}
