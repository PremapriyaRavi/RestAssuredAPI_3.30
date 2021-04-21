package org.chaining;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import io.restassured.RestAssured;
import io.restassured.response.Response;
public class APIChainingWithJira {
	public static void main(String[] args) throws ParseException {
		//https://mynthraa.atlassian.net/rest/api/2/issue/
		System.out.println("------------Post-createIssue-----------");
		RestAssured.baseURI="https://mynthraa.atlassian.net/";
		Response resPost = RestAssured.given().header("Content-Type","application/json")
				.auth().preemptive().basic("riyaaravi97@gmail.com","nMwdg0trFffLvYH9NswjD619")
				.body(PayLoad.createIssue())
				.when().post("rest/api/2/issue/");
		System.out.println("resCode...." +resPost.getStatusCode());
		String createBody = resPost.getBody().asString();
		System.out.println(createBody);
		//JSONParser
		JSONParser p=new JSONParser();
		Object obj = p.parse(createBody);
		JSONObject j=(JSONObject)obj;
		String KEY = j.get("key").toString();
		System.out.println("key........"+KEY);
		//PUT
		//https://mynthraa.atlassian.net/rest/api/2/issue/key
		System.out.println("------Put-updateIssue-usingAPIChainingWithJIRA---");
		Response resPut = RestAssured.given().header("Content-Type","application/json")
		.auth().preemptive().basic("riyaaravi97@gmail.com","nMwdg0trFffLvYH9NswjD619")
		.body(PayLoad.updateIssue())
		.when().put("rest/api/2/issue/"+KEY);
		System.out.println("resCode..."+resPut.getStatusCode());
		String updateBody = resPut.getBody().asString();
		System.out.println(updateBody);
		//DELETE
		System.out.println("--------Delete--------");
		Response resDel = RestAssured.given().header("Content-Type","application/json")
		.auth().preemptive().basic("riyaaravi97@gmail.com","nMwdg0trFffLvYH9NswjD619")
		.when().delete("rest/api/2/issue/"+KEY);
		System.out.println("resCode..."+resDel.getStatusCode());
		String delBody = resDel.getBody().asString();
		System.out.println(delBody);
	}
}
