package logicPhase.Day08.kalkulator;

public class Tambah {
  public double angka1;
  public double angka2;

  public Tambah(){
  }

  public Tambah(double angka1, double angka2){
    this.angka1 = angka1;
    this.angka2 = angka2;
  }

  public double perhitunganTambah(){
    angka1 += angka2;
    return angka1;
  }

}
