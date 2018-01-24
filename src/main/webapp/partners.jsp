<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="fr.insa.soa.SOA_Project.Partner" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<%@ include file="head.jsp" %>
	<title>Light Bootstrap Dashboard by Creative Tim</title>

</head>
<body background="bg1.png">

<div class="wrapper">
    <%@ include file="sidebar.jsp" %>
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
                    <a class="navbar-brand" href="#">Our Partners</a>
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
                            <a href="#">
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
                        <h4 class="title"> A list of our partners.</h4>   
                    </div>
                    
                    <div class="content" align="center">
                        <div class="row">
                            <div class="col-md-(6)">
                                <ul id="partnerList"></ul>
	                       			<c:forEach items="${partners}" var="p">
	                       				<li>
										  	<div class="header">
									  			<h5 class="title">${p.name}</h5>
									  			<p>Email: ${p.email}</p>
									  			<p>Description: ${p.description}</p>
									        </div>
								        </li>
									</c:forEach>
									

									
									
 <!--  
 
 									<script>
										var gpsPoints = {"route": [{"lat" : 0, "lon" : 0}, {"lat" : 0, "lon" : 0}]};
										var json = JSON.parse(gpsPoints);
										
									</script>
									
                                <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
                                <script>
                                	$(document).ready(function(){
                                		
                                		
                                		
                                		gpsPoints
                                		$.get( "webapi/partners/all", function(data) {	
                                			for (var i = 0; i < data.length; i++) {
                                				var partnerElement = $("<li></li>");
                                				var partnerDiv = $('<div class="header"></div>');
                                				var partnerName = $('<h5 class="title"></h5>').text(data[i].name);
                                				var partnerInfo = $('<li></li>');
                                				var partnerEmail = $("<p></p>").text("Email: " + data[i].email);
                                				var partnerDescription = $("<p></p>").text("Description: " + data[i].description);
												partnerInfo.append(partnerName);
												partnerInfo.append(partnerEmail);
												partnerInfo.append(partnerDescription);
												partnerInfo.append($("<br><hr>"));
												partnerDiv.append(partnerInfo);
												partnerElement.append(partnerDiv);
                                				$("#partnerList").append(partnerElement);
                                			}
                               			});
                                	});
                                </script>
-->                                
                                <!--<button type="button" class="btn btn-info" onclick="location.href='index.jsp';" >Back to index</button>-->

                                
                                
                                

                        </div>
                        <br>
                        <br>
 
                    </div>
                </div>
            </div>
        </div>
    </div>

        </div>
    



        <footer class="footer">
            <div class="container-fluid">
                <nav class="pull-left">
                    <ul>
                        <li>
                            <a href="#">
                                Home
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                Company
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                Portfolio
                            </a>
                        </li>
                        <li>
                            <a href="#">
                               Blog
                            </a>
                        </li>
                    </ul>
                </nav>
                <p class="copyright pull-right">
                    &copy; <script>document.write(new Date().getFullYear())</script> <a href="http://www.creative-tim.com">Creative Tim</a>, made with love for a better web
                </p>
            </div>
        </footer>

    </div>


</body>


</html>