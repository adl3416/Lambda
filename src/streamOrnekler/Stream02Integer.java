package streamOrnekler;

import java.util.ArrayList;
import java.util.List;

public class Stream02Integer { // map ile birlikte yaptik
    public static void main(String[] args) {

        List<Integer> liste = new ArrayList<>();
        liste.add(12);
        liste.add(9);
        liste.add(13);
        liste.add(4);
        liste.add(9);
        liste.add(2);
        liste.add(4);
        liste.add(12);
        liste.add(15);

        tekKareYazdir(liste);
        System.out.println("TOPLAM:" +  tekKupToplami(liste));


    }// main sonu

    public static void tekKareYazdir(List<Integer> l) { // l bir isim biz verdik

        l.stream().filter(Stream01Integer::tekMi).map(x->x*x).forEach(Stream01Integer:: yazdır); //81 169 81 225
        System.out.println(" ");
        l.stream().filter(Stream01Integer::tekMi).distinct().map(x->x*x).forEach(Stream01Integer:: yazdır);//81 169 225

        // distinct :  tekrar olanlari kaldirir mesela  81 iki adetti birini kaldirdi
    }
    public static Integer tekKupToplami(List<Integer> l ){
      //return  l .stream().filter(Stream01Integer::tekMi).map(x->x*x*x).reduce( 0,(x,y)->(x+y));
       // return  l .stream().filter(Stream01Integer::tekMi).map(x->x*x*x).reduce(Math::addExact);
        return l.stream().filter(Stream01Integer::tekMi).map(x->x*x*x).reduce(0, Integer::sum);


    }

}
