/*
 * Proyecto Lagerhouse para Portafolio de Título
 * Seccion 001V, Sede Maipú
 * Jacob Olivares Espinoza - 19.128.620-0
 */
package com.lagerhouse.app.model;

import java.util.Date;

/**
 *
 * @author Jacob Olivares Espinoza
 */
public class Product {
    private int idProduct, idSubCategory, idBrand, barcode, price, stock, minStock, idProvider;
    private String productName;
    private Date expirationDate;

    public Product() {
    }

    
    public Product(int idProduct, int idSubCategory, int idBrand, int barcode, int price, 
            int stock, int minStock, String productName, Date expirationDate, int idProvider) {
        this.idProduct = idProduct;
        this.idSubCategory = idSubCategory;
        this.idBrand = idBrand;
        this.barcode = barcode;
        this.price = price;
        this.stock = stock;
        this.minStock = minStock;
        this.productName = productName;
        this.expirationDate = expirationDate;
        this.idProvider = idProvider;
    }

    public Product(int idSubCategory, int idBrand, int barcode, int price, int stock
            , int minStock, String productName, Date expirationDate, int idProvider) {
        this.idSubCategory = idSubCategory;
        this.idBrand = idBrand;
        this.barcode = barcode;
        this.price = price;
        this.stock = stock;
        this.minStock = minStock;
        this.productName = productName;
        this.expirationDate = expirationDate;
        this.idProvider = idProvider;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdSubCategory() {
        return idSubCategory;
    }

    public void setIdSubCategory(int idSubCategory) {
        this.idSubCategory = idSubCategory;
    }

    public int getIdBrand() {
        return idBrand;
    }

    public void setIdBrand(int idBrand) {
        this.idBrand = idBrand;
    }

    public int getBarcode() {
        return barcode;
    }

    public void setBarcode(int barcode) {
        this.barcode = barcode;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getMinStock() {
        return minStock;
    }

    public void setMinStock(int minStock) {
        this.minStock = minStock;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getIdProvider() {
        return idProvider;
    }

    public void setIdProvider(int idProvider) {
        this.idProvider = idProvider;
    }

    @Override
    public String toString() {
        return "Product{" + "idProduct=" + idProduct + ", idSubCategory=" + idSubCategory + ", idBrand=" + idBrand + ", barcode=" + barcode + ", price=" + price + ", stock=" + stock + ", minStock=" + minStock + ", idProvider=" + idProvider + ", productName=" + productName + ", expirationDate=" + expirationDate + '}';
    }
    
    
    
}
