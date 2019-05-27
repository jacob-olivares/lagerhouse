/*
 * Proyecto Lagerhouse para Portafolio de Título
 * Seccion 001V, Sede Maipú
 * Jacob Olivares Espinoza - 19.128.620-0
 */
package com.lagerhouse.app.DAO.product;

import com.lagerhouse.app.DAO.CrudRepository;
import com.lagerhouse.app.DAO.connection.ConnectionDB;
import com.lagerhouse.app.model.Product;
import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jacob Olivares Espinoza
 */
public class DAOProduct implements CrudRepository<Product> {

    private final ConnectionDB objConn = ConnectionDB.instanceConn();
    ResultSet rs;

    @Override
    public boolean insert(Product x) {
        String query = "{call PRODUCT_tapi.ins(?,?,?,?,?,?,?,?,?)}";

        try {
            CallableStatement callStatement = objConn.getConn().prepareCall(query);
            callStatement.setInt(1, x.getIdBrand());
            callStatement.setDate(2, new Date(x.getExpirationDate().getTime()));
            callStatement.setInt(3, x.getBarcode());
            callStatement.setInt(4, x.getIdSubCategory());
            callStatement.setInt(5, x.getPrice());
            callStatement.setString(6, x.getProductName());
            callStatement.setInt(7, x.getIdProvider());
            callStatement.setInt(8, x.getStock());
            callStatement.setInt(9, x.getMinStock());

            if (callStatement.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;
    }

    @Override
    public boolean update(Product x) {
        String query = "{call PRODUCT_tapi.upd(?,?,?,?,?,?,?,?,?,?)}";
        try {
            CallableStatement callStatement = objConn.getConn().prepareCall(query);
            callStatement.setInt(1, x.getIdBrand());
            callStatement.setDate(2, new Date(x.getExpirationDate().getTime()));
            callStatement.setInt(3, x.getBarcode());
            callStatement.setInt(4, x.getIdSubCategory());
            callStatement.setInt(5, x.getPrice());
            callStatement.setInt(6, x.getIdProduct());
            callStatement.setString(7, x.getProductName());
            callStatement.setInt(8, x.getIdProvider());
            callStatement.setInt(9, x.getStock());
            callStatement.setInt(10, x.getMinStock());

            if (callStatement.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;
    }

    @Override
    public boolean delete(int x) {
        String query = "{call PRODUCT_tapi.del(?)}";
        try {
            CallableStatement callStatement = objConn.getConn().prepareCall(query);
            callStatement.setInt(1, x);

            if (callStatement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;
    }

    @Override
    public List<Product> select() {
        String query = "SELECT * FROM PRODUCT";
        ArrayList<Product> products = null;
        try {
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            System.out.println(objConn.getConn());
            rs = ps.executeQuery();
            products = new ArrayList<>();
            while (rs.next()) {
                products.add(new Product(rs.getInt("ID_PRODUCT"), rs.getInt("ID_SUBCATEGORY"),
                        rs.getInt("ID_BRAND"), rs.getInt("BAR_CODE"), rs.getInt("PRICE"), rs.getInt("STOCK"),
                        rs.getInt("MIN_STOCK"), rs.getString("PRODUCT_NAME"), rs.getDate("EXPIRATION_DATE"),
                        rs.getInt("ID_PROVIDER")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return products;
    }

    @Override
    public Product selectById(int x) {
        String query = "SELECT * FROM PRODUCT WHERE ID_PRODUCT=?;";
        Product product = new Product();
        try {
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            ps.setInt(1, x);
            rs = ps.executeQuery();

            product.setIdProduct(rs.getInt("ID_PRODUCT"));
            product.setIdSubCategory(rs.getInt("ID_SUBCATEGORY"));
            product.setIdBrand(rs.getInt("ID_BRAND"));
            product.setBarcode(rs.getInt("BAR_CODE"));
            product.setPrice(rs.getInt("PRICE"));
            product.setStock(rs.getInt("STOCK"));
            product.setMinStock(rs.getInt("MIN_STOCK"));
            product.setProductName(rs.getString("PRODUCT_NAME"));
            product.setExpirationDate(rs.getDate("EXPIRATION_DATE"));

        } catch (SQLException ex) {
            Logger.getLogger(DAOProduct.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return product;
    }

}
