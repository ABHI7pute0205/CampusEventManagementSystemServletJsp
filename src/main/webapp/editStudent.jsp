<%@ page import="Model.StudentModel" %>

<%
StudentModel s = (StudentModel) request.getAttribute("student");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Student</title>

<!-- Bootstrap CDN -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">

<style>
body {
	background-color: #f4f6f9;
}

.edit-card {
	max-width: 500px;
	margin: 80px auto;
	padding: 25px;
	border-radius: 12px;
	box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
	background: white;
}

.edit-card h3 {
	text-align: center;
	margin-bottom: 20px;
	font-weight: 600;
}

.form-label {
	font-weight: 500;
}
</style>
</head>

<body>

	<div class="edit-card">

		<h3>Edit Student</h3>

		<form action="<%=request.getContextPath()%>/UpdateStudentServlet"
			method="post">

			<input type="hidden" name="sid" value="<%=s.getSid()%>">

			<div class="mb-3">
				<label class="form-label">Student Name</label>
				<input type="text" name="sname" class="form-control"
					value="<%=s.getSname()%>" required>
			</div>

			<div class="mb-3">
				<label class="form-label">Email</label>
				<input type="email" name="email" class="form-control"
					value="<%=s.getEmail()%>" required>
			</div>

			<div class="mb-3">
				<label class="form-label">Contact</label>
				<input type="text" name="contact" class="form-control"
					value="<%=s.getContact()%>" required>
			</div>

			<div class="mb-3">
				<label class="form-label">Password</label>
				<input type="text" name="password" class="form-control"
					value="<%=s.getPassword()%>" required>
			</div>

			<div class="mb-4">
				<label class="form-label">Department</label>
				<input type="text" name="dept" class="form-control"
					value="<%=s.getDept()%>" required>
			</div>

			<div class="d-grid">
				<button type="submit" class="btn btn-primary">
					Update Student
				</button>
			</div>

		</form>

	</div>

</body>
</html>
