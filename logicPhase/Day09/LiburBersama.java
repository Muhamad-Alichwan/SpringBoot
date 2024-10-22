package logicPhase.Day09;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LiburBersama {
  public static void main(String[] args) {
    System.out.println(liburBersama(3,2, "25 Februari 2020"));;
  }

  // Kenapa saya menngunakan String liburanBersama ?.
  // Karena hasil dari method atau fungsi yang saya buat, mengembalikan atau ngereturn sebuah String tanggal.
  public static String liburBersama(Integer x, Integer y, String tanggalLibur) {
    // DateTimeFormatter lebih mudah dan fleksibel digunakan untuk menentukan lokasi penanggalan, waktu, dan performatan.
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.forLanguageTag("id-ID"));
    
    // LocalDate berguna untuk format penanggalan tanpa zona. 
    // LocalDate.parse berguna untuk mengkonversikan atau meng-convert String tanggalLibur menjadi objek LocalDate, berdasarkan format dateTimeFormatter.
    LocalDate tanggal = LocalDate.parse(tanggalLibur, dateTimeFormatter);
    int kpk = 0;
    if (x % y == 0) {
      kpk = x;
    }
    else if(y % x ==0){
      kpk = y;
    }
    else{
      if(x < y){
        kpk = y;
      }
      else{
        kpk = x;
      }
      while (true) {
        if(kpk % y == 0 && kpk % x ==0){
          break;
        }
        kpk +=1;
      }
    }
    return tanggal.plusDays(kpk).format(dateTimeFormatter);
  }
}
