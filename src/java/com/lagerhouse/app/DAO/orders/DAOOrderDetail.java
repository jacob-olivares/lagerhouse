/*
 * Proyecto Lagerhouse para Portafolio de Título
 * Seccion 001V, Sede Maipú
 * Jacob Olivares Espinoza - 19.128.620-0
 */
package com.lagerhouse.app.DAO.orders;

import com.lagerhouse.app.DAO.CrudRepository;
import com.lagerhouse.app.DAO.connection.ConnectionDB;
import com.lagerhouse.app.model.OrderDetail;
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
public class DAOOrderDetail implements CrudRepository<OrderDetail> {

    private final ConnectionDB objConn = ConnectionDB.instanceConn();
    ResultSet rs;

    @Override
    public boolean insert(OrderDetail x) {
        String query = "{call ORDER_DETAIL_tapi.ins(?,?,?)}";

        try {
            CallableStatement callStatement = objConn.getConn().prepareCall(query);
            callStatement.setInt(1, x.getQuantity());
            callStatement.setInt(2, x.getNeto());
            callStatement.setInt(3, x.getIdProduct());

            if (callStatement.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOOrderDetail.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;
    }

    @Override
    public boolean update(OrderDetail x) {
        String query = "{call ORDER_DETAIL_tapi.upd(?,?,?)}";

        try {
            CallableStatement callStatement = objConn.getConn().prepareCall(query);
            callStatement.setInt(1, x.getQuantity());
            callStatement.setInt(2, x.getNeto());
            callStatement.setInt(3, x.getIdOrderDetail());
            callStatement.setInt(4, x.getIdProduct());

            if (callStatement.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOOrderDetail.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;
    }

    @Override
    public boolean delete(int x) {
        String query = "{call ORDER_DETAIL_tapi.del(?,?)}";
        try {
            CallableStatement callStatement = objConn.getConn().prepareCall(query);
            callStatement.setInt(1, x);

            if (callStatement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrderDetail.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;
    }

    @Override
    public List<OrderDetail> select() {
        String query = "SELECT * FROM ORDER_DETAIL";
        ArrayList<OrderDetail> ordersDetail = null;
        try {
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            System.out.println(objConn.getConn());
            rs = ps.executeQuery();
            ordersDetail = new ArrayList<>();
            
            while(rs.next()){
                ordersDetail.add(new OrderDetail(rs.getInt("ID_ORDER_DETAIL"), rs.getInt("ID_PRODUCT"), 
                                                 rs.getInt("QUANTITY"), rs.getInt("NETO")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrderDetail.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return ordersDetail;
    }

    @Override
    public OrderDetail selectById(int x) {
        String query = "SELECT * FROM ORDER_DETAIL WHERE ID_ORDER_DETAIL=?";
        OrderDetail orderDetail = new OrderDetail();
        try{
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            ps.setInt(1, x);
            rs = ps.executeQuery();
            
            orderDetail.setIdOrderDetail(rs.getInt("ID_ORDER_DETAIL"));
            orderDetail.setIdProduct(rs.getInt("ID_PRODUCT"));
            orderDetail.setNeto(rs.getInt("NETO"));
            orderDetail.setQuantity(rs.getInt("QUANTITY"));
            
        } catch (SQLException ex) {
            Logger.getLogger(DAOOrderDetail.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return orderDetail;
    }
}
