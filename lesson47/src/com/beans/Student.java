package com.beans;

public class Student {
	
	private String stuNo;    //ѧ��(����)
	private String name;
	private int age;
	private String idCard;
	private int score ;   //�ɼ�
	private String addTime ;  //ע������
	
	//�������ֶ�������������ѯ��,�����ݿ���û��,�����ı����
	private String title ;   //���ı���
	private String teacher;  //����ָ����ʦ
	
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
