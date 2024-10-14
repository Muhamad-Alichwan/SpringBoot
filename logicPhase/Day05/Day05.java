package logicPhase.Day05;
import java.util.*;

public class Day05 {

  public static void main(String[] args) {
    int[] arrA = new int[]{1,2,3,4,5};
    int arrB[] = {6,7,8,9,10};
    String[] arrC = {"Nissan", "Toyota", "Honda"};
    String arrD[] = {"Ferrari", "Lamborghini", "McLaren"};
    char arrE[] = {'3','4','2'};

    for (int i = 0; i < arrA.length ; i++) {
      System.out.print(arrA[i]);
    }
    System.out.println();
    for (char c : arrE) {
      System.out.print(c);
    }
    System.out.println();
    System.out.println();
    kotak(5);
    System.out.println();
    diagonal(5);
    System.out.println();
    oddEven(5);
    System.out.println();
    angkaterbalik(5);
    System.out.println();

  //   Scanner input = new Scanner(System.in);
  //   while (true) {
  //     System.out.println(" Masukan Size column (ketik 0 untuk keluar):");
  //     int size = input.nextInt();
  //     if (size == 0) {
  //       break;
  //     }
  //     mean(size);
  //   }
  //   input.close();
  // }

  //   Scanner input = new Scanner(System.in);
  //   while (true) {
  //     System.out.println(" Masukan Size column (ketik 0 untuk keluar):");
  //     int size = input.nextInt();
  //     if (size == 0) {
  //       break;
  //     }
  //     median(size);
  //   }
  //   input.close();
  // }

  //   Scanner input = new Scanner(System.in);
  //   while (true) {
  //     System.out.println(" Masukan Size column (ketik 0 untuk keluar):");
  //     int size = input.nextInt();
  //     if (size == 0) {
  //       break;
  //     }
  //     modus(size, input);
  //   }
  //   input.close();
  // }

  // Scanner input = new Scanner(System.in);
  //   while (true) {
  //     System.out.println(" Masukan Size column (ketik 0 untuk keluar):");
  //     int size = input.nextInt();
  //     if (size == 0) {
  //       break;
  //     }
  //     min(size);
  //   }
  //   input.close();
  // }

  // Scanner input = new Scanner(System.in);
  //   while (true) {
  //     System.out.println(" Masukan Size column (ketik 0 untuk keluar):");
  //     int size = input.nextInt();
  //     if (size == 0) {
  //       break;
  //     }
  //     max(size);
  //   }
  //   input.close();
  // }

//   // Membuat daftar yang akan diberikan sebagai argumen ke fungsi hitung
//   List<Integer> inputList = new ArrayList<>();
//   inputList.add(1);
//   inputList.add(2);
//   inputList.add(3);

//   // Memanggil fungsi hitung dan menyimpan hasilnya
//   List<Integer> resultList = hitung(inputList);

//   // Mencetak hasil
//   System.out.println("Hasil dari fungsi hitung: " + resultList);
// }

//   List<Integer> inputList1 = new ArrayList<>();
//   List<Integer> inputList2 = new ArrayList<>();
//   inputList1.add(1);
//   inputList1.add(2);
//   inputList1.add(3);

//   inputList2.add(1);
//   inputList2.add(2);
//   inputList2.add(3);

//   // Memanggil fungsi hitung dan menyimpan hasilnya
//   List<Integer> resultList = sum2(inputList1, inputList2);

//   // Mencetak hasil
//   System.out.println("Hasil dari fungsi hitung: " + resultList);
// }

  List<Integer> inputList1 = new ArrayList<>();
  List<Integer> inputList2 = new ArrayList<>();
  // twoTwo([4, 2, 2, 3]) → true
  // twoTwo([2, 2, 4]) → true
  // twoTwo([2, 2, 4, 2]) → false
  inputList1.add(4);
  inputList1.add(2);
  inputList1.add(2);
  inputList1.add(3);

  inputList2.add(2);
  inputList2.add(2);
  inputList2.add(4);
  inputList2.add(2);

  // Memanggil fungsi hitung dan menyimpan hasilnya
  boolean resultList = twotwo(inputList2);

  // Mencetak hasil
  System.out.println(resultList);
}

  public static void kotak(int size) {
    char[][] arrA = new char[size][size];
    // perulangan untuk memasukan data array
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if(i>=1 && i<=3 && j>=1 && j <= 3){
          arrA[i][j]=' ';
        }
        else{
        arrA[i][j]='*';
        }
      }
    }
    // perulangan untuk ngeprint array 
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        System.out.print(arrA[i][j] + " ");
      }
      System.out.println();
    }
  }

  
  public static void diagonal(int size) {
    char[][] arrA = new char[size][size];
    // perulangan untuk memasukan data array
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if(i==j || i+j == size - 1 ){
          arrA[i][j]='*';
        }
        else{
        arrA[i][j]=' ';
        }
      }
    }
    // perulangan untuk ngeprint array 
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        System.out.print(arrA[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void oddEven(int size) {
    int arrA[][] = new int[size][size];
    int ganjil = 1;
    int genap = 2;
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        if (i%2 == 0) {
          arrA[i][j] = ganjil ;
          ganjil += 2;
        } else {
          arrA[i][j] = genap ;
          genap += 2;
        }
      }
    }

    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        System.out.print(arrA[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void angkaterbalik(int size) {
    int arrA[][] = new int[size][size];
    int num = size*size;
    for (int i = 0; i < size; i++ ) {
      for (int j = 0; j < size; j++ ) {
        arrA[i][j] = num--;
      }
    }   
    
    for (int i = 0; i < arrA.length; i++) {
      for (int j = 0; j < arrA.length; j++) {
        System.out.print(arrA[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void mean(int size) {
    int arrA[] = new int[size];
    double sum = 0;
    Random rand = new Random();
    for (int i = 0; i < size; i++) {
        arrA[i] = rand.nextInt(100);
        System.out.print(arrA[i] + " ");
    }
    
    // Menghitung mean
    for (int j = 0; j < arrA.length; j++) {
      sum += arrA[j];
    }
    double mean = sum / size;
    System.out.println("\nMean: " + mean);
}

  public static void median(int size) {
    int arrA[] = new int[size];
    Random rand = new Random();
    for (int i = 0; i < size; i++) {
        arrA[i] = rand.nextInt(100);
        System.out.print(arrA[i] + " ");
    }
    
    // Menghitung median
    Arrays.sort(arrA);
    int n = arrA.length;
    if(n%2 == 1){
      System.out.println(arrA);
      System.out.print("\nData Median adalah : "+ arrA[n/2] );
    }
    else{
      System.out.println(arrA);
      System.out.println("\nData Median adalah : " + (arrA[(n/2)-1]+arrA[n/2])/2.0);
    }
  }
  public static void modus(int size, Scanner input) {
    int arrA[] = new int[size];
    System.out.println("Masukkan " + size + " nilai untuk array:");
        for (int i = 0; i < size; i++) {
            arrA[i] = input.nextInt();
        }
        System.out.println("Nilai array:");
        for (int i = 0; i < size; i++) {
            System.out.print(arrA[i] + " ");
        }
        System.out.println();

    // Menghitung modus
    Arrays.sort(arrA);
    int maxCount = 1; // untuk melakukan perbandingan nilai max yang sering muncul dengan currentCount 
    int saveModus = arrA[0]; // untuk menyimpan nilai modus ke array
    int currentCount = 1; // untuk melakukan penjumlahan nilai saat ini

    for (int i = 1; i < size; i++) {
      if (arrA[i] == arrA[i - 1]) {
        currentCount++;
      } 
      else { // jika nilai saat ini beda dengan nilai sebelumnya, kita akan melakukan update pada nilai maxCount & currentCount
        if (currentCount > maxCount) {
          maxCount = currentCount;
          saveModus = arrA[i - 1];
        }
        currentCount = 1; // Reset jumlah kemunculan untuk nilai baru 
      }
    }

        // Cek untuk elemen terakhir
        if (currentCount > maxCount) {
            saveModus = arrA[size - 1];
        }

        System.out.println();
        System.out.println("\nSorted array :");
        for (int i : arrA) {
          System.out.print( i + " ");
        }
        System.out.println("Modus: " + saveModus + " (muncul " + maxCount + " kali)");

  }

  public static void min(int size) {
    int arrA[] = new int[size];
    Random rand = new Random();
    for (int i = 0; i < size; i++) {
        arrA[i] = rand.nextInt(100);
        System.out.print(arrA[i] + " ");
    }

    //mencari nilai min
    Arrays.sort(arrA);
    System.out.println();
    System.out.println("\nSorted array :");
    for (int i : arrA) {
      System.out.print( i + " ");
    }
    System.out.println("Nilai Minimun dari Array : " + arrA[0]);
  }

  public static void max(int size) {
    int arrA[] = new int[size];
    Random rand = new Random();
    for (int i = 0; i < size; i++) {
        arrA[i] = rand.nextInt(100);
        System.out.print(arrA[i] + " ");
    }

    //mencari nilai max
    Arrays.sort(arrA);
    System.out.println();
    System.out.println("\nSorted array :");
    for (int i : arrA) {
      System.out.print( i + " ");
    }
    
    System.out.println("\nNilai Maximum dari Array : " + arrA[arrA.length-1]);
  }

  public static List<Integer> hitung(List<Integer> a) {
    ArrayList<Integer> reverse = new ArrayList<>();
    // reverse.add(a.get(2));
    // reverse.add(a.get(1));
    // reverse.add(a.get(0));
    for (int i = a.size()-1; i >= 0; i--) {
      reverse.add(a.get(i));
    }
    return reverse;
}

public static List<Integer> sum2(List<Integer> a, List<Integer> b) {
  ArrayList<Integer> sum2List = new ArrayList<Integer>();
  sum2List.add(a.get(0)+b.get(0));
  sum2List.add(a.get(
  1)+b.get(1));
  sum2List.add(a.get(2)+b.get(2));
  for (int i = 0; i < sum2List.size(); i++) {
    sum2List.get(i);
  }
  return sum2List;
}

public static boolean twotwo(List<Integer> a) {
  // memeriksa array jika 
  if (a.size()==1 && a.get(0)==2) {
    return false;
  }
  // memeriksa angka depan dan terakhir array
  if(a.size() >=2){
    if(a.get(0)==2 && a.get(1)!=2 || a.size()-1==2 && a.size()-2!=2){
    return false;
  }
  for (int i = 1; i <= a.size()-2; i++) {
    if(a.get(i)==2 && a.get(i-1)!=2 && a.get(i+1)!=2){
      return false;
    }
  }
}
  return true;
}
public static String solution(String Input) {
  // Your code starts here.
  Input = Input.toLowerCase();
  Map<String,Integer> newMap = new HashMap<String,Integer>();
  for(int i = 0; i<Input.length(); i++){
    if(newMap.containsKey(Input.indexOf(i))){
      newMap.put(Input.indexOf(i), newMap.get(Input.indexOf(i)+1));
    }
    else{
      newMap.put(Input.indexOf(i),1);
    }
  }
}


  public static List<Integer> solution(List<Integer> l1, List<Integer> l2) {
    // Your code starts here.
    String strl1 = l1.toString();
    Integer numberl1 = Integer.parseInt(strl1);
    String strl2 = l2.toString();
    Integer numberl2 = Integer.parseInt(strl2);
    List<Integer> newList = new List<Integer>();
    newList = numberl1 + numberl2;
    return newList;

  }
}






}