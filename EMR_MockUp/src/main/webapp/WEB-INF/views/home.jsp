<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Select Subsystem</title>

<!-- Bootstrap core CSS -->
<link href="resources/css/bootstrap.css" rel="stylesheet">
<script src="resources/js/bootstrap.js"></script>

</head>
<body>

	<div class="jumbotron" style="text-align: center">
		<h1>Select Category:</h1>
		<div class="spacer"> </div>
		<p>
			<a class="btn btn-primary btn-lg" style="margin-right: 80px"
				role="button" href="<c:url value="/nursing"/>">Nursing Assessment</a> <a
				class="btn btn-primary btn-lg" role="button" href="<c:url value="/cna"/>">CNA Charting</a>
				<a
				class="btn btn-primary btn-lg" style="margin-left: 80px" role="button" href="<c:url value="/charts"/>">Chart Metrics</a>
		</p>
	</div>
	<div class="centered-pills">
	<ul class="nav nav-pills">
		<li><a href="<c:url value="/patientsList"/>">Back</a></li>
	</ul>
	</div>
</body>
</html>
