package streamOrnekler;

import java.util.stream.IntStream;

public class Stream05Digerleri {
    public static void main(String[] args) {
        /*
          Collection'larimizi stream method;u ile Stream'e cevirmeyi ogrendik.
          Collection : List,Map,HashMap vb..
          Stream'e cevirdikten sonra Stream API kullanarak pipeLine'a sokuyorduk.
          IntStream : Integer seklinde Stream olusturabiliriz.
          LongStream, DoubleStream
          Bunlarin ne artisi var ? Sayisal degerlerle islem yapacaksak isleri kolaylastiriyor.
          Biz istersek Integer, Double, Long tipinde Stream'ler olusturabiliyoruz.
         */

        System.out.println("Toplam: " + topla ( 4));// 6
        System.out.println("Toplam: " + topla1 ( 4));// 6







  }
    //****************************************************************************************************
    // ÖRNEK25: ! den belirtilen degere kadar olan  tamsayilari toplayan ve sonucu dönduren method u  yaziniz.
    //****************************************************************************************************

    public  static int topla(int deger ) {
      return  IntStream.range(1,  deger+1 ).sum(); // 1deen deger kara git  sum ile topla

    }
    public  static int topla1 (int deger ) {
        return IntStream.rangeClosed(1, deger).sum();
    }







}

