package com.dao;

import java.util.List;

import com.beans.Course;
import com.beans.Paper;
import com.beans.Student;

public interface IStudentDao {
	/* 
	  * 添加学生
	 * Student 学生信息
	 * paper 论文信息
	  *  选课信息(选的课程的id)
	 */
	void addStudent(Student stu, Paper paper, String [] courseIdList);
	
	List<Student> getStudentList(String studentNo,String stuName,int scoreLower ,int scoreHeight,String beginTime,String endTime);
	
	void delStudent(String  stuNo);
	
	List<Course> getCourselist();

}
