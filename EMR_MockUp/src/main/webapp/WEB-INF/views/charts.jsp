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
	
	<script type="text/javascript" src="//www.google.com/jsapi"></script>
    <script type="text/javascript">
      google.load('visualization', '1', {packages: ['corechart']});
    </script>
    <script type="text/javascript">
      function drawVisualization() {
        // Create and populate the data table.
        var data = google.visualization.arrayToDataTable([
          ['Year', 'Austria', 'Belgium', 'Czech Republic', 'Finland', 'France', 'Germany'],
          ['2003',  1336060,   3817614,       974066,       1104797,   6651824,  15727003],
          ['2004',  1538156,   3968305,       928875,       1151983,   5940129,  17356071],
          ['2005',  1576579,   4063225,       1063414,      1156441,   5714009,  16716049],
          ['2006',  1600652,   4604684,       940478,       1167979,   6190532,  18542843],
          ['2007',  1968113,   4013653,       1037079,      1207029,   6420270,  19564053],
          ['2008',  1901067,   6792087,       1037327,      1284795,   6240921,  19830493]
        ]);
      
        // Create and draw the visualization.
        new google.visualization.ColumnChart(document.getElementById('visualization')).
            draw(data,
                 {title:"Yearly Coffee Consumption by Country",
                  width:600, height:400,
                  hAxis: {title: "Year"}}
            );
      }
      

      google.setOnLoadCallback(drawVisualization);
    </script>
    <body style="font-family: Arial;border: 0 none;">
    <div id="visualization" style="width: 600px; height: 400px;"></div>
  </body>
  <div class="centered-pills">
	<ul class="nav nav-pills">
		<li><a href="<c:url value="/home"/>">Close</a></li>
	</ul>
	</div>
</body>
</html>