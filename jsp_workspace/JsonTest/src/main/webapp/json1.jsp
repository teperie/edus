<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<!DOCTYPE html>
	<html>

	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
	</head>

	<body>
		<span id="id"></span>
		<span id="name"></span>
		<span id="age"></span>
		<span id="grade"></span>
		<span id="department"></span>

		<script>
			let person = { id: "hong", name: "gildong", age: 20, info: { grade: 4, department: "computer" } };
			console.log(person);
			console.log(typeof person);
	
			let perStr = JSON.stringify(person);
			console.log(perStr);
			console.log(typeof perStr);
	
			let perObj = JSON.parse(perStr);
			console.log(perObj);
			console.log(typeof perObj);
	
			document.getElementById("id").innerHTML = perObj.id;
			document.getElementById("name").innerHTML = perObj.name;
			document.getElementById("age").innerHTML = perObj.age;
			document.getElementById("grade").innerHTML = perObj.info.grade;
			document.getElementById("department").innerHTML = perObj.info.department;
		</script>
	</body>

	</html>