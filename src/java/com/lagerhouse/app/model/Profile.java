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
public class Profile {
    private int idProfile;
    private String profileName;

    public Profile() {
    }

    public Profile(int idProfile, String profileName) {
        this.idProfile = idProfile;
        this.profileName = profileName;
    }

    public Profile(String profileName) {
        this.profileName = profileName;
    }

    public int getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(int idProfile) {
        this.idProfile = idProfile;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    @Override
    public String toString() {
        return "Profile{" + "idProfile=" + idProfile + ", profileName=" + profileName + '}';
    }
    
    
}
