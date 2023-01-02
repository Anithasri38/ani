<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Hello!!!!!!!!</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
    rel="stylesheet">
</head>
<body>
hi${name} <br>
your Todos are<br>
<nav role="navigation" class="navbar navbar-default">
	<div class="">
		<a href="http://www.in28minutes.com" class="navbar-brand">in28Minutes</a>
	</div>
	<div class="navbar-collapse">
		<ul class="nav navbar-nav">
			<li class="active"><a href="/login">Home</a></li>
			<li><a href="/list-todos">Todos</a></li>

		</ul>
	</div>
</nav>
<div class="container">
<table class="table">
<caption>your Todos are<br></caption>
   <thead>
    <tr>
      <th>Description</th>
      <th>Target Date</th>
      <th>Is Completed</th>
     </tr>
   </thead>
   <tbody>
       <c:forEach items="${todos}" var="todo">
         <tr>
            <td>${todo.desc}</td>
            <td><fmt:formatDate pattern="dd/MM/yyyy" value="${todo.targetDate}" /></td>
            <td>${todo.done}</td>
            <td><a href="/spring-mvc/update-todo?id=${todo.id}" class="btn btn-success">Update</a></td>
            <td><a href="/spring-mvc/delete-todo?id=${todo.id}" class="btn btn-danger">Delete</a></td>
            </tr>
            </c:forEach>
   </tbody>
</table>
</div>
</body>
<a class="btn btn-success" href="/spring-mvc/todo">Add</a>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>