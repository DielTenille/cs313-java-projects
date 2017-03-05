<%-- 
    Document   : welcome
    Created on : Mar 4, 2017, 1:18:07 AM
    Author     : t2alaska
--%>

    <%@page contentType="text/html" pageEncoding="UTF-8"%>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <!-- Bootstrap CSS -->
            <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
            <title>Welcome</title>
        </head>

        <body>

            <div class="container">
                <div class="jumbotron text-center">
                    <a class="btn btn-warning pull-right" href="Logout">Log Out</a>
                    <br>
                    <h1>Welcome!</h1>

                    <p>Welcome ${username}. You are logged in!</p>
                </div>
                <br />

                <div class="row">
                    <div class="col-sm-10">
                        <div class="row">
                            <div class="col-sm-10">
                                <h2 class="text-left col-sm-offset-1">Add a New Post</h2>
                                ${errorMsg}
                            </div>
                        </div>
                        <div class="form-group">
                            <form action="CreatePost" method="post">
                                <textarea class="form-control col-sm-offset-1" rows="10" cols="50" name="message" placeholder="Enter your post here" required></textarea>
                                <br><br>
                                <div class="row">
                                    <div class="col-sm-10 col-sm-offset-1">
                                        <button class="btn btn-success" type="submit" value="Post">Add Post</button>
                                        <a class="btn btn-info" href="LoadPosts" role="button" value="View Posts">View Posts </a>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </body>

        </html>