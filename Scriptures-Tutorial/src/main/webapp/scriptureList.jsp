<%-- 
    Document   : scriptureList
    Created on : Feb 25, 2017, 4:42:34 PM
    Author     : t2alaska
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Scripture List</title>
    </head>
    <body>
        <h1>Scripture List</h1>
        <div> 
            <c:forEach var="scripture" items="${scriptures}">
                <strong>${scripture.book}</strong> ${scripture.chapter}:${scripture.verse}<br />
            </c:forEach>
       </div>     


        </div>
    </body>
</html>
