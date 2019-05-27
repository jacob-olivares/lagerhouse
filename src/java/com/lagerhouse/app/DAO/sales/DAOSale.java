/*
 * Proyecto Lagerhouse para Portafolio de Título
 * Seccion 001V, Sede Maipú
 * Jacob Olivares Espinoza - 19.128.620-0
 */
package com.lagerhouse.app.DAO.sales;

import com.lagerhouse.app.DAO.CrudRepository;
import com.lagerhouse.app.DAO.connection.ConnectionDB;
import com.lagerhouse.app.model.Sale;
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
public class DAOSale implements CrudRepository<Sale> {

    private final ConnectionDB objConn = ConnectionDB.instanceConn();
    ResultSet rs;

    @Override
    public boolean insert(Sale x) {
        String query = "{call SALE_tapi.ins(?,?,?,?,?,?)}";
        try {
            CallableStatement cst = objConn.getConn().prepareCall(query);
            cst.setInt(1, x.getIdStatus());
            cst.setInt(2, x.getMountPaid());
            cst.setInt(3, x.getIdCustomer());
            cst.setInt(4, x.getIdUser());
            cst.setDate(5, new Date(x.getDateSale().getTime()));
            cst.setInt(6, x.getIdTicket());

            if (cst.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOSale.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;
    }

    @Override
    public boolean update(Sale x) {
        String query = "{call SALE_tapi.upd(?,?,?,?,?,?,?)}";
        try {
            CallableStatement cst = objConn.getConn().prepareCall(query);
            cst.setInt(1, x.getIdStatus());
            cst.setInt(2, x.getMountPaid());
            cst.setInt(3, x.getIdCustomer());
            cst.setInt(4, x.getIdSale());
            cst.setInt(5, x.getIdUser());
            cst.setDate(6, new Date(x.getDateSale().getTime()));
            cst.setInt(7, x.getIdTicket());

            if (cst.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOSale.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(DAOSale.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;
    }

    @Override
    public List<Sale> select() {
        String query = "SELECT * FROM SALE";
        ArrayList<Sale> sales = null;
        try {
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            rs = ps.executeQuery();
            sales = new ArrayList<>();
            while (rs.next()) {
                sales.add(new Sale(rs.getInt("ID_SALE"),
                        rs.getInt("ID_USER"),
                        rs.getInt("ID_TICKET"), rs.getInt("ID_CUSTOMER"),
                        rs.getInt("ID_STATUS"), rs.getInt("MOUNT_PAID"), rs.getDate("DATE_SALE")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOSale.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return sales;
    }

    @Override
    public Sale selectById(int x) {
        String query = "SELECT * FROM SALE WHERE ID_SALE=?";
        Sale sale = new Sale();
        try {
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            rs = ps.executeQuery();
            
            sale.setIdSale(rs.getInt("ID_SALE"));
            sale.setIdUser(rs.getInt("ID_USER"));
            sale.setIdTicket(rs.getInt("ID_TICKET"));
            sale.setIdCustomer(rs.getInt("ID_CUSTOMER"));
            sale.setIdStatus(rs.getInt("ID_STATUS"));
            sale.setMountPaid(rs.getInt("MOUNT_PAID"));
            sale.setDateSale(rs.getDate("DATE_SALE"));

        } catch (SQLException ex) {
            Logger.getLogger(DAOSale.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return sale;
    }

}
