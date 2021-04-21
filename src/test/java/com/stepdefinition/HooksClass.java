package com.stepdefinition;

import java.io.FileNotFoundException;

import org.junit.Before;

public class HooksClass {
	@Before("@updateIssue or @deleteIssue")
	//It runs before the update or delete
	public void beforeScenario() throws FileNotFoundException{
		JIRASteps j=new JIRASteps();
		j.to_add_the_create_issue_payload_and("select button not working","user cannot select the items");
		j.user_should_call_the_JIRA_API_with_http_request("createIssue","post");
	}

}
