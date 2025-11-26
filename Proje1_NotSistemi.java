 * Ad Soyad: [Nisanur Eltekin]
 * Ogrenci No: [250541100]
 * Tarih: [26/11/2025]
 * Aciklama: Gorev 1 - Not Sistemi

   import java.util.Scanner;

public class NotSistemi {

    // Ortalama hesaplama (vize %30, final %40, ödev %30)
    public static double calculateAverage(int vize_notu, int final_notu, int odev_notu){
        double ortalama = vize_notu * 0.3 + final_notu * 0.4 + odev_notu * 0.3;
        return ortalama;
    }

    // Geçme durumu kontrolü (ortalama >= 50 ise geçer)
    public static boolean isPassingGrade(double ortalama){
        if (ortalama >= 50){
            return true;
        }else{
            return false;
        }
    }

    // Harf notu belirleme
    public static String getLetterGrade(double ortalama){
        String harf_notu = "";
        if (ortalama >=90 && ortalama <=100){
            return "A";
        }else if(ortalama >=80 && ortalama <=89){
            return "B";
        }else if(ortalama >=70 && ortalama <=79){
            return "C";
        }else if(ortalama >=60 && ortalama <=69){
            return "D";
        }else { //60dan küçük ise;
            return "F";
        }
    }

    // Onur listesi kontrolü (ortalama >=85 ve tüm notlar >=70)
    public static boolean isHonorList(double ortalama, int vize_notu, int final_notu, int odev_notu){
        if (ortalama >= 85 && vize_notu >=70 && final_notu >=70 && odev_notu >=70){
            return true;
        }else  {
            return false;
        }
    }

    // Bütünleme hakkı kontrolü (ortalama 40–49 arası)
    public static boolean hasRetakeRight(double ortalama){
        if (ortalama >= 40 && ortalama <50){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner =  new Scanner(System.in);

        // Kullanıcıdan notları al
        int vize_notu, final_notu, odev_notu;
        System.out.print("Vize notunu girin:");
        vize_notu = scanner.nextInt();
        System.out.print("Final notunu girin:");
        final_notu = scanner.nextInt();
        System.out.print("Ödev notunu girin:");
        odev_notu = scanner.nextInt();

        // Sonuçları ekrana yazdır
        System.out.println("\n=== OGRENCİ NOT RAPORU === ");
        System.out.println("Vize Notu   : " +vize_notu);
        System.out.println("Final Notu  : " +final_notu);
        System.out.println("Ödev Notu   : " +odev_notu);
        System.out.println("-------------------");
        double ortalama = calculateAverage(vize_notu, final_notu, odev_notu);
        System.out.println("Ortalama    : " +ortalama);
        System.out.println("Harf Notu   : " +getLetterGrade(ortalama));
        if(isPassingGrade(ortalama)){
            System.out.println("Durum       : GEÇTİ");
        }else{
            System.out.println("Durum       : KALDI");
        }
        System.out.println("Onur Listesi: " +(isHonorList(ortalama, vize_notu, final_notu, odev_notu)
                == true ? "EVET" : "HAYIR"));
        if(hasRetakeRight(ortalama)){
            System.out.println("BUTUNLEME   : VAR");
        }else{
            System.out.println("BUTUNLEME   : YOK");
        }

    }
}
