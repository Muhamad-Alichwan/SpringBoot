package logicPhase.Day08;

public class kurang {
  public double angka1;
  public double angka2;

  public kurang(){
  }

  public kurang(double angka1, double angka2){
    this.angka1 = angka1;
    this.angka2 = angka2;
  }

  public double perhitunganKurang(){
    angka1 -= angka2;
    return angka1;
  }

}