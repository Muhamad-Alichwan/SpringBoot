package logicPhase.Day02;
import java.util.Scanner; 
/*
 * Objective:
 * 1. Menentukan generasi berdasarkan tahun lahir
 * 2. Menentukan badan kurus, gemuk atau ideal berdasarkan tinggi dan berat badan. Hitung BMI nya
 * 3. Menentukan nilai maksimal dan minimal dari 4 buah angka
 * 4. Menentukan apakah 2 buah angka yang menjadi parameter, berada diantara angka 30-50, Mengembalikan True or False
 * 5. Buatlah fungsi deret fibonaci. Parameter merupakan panjang deret angka yang tercetak
 * 6, Buatlah fungsi faktorial
 * 7. Buatlah fungsi generate matrix dengan size sebagai argument nya
 */
public class Day02 {
  public static void generasi(int tahunLahir) {
    if (tahunLahir >= 1946 && tahunLahir <= 1964) {
      System.out.println("Baby Boomer");
  } else if (tahunLahir >= 1965 && tahunLahir <= 1980) {
      System.out.println("Generasi X");
  } else if (tahunLahir >= 1981 && tahunLahir <= 1996) {
      System.out.println("Millennials");
  } else if (tahunLahir >= 1997 && tahunLahir <= 2012) {
      System.out.println("Generasi Z");
  } else if (tahunLahir >= 2013 && tahunLahir <= 2025) {
      System.out.println("Generasi Alpha");
  } else {
    System.out.println("Invalid Year");
    }
  } 

  public static void badanIdeal(double tinggiBadan, double beratBadan) {
    double BMI = beratBadan / ((tinggiBadan/100 * tinggiBadan/100));
    if (BMI < 18.5) {
      System.out.println("Badan Kurus degan BMI " + BMI);
    } 
    else if(BMI >= 18.5 && BMI <= 24.9) {
      System.out.println("Badan Ideal degan BMI " + BMI);
    }
    else if(BMI >=25 && BMI <= 29.9){
    System.out.println("Gemuk dengan BMI " + BMI);
    }
    else{
    System.out.println("Obesitas degan BMI " + BMI);
    }
  }
  public static void maxmin(int angka1, int angka2, int angka3, int angka4) {
    if (angka1 > angka2 && angka1 > angka3 && angka1 > angka4) {
    System.out.println("Angka terbesar adalah " + angka1);
    } else if (angka2 > angka1 && angka2 > angka3 && angka2 > angka4) {
    System.out.println("Angka terbesar adalah " + angka2);
    } else if (angka3 > angka1 && angka3 > angka2 && angka3 > angka4) {
    System.out.println("Angka terbesar adalah " + angka3);
    } else {
    System.out.println("Angka terbesar adalah " + angka4);
    }

    if (angka1 < angka2 && angka1 < angka3 && angka1 < angka4) {
    System.out.println("Angka terkecil adalah " + angka1);
    } else if (angka2 < angka1 && angka2 < angka3 && angka2 < angka4) {
    System.out.println("Angka terkecil adalah " + angka2);
    } else if (angka3 < angka1 && angka3 < angka2 && angka3 < angka4) {
    System.out.println("Angka terkecil adalah " + angka3);
    } else {
    System.out.println("Angka terkecil adalah " + angka4);
    }
  }

  public static void beetweenNumber(int angka1, int angka2) {
    if(angka1 >= 30 && angka1 <=50 && angka2 >= 30 && angka2 <=50) {
      System.out.println(true);
    } else {
      System.out.println(false);
    }
  }

  public static void fibonacci (int angkafibonacci) {
    int angka1 = 1;
    int angka2 = 1;
    // 1 1 2 3 5 8 13 21 34 55
    for (int i=0; i<angkafibonacci; i++){
      System.out.println(angka1);
      int angka3 = angka1 + angka2;
      angka1 = angka2;
      angka2 = angka3;
    }
  }

  //faktorial adalah perkalian deret dimana N dikalikan dengan N-1. contoh 5! = 5*4*3*2*1
  // public static void faktorial(int angkafaktorial) {
  //   // Menggunakan perulangan for
  //   long tempNum = 1;
  //   for (int i = angkafaktorial; i>0 ; i--) {
  //     tempNum = tempNum * i;
  //   }
  //   System.out.println(tempNum);
  // }
  public static long faktorial(long angkafaktorial){    
    // // Menggunakan recursive
    if (angkafaktorial == 0){
      return 1;
    }
    return angkafaktorial * faktorial(angkafaktorial - 1);
  }

  //Buatlah fungsi generate matrix dengan size sebagai argument nya
  /*
   * Function GenerateMatrix(size)
    Declare matrix as a 2D array of integers with dimensions size x size
    For i from 0 to size-1
        For j from 0 to size-1
            Set matrix[i][j] to 0 (or any initial value)
        End For
    End For
    Return matrix
End Function

   */
  public static void matrix(int size) {
    for(int i=0;i<size;i++){
      for(int j=0;j<size;j++){
        System.out.print(j + 1 + " ");
      }
      System.out.println("");
    }
  }

  public static void main(String[] args) {
    // generasi(1965);
    // generasi(1997);
    // generasi(2013);
    // generasi(2025);
    // generasi(1945);
    // generasi(2030);
    // System.out.println("");
    // badanIdeal(170, 45);
    // badanIdeal(170, 70);
    // badanIdeal(200, 110);
    // badanIdeal(195, 200);
    // System.out.println("");
    // maxmin(60, 20, 30, 40);
    // System.out.println("");
    // beetweenNumber(30, 45);
    // beetweenNumber(30, 50);
    // beetweenNumber(30, 60);
    
    // System.out.println("");
    // Scanner input = new Scanner(System.in);
    //     System.out.println("Masukkan angka : ");
    //     int angka = input.nextInt();
    //     fibonacci(angka);
        
    //     input.close();

    Scanner input = new Scanner(System.in);
    System.out.println("Masukkan angka : ");
    int angka = input.nextInt();
    System.out.println(faktorial(angka));
    input.close();

    // Scanner input = new Scanner(System.in);
    // System.out.println("Masukkan angka : ");
    // int angka = input.nextInt();
    // matrix(angka);
    // input.close();

  }
  
}
