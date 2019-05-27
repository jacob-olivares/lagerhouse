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
public class Permission {
    private int idPermission;
    private String permissionName;

    public Permission() {
    }

    public Permission(int idPermission, String permissionName) {
        this.idPermission = idPermission;
        this.permissionName = permissionName;
    }

    public Permission(String permissionName) {
        this.permissionName = permissionName;
    }

    public int getIdPermission() {
        return idPermission;
    }

    public void setIdPermission(int idPermission) {
        this.idPermission = idPermission;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    @Override
    public String toString() {
        return "Permission{" + "idPermission=" + idPermission + ", permissionName=" + permissionName + '}';
    }
    
    
}
