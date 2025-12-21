<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="Model.StudentModel"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Student Operation Dashboard</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet" />

<style>
body {
	background-color: #f8f9fa;
}

.operation-section {
	display: none;
}
</style>
</head>

<body>

	<nav class="navbar navbar-light bg-light">
		<div class="container">
			<span class="navbar-brand">Student Operation Dashboard</span> <span>
				<marquee class="text-black"> Welcome Admin Into Student
					Operation Section </marquee>
			</span> <a href="AdminDashboard.html" class="btn btn-outline-dark btn-sm">
				Back to Admin Page </a>
		</div>
	</nav>

	<div class="container mt-4">

		<div class="text-center mb-4">
			<button class="btn btn-primary m-2" onclick="showSection('add')">
				Add Student</button>

			<button class="btn btn-success m-2" onclick="showSection('search')">
				Search by Email</button>

			<button class="btn btn-warning m-2" onclick="showSection('dept')">
				Search by Department</button>

			<button class="btn btn-info m-2" onclick="showSection('all')">
				List All Students</button>
		</div>


		<!-- ADD STUDENT -->
		<div id="add" class="operation-section">
			<div id="messageBox"></div>

			<h4>Add Student</h4>

			<form action="AddStudentServlet" method="post">
				<input class="form-control mb-2" name="sname" placeholder="Name"
					required /> <input class="form-control mb-2" name="email"
					placeholder="Email" required /> <input class="form-control mb-2"
					name="department" placeholder="Department" required /> <input
					class="form-control mb-2" name="mobile" placeholder="Mobile"
					required /> <input class="form-control mb-2" name="password"
					type="password" placeholder="Password" required />
				<button class="btn btn-primary">Add Student</button>
			</form>
		</div>

		<!-- search by email -->
		<div id="search" class="operation-section">

			<h4>Search Student by Email ID</h4>

			<form action="<%=request.getContextPath()%>/SearchStudentByEmail"
				method="get">
				<input type="email" class="form-control mb-3" name="email"
					placeholder="Enter Student Email ID" required />
				<button class="btn btn-success">Search</button>
			</form>

			<%
			java.util.List<Model.StudentModel> list = (java.util.List<Model.StudentModel>) request.getAttribute("studentList");

			if (list != null && !list.isEmpty()) {
			%>

			<table class="table table-bordered mt-4">
				<thead class="table-dark">
					<tr>
						<th>Name</th>
						<th>Email</th>
						<th>Department</th>
						<th>Contact</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (Model.StudentModel s : list) {
					%>
					<tr>
						<td><%=s.getSname()%></td>
						<td><%=s.getEmail()%></td>
						<td><%=s.getDept()%></td>
						<td><%=s.getContact()%></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>

			<%
			} else if (request.getAttribute("studentList") != null) {
			%>
			<div class="alert alert-warning mt-3">No student found with
				this email</div>
			<%
			}
			%>

		</div>
	</div>

	<!--  department -->
	<div id="dept" class="operation-section">

		<h4>Students by Department</h4>

		<form action="<%=request.getContextPath()%>/SearchStudentByDept"
			method="post">

			<input type="text" name="department" class="form-control mb-3"
				placeholder="Enter Department Name" required />
			<button class="btn btn-warning">List Students</button>
		</form>

		<%
		java.util.List<Model.StudentModel> deptList = (java.util.List<Model.StudentModel>) request.getAttribute("deptStudent");

		if (deptList != null && !deptList.isEmpty()) {
		%>

		<table class="table table-bordered mt-3">
			<thead class="table-dark">
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>Department</th>
					<th>Contact</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (Model.StudentModel s : deptList) {
				%>
				<tr>
					<td><%=s.getSid()%></td>
					<td><%=s.getSname()%></td>
					<td><%=s.getEmail()%></td>
					<td><%=s.getDept()%></td>
					<td><%=s.getContact()%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>

		<%
		} else if (deptList != null) {
		%>
		<div class="alert alert-danger mt-3">No students found for this
			department</div>
		<%
		}
		%>

	</div>

	<!--List all Student -->

	<div id="all" class="operation-section">
		<h4>All Students</h4>

		<form action="<%=request.getContextPath()%>/ListAllStudent"
			method="get">

			<button class="btn btn-info mb-3">Load All Students</button>
		</form>

		<%
		List<StudentModel> allList = (List<StudentModel>) request.getAttribute("allStudents");

		if (allList != null) {
		%>
		<table class="table table-bordered">
			<thead class="table-dark">
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Email</th>
					<th>Department</th>
					<th>Contact</th>
					<th>Password</th>
				</tr>
			</thead>
			<tbody>
				<%
				for (Model.StudentModel s : allList) {
				%>
				<tr>
					<td><%=s.getSid()%></td>
					<td><%=s.getSname()%></td>
					<td><%=s.getEmail()%></td>
					<td><%=s.getDept()%></td>
					<td><%=s.getContact()%></td>
					<td><%=s.getPassword()%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<%
		}
		%>
	</div>

	<script>
	function showSection(id) {
		document.querySelectorAll(".operation-section")
			.forEach(sec => sec.style.display = "none");
		document.getElementById(id).style.display = "block";
	}

	//  table display hoil jar tya depratment che student present asle tar
	<%if (request.getAttribute("studentList") != null) {%>
		showSection("search");
	<%}%>

	<%if (request.getAttribute("deptStudent") != null) {%>
	showSection("dept");
	<%}%>
	
	<%if (request.getAttribute("allStudents") != null) {%>
	showSection("all");
<%}%>
	</script>

</body>
</html>
