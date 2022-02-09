package lambdayeni2021;

import java.util.*;
import java.util.stream.Collectors;

public class Lambda04 {
    public static void main(String[] args) {


        TechPro trGunduz = new TechPro("yaz", "TR gunduz", 97, 124);
        TechPro engGunduz = new TechPro("kis", "ENG gunduz", 95, 131);
        TechPro trGece = new TechPro("bahar", "TR gece", 98, 143);
        TechPro engGece = new TechPro("sonbahar", "ENG gece", 93, 151);

        List<TechPro> list = new ArrayList<>(Arrays.asList(trGunduz, engGunduz, trGece, engGece));

        //bu class da agirliki return type calisacagiz
        System.out.println(batcOrt92Byk(list)); // true
        System.out.println();
        System.out.println(" *** ");
        System.out.println(ogrcSayisi110Az(list)); //true
        System.out.println();
        System.out.println(" *** ");
        System.out.println(herhangiBirBaharKontrol(list));  //true
        System.out.println();
        System.out.println(" *** ");
        System.out.println(ogrcSayisiTersSireliBatch(list)); //[TechPro{batch='sonbahar', batchName='ENG gece', batchOrt=93, ogrcSayisi=151}, TechPro{batch='bahar', batchName='TR gece', batchOrt=98, ogrcSayisi=143}, TechPro{batch='kis', batchName='ENG gunduz', batchOrt=95, ogrcSayisi=131}, TechPro{batch='yaz', batchName='TR gunduz', batchOrt=97, ogrcSayisi=124}]
        System.out.println();
        System.out.println(" *** ");
        System.out.println(batchOrtTersSiraliBatch(list)); //[TechPro{batch='bahar', batchName='TR gece', batchOrt=98, ogrcSayisi=143}, TechPro{batch='yaz', batchName='TR gunduz', batchOrt=97, ogrcSayisi=124}, TechPro{batch='kis', batchName='ENG gunduz', batchOrt=95, ogrcSayisi=131}]
        System.out.println();
        System.out.println(" *** ");
        System.out.println(ogrcSayisiEnAz2Batch(list)); //[TechPro{batch='kis', batchName='ENG gunduz', batchOrt=95, ogrcSayisi=131}]
        System.out.println();
        System.out.println(" *** ");
        System.out.println(ogrcOrt95BykOgrcSayisi(list)); //267
        System.out.println();
        System.out.println(" *** ");
        System.out.println(ogrcSayisi130BykBatchOrt(list)); //OptionalDouble[95.33333333333333]    98    95  93 un ortalamasi

    }

    //
    public static boolean batcOrt92Byk(List<TechPro> list) {

        return list.
                stream().allMatch(t -> t.getBatchOrt() > 92);//akısdaki her eleman batchort field'a gore eslesmesi kontrol edildi

    }

    //task 02-->ogrc sayilarinin hic birinin  110 den az olmadigini  kontrol eden pr create ediniz.
    public static boolean ogrcSayisi110Az(List<TechPro> list) {
        return list.
                stream().
                // noneMatch(t -> t.getOgrcSayisi()< 110);
                        allMatch(t -> t.getOgrcSayisi() >= 110);
    }


    //task 03-->batch'lerde herhangi birinde "bahar" olup olmadigini  kontrol eden pr create ediniz.
    public static boolean herhangiBirBaharKontrol(List<TechPro> list) {
        return list.
                stream().
                anyMatch(t -> t.getBatch().equals("bahar"));  //anyMatch herhangi birini getir  bak (bahar) varmi yokmu yani bahara esitmi
    }


    public static List<TechPro> ogrcSayisiTersSireliBatch(List<TechPro> list) {
        //techPro classndaki ogrenci sayisina gore sirala dedik sonra collect dedik. bu toplama methodu. // Collectors to liste gore topla
        return list.
                stream().  //
                sorted(Comparator.comparing(TechPro::getOgrcSayisi).reversed()). //ogrssayis parametresine gore ters siraladi
                collect(Collectors.toList()); ////collect()->akısdaki elamanları istenen sarta gore toplar
        //Collectors.toList()->collect'e toplanan elemanlarilist'e cevir
    }

    //task 05-->batch'leri batch ort gore  b->k siralayip ilk3 'unu yazdiriniz. ( //reserved ters siralama yapar)

    public static List<TechPro> batchOrtTersSiraliBatch(List<TechPro> list) {
        return list.
                stream().
                sorted(Comparator.comparing(TechPro::getBatchOrt).reversed()).//ogrcSayisi parametresine gore ters siraladi
                limit(3).//akıstadki elemanlarin ilk ucu alindi
                collect(Collectors.toList());//collect()->akısdaki elamanları istenen sarta gore toplar
        //Collectors.toList()->collect'e toplanan elemanlarilist'e cevirir
    }

    //task 06--> ogrc sayisi en az olan 2. batch'i  yazdiriniz.
    public static List<TechPro> ogrcSayisiEnAz2Batch(List<TechPro> list) {
        return list.
                stream().
                sorted(Comparator.comparing(TechPro::getOgrcSayisi)).//ogrcSayisi parametresine gore  siraladi
                limit(2).//ilk iki elelman alindi
                skip(1).//ilk elelamn atlatildi ***
                collect(Collectors.toList());//collect()->akısdaki elamanları istenen sarta gore toplar

    }

    //task 07--> batch ort 95 'den buyuk olan batch'lerin ogrc sayilarini toplamini yazdiriniz

    public static int ogrcOrt95BykOgrcSayisi(List<TechPro> list) {
        return list.
                stream().
                filter(t -> t.getBatchOrt() > 95).//95 den byk sarti saglandi
                map(t -> t.getOgrcSayisi()).//batch oert olan data ogrc sayisi olarak update edildi
                //reduce(0,Integer::sum);//ogrc sayisi toplandi      1.yol
                        reduce(0, (t, u) -> t + u);//ogrc sayisi toplandi // 124+143=267   2.yol
    }

    //task 08--> Ogrenci sayisi 130'dan buyuk olan Batch'lerin batchOrt'larinin ortalamasini bulunuz.
    public static OptionalDouble ogrcSayisi130BykBatchOrt(List<TechPro> list) {
        return list.
                stream().
                filter(t -> t.getOgrcSayisi() > 130).
                mapToDouble(t -> t.getBatchOrt()).
                average();

    }




    }
