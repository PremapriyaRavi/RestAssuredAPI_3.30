package com.stepdefinition;

public enum APIResources {
	createIssue("rest/api/2/issue/"),
	getAllIssue("rest/api/2/search"),
	updateIssue("rest/api/2/issue/"),
	deleteIssue("rest/api/3/issue/");
	String resources;
	APIResources(String resources) {
		this.resources=resources;
	}
	
	public String getResources() {
		return resources;
	}
}
