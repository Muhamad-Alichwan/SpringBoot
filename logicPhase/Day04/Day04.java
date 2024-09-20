package logicPhase.Day04;
import java.util.Scanner;
public class Day04 {
  /*
   * objectives:
   * 1. Dengan menggunakan scanner, Buatlah function untuk mencetak matrix dengan parameter sebagai size
   * matrixnya (kotak). Munculkan indexnya.
   * 2. Dengan menggunakan scanner, Buatlah function untuk mencetak matrix dengan parameter column dan row
   * sebagai ukuran martix nya. Munculkan indexnya
   * 3. Sama seperti soal nomor 1 dan 2, tetapi cetak bintang (*)
   * 4. angka segitiga siku kiri
   * 5. angka segitiga siku kanan
   * 6. bintang segitiga siku kiri
   * 7. binrang segitiga siku kanan
   */
  public static void main(String[] args) {
    // Scanner input = new Scanner(System.in);
    // System.out.println("Masukan Size matrix:");
    // int size = input.nextInt();
    // matrix1(size);
    // input.close();

    // Scanner input = new Scanner(System.in);
    // System.out.println("Masukan Size matrix:");
    // int size = input.nextInt();
    // matrixbintang1(size);
    // input.close();

    // Scanner input = new Scanner(System.in);
    // System.out.println("Masukan Size matrix:");
    // int size = input.nextInt();
    // sikukiri(size);
    // input.close();

    Scanner input = new Scanner(System.in);
    System.out.println("Masukan Size matrix:");
    int size = input.nextInt();
    sikukiribintang(size);
    input.close();

    // Scanner input = new Scanner(System.in);
    // System.out.println("Masukan Size matrix:");
    // int size = input.nextInt();
    // sikukanan(size);
    // input.close();

    // Scanner input = new Scanner(System.in);
    // System.out.println("Masukan Size matrix:");
    // int size = input.nextInt();
    // sikukananbintang(size);
    // input.close();

    // Scanner input = new Scanner(System.in);
    // System.out.println("Masukan Size column:");
    // int column = input.nextInt();
    // System.out.println("Masukan Size column:");
    // int row = input.nextInt();
    // matrix2(column,row);
    // input.close();

    // Scanner input = new Scanner(System.in);
    // System.out.println("Masukan Size column:");
    // int column = input.nextInt();
    // System.out.println("Masukan Size column:");
    // int row = input.nextInt();
    // bintangmatrix2(column,row);
    // input.close();

    // sleepIn(true, true); // expected : True
    // sleepIn(true, false); // expected : False
    // sleepIn(false, false); // expected : True
    // sleepIn(false, true); // expected : True

    // trouble(false, false); // expected : True
    // trouble(true, false); // expected : False
    // trouble(true, true); // expected : True
    // trouble(false, true); // expected : False

    // grading(50);
    // grading(69);
    // grading(100);

    // ganjilgenap(5);

    // test(10005);
    
  }

  public static void matrix1(int size){
    for(int i=0; i<size; i++){
      for(int j=0; j<size; j++){
        System.out.print(i + "" + j + " ") ;
      }
      System.out.println();
    }
  }

  public static void matrix2(int column, int row) {
    for (int i = 0; i < column; i++) {
      for (int j = 0; j < row; j++) {
        System.out.print(i+""+j+" ");
      }
      System.out.println();
    }
  }
  public static void matrixbintang1(int size) {
  for (int i = 0; i<size; i++) {
    for (int j = 0; j < size; j++) {
      System.out.print("*"+" ");
    }
    System.out.println("");
  }
}
  public static void bintangmatrix2(int column, int row) {
  for (int i = 0; i < column; i++) {
    for (int j = 0; j < row; j++) {
      System.out.print("*" + " ");
    }
    System.out.println("");
  }
}
  public static void sikukiri(int size) {
    for (int i = 0; i < size; i++) {
      for(int j = 0; j < size; j++){
        if(j<=i){
          System.out.print(j+1 + " ");
        }
        else{
          System.out.print(" ");
        }
      }
    }
  }

  public static void sikukiribintang(int size) {
    for (int i = 0; i < size; i++) {
      for(int j = 0; j < size; j++){
        if(j<=i){
          System.out.print("*" + " ");
        }
        else{
          System.out.print(" ");
        }
      }
      System.out.println("");
    }
  }

  public static void sikukanan(int size) {
    for (int i = 0; i < size; i++) {
      for(int j = 0; j < size; j++){
        if(j < size - i - 1){
          System.out.print("  ");
        }
        else{
          System.out.print((j - (size - i - 1) + 1) + " ");
        }
      }
      System.out.println();
    }
  }

  public static void sikukananbintang(int size) {
    for (int i = 0; i < size; i++) {
      for(int j = 0; j < size; j++){
        if(j < size - i - 1){
          System.out.print("  ");
        }
        else{
          System.out.print("*" + " ");
        }
      }
      System.out.println();
    }
  }

  public static void test(int angka) {
    String des = angka + "";
    char lastDigit = des.charAt(des.length()-1);
    System.out.println("ini digit terakhir " + Character.getNumericValue(lastDigit));
  }

  public static void sleepIn(boolean weekday, boolean vacation) {
    if(weekday && !vacation){
      System.out.println(false);
    }
    else{
    System.out.println(true);
    }
  }

  // 1  2 monyet senyum trouble
  // 2  2 monyet gk senyum trouble
  // 3. 2 monyet belang not trouble
  public static void trouble(boolean monkey1, boolean monkey2){
    if(monkey1 != monkey2){
      System.out.println(false);
    }
    else{
      System.out.println(true);
    }
  }
  public static void grading(int angka){
      // 100 - 90 = A, 89 - 70 = B, 69-50 = C, 49-40 = D, <39 = F
      // <60 tidak lulus, 61 lulus
      // angka, grade, lulus, gk lulus, 
      if(angka <= 100 && angka >=90){
        System.out.println("A");
      }
      else if(angka <= 89 && angka >=70){
        System.out.println("B");
      }
      else if(angka <= 69 && angka >=50){
        System.out.println("C");
      }
      else if(angka <= 49 && angka >=40){
        System.out.println("D");
      }
      else{
        System.out.println("F");
      }

      if(angka<=60){
        System.out.println(angka + " tidak lulus");
      }
      else{
        System.out.println(angka + " lulus");
      }
    }

    // ganjil genap mencetak angka baris pertama angka ganjil, baris kedua angka genap. parameter nya 1
  public static void ganjilgenap(int size) {
      int ganjil = 1;
      int genap = 2;

      for (int i = 0; i < size ; i++) {
        System.out.print(ganjil + " ");
        ganjil +=2;
      }

      System.out.println();

      for (int i = 0; i < size ; i++) {
        System.out.print(genap + " ");
        genap +=2;
      }
    }
}