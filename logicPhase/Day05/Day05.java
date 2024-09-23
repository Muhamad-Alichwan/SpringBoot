package logicPhase.Day05;

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



}