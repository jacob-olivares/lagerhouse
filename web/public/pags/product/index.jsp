<%-- 
    Document   : index.js
    Created on : 24-05-2019, 16:36:52
    Author     : Jacob Olivares Espinoza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="/ServletCargaListas" />
<!DOCTYPE html>
<html>
    <head>
        <%@include file="../../patials/head.jsp" %>
    </head>
    <body>
        <div class="nav">
            <%@include file="../../patials/nav.jsp" %>
        </div>
        <top>
            <%@include file="../../patials/top.jsp" %>
        </top>
        <div class="container">
            <header>
                <%@include file="../../patials/header.jsp" %>
            </header>
            <main>
                <jsp:include page="../../contents/product/productIndex.jsp" />
            </main>
            <footer>
                <%@include file="../../patials/footer.jsp" %>
            </footer>
        </div>
    </body>
</html>
