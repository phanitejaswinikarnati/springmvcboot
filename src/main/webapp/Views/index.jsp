<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Sum of two numbers:
	<br>
	<form action="add" method="post">
		Number 1: <input type="text" name="num1"><br> 
		Number 2: <input type="text" name="num2"><br> 
		<input type="submit">
	</form>
	
	<br>
	Aliens List: ${AllAliens}
	<br>
	
	Add Alien Data:<br>
	<form action="addAlienData" method="post">
		Number Alien ID: <input type="text" name="aid"><br> 
		Number Alien Name: <input type="text" name="aname"><br> 
		<input type="submit">
	</form>
	<br>
	
	Delete Alien Data:<br>
	<form action="deleteAlienData" method="post">
		Number Alien ID: <input type="text" name="aid"><br> 
		Number Alien Name: <input type="text" name="aname"><br> 
		<input type="submit">
	</form>
	<br>
	
	<form action="getAliensList" method="get">
		Get Aliens List: <input type="submit">
	</form>
	
	<br>
	<form action="getAlienData" method="post">
		Enter Alien ID: <input type="text" name="aid">
		<input type="submit">
	</form>
	<br>
	
	<form action="getAlienDataByName" method="post">
		Enter Alien Name: <input type="text" name="aname">
		<input type="submit">
	</form>
	

</body>
</html>