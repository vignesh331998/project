<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

  <body bgcolor="#F8F9F9">
 
  <div style="float:right">
<form align="right" method="post" action="VendorHome.jsp">
  <label class="logoutLblPos">
  <input name="submit" type="submit" value="Back">
  </label>
</form>
</div>

	<div id="reg" style="text-align: center;">
		<h1 style="text-decoration: underline;">
			<i>Courses</i>
		</h1>
	</div>
	<fieldset>
		<form action="VendorController"  method="post">
		<tr>
				
					<td><label for="cid">Course code</label></td>
					<td><input type="number" id="cid" name="cid"
						placeholder="Enter Course code" /></td>
				</tr>
                 <br>

				<tr>
					<td><label for="cname" class="align">Course Name</label></td>
					<td><input type="text" id="cname" name="cname"
						placeholder="Enter Course Name" /></td>
				</tr><br>
				<input
				type="submit" class="registerbtn" name="s" value="Add Course" />
			</form>	
</body>
</html>