<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">

    <title>Sign in</title>

    <!-- Bootstrap core CSS -->
    <link href="resources/css/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="resources/css/signin.css" rel="stylesheet">

  </head>

  <body>

    <div class="container">

      <form class="form-signin" action="<c:url value="/j_spring_security_check"/>" method="post">
        <h2 class="form-signin-heading">Please sign in</h2>
        <input type="text" class="form-control" placeholder="Username" required autofocus name="j_username">
        <input type="password" class="form-control" placeholder="Password" required name="j_password">
        <c:if test="${error}">
      		<div class="alert alert-danger">Invalid username or password.</div>
      	</c:if>  
        
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

    </div> <!-- /container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
  </body>
</html>
