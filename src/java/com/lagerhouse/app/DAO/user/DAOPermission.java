/*
 * Proyecto Lagerhouse para Portafolio de Título
 * Seccion 001V, Sede Maipú
 * Jacob Olivares Espinoza - 19.128.620-0
 */
package com.lagerhouse.app.DAO.user;

import com.lagerhouse.app.DAO.CrudRepository;
import com.lagerhouse.app.DAO.connection.ConnectionDB;
import com.lagerhouse.app.model.Permission;
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
public class DAOPermission implements CrudRepository<Permission>{
    private final ConnectionDB objConn = ConnectionDB.instanceConn();
    ResultSet rs;
    
    @Override
    public boolean insert(Permission x) {
                String query = "{call PERMISSION_tapi.ins(?)}";
        try {
            CallableStatement callStatement = objConn.getConn().prepareCall(query);
            callStatement.setString(1, x.getPermissionName());

            if (callStatement.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOPermission.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;
    }

    @Override
    public boolean update(Permission x) {
                String query = "{call PERMISSION_tapi.upd(?,?)}";
        try {
            CallableStatement callStatement = objConn.getConn().prepareCall(query);
            callStatement.setInt(1, x.getIdPermission());
            callStatement.setString(2, x.getPermissionName());

            if (callStatement.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOPermission.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;    }

    @Override
    public boolean delete(int x) {
        String query = "{call PERMISSION_tapi.del(?)}";
        try {
            CallableStatement callStatement = objConn.getConn().prepareCall(query);
            callStatement.setInt(1, x);

            if (callStatement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOPermission.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;   
    }

    @Override
    public List<Permission> select() {
        String query = "SELECT * FROM PERMISSION";
        ArrayList<Permission> permissions = null;
        try {
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            System.out.println(objConn.getConn());
            rs = ps.executeQuery();
            permissions = new ArrayList<>();
            while (rs.next()) {
                permissions.add(new Permission(rs.getInt("ID_PERMISSION"), rs.getString("PERMISSION_NAME")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOPermission.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return permissions;    
    }

    @Override
    public Permission selectById(int x) {
        String query = "SELECT * FROM PERMISSION WHERE ID_PERMISSION=?";
        Permission permission = new Permission();
        try {
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            ps.setInt(1, x);
            permission.setIdPermission(rs.getInt("ID_PERMISSION"));
            permission.setPermissionName(rs.getString("PERMISSION_NAME"));
        } catch (SQLException ex) {
            Logger.getLogger(DAOPermission.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return permission;        
    }
    
}
