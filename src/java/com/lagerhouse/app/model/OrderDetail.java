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
public class OrderDetail {
    private int idOrderDetail, idProduct, quantity, neto;

    public OrderDetail(int idOrderDetail, int idProduct, int quantity, int neto) {
        this.idOrderDetail = idOrderDetail;
        this.idProduct = idProduct;
        this.quantity = quantity;
        this.neto = neto;
    }

    public OrderDetail() {
    }

    public int getIdOrderDetail() {
        return idOrderDetail;
    }

    public void setIdOrderDetail(int idOrderDetail) {
        this.idOrderDetail = idOrderDetail;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getNeto() {
        return neto;
    }

    public void setNeto(int neto) {
        this.neto = neto;
    }

    @Override
    public String toString() {
        return "OrderDetail{" + "idOrderDetail=" + idOrderDetail + ", idProduct=" + idProduct + ", quantity=" + quantity + ", neto=" + neto + '}';
    }
    
    
}
