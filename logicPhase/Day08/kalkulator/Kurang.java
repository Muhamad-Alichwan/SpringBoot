package logicPhase.Day08.kalkulator;

public class Kurang {
  public double angka1;
  public double angka2;

  public Kurang(){
  }

  public Kurang(double angka1, double angka2){
    this.angka1 = angka1;
    this.angka2 = angka2;
  }

  public double perhitunganKurang(){
    angka1 -= angka2;
    return angka1;
  }

}