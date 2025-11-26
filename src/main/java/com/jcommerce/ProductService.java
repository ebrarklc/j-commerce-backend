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

    @Transactional
    public Product urunGuncelle(Long id, Product yeniBilgiler){
        // adım 1 ürünü ıd ile bul
        Product mevcutUrun = Product.findById(id);

        // adım 2 eer ürün yoksa (null ise) hata fırlat
        if(mevcutUrun==null){
            throw new IllegalArgumentException("Ürün Bulunamadı! ID:" + id);
        }

        // adım 3 Bilgileri güncelle
        mevcutUrun.name = yeniBilgiler.name;
        mevcutUrun.price = yeniBilgiler.price;
        mevcutUrun.inStock = yeniBilgiler.inStock;

        return mevcutUrun;
    }

    @Transactional
    public void urunSil(Long id){
        // adım 1 silinecek ürün var mı kontrol et (tıpkı update daki gibi)
        boolean silindiMi = Product.deleteById(id);

        // adım 2 eğer silinmediyse (yani öyle bir ürün yoksa ) false döner
        if (!silindiMi){
            throw new IllegalArgumentException("Silinecek Ürün Bulunamadı! ID:" + id);
        }
    }

}
