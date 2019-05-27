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
public class SubCategory {
    private int idSubCategory, idCategory;
    private String subCategoryName;

    public SubCategory() {
    }

    public SubCategory(int idSubCategory, int idCategory, String subCategoryName) {
        this.idSubCategory = idSubCategory;
        this.idCategory = idCategory;
        this.subCategoryName = subCategoryName;
    }

    public SubCategory(int idCategory, String subCategoryName) {
        this.idCategory = idCategory;
        this.subCategoryName = subCategoryName;
    }

    public int getIdSubCategory() {
        return idSubCategory;
    }

    public void setIdSubCategory(int idSubCategory) {
        this.idSubCategory = idSubCategory;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getSubCategoryName() {
        return subCategoryName;
    }

    public void setSubCategoryName(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    @Override
    public String toString() {
        return "SubCategory{" + "idSubCategory=" + idSubCategory + ", idCategory=" + idCategory + ", subCategoryName=" + subCategoryName + '}';
    }

}
