/*
 * Proyecto Lagerhouse para Portafolio de Título
 * Seccion 001V, Sede Maipú
 * Jacob Olivares Espinoza - 19.128.620-0
 */
package com.lagerhouse.app.DAO.sales;

import com.lagerhouse.app.DAO.CrudRepository;
import com.lagerhouse.app.DAO.connection.ConnectionDB;
import com.lagerhouse.app.model.Customer;
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
public class DAOCustomer implements CrudRepository<Customer> {

    private final ConnectionDB objConn = ConnectionDB.instanceConn();
    ResultSet rs;

    @Override
    public boolean insert(Customer x) {
        String query = "{call CUSTOMER_tapi.ins(?,?,?,?,?)}";
        try {
            CallableStatement cst = objConn.getConn().prepareCall(query);
            cst.setInt(1, x.getDniCustomer());
            cst.setString(2, x.getCustomerName());
            cst.setDate(3, new Date(x.getCreateDate().getTime()));
            cst.setString(4, x.getCustomerLastName());
            cst.setString(5, Character.toString(x.getDv()));

            if (cst.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;
    }

    @Override
    public boolean update(Customer x) {
        String query = "{call CUSTOMER_tapi.upd(?,?,?,?,?,?,?)}";
        try {
            CallableStatement cst = objConn.getConn().prepareCall(query);
            cst.setInt(1, x.getDniCustomer());
            cst.setString(2, x.getCustomerName());
            cst.setDate(3, new Date(x.getCreateDate().getTime()));
            cst.setInt(4, x.getIdCustomer());
            cst.setInt(5, x.getPurchases());
            cst.setString(6, x.getCustomerLastName());
            cst.setString(7, Character.toString(x.getDv()));

            if (cst.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;
    }

    @Override
    public boolean delete(int x) {
        String query = "{call CUSTOMER_tapi.del(?)}";
        try {
            CallableStatement callStatement = objConn.getConn().prepareCall(query);
            callStatement.setInt(1, x);

            if (callStatement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return false;
    }

    @Override
    public List<Customer> select() {
        String query = "SELECT * FROM CUSTOMER";
        ArrayList<Customer> customers = null;
        try {
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            rs = ps.executeQuery();
            customers = new ArrayList<>();
            while (rs.next()) {
                customers.add(new Customer(rs.getInt("ID_CUSTOMER"),
                        rs.getInt("DNI_CUSTOMER"),
                        rs.getInt("PURCHASES"), rs.getString("DV_DNI_CUSTOMER").charAt(0),
                        rs.getString("CUSTOMER_NAME"), rs.getString("LAST_NAME"),
                        rs.getDate("CREATED_DATE")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return customers;
    }

    @Override
    public Customer selectById(int x) {
        String query = "SELECT * FROM CUSTOMER WHERE ID_CUSTOMER=?;";
        Customer customer = new Customer();
        try {
            PreparedStatement ps = objConn.getConn().prepareStatement(query);
            ps.setInt(1, x);
            rs = ps.executeQuery();

            customer.setIdCustomer(rs.getInt("ID_CUSTOMER"));
            customer.setDniCustomer(rs.getInt("DNI_CUSTOMER"));
            customer.setPurchases(rs.getInt("PURCHASES"));
            customer.setDv(rs.getString("DV_DNI_CUSTOMER").charAt(0));
            customer.setCustomerName(rs.getString("CUSTOMER_NAME"));
            customer.setCreateDate(rs.getDate("CREATE_DATE"));

        } catch (SQLException ex) {
            Logger.getLogger(DAOCustomer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            objConn.closeConnection();
        }
        return customer;
    }

}
