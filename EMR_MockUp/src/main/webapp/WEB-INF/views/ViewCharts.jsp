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
					<li><form:form class="form"
							action="${pageContext.request.contextPath}/getChart"
							method="post">
							<button type="submit" class="btn" name="dateSelected"
								value="${date}">
								<c:out value="${date}" />
							</button>
						</form:form></li>
				</c:forEach>
			</ul>
		</div>
		<c:if test="${selectedChart != null}">
			<div class="panel panel-default">
				<div class="panel-heading">CNA Charts for
					${selectedChart.createdDate}</div>
				<div class="panel-body">
					<div class="row">
						<div class="col-md-6">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h1 class="panel-title">Food Intake</h1>
								</div>
								<div class="panel-body">
									<h1>
										<span class="label label-default">Breakfast:
											${selectedChart.foodIntake.breakfast} </span>
									</h1>
									<h1>
										<span class="label label-default">Lunch:
											${selectedChart.foodIntake.lunch} </span>
									</h1>
									<h1>
										<span class="label label-default">Supper:
											${selectedChart.foodIntake.supper} </span>
									</h1>
									<h1>
										<span class="label label-default">Snack:
											${selectedChart.foodIntake.snack} </span>
									</h1>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h1 class="panel-title">Food Intake</h1>
								</div>
								<div class="panel-body">
									<h1>
										<span class="label label-default">Breakfast:
											${selectedChart.fluidIntake.breakfast} </span>
									</h1>
									<h1>
										<span class="label label-default">Lunch:
											${selectedChart.fluidIntake.lunch} </span>
									</h1>
									<h1>
										<span class="label label-default">Supper:
											${selectedChart.fluidIntake.supper} </span>
									</h1>
									<h1>
										<span class="label label-default">Other:
											${selectedChart.fluidIntake.other} </span>
									</h1>
								</div>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h1 class="panel-title">Fluid Output</h1>
								</div>
								<div class="panel-body">
									<div class="panel panel-default">
										<div class="panel-heading">
											<h3 class="panel-title">Urine</h3>
											<div class="panel-body">
												<h3>
													<span class="label label-default">ML:
														${selectedChart.fluidOutput.ml} </span>
												</h3>
												<h3>
													<span class="label label-default">Times Voided:
														${selectedChart.fluidOutput.timesVoided} </span>
												</h3>
											</div>
										</div>
									</div>
									<h3>
										<span class="label label-default">Emesis:
											${selectedChart.fluidOutput.emesis} </span>
									</h3>
									<h3>
										<span class="label label-default">Bowel Movement:
											${selectedChart.bowelMovement} </span>
									</h3>
								</div>
							</div>
						</div>
						<div class="col-md-6">
							<div class="panel panel-default">
								<div class="panel-heading">
									<h1 class="panel-title">Activities of Daily Living</h1>
								</div>
								<div class="panel-body">
									<h3>
										<span class="label label-default">Bathing:
											${selectedChart.activities.bathing} </span>
									</h3>
									<h3>
										<span class="label label-default">Dressing:
											${selectedChart.activities.dressing} </span>
									</h3>
									<h3>
										<span class="label label-default">Oral Care:
											${selectedChart.activities.oralCare} </span>
									</h3>
									<h3>
										<span class="label label-default">Eating:
											${selectedChart.activities.eating} </span>
									</h3>
									<h3>
										<span class="label label-default">Transferring:
											${selectedChart.activities.transferring} </span>
									</h3>
									<div class="panel panel-default">
										<div class="panel-heading">
											<h3 class="panel-title">Ambulation</h3>
											<div class="panel-body">
												<h3>
													<span class="label label-default">Feet:
														${selectedChart.activities.ambulationDistance} </span>
												</h3>
												<h3>
													<span class="label label-default">Ambulation:
														${selectedChart.activities.ambulationType} </span>
												</h3>
											</div>
										</div>
									</div>
								</div>
							</div>
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
