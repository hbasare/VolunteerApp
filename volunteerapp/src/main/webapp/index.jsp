<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Home</title>
    <!-- Bootstrap -->
    <link type="text/css" href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
  	<spring:url value="/clientLogin" var="client" htmlEscape="true"/>
  	<spring:url value="/volunteerLogin" var="volunteer" htmlEscape="true"/>
  	<spring:url value="/displayClientRegistration" var="clientReg" htmlEscape="true"/>
  	<spring:url value="/volunteerRegistration" var="volunteerReg" htmlEscape="true"/>
  	<div class="container-fluid">
  		<div class="row">
	  		<div class="col-sm-1"></div>
	  		<div class="col-sm-10">
	  			<h1>Welcome to the volunteer skill search database. </h1><br/><br/><br/><br/><br/><br/><br/><br/><br/>
	  		</div>
	  		<div class="col-sm-1"></div>
  		</div>
	  	<div class="row">
	  		<div class="col-sm-1"></div>
	  		<div class="col-sm-4">
	    		<div class="col-sm-1"><a href="${volunteer}" class="btn btn-info" role="button">Volunteer Login</a></div>
	    	</div>
	    	<div class="col-sm-1">
		    	<div class="col-sm-6"><a href="${client}" class="btn btn-info" role="button">Client Login</a></div>
	    	</div>
	    	<div class="col-sm-4"></div>
	    	<div class="col-sm-1"></div>
	    </div>
	    <br/><br/><br/><br/>
	    <div class="row">
	  		<div class="col-sm-1"></div>
	  		<div class="col-sm-4">
	    		<div class="col-sm-1"><a href="${volunteerReg}" class="btn btn-info" role="button">Volunteer Registration</a></div>
	    	</div>
	    	<div class="col-sm-1">
		    	<div class="col-sm-6"><a href="${clientReg}" class="btn btn-info" role="button">Client Registration</a></div>
	    	</div>
	    	<div class="col-sm-4"></div>
	    	<div class="col-sm-1"></div>
	    </div>
  	</div>
    
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
  </body>
</html>
