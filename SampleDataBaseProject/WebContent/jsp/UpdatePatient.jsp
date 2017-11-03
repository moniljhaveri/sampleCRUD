<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="Bean.Patient" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Patient</title>
</head>
<body>
<h1>Update Patient</h1>
<form method="post" action="../UpdatePatientController"/>
<select name="dropdown">
<%  
   session = request.getSession();
   Object o = session.getAttribute("vP");
   ArrayList<Patient> vP = (ArrayList<Patient>)o;
   for(Patient p : vP){
	   out.println("<option value=" + p.getId() + ">" + p.getFirstName() + "</option>");
   }
%>  
</select>
<table style="width:75%">
<tr>
<th>First Name: <input type="text" name="firstName" required><br><th>
</tr>
<tr>
<th>Last Name: <input type="text" name="lastName" required><br><th>
</tr>
<tr>
<th>Age: <input type="number" name="age" required><br><th>
</tr>
<tr>
<th>Sex<br>
<input type="radio" name="gender" value="m" required>Male
<input type="radio" name="gender" value="f" required>Female
<input type="radio" name="gender" value="o" required>Other
<br><br>
<input type="submit">
</th>
</tr>
</table>
</form>

</body>
</html>