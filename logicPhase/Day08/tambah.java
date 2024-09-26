package logicPhase.Day08;

public class tambah {
  public double angka1;
  public double angka2;

  public tambah(){
  }

  public tambah(double angka1, double angka2){
    this.angka1 = angka1;
    this.angka2 = angka2;
  }

  public double perhitunganTambah(){
    angka1 += angka2;
    return angka1;
  }

}
