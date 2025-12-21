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
	<!-- Navbar -->
	<nav class="navbar navbar-dark bg-dark">
		<div class="container">
			<span class="navbar-brand">Student Event Registration
				Dashboard</span> <span><marquee style="color: #f8f9fa"
					class="navbar-brand" behavior="scroll" direction="left">
					Welcome Admin Into Student Event Registration Section </marquee></span> <a
				href="AdminDashboard.html" class="btn btn-outline-light btn-sm">Back
				to Admin Page</a>
		</div>
	</nav>

	<div class="container mt-4">
		<!-- Operation Buttons -->
		<div class="text-center mb-4">
			<button class="btn btn-primary m-2"
				onclick="showSection('studentEvents')">Student Registered
				Events</button>
			<button class="btn btn-success m-2"
				onclick="showSection('allStudents')">Students Registered
				for Events</button>
			<button class="btn btn-info m-2"
				onclick="showSection('eventDetails')">Event Details</button>
		</div>

		<!-- 1. EVENTS REGISTERED BY STUDENT -->
		<div id="studentEvents" class="operation-section">
			<h4>Events Registered by Student</h4>
			<input type="number" class="form-control mb-3"
				placeholder="Enter Student ID" />

			<table class="table table-bordered">
				<thead class="table-dark">
					<tr>
						<th>Event ID</th>
						<th>Event Name</th>
						<th>Date</th>
						<th>Location</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>401</td>
						<td>Tech Seminar</td>
						<td>2025-02-10</td>
						<td>Auditorium</td>
					</tr>
				</tbody>
			</table>
		</div>

		<!-- 2. STUDENTS REGISTERED FOR A SPECIFIC EVENT -->
		<div id="allStudents" class="operation-section">
			<h4>Students Registered for Event</h4>

			<input type="number" class="form-control mb-3"
				placeholder="Enter Event ID" />

			<table class="table table-bordered table-striped">
				<thead class="table-success">
					<tr>
						<th>Student ID</th>
						<th>Student Name</th>
						<th>Department</th>
						<th>Event Name</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>101</td>
						<td>Rahul Patil</td>
						<td>Computer</td>
						<td>AI Workshop</td>
					</tr>
					<tr>
						<td>102</td>
						<td>Amit Deshmukh</td>
						<td>IT</td>
						<td>AI Workshop</td>
					</tr>
				</tbody>
			</table>
		</div>

		<!-- 3. EVENT DETAILS -->
		<div id="eventDetails" class="operation-section">
			<h4>Event Details</h4>
			<input type="number" class="form-control mb-3"
				placeholder="Enter Event ID" />

			<table class="table table-bordered">
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
						<td>AI Workshop</td>
						<td>100</td>
						<td>65</td>
						<td>35</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<!-- JS -->
	<script>
      function showSection(sectionId) {
        document
          .querySelectorAll(".operation-section")
          .forEach((section) => (section.style.display = "none"));

        document.getElementById(sectionId).style.display = "block";
      }
    </script>
</body>
</html>