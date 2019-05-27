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
public class Ticket {
    private int idTicket, mount, idDetail;
    private Date dateTicket;

    public Ticket() {
    }

    public Ticket(int idTicket, int mount, int idDetail, Date dateTicket) {
        this.idTicket = idTicket;
        this.mount = mount;
        this.idDetail = idDetail;
        this.dateTicket = dateTicket;
    }

    public Ticket(int mount, int idDetail, Date dateTicket) {
        this.mount = mount;
        this.idDetail = idDetail;
        this.dateTicket = dateTicket;
    }

    public int getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(int idTicket) {
        this.idTicket = idTicket;
    }

    public int getMount() {
        return mount;
    }

    public void setMount(int mount) {
        this.mount = mount;
    }

    public int getIdDetail() {
        return idDetail;
    }

    public void setIdDetail(int idDetail) {
        this.idDetail = idDetail;
    }

    public Date getDateTicket() {
        return dateTicket;
    }

    public void setDateTicket(Date dateTicket) {
        this.dateTicket = dateTicket;
    }

    @Override
    public String toString() {
        return "Ticket{" + "idTicket=" + idTicket + ", mount=" + mount + ", idDetail=" + idDetail + ", dateTicket=" + dateTicket + '}';
    }
}
