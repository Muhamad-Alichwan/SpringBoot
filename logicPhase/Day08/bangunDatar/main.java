package logicPhase.Day08.bangundatar;

// import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    String str;
    // Scanner scanner = new Scanner(System.in);

    // scanner.close();
    Persegi Persegi1 = new Persegi();
    Persegi1.setHorizontal(5);
    System.out.println("Keliling Persegi : "+ Persegi1.keliling());
    System.out.println("Luas Persegi : "+ Persegi1.luas());

    System.out.println();

    PersegiPanjang PersegiPanjang1 = new PersegiPanjang();
    PersegiPanjang1.setHorizontal(6);
    PersegiPanjang1.setHorizontal(9);
    System.out.println("Keliling Persegi Panjang : "+ PersegiPanjang1.keliling());
    System.out.println("Luas Persegi Panjang : "+ PersegiPanjang1.luas());
    ;

    System.out.println();

    SegitigaSiku SegitigaSiku1 = new SegitigaSiku();
    SegitigaSiku1.setHorizontal(3);
    SegitigaSiku1.setVertikal(4);
    SegitigaSiku1.setDiagonal(5);
    System.out.println("Keliling Segitiga Siku-Siku : "+ SegitigaSiku1.keliling());
    System.out.println("Luas Segitiga Siku-Siku : "+ SegitigaSiku1.luas());
    

    System.out.println();

    SegitigaSisi SegitigaSisi1 = new SegitigaSisi();
    SegitigaSisi1.setHorizontal(3); 
    SegitigaSisi1.setVertikal(4); 
    SegitigaSisi1.setDiagonal(5); 
    System.out.println("Keliling Segitiga Sama Sisi : "+ SegitigaSisi1.keliling());
    System.out.println("Luas Segitiga Sama Sisi : "+ SegitigaSisi1.luas());
    

    System.out.println();

    Jajargenjang jajargenjang1 = new Jajargenjang();
    jajargenjang1.setHorizontal(3);
    jajargenjang1.setVertikal(4);
    jajargenjang1.setDiagonal(5);
    System.out.println("Keliling Luas Jajargenjang : "+ jajargenjang1.keliling());
    System.out.println("Keliling Luas Jajargenjang : "+ jajargenjang1.luas());
    

    System.out.println();

    Lingkaran lingkaran1 = new Lingkaran();
    lingkaran1.setJariJari(7);
    System.out.println("Keliling Lingkaran : "+ lingkaran1.keliling());
    System.out.println("Luas Lingkaran : "+ lingkaran1.luas());
    

  }
}
