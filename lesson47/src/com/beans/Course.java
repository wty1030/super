package com.beans;

//�γ���Ϣ
public class Course {
	private int id;
	private String courseNo;  //�γ̱��  
	private String name;
	private String teacher;  //�ڿν�ʦ
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
