-- ID: 1, Kullanıcı: admin, Şifre: admin123, Rol: admin
INSERT INTO users (id, username, password, role) VALUES (1, 'admin', 'admin123', 'admin');

-- Sequence (Sayaç) hatası almamak için sayacı 2'den başlat diyoruz
ALTER SEQUENCE users_seq RESTART WITH 2;