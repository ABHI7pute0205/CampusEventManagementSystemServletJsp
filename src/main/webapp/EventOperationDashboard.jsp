<%
    HttpSession session1 = request.getSession(false);
    if (session1 == null || session1.getAttribute("adminUser") == null) {
        response.sendRedirect("AdminLogin.html");
        return;
    }
%>



<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="Model.EventModel"%>
<%@ page import="java.util.List"%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Event Operation Dashboard</title>
<meta name="viewport" content="width=device-width, initial-scale=1" />

<!-- Bootstrap -->
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

	<nav class="navbar navbar-light bg-light px-3 border-bottom">
		<div class="container-fluid d-flex align-items-center">

			<!-- Left -->
			<span class="navbar-brand  text-dark"> Event Operation
				Dashboard </span>

			<!-- Marque tag chya text la back to login chya btn pasun left kad move kar nya 
		sathi me-5 kel mhanje margin dele -->

			<div class="text-center flex-grow-1 me-5">
				<marquee behavior="scroll" direction="left" scrollamount="4"
					class="text-dark fw-semibold"> Welcome Admin Into Event
					Operation Section </marquee>
			</div>

			<!-- Right -->
			<a href="AdminDashboard.jsp" class="btn btn-outline-danger btn-sm"> Back
				to Admin Page </a>

		</div>
	</nav>


	<div class="container mt-4">

		<!-- Buttons -->
		<div class="text-center mb-4">
			<button class="btn btn-primary m-2" onclick="showSection('addEvent')">Add
				Event</button>

			<button class="btn btn-info m-2" onclick="showSection('allEvent')">List
				All Events</button>

			<button class="btn btn-secondary m-2"
				onclick="showSection('upcomingEvent')">Upcoming Events</button>

		</div>

		<!-- Add Events -->
		<div id="addEvent" class="operation-section">

			<!-- Message Box -->
			<div id="messageBox"></div>

			<h4>Add Event</h4>

			<form action="<%=request.getContextPath()%>/AddEventServlet"
				method="post">


				<input type="text" class="form-control mb-2" name="name"
					placeholder="Event Name" required /> <input type="date"
					class="form-control mb-2" name="date" required
					placeholder="Enter Date" /> <input type="text"
					class="form-control mb-2" name="location"
					placeholder="Location of  an event" required /> <input
					type="number" class="form-control mb-2" name="capacity"
					placeholder="capacity of an event" required></input>

				<button class="btn btn-primary">Add Event</button>
			</form>
		</div>


		<!-- List all events  -->

		<div id="allEvent" class="operation-section">
			<h4>All Events</h4>

			<form action="ListAllevents" method="get">
				<button class="btn btn-info mb-3">Load All Events</button>
			</form>

			<%
			List<EventModel> allEvents = (List<EventModel>) request.getAttribute("allEvents");

			//java.util.List<Model.EventModel> allEvents = (java.util.List<Model.EventModel>) request.getAttribute("allEvents");

			if (allEvents != null && !allEvents.isEmpty()) {
			%>

			<table class="table table-bordered">
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


		<!-- Upcoming events  -->
		<div id="upcomingEvent" class="operation-section">
			<h4>Upcoming Events</h4>

			<form action="<%=request.getContextPath()%>/UpcomingEventsServlet"
				method="get">



				<button class="btn btn-success mb-3">Load Upcoming Events</button>

			</form>

			<%
			List<EventModel> upcoming = (List<EventModel>) request.getAttribute("upComingE");

			if (upcoming != null && !upcoming.isEmpty()) {
			%>

			<table class="table table-bordered">
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
					for (EventModel e : upcoming) {
					%>
					<tr>
						<td><%=e.getEid()%></td>
						<td><%=e.getName()%></td>
						<td><%=e.getEdate()%></td>
						<td><%=e.getVenue()%></td>
						<td><%=e.getCapacity()%></td>
					</tr>
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



	</div>

	<!--JS-->
	<script>
		function showSection(id) {
			document.querySelectorAll(".operation-section")
				.forEach(sec => sec.style.display = "none");
			document.getElementById(id).style.display = "block";
		}

		
		<%String message = (String) request.getAttribute("eventMessage");
if (message != null) {%>
			showSection("addEvent");
			document.getElementById("messageBox").innerHTML =
				'<div class="alert alert-success mt-2 text-center"><%=message%></div>';
		<%}%>
		
		const params = new URLSearchParams(window.location.search);
		const status = params.get("status");

		if (status === "success") {
		  document.getElementById("messageBox").innerHTML =
		    `<div class="alert alert-success text-center">
		       Event added successfully!
		     </div>`;
		  showSection("add");
		}

		if (status === "error") {
		  document.getElementById("messageBox").innerHTML =
		    `<div class="alert alert-danger text-center">
		       Event not added!
		     </div>`;
		  showSection("add");
		}
		
		/* auto open section */
		<%if (request.getAttribute("allEvents") != null) {%>
		  showSection("all");
		<%}%>

		<%if (request.getAttribute("upcomingEvents") != null) {%>
		  showSection("upcoming");
		<%}%>
		
	</script>

</body>
</html>
