<%-- 
    Document   : index
    Created on : May 21, 2019, 4:39:37 PM
    Author     : jeanp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="public/patials/head.jsp" %>
    </head>
    <body>
        <div class="nav">
            <%@include file="public/patials/nav.jsp" %>
        </div>
    <top>
        <%@include file="public/patials/top.jsp" %>
    </top>
    <div class="container">
        <header>
            <%@include file="public/patials/header.jsp" %>
        </header>
        <main>
            <jsp:include page="public/contents/dashboardContent.jsp" />
        </main>
        <footer>
            <%@include file="public/patials/footer.jsp" %>
        </footer>
    </div>
    </body>
</html>
