/*
 * Proyecto Lagerhouse para Portafolio de Título
 * Seccion 001V, Sede Maipú
 * Jacob Olivares Espinoza - 19.128.620-0
 */
package com.lagerhouse.app.DAO.sales;

import com.lagerhouse.app.DAO.CrudRepository;
import com.lagerhouse.app.DAO.connection.ConnectionDB;
import com.lagerhouse.app.model.Ticket;
import com.lagerhouse.app.model.TicketDetail;
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
public class DAOTicketDetail implements CrudRepository<TicketDetail>{
    private final ConnectionDB objConn = ConnectionDB.instanceConn();
    ResultSet rs;
    
    @Override
    public boolean insert(TicketDetail x) {
        String query = "{call TICKET_DETAIL_tapi.ins(?,?,?,?)}";
        try {
            CallableStatement cst = objConn.getConn().prepareCall(query);
            cst.setInt(1, x.getIdDetail());
            cst.setInt(2, x.getQuantity());
            cst.setInt(3, x.getNeto());
            cst.setInt(4, x.getIdProduct());

            if (cst.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOTicketDetail.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;    
    }

    @Override
    public boolean update(TicketDetail x) {
        String query = "{call TICKET_DETAIL_tapi.upd(?,?,?,?)}";
        try {
            CallableStatement cst = objConn.getConn().prepareCall(query);
            cst.setInt(1, x.getIdDetail());
            cst.setInt(2, x.getQuantity());
            cst.setInt(3, x.getNeto());
            cst.setInt(4, x.getIdProduct());

            if (cst.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOTicketDetail.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;      
    }

    @Override
    public boolean delete(int idTicketDetail) {
        String query = "{call TICKET_DETAIL_tapi.del(?)}";
        try {
            CallableStatement callStatement = objConn.getConn().prepareCall(query);
            callStatement.setInt(1, idTicketDetail);

            if (callStatement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOTicketDetail.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;    
    }

    @Override
    public List<TicketDetail> select() {
        String query = "SELECT * FROM TICKET_DETAIL";
        ArrayList<TicketDetail> ticketDetails = null;
        try {
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            rs = ps.executeQuery();
            ticketDetails = new ArrayList<>();
            while (rs.next()) {
                ticketDetails.add(new TicketDetail(rs.getInt("ID_DETAIL"),
                        rs.getInt("ID_PRODUCT"),
                        rs.getInt("NETO"), rs.getInt("QUANTITY")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOTicketDetail.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return ticketDetails;      
    }

    @Override
    public TicketDetail selectById(int x) {
        String query = "SELECT * FROM TICKET WHERE ID_TICKET=?";
        TicketDetail ticketDetail = new TicketDetail();
        try {
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            rs = ps.executeQuery();
            
            ticketDetail.setIdDetail(rs.getInt("ID_DETAIL"));
            ticketDetail.setIdProduct(rs.getInt("ID_PRODUCT"));
            ticketDetail.setNeto(rs.getInt("NETO"));
            ticketDetail.setQuantity(rs.getInt("QUANTITY"));

        } catch (SQLException ex) {
            Logger.getLogger(DAOTicketDetail.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return ticketDetail;       
    }
    
}
