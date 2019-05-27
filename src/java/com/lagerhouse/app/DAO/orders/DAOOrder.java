/*
 * Proyecto Lagerhouse para Portafolio de Título
 * Seccion 001V, Sede Maipú
 * Jacob Olivares Espinoza - 19.128.620-0
 */
package com.lagerhouse.app.DAO.orders;

import com.lagerhouse.app.DAO.CrudRepository;
import com.lagerhouse.app.DAO.connection.ConnectionDB;
import com.lagerhouse.app.model.Order;
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
public class DAOOrder implements CrudRepository<Order>{
    private final ConnectionDB objConn = ConnectionDB.instanceConn();
    ResultSet rs;

    @Override
    public boolean insert(Order x) {
        String query = "{call ORDERS_tapi.ins(?,?,?)}";

        try {
            CallableStatement callStatement = objConn.getConn().prepareCall(query);
            callStatement.setInt(1, x.getIdStatus());
            callStatement.setInt(2, x.getIdDetailOrder());
            callStatement.setInt(3, x.getIdProvider());

            if (callStatement.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;    
    }

    @Override
    public boolean update(Order x) {
        String query = "{call ORDERS_tapi.upd(?,?,?,?)}";

        try {
            CallableStatement callStatement = objConn.getConn().prepareCall(query);
            callStatement.setInt(1, x.getIdStatus());
            callStatement.setInt(2, x.getIdOrder());
            callStatement.setInt(3, x.getIdDetailOrder());
            callStatement.setInt(4, x.getIdProvider());

            if (callStatement.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;    
    }    

    @Override
    public boolean delete(int x) {
        String query = "{call ORDERS_tapi.del(?)}";
        try {
            CallableStatement callStatement = objConn.getConn().prepareCall(query);
            callStatement.setInt(1, x);

            if (callStatement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;    
    }

    @Override
    public List<Order> select() {
        String query = "SELECT * FROM ORDERS";
        ArrayList<Order> orders = null;
        try {
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            System.out.println(objConn.getConn());
            rs = ps.executeQuery();
            orders = new ArrayList<>();
            
            while(rs.next()){
                orders.add(new Order(rs.getInt("ID_ORDER"), rs.getInt("ID_PROVIDER"), 
                                                 rs.getInt("ID_DETAIL_ORDER"), rs.getInt("ID_STATUS")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return orders;    
    }

    @Override
    public Order selectById(int x) {
        String query = "SELECT * FROM ORDERS WHERE ID_ORDER=?";
        Order order = new Order();
        try {
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            ps.setInt(1, x);
            
            rs = ps.executeQuery();
            order.setIdOrder(rs.getInt("ID_ORDER"));
            order.setIdDetailOrder(rs.getInt("ID_DETAIL_ORDER"));
            order.setIdProvider(rs.getInt("ID_PROVIDER"));
            order.setIdStatus(rs.getInt("ID_STATUS"));
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrder.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return order;    
    }
    
}
