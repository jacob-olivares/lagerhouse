/*
 * Proyecto Lagerhouse para Portafolio de Título
 * Seccion 001V, Sede Maipú
 * Jacob Olivares Espinoza - 19.128.620-0
 */
package com.lagerhouse.app.DAO.product;

import com.lagerhouse.app.DAO.CrudRepository;
import com.lagerhouse.app.DAO.connection.ConnectionDB;
import com.lagerhouse.app.DAO.connection.ConnectionDB;
import com.lagerhouse.app.model.OrderDetail;
import com.lagerhouse.app.model.SubCategory;
import java.sql.CallableStatement;
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
public class DAOSubCategory implements CrudRepository<SubCategory> {

    private final ConnectionDB objConn = ConnectionDB.instanceConn();
    ResultSet rs;

    @Override
    public boolean insert(SubCategory x) {
        String query = "{call SUB_CATEGORY_tapi.ins(?,?)}";

        try {
            CallableStatement callStatement = objConn.getConn().prepareCall(query);
            callStatement.setInt(1, x.getIdCategory());
            callStatement.setString(2, x.getSubCategoryName());

            if (callStatement.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOSubCategory.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;
    }

    @Override
    public boolean update(SubCategory x) {
        String query = "{call SUB_CATEGORY_tapi.upd(?,?,?)}";

        try {
            CallableStatement callStatement = objConn.getConn().prepareCall(query);
            callStatement.setInt(1, x.getIdCategory());
            callStatement.setInt(2, x.getIdSubCategory());
            callStatement.setString(3, x.getSubCategoryName());

            if (callStatement.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOSubCategory.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;
    }

    @Override
    public boolean delete(int x) {
        String query = "{call SUB_CATEGORY_tapi.del(?)}";
        try {
            CallableStatement callStatement = objConn.getConn().prepareCall(query);
            callStatement.setInt(1, x);

            if (callStatement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOSubCategory.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;
    }

    @Override
    public List<SubCategory> select() {
        String query = "SELECT * FROM SUB_CATEGORY";
        ArrayList<SubCategory> subCategories = null;
        try {
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            System.out.println(objConn.getConn());
            rs = ps.executeQuery();
            subCategories = new ArrayList<>();
            
            while(rs.next()){
                subCategories.add(new SubCategory(rs.getInt("ID_SUBCATEGORY"), rs.getInt("ID_CATEGORY"), 
                                                 rs.getString("SUBCATEGORY_NAME")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOSubCategory.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return subCategories;
    }

    @Override
    public SubCategory selectById(int x) {
        String query = "SELECT * FROM SUB_CATEGORY WHERE ID_SUBCATEGORY=?";
        SubCategory subCategory = new SubCategory();
        try{
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            ps.setInt(1, x);
            rs = ps.executeQuery();
            
            subCategory.setIdSubCategory(rs.getInt("ID_SUBCATEGORY"));
            subCategory.setIdCategory(rs.getInt("ID_CATEGORY"));
            subCategory.setSubCategoryName(rs.getString("SUBCATEGORY_NAME"));
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOSubCategory.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return subCategory;    
    }

}
