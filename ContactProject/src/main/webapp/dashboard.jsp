
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
<meta name='viewport' content='width=device-width, initial-scale=1'>
<style>
body{
background-color: #c4c2bb;
}
table{
margin: 0 auto;
background-color: #fc7303;
}
.heading{

margin: 0 auto;
}
button{
 background-color: green; 
  border: none;
  color: black;
  padding: 5px 3px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 15px;
  cursor: pointer;
}
button:hover {
  opacity: 0.8;
}
</style>
<meta charset="UTF-8">
<title>Dashboard</title>
</head>
<body>

<h1>All Active <i style='font-size:24px' class='fas'>&#xf101;</i></h1>
		<table class="table" border=1>
		   
		    <tr>
				<td><b>Name</b></td>
				<td><b>Email</b></td>
				<td><b>Message</b></td>
				<td><b>Activity</b></td>
				<td><b>Active Time</b></td>
				<td><b>Modify</b></td>
			</tr>
			<c:forEach items="${requests}" var="row">
				<tr>

					<td><c:out value="${row.uname}"></c:out></td>
					<td><c:out value="${row.email}"></c:out></td>
					<td><c:out value="${row.messege}"></c:out></td>
					<td><c:out value="${row.activity}"></c:out></td>
					<td><c:out value="${row.time}"></c:out></td>
					<td><form action="dashboard" method="POST">
							<button type="submit" value="${row.id}" name="requestId">Make
								Archive</button>
						</form></td>
						</tr>
						</c:forEach>
		</table>
		<h1>All Archive <i style='font-size:24px' class='fas'>&#xf101;</i></h1>
		<table class="table" border=1>
			<tr>
				<td><b>Name</b></td>
				<td><b>Email</b></td>
				<td><b>Message</b></td>
				<td><b>Activity</b></td>
				<td><b>Archive Time</b></td>
				<td><b>Change</b></td>
			</tr>
			<c:forEach items="${requestArchive}" var="row">

				<tr>

					<td><c:out value="${row.uname}"></c:out></td>
					<td><c:out value="${row.email}"></c:out></td>
					<td><c:out value="${row.messege}"></c:out></td>
					<td><c:out value="${row.activity}"></c:out></td>
					<td><c:out value="${row.time}"></c:out></td>
					
					<td><form action="dashboard" method="POST">
							<button type="submit" value="${row.id}" name="requestId">Make
								Active</button>
						</form></td>
				</tr>
			</c:forEach>
		</table>
</body>
</html>