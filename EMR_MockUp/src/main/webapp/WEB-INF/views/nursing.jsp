<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<title>Nursing Assessment</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link href="resources/css/bootstrap.css" rel="stylesheet">

<script src="resources/js/bootstrap.js"></script>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script src="https://code.jquery.com/jquery.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="resources/js/bootstrap.js"></script>

	<form class="form-inline" role="form">
		<div class="panel panel-primary">
			<div class="panel-heading">Enter nursing assessment
				information:</div>
			<div class="panel-body">
				<table class="table">
					<tbody>
						<tr>
							<td width="20%"><h3>Vital Signs</h3></td>
							<td><div class="form-group col-lg-6">
									<textarea class="form-control" rows="3"></textarea>
								</div></td>
						</tr>
						<tr>
							<td width="20%"><h3>Cardiovascular System</h3></td>
							<td><div class="form-group col-lg-6">
									<textarea class="form-control" rows="3"></textarea>
								</div></td>
						</tr>
						<tr>
							<td width="20%"><h3>Digestive System</h3></td>
							<td><div class="form-group col-lg-6">
									<textarea class="form-control" rows="3"></textarea>
								</div></td>
						</tr>
						<tr>
							<td width="20%"><h3>Endocrine System</h3></td>
							<td><div class="form-group col-lg-6">
									<textarea class="form-control" rows="3"></textarea>
								</div></td>
						</tr>
						<tr>
							<td width="20%"><h3>Urinary System</h3></td>
							<td><div class="form-group col-lg-6">
									<textarea class="form-control" rows="3"></textarea>
								</div></td>
						</tr>
						<tr>
							<td width="20%"><h3>Musculosceletal System</h3></td>
							<td><div class="form-group col-lg-6">
									<textarea class="form-control" rows="3"></textarea>
								</div></td>
						</tr>
						<tr>
							<td width="20%"><h3>Nervous System</h3></td>
							<td><div class="form-group col-lg-6">
									<textarea class="form-control" rows="3"></textarea>
								</div></td>
						</tr>
						<tr>
							<td width="20%"><h3>Respiratory System</h3></td>
							<td><div class="form-group col-lg-6">
									<textarea class="form-control" rows="3"></textarea>
								</div></td>
						</tr>
						<tr>
							<td width="20%"><h3>Behavior</h3></td>
							<td><div class="form-group col-lg-6">
									<textarea class="form-control" rows="3"></textarea>
								</div></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</form>
	<div class="centered-pills">
	<ul class="nav nav-pills">
		<li><a href="<c:url value="/home"/>">Back</a></li>
		<li><a href="<c:url value="/patientsList"/>">Save and Close</a></li>
	</ul>
	</div>
</body>
</html>