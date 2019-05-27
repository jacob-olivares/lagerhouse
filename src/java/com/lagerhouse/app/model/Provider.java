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
public class Provider {
    private int idProvider, providerDni, providerPhone;
    private String providerName, providerAddress, providerMail;
    private char dvProviderDni;

    public Provider() {
    }

    public Provider(int idProvider, int providerDni, int providerPhone, String providerName, String providerAddress, String providerMail, char dvProviderDni) {
        this.idProvider = idProvider;
        this.providerDni = providerDni;
        this.providerPhone = providerPhone;
        this.providerName = providerName;
        this.providerAddress = providerAddress;
        this.providerMail = providerMail;
        this.dvProviderDni = dvProviderDni;
    }

    public Provider(int providerDni, int providerPhone, String providerName, String providerAddress, String providerMail, char dvProviderDni) {
        this.providerDni = providerDni;
        this.providerPhone = providerPhone;
        this.providerName = providerName;
        this.providerAddress = providerAddress;
        this.providerMail = providerMail;
        this.dvProviderDni = dvProviderDni;
    }

    public int getIdProvider() {
        return idProvider;
    }

    public void setIdProvider(int idProvider) {
        this.idProvider = idProvider;
    }

    public int getProviderDni() {
        return providerDni;
    }

    public void setProviderDni(int providerDni) {
        this.providerDni = providerDni;
    }

    public int getProviderPhone() {
        return providerPhone;
    }

    public void setProviderPhone(int providerPhone) {
        this.providerPhone = providerPhone;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderAddress() {
        return providerAddress;
    }

    public void setProviderAddress(String providerAddress) {
        this.providerAddress = providerAddress;
    }

    public String getProviderMail() {
        return providerMail;
    }

    public void setProviderMail(String providerMail) {
        this.providerMail = providerMail;
    }

    public char getDvProviderDni() {
        return dvProviderDni;
    }

    public void setDvProviderDni(char dvProviderDni) {
        this.dvProviderDni = dvProviderDni;
    }

    @Override
    public String toString() {
        return "Provider{" + "idProvider=" + idProvider + ", providerDni=" + providerDni + ", providerPhone=" + providerPhone + ", providerName=" + providerName + ", providerAddress=" + providerAddress + ", providerMail=" + providerMail + ", dvProviderDni=" + dvProviderDni + '}';
    }
}
