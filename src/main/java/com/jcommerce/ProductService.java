package com.jcommerce;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;


@ApplicationScoped // bu bir notasyon ve notasyonlar etiket gibidir örneğin bir kutunun ne içeridğini söylemek için etiketi
// kutunun içine atmazsın kutunun üzerinde yapıştırırsın
// kodumuzdaki mantıkta da public class ın tepesine yazarız
public class ProductService {

    // 1. metot tüm ürünleri getir
    public List<Product> tumUrunleriGetir(){
        return com.jcommerce.Product.listAll();
    }

    // 2. metot ürün ekle
    @Transactional
    public void urunEkle(Product yeniUrun){
        if (yeniUrun.price < 0){
            throw new IllegalArgumentException("Fiyat Negatif olamaz!");
        }
        yeniUrun.persist();
        //KÜÇÜK BİR BİLGİ (RAM vs DİSK)
        //Add (Ekle): Genelde geçici hafızaya (RAM) ekler. Bilgisayar kapanınca uçar gider.
        //Persist (Kalıcı Yap / Sürdür): Bu kelime İngilizce "Persistence"dan gelir. "Kalıcı hale getirmek" demektir. Veriyi RAM'den alır, veritabanının diskine çiviler.
        //O yüzden Panache kütüphanesinde komutumuz: .persist()

    }
}
