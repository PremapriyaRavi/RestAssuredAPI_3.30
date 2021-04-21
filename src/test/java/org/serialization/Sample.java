package org.serialization;
import org.junit.Assert;
import org.junit.Test;
//JSONObject into responsebody(input body)
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
public class Sample {
	//	public static void main(String[] args) {
	//		// http://localhost:8080/rest/api/2/issue/
	//		System.out.println("-------POST--------");
	//		RestAssured.baseURI="https://mynthraa.atlassian.net";
	//		Response respost = RestAssured.given().header("Content-Type","application/json")
	//		.auth().preemptive().basic("riyaaravi97@gmail.com","nMwdg0trFffLvYH9NswjD619")
	//		.body(PayLoad.createUser())
	//		.when().post("/rest/api/2/issue/")
	//		.then().statusCode(201).extract().response();
	//		//if the validate get fails it through java.lang.AssertionError
	//		System.out.println("resCode....."+respost.getStatusCode());
	//		ResponseBody body = respost.getBody();
	//		System.out.println("resBody...");
	//		System.out.println(body.asString());	 
	//		//deserialization
	//		Output ot = respost.as(Output.class);
	//		System.out.println("id.."+ot.getId());
	//		System.out.println("key.."+ot.getKey());
	//		System.out.println("self.."+ot.getSelf());		
	//	}` 
	@Test
	public void test() {
		System.out.println("-------POST--------");
		RestAssured.baseURI="https://mynthraa.atlassian.net";
		Response respost = RestAssured.given().header("Content-Type","application/json")
				.auth().preemptive().basic("riyaaravi97@gmail.com","nMwdg0trFffLvYH9NswjD619")
				.body(PayLoad.createIssue())
				.when().post("/rest/api/2/issue/");
		//if the validate get fails it through java.lang.AssertionError
		System.out.println("resCode....."+respost.getStatusCode());
		ResponseBody body = respost.getBody();
		System.out.println("resBody...");
		System.out.println(body.asString());	 
		//deserialization
		Output ot = respost.as(Output.class);
		System.out.println("id.."+ot.getId());
		System.out.println("key.."+ot.getKey());
		System.out.println("self.."+ot.getSelf());		
		Assert.assertEquals("status code should be in 201..",201,respost.getStatusCode());
		Assert.assertTrue(ot.getKey().contains("CRAZ"));
		Assert.assertTrue(ot.getSelf().contains("mynthraa"));	
	}	
}
