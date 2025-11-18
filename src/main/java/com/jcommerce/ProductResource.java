package com.jcommerce;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/products") // tarayıcıda bu adrese gidince çalışır
public class ProductResource {

    @GET // veri isteme metodu
    @Produces(MediaType.APPLICATION_JSON) // cevabı json formatında ver
    public List<product> getALLProducts(){
        // sanki veritabanından çekiyormuşuz gibi sahte bir liste yapalım
        List<product> products = new ArrayList<>();

        // listeye ürün ekleyelim
        products.add(new product(1L, "Laptop",25000.0, true));
        products.add(new product(2L,"Mouse",500.0, true));
        products.add(new product(3L, "Klavye",1200.0,false)); // stokta yok

        return products;// quarkus bunu otomatik json a çevirir

    }
}
