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
public class Sale {
    private int idSale, idUser, idTicket, idCustomer, idStatus, mountPaid;
    private Date dateSale;

    public Sale() {
    }

    public Sale(int idSale, int idUser, int idTicket, int idCustomer, int idStatus, int mountPaid, Date dateSale) {
        this.idSale = idSale;
        this.idUser = idUser;
        this.idTicket = idTicket;
        this.idCustomer = idCustomer;
        this.idStatus = idStatus;
        this.mountPaid = mountPaid;
        this.dateSale = dateSale;
    }

    public Sale(int idUser, int idTicket, int idCustomer, int idStatus, int mountPaid, Date dateSale) {
        this.idUser = idUser;
        this.idTicket = idTicket;
        this.idCustomer = idCustomer;
        this.idStatus = idStatus;
        this.mountPaid = mountPaid;
        this.dateSale = dateSale;
    }

    public int getIdSale() {
        return idSale;
    }

    public void setIdSale(int idSale) {
        this.idSale = idSale;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public int getMountPaid() {
        return mountPaid;
    }

    public void setMountPaid(int mountPaid) {
        this.mountPaid = mountPaid;
    }

    public Date getDateSale() {
        return dateSale;
    }

    public void setDateSale(Date dateSale) {
        this.dateSale = dateSale;
    }

    @Override
    public String toString() {
        return "Sale{" + "idSale=" + idSale + ", idUser=" + idUser + ", idTicket=" + idTicket + ", idCustomer=" + idCustomer + ", idStatus=" + idStatus + ", mountPaid=" + mountPaid + ", dateSale=" + dateSale + '}';
    }
}
