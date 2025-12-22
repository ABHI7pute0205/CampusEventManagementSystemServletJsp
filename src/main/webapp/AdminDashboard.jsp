<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
    HttpSession session1 = request.getSession(false);
    if (session1 == null || session1.getAttribute("adminUser") == null) {
        // session → operations block
        response.sendRedirect("AdminLogin.html");
        return;
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Admin Dashboard</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet" />

<style>
body {
	background-color: #f8f9fa;
}

.dashboard-card {
	transition: transform 0.3s;
}

.dashboard-card:hover {
	transform: scale(1.05);
}

.custom-container {
	max-width: 80%;
}
</style>
</head>

<body>
	<!-- Navbar -->
	<nav class="navbar navbar-light bg-light">
		<div class="container custom-container">
			<span class="navbar-brand">Admin Dashboard </span> <span> <marquee
					style="color: black" class="navbar-brand" behavior="scroll"
					direction="left"> Welcome To Admin Dashboard
				</marquee>
			</span>

			<!-- when this logout button hit admin back to login page
			<a href="AdminLogoutServlet" class="btn btn-outline-dark btn-sm">
				Admin Logout </a>
			
			 -->
				
				<a href="<%=request.getContextPath()%>/AdminLogoutServlet"
				class="btn btn-outline-danger btn-sm">Admin Logout </a>
		</div>
	</nav>

	<!-- Dashboard -->
	<div class="container custom-container mt-5">
		<div class="row text-center">
			<div class="col-md-4 mb-4">
				<div class="card dashboard-card shadow p-5">
					<div class="card-body">
						<h4>Student Operation</h4>
						<p>Manage students</p>
						<a href="StudentOperation.jsp" class="btn btn-primary">Go</a>
					</div>
				</div>
			</div>

			<div class="col-md-4 mb-4">
				<div class="card dashboard-card shadow p-5">
					<div class="card-body">
						<h4>Event Operation</h4>
						<p>Manage events</p>
						<a href="EventOperationDashboard.jsp" class="btn btn-success">
							Go </a>
					</div>
				</div>
			</div>

			<div class="col-md-4 mb-4">
				<div class="card dashboard-card shadow p-5">
					<div class="card-body">
						<h4>Student Event</h4>
						<p>Manage Register students</p>
						<a href="StudentEventReg.jsp" class="btn btn-warning">Go</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
