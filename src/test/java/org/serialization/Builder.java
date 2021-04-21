package org.serialization;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.chaining.BaseClassForAPI;

import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Builder {
	//	public static void main(String args) {
	//		//Request
	//		RequestSpecBuilder reqspec =new RequestSpecBuilder();
	//		reqspec.setBaseUri("https://mynthraa.atlassian.net");
	//		reqspec.setContentType(ContentType.JSON);
	//		PreemptiveBasicAuthScheme auth=new PreemptiveBasicAuthScheme();
	//		auth.setUserName("riyaaravi97@gmail.com");
	//		auth.setPassword("nMwdg0trFffLvYH9NswjD619");
	//		reqspec.setAuth(auth);
	//		RequestSpecification req = reqspec.build();
	//		//Reponse
	//		ResponseSpecBuilder resspec=new ResponseSpecBuilder();
	//		ResponseSpecification res= resspec.expectStatusCode(201).expectContentType(ContentType.JSON).build();
	//		
	//		//spec-->accept requestspecification
	//		Response resPost = RestAssured.given().spec(req).body(PayLoad.createUser())
	//		.when().post("https://mynthraa.atlassian.net").then().spec(res).extract().response();
	//
	//	}
	static RequestSpecification req;
	public static RequestSpecification getReqBuilder() throws FileNotFoundException {
		//here ctype is enum
		//simplified form
		//it read the data from console and  inside target forget it shows into the single file here file name as log.txt
		PrintStream stream=new PrintStream("log.txt");
		if(req==null) {
			PreemptiveBasicAuthScheme auth=new PreemptiveBasicAuthScheme();
			auth.setUserName(BaseClassForAPI.getPropertyData("username"));
			auth.setPassword(BaseClassForAPI.getPropertyData("password")); 
			req=new RequestSpecBuilder()
					.setBaseUri(BaseClassForAPI.getPropertyData("baseUri"))
					//to read the data from log.txt
					//and gives request like put,get,post,delete
					//and its corresponding response
					.addFilter(RequestLoggingFilter.logRequestTo(stream))
					.addFilter(ResponseLoggingFilter.logResponseTo(stream))
					.setContentType(ContentType.JSON)
					.setAuth(auth).build();
		}
		return req;
	}
	public static ResponseSpecification getResPostSpec() {
		ResponseSpecBuilder req=new ResponseSpecBuilder();
		ResponseSpecification respost = req.expectContentType(ContentType.JSON)
				.expectStatusCode(201)
				.build();
		return respost;
	}
	public ResponseSpecification getResPutSpec() {
		ResponseSpecBuilder req=new ResponseSpecBuilder();
		ResponseSpecification respost = req.expectContentType(ContentType.JSON)
				.expectStatusCode(201)
				.build();
		return respost;

	}

}
