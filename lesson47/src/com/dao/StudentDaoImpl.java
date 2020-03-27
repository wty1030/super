package com.dao;

import java.sql.*;
import java.util.*;
import java.util.List;

import com.beans.Course;
import com.beans.Paper;
import com.beans.Student;
import com.jdbc.DBUtil;
import com.utils.StrUtil;

public class StudentDaoImpl implements IStudentDao {

	public void addStudent(Student stu, Paper paper, String[] courseIdList) {
		Connection conn=null;
		PreparedStatement stm=null;
		try {
			conn=DBUtil.getConn();		
			conn.setAutoCommit(false);
			
			//添加学生
			String sql="insert into student (stuNo,name,age,idCard,score,addTime) values(?,?,?,?,?,?)  ";
			stm=conn.prepareStatement(sql);
			stm.setString(1, stu.getStuNo());
			stm.setString(2, stu.getName());
			stm.setInt(3,stu.getAge());
			stm.setString(4, stu.getIdCard());
			stm.setInt(5,stu.getScore());
			stm.setString(6, stu.getAddTime());
			stm.execute();
			stm.close();

			//添加论文
			String sql2="insert into paper (letterCount,teacher,title,introduce,stuNo) values (?,?,?,?,?) "; 
			stm=conn.prepareStatement(sql2);
			stm.setInt(1, paper.getLetterCount());
			stm.setString(2, paper.getTeacher());
			stm.setString(3, paper.getTitle());
			stm.setString(4, paper.getIntroduce());
			stm.setString(5, stu.getStuNo());  //这是学生的主键,建立起关联
			stm.execute();
			stm.close();
			
			
			//添加选课信息(选课信息是多条)
			for(String courseId:courseIdList){
				String sql3="insert into stu_course (stuNo,courseId) values (?,?) ";
				stm=conn.prepareStatement(sql3);
				stm.setString(1, stu.getStuNo());
				stm.setObject(2, courseId);
				stm.execute();
			}
			
			conn.commit();
			
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			DBUtil.close(null,stm,conn);
		}
		
	}

	public List<Student> getStudentList(String studentNo, String stuName,int scoreLower, int scoreHeight, String beginTime, String endTime) {
			
		List<Student> list=new ArrayList<Student>();
		
		String sql="select a.* ,b.title,b.teacher from student a  left join paper b on a.stuNo=b.stuNo  where 1=1" ;
		
		if(!StrUtil.isNullOrEmpty(studentNo)){
			sql+=" and a.stuNo like '%" +  studentNo+"%'"; 
		}
		
		if(!StrUtil.isNullOrEmpty(stuName)){
			sql+=" and stuName like '%" +  stuName+"%'"; 
		}
		
		if(scoreLower!=0){
			sql+=" and score >= "+scoreLower;
		}
		
		if(scoreHeight!=0){
			sql+=" and score<="+scoreHeight;
		}
		
		if(!StrUtil.isNullOrEmpty(beginTime)){
			sql+=" and addTime >='" +beginTime+"'"; 
		}
		
		if(!StrUtil.isNullOrEmpty(endTime)){
			sql+=" and addTime <='" +endTime+"'"; 
		}
		
		Connection conn=null;
		ResultSet rs=null;
		Statement stm=null;
		try {
			conn=DBUtil.getConn();
			stm=conn.createStatement();
			rs=stm.executeQuery(sql);
			
			while(rs.next()){
				Student stu=new Student();
				stu.setStuNo(rs.getString("stuNo"));
				stu.setName(rs.getString("name"));
				stu.setAddTime(rs.getString("addTime"));
				stu.setScore(rs.getInt("score"));
				stu.setTitle(rs.getString("title"));
				stu.setIdCard(rs.getString("idCard"));
				stu.setTeacher(rs.getString("teacher"));
				
				list.add(stu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			DBUtil.close(rs, stm, conn);
		}
		
		return list;	
	}

	public void delStudent(String stuNo) {
		Connection conn=null;
		PreparedStatement stm=null;
		try {
			conn=DBUtil.getConn();
			conn.setAutoCommit(false);
			
			//要先删除从表信息(论文)
			String sql="delete from paper where stuNo=?";
			stm=conn.prepareStatement(sql);
			stm.setString(1, stuNo);
			stm.execute();
			stm.close();
			
			//要先删除从表信息(选课)
			String sq2="delete from stu_course where stuNo=?"; 
			stm=conn.prepareStatement(sq2);
			stm.setString(1, stuNo);
			stm.execute();
			stm.close();
			
			//删除主表信息
			String sq3="delete from student where stuNo=?"; 
			stm=conn.prepareStatement(sq3);
			stm.setString(1, stuNo);
			stm.execute();
			stm.close();
			
			conn.commit();
			
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally{
			DBUtil.close(null, stm, conn);
		}
	}

	//查询所有的课程列表
	public List<Course> getCourselist() {
		List<Course>courseList=new ArrayList<Course>();
		Connection conn=null;
		Statement stm=null;
		ResultSet rs=null;
		
		try {
			conn=DBUtil.getConn();
			stm=conn.createStatement();
			String sql="select * from course" ; 
			rs=stm.executeQuery(sql);
			while(rs.next()) {
				Course c=new Course();
				c.setId(rs.getInt("id"));
				c.setCourseNo(rs.getString("courseNo"));
				c.setName(rs.getString("name"));
				c.setStudyDays(rs.getInt("studyDays"));
				c.setTeacher(rs.getString("teacher"));
				courseList.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.close(null, stm, conn);
		}
		
		return courseList;
	}

}
