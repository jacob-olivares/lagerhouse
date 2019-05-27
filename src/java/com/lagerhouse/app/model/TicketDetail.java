/*
 * Proyecto Lagerhouse para Portafolio de Título
 * Seccion 001V, Sede Maipú
 * Jacob Olivares Espinoza - 19.128.620-0
 */
package com.lagerhouse.app.model;

/**
 *
 * @author Jacob Olivares Espinoza
 */
public class TicketDetail {
    private int idDetail, idProduct, neto, quantity;

    public TicketDetail() {
    }
    
    public TicketDetail(int idDetail, int idProduct, int neto, int quantity) {
        this.idDetail = idDetail;
        this.idProduct = idProduct;
        this.neto = neto;
        this.quantity = quantity;
    }

    public int getIdDetail() {
        return idDetail;
    }

    public void setIdDetail(int idDetail) {
        this.idDetail = idDetail;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getNeto() {
        return neto;
    }

    public void setNeto(int neto) {
        this.neto = neto;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "TicketDetail{" + "idDetail=" + idDetail + ", idProduct=" + idProduct + ", neto=" + neto + ", quantity=" + quantity + '}';
    }
    
    
}
