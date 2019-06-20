<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>WELCOME : ${sessionScope.user.name} </h3>
<div
		style="margin-left: 300px; height: 300px; width: 300px; ">
	
	<table cellpadding="10" border="0" bgcolor="#e3e3e3">
		<tr bgcolor="#0000cd" style="color: white; font-weight: bold">
		 
		<th>Course ID</th>
			<th>Course Name</th>
			
			
		</tr>
		
		<c:forEach items="${requestScope.clist}" var="cou" varStatus="a">
			
				<tr bgcolor="#8470ff">
					 
					<td>${cou.id}</td>
					<td>${cou.name}</td>

				</tr>
		
		</c:forEach>
	</table>
	
	</div>
<br />
<br />
</body>
</html>