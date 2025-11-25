package com.jcommerce;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class GlobalExceptionHandler implements ExceptionMapper<IllegalArgumentException> {

    @Override
    public Response toResponse(IllegalArgumentException exception) {
        // ADIM 4: Hatadan mesajı çek
        String mesaj = exception.getMessage();

        // ADIM 5: Yukarıda yazdığın ErrorResponse sınıfından yeni bir kutu oluştur
        ErrorResponse cevapKutusu = new ErrorResponse("Hata Oluştu", mesaj);

        // ADIM 6: 400 Bad Request damgasıyla gönder
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(cevapKutusu)
                .build();
    }


    public static class ErrorResponse {
        // ADIM 1: Değişkenleri burada tanımla (title ve details)
        public String title;
        public String details; // Diğer değişkenin adı ne?

        public ErrorResponse(String title, String details) {
            // ADIM 2: Eşleştirmeyi yap
            this.title = title;
            this.details = details; // Neyi neye eşitleyeceğiz?
        }
    }
}