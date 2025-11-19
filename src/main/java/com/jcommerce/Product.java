package com.jcommerce;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity // Bu artık veritabanında bir TABLO!
public class Product extends PanacheEntity {

    // ID tanımlamaya gerek yok, PanacheEntity otomatik halleder.

    public String name;
    public double price;
    public boolean inStock;

    // Boş constructor şart
    public Product() {}

    public Product(String name, double price, boolean inStock) {
        this.name = name;
        this.price = price;
        this.inStock = inStock;
    }
}