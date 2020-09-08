<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Alien Details: ${alienData}
	<br>
	
	Welcome ${name}: ${alienData.aname}
	<br>
	
	Aliens List: ${AliensDataList}
	<br>
	
	Alien Data of ID ${AlienData.aid}: ${AlienData}
	
	<br>
	
	Aliens By Name: ${findAliensByName}
	
	
</body>
</html>