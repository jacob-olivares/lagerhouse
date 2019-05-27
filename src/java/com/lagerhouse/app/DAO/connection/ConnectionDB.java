/*
 * Proyecto Lagerhouse para Portafolio de Título
 * Seccion 001V, Sede Maipú
 * Jacob Olivares Espinoza - 19.128.620-0
 */
package com.lagerhouse.app.DAO.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jacob Olivares Espinoza
 */
public class ConnectionDB {
    public static ConnectionDB InstConn;
    private Connection conn;

    private ConnectionDB() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1525:lagerhauss" , "jacob", "jacob123");
            
            if(conn!=null){
                System.out.println(conn);
            }else{
                System.out.println("not connect");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConnectionDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public synchronized static ConnectionDB instanceConn() {
        if (InstConn == null) {
            InstConn = new ConnectionDB();

        }
        return InstConn;
    }

    public Connection getConn() {
        return conn;
    }

    public void closeConnection() {
        InstConn = null;
    }
}
