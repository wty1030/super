<%@ page language="java" import="java.util.*,com.dao.*,com.beans.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title></title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">

<style>
table, td {
	border: 1px solid blue;
	border-collapse: collapse;
}
</style>

</head>

<body>
	<div style="border: 3px solid blue; padding: 20px">
		<h1>学生信息</h1>
		<hr />
		<form action="StudentServlet" method="post">
		<input type="hidden" name="flag" value="add">

		学生学号：<input name="stuNo" value="${param.stuNo }" /> <br> 
		学生姓名：<input name="name" value="${param.name }" /><br> 
		学生年龄：<input name="age" value="${param.age }" /><br>
		身份证号：<input name="idCard" value="${param.idCard }" /><br> 
		入学成绩：<input name="score" value="${param.score }"  /><br> 
		选修课程： 
		
		<%
			IStudentDao dao=new StudentDaoImpl();
			List<Course>courseList=dao.getCourselist();
			
			String [] courses=request.getParameterValues("courseIds");
			List<String> coureseList=new ArrayList<String>();
			if(courses!=null){
				coureseList=Arrays.asList(courses);
			}
		%>
		
		<%
			for(Course c: courseList){
		%>
			<input 
				type="checkbox" 
				name="courseIds" 
				value="<%=c.getId()%>"
							
				<%
 					String str=coureseList.contains(c.getId()+"")?"checked":"";
					out.print(str);
				%>

				>

				<%=c.getName() %>  
				&nbsp; &nbsp; &nbsp;
		<%
			}
		%>
		
	
		<br>
		<h1>学生论文信息</h1>
		<hr />

		论文标题：<input name="title" value="${param.title }" /> <br> 
		论文字数：<input  name="letterCount" value="${param.letterCount }" /> <br>
	       指导教师：<input  name="teacher"  value="${param.teacher }"/> <br>
		论文简介：<textarea rows=5 cols=20   name="introduce" >${param.introduce }</textarea>
		
		<hr />
		<br>
		
		<input type="submit" value="全部保存" onclick="return confirm('确定提交吗')"  />
		<br>
	    <br />
	    
	    </form>
	    
	    ${msg }
	</div>

</body>
</html>