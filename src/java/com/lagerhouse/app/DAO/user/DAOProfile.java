/*
 * Proyecto Lagerhouse para Portafolio de Título
 * Seccion 001V, Sede Maipú
 * Jacob Olivares Espinoza - 19.128.620-0
 */
package com.lagerhouse.app.DAO.user;

import com.lagerhouse.app.DAO.CrudRepository;
import com.lagerhouse.app.DAO.connection.ConnectionDB;
import com.lagerhouse.app.model.Profile;
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
public class DAOProfile implements CrudRepository<Profile> {

    private final ConnectionDB objConn = ConnectionDB.instanceConn();
    ResultSet rs;

    @Override
    public boolean insert(Profile x) {
        String query = "{call PROFILE_tapi.ins(?)}";
        try {
            CallableStatement callStatement = objConn.getConn().prepareCall(query);
            callStatement.setString(1, x.getProfileName());

            if (callStatement.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOProfile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;
    }

    @Override
    public boolean update(Profile x) {
        String query = "{call PROFILE_tapi.upd(?,?)}";
        try {
            CallableStatement callStatement = objConn.getConn().prepareCall(query);
            callStatement.setString(1, x.getProfileName());
            callStatement.setInt(1, x.getIdProfile());

            if (callStatement.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOProfile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;
    }

    @Override
    public boolean delete(int x) {
        String query = "{call PROFILE_tapi.del(?)}";
        try {
            CallableStatement callStatement = objConn.getConn().prepareCall(query);
            callStatement.setInt(1, x);

            if (callStatement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProfile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;
    }

    @Override
    public List<Profile> select() {
        String query = "SELECT * FROM PROFILE";
        ArrayList<Profile> profiles = null;
        try {
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            rs = ps.executeQuery();
            profiles = new ArrayList<>();
            while (rs.next()) {
                profiles.add(new Profile(rs.getInt("ID_PROFILE"), rs.getString("PROFILE_NAME")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProfile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return profiles;
    }

    @Override
    public Profile selectById(int x) {
        String query = "SELECT * FROM PROFILE WHERE ID_PROFILE=?";
        Profile profile = new Profile();
        try {
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            ps.setInt(1, x);
            rs = ps.executeQuery();

            profile.setIdProfile(x);
            profile.setProfileName(rs.getString("PROFILE_NAME"));
        } catch (SQLException ex) {
            Logger.getLogger(DAOProfile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return profile;
    }

}
