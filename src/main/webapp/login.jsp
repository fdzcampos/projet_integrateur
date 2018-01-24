<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">


<html  lang="en" xmlns="http://www.w3.org/1999/xhtml">
	
	<head>
		<%@ include file = "head.jsp" %>
		<title>Login </title>
	</head>
	
	<body background="bg1.png" >
	
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
                    <a class="navbar-brand" href="login.jsp">Log in</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-left">
                        <li>
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="fa fa-dashboard"></i>
								<p class="hidden-lg hidden-md">Dashboard</p>
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
		
		
		
		        
		        <div class="content">
		            <div class="container-fluid">
		                <div class="card">
		                    <div class="header">
		                        <h4 class="title"> Enter your login info</h4>
		                        
		                    </div>
		                    <div class="content" align="center">
		                        <div class="row">
		                            <div class="col-md-(6)">
		                                
		                                <style>
		                                	input[type=email] { color:#000;}
		                                </style>
		                             <form action="servlet_login" >
		                                  <div class="form-group">
		                                    <label for="email">Email address:</label>
		                                    <input type="email" name= "email" class="form-control" id="email"/>
		                                  </div>
		                                  <div class="form-group">
		                                    <label for="pwd">Password:</label>
		                                    <input type="password" name = "pwd" class="form-control" id="pwd"/>
		                                  </div>
		                                  <div class="checkbox">
		                                    <label><input type="checkbox"/> Remember me</label>
		                                  </div>
		                                  <button type="submit" class="btn btn-default">Submit</button>
		                                  <button type="button" class="btn btn-default" onclick="location.href='register.jsp';">Not a member yet?</button>
		                            </form>
		                
		                        </div>
		                        <br/>
		                        <br/>
		
		                    </div>
		                </div>
		            </div>
		        </div>
		        
		        
		        
		        </div>
		
		
		        <footer class="footer">
		            	<%@ include file = "footer.jsp" %>
		        </footer>
		
		    </div>
		</div>
	</body>
	
	<!--   Core JS Files   -->
    <script src="jquery.3.2.1.min.js" type="text/javascript"></script>
	<script src="bootstrap.min.js" type="text/javascript"></script>

	<!--  Charts Plugin -->
	<script src="chartist.min.js"></script>

    <!--  Notifications Plugin    -->
    <script src="bootstrap-notify.js"></script>

    <!--  Google Maps Plugin    -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>

    <!-- Light Bootstrap Table Core javascript and methods for Demo purpose -->
	<script src="light-bootstrap-dashboard.js?v=1.4.0"></script>

	<!-- Light Bootstrap Table DEMO methods, don't include it in your project! -->
	<script src="demo.js"></script>
	
	<script type="text/javascript">
    	$(document).ready(function(){
    		
        	demo.initChartist();
        	color = Math.floor((Math.random() * 4) + 1);
        	
        	$.notify({
            	icon: "pe-7s-gift",
            	message: "Welcome! Enter your user data or register with us if this is your first visit!"

            },{
                type: type[color],
                timer: 4000,
                placement: {
                    from: 'top',
                    align: 'right'
                }
            });
    	});
    	
	</script>

</html>
