/*
 * Proyecto Lagerhouse para Portafolio de Título
 * Seccion 001V, Sede Maipú
 * Jacob Olivares Espinoza - 19.128.620-0
 */
package com.lagerhouse.app.controller;

import com.lagerhouse.app.DAO.orders.DAOOrder;
import com.lagerhouse.app.DAO.orders.DAOOrderDetail;
import com.lagerhouse.app.DAO.orders.DAOStatus;
import com.lagerhouse.app.DAO.product.DAOBrand;
import com.lagerhouse.app.DAO.product.DAOCategory;
import com.lagerhouse.app.DAO.product.DAOProduct;
import com.lagerhouse.app.DAO.product.DAOSubCategory;
import com.lagerhouse.app.DAO.provider.DAOProvider;
import com.lagerhouse.app.DAO.provider.DAOProviderSeller;
import com.lagerhouse.app.DAO.sales.DAOCustomer;
import com.lagerhouse.app.DAO.sales.DAOSale;
import com.lagerhouse.app.DAO.sales.DAOTicket;
import com.lagerhouse.app.DAO.sales.DAOTicketDetail;
import com.lagerhouse.app.DAO.user.DAOPermission;
import com.lagerhouse.app.DAO.user.DAOProfile;
import com.lagerhouse.app.DAO.user.DAOProfilePermission;
import com.lagerhouse.app.DAO.user.DAOUser;
import com.lagerhouse.app.model.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jacob Olivares Espinoza
 */
public class ServletCargaListas extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        loadDBTables(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    public void loadDBTables(HttpServletRequest request, HttpServletResponse response){
        // CARGAREMOS LOS DATOS DESDE LA DB A TRAVÉS DE LOS DAO
        // DAOs Products
        DAOProduct dProduct = new DAOProduct();
        DAOBrand dBrand = new DAOBrand();
        DAOCategory dCategory = new DAOCategory();
        DAOSubCategory dSubCategory = new DAOSubCategory();
        
        // DAOs Users
        DAOUser dUser = new DAOUser();
        DAOProfile dProfile = new DAOProfile();
        DAOPermission dPermission = new DAOPermission();
        DAOProfilePermission dProfilePermission = new DAOProfilePermission();
        
        // DAOs Providers
        DAOProvider dProvider = new DAOProvider();
        DAOProviderSeller dProviderSeller = new DAOProviderSeller();
        
        // DAOs Orders
        DAOOrder dOrder = new DAOOrder();
        DAOOrderDetail dOrderDetail = new DAOOrderDetail();
        DAOStatus dStatus = new DAOStatus();

        // DAOs Sales
        DAOCustomer dCustomer = new DAOCustomer();
        DAOSale dSale = new DAOSale();
        DAOTicket dTicket = new DAOTicket();
        DAOTicketDetail dTicketDetail = new DAOTicketDetail();
        
        
        // LISTAS PARA SER DESPLEGADAS Y UTILIZADAS POR TODO EL SISTEMA WEB
        // LISTA DE PRODUCTOS, CATEGORIAS, SUBCATEGORIAS, MARCAS.
        ArrayList<Product> products = (ArrayList<Product>)dProduct.select();
        ArrayList<Brand> brands = (ArrayList<Brand>)dBrand.select();
        ArrayList<Category> categories = (ArrayList<Category>)dCategory.select();
        ArrayList<SubCategory> subCategories = (ArrayList<SubCategory>)dSubCategory.select();
        
        // LISTA DE USUARIOS CON SUS PERFILES, PERMISOS.
        ArrayList<User> users = (ArrayList<User>)dUser.select();
        ArrayList<Profile> profiles = (ArrayList<Profile>)dProfile.select();
        ArrayList<Permission> permissions = (ArrayList<Permission>)dPermission.select();
        ArrayList<ProfilePermission> profilePermissions = (ArrayList<ProfilePermission>)dProfilePermission.select();
        
        // LISTA DE PROVEEDORES Y SUS VENDEDORES.
        ArrayList<Provider> providers = (ArrayList<Provider>)dProvider.select();
        ArrayList<ProviderSeller> providerSellers = (ArrayList<ProviderSeller>)dProviderSeller.select();
        
        // LISTA DE ORDENES DE PEDIDO Y LAS LISTAS DE DETALLES DE CADA ORDEN
        ArrayList<Order> orders = (ArrayList<Order>)dOrder.select();
        ArrayList<OrderDetail> orderDetails = (ArrayList<OrderDetail>)dOrderDetail.select();
        ArrayList<Status> statuses = (ArrayList<Status>)dStatus.select();
        
        
        // LISTA DE VENTAS, BOLETAS Y DETALLE DE CADA BOLETA
        ArrayList<Customer> customers = (ArrayList<Customer>)dCustomer.select();
        ArrayList<Sale> sales = (ArrayList<Sale>)dSale.select();
        ArrayList<Ticket> tickets = (ArrayList<Ticket>)dTicket.select();
        ArrayList<TicketDetail> ticketDetails = (ArrayList<TicketDetail>)dTicketDetail.select();
        
        request.getSession().setAttribute("products", products);
        request.getSession().setAttribute("brands", brands);
        request.getSession().setAttribute("categories", categories);
        request.getSession().setAttribute("subCategories", subCategories);
        request.getSession().setAttribute("users", users);
        request.getSession().setAttribute("profiles", profiles);
        request.getSession().setAttribute("permissions", permissions);
        request.getSession().setAttribute("profilePermissions", profilePermissions);
        request.getSession().setAttribute("providers", providers);
        request.getSession().setAttribute("orders", orders);
        request.getSession().setAttribute("orderDetails", orderDetails);
        request.getSession().setAttribute("statuses", statuses);
        request.getSession().setAttribute("customers", customers);
        request.getSession().setAttribute("sales", sales);
        request.getSession().setAttribute("tickets", tickets);
        request.getSession().setAttribute("ticketDetails", ticketDetails);
    }
}
