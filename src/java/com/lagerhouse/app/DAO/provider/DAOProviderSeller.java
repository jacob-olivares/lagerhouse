/*
 * Proyecto Lagerhouse para Portafolio de Título
 * Seccion 001V, Sede Maipú
 * Jacob Olivares Espinoza - 19.128.620-0
 */
package com.lagerhouse.app.DAO.provider;

import com.lagerhouse.app.DAO.CrudRepository;
import com.lagerhouse.app.DAO.connection.ConnectionDB;
import com.lagerhouse.app.model.ProviderSeller;
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
public class DAOProviderSeller implements CrudRepository<ProviderSeller> {

    private final ConnectionDB objConn = ConnectionDB.instanceConn();
    ResultSet rs;

    @Override
    public boolean insert(ProviderSeller x) {
        String query = "{call PROVIDER_SELLER_tapi.ins(?,?,?,?)}";
        try {
            CallableStatement cst = objConn.getConn().prepareCall(query);
            cst.setString(1, x.getSellerMail());
            cst.setInt(2, x.getIdProvider());
            cst.setString(3, x.getSellerName());
            cst.setInt(4, x.getSellerPhone());

            if (cst.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProviderSeller.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;
    }

    @Override
    public boolean update(ProviderSeller x) {
        String query = "{call PROVIDER_SELLER_tapi.upd(?,?,?,?,?)}";
        try {
            CallableStatement cst = objConn.getConn().prepareCall(query);
            cst.setString(1, x.getSellerMail());
            cst.setInt(2, x.getIdProviderSeller());
            cst.setInt(3, x.getIdProvider());
            cst.setString(4, x.getSellerName());
            cst.setInt(5, x.getSellerPhone());

            if (cst.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProviderSeller.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;
    }

    @Override
    public boolean delete(int x) {
        String query = "{call PROVIDER_SELLER_tapi.del(?)}";
        try {
            CallableStatement callStatement = objConn.getConn().prepareCall(query);
            callStatement.setInt(1, x);

            if (callStatement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOProviderSeller.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;
    }

    @Override
    public List<ProviderSeller> select() {
        String query = "SELECT * FROM PROVIDER_SELLER";
        ArrayList<ProviderSeller> providerSellers = null;
        try {
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            rs = ps.executeQuery();
            providerSellers = new ArrayList<>();
            while (rs.next()) {
                providerSellers.add(new ProviderSeller(rs.getInt("ID_PROVIDER_SELLER"),
                        rs.getInt("SELLER_PHONE"),
                        rs.getInt("ID_PROVIDER"), rs.getString("SELLER_NAME"), 
                        rs.getString("SELLER_EMAIL")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOProviderSeller.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return providerSellers;    
    }

    
    public List<ProviderSeller> selectByIdProvider(int x) {
                String query = "SELECT * FROM PROVIDER_SELLER WHERE ID_PROVIDER=?";
        ArrayList<ProviderSeller> providerSellers = null;
        try {
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            ps.setInt(1, x);
            rs = ps.executeQuery();
            providerSellers = new ArrayList<>();
            while (rs.next()) {
                providerSellers.add(new ProviderSeller(rs.getInt("ID_PROVIDER_SELLER"),
                        rs.getInt("SELLER_PHONE"),
                        rs.getInt("ID_PROVIDER"), rs.getString("SELLER_NAME"), 
                        rs.getString("SELLER_EMAIL")));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOProviderSeller.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return providerSellers;    
    }
    @Override
    public ProviderSeller selectById(int x) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
