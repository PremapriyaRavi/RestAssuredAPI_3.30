package com.stepdefinition;

public class A {
	public static void main(String[] args) {
		//APIResources api=APIResources.valueOf("createIssue");
		APIResources api=APIResources.createIssue;
		String re=api.getResources();
		System.out.println(api);
		System.out.println(re);
	}

}
