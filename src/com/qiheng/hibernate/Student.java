package com.qiheng.hibernate;

import java.sql.Timestamp;

public class Student {
	
	private StudentPrimaryKey primaryKey;
	
	private int age;

	private Timestamp timestamp;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public StudentPrimaryKey getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(StudentPrimaryKey primaryKey) {
		this.primaryKey = primaryKey;
	}

}
