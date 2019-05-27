/*
 * Proyecto Lagerhouse para Portafolio de Título
 * Seccion 001V, Sede Maipú
 * Jacob Olivares Espinoza - 19.128.620-0
 */
package com.lagerhouse.app.DAO.sales;

import com.lagerhouse.app.DAO.CrudRepository;
import com.lagerhouse.app.DAO.connection.ConnectionDB;
import com.lagerhouse.app.model.Ticket;
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
public class DAOTicket implements CrudRepository<Ticket> {

    private final ConnectionDB objConn = ConnectionDB.instanceConn();
    ResultSet rs;

    @Override
    public boolean insert(Ticket x) {
        String query = "{call TICKET_tapi.ins(?,?,?)}";
        try {
            CallableStatement cst = objConn.getConn().prepareCall(query);
            cst.setInt(1, x.getIdDetail());
            cst.setDate(2, new Date(x.getDateTicket().getTime()));
            cst.setInt(3, x.getMount());

            if (cst.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOTicket.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;
    }

    @Override
    public boolean update(Ticket x) {
        String query = "{call TICKET_tapi.upd(?,?,?,?)}";
        try {
            CallableStatement cst = objConn.getConn().prepareCall(query);
            cst.setInt(1, x.getIdDetail());
            cst.setDate(2, new Date(x.getDateTicket().getTime()));
            cst.setInt(3, x.getMount());
            cst.setInt(4, x.getIdTicket());

            if (cst.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOTicket.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;
    }

    @Override
    public boolean delete(int x) {
        String query = "{call TICKET_tapi.del(?)}";
        try {
            CallableStatement callStatement = objConn.getConn().prepareCall(query);
            callStatement.setInt(1, x);

            if (callStatement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOTicket.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;
    }

    @Override
    public List<Ticket> select() {
        String query = "SELECT * FROM TICKET";
        ArrayList<Ticket> tickets = null;
        try {
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            rs = ps.executeQuery();
            tickets = new ArrayList<>();
            while (rs.next()) {
                tickets.add(new Ticket(rs.getInt("ID_TICKET"),
                        rs.getInt("MOUNT"),
                        rs.getInt("ID_DETAIL"), rs.getDate("DATE_TICKET")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOTicket.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return tickets;    
    }

    @Override
    public Ticket selectById(int x) {
        String query = "SELECT * FROM TICKET WHERE ID_TICKET=?";
        Ticket ticket = new Ticket();
        try {
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            rs = ps.executeQuery();
            
            ticket.setIdDetail(rs.getInt("ID_DETAIL"));
            ticket.setDateTicket(rs.getDate("DATE_TICKET"));
            ticket.setMount(rs.getInt("MOUNT"));
            ticket.setIdTicket(rs.getInt("ID_TICKET"));

        } catch (SQLException ex) {
            Logger.getLogger(DAOTicket.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return ticket;    
    }

}
