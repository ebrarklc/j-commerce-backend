package com.jcommerce;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.annotation.security.RolesAllowed; // <-- KİLİT KÜTÜPHANESİ

import java.util.List;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {

    @Inject
    ProductService service;

    // VİTRİN: Herkese Açık (Kilit Yok)
    @GET
    public List<Product> getAllProducts() {
        return service.tumUrunleriGetir();
    }

    // DEPO GİRİŞİ: Sadece Admin (Kilitli) 🔒
    @POST
    @RolesAllowed("admin")
    public Product addProduct(Product product) {
        service.urunEkle(product);
        return product;
    }

    // DEPO GİRİŞİ: Sadece Admin (Kilitli) 🔒
    @PUT
    @Path("/{id}")
    @RolesAllowed("admin")
    public Product updateProduct(@PathParam("id") Long id, Product product) {
        return service.urunGuncelle(id, product);
    }

    // DEPO GİRİŞİ: Sadece Admin (Kilitli) 🔒
    @DELETE
    @Path("/{id}")
    @RolesAllowed("admin")
    public Response deleteProduct(@PathParam("id") Long id) {
        service.urunSil(id);
        return Response.ok("Ürün Başarıyla Silindi! 🚀").build();
    }
}