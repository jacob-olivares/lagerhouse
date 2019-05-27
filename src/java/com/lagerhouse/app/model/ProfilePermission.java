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
public class ProfilePermission {
    private int idProfile, idPermission;

    public ProfilePermission() {
    }

    public ProfilePermission(int idProfile, int idPermission) {
        this.idProfile = idProfile;
        this.idPermission = idPermission;
    }

    public int getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(int idProfile) {
        this.idProfile = idProfile;
    }

    public int getIdPermission() {
        return idPermission;
    }

    public void setIdPermission(int idPermission) {
        this.idPermission = idPermission;
    }

    @Override
    public String toString() {
        return "ProfilePermission{" + "idProfile=" + idProfile + ", idPermission=" + idPermission + '}';
    }
    
    
}
