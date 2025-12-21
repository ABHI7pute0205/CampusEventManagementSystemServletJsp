<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="Model.EventModel"%>
<%@ page import="jakarta.servlet.http.HttpSession"%>

<%
String msg = request.getParameter("msg");
if ("success".equals(msg)) {
%>
<div class="alert alert-success">Event registered successfully</div>
<%
} else if ("cancel".equals(msg)) {
%>
<div class="alert alert-warning">Event registration cancelled</div>
<%
}
%>

<%
/* Session data check  */
HttpSession session1 = request.getSession(false);
if (session1 == null || session1.getAttribute("studentId") == null) {
	response.sendRedirect("login.html");
	return;
}

int studentId = (int) session1.getAttribute("studentId");
String studentEmail = (String) session1.getAttribute("studentEmail");

/*  */
String view = request.getParameter("view");
if (view == null) {
	view = "all";
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Event Dashboard</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body class="bg-light text-dark mt-3">

	<!-- Nav bar start-->
	
	<nav class="navbar navbar-light bg-light px-3 border-bottom">
		<div class="container-fluid d-flex align-items-center">

			<!-- Left -->
			<span class="navbar-brand fw-bold text-dark"> Student
				Dashboard </span>

			<!-- Marque tag chya text la back to login chya btn pasun left kad move kar nya 
		sathi me-5 kel mhanje margin dele -->

			<div class="text-center flex-grow-1 me-5">
				<marquee behavior="scroll" direction="left" scrollamount="4"
					class="text-dark fw-semibold">
					<%=(studentEmail != null ? "  " + studentEmail : "")%>
					Welcome to Student Dashboard
				</marquee>
			</div>

			<!-- Right -->
			<a href="login.html" class="btn btn-outline-danger btn-sm"> Back
				to Login </a>

		</div>
	</nav>

	<div class="container mt-4">

		<!-- Success Msg -->
		<%
		if ("success".equals(request.getParameter("msg"))) {
		%>
		<div class="alert alert-success">Register for the event success
		</div>
		<%
		}
		%>

		<!-- Buttons which are visible to User-->
		
		<div class="mb-4 text-center">
			<a href="StudentDashboard.jsp?view=all" class="btn btn-primary me-2">
				View All Events </a> <a href="StudentDashboard.jsp?view=upcoming"
				class="btn btn-success me-2"> View Upcoming Events </a> <a
				href="StudentDashboard.jsp?view=registered" class="btn btn-warning">
				View Registered Events </a>
		</div>

		
		<!-- All Events S -->
		<%
		if ("all".equals(view)) {
		%>
		<div id="allEvent" class="operation-section">

			<h4>All Events</h4>

			<form action="<%=request.getContextPath()%>/ListAllEventsServlet"
				method="get">
				<input type="hidden" name="view" value="all">
				<button class="btn btn-info mb-3">Load All Events</button>
			</form>

			<%
			List<EventModel> allEvents = (List<EventModel>) request.getAttribute("allEvents");

			if (allEvents != null && !allEvents.isEmpty()) {
			%>

			<table class="table table-bordered bg-white">
				<thead class="table-dark">
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
					for (EventModel e : allEvents) {
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
			}
			%>
		</div>
		<%
		}
		%>

		<!-- Upcoming events -->

		<%
		if ("upcoming".equals(view)) {
		%>
		<div id="upcomingEvent" class="operation-section">

			<h4>Upcoming Events</h4>

			<form
				action="<%=request.getContextPath()%>/ListOfUpcomingEventServlet"
				method="get">
				<input type="hidden" name="view" value="upcoming">
				<button class="btn btn-info mb-3">Load Upcoming Events</button>
			</form>

			<%
			List<EventModel> upcomingEvents = (List<EventModel>) request.getAttribute("upcomingEvents");

			if (upcomingEvents != null && !upcomingEvents.isEmpty()) {
			%>

			<table class="table table-bordered bg-white">
				<thead class="table-dark">
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Date</th>
						<th>Venue</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (EventModel e : upcomingEvents) {
					%>
					<tr>
						<td><%=e.getEid()%></td>
						<td><%=e.getName()%></td>
						<td><%=e.getEdate()%></td>
						<td><%=e.getVenue()%></td>
						<td><a href="ApplyForEventServlet?eventId=<%=e.getEid()%>"
							class="btn btn-sm btn-success">Apply</a> <a
							href="CancelEventServlet?eventId=<%=e.getEid()%>"
							class="btn btn-sm btn-danger">Cancel</a></td>
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
		<%
		}
		%>

		
		<!-- Register Events  -->
		<%
		if ("registered".equals(view)) {
		%>
		<div id="registeredEvent" class="operation-section">

			<h4>Your Registered Events</h4>

			<form
				action="<%=request.getContextPath()%>/ListOfRegisteredEventsServlet"
				method="get">
				<input type="hidden" name="view" value="registered">
				<button class="btn btn-info mb-3">Load Register Events</button>
			</form>



			<%
			List<EventModel> registeredEvents = (List<EventModel>) request.getAttribute("registeredEvents");

			if (registeredEvents != null && !registeredEvents.isEmpty()) {
			%>

			<table class="table table-bordered bg-white">
				<thead class="table-dark">
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Date</th>
						<th>Status</th>
					</tr>
				</thead>
				<tbody>
					<%
					for (EventModel e : registeredEvents) {
					%>
					<tr>
						<td><%=e.getEid()%></td>
						<td><%=e.getName()%></td>
						<td><%=e.getEdate()%></td>
						<td>Registered</td>
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
		<%
		}
		%>

	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js">
		
	</script>

</body>
</html>
