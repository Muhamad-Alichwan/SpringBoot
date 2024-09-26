package logicPhase.Day08.bangunDatar;

// import java.util.Scanner;

public class main {
  public static void main(String[] args) {
    // Scanner scanner = new Scanner(System.in);

    // scanner.close();
    persegi persegi1 = new persegi();
    persegi1.horizontal = 5;
    persegi1.vertikal = 5;
    persegi1.keliling();
    persegi1.luas();

    System.out.println();

    persegiPanjang persegiPanjang1 = new persegiPanjang();
    persegiPanjang1.horizontal = 6;
    persegiPanjang1.vertikal = 9;
    persegiPanjang1.keliling();
    persegiPanjang1.luas();

    System.out.println();

    segitigaSiku segitigaSiku1 = new segitigaSiku();
    segitigaSiku1.horizontal = 3;
    segitigaSiku1.vertikal = 4;
    segitigaSiku1.diagonal = 5;
    segitigaSiku1.keliling();
    segitigaSiku1.luas();

    System.out.println();

    segitigaSisi segitigaSisi1 = new segitigaSisi();
    segitigaSisi1.horizontal = 3;
    segitigaSisi1.vertikal = 4;
    segitigaSisi1.diagonal = 5;
    segitigaSisi1.keliling();
    segitigaSisi1.luas();

    System.out.println();

    jajargenjang jajargenjang1 = new jajargenjang();
    jajargenjang1.horizontal = 3;
    jajargenjang1.vertikal = 4;
    jajargenjang1.diagonal = 5;
    jajargenjang1.keliling();
    jajargenjang1.luas();

    System.out.println();

    lingkaran lingkaran1 = new lingkaran();
    lingkaran1.jariJari = 7;
    lingkaran1.keliling();
    lingkaran1.luas();

  }
}
