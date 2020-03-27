package com.beans;

public class Student {
	
	private String stuNo;    //学号(主键)
	private String name;
	private int age;
	private String idCard;
	private int score ;   //成绩
	private String addTime ;  //注册日期
	
	//这两个字段是用来关联查询的,在数据库里没有,是论文表里的
	private String title ;   //论文标题
	private String teacher;  //论文指导教师
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String toString() {
		return "Student [stuNo=" + stuNo + ", name=" + name + ", age=" + age
				+ ", idCard=" + idCard + ", score=" + score + ", addTime="
				+ addTime + ", title=" + title + ", teacher=" + teacher + "]";
	}
	
	public String getStuNo() {
		return stuNo;
	}
	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getAddTime() {
		return addTime;
	}
	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}
	
}
