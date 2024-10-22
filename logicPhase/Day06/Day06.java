package logicPhase.Day06;
import java.util.*;

public class Day06 {
  public static void main(String[] args) {
    vokalkonsonan("Sample Case");
    System.out.println();
    vokalkonsonan("Next Case");
    System.out.println();

    Scanner input = new Scanner(System.in);
    makan(input);
    input.close();

    // Scanner input = new Scanner(System.in);
    // konversiVolume(input);
    // input.close();


  }

  public static void vokalkonsonan(String input) {
    String vokal = "";
    String konsonan = "";

    String strBaru = input.replace(" ", "").toLowerCase();
    for (int i = 0; i < strBaru.length(); i++) {
      char c = strBaru.charAt(i);
      if(c == 'a' || c == 'i' || c == 'u' || c == 'e' || c == 'o'){
        vokal += c;
      }
      else if(Character.isLetter(c)){
        konsonan += c;
      }
    }
    //urutkan vokal
    char vokalArray[] = vokal.toCharArray();
    Arrays.sort(vokalArray);
    String vokalSort = new String(vokalArray);

    //urutkan konsonan
    char konsonanArray[] = konsonan.toCharArray();
    Arrays.sort(konsonanArray);
    String konsonanSort = new String(konsonanArray);

    System.out.println("huruf awal : " + input);
    System.out.println("huruf Vokal : " + vokalSort);
    
    System.out.println("huruf Konsonan : " + konsonanSort);
  }

  public static void makan(Scanner input) {
    int totalOrang = 0;
    double totalPorsi = 0;
    int totalPorsiPerempuanDewasa = 0;

    while (true) {
      System.out.println("Pilih opsi:");
      System.out.println("1. Laki-laki Dewasa");
      System.out.println("2. Perempuan Dewasa");
      System.out.println("3. Remaja");
      System.out.println("4. Anak - anak");
      System.out.println("5. Balita");
      System.out.println("0. keluar");
      System.out.println("Masukkan pilihan Anda: ");
      int pilihan = input.nextInt();

      switch (pilihan) {
        case 1:
          System.out.print("Masukkan jumlah laki-laki dewasa yang akan makan: ");
          int lakiLakiDewasa = input.nextInt();
          totalOrang += lakiLakiDewasa;
          totalPorsi += lakiLakiDewasa * 2;
          System.out.println(lakiLakiDewasa + " orang Laki-laki dewasa ");
          break;
        case 2:
          System.out.print("Masukkan jumlah Perempuan Dewasa yang akan makan: ");
          int perempuanDewasa = input.nextInt();
          totalOrang += perempuanDewasa;
          totalPorsiPerempuanDewasa += perempuanDewasa;
          totalPorsi += perempuanDewasa;
          System.out.println(perempuanDewasa + " orang Perempuan Dewasa ");
          break;
        case 3:
          System.out.print("Masukkan jumlah Remaja yang akan makan: ");
          int remaja = input.nextInt();
          totalOrang += remaja;
          totalPorsi += remaja;
          System.out.println(remaja + " orang Remaja ");
          break;
        case 4:
          System.out.print("Masukkan jumlah Anak - anak yang akan makan: ");
          int anakAnak = input.nextInt();
          totalOrang += anakAnak;
          totalPorsi += anakAnak * 0.5;
          System.out.println(anakAnak + " orang Anak - anak ");
          break;
        case 5:
          System.out.print("Masukkan jumlah Balita yang akan makan: ");
          int balita = input.nextInt();
          totalOrang += balita;
          totalPorsi += balita;
          System.out.println(balita + " orang Balita ");
          break;
        case 0:
          System.out.println("Keluar dari sistem");
          System.out.println("Total Orang yang makan: "+ totalOrang);
          System.out.println("Total Porsi yang dimakan: "+ totalPorsi);
          return;
        default:
          System.out.println("Pilihan tidak valid. Silakan coba lagi.");
      }
      if(totalOrang > 5 && totalOrang%2 != 0 ){
        totalPorsi += totalPorsiPerempuanDewasa;
        System.out.println("orang yang makan dengan jumlah orang yang ganjil");
      }
    }
  }

  public static void konversiVolume(Scanner input) {
    double totalCangkir = 0 ;

    System.out.println("Pilih opsi:");
    System.out.println("1. Botol");
    System.out.println("2. Teko");
    System.out.println("3. Gelas");
    System.out.println("0. Keluar");
    System.out.println("Masukan pilihan Anda:");
    int Pilihan = input.nextInt();

    switch (Pilihan) {
      case 1:
        System.out.println("Masukan Jumlah Botol: ");
        int botol = input.nextInt();
        totalCangkir = (totalCangkir + botol) * 5;
        System.out.println("Jumlah Botol dalam "+ botol + "botol adalah "+ totalCangkir + " Cangkir");
        break;

      case 2:
        System.out.println("Masukan Jumlah Teko: ");
        int teko = input.nextInt();
        totalCangkir = (totalCangkir + teko) * 25;
        break;

      case 3:
        System.out.println("Masukan Jumlah Gelas: ");
        int gelas = input.nextInt();
        totalCangkir = (totalCangkir + gelas) * 2.5;
        break;

      case 0:
        System.out.println("Keluar dari sistem");
        System.out.println("Total takaran dalam cangkir: "+ totalCangkir);
        // return;
    
      default:
        System.out.println("Masukan sesuai angka di opsi");
    }
  }
 
  
}