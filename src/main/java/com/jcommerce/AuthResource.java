package com.jcommerce;

import io.smallrye.jwt.build.Jwt;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.HashSet;
import java.util.Arrays;

@Path("/auth")
public class AuthResource {

    @POST
    @Path("/login")
    @Produces(MediaType.TEXT_PLAIN) // Geriye sadece Token (yazı) döneceğiz
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(LoginRequest request) {

        // 1. Veritabanından Kullanıcıyı Bul
        // "username" alanında, gelen request.username değerini ara
        User user = User.find("username", request.username).firstResult();

        // 2. Kullanıcı Var mı ve Şifre Doğru mu?
        if (user == null || !user.password.equals(request.password)) {
            // Dün yazdığımız GlobalExceptionHandler bunu yakalayıp 400 dönecek
            throw new IllegalArgumentException("Kullanıcı adı veya şifre hatalı!");
        }

        // 3. Her şey doğruysa TOKEN (Kart) Bas!
        String token = Jwt.issuer("https://jcommerce.com") // Kartı basan kurum
                .upn(user.username) // Kart sahibinin adı
                .groups(new HashSet<>(Arrays.asList(user.role))) // Yetkisi (Admin/User)
                .expiresIn(3600) // Kartın ömrü (3600 saniye = 1 saat)
                .sign(); // İmzala ve mühürle

        return Response.ok(token).build();
    }
}