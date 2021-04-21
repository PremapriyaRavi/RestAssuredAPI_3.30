package org.serialization;
import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
public class SampleForReuse extends Builder{
	@Test
	public void test() throws FileNotFoundException {
		//https://mynthraa.atlassian.net/rest/api/2/issue/
		Response resPost = RestAssured.
				given().log().all()
				//given()
				.spec(Builder.getReqBuilder())
				.body(PayLoad.createIssue())
				.when().post("rest/api/2/issue/")
				//.then().spec(getResPostSpec())
				.then().log().all()
				.extract()
				.response();	
		System.out.println("resCode....."+resPost.getStatusCode());
		ResponseBody body = resPost.getBody();
		System.out.println("resBody...");
		System.out.println(body.asString());
		Output ot = resPost.as(Output.class);
		System.out.println("id.."+ot.getId());
		System.out.println("key.."+ot.getKey());
		System.out.println("self.."+ot.getSelf());		
		Assert.assertEquals("status code should be in 201..",201,resPost.getStatusCode());
		Assert.assertTrue(ot.getKey().contains("CRAZ"));
		Assert.assertTrue(ot.getSelf().contains("mynthraa"));	
	}	
}
