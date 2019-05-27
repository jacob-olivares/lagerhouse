/*
 * Proyecto Lagerhouse para Portafolio de Título
 * Seccion 001V, Sede Maipú
 * Jacob Olivares Espinoza - 19.128.620-0
 */
package com.lagerhouse.app.DAO.user;

import com.lagerhouse.app.DAO.connection.ConnectionDB;
import com.lagerhouse.app.model.ProfilePermission;
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
public class DAOProfilePermission{

    private final ConnectionDB objConn = ConnectionDB.instanceConn();
    ResultSet rs;

    public boolean insert(ProfilePermission x) {
        String query = "{call PROFILE_PERMISSION_TAPI.ins(?,?)}";

        try {
            CallableStatement callStatement = objConn.getConn().prepareCall(query);
            callStatement.setInt(1, x.getIdPermission());
            callStatement.setInt(2, x.getIdProfile());

            if (callStatement.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOProfilePermission.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;
    }

    public boolean update(ProfilePermission x) {
        String query = "{call PROFILE_PERMISSION_TAPI.upd(?,?)}";

        try {
            CallableStatement callStatement = objConn.getConn().prepareCall(query);
            callStatement.setInt(1, x.getIdPermission());
            callStatement.setInt(2, x.getIdProfile());

            if (callStatement.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOProfilePermission.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;    
    }

    public boolean deleteByTwoId(int idPermission, int idProfile) {
        String query = "{call ORDER_DETAIL_tapi.del(?,?)}";
        try {
            CallableStatement callStatement = objConn.getConn().prepareCall(query);
            callStatement.setInt(1, idPermission);
            callStatement.setInt(2, idProfile);

            if (callStatement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProfilePermission.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;    
    }

    public List<ProfilePermission> select() {
        String query = "SELECT * FROM PROFILE_PERMISSION";
        ArrayList<ProfilePermission> profilePermissions = null;
        try {
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            rs = ps.executeQuery();
            profilePermissions = new ArrayList<>();
            
            while(rs.next()){
                profilePermissions.add(new ProfilePermission(rs.getInt("ID_PERMISSION"), rs.getInt("ID_PROFILE")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProfilePermission.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return profilePermissions;    
    }

    public ArrayList<ProfilePermission> selectById(int idProfile) {
        String query = "SELECT * FROM PROFILE_PERMISION WHERE ID_PROFILE=?";
        ArrayList<ProfilePermission> profilePermissions = null;
        try{
            profilePermissions = new ArrayList<>();
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            ps.setInt(1, idProfile);
            
            rs = ps.executeQuery();
            while(rs.next()){
                profilePermissions.add(new ProfilePermission(rs.getInt("ID_PROFILE"), rs.getInt("ID_PERMISSION")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProfilePermission.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return profilePermissions;
    }
}
