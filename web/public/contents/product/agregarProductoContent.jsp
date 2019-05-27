<%-- 
    Document   : agregarProductoContent
    Created on : 25-05-2019, 22:55:48
    Author     : Jacob Olivares Espinoza
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<form action="${pageContext.request.contextPath}/mantenedor/producto/agregar" method="POST">
    <table>
        <tr>
            <td>Nombre producto: </td>
            <td><input type="text" name="productName"/></td>
        </tr>
        <tr>
            <td>Proveedor</td>
            <td>
                <select name="idProvider">
                    <option value="0">Seleccione</option>
                    <c:forEach items="${providers}" var="provider">
                        <option value="${provider.idProvider}">${provider.providerName}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Marca: </td>
            <td>
                <select name="idBrand">
                    <option value="0">Seleccione</option>
                    <c:forEach items="${brands}" var="brand">
                        <option value="${brand.idBrand}">${brand.nameBrand}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>

        <tr>
            <td>Categoria: </td>
            <td>
                <select name="idCategory">
                    <option value="0">Seleccione</option>
                    <c:forEach items="${categories}" var="category">
                        <option value="${category.idCategory}">${category.categoryName}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>Sub-Categoria: </td>
            <td>
                <select name="idSubCategory">
                    <option value="0">Seleccione</option>
                    <c:forEach items="${subCategories}" var="subCategory">
                        <option value="${subCategory.idSubCategory}">${subCategory.subCategoryName}</option>
                    </c:forEach>
                </select>
            </td>
        </tr>
        <tr>
            <td>F.Vencimiento: </td>
            <td><input type="date" pattern="dd/MM/YYYY"name="expirationDate"/></td>
        </tr>    
        <tr>
            <td>Precio: </td>
            <td><input type="number" name="price"/></td>
        </tr>    
        <tr>
            <td>Stock: </td>
            <td><input type="number" name="stock"/></td>
        </tr>
        <tr>
            <td>Stock Critico: </td>
            <td><input type="number" name="minStock"/></td>
        </tr>
        <tr>
            <td></td>
            <td><button type="submit">Guardar Producto</button></td>
        </tr>
    </table>
</form>
