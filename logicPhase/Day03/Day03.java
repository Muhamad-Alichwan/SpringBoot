package logicPhase.Day03;
import java.util.Scanner;
/* Objective:
 * 1. dayName(int number). Fungsi ini menerima inputan angka dan mengembalikan hari apa sesuai urutan angka tersebut
 * 
 * 2. dayNumber(String day). Fungsi ini menerima inputan nama hari dan mengembalikan angka hari ke berapa
 * Note: hari dimulai dari senin
 * 
 * 3. Dengan memanfaatkan 2 fungsi diatas, buatlah function, dengan  parameter day sebagai string, 
 * yang mencetak kata2 sebagai berikut:
 *  Kemarin lusa adalah hari ....(2 hari sebelum parameter)
 *  kemarin adalah hari ....(1 hari sebelum parameter)
 *  hari ini adalah hari ....(didapat dari parameter)
 *  besok adalah hari ....(1 hari setelah parameter)
 *  besok lusa adalah hari ....(2 hari setelah parameter)
 * 
 * 4. Buatlah function leapYear() dengan parameter year yang berfungsi untuk mencetak tahun tahun kabisat 
 *    mulai dari nilai yang diambil dari parameter, sampai tahun ini
 * 
 * 5. Buatlah function oddEvenAddition() dengan parameter number sebagai jumlah iterasi yang berfungsi
 *    untuk melakukan penjumlahan bilangan ganjil gepan.
 * */
public class Day03 {
public static String dayName(int number) {
    String hari;
    switch (number) { 
      /*  Note: 
      1. untuk menggunakan break dalam switch case harus ditambahkan variabel untuk menyimpan nilai dalam suatu case
      2. Jika ingin tanpa menggunakan break. Didalam case langsung ngereturn / ngeprint nilai yang ingin ditampilkan */
        case 1:
            hari = "Senin";
            break;
        case 2:
            hari = "Selasa";
            break;
        case 3:
            hari = "Rabu";
            break;
        case 4:
            hari = "Kamis";
            break;
        case 5:
            hari = "Jumat";
            break;
        case 6:
            hari = "Sabtu";
            break;
        case 7:
            hari = "Minggu";
            break;
        default:
            hari = "Tidak ada";
            break;
    }
    return hari;
}
  public static int dayNumber(String day){
    int number;
    switch (day.toLowerCase()) {
      case "senin":
        number = 1;
        break;
      case "selasa":
        number = 2;
        break;
      case "rabu":
        number = 3;
        break;
      case "kamis":
        number = 4;
        break;
      case "jumat":
        number = 5;
        break;
      case "sabtu":
        number = 6;
        break;
      case "minggu":
        number = 7;
        break;
      default:
        throw new IllegalArgumentException("Hari tidak valid: " + day);
    }
    return number;
  }

  public static void hitunghari(String day) {
    int number = dayNumber(day);
    System.out.println("Kemarin lusa adalah hari " + dayName((number - 2 + 7-1)%7+1));
    System.out.println("Kemarin adalah hari " + dayName((number - 1 + 7-1)%7+1));
    System.out.println("Hari ini adalah hari " + dayName(number));
    System.out.println("Besok adalah hari " + dayName((number + 1-1)%7+1));
    System.out.println("Besok lusa adalah hari " + dayName((number + 2-1)%7+1));
  }

  public static void leapYear(int year) {
    if (year%400 == 0 || year%400 != 0 && year%100 != 0 && year%4 == 0 ){
      for (int i = year; i <= 2024; i++) {
        if(i%400 == 0 || i%400 != 0 && i%100 != 0 && i%4 == 0){
          System.out.print(i + " ");
        }
      }
    }
    else{
      System.out.println("Bukan tahun kabisat");
    }  
  }

  public static void oddEvenAddition(int number){
    // i%2 == 0 = genap
    // i%2 != 0 = ganjil
    // for (int i = 0; i <= number; i++) {
    //   int j = i + 1;
    //   if(j<=number){
    //     System.out.println(i + "+" + j + "=" + (i+j));
    //   }
    // }

    int angka1=1;
    int angka2=2;
    for (int i = 0; i < number; i++) {
      int angka3 = angka1 + angka2;
      System.out.println(angka1 + "+" + angka2 + "=" + angka3);
      angka1 += 2 ;
      angka2 += 2 ;
    }
  }
  public static void main(String[] args) {
    // Scanner input = new Scanner(System.in);
    // System.out.println("Masukkan angka: ");
    // int number = input.nextInt();
    // System.out.println(dayName(number));
    // input.close();

    // Scanner input = new Scanner(System.in);
    // System.out.println("Masukkan Hari: ");
    // String day = input.nextLine();
    // System.out.println(dayNumber(day));
    // input.close();

    // Scanner input = new Scanner(System.in);
    // System.out.println("Masukkan Hari: ");
    // String day = input.nextLine();
    // hitunghari(day);
    // input.close();

    // Scanner input = new Scanner(System.in);
    // System.out.println("Masukkan Tahun: ");
    // int year = input.nextInt();
    // leapYear(year);
    // input.close();

    Scanner input = new Scanner(System.in);
    System.out.println("Masukkan angka: ");
    int angka = input.nextInt();
    oddEvenAddition(angka);
    input.close();
  }
}
