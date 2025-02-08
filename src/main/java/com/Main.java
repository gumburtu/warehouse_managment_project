package com;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DepoYonetimi depo = new DepoYonetimi();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== DEPO YÖNETİM SİSTEMİ ===");
            System.out.println("1. Ürün Tanımla");
            System.out.println("2. Ürün Listele");
            System.out.println("3. Ürün Girişi");
            System.out.println("4. Ürünü Rafa Koy");
            System.out.println("5. Ürün Çıkışı");
            System.out.println("6. Çıkış");
            System.out.print("Seçiminiz: ");

            int secim = scanner.nextInt();
            scanner.nextLine(); // Buffer temizleme

            switch (secim) {
                case 1:
                    System.out.print("Ürün İsmi: ");
                    String urunIsmi = scanner.nextLine();
                    System.out.print("Üretici: ");
                    String uretici = scanner.nextLine();
                    System.out.print("Birim: ");
                    String birim = scanner.nextLine();
                    depo.urunTanimlama(urunIsmi, uretici, birim);
                    break;

                case 2:
                    depo.urunListele();
                    break;

                case 3:
                    System.out.print("Ürün ID: ");
                    int giriId = scanner.nextInt();
                    System.out.print("Miktar: ");
                    int giriMiktar = scanner.nextInt();
                    depo.urunGirisi(giriId, giriMiktar);
                    break;

                case 4:
                    System.out.print("Ürün ID: ");
                    int rafId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Raf: ");
                    String raf = scanner.nextLine();
                    depo.urunuRafaKoy(rafId, raf);
                    break;

                case 5:
                    System.out.print("Ürün ID: ");
                    int cikisId = scanner.nextInt();
                    System.out.print("Miktar: ");
                    int cikisMiktar = scanner.nextInt();
                    depo.urunCikisi(cikisId, cikisMiktar);
                    break;

                case 6:
                    System.out.println("Program sonlandırılıyor...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Geçersiz seçim!");
            }
        }
    }
}//v1