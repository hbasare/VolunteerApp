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
    <title>Volunteer Login</title>
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
  	<spring:url value="/displayVolunteerRegistration" var="volunteerReg" htmlEscape="true"/>
  	<div class="container-fluid">
  		<div class="row">
	  		<div class="col-sm-4"></div>
	  		<div class="col-sm-4">
	  			<h1>Volunteer Login</h1><br/><br/><br/><br/><br/><br/><br/><br/><br/>
	  		</div>
	  		<div class="col-sm-4"></div>
  		</div>
  		
	  	<form:form class="form-horizontal" role="form" method="post" action="volunteerLogin" modelAttribute="volunteerLogin">
		  	<div class="row">
		  		<div class="col-sm-3"></div>
		  		<div class="col-sm-1">
		  			<div class="form-group">
		    			<label class="control-label col-sm-2" for="email">Email:</label>
		    		</div>
		    	</div>
		    	<div class="col-sm-6">
		    		<div class="col-sm-10">
			    		<form:input type="email" path="username" class="form-control" id="email" placeholder="Enter email"/>
			    	</div>
		    	</div>
		    	<div class="col-sm-2"></div>
		    </div>
		    <div class="row">
		    	<div class="col-sm-3"></div>
		    	<div class="col-sm-1">
		    		<div class="form-group">
		    			<label class="control-label col-sm-2" for="password">Password:</label>
		    		</div>
		    	</div>
		    	<div class="col-sm-6">
		    		<div class="col-sm-10">
			    		<form:input type="password" path="password" class="form-control" id="password" placeholder="Enter password"/> 
			    	</div>
		    	</div>
		    	<div class="col-sm-2"></div>
		    </div>		    
		    <div class="row">
		    	<div class="col-sm-3"></div>
		    	<div class="col-sm-1"></div>
		    	<div class="col-sm-4">
		    		<div class="form-group">
			    		<div class="col-sm-offset-1">
			      			<div class="checkbox">
			        			<label><input type="checkbox">Remember me</label>
			      			</div>
			    		</div>
		    		</div>
		    	</div>
		    	<div class="col-sm-2">
		    		<div class="form-group">
			    		<div class="col-sm-offset-1">
			      			<div class="checkbox">
			        			<a href="${volunteerReg}" class="btn btn-info" role="button">Register</a>
			      			</div>
			    		</div>
		    		</div>
		    	</div>
		    	<div class="col-sm-2"></div>
		    </div>
		    <div class="row">	
		    	<div class="col-sm-4"></div>
			  	<div class="col-sm-4">
			  		<div class="form-group">
			    		<div class="col-sm-offset-2 col-sm-10">
			      			<button type="submit" class="btn btn-default">Submit</button>
			    		</div>
			  		</div>
			  	</div>
			  	<div class="col-sm-4"></div>
		  	</div>
	    </form:form>
  	</div>
    
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
  </body>
</html>
