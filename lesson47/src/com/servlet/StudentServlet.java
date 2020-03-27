package com.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beans.Paper;
import com.beans.Student;
import com.dao.IStudentDao;
import com.dao.StudentDaoImpl;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private IStudentDao dao=new StudentDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String flag=request.getParameter("flag"); 
		
		if("add".equals(flag)) {
			this.add(request,response);
		}
		
		else if("manager".equals(flag)) {
			this.manager(request,response);
		}
		
		else if("del".equals(flag)) {
			this.del(request,response);
		}
	}


	//ɾ��
	private void del(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stuNo=request.getParameter("id");
		dao.delStudent(stuNo);
		
		List<Student> stuList=dao.getStudentList(null, null, 0, 0, null, null);
		request.setAttribute("stuList",stuList);
		request.getRequestDispatcher("/student-manager.jsp").forward(request, response);
	}


	//��ѯѧ��
	private void manager(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String stuNo= request.getParameter("stuNo");
		String  name= request.getParameter("name");
		int  scoreLower=Integer.parseInt(request.getParameter("scoreLower"));
		int scoreHeight = Integer.parseInt(request.getParameter("scoreHeight"));
		
		//����ʱ����˵,һ��Ҫע�����ĸ�ʽҪ�Ϸ�
		String beginTime = request.getParameter("beginTime");
		String endTime = request.getParameter("endTime");

		List<Student> stuList=dao.getStudentList(stuNo, name, scoreLower, scoreHeight, beginTime, endTime);
		request.setAttribute("stuList",stuList);
		request.getRequestDispatcher("/student-manager.jsp").forward(request, response);
	}


	//���ѧ��
	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�õ�ѧ����Ϣ
		String  stuNo = request.getParameter("stuNo"); 
		String  name = request.getParameter("name"); 
		int  age = Integer.parseInt(request.getParameter("age")); 
		String  idCard = request.getParameter("idCard"); 
		int  score =Integer.parseInt(request.getParameter("score")); 
		String addTime= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
		
		Student stu=new Student();
		stu.setStuNo(stuNo);
		stu.setName(name);
		stu.setAge(age);
		stu.setScore(score);
		stu.setIdCard(idCard);
		stu.setAddTime(addTime);
		

		//�õ�������Ϣ
		String  title = request.getParameter("title"); 
		int  letterCount  =Integer.parseInt(request.getParameter("letterCount")); 
		String teacher = request.getParameter("teacher"); 
		String introduce = request.getParameter("introduce"); 
		
		Paper paper=new Paper();
		paper.setTitle(title);
		paper.setLetterCount(letterCount);
		paper.setTeacher(teacher);
		paper.setIntroduce(introduce);
		paper.setStuNo(stuNo);
		

		//�õ�ѡ����Ϣ
		String [] courses=request.getParameterValues("courseIds");
			
		//����dao��
		dao.addStudent(stu, paper, courses);
		
		//ת��
		request.setAttribute("msg", "ѧ����Ϣ��ӳɹ�");
		request.getRequestDispatcher("/student-add.jsp").forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
