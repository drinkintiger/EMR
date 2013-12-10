<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">

<title>View CNA Charts</title>

<!-- Bootstrap core CSS -->
<link href="resources/css/bootstrap.css" rel="stylesheet">

<!-- Custom styles for this template -->
<link href="resources/css/grid.css" rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy this line! -->
<!--[if lt IE 9]><script src="../../docs-assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>

<body>
	<div class="container">

		<div class="page-header">
			<h1>${selectedPatient.firstName} ${selectedPatient.lastName}'s</h1>
			<p class="lead">CNA Charts</p>
		</div>
		<div class="btn-group">
			<button type="button" class="btn btn-default dropdown-toggle"
				data-toggle="dropdown">
				Select a date <span class="caret"></span>
			</button>
			<ul class="dropdown-menu">
				<c:forEach items="${dateList}" var="date">
					<li>
						<form:form class="form"
							action="${pageContext.request.contextPath}/getAssessment"
							method="post">
							<button type="submit" class="btn" name="dateSelected"
								value="${date}">
								<c:out value="${date}" />
							</button>
						</form:form>
					</li>
				</c:forEach>
			</ul>
		</div>
		<c:if test="${selectedAssessment != null}">
			<div class="panel panel-default">
				<div class="panel-heading">Nursing Assessment for
					${selectedAssessment.createdDate}</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-md-12">
							<h3>Vital Signs</h3>
							${selectedAssessment.vitalSigns}
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<h3>Cardiovascular System</h3>
							${selectedAssessment.cardioSystem}
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<h3>Digestive System</h3>
							${selectedAssessment.digestiveSystem}
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<h3>Endocrine System</h3>
							${selectedAssessment.endocrineSystem}
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<h3>Urinary System</h3>
							${selectedAssessment.urinarySystem}
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<h3>Musculosceletal System</h3>
							${selectedAssessment.muscularSystem}
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<h3>Nervous System</h3>
							${selectedAssessment.nervousSystem}
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<h3>Respiratory System</h3>
							${selectedAssessment.respiratorySystem}
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<h3>Behavior</h3>
							${selectedAssessment.behavior}
						</div>
					</div>
				</div>
			</div>
		</c:if>
	</div>
	<!-- /container -->


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="https://code.jquery.com/jquery.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="resources/js/bootstrap.js"></script>
</body>
</html>
