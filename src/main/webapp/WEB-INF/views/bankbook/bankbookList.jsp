<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>bankbookList</title>
		<c:import url="../temp/boot_head.jsp"></c:import>
	</head>
	<body>
		<c:import url="../temp/boot_nav.jsp"></c:import>
			
		<h1>List Renewal</h1>
		<div class="container-fluid">
			<div class="col-md-7 mx-auto my-0">
				<table class="table table-striped table-hover">
					<tr>
						<th>Number</th><th>Name</th><th>Rate</th>
					</tr>
					<c:forEach items="${list}" var="dto">
						<tr>
							<td>${dto.bookNumber}</td>
							<td><a href="./bankbookSelect?bookNumber=${dto.bookNumber}">${dto.bookName}</td>
							<td>${dto.bookRate}</td>
						</tr>
					</c:forEach>
					
				</table>
				<a href="./bankbookInsert" class="btn btn-danger">ADD</a>
				
			</div>
		</div>
	</body>
</html>