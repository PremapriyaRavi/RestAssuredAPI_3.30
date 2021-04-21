package org.deSerialization;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetExampleUsingJIRA {
	public static void main(String[] args) {
		//https://mynthraa.atlassian.net/
		RestAssured.baseURI="https://mynthraa.atlassian.net/";
		Response resGet = RestAssured.given().headers("Content-Type","application/json")
				.auth().preemptive().basic("riyaaravi97@gmail.com","nMwdg0trFffLvYH9NswjD619")
				.when().get("rest/api/2/search");
		System.out.println("resCode.."+resGet.getStatusCode());
		System.out.println("resBody....");
		String body = resGet.getBody().asString();
		System.out.println(body);

	}
}
