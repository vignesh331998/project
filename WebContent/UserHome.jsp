<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Home</title>
</head>
<body>
<div style="float:right">
<form align="right" method="post" action="homepage.jsp">
  <label class="logoutLblPos">
  <input name="submit" type="submit" value="Logout">
  </label>
</form>
</div>
<h3>WELCOME : ${sessionScope.user.name} </h3>


<a href=UserProfile.jsp > Profile</a>
<a href=UserTrans.jsp > Transactions</a>
<a href=UserService.jsp > List of Services</a>
</body>
</html>