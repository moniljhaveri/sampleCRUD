<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Create Patient</h1>
<form method="post" action="../CreatePatientController"/>
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