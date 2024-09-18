package logicPhase;

/*
 * Objective:
 * 1. Menentukan generasi berdasarkan tahun lahir
 * 2. Menentukan badan kurus, gemuk atau ideal berdasarkan tinggi dan berat badan. Hitung BMI nya
 * 3. Menentukan nilai maksimal dan minimal dari 4 buah angka
 * 4. Menentukan apakah 2 buah angka yang menjadi parameter, berada diantara angka 30-50, Mengembalikan True or False
 */
public class latihanSoalforLoop {
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
  public static void main(String[] args) {
    generasi(1965);
    generasi(1997);
    generasi(2013);
    generasi(2025);
    generasi(1945);
    generasi(2030);
    System.out.println("");
    badanIdeal(170, 45);
    badanIdeal(170, 70);
    badanIdeal(200, 110);
    badanIdeal(195, 200);
    System.out.println("");
    maxmin(60, 20, 30, 40);
    System.out.println("");
    beetweenNumber(30, 45);
    
  }
  
}
