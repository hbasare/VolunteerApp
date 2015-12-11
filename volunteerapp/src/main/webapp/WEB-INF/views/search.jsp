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
    <title>Find a Volunteer</title>
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
  	<spring:url value="/displayEditClientProfile" var="editClientProfile" htmlEscape="true"/>
  	<div class="container-fluid">
  		<div class="row">
	  		<div class="col-sm-1"><a href="${editClientProfile}" class="btn btn-info" role="button">Edit Profile</a></div>
	  		<div class="col-sm-10"></div>	  		
	  		<div class="col-sm-1"><a href="${clientLogout}" class="btn btn-info" role="button">Logout</a></div>
  		</div>
  		<div class="row">
	  		<div class="col-sm-4"></div>
	  		<div class="col-sm-4">
	  			<h1>Find a Volunteer</h1><br/><br/><br/>
	  		</div>
	  		<div class="col-sm-4"></div>
  		</div>
  		
	  	<form:form class="form-horizontal" role="form" method="post" action="search" modelAttribute="search">
	  		<div class="row">
		  		<div class="col-sm-2"></div>
		  		<div class="col-sm-2">
		  			<div class="form-group">
		    			<label class="control-label col-sm-12" for="city">City</label>
		    		</div>
		    	</div>
		    	<div class="col-sm-2">
		    		<div class="col-sm-10">
			    		<form:input type="text" path="city" class="form-control" id="city" />
			    	</div>
		    	</div>
		    	<div class="col-sm-2">
		  			<div class="form-group">
		    			<label class="control-label col-sm-12" for="province">Province</label>
		    		</div>
		    	</div>
		    	<div class="col-sm-2">
		    		<div class="col-sm-10">
			    		<form:input type="text" path="province" class="form-control" id="province" />
			    	</div>
		    	</div>
		    	<div class="col-sm-2"></div>
		    </div>
		    <div class="row">
		  		<div class="col-sm-2"></div>
		  		<div class="col-sm-2">
		  			<div class="form-group">
		    			<label class="control-label col-sm-12" for="lang">Language</label>
		    		</div>
		    	</div>
		    	<div class="col-sm-2">
		    		<div class="col-sm-10">
			    		<form:input type="text" path="lang" class="form-control" id="lang" />
			    	</div>
		    	</div>
		    	<div class="col-sm-2">
		  			<div class="form-group">
		    			<label class="control-label col-sm-12" for="gender">Gender</label>
		    		</div>
		    	</div>
		    	<div class="col-sm-2">
		    		<div class="col-sm-10">
			    		<form:input type="text" path="gender" class="form-control" id="gender" />
			    	</div>
		    	</div>
		    	<div class="col-sm-2"></div>
		    </div>
		    <div class="row">
		  		<div class="col-sm-2"></div>
		  		<div class="col-sm-2">
		  			<div class="form-group">
		    			<label class="control-label col-sm-12" for="skillSet">Skill Set</label>
		    		</div>
		    	</div>
		    	<div class="col-sm-6">
		    		<div class="col-sm-10">
			    		<form:input type="text" path="skillSet" class="form-control" id="skillSet" />
			    	</div>
		    	</div>
		    	<div class="col-sm-2"></div>
		    </div>
		    
		  	<div class="row">
		  		<div class="col-sm-6"></div>
		    	<div class="col-sm-2">
		    		<div class="form-group">
			    		<div class="col-sm-2">
			      			<button type="submit" class="btn btn-default">Search</button>
			    		</div>
			  		</div>
		    	</div>
		    	<div class="col-sm-4"></div>
		    </div>
		</form:form>
	    <br/><br/>
	    <c:if test="${not empty searchResults}">
	    <div>
	    	<table class="table table-striped">
	    		<thead>
	    			<tr>
	    				<th>First Name</th>
	    				<th>Last Name</th>
	    				<th>Email</th>
	    				<th>Telephone</th>
	    				<th>City</th>
	    			</tr>
	    		</thead>
	    		<tbody>
	    			
	    				<c:forEach var="volunteer" items="${searchResults}">
	    					<tr>
			    				<td>${volunteer.firstName}</td>
			    				<td>${volunteer.lastName}</td>
			    				<td>${volunteer.email}</td>
			    				<td>${volunteer.phoneNumber}</td>
			    				<td>${volunteer.city}</td>
	    					</tr>
	    				</c:forEach>
	    			
	    			<!-- 
	    			<tr>
	    				<td>Doga</td>
	    				<td>Tav</td>
	    				<td>me@somewhere.ca</td>
	    				<td>506-000-7777</td>
	    				<td>Fredericton</td>
	    			</tr>
	    			<tr>
	    				<td>Nicole</td>
	    				<td>McGee</td>
	    				<td>moi@somewhere.ca</td>
	    				<td>506-222-8888</td>
	    				<td>Saint John</td>
	    			</tr>	
	    			 -->	    			
	    		</tbody>
	    	</table>
	    </div>
	   </c:if> 
  	</div>
    
    




    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
  </body>
</html>
