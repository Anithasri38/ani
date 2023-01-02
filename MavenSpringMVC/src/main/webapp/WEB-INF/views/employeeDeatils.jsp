<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
    rel="stylesheet">
</head>
<body>
<table class="table">
<caption>your Employees are<br></caption>
   <thead>
    <tr>
      <th>EmployeeId</th>
      <th>EmployeeName</th>
      <th>EmployeeDepartMent</th>
      <th>EmployeeDesignation</th>
      <th>EmployeeSalary</th>
     </tr>
   </thead>
   <tbody>
       <c:forEach items="${employee}" var="emp">
         <tr>
            <td>${emp.employeeId}</td>
            <td>${emp.employeeName}</td>
            <td>${emp.employeeDepatment}</td>
            <td>${emp.employeeDesignation }</td>
            <td>${emp.employeeSalary }</td>
            </tr>
            </c:forEach>
            </tbody>
            </table>
</body>
</html>