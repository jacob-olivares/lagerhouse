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
public class Order {
    private int idOrder, idProvider, idDetailOrder, idStatus;

    public Order() {
    }

    public Order(int idOrder, int idProvider, int idDetailOrder, int idStatus) {
        this.idOrder = idOrder;
        this.idProvider = idProvider;
        this.idDetailOrder = idDetailOrder;
        this.idStatus = idStatus;
    }

    public Order(int idProvider, int idDetailOrder, int idStatus) {
        this.idProvider = idProvider;
        this.idDetailOrder = idDetailOrder;
        this.idStatus = idStatus;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdProvider() {
        return idProvider;
    }

    public void setIdProvider(int idProvider) {
        this.idProvider = idProvider;
    }

    public int getIdDetailOrder() {
        return idDetailOrder;
    }

    public void setIdDetailOrder(int idDetailOrder) {
        this.idDetailOrder = idDetailOrder;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    @Override
    public String toString() {
        return "Order{" + "idOrder=" + idOrder + ", idProvider=" + idProvider + ", idDetailOrder=" + idDetailOrder + ", idStatus=" + idStatus + '}';
    }
}
