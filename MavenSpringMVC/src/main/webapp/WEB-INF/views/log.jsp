<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${result}
<form action="/spring-mvc/log" method="post">
Enter UserName<input type="text" name="username1"><br>
Enter Password<input type="password" name="password1"><br>
<input type="submit" value="submit">
</form>
</body>
</html>