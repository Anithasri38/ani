<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type" content="text/html;charset=ISO-8859-1">
<title>Wishes from jsp</title>
</head>
<body>
Hell Good Morning ${name}
<p><font color="red">${errorMessage }</font></p>
<form action="/spring-mvc/login" method="post">
 Enter your name<input type="text" name="name"/><br>
 Enter Password<input type="password" name="password" />
 <input type="submit" value="login"/>
</form>
</body>
</html>