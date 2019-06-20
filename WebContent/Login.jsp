<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<head>
<link href="./styles/css/login.css" rel="stylesheet" type="text/css">
<!-- <script type="text/javascript" src="./scripts/js/login.js"></script> -->
</head>
<body bgcolor="#F8F9F9">
 

	<div id="reg" style="text-align: center;">
		<h1 style="text-decoration: underline;">
			<i>Login Page</i>
		</h1>
	</div>
	<fieldset>
		<form action="UserControl"  method="post">
			<div class="imgcontainer">
				<img src=".\\assets\login.jfif" alt="Login icon" height="80"
					width="80">
			</div>
			<table id="tab">
               <tr>
               <td><label for="type"> Select Admin/Vendor/Subscriber</label></td>
				       <td>
               <select name="select">
               <option  value="Select">None</option>
               <option  value="Admin">Admin</option>
               <option  value="Vendor">Vendor</option>
               <option  value="Subscriber">Subscriber</option> 
               </select>
               </td>
               </tr>
				<tr>
				
					<td><label for="uname">UserName</label></td>
					<td><input type="text" id="uname" name="uname"
						placeholder="Enter UserName" /></td>
				</tr>
                 

				<tr>
					<td><label for="upwd" class="align">Password</label></td>
					<td><input type="password" id="upwd" name="upwd"
						placeholder="Enter Password" /></td>
				</tr>

			</table>
			<input type="hidden" name="action" value="Login" /> 
			<input
				type="submit" class="registerbtn" name="s" value="Login" />

		</form>
	</fieldset>
	<h1>${msg }</h1>
</body>
</html>
