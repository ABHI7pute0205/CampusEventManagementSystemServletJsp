
<%
HttpSession session1 = request.getSession(false);
if (session1 == null || session1.getAttribute("adminUser") == null) {
	response.sendRedirect("AdminLogin.html");
	return;
}
%>

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

#allStudent {
	margin-left: 120px;
}

#deptSearch {
	width: 1100px;
	margin-left: 120px;
}
</style>
</head>

<body>

	<nav class="navbar navbar-light bg-light">
		<div class="container">
			<span class="navbar-brand">Student Operation Dashboard</span> <span>
				<marquee class="text-black"> Welcome Admin Into Student
					Operation Section </marquee>
			</span> <a href="AdminDashboard.jsp" class="btn btn-outline-dark btn-sm">
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

			<!--  pdf download  -->
			<a href="StudentPdfServlet" class="btn btn-info m-2"> Download
				Student Detail Pdf </a>


		</div>


		<!-- ADD STUDENT -->
		<div id="add" class="operation-section">
			<div id="messageBox"></div>

			<h4>Enter Student Details</h4>

			<form action="AddStudentServlet" method="post">
				<input class="form-control mb-2" name="sname"
					placeholder="Student Name" required /> <input
					class="form-control mb-2" name="email" placeholder="Student email"
					required /> <input class="form-control mb-2" name="department"
					placeholder="Student Department" required /> <input
					class="form-control mb-2" name="mobile"
					placeholder="Student Mobile" required /> <input
					class="form-control mb-2" name="password" type="password"
					placeholder="Student Password" required />

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

	<!-- Search student by  department -->

	<div id="dept" class="operation-section">

		<h4 id="allStudent">Students by Department</h4>

		<form action="<%=request.getContextPath()%>/SearchStudentByDept"
			method="post">

			<input id="deptSearch" type="text" name="department"
				class="form-control mb-3" placeholder="Enter Department Name"
				required />

			<button id="allStudent" class="btn btn-warning">List
				Students</button>
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
		<!-- this is pagination button  -->
		<%
		Integer deptcurrentPage = (Integer) request.getAttribute("currentPage");
		Integer depttotalPages = (Integer) request.getAttribute("totalPages");
		String department = (String) request.getAttribute("department");
		%>

		<%
		if (deptcurrentPage != null && depttotalPages != null) {
		%>
		<div class="mt-3 text-center">

			<%
			if (deptcurrentPage > 1) {
			%>
			<a class="btn btn-secondary"
				href="SearchStudentByDept?department=<%=department%>&page=<%=deptcurrentPage - 1%>">
				Previous </a>

			<%
			}
			%>

			<span class="mx-3"> Page <%=deptcurrentPage%> of <%=depttotalPages%>
			</span>

			<%
			if (deptcurrentPage < depttotalPages) {
			%>
			<a class="btn btn-secondary"
				href="SearchStudentByDept?department=<%=department%>&page=<%=deptcurrentPage + 1%>">
				Next </a>
			<%
			}
			%>

		</div>
		<%
		}
		%>

		<!-- eith he search by department ch end zal  -->

	</div>

	<!--List all Student -->

	<div id="all" class="operation-section">
		<h4 id=allStudent>All Students</h4>

		<form action="<%=request.getContextPath()%>/ListAllStudent"
			method="get">

			<button id="allStudent" class="btn btn-info mb-3">Load All
				Students</button>
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
					<th>Actions</th>
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

<!--  -->
					<td>
						 <a href="EditStudentServlet?studentId=<%=s.getSid()%>"
						class="btn btn-sm btn-success"> Edit Student </a> 
						<a
						href="DeleteStudentServlet?studentId=<%=s.getSid()%>"
						class="btn btn-sm btn-danger">Delete Student</a>
					</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<%
		}
		%>


		<!-- this is pagination button  -->
		<%
		// servlet madhun setAttribute ne currentPage che value servlet mdhun .jsp la pass kele 
		// and .getAttribute ne te value get kele 
		Integer allCurrentPage = (Integer) request.getAttribute("allcurrentPage");
		Integer alltotalPages = (Integer) request.getAttribute("alltotalPages");
		%>

		<div class="mt-3 text-center">

			<!-- href="ListAllStudent" jar user ne previous btn var ti click kel tar same servlet var ti redirect zal pahije tya sathi same servlet che URL href madhe pass kele  -->
			<%
			if (allCurrentPage != null && alltotalPages != null) {
			%>
			<div class="mt-3 text-center">

				<%
				if (allCurrentPage > 1) {
				%>
				<a class="btn btn-secondary"
					href="ListAllStudent?page=<%=allCurrentPage - 1%>"> Previous </a>
				<%
				}
				%>

				<span class="mx-3"> Page <%=allCurrentPage%> of <%=alltotalPages%>
				</span>

				<%
				if (allCurrentPage < alltotalPages) {
				%>
				<a class="btn btn-secondary"
					href="ListAllStudent?page=<%=allCurrentPage + 1%>"> Next </a>
				<%
				}
				%>

			</div>
			<%
			}
			%>

		</div>

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
