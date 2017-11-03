<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="Bean.Patient" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Delete Patient</h1>

<form method="post" action="../DeletePatientController"/>
<select name="dropdown">
<%  
   session = request.getSession();
   Object o = session.getAttribute("vP");
   ArrayList<Patient> vP = (ArrayList<Patient>)o;
   for(Patient p : vP){
	   out.println("<option value=" + p.getId() + ">" + p.getFirstName() + "</option>");
   }
%>  
<input type="submit">
</form>
</select>
</body>
</html>