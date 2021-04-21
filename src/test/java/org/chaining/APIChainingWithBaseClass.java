package org.chaining;

import org.json.simple.parser.ParseException;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APIChainingWithBaseClass extends BaseClassForAPI{
	public static void main(String[] args) throws ParseException {
		System.out.println("------------Post-createIssue-----------");
		RestAssured.baseURI="https://mynthraa.atlassian.net/";
		Response resPost = RestAssured.given().header("Content-Type","application/json")
				.auth().preemptive().basic("riyaaravi97@gmail.com","nMwdg0trFffLvYH9NswjD619")
				.body(PayLoad.createIssue())
				.when().post("rest/api/2/issue/");
		//System.out.println("resCode.."+ BaseClassForAPI.getResponseCode(resPost));
		//we can extends
		System.out.println("resCode.."+getResponseCode(resPost));
		String createBody = getResponseBody(resPost);
		System.out.println(createBody);
		String KEY = getValue(createBody,"key");
		System.out.println("key........"+KEY);
		//PUT
		System.out.println("------Put-updateIssue-usingAPIChainingWithJIRA---");
		Response resPut = RestAssured.given().header("Content-Type","application/json")
				.auth().preemptive().basic("riyaaravi97@gmail.com","nMwdg0trFffLvYH9NswjD619")
				.body(PayLoad.updateIssue())
				.when().put("rest/api/2/issue/"+KEY);
		System.out.println("resCode..."+getResponseCode(resPut));
		System.out.println(getResponseBody(resPut));
		//DELETE
		System.out.println("---------Delete--------");
		Response resDel = RestAssured.given().header("Content-Type","application/json")
				.auth().preemptive().basic("riyaaravi97@gmail.com","nMwdg0trFffLvYH9NswjD619")
				.when().delete("rest/api/2/issue/"+KEY);
		System.out.println("resCode..+"+getResponseCode(resDel));
		System.out.println(getResponseBody(resDel));
	}
}
