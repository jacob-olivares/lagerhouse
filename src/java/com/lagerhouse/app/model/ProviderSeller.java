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
public class ProviderSeller {
    private int idProviderSeller, sellerPhone, idProvider;
    private String sellerName, sellerMail;

    public ProviderSeller() {
    }

    public ProviderSeller(int idProviderSeller, int sellerPhone, int idProvider, String sellerName, String sellerMail) {
        this.idProviderSeller = idProviderSeller;
        this.sellerPhone = sellerPhone;
        this.idProvider = idProvider;
        this.sellerName = sellerName;
        this.sellerMail = sellerMail;
    }

    public ProviderSeller(int sellerPhone, int idProvider, String sellerName, String sellerMail) {
        this.sellerPhone = sellerPhone;
        this.idProvider = idProvider;
        this.sellerName = sellerName;
        this.sellerMail = sellerMail;
    }

    public int getIdProviderSeller() {
        return idProviderSeller;
    }

    public void setIdProviderSeller(int idProviderSeller) {
        this.idProviderSeller = idProviderSeller;
    }

    public int getSellerPhone() {
        return sellerPhone;
    }

    public void setSellerPhone(int sellerPhone) {
        this.sellerPhone = sellerPhone;
    }

    public int getIdProvider() {
        return idProvider;
    }

    public void setIdProvider(int idProvider) {
        this.idProvider = idProvider;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerMail() {
        return sellerMail;
    }

    public void setSellerMail(String sellerMail) {
        this.sellerMail = sellerMail;
    }

    @Override
    public String toString() {
        return "ProviderSeller{" + "idProviderSeller=" + idProviderSeller + ", sellerPhone=" + sellerPhone + ", idProvider=" + idProvider + ", sellerName=" + sellerName + ", sellerMail=" + sellerMail + '}';
    }
    
    
}
