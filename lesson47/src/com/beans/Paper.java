package com.beans;

public class Paper {
	private int id; //����
	private int letterCount; //����
	private String teacher;  //ָ����ʦ
	private String title;  //����
	private String introduce; //���
	
	private String stuNo;  //ѧ��ѧ�� ������ѧ������������,�����
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLetterCount() {
		return letterCount;
	}

	public void setLetterCount(int letterCount) {
		this.letterCount = letterCount;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getStuNo() {
		return stuNo;
	}

	public void setStuNo(String stuNo) {
		this.stuNo = stuNo;
	}
}
