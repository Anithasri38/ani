<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
    rel="stylesheet">
</head>
<body>
<h1 align="center">Registration Form</h1>
<div class="container">
 <form:errors path="customer.*"/>
 <form:form action="/spring-mvc/customerRegistration" modelAttribute="customerRegistration" method="post">
 <table align="center">
 <tr>
    <td>UserName:</td><td><input type="text" name="username"/><form:errors path="username" cssClass="error"/></td>
    </tr>
  <tr>
     <td>Password:</td><td><input type="password" name="password"/><form:errors path="password" cssClass="error"/></td>
   </tr>
 <tr>
     <td>Email:</td><td><input type="text" name="email"/><form:errors path="email" cssClass="error"/></td>
   </tr>
 <tr>
     <td>Contact:</td><td><input type="text" name="contact"/><form:errors path="contact" cssClass="error"/></td>
   </tr>
  <tr>
    <td>City:</td><td><select name="city">
     <option>Guntur</option>
     <option>Addanki</option>
     <option>Vijayawada</option>
     <option>Vizag</option>
     <option>Nellore</option>
     <option>Vinukonda</option>
     </select></td>
     </tr>
      <tr>
     <td>Zipcode:</td><td><input type="text" name="zipcode"/><form:errors path="zipcode" cssClass="error"/></td>
   </tr>
     
     <tr>
     <td><input type="submit" value="register"/></td>
     </tr>
     </table>
 </form:form>
 </div>
 <script src="webjars/jquery/1.9.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>