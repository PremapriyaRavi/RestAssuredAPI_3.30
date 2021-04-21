package org.deSerialization;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class ExampleForListOfUsers {
	public static void main(String[] args) {
		// https://reqres.in/api/users?page=2
		RestAssured.baseURI="https://reqres.in/";
		Response resGet = RestAssured.given().header("Content-Type","application/json")
				.queryParam("page",2)
				//optional
				.expect().defaultParser(Parser.JSON)
				.when().get("api/users");
		System.out.println("ResCode...."+resGet.getStatusCode());
		ResponseBody resBody = resGet.getBody();
		System.out.println(resBody.asString());
		//extract response body into Object
		UserDetails u = resGet.as(UserDetails.class);
		System.out.println("Page.."+u.getPage());
		System.out.println("Per_page.."+u.getPer_page());
		System.out.println("total.."+u.getTotal());
		System.out.println("total_pages.."+u.getTotal_pages());
		//Data	
		List<Data> d = u.getData();
		for (Data x : d) {
			System.out.println("id.."+x.getId());
			System.out.println("email.."+x.getEmail());
			System.out.println("first_name.."+x.getFirst_name());
			System.out.println("last_name.."+x.getLast_name());
			System.out.println("avatar.."+x.getAvatar());	
		}
		//support
		Support s = u.getSupport();
		System.out.println(s.getUrl());
		System.out.println(s.getText());
	}
}
