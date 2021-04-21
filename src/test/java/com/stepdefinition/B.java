package com.stepdefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class B {
	public static void main(String[] args) throws IOException {
		Properties p=new Properties();
		File f=new File("C:\\Users\\PREMA\\eclipse-workspace\\RestAssuredAPI_3.30PM\\src\\test\\resources\\Property\\config.properties");
		FileInputStream it=new FileInputStream(f);
		p.load(it);
		//Object object = p.get("baseUri");
		String st = p.get("baseUri").toString();
		System.out.println(st);
		String user = p.get("username").toString();
		System.out.println(user);
		String pass = p.get("password").toString();
		System.out.println(pass);
		

	}

}
