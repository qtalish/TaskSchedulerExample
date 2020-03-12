<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<title>Home</title>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<link href='http://fonts.googleapis.com/css?family=Oswald:400,300,700'
	rel='stylesheet' type='text/css'>
<style>
body {
	font-family: 'Georgia', sherif;
}
</style>
</head>
<body>
	<div class="container">
	<button onclick="window.location.href='list'" class="btn btn-primary">Student List</button>
		<table>
			<form:form action="save" modelAttribute="student" method="post">
				<form:hidden path="id" />
				<tr>
					<td>First Name:</td>
					<td><form:input path="fname" /></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><form:input path="lname" /></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><form:input path="email" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><form:password path="password" /></td>
				</tr>
				<tr>
					<td></td>
					<td><button class="btn btn-primary">Submit</button></td>
				</tr>
			</form:form>

		</table>

	</div>
</body>
</html>
