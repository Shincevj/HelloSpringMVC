package org.cims.hellospringmvc.model;

public class Student {
	private int id;
	private String name;
	private String branch;
	private int percentage;
	private int phone;
	private String email;
	
	public Student(String name, String branch, int percentage, int phone, String email){
		super();
		this.name = name;
		this.branch = branch;
		this.percentage = percentage;
		this.phone = phone;
		this.email = email;
	}
	
	public void insert(String name, String branch, int percentage, int phone, String email){
		this.name = name;
		this.branch = branch;
		this.percentage = percentage;
		this.phone = phone;
		this.email = email;
	}
}