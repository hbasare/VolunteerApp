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
    <title>Client Profile</title>
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
  	<spring:url value="/clientLogout" var="clientLogout" htmlEscape="true"/>
  	<spring:url value="/deleteClientProfile" var="deleteClientProfile" htmlEscape="true"/>
  	<spring:url value="/displaySearch" var="search" htmlEscape="true"/>
  	<div class="container-fluid">
  		<div class="row">
	  		<div class="col-sm-1"><a href="${search}" class="btn btn-info" role="button">Search for Volunteers</a></div>
	  		<div class="col-sm-4"></div>	
	  		<div class="col-sm-2"><a href="${deleteClientProfile}" class="btn btn-info" role="button">Delete Profile</a></div>	  	
	  		<div class="col-sm-4"></div>	  	
	  		<div class="col-sm-1"><a href="${clientLogout}" class="btn btn-info" role="button">Logout</a></div>
  		</div>
  		<div class="row">
	  		<div class="col-sm-4"></div>
	  		<div class="col-sm-4">
	  			<h1>Client Profile</h1><br/><br/><br/>
	  		</div>
	  		<div class="col-sm-4"></div>
  		</div>
  		
	  	<form:form class="form-horizontal" role="form" method="post" action="editClientProfile" modelAttribute="client">
		  	<div class="row">
		  		<div class="col-sm-2"></div>
		  		<div class="col-sm-2">
		  			<div class="form-group">
		    			<label class="control-label col-sm-12" for="firstname">First Name</label>
		    		</div>
		    	</div>
		    	<div class="col-sm-6">
		    		<div class="col-sm-10">
			    		<form:input type="text" path="firstName" class="form-control" id="firstname" placeholder="Enter first name"/>
			    	</div>
		    	</div>
		    	<div class="col-sm-2"></div>
		    </div>
		    <div class="row">
		    	<div class="col-sm-2"></div>
		    	<div class="col-sm-2">
		    		<div class="form-group">
		    			<label class="control-label col-sm-12" for="lastname">Last Name</label>
		    		</div>
		    	</div>
		    	<div class="col-sm-6">
		    		<div class="col-sm-10">
			    		<form:input type="text" path="lastName" class="form-control" id="lastname" placeholder="Enter last name"/> 
			    	</div>
		    	</div>
		    	<div class="col-sm-2"></div>
		    </div>
		    <div class="row">
		    	<div class="col-sm-2"></div>
		    	<div class="col-sm-2">
		    		<div class="form-group">
		    			<label class="control-label col-sm-12" for="org">Organization</label>
		    		</div>
		    	</div>
		    	<div class="col-sm-6">
		    		<div class="col-sm-10">
			    		<form:input type="text" path="organisation" class="form-control" id="org" placeholder="Enter the name of your Organisation"/> 
			    	</div>
		    	</div>
		    	<div class="col-sm-2"></div>
		    </div>
		    <div class="row">
		  		<div class="col-sm-2"></div>
		  		<div class="col-sm-2">
		  			<div class="form-group">
		    			<label class="control-label col-sm-12" for="email">Email</label>
		    		</div>
		    	</div>
		    	<div class="col-sm-6">
		    		<div class="col-sm-10">
			    		<form:input type="email" path="email" class="form-control" id="email" placeholder="Enter email"/>
			    	</div>
		    	</div>
		    	<div class="col-sm-2"></div>
		    </div>
		    <div class="row">
		  		<div class="col-sm-2"></div>
		  		<div class="col-sm-2">
		  			<div class="form-group">
		    			<label class="control-label col-sm-12" for="password">Password</label>
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
		  		<div class="col-sm-2"></div>
		  		<div class="col-sm-2">
		  			<div class="form-group">
		    			<label class="control-label col-sm-12" for="phone">Phone Number</label>
		    		</div>
		    	</div>
		    	<div class="col-sm-6">
		    		<div class="col-sm-10">
			    		<form:input type="text" path="phoneNumber" class="form-control bfh-phone" data-format="(ddd) ddd-dddd" id="phone" placeholder="Enter phone number"/>
			    	</div>
		    	</div>
		    	<div class="col-sm-2"></div>
		    </div>
		    <br /><br />
		    <div class="row">	
		    	<div class="col-sm-2"></div>
		    	<div class="col-sm-2"></div>
			  	<div class="col-sm-6">
			  		<div class="form-group">
			    		<div class="col-sm-offset-2 col-sm-10">
			      			<button type="submit" class="btn btn-default">Save</button>
			    		</div>
			  		</div>
			  	</div>
			  	<div class="col-sm-2"></div>
		  	</div>
	    </form:form>
  	</div>
    
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="scripts/bootstrap.min.js"></script>
  </body>
</html>
