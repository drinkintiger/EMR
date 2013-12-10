<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Patient Selection</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link href="resources/css/bootstrap.min.css" rel="stylesheet">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<h1>Select a patient:</h1>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="https://code.jquery.com/jquery.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="resources/js/bootstrap.js"></script>

	<div class="col-lg-6">
		<div class="panel panel-default">
			<!-- Default panel contents -->
			<!-- Table -->
			<table class="table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Patient's Name</th>
						<th>Active</th>
						<th>Nursing Assessments</th>
						<th>CNA Charts</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${patients}" var="patient">
						<tr>
							<td><c:out value="${patient.id}" /></td>
							<td><form:form class="form"
									action="${pageContext.request.contextPath}/home" method="post">
									<button type="submit" class="btn btn-primary"
										name="selectedPatientID" value="${patient.id}">
										<c:out value="${patient.firstName} ${patient.lastName}" />
									</button>
								</form:form></td>
							<td><c:out value="${patient.active}" /></td>
							<td><form:form class="form"
									action="${pageContext.request.contextPath}/ViewAssessments"
									method="post">
									<button type="submit" class="btn btn-primary"
										name="viewAssessment" value="${patient.id}">
										<c:out value="View assessments" />
									</button>
								</form:form></td>
							<td><form:form class="form"
									action="${pageContext.request.contextPath}/ViewCharts"
									method="post">
									<button type="submit" class="btn btn-primary"
										name="viewCharts" value="${patient.id}">
										<c:out value="View charts" />
									</button>
								</form:form></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<div class="col-lg-3 pull-right">
		<span class="label label-success">Logged in as
			${user.first_name} ${user.last_name}</span>
		<div class="centered-pills">
			<ul class="nav nav-pills">
				<li><a href="<c:url value="/login"/>">Sign Out</a></li>
			</ul>
		</div>
	</div>
</body>
</html>