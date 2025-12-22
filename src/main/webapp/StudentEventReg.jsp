
<!-- he je session aahe na each admin chya .jsp like studentEventReg.jsp | 
studentOperation.jsp | EventOperationDashboard.jsp hya saglya file madhe top la session check
 kara y ch nahi tar operation perform hotat logout var ti click tari again  -->
 
 
<%
    HttpSession session1 = request.getSession(false);
    if (session1 == null || session1.getAttribute("adminUser") == null) {
        response.sendRedirect("AdminLogin.html");
        return;
    }
%>



<%@ page import="java.util.List"%>
<%@ page import="Model.EventModel"%>
<%@ page import="Model.StudentModel"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Student Event Registration Dashboard</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />

<!-- Bootstrap CDN -->
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
	<!--   this is new navbar  -->

	<nav class="navbar navbar-light bg-light px-3 border-bottom">
		<div class="container-fluid d-flex align-items-center">

			<!-- Left -->
			<span class="navbar-brand  text-dark"> Student Event
				Registration Dashboard </span>

			<!-- Marque tag chya text la back to login chya btn pasun left kad move kar nya 
		sathi me-5 kel mhanje margin dele -->

			<div class="text-center flex-grow-1 me-5">
				<marquee behavior="scroll" direction="left" scrollamount="4"
					class="text-dark fw-semibold"> Welcome Admin Into Student
					Event Registration Section </marquee>
			</div>

			<!-- Right -->
			<a href="AdminDashboard.jsp" class="btn btn-outline-danger btn-sm">Back
				to Admin Page </a>
		</div>
	</nav>

	<div class="container mt-4">

		<!-- Buttons -->
		<div class="text-center mb-4">
			<button class="btn btn-primary m-2"
				onclick="showSection('studentEvents')">Student Wise Event
				Registration</button>

			<button class="btn btn-success m-2"
				onclick="showSection('allStudents')">Event Wise Student
				Registration</button>

			<button class="btn btn-info m-2"
				onclick="showSection('eventDetails')">Event Capacity
				Details</button>
		</div>

		<!-- Student wise Event Registration -->

		<div id="studentEvents" class="operation-section">
			<h4>Events Registered by Student</h4>

			<form action="StudentWiseEventRegServlet" method="get">
				<input type="number" name="sid" class="form-control mb-3"
					placeholder="Enter Student ID" />
				<button class="btn btn-primary">Get Details</button>
			</form>

			<%
			List<EventModel> studentEvents = (List<EventModel>) request.getAttribute("studRegForEvent");

			if (studentEvents != null && !studentEvents.isEmpty()) {
			%>

			<table class="table table-bordered mt-3">
				<thead class="table-success">
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Date</th>
						<th>Venue</th>
						<th>Capacity</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (EventModel e : studentEvents) {
					%>
					<tr>
						<td><%=e.getEid()%></td>
						<td><%=e.getName()%></td>
						<td><%=e.getEdate()%></td>
						<td><%=e.getVenue()%></td>
						<td><%=e.getCapacity()%></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>

			<%
			} else if (request.getParameter("sid") != null) {
			%>
			<div class="text-danger text-center mt-3">No events registered
				for this student</div>
			<%
			}
			%>
		</div>

		<!-- Event Wise Student Registration -->


		<div id="allStudents" class="operation-section">
			<h4>Students Registered for Event Enter Event name to see</h4>

			<form action="EventWieseStudentRegServlet" method="get">
				<input type="text" name="eventName" class="form-control mb-3"
					placeholder="Enter Event Name" />
				<button class="btn btn-primary">Get Details</button>
			</form>

			<%
			List<StudentModel> studentList = (List<StudentModel>) request.getAttribute("studEventReg");

			if (studentList != null && !studentList.isEmpty()) {
			%>

			<table class="table table-bordered mt-3">
				<thead class="table-success">
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Email</th>
						<th>Contact</th>
						<th>Department</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (StudentModel s : studentList) {
					%>
					<tr>
						<td><%=s.getSid()%></td>
						<td><%=s.getSname()%></td>
						<td><%=s.getEmail()%></td>
						<td><%=s.getContact()%></td>
						<td><%=s.getDept()%></td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>

			<%
			} else if (request.getParameter("eventName") != null) {
			%>
			<div class="text-danger text-center mt-3">No students
				registered for this event</div>
			<%
			}
			%>
		</div>


		<!-- Event Details  -->

		<div id="eventDetails" class="operation-section">
			<h4>Event Details Enter Event id to see it's details</h4>

			<form action="EventCapaciyDetailsServlet" method="get">
				<input type="text" name="eid" class="form-control mb-3"
					placeholder="Enter Event Id" />
				<button class="btn btn-primary">Get Details</button>
			</form>


			<%
			Model.EventModel event = (Model.EventModel) request.getAttribute("eventCapacity");

			if (event != null) {
			%>

			<table class="table table-bordered mt-3">
				<thead class="table-info">
					<tr>
						<th>Event Name</th>
						<th>Total Capacity</th>
						<th>Allocated Seats</th>
						<th>Remaining Seats</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><%=event.getName()%></td>
						<td><%=event.getCapacity()%></td>
						<td><%=event.getRegistered()%></td>
						<td><%=event.getAvailable()%></td>
					</tr>
				</tbody>
			</table>

			<%
			} else if (request.getParameter("eid") != null) {
			%>

			<div class="text-danger text-center mt-3">Event not found</div>

			<%
			}
			%>

		</div>

		<!-- JS -->
		<script>
	function showSection(sectionId) {
		document.querySelectorAll(".operation-section")
			.forEach(s => s.style.display = "none");

		document.getElementById(sectionId).style.display = "block";
	}
	</script>
</body>
</html>
