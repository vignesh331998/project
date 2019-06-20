<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Deactivation  Page</title>
</head>
<body bgcolor="#F8F9F9">
	<div id="reg" style="text-align: center;">
		<h1 style="text-decoration: underline;">
			<i>Deactivation  Page</i>
		</h1>
		<div style="float:right">
<form align="right" method="post" action="UserProfile.jsp">
  <label class="logoutLblPos">
  <input name="submit" type="submit" value="Back">
  </label>
</form>
</div>
	</div>
	<form action="DeactivateController"  method="post">
    <tr>
				
					<td><label for="uname">UserName</label></td>
					<td><input type="text" id="uname" name="uname"
						placeholder="Enter UserName" /></td>
				</tr>
                 <br>

				<tr>
					<td><label for="upwd" class="align">Password</label></td>
					<td><input type="password" id="upwd" name="upwd"
						placeholder="Enter Password" /></td>
				</tr>
				<br>
				<input type="submit" class="registerbtn" name="s" value="Deactivate" />
				</form>
</body>
</html>