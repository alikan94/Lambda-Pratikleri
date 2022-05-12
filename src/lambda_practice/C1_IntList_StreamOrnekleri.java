package lambda_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class C1_IntList_StreamOrnekleri {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(-5, -8, -2, -12, 0, 1, 12, 5, 6, 9, 15, 8));
        System.out.println("S1:listi aralarinda bosluk birakarak yazdiriniz");
        hepsiniYaz(list);
        Methods.yildizYazdir(15);

        System.out.println("S2: sadece negatif olanlari yazdir");
        negatifleriYaz(list);
        Methods.yildizYazdir(15);

        System.out.println("S3: pozitif olanlardan yeni bir liste olustur");
        System.out.print("pozitifList(list) = " + pozitifList(list));
        Methods.yildizYazdir(15);

        System.out.println("S4: list in elemanlarin karelerinden yeni bir list olusturalim");
        System.out.print("kareleriList(list) = " + kareleriList(list));
        Methods.yildizYazdir(15);

        System.out.println("S5 : list in elemanlarin karelerinden tekrarsiz yeni bir list olusturalim");
        System.out.print("kareleriTekrarsizList(list) = " + kareleriTekrarsizList(list));
        Methods.yildizYazdir(15);

        System.out.println("S6: listin elemanlarini kucukten buyuge siralayalim");
        siralaYazdir(list);
        Methods.yildizYazdir(15);

        System.out.println("S7: listin elemanlarini buyukten kucuge siralayalim");
        tersSiralaYazdir(list);
        Methods.yildizYazdir(15);

        System.out.println("S8: list pozitif elemanlari icn kuplerini bulup birler basamagi " +
                "5 olanlardan yeni bir list olusturalim");
        System.out.print("kuplerListe(list) = " + kuplerListe(list));
        Methods.yildizYazdir(15);

        System.out.println("S9: list pozitif elemanlari icn karelerini bulup birler " +
                "basamagi 5 olmayanlardan yeni bir list olusturalim");
        System.out.println("karelerson5Degil(list) = " + karelerson5Degil(list));

        Methods.yildizYazdir(15);

        System.out.println("S10 :list elemanlarini toplamini bulalim");
        System.out.println("toplam(list) = " + toplam(list));

        Methods.yildizYazdir(15);

        System.out.println("S11 : peek ornegi cozelim - negatiflerin karelerinden list olusturalim");
        System.out.println("negatiflerinKareleri(list) = " + negatiflerinKareleri(list));
        Methods.yildizYazdir(15);

        System.out.println("S12 : listeden 5 den buyuk  sayi var mi?");
        System.out.println("besdenBuyukVarMi(list) = " + listede5tenBuyukSayiVarMi(list));
        Methods.yildizYazdir(15);

        System.out.println("S13 : listenin tum elemanlari sifirdan kucuk mu?");
        System.out.println("sifirdanKucukMu(list) = " + sifirdanKucukMuHepsi(list));
        Methods.yildizYazdir(15);

        System.out.println("S14: listenin 100 e esit elemani yok mu ?\n" +
                "\n" + "yuzeEsitElemanYokMu() : " + yuzeEsitElemanYokMu(list) +
                "\n" +
                "\n  // S15: listenin sifira esit elemani yok mu?\n" +
                "\n" + "sifiraEsitElemanYokMu() : " + sifiraEsitElemanYokMu(list) +
                "\n" +
                "    // S16:  listenin ilk 5 elemanini topla?\n" +
                "\n" + "ilk5ElemaniTopla() : " + ilk5ElemaniTopla(list) +
                "\n   //S17: listenin son bes elemaninin  listele\n" +
                "\n" + "son5ElemaniTopla() : " + son5ElemaniTopla(list));



    }


    // S1:listi aralarinda bosluk birakarak yazdiriniz //
    public static void hepsiniYaz(List<Integer> list) {
        list.stream().forEach(Methods::yazdirBirBosluklu);
    }

    //S2: sadece negatif olanlari yazdir
    public static void negatifleriYaz(List<Integer> list) {
        list.stream().filter(Methods::negatifMi).forEach(Methods::yazdirBirBosluklu);
    }

    //S3: pozitif olanlardan yeni bir liste olustur
    private static List<Integer> pozitifList(List<Integer> list) {

        return list.stream().filter(Methods::pozitifMi).collect(Collectors.toList());
    }

    // S4: list in elemanlarin karelerinden yeni bir list olusturalim

    private static List<Integer> kareleriList(List<Integer> list) {
        return list.stream().map(Methods::kareBul).collect(Collectors.toList());
    }
    //S5 : list in elemanlarin karelerinden tekrarsiz yeni bir list olusturalim

    private static List<Integer> kareleriTekrarsizList(List<Integer> list) {
        return list.stream().map(Methods::kareBul).distinct().collect(Collectors.toList());
    }
    //S6: listin elemanlarini kucukten buyuge siralayalim

    public static void siralaYazdir(List<Integer> list) {
        list.stream().sorted().forEach(Methods::yazdirBirBosluklu);
    }

    //S7: listin elemanlarini buyukten kucuge siralayalim
    public static void tersSiralaYazdir(List<Integer> list) {
        list.
                stream().
                sorted(Comparator.reverseOrder()).
                forEach(Methods::yazdirBirBosluklu);
    }

    // S8: list pozitif elemanlari icn kuplerini bulup birler basamagi 5 olanlardan yeni bir list olusturalim
    private static List<Integer> kuplerListe(List<Integer> list) {
        return list.
                stream().
                filter(Methods::pozitifMi).
                map(Methods::kupBul).
                filter(t -> t % 10 == 5).
                collect(Collectors.toList());
    }

    //S9: list pozitif elemanlari icn karelerini bulup birler basamagi 5 olmayanlardan yeni bir list olusturalim

    public static List<Integer> karelerson5Degil(List<Integer> list) {
        return list.
                stream().
                filter(Methods::pozitifMi).
                map(Methods::kareBul).
                filter(t -> t % 10 != 5).
                collect(Collectors.toList());
    }

    // S10 :list elemanlarini toplamini bulalim

    public static int toplam(List<Integer> list) {
        return list.
                stream().reduce(0, Integer::sum);

    }

    // S11 : peek ornegi cozelim - negatiflerin karelerinden list olusturalim
    public static List<Integer> negatiflerinKareleri(List<Integer> list) {
        return list.
                stream().
                filter(t -> t < 0).
                peek(t-> System.out.println("Negatifler : " + t)).
                map(t->t*t).
                peek(t-> System.out.println("Negatiflerin Karesi : " + t)).
                collect(Collectors.toList());
    }

    // S12 : listeden 5 den buyuk  sayi var mi?

    public static boolean listede5tenBuyukSayiVarMi(List<Integer> list) {
        return list.stream().anyMatch(t->t==5);

    }

    // S13 : listenin tum elemanlari sifirdan kucuk mu?
    public static boolean sifirdanKucukMuHepsi(List<Integer> list) {
        return list.stream().allMatch(t->t<0);

    }

    // S14: listenin 100 e esit elemani yok mu ?

    public static boolean yuzeEsitElemanYokMu(List<Integer> list) {
        return list.stream().anyMatch(t->t!=100);

    }

    // S15: listenin sifira esit elemani yok mu?
    public static boolean sifiraEsitElemanYokMu(List<Integer> list) {
        return list.stream().anyMatch(t->t==0);

    }

    // S16:  listenin ilk 5 elemanini topla?
    public static int ilk5ElemaniTopla(List<Integer> list) {
        return list.stream().limit(5).reduce(0,Integer::sum);

    }
    //S17: listenin son bes elemaninin  listele
    public static int son5ElemaniTopla(List<Integer> list) {
        return list.stream().limit(list.size()-5).reduce(0,Integer::sum);

    }

}