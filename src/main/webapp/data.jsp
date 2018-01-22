<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<%@ include file = "head.jsp" %>
		<title> Data </title>
	</head>

	<body background="bg1.png">
		
		
		<% 
			if (session.getAttribute("user") == null) {
			    response.sendRedirect("index.jsp");
			}
		%>
		
		<div class="wrapper">
	    	<%@ include file = "sidebar.jsp" %>
	
		    <div class="main-panel" >
		        <nav class="navbar navbar-default navbar-fixed">
		            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navigation-example-2">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Index</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-left">
                        <li>
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="fa fa-dashboard"></i>
								<p class="hidden-lg hidden-md">Index</p>
                            </a>
                        </li>
                        <li class="dropdown">
                              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <i class="fa fa-globe"></i>
                                    <b class="caret hidden-lg hidden-md"></b>
									<p class="hidden-lg hidden-md">
										5 Notifications
										<b class="caret"></b>
									</p>
                              </a>
                              <ul class="dropdown-menu">
                                <li><a href="#">Notification 1</a></li>
                                <li><a href="#">Notification 2</a></li>
                                <li><a href="#">Notification 3</a></li>
                                <li><a href="#">Notification 4</a></li>
                                <li><a href="#">Another notification</a></li>
                              </ul>
                        </li>
                        <li>
                           <a href="">
                                <i class="fa fa-search"></i>
								<p class="hidden-lg hidden-md">Search</p>
                            </a>
                        </li>
                    </ul>

                    <ul class="nav navbar-nav navbar-right">
                        <li>
                           <a href="">
                               <p>Account</p>
                            </a>
                        </li>
                        <li class="dropdown">
                              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <p>
										Dropdown
										<b class="caret"></b>
									</p>

                              </a>
                              <ul class="dropdown-menu">
                                <li><a href="#">Action</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something</a></li>
                                <li><a href="#">Another action</a></li>
                                <li><a href="#">Something</a></li>
                                <li class="divider"></li>
                                <li><a href="#">Separated link</a></li>
                              </ul>
                        </li>
                        <li>
                            <a href="logout.jsp">
                                <p>Log out</p>
                            </a>
                        </li>
						<li class="separator hidden-lg"></li>
                    </ul>
                </div>
            </div>
	        	</nav>
	
	<!--	Try to add a disconnect button         -->
	            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	    		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	    		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	        
	            <a href="#" class="btn btn-info btn-lg">
                    <style type="text/css">
        	            .topcorner{
	        	            position:absolute;
	                        top:0;
	                        right:0;
	                    }
					</style>
	                    
	                <span class="glyphicon glyphicon-log-out">Log out</span> 
	            </a>
	        
	            <div class="content">
	            	<div class="container-fluid">
	                	<div class="card">
	                    	<div class="header">
	                        	<h4 class="title"> Visualize the data.</h4>
	                        </div>
	                    	<div class="content" align="center">
	                        	<div class="row">
	                            	<div class="col-md-(6)">
		                                <div class="header">
		                                    <h5 class="title"> Already a member? Welcome back!</h5>
		                                    <br/>
		                                </div>
			                                
		                                <button type="button" class="btn btn-info" onclick="location.href='login.jsp';" >Log in</button>
			                                
		                                <div class="header">
		                                    <h5 class="title"> Not a member? Become one.</h5>
		                                    <br/>
		                                </div>
		                                <button type="button" class="btn btn-info" onclick="location.href='register.jsp';" >Register</button>
		                       		</div>
	                        		<br/>
	                        		<br/>
	                    		</div>
	                		</div>
	            		</div>
	        		</div>
	    		</div>
	        </div>
	    
			<footer class="footer">
	            <%@ include file = "footer.jsp" %>
	        </footer>
		
		</div>
	    
	</body>
	
</html>