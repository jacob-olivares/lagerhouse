/*
 * Proyecto Lagerhouse para Portafolio de Título
 * Seccion 001V, Sede Maipú
 * Jacob Olivares Espinoza - 19.128.620-0
 */
package com.lagerhouse.app.DAO.product;

import com.lagerhouse.app.DAO.CrudRepository;
import com.lagerhouse.app.DAO.connection.ConnectionDB;
import com.lagerhouse.app.DAO.connection.ConnectionDB;
import com.lagerhouse.app.model.Category;
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
public class DAOCategory implements CrudRepository<Category> {

    private final ConnectionDB objConn = ConnectionDB.instanceConn();
    ResultSet rs;

    @Override
    public boolean insert(Category x) {
        String query = "{call CATEGORY_tapi.ins(?)}";
        try {
            CallableStatement callStatement = objConn.getConn().prepareCall(query);
            callStatement.setString(1, x.getCategoryName());

            if (callStatement.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;
    }

    @Override
    public boolean update(Category x) {
        String query = "{call CATEGORY_tapi.upd(?,?)}";
        try {
            CallableStatement callStatement = objConn.getConn().prepareCall(query);
            callStatement.setInt(1, x.getIdCategory());
            callStatement.setString(2, x.getCategoryName());
            if (callStatement.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;
    }

    @Override
    public boolean delete(int x) {
        String query = "{call CATEGORY_tapi.del(?)}";
        try {
            CallableStatement callStatement = objConn.getConn().prepareCall(query);
            callStatement.setInt(1, x);

            if (callStatement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;
    }

    @Override
    public List<Category> select() {
        String query = "SELECT * FROM CATEGORY";
        ArrayList<Category> categories = null;
        try {
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            System.out.println(objConn.getConn());
            rs = ps.executeQuery();
            categories = new ArrayList<>();
            while (rs.next()) {
                categories.add(new Category(rs.getInt("ID_CATEGORY"), rs.getString("CATEGORY_NAME")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return categories;
    }

    @Override
    public Category selectById(int x) {
        String query = "SELECT * FROM CATEGORY WHERE ID_CATEGORY=?;";
        Category category = new Category();
        try {
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            ps.setInt(1, x);
            rs = ps.executeQuery();

            category.setIdCategory(rs.getInt("ID_CATEGORY"));

        } catch (SQLException ex) {
            Logger.getLogger(DAOCategory.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return category;
    }
}
