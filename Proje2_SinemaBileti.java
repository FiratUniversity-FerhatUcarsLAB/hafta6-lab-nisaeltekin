 * Ad Soyad: [Nisanur Eltekin]
 * Ogrenci No: [250541100]
 * Tarih: [26/11/2025]
 * Aciklama: Gorev 2 - Sinema Bileti

import java.util.Scanner;

public class SinemaBileti {

    // Gün hafta sonu mu? (6=Cmt, 7=Paz)
    public static boolean isWeekend(int gun) {
        if (gun < 1 || gun > 7) {
            System.out.println("Geçersiz gün! 1-7 arasında olmalı.");
            return false;
        }
        return gun == 6 || gun == 7;
    }

    // Seans matine mi? (08:00–23:00 arası)
    public static boolean isMatinee(int saat) {
        if (saat < 8 || saat > 23) {
            System.out.println("Geçersiz saat! Saat 8 ile 23 arasında olmalıdır.");
            return false;
        }
        if (saat < 12) {
            return true;
        } else {
            return false;
        }
    }

    // Temel bilet fiyatı hesaplama
    public static double calculateBasePrice(int gun, int saat) {
        boolean haftasonu = isWeekend(gun);
        boolean matinee = isMatinee(saat);

        if (!haftasonu && matinee)
            return 45;                   // Hafta içi matine
        if (!haftasonu)
            return 65;                   // Hafta içi normal
        if (haftasonu && matinee)
            return 55;                  // Hafta sonu matine
        return 85;                      // Hafta sonu normal
    }

    // İndirim oranı hesaplama
    public static double calculateDiscount(int yas, int meslek, int gun) {
        if (yas >= 65) return 0.30;   // 65 yaş üstü
        if (yas < 12) return 0.25;    // 12 yaş altı

        if (meslek < 1 || meslek > 3) {
            System.out.println("Geçersiz meslek kodu! Meslek 1, 2 veya 3 olmalıdır.");
            return 0.0; // hatalı girişte indirim uygulanmaz
        }

        // Meslek → 1=öğrenci 2=öğretmen 3=diğer
        switch (meslek) {
            case 1: // Öğrenci
                if (gun >= 1 && gun <= 4)
                    return 0.20; // Pazartesi–Perşembe
                    return 0.15; // Cuma–Pazar
            case 2: // Öğretmen
                if (gun == 3)
                    return 0.35; // Çarşamba
                    return 0.0;
            default:
                return 0.0;
        }
    }

    // Film formatına göre ek ücret
    public static double getFormatExtra(int filmTuru) {
        if (filmTuru < 1 || filmTuru > 4) {
            System.out.println("Geçersiz film türü! 1–4 arasında bir değer girilmelidir.");
            return 0; // Hatalı türde ek ücret uygulanmaz
        }
        switch (filmTuru) {
            case 1:
                return 0;      // 2D
            case 2:
                return 25;     // 3D
            case 3:
                return 35;     // IMAX
            case 4:
                return 50;     // 4DX
            default:
                return 0;
        }
    }

    // Toplam fiyat hesaplama
    public static double calculateFinalPrice(int gun, int saat, int yas, int meslek, int filmTuru) {
        double temelFiyat = calculateBasePrice(gun, saat);
        double indirimOrani = calculateDiscount(yas, meslek, gun);
        double indirimTutari = temelFiyat * indirimOrani;
        double indirimliFiyat = temelFiyat - indirimTutari;
        double ekUcret = getFormatExtra(filmTuru);
        return indirimliFiyat + ekUcret;
    }

    // Bilet bilgisi raporu oluşturma
    public static String generateTicketInfo(int gun, int saat, int yas, int meslek, int filmTuru) {
        double temelFiyat = calculateBasePrice(gun, saat);
        double indirimOrani = calculateDiscount(yas, meslek, gun);
        double indirimTutari = temelFiyat * indirimOrani;
        double indirimliFiyat = temelFiyat - indirimTutari;
        double sonFiyat = calculateFinalPrice(gun, saat, yas, meslek, filmTuru);

        return "\n----- BİLET BİLGİSİ -----\n"
                + "Temel Fiyat        : " + temelFiyat + " TL\n"
                + "İndirim Oranı      : %" + (indirimOrani * 100) + "\n"
                + "İndirim Tutarı     : " + indirimTutari + " TL\n"
                + "İndirimli Fiyat    : " + indirimliFiyat + " TL\n"
                + "Film Formatı Ekstra: " + getFormatExtra(filmTuru) + " TL\n"
                + "Toplam Fiyat       : " + sonFiyat + " TL\n";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Kullanıcıdan girişler alınıyor
        System.out.print("Gün Seç (1=Pzt ... 7=Paz): ");
        int gun = sc.nextInt();

        System.out.print("Saat (8-23): ");
        int saat = sc.nextInt();

        System.out.print("Yaş: ");
        int yas = sc.nextInt();

        System.out.print("Meslek (1=Öğrenci, 2=Öğretmen, 3=Diğer): ");
        int meslek = sc.nextInt();

        System.out.print("Film Türü (1=2D, 2=3D, 3=IMAX, 4=4DX): ");
        int filmTuru = sc.nextInt();
        
        // Bilet bilgisi ekrana yazdırılıyor
        System.out.println(generateTicketInfo(gun, saat, yas, meslek, filmTuru));
    }

}


