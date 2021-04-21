package org.chaining;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APIChaining {
	public static void main(String[] args) throws ParseException {
		//https://reqres.in/api/users
		//POST
		System.out.println("------------Post-createUser-----------");
		RestAssured.baseURI="https://reqres.in/";
		Response postCreate = RestAssured.given().header("Content-Type","application/json")
				.body(PayLoad.createUser())
				.when().post("api/users");
		System.out.println("resCode...." +postCreate.getStatusCode());
		String createBody = postCreate.getBody().asString();
		System.out.println(createBody);
		//JSONParser
		JSONParser p=new JSONParser();
		Object obj = p.parse(createBody);
		JSONObject j=(JSONObject)obj;
		String name = j.get("name").toString();
		String job = j.get("job").toString();
		String id = j.get("id").toString();
		System.out.println(name);
		System.out.println(job);
		System.out.println(id);
		//PUT
		//https://reqres.in/api/users/2
		System.out.println("------Put-updateUser-usingAPIChaining---");
		Response putCreate = RestAssured.given().header("Content-Type","application/json")
		.body(PayLoad.updateUser(name))
		.when().put("api/users/2");
		System.out.println("resCode....."+putCreate.getStatusCode());
		String updateBody = putCreate.getBody().asString();
		System.out.println(updateBody);
		
	}

}
