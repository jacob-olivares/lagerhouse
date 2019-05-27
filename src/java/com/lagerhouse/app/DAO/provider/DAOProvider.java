/*
 * Proyecto Lagerhouse para Portafolio de Título
 * Seccion 001V, Sede Maipú
 * Jacob Olivares Espinoza - 19.128.620-0
 */
package com.lagerhouse.app.DAO.provider;

import com.lagerhouse.app.DAO.CrudRepository;
import com.lagerhouse.app.DAO.connection.ConnectionDB;
import com.lagerhouse.app.model.Provider;
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
public class DAOProvider implements CrudRepository<Provider>{
    private final ConnectionDB objConn = ConnectionDB.instanceConn();
    ResultSet rs;

    @Override
    public boolean insert(Provider x) {
        String query = "{call PROVIDER_tapi.ins(?,?,?,?,?,?)}";
        try {
            CallableStatement cst = objConn.getConn().prepareCall(query);
            cst.setString(1, x.getProviderMail());
            cst.setInt(2, x.getProviderPhone());
            cst.setString(3, x.getProviderAddress());
            cst.setInt(4, x.getDvProviderDni());
            cst.setString(5, x.getProviderName());
            cst.setString(6, Character.toString(x.getDvProviderDni()));

            if (cst.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProvider.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;    
    }

    @Override
    public boolean update(Provider x) {
        String query = "{call PROVIDER_tapi.upd(?,?,?,?,?,?,?)}";
        try {
            CallableStatement cst = objConn.getConn().prepareCall(query);
            cst.setString(1, x.getProviderMail());
            cst.setInt(2, x.getProviderPhone());
            cst.setString(3, x.getProviderAddress());
            cst.setInt(4, x.getDvProviderDni());
            cst.setInt(5, x.getIdProvider());
            cst.setString(6, x.getProviderName());
            cst.setString(7, Character.toString(x.getDvProviderDni()));

            if (cst.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProvider.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;     
    }

    @Override
    public boolean delete(int x) {
        String query = "{call PROVIDER_tapi.del(?)}";
        try {
            CallableStatement callStatement = objConn.getConn().prepareCall(query);
            callStatement.setInt(1, x);

            if (callStatement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProvider.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;    
    }

    @Override
    public List<Provider> select() {
        String query = "SELECT * FROM PROVIDER";
        ArrayList<Provider> providers = null;
        try {
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            rs = ps.executeQuery();
            providers = new ArrayList<>();
            while (rs.next()) {
                providers.add(new Provider(rs.getInt("ID_PROVIDER"),
                        rs.getInt("PROVIDER_DNI"),
                        rs.getInt("PROVIDER_PHONE"), rs.getString("PROVIDER_NAME"), 
                        rs.getString("PROVIDER_ADDRESS"), rs.getString("PROVIDER_MAIL"),
                        rs.getString("DV_PROVIDER_DNI").charAt(0)));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOProvider.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return providers;        
    }

    @Override
    public Provider selectById(int x) {
        String query = "SELECT * FROM PROVIDER WHERE ID_PROVIDER=?";
        Provider provider = new Provider();
        try {
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            rs = ps.executeQuery();
            provider.setProviderDni(rs.getInt("PROVIDER_DNI"));
            provider.setProviderPhone(rs.getInt("PROVIDER_PHONE"));
            provider.setProviderName(rs.getString("PROVIDER_NAME"));
            provider.setProviderAddress(rs.getString("PROVIDER_ADDRESS"));
            provider.setProviderMail(rs.getString("PROVIDER_EMAIL"));
            provider.setDvProviderDni(rs.getString("DV_PROVIDER_DNI").charAt(0));          
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOProviderSeller.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return provider;        
    }
    
}
