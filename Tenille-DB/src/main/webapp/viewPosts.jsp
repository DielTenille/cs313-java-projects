<%-- 
    Document   : viewPosts
    Created on : Mar 4, 2017, 11:19:35 AM
    Author     : t2alaska
--%>

    <%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <!-- Bootstrap CSS -->
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
            <title>View Posts</title>
        </head>

        <body>
            <div class="container">
                <div class="jumbotron">
                    <a class="btn btn-warning pull-right" href="Logout">Log Out</a>
                    <br>
                    <h1 class="text-center">Discussion Board Posts</h1>
                </div>
                <div class="row">
                    <div class="col-sm-10 col-sm-offset-1">

                        <table class="table">
                            <thead class="thead-inverse">
                            <tr>
                                <th>User</th>
                                <th>Post</th>
                                <th>Date</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="post" items="${posts}">    
                                ${posts}                                              
                            </c:forEach>
                            </tbody>
                        </table>
                        <p><a class="btn btn-info" href="welcome.jsp">New Post</a></p>
                    </div>
                </div>
            </div>
        </body>

        </html>