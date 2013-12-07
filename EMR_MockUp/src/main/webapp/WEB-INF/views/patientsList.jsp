<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

	<form:form class="form" action="${pageContext.request.contextPath}/home" method="post">
		<div class="col-lg-3">
			<div class="panel panel-default">
				<!-- Default panel contents -->

				<!-- Table -->
				<table class="table">
					<thead>
						<tr>
							<th>ID</th>
							<th>Patient's Name</th>
							<th>Active</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${patients}" var="patient">
							<tr>
							<td><c:out value="${patient.id}"/></td>
							<td><button type="submit" class="btn btn-primary" name="selectedPatientID" value=${patient.id}>
								<c:out value="${patient.firstName} ${patient.lastName}"/>
								</button>
							</td>
							<td><c:out value="${patient.active}"/></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<div class="col-lg-6 btn-group">
			<div class="row">
				<div class="col-lg-3">
					<div class="input-group">
						<span class="input-group-addon"> <input type="radio" name="type">
						</span>
						<output class="form-control">Active</output>
					</div>
					<!-- /input-group -->
				</div>
			</div>
			<div class="row">
				<!-- /.col-lg-6 -->
				<div class="col-lg-3">
					<div class="input-group">
						<span class="input-group-addon"> <input type="radio" name="type">
						</span>
						<output type="text" class="form-control">Inactive</output>
					</div>
					<!-- /input-group -->
				</div>
				<!-- /.col-lg-6 -->
			</div>
			<!-- /.row -->
		</div>
		<div class="centered-pills">
	<ul class="nav nav-pills">
		<li><a href="<c:url value="/login"/>">Sign Out</a></li>
	</ul>
	</div>
	</form:form>
</body>
</html>