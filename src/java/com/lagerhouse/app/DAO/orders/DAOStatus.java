/*
 * Proyecto Lagerhouse para Portafolio de Título
 * Seccion 001V, Sede Maipú
 * Jacob Olivares Espinoza - 19.128.620-0
 */
package com.lagerhouse.app.DAO.orders;

import com.lagerhouse.app.DAO.CrudRepository;
import com.lagerhouse.app.DAO.user.DAOProfile;
import com.lagerhouse.app.DAO.connection.ConnectionDB;
import com.lagerhouse.app.model.Profile;
import com.lagerhouse.app.model.Status;
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
public class DAOStatus implements CrudRepository<Status> {

    private final ConnectionDB objConn = ConnectionDB.instanceConn();
    ResultSet rs;

    @Override
    public boolean insert(Status x) {
        String query = "{call STATUS_tapi.ins(?)}";
        try {
            CallableStatement callStatement = objConn.getConn().prepareCall(query);
            callStatement.setString(1, x.getStatusName());

            if (callStatement.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOStatus.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;
    }

    @Override
    public boolean update(Status x) {
        String query = "{call STATUS_tapi.upd(?,?)}";
        try {
            CallableStatement callStatement = objConn.getConn().prepareCall(query);
            callStatement.setInt(1, x.getIdStatus());
            callStatement.setString(2, x.getStatusName());

            if (callStatement.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOStatus.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;
    }

    @Override
    public boolean delete(int x) {
        String query = "{call SALE_tapi.del(?)}";
        try {
            CallableStatement callStatement = objConn.getConn().prepareCall(query);
            callStatement.setInt(1, x);

            if (callStatement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOStatus.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;
    }

    @Override
    public List<Status> select() {
        String query = "SELECT * FROM STATUS";
        ArrayList<Status> listStatus = null;
        try {
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            rs = ps.executeQuery();
            listStatus = new ArrayList<>();
            while (rs.next()) {
                listStatus.add(new Status(rs.getInt("ID_STATUS"), rs.getString("STATUS_NAME")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOStatus.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return listStatus;
    }

    @Override
    public Status selectById(int x) {
        String query = "SELECT * FROM PROFILE WHERE ID_PROFILE=?";
        Status status = new Status();
        try {
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            ps.setInt(1, x);
            rs = ps.executeQuery();

            status.setIdStatus(x);
            status.setStatusName(rs.getString("STATUS_NAME"));
        } catch (SQLException ex) {
            Logger.getLogger(DAOProfile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return status;    
    }

}
