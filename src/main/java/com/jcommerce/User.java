package com.jcommerce;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.security.jpa.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
@UserDefinition
public class User extends PanacheEntity { // <-- EKLENDİ: extends PanacheEntity

    @Username
    public String username;

    @Password
    public String password;

    @Roles
    public String role;

    // Kullanıcı eklemek için kolay bir metod (Constructor)
    public static void add(String username, String password, String role) {
        User user = new User();
        user.username = username;
        user.password = password; // Gerçek hayatta şifrelenmeli (bcrypt) ama şimdilik düz yapalım
        user.role = role;
        user.persist();
    }
}