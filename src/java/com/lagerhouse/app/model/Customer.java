/*
 * Proyecto Lagerhouse para Portafolio de Título
 * Seccion 001V, Sede Maipú
 * Jacob Olivares Espinoza - 19.128.620-0
 */
package com.lagerhouse.app.model;

import java.util.Date;

/**
 *
 * @author Jacob Olivares Espinoza
 */
public class Customer {
    private int idCustomer, dniCustomer, purchases;
    private char dv;
    private String customerName, customerLastName;
    private Date createDate;

    public Customer() {
    }

    //constructor para el insert a la base de datos
    public Customer(int dniCustomer, char dv, String customerName, String customerLastName, Date createDate) {
        this.dniCustomer = dniCustomer;
        this.dv = dv;
        this.customerName = customerName;
        this.customerLastName = customerLastName;
        this.createDate = createDate;
    }

    public Customer(int idCustomer, int dniCustomer, int purchases, char dv, String customerName, String customerLastName, Date createDate) {
        this.idCustomer = idCustomer;
        this.dniCustomer = dniCustomer;
        this.purchases = purchases;
        this.dv = dv;
        this.customerName = customerName;
        this.customerLastName = customerLastName;
        this.createDate = createDate;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getDniCustomer() {
        return dniCustomer;
    }

    public void setDniCustomer(int dniCustomer) {
        this.dniCustomer = dniCustomer;
    }

    public int getPurchases() {
        return purchases;
    }

    public void setPurchases(int purchases) {
        this.purchases = purchases;
    }

    public Character getDv() {
        return dv;
    }

    public void setDv(char dv) {
        this.dv = dv;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Customer{" + "idCustomer=" + idCustomer + ", dniCustomer=" + dniCustomer + ", purchases=" + purchases + ", dv=" + dv + ", customerName=" + customerName + ", customerLastName=" + customerLastName + ", createDate=" + createDate + '}';
    }
}
