/*
 * Proyecto Lagerhouse para Portafolio de Título
 * Seccion 001V, Sede Maipú
 * Jacob Olivares Espinoza - 19.128.620-0
 */
package com.lagerhouse.app.DAO.user;

import com.lagerhouse.app.DAO.CrudRepository;
import com.lagerhouse.app.DAO.connection.ConnectionDB;
import com.lagerhouse.app.model.Ticket;
import com.lagerhouse.app.model.User;
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
public class DAOUser implements CrudRepository<User> {

    private final ConnectionDB objConn = ConnectionDB.instanceConn();
    ResultSet rs;

    @Override
    public boolean insert(User x) {
        String query = "{call USERS_tapi.ins(?,?,?)}";
        try {
            CallableStatement cst = objConn.getConn().prepareCall(query);
            cst.setString(1, x.getPassword());
            cst.setString(2, x.getUsername());
            cst.setInt(3, x.getIdProfile());

            if (cst.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;
    }

    @Override
    public boolean update(User x) {
        String query = "{call USERS_tapi.upd(?,?,?,?)}";
        try {
            CallableStatement cst = objConn.getConn().prepareCall(query);
            cst.setString(1, x.getPassword());
            cst.setString(2, x.getUsername());
            cst.setInt(3, x.getIdUser());
            cst.setInt(4, x.getIdProfile());

            if (cst.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;
    }

    @Override
    public boolean delete(int x) {
        String query = "{call USERS_tapi.del(?)}";
        try {
            CallableStatement callStatement = objConn.getConn().prepareCall(query);
            callStatement.setInt(1, x);

            if (callStatement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;
    }

    @Override
    public List<User> select() {
        String query = "SELECT * FROM USERS";
        ArrayList<User> users = null;
        try {
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            rs = ps.executeQuery();
            users = new ArrayList<>();
            while (rs.next()) {
                users.add(new User(rs.getInt("ID_USER"),
                        rs.getInt("ID_PROFILE"),
                        rs.getString("USERNAME"), rs.getString("PASSWORD")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return users;
    }

    @Override
    public User selectById(int x) {
        String query = "SELECT * FROM USERS WHERE ID_USER=?";
        User user = new User();
        try {
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            rs = ps.executeQuery();
            
            user.setIdUser(rs.getInt("ID_USER"));
            user.setIdProfile(rs.getInt("ID_PROFILE"));
            user.setUsername(rs.getString("USERNAME"));
            user.setPassword(rs.getString("PASSWORD"));

        } catch (SQLException ex) {
            Logger.getLogger(DAOUser.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return user;       
    }

}
