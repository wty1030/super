package com.beans;

//课程信息
public class Course {
	private int id;
	private String courseNo;  //课程编号  
	private String name;
	private String teacher;  //授课教师
	private int studyDays;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourseNo() {
		return courseNo;
	}
	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public int getStudyDays() {
		return studyDays;
	}
	public void setStudyDays(int studyDays) {
		this.studyDays = studyDays;
	} 
}
