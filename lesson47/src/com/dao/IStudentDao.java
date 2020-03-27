package com.dao;

import java.util.List;

import com.beans.Course;
import com.beans.Paper;
import com.beans.Student;

public interface IStudentDao {
	/* 
	  * ���ѧ��
	 * Student ѧ����Ϣ
	 * paper ������Ϣ
	  *  ѡ����Ϣ(ѡ�Ŀγ̵�id)
	 */
	void addStudent(Student stu, Paper paper, String [] courseIdList);
	
	List<Student> getStudentList(String studentNo,String stuName,int scoreLower ,int scoreHeight,String beginTime,String endTime);
	
	void delStudent(String  stuNo);
	
	List<Course> getCourselist();

}
