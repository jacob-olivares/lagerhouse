/*
 * Proyecto Lagerhouse para Portafolio de Título
 * Seccion 001V, Sede Maipú
 * Jacob Olivares Espinoza - 19.128.620-0
 */
package com.lagerhouse.app.controller;

import com.lagerhouse.app.DAO.product.DAOProduct;
import com.lagerhouse.app.model.Product;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jacob Olivares Espinoza
 */
public class ServletProducto extends HttpServlet {
    private static final String AGREGAR_PRODUCTO = "agregar";

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
        String urlIngresada = request.getRequestURI();
        String accionSolicitada = urlIngresada.substring(urlIngresada.lastIndexOf("/") + 1);
        System.out.println(accionSolicitada + " " + urlIngresada);
                    
        if(AGREGAR_PRODUCTO.equalsIgnoreCase(accionSolicitada)) {
                this.agregarProducto(request, response);
                
            } 
        

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

    private void agregarProducto(HttpServletRequest request, HttpServletResponse response) {
        if ("POST".equalsIgnoreCase(request.getMethod())) {
            try {
                String barcode;
                DateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
                String productName = request.getParameter("productName");
                int idProvider = Integer.parseInt(request.getParameter("idProvider"));
                int idBrand = Integer.parseInt(request.getParameter("idBrand"));
                int idCategory = Integer.parseInt(request.getParameter("idCategory"));
                int idSubCategory = Integer.parseInt(request.getParameter("idSubCategory"));
                String fecha = request.getParameter("expirationDate");
                Date expirationDate = sdf.parse(fecha);
            
                int price = Integer.parseInt(request.getParameter("price"));
                int stock = Integer.parseInt(request.getParameter("stock"));
                int minStock = Integer.parseInt(request.getParameter("minStock"));
               
                // SE CREA EL OBJETO DE LA CLASE PARA SER INYECTADO EN EL DAO A LA BD
                DAOProduct dProduct = new DAOProduct();
                Product product = new Product(idSubCategory, idBrand, price, price, stock, minStock, productName, expirationDate, idProvider);
                
                // CREAREMOS EL BARCODE
                String _fecha = sdf.format(expirationDate);
                String barcode_aux = idProvider + "" + idSubCategory + fecha + product.getIdProduct();
                System.out.println("BARCODE"+ barcode_aux);
            
            } catch (ParseException ex) {
                Logger.getLogger(ServletProducto.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        }
    }
    
   // public int generarCodigo(int idProvider, int idSubCategory, )

}
