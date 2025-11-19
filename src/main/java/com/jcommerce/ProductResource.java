package com.jcommerce;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    @GET
    public List<Product> getAllProducts() {
        // SQL: SELECT * FROM Product
        return com.jcommerce.Product.listAll();
    }

    @POST
    @Transactional // Veritabanına yazma işlemi olduğu için "Transaction" şart
    public Product addProduct(Product product) {
        // SQL: INSERT INTO Product ...
        product.persist();
        return product;
    }
}