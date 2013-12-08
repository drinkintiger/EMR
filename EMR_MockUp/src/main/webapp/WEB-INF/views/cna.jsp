<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<title>CNA Record</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- Bootstrap -->
<link href="resources/css/bootstrap.css" rel="stylesheet">

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
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

	<form class="form-inline" role="form" action="saveCNARecord">
		<div class="panel panel-primary">
			<div class="panel-heading">
				<h3>Enter CNA record information:</h3>
			</div>
			<div class="panel-body">
				<table class="table">
					<tbody>
						<tr>
							<td width="20%"><h3>Food Intake</h3></td>
							<td><div class="form-group col-lg-6">
									<div class="panel panel-default">
										<div class="panel-body">
											<div class="input-group">
												<span class="input-group-addon">Breakfast</span> <input
													type="text" class="form-control" name="breakfastFood"
													placeholder="%">
											</div>
											<div class="input-group">
												<span class="input-group-addon">Lunch</span> <input
													type="text" class="form-control" name="lunchFood"
													placeholder="%">
											</div>
											<div class="input-group">
												<span class="input-group-addon">Supper</span> <input
													type="text" class="form-control" name="supperFood"
													placeholder="%">
											</div>
											<div class="input-group">
												<span class="input-group-addon">Snack</span> <input
													type="text" class="form-control" name="snackFood"
													placeholder="%">
											</div>
										</div>
									</div>
								</div></td>
						</tr>
						<tr>
							<td width="20%"><h3>Fluid Intake</h3></td>
							<td><div class="form-group col-lg-6">
									<div class="panel panel-default">
										<div class="panel-body">
											<div class="input-group">
												<span class="input-group-addon">Breakfast</span> <input
													type="text" class="form-control" name="breakfastFluid"
													placeholder="ml">
											</div>
											<div class="input-group">
												<span class="input-group-addon">Lunch</span> <input
													type="text" class="form-control" name="lunchFluid"
													placeholder="ml">
											</div>
											<div class="input-group">
												<span class="input-group-addon">Supper</span> <input
													type="text" class="form-control" name="supperFluid"
													placeholder="ml">
											</div>
											<div class="input-group">
												<span class="input-group-addon">Other</span> <input
													type="text" class="form-control" name="otherFluid"
													placeholder="ml">
											</div>
										</div>
									</div>
								</div></td>
						</tr>
						<tr>
							<td width="20%"><h3>Fluid Output</h3></td>
							<td><div class="form-group col-lg-6">
									<div class="panel panel-default">
										<div class="panel-heading">Urine</div>
										<div class="panel-body">
											<div class="input-group">
												<span class="input-group-addon">ML</span> <input type="text"
													class="form-control" name="urineOutput"> <span
													class="input-group-addon">Times voided</span> <input
													type="text" class="form-control" name="timesVoided">
											</div>
										</div>
									</div>
								</div></td>
							<td width="35%">
								<div class="form-group col-lg-6">
									<div class="panel panel-default">
										<div class="panel-heading">Emesis</div>
										<div class="panel-body">
											<div class="input-group col-lg-6">
												<div class="row">
													<div class="col-lg-3">
														<div class="input-group">
															<span class="input-group-addon"> <input
																type="radio" name="emesis" value="small">
															</span>
															<output class="form-control">Small</output>
														</div>
														<!-- /input-group -->
													</div>
												</div>
												<div class="row">
													<!-- /.col-lg-6 -->
													<div class="col-lg-3">
														<div class="input-group">
															<span class="input-group-addon"> <input
																type="radio" name="emesis" value="medium">
															</span>
															<output class="form-control">Medium</output>
														</div>
														<!-- /input-group -->
													</div>
													<!-- /.col-lg-6 -->
												</div>
												<!-- /.row -->
												<div class="row">
													<!-- /.col-lg-6 -->
													<div class="col-lg-3">
														<div class="input-group">
															<span class="input-group-addon"> <input
																type="radio" name="emesis" value="large">
															</span>
															<output class="form-control">Large</output>
														</div>
														<!-- /input-group -->
													</div>
													<!-- /.col-lg-6 -->
												</div>
											</div>
										</div>
									</div>
								</div>
							</td>
						</tr>
						<tr>
							<td width="20%"><h3>Bowel Movement</h3></td>
							<td><div class="form-group col-lg-6">
									<div class="panel panel-default">
										<div class="panel-body">
											<div class="col-lg-6 btn-group">
												<div class="row">
													<div class="col-lg-3">
														<div class="input-group">
															<span class="input-group-addon"> <input
																type="radio" name="bowelMovement" value="small">
															</span>
															<output class="form-control">Small</output>
														</div>
														<!-- /input-group -->
													</div>
												</div>
												<div class="row">
													<!-- /.col-lg-6 -->
													<div class="col-lg-3">
														<div class="input-group">
															<span class="input-group-addon"> <input
																type="radio" name="bowelMovement" value="medium">
															</span>
															<output class="form-control">Medium</output>
														</div>
														<!-- /input-group -->
													</div>
													<!-- /.col-lg-6 -->
												</div>
												<!-- /.row -->
												<div class="row">
													<!-- /.col-lg-6 -->
													<div class="col-lg-3">
														<div class="input-group">
															<span class="input-group-addon"> <input
																type="radio" name="bowelMovement" value="large">
															</span>
															<output class="form-control">Large</output>
														</div>
														<!-- /input-group -->
													</div>
													<!-- /.col-lg-6 -->
												</div>
											</div>
										</div>
									</div>
								</div></td>
						</tr>
						<tr>
							<td width="20%"><h3>Activities of Daily Living</h3></td>
							<td>
								<div class="panel panel-default">
									<div class="panel-body">
										<table class="table">
											<tbody>
												<tr>
													<td width="20%"><h3>Bathing</h3></td>
													<td><div class="col-lg-6 btn-group">
															<div class="row">
																<div class="col-lg-3">
																	<div class="input-group">
																		<span class="input-group-addon"> <input
																			type="radio" name="bathing" value="Independent">
																		</span>
																		<output class="form-control">Independent</output>
																	</div>
																	<!-- /input-group -->
																</div>
															</div>
															<div class="row">
																<!-- /.col-lg-6 -->
																<div class="col-lg-3">
																	<div class="input-group">
																		<span class="input-group-addon"> <input
																			type="radio" name="bathing"
																			value="Partial Assistance">
																		</span>
																		<output class="form-control">Partial
																			Assistance</output>
																	</div>
																	<!-- /input-group -->
																</div>
																<!-- /.col-lg-6 -->
															</div>
															<!-- /.row -->
															<div class="row">
																<!-- /.col-lg-6 -->
																<div class="col-lg-3">
																	<div class="input-group">
																		<span class="input-group-addon"> <input
																			type="radio" name="bathing" value="Full Assistance">
																		</span>
																		<output class="form-control">Full Assistance</output>
																	</div>
																	<!-- /input-group -->
																</div>
																<!-- /.col-lg-6 -->
															</div>
														</div></td>
												</tr>
												<tr>
													<td width="20%"><h3>Dressing</h3></td>
													<td><div class="col-lg-6 btn-group">
															<div class="row">
																<div class="col-lg-3">
																	<div class="input-group">
																		<span class="input-group-addon"> <input
																			type="radio" name="dressing" value="Independent">
																		</span>
																		<output class="form-control">Independent</output>
																	</div>
																	<!-- /input-group -->
																</div>
															</div>
															<div class="row">
																<!-- /.col-lg-6 -->
																<div class="col-lg-3">
																	<div class="input-group">
																		<span class="input-group-addon"> <input
																			type="radio" name="dressing"
																			value="Partial Assistance">
																		</span>
																		<output class="form-control">Partial
																			Assistance</output>
																	</div>
																	<!-- /input-group -->
																</div>
																<!-- /.col-lg-6 -->
															</div>
															<!-- /.row -->
															<div class="row">
																<!-- /.col-lg-6 -->
																<div class="col-lg-3">
																	<div class="input-group">
																		<span class="input-group-addon"> <input
																			type="radio" name="dressing" value="Full Assistance">
																		</span>
																		<output class="form-control">Full Assistance</output>
																	</div>
																	<!-- /input-group -->
																</div>
																<!-- /.col-lg-6 -->
															</div>
														</div></td>
												</tr>
												<tr>
													<td width="20%"><h3>Oral Care</h3></td>
													<td><div class="col-lg-6 btn-group">
															<div class="row">
																<div class="col-lg-3">
																	<div class="input-group">
																		<span class="input-group-addon"> <input
																			type="radio" name="oralCare" value="Independent">
																		</span>
																		<output class="form-control">Independent</output>
																	</div>
																	<!-- /input-group -->
																</div>
															</div>
															<div class="row">
																<!-- /.col-lg-6 -->
																<div class="col-lg-3">
																	<div class="input-group">
																		<span class="input-group-addon"> <input
																			type="radio" name="oralCare"
																			value="Partial Assistance">
																		</span>
																		<output class="form-control">Partial
																			Assistance</output>
																	</div>
																	<!-- /input-group -->
																</div>
																<!-- /.col-lg-6 -->
															</div>
															<!-- /.row -->
															<div class="row">
																<!-- /.col-lg-6 -->
																<div class="col-lg-3">
																	<div class="input-group">
																		<span class="input-group-addon"> <input
																			type="radio" name="oralCare" value="Full Assistance">
																		</span>
																		<output class="form-control">Full Assistance</output>
																	</div>
																	<!-- /input-group -->
																</div>
																<!-- /.col-lg-6 -->
															</div>
														</div></td>
												</tr>
												<tr>
													<td width="20%"><h3>Eating</h3></td>
													<td><div class="col-lg-6 btn-group">
															<div class="row">
																<div class="col-lg-3">
																	<div class="input-group">
																		<span class="input-group-addon"> <input
																			type="radio" name="eating" value="Independent">
																		</span>
																		<output class="form-control">Independent</output>
																	</div>
																	<!-- /input-group -->
																</div>
															</div>
															<div class="row">
																<!-- /.col-lg-6 -->
																<div class="col-lg-3">
																	<div class="input-group">
																		<span class="input-group-addon"> <input
																			type="radio" name="eating" value="Partial Assistance">
																		</span>
																		<output class="form-control">Partial
																			Assistance</output>
																	</div>
																	<!-- /input-group -->
																</div>
																<!-- /.col-lg-6 -->
															</div>
															<!-- /.row -->
															<div class="row">
																<!-- /.col-lg-6 -->
																<div class="col-lg-3">
																	<div class="input-group">
																		<span class="input-group-addon"> <input
																			type="radio" name="eating" value="Full Assistance">
																		</span>
																		<output class="form-control">Full Assistance</output>
																	</div>
																	<!-- /input-group -->
																</div>
																<!-- /.col-lg-6 -->
															</div>
														</div></td>
												</tr>
												<tr>
													<td width="20%"><h3>Transferring</h3></td>
													<td><div class="col-lg-6 btn-group">
															<div class="row">
																<div class="col-lg-3">
																	<div class="input-group">
																		<span class="input-group-addon"> <input
																			type="radio" name="transferring" value="Independent">
																		</span>
																		<output class="form-control">Independent</output>
																	</div>
																	<!-- /input-group -->
																</div>
															</div>
															<div class="row">
																<!-- /.col-lg-6 -->
																<div class="col-lg-3">
																	<div class="input-group">
																		<span class="input-group-addon"> <input
																			type="radio" name="transferring"
																			value="Assistance of 1-2">
																		</span>
																		<output class="form-control">Assistance of
																			1-2</output>
																	</div>
																	<!-- /input-group -->
																</div>
																<!-- /.col-lg-6 -->
															</div>
															<!-- /.row -->
															<div class="row">
																<!-- /.col-lg-6 -->
																<div class="col-lg-3">
																	<div class="input-group">
																		<span class="input-group-addon"> <input
																			type="radio" name="transferring"
																			value="Mechanical lift">
																		</span>
																		<output class="form-control">Mechanical lift</output>
																	</div>
																	<!-- /input-group -->
																</div>
																<!-- /.col-lg-6 -->
															</div>
														</div></td>
												</tr>
												<tr>
													<td width="20%">
															<h3>Ambulation</h3>
															<input type="text" class="form-control"
																name="ambulationDistance"> <span
																class="input-group-addon">Feet</span>
													</td>
													<td><div class="col-lg-6 btn-group">
															<div class="row">
																<div class="col-lg-3">
																	<div class="input-group">
																		<span class="input-group-addon"> <input
																			type="radio" name="ambulation" value="Independent">
																		</span>
																		<output class="form-control">Independent</output>
																	</div>
																	<!-- /input-group -->
																</div>
															</div>
															<div class="row">
																<!-- /.col-lg-6 -->
																<div class="col-lg-3">
																	<div class="input-group">
																		<span class="input-group-addon"> <input
																			type="radio" name="ambulation"
																			value="Assistance of 1">
																		</span>
																		<output class="form-control">Assistance of 1</output>
																	</div>
																	<!-- /input-group -->
																</div>
																<!-- /.col-lg-6 -->
															</div>
															<!-- /.row -->
															<div class="row">
																<!-- /.col-lg-6 -->
																<div class="col-lg-3">
																	<div class="input-group">
																		<span class="input-group-addon"> <input
																			type="radio" name="ambulation"
																			value="Assistance of
																			2">
																		</span>
																		<output class="form-control">Assistance of 2</output>
																	</div>
																	<!-- /input-group -->
																</div>
																<!-- /.col-lg-6 -->
															</div>
														</div></td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="centered-pills">
			<ul class="nav nav-pills">
				<li><a href="<c:url value="/home"/>">Back</a></li>
				<li><button type="submit" class="btn btn-primary form-control">Submit</button></li>
			</ul>
		</div>
	</form>
</body>
</html>