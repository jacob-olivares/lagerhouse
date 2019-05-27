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
public class User {
    private int idUser, idProfile;
    private String username, password;

    public User() {
    }

    public User(int idUser, int idProfile, String username, String password) {
        this.idUser = idUser;
        this.idProfile = idProfile;
        this.username = username;
        this.password = password;
    }
        
    public User(int idProfile, String username, String password) {
        this.idProfile = idProfile;
        this.username = username;
        this.password = password;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(int idProfile) {
        this.idProfile = idProfile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "idUser=" + idUser + ", idProfile=" + idProfile + ", username=" + username + ", password=" + password + '}';
    }
}
