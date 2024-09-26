package logicPhase.Day08;
import java.util.Scanner;

public class Day08 {
  public static void main(String[] args) {
    // tambah tambah = new tambah();
    // kurang kurang = new kurang();
    // kali kali = new kali();
    // bagi bagi = new bagi();
    Scanner scanner = new Scanner(System.in);
    int input = -1;
    while (input != 0) {
      System.out.println("Masukan angka (0 untuk keluar program kalkulator)");
      System.out.println("Operasi Matematika");
      System.out.println("1. Tambah");
      System.out.println("2. Kurang");
      System.out.println("3. Kali");
      System.out.println("4. Bagi");
      System.out.print("Masukan Angka: ");

      input = scanner.nextInt();
      if(input != 0 ){
        switch (input) {
          case 1:
            System.out.print("Masukan angka ke-1: ");
            double angka1 = scanner.nextDouble();
            System.out.print("Masukan angka ke-2: ");
            double angka2 = scanner.nextDouble();
            tambah tambah = new tambah(angka1,angka2);
            System.out.printf("Hasil %.2f + %.2f = %.2f\n", angka1, angka2, tambah.perhitunganTambah());
            break;

          case 2:
            System.out.print("Masukan angka ke-1: ");
            double angka1Kurang = scanner.nextDouble();
            System.out.print("Masukan angka ke-2: ");
            double angka2Kurang = scanner.nextDouble();
            kurang kurang = new kurang(angka1Kurang,angka2Kurang);
            System.out.printf("Hasil %.2f - %.2f = %.2f\n", angka1Kurang, angka2Kurang, kurang.perhitunganKurang());
            break;

          case 3:
            System.out.print("Masukan angka ke-1: ");
            double setAngka1 = scanner.nextDouble();
            System.out.print("Masukan angka ke-2: ");
            double setAngka2 = scanner.nextDouble();
            kali kali = new kali(setAngka1,setAngka2);
            System.out.printf("Hasil %.2f * %.2f = %.2f\n", setAngka1, setAngka2, kali.perhitunganKali());
            break;

          case 4:
            System.out.print("Masukan angka ke-1: ");
            double setAngka1Bagi = scanner.nextDouble();
            System.out.print("Masukan angka ke-2: ");
            double setAngka2Bagi = scanner.nextDouble();
            bagi bagi = new bagi(setAngka1Bagi,setAngka2Bagi);
            System.out.printf("Hasil %.2f / %.2f = %.2f\n", setAngka1Bagi, setAngka2Bagi, bagi.perhituganBagi());
            break;
        
          default:
            break;
        }
      }
    }
    
    scanner.close();
  }
  
}
