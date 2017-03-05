<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>

    <head>
        <title>Tenille - Login Page</title>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>

    <body>
        <div class="container">
            <div class="jumbotron text-center">
                <h1>DISCUSSION BOARD</h1>
                <h2>Login Page</h2>
            </div>
            <div class="row">
                <div class="forum-group col-sm-10 col-sm-offset-1">
                    <form action="Login" method="post">

                        <!--<div>${loginStatus}</div>-->
                        <div class="form-group row">
                            <label class="col-sm-2 col-form-label"> USERNAME :</label>
                            <div class="col-sm-10">
                                <input class="form-control" type="text" name="username" placeholder="enter your name" />
                            </div>
                        </div>
                            <div class="form-group row">
                            <label class="col-sm-2 col-form-label"> PASSWORD :</label>
                            <div class="col-sm-10">
                                <input class="form-control" type="password" name="password" placeholder="enter your password" />
                            </div>
                        </div>
                        <button class="btn btn-success pull-right" type="submit">LOGIN</button>

                    </form>
                </div>
            </div>
    </body>

    </html>