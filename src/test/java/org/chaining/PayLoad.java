package org.chaining;

public class PayLoad {
	public  static String createUser() {
		return "{\r\n" + 
				"    \"name\": \"Priyaa\",\r\n" + 
				"    \"job\": \"leader\"\r\n" + 
				"}";		
	}
	public static String updateUser(String name) {
		return "{\r\n" + 
				"    \"name\": \""+name+"\",\r\n" + 
				"    \"job\": \"zion resident\"\r\n" + 
				"}";
	}
	public static String createIssue() {
		return "{\r\n" + 
				"    \"fields\": {\r\n" + 
				"       \"project\":\r\n" + 
				"       {\r\n" + 
				"          \"key\": \"CRAZ\"\r\n" + 
				"       },\r\n" + 
				"       \"summary\": \"Create Issue for APIChanining.\",\r\n" + 
				"       \"description\": \"Creating of an issue using project keys and issue type names using the REST API\",\r\n" + 
				"       \"issuetype\": {\r\n" + 
				"          \"name\": \"Bug\"\r\n" + 
				"       }\r\n" + 
				"   }\r\n" + 
				"}";	
	}

	public static String updateIssue(){
		return "{\r\n" + 
				"    \"fields\" : {\r\n" + 
				"        \"summary\": \"This is updated Summary\",\r\n" + 
				"        \"description\": \"Description\"        \r\n" + 
				"    }\r\n" + 
				"}";

	}
}
