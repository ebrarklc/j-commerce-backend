package com.jcommerce;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    @Inject
    ProductService service;

    @GET
    public List<Product> getAllProducts() {
        return service.tumUrunleriGetir();
    }

    @POST
    public Product addProduct(Product product) {
        service.urunEkle(product);
        return product;
    }
}