<%-- 
    Document   : nav
    Created on : May 21, 2019, 4:36:59 PM
    Author     : jeanp
--%>
<a href="?" class="logo">
        <img alt="Logo" src="https://cdn.shopify.com/tools/logo-maker/show/bjdBQ1UxVy9pYWMxRjJyQVpyaWxpdz09LS1CK0tjdWRzVzlIeGtsaUxXNDIxZG5BPT0=--01c68e9c7b21e79449fee3eb774e7ffe6ee258fe_500x.svg.png">
</a>
<div class="categories">
    <label class="title">Navegacion</label>
    <div class="menu">
        <label class="categoryButton">Productos</label>
        <div class="submenu">
                <a href="?pag=list&cat=prod&opc=cate">Categorias</a>
                <a href="?pag=list&cat=prod&opc=subc">Subcategorias</a>
                <a href="${pageContext.request.contextPath}/public/pags/product/index.jsp">Productos</a>
                <a href="?pag=list&cat=prod&opc=marc">Marcas</a>
        </div>
    </div>
    <div class="menu">
        <label class="categoryButton">Ventas</label>
        <div class="submenu">
                <a href="?pag=list&cat=vent&opc=bole">Boletas</a>
                <a href="?pag=list&cat=vent&opc=desc">Descuentos</a>
                <a href="?pag=list&cat=vent&opc=pedi">Pedidos</a>
        </div>
    </div>
    <div class="menu">
        <label class="categoryButton">Externos</label>
        <div class="submenu">
                <a href="?pag=list&cat=exte&opc=clie">Clientes</a>
                <a href="?pag=list&cat=exte&opc=prov">Proveedores</a>
        </div>
    </div>
    <div class="menu">
        <label class="categoryButton">Configuración</label>
        <div class="submenu">
                <a href="?pag=list&cat=conf&opc=perf">Perfiles</a>
                <a href="?pag=list&cat=conf&opc=perm">Permisos</a>
                <a href="?pag=list&cat=conf&opc=usua">Usuarios</a>
                <a href="?pag=list&cat=conf&opc=sopo">Soporte</a>
        </div>
    </div>
</div>
<script type="text/javascript">
    $('.menu').click(function(){
        $(this).find('.submenu').slideToggle();
    });

    $('i').click(function(){
        $('.nav').toggleClass('minimizado');
    });
</script>