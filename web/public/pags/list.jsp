<%-- 
    Document   : list
    Created on : May 21, 2019, 5:26:11 PM
    Author     : jeanp
--%>
<%@page import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String cat = request.getParameter("cat");
    String opc = request.getParameter("opc");
%>
<table>
    <thead>
        <tr> 
            <%
                String[] campos = {"ID", "Nombre", "Precio", "F.Vencimiento", "Stock"};
                for (String campo : campos) {
                    out.println("<th>" + campo + "</th>");
                }
            %>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.idProduct}</td>
                <td>${product.productName}</td>
                <td>${product.price}</td>
                <td>${product.expirationDate}</td>
                <td>${product.stock}</td>
                <td>
                    <a href="#">EDITAR</a>
                    <a href="#">ELIMINAR</a></td>
            </tr>
        </c:forEach>
    </tbody>
    <a href="${pageContext.request.contextPath}/public/pags/agregarProducto.jsp">Agregar producto</button>
</table>


