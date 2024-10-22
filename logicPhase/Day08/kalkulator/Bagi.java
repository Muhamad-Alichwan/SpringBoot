package logicPhase.Day08.kalkulator;

public class Bagi {
  private double angka1;
  private double angka2;

  public Bagi(){
  }
  
  public Bagi(double angka1, double angka2){
    this.angka1 = angka1;
    this.angka2 = angka2;
  }

  public double getAngka1() {
    return angka1;
  }

  public void setAngka1(double angka1) {
    this.angka1 = angka1;
  }

  public double getAngka2() {
    return angka2;
  }

  public void setAngka2(double angka2) {
    this.angka2 = angka2;
  }

  public double perhituganBagi(){
    angka1 = angka1 / angka2;
    return angka1;
  }

}
