package com.jcommerce;

// Bu sınıf, bir ürünün şablonudur.
public class product {

    public Long id; //ürün Idsi
    public String name; //ürün adı
    public double price; //fiyatı
    public boolean inStock; //stokta var mı

    // boş constructor (quarkusun jason çevrimi için gereklidir)
    public product() {
    }

    //kolayca nesne üretmek için dolu constructor (Temel olarak bir sınıfın (class) örneği oluşturulduğunda çalışan özel bir metottur.)
    public product(Long id, String name, double price, boolean inStock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inStock = inStock;
    }
}

