package logicPhase.Day09;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.Locale;

public class TarifParkir {
  public static void main(String[] args) {
    kalkulasiTarif("28 Januari 2020 07:30:34", "28 Januari 2020 20:03:35");
  //   Scanner input = new Scanner(System.in);
    
  //   int pilihan = -1;
  //   while (pilihan != 0) {
  //     System.out.println("Aplikasi Parkir");
  //     System.out.println("1. Masuk Aplikasi");
  //     System.out.println("0. Keluar");
  //     System.out.print("Masukan Pilihan: ");
  //     pilihan = input.nextInt();
  //     switch (pilihan) {
  //       case 1:
  //         System.out.print("Masukan Tanggal Masuk: ");
  //         String tanggalMasuk = input.nextLine();
  //         System.out.println("Masukan Tanggal Akhir");
  //         String tanggalAkhir = input.nextLine();
  //         kalkulasiTarif(tanggalMasuk, tanggalAkhir);
  //         break;
  
  //       case 0:
  //         System.out.println("Keluar dari program");
  //         break;
        
  //       default:
  //         break;
  //       }
  //     }
      
  //   input.close();
  }

  public static void kalkulasiTarif(String strtanggalMulai, String strtanggalAkhir) {
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm:ss", Locale.forLanguageTag("id-ID"));

    // Convert String to LocalDateTime based on formata from dateTimeFormatter
    LocalDateTime tanggalMulai = LocalDateTime.parse(strtanggalMulai, dateTimeFormatter);
    LocalDateTime tanggalAkhir = LocalDateTime.parse(strtanggalAkhir, dateTimeFormatter);

    // variabel jam menyimpan dengan tipe data Long. Yang menyimpan nilai selisih jam antara tanggal mulai dan akhir.
    Long jam = ChronoUnit.HOURS.between(tanggalMulai, tanggalAkhir);
    double uang = 0;
    if(jam <= 8){
      uang = (uang + 1000) * jam;
    }
    else if(jam <= 24){
      uang += 8000;
    }
    else{
      Long hari = jam/24;
      Long sisaJam = jam%24;
      uang += 15000 * hari;
      if(sisaJam <= 8){
        uang = (uang + 1000) * sisaJam;
      }
      else if(sisaJam <= 24){
        uang += 8000;
      }
    }
    System.out.println("Besarnya Tarif Parkir: "+ uang);
  }


}
