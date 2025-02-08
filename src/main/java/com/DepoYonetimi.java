package com;

import java.util.*;

public class DepoYonetimi {
    private Map<Integer, Urun> urunler;
    private int sonId;

    public DepoYonetimi() {
        this.urunler = new HashMap<>();
        this.sonId = 1000;
    }

    public void urunTanimlama(String urunIsmi, String uretici, String birim) {
        Urun yeniUrun = new Urun(sonId, urunIsmi, uretici, birim);
        urunler.put(sonId, yeniUrun);
        System.out.println("Ürün başarıyla tanımlandı. ID: " + sonId);
        sonId++;
    }

    public void urunListele() {
        System.out.println("\nid        ismi       ureticisi       miktari       birimi       raf");
        System.out.println("--------------------------------------------------------------------");
        for (Urun urun : urunler.values()) {
            System.out.printf("%-10d %-10s %-15s %-13d %-12s %s%n",
                    urun.getId(),
                    urun.getUrunIsmi(),
                    urun.getUretici(),
                    urun.getMiktar(),
                    urun.getBirim(),
                    urun.getRaf());
        }
    }

    public void urunGirisi(int id, int miktar) {
        if (urunler.containsKey(id)) {
            Urun urun = urunler.get(id);
            urun.setMiktar(urun.getMiktar() + miktar);
            System.out.println("Ürün girişi başarılı. Yeni miktar: " + urun.getMiktar());
        } else {
            System.out.println("Ürün bulunamadı!");
        }
    }

    public void urunuRafaKoy(int id, String raf) {
        if (urunler.containsKey(id)) {
            Urun urun = urunler.get(id);
            urun.setRaf(raf);
            System.out.println("Ürün rafa yerleştirildi.");
        } else {
            System.out.println("Ürün bulunamadı!");
        }
    }

    public void urunCikisi(int id, int miktar) {
        if (urunler.containsKey(id)) {
            Urun urun = urunler.get(id);
            if (urun.getMiktar() >= miktar) {
                urun.setMiktar(urun.getMiktar() - miktar);
                System.out.println("Ürün çıkışı başarılı. Kalan miktar: " + urun.getMiktar());
            } else {
                System.out.println("Yetersiz stok! Mevcut miktar: " + urun.getMiktar());
            }
        } else {
            System.out.println("Ürün bulunamadı!");
        }
    }
}