<%@ page language="java" import="java.util.*,com.dao.*,com.beans.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath(); 
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>"> 
    
    <title></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body>
 
 	<form action="StudentServlet" method="post">
 		<input type="hidden" name="flag" value="manager">

    <div style="border:3px solid orange;padding:20px">
    	<h1>学生查询</h1>
    	<hr>
    	学生编号：<input name="stuNo" value="${param.stuNo }"   >  &nbsp;&nbsp;&nbsp; 
    	姓名：<input name="name" value="${param.name }" >  &nbsp;&nbsp;&nbsp;
    	入学成绩从：<input  name="scoreLower" value="${param.scoreLower }" > 
    	到<input name="scoreHeight" value="${param.scoreHeight }" >之间    &nbsp;&nbsp;&nbsp;
    	注册日期：从<input name="beginTime" value="${param.beginTime }" > 
    	到<input name="endTime"  value="${param.endTime }" > 之间  &nbsp;&nbsp;&nbsp; 
    	<input type="submit" name="查询" >
    	
    <hr>
    
    <%
    	List<Student> stuList=(List<Student>)request.getAttribute("stuList");
    %>
    	<table width="70%" >
	   		<tr>
	 			<td>编号</td><td>姓名</td><td>入学成绩</td><td>身份证号</td><td>注册日期</td><td>论文标题</td><td>指导教师</td><td>操作</td>
	 						
	 		</tr>
    			<%
    			if(stuList!=null){
	    			for(Student u:stuList){
	    		%>
	  			<tr>
	  					<td><%=u.getStuNo() %></td>
	  					<td><%=u.getName() %></td>
	  					<td><%=u.getScore() %></td>
	  					<td><%=u.getIdCard() %></td>
	  					<td><%=u.getAddTime() %></td>
	  					<td><%=u.getTitle() %></td>
	  					<td><%=u.getTeacher() %></td>
	  					<td><a href="StudentServlet?flag=del&id=<%=u.getStuNo() %>" onclick ="return confirm('该操作会删除学生的所有信息,确认吗')">删除</a></td>
	  						
	  			</tr>
	  			
	  			<%
	    			}
    			}
  			%>

    	</table>
    </div>
    
    </form>

  </body>
</html>