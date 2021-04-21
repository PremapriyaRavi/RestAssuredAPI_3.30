package com.stepdefinition;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;

import org.serialization.Builder;
import org.serialization.Output;
import org.serialization.PayLoad;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JIRASteps {
	RequestSpecification reqSpec;
	Response response;
	static String issueId;
	@Given("To add the create issue payload {string} and {string}")
	public void to_add_the_create_issue_payload_and(String summary, String description) throws FileNotFoundException {
	   reqSpec = RestAssured.given().log().all().spec(Builder.getReqBuilder())
	   .body(PayLoad.createIssue(summary, description));
	}
	@When("User should call the JIRA {string} API with {string} http request")
	public void user_should_call_the_JIRA_API_with_http_request(String resources, String reqType) {
	   APIResources api = APIResources.valueOf(resources);
	   String apiResources = api.getResources();
//req types
	   if(reqType.equals("post")) {
		   response=reqSpec.when().post(apiResources);
		   Output ot = response.as(Output.class);
		   issueId = ot.getKey();
	   }
	   if(reqType.equals("put")) {
		   response=reqSpec.when().put(apiResources+issueId);
	   }
	   if(reqType.equals("get")) {
		   response=reqSpec.when().get(apiResources);
	   }
	   if(reqType.equals("delete")) {
		   response=reqSpec.when().delete(apiResources+issueId);
	   }
	}
	@Then("To validate the response code it should be {int}")
	public void to_validate_the_response_code_it_should_be(int statusCode) {
	response.then().log().all();
	assertEquals("verify status code..",statusCode,response.getStatusCode());
	}
	@Then("To validate the self from resposebody that contains {string}")
	public void to_validate_the_self_from_resposebody_that_contains(String self) {
	  //response body contains id,key,self
		Output ot = response.then().log().all().extract()
		.as(Output.class);
		assertTrue("verify response body self contains mynthraa",ot.getSelf().contains(self));
//	    issueId = ot.getKey();
	    System.out.println("issueId..."+issueId);
	}
	@Given("To add the update issue payload {string} and {string}")
	public void to_add_the_update_issue_payload_and(String summary, String description) throws FileNotFoundException {
	 System.out.println("--------PUT-------------");
	 reqSpec = RestAssured.given().log().all().spec(Builder.getReqBuilder()).body(PayLoad.updateIssue(summary, description));
	}
	@Given("To add the base uri")
	public void to_add_the_base_uri() throws FileNotFoundException {
	    reqSpec = RestAssured.given().log().all().spec(Builder.getReqBuilder());
	}

}
