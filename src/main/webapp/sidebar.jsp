<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<%@ include file = "head.jsp" %>
	</head>

	<body>
	
		<div class="sidebar" data-color="purple" data-image="sidebar-5.jpg">
	    	<div class="sidebar-wrapper">
	            <div class="logo">
	                <a href="http://localhost:8080/SOA_Project/index.jsp" class="simple-text">
	                    Projet IL/SOA
	                </a>
	            </div>
            
	            <ul class="nav">
	                <li class="active"/>
	            
	               <li>
                   		<p>
	                        <a href="login.jsp">
	                           <i class="pe-7s-bell"></i>
	                           Log In
	                        </a>
                        </p>
                    </li>
	            
	               <li>
                   		<p>
	                        <a href="register.jsp">
	                            <i class="pe-7s-bell"></i>
	                            Register
	                        </a>
                        </p>
                    </li>
                    
	                <li>
                    	<p>
	                        <a href="dashboard.jsp">
	                            <i class="pe-7s-graph"></i>
	                            Dashboard
	                        </a>
                        </p>
                    </li>
                    <li>
                    	<p>
	                        <a href="user.jsp">
	                            <i class="pe-7s-bell"></i>
	                            User
	                        </a>
                        </p>
                    </li>
	               <li>
                    	<p>
	                        <a href="maps.jsp">
	                            <i class="pe-7s-map-marker"></i>
	                            Maps
	                        </a>
                        </p>
                    </li>
	                <li>
                    	<p>
	                       <a href="notifications.jsp">
	                           <i class="pe-7s-bell"></i>
	                           Notifications
	                       </a>
                        </p>
                    </li>
					
	            </ul>
    		</div>
    	</div>

	</body>
</html>