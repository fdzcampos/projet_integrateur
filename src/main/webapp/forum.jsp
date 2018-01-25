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
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">List of topics</h4>
                                <p class="category">All topics posted to the forum are displayed here.</p>
                            </div>
                            
                            <br>
                             <button type="button" class="btn btn-info" onclick="location.href='topic_template.html';" >Add a topic</button>
                                
                            
                            
                            <div class="content table-responsive table-full-width">
                                <table class="table">
                                    <thead>
                                    	<th>Title</th>
                                    	<th>Posts</th>
                                    	<th>Author</th>
                                    	<th>Creation</th>
                                    	<th>Last modified</th>
                                    </thead>
                                    <tbody>
	                                    <c:forEach items="${topics}" var="t">
		                       				<tr>
										  		<td><a href ="topic?idTopic=${t.id}">${t.title}</a></td>
										  		<td>${t.nbMessages}</td>
	                                        	<td>${t.user.username}</td>
	                                        	<td>${t.date}</td>
	                                        	<td>${t.date}</td>
									        </tr>
										</c:forEach>
                                    </tbody>
                                </table>

                            </div>
                            
                            <div align="center">
                            	<c:if test="${morePages}">
                            		<button type="button" class="btn btn-info" onclick="location.href='topic_forum.html';" >Previous</button>
                            		<button type="button" class="btn btn-info" onclick="location.href='topic_forum.html';" >Next</button>
                            	</c:if>
                            </div>
                            
                            <div class="card">
	                            <div class="header">
	                                <h4 class="title">Add a topic</h4>
	                            </div>
	                            <div class="content">
	                                <form action="forum" method="post">
	                                    <div class="row">
	                                        <div class="col-md-5">
	                                            <div class="form-group">
	                                                <label>Topic title </label>
	                                                <input type="text" class="form-control" placeholder="Title" name="title" value="">
	                                            </div>
	                                        </div>
	
	                                    </div>
	
	
	                                    <div class="row">
	                                        <div class="col-md-12">
	                                            <div class="form-group">
	                                                <label>First post content</label>
	                                                <textarea rows="5" class="form-control" placeholder="Here can be your description" name="message" value=""></textarea>
	                                            </div>
	                                        </div>
	                                    </div>
	
	                                    <button type="submit" class="btn btn-info btn-fill pull-right">Create topic</button>
	                                    <div class="clearfix"></div>
	                                </form>
	                            </div>
	                        </div>
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