package org.chaining;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//LibGlobal
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import io.restassured.response.Response;

public class BaseClassForAPI {
	public static int getResponseCode(Response re) {
		return re.getStatusCode();
	}
	public static String getResponseBody(Response re) {
		return re.getBody().asString();
	}
	public static String getValue(String body,String key) throws ParseException {
		JSONParser p=new JSONParser();
		Object obj = p.parse(body);
		JSONObject j=(JSONObject)obj;
		//key or id or anything so it changes
		return j.get(key).toString();
	}
	public static String getPropertyData(String value){
		Properties p=new Properties();
		FileInputStream it=null;
		try {
			p.load(new FileInputStream(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Property\\config.properties")));
		}
		catch (IOException e) {
			e.printStackTrace();
		} 
		String st = p.get(value).toString();
		return st;
	}
}

