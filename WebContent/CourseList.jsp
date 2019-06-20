<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Course List</title>
</head>
<body>


	<div
		style="margin-left: 300px; height: 300px; width: 300px; ">
	
	<form action="CourseController"  method="post">
	<table cellpadding="10" border="0" bgcolor="#e3e3e3">
		<tr bgcolor="#0000cd" style="color: white; font-weight: bold">
			<th>Course Name</th>
			<th>Course ID</th>
			
		</tr>
		
		<c:forEach items="${requestScope.courseList}" var="course" varStatus="a">
			
				<tr bgcolor="#8470ff">
					<td><input type="text" name="coursename" value="${course.name}"></td>
					<td><input type="text" name="courseid" value="${course.id}"></td>
					<td><input type="text" name="vendorid" value="${course.userid}"></td>

				<td><input type="checkbox" name="choose" value="${course.id} ${course.userid}"/>Select</td>
				</tr>
		
		</c:forEach>
	</table>
	<input 	type="submit" class="registerbtn" name="s" value="Submit" />
	</form>
	</div>
<br />
<br />


</body>
</html>