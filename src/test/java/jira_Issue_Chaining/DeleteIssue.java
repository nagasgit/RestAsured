package jira_Issue_Chaining;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeleteIssue extends BaseClass {
	@Test (dependsOnMethods="jira_Issue_Chaining.UpdateIssue.updateIssue")
	public void delIss()
	{
		Response resp = RestAssured.given()
		.contentType("application/json")
		.when()
		.log()
		.all()
		.delete("/issue/"+key);
		resp.prettyPrint();
		resp.then().assertThat().statusCode(204);
		
	}

}
