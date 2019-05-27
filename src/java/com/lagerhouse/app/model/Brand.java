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
public class Brand {
    private int idBrand;
    private String nameBrand;

    public Brand() {
    }


    public Brand(int idBrand, String nameBrand) {
        this.idBrand = idBrand;
        this.nameBrand = nameBrand;
    }
    
    //Constructor para insert
    public Brand(String nameBrand) {
        this.nameBrand = nameBrand;
    }
    public int getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(int idBrand) {
        this.idBrand = idBrand;
    }

    public String getNameBrand() {
        return nameBrand;
    }

    public void setNameBrand(String nameBrand) {
        this.nameBrand = nameBrand;
    }

    @Override
    public String toString() {
        return "Brand{" + "idBrand=" + idBrand + ", nameBrand=" + nameBrand + '}';
    }
    
}
