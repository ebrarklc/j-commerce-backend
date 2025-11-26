package com.jcommerce;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

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

    // GÜNCELLEME ENDPOINT'İ
    @PUT
    @Path("/{id}")
    public Product updateProduct(@PathParam("id") Long id, Product product) {
        // Servisi çağır ve sonucu dön
        return service.urunGuncelle(id, product);
    }

    @DELETE
    @Path("/{id}")
    // 1. Değişiklik: 'void' yerine 'Response' yaz
    public Response deleteProduct(@PathParam("id") Long id) {

        service.urunSil(id); // İşlem aynı kalıyor

        // 2. Değişiklik: Kullanıcıya mesaj dön
        // Response.ok(...) içine istediğin mesajı yazabilirsin
        return Response.ok("Ürün Başarıyla Silindi! 🚀").build();
    }
}