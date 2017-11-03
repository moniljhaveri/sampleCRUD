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
<h1>View Patient</h1>
<% 
out.print("View Patients");
   session = request.getSession();
   Object o = session.getAttribute("vP");
   ArrayList<Patient> vP = (ArrayList<Patient>)o; %>
   <table style="width:75%">
   <tr>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Age</th>
    <th>Sex</th>
  </tr>
   <%  

   	for(Patient p : vP){
		out.println("<tr>");
		out.println("<td>" + p.getFirstName() + "</td>");
		out.println("<td>" + p.getLastName() + "</td>");
		out.println("<td>" + p.getAge() + "</td>");
		out.println("<td>" + p.getSex() + "</td>");
		out.println("</tr>");
   	}
%>
</table>

</body>
</html>