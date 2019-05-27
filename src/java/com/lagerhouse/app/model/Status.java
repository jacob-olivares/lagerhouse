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
public class Status {
    private int idStatus;
    private String statusName;

    public Status() {
    }

    public Status(int idStatus, String statusName) {
        this.idStatus = idStatus;
        this.statusName = statusName;
    }

    public Status(String statusName) {
        this.statusName = statusName;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idStatus) {
        this.idStatus = idStatus;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @Override
    public String toString() {
        return "Status{" + "idStatus=" + idStatus + ", statusName=" + statusName + '}';
    }
}
