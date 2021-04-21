package org.serialization;
//input-serialization
public class PayLoad {
public static Account createIssue() {
	Project project=new Project();
	project.setKey("CRAZ");
	Issuetype issuetype=new Issuetype();
	issuetype.setName("Bug");
	Fields fields =new Fields();
	fields.setSummary("serialization example..login not working");
	fields.setDescription("cannot able to login");
	fields.setProject(project);
	fields.setIssuetype(issuetype);
	Account account=new Account();
	account.setFields(fields);
	//bcoz account is a rootclass
	return account;
}
public static Account createIssue(String summary,String description) {
	Project project=new Project();
	project.setKey("CRAZ");
	Issuetype issuetype=new Issuetype();
	issuetype.setName("Bug");
	Fields fields =new Fields();
	fields.setSummary(summary);
	fields.setDescription(description);
	fields.setProject(project);
	fields.setIssuetype(issuetype);
	Account account=new Account();
	account.setFields(fields);
	//bcoz account is a rootclass
	return account;
}
public static RootUpdateIssue updateIssue(String summary,String description) {
	UpdateFields fields=new UpdateFields();
	fields.setSummary(summary);
	fields.setDescription(description);
	RootUpdateIssue issue=new RootUpdateIssue();
	issue.setFields(fields);
	return issue;
}
}
