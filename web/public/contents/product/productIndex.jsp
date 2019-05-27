<%-- 
    Document   : productIndex
    Created on : 25-05-2019, 22:26:14
    Author     : Jacob Olivares Espinoza
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.lagerhouse.app.model.Product"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <a href="${pageContext.request.contextPath}/public/pags/product/agregarProducto.jsp">Agregar producto</button>
</table>
