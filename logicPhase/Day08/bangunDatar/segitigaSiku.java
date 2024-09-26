package logicPhase.Day08.bangunDatar;

public class segitigaSiku extends bangunDatar{
  public segitigaSiku(){
  }
  public segitigaSiku(double horizontal, double vertikal, double diagonal ){
    this.horizontal = horizontal;
    this.vertikal = vertikal;
    this.diagonal = diagonal;
  }

  @Override
  public void keliling() {
    double hasilKeliling =horizontal + vertikal+diagonal;
    System.out.println("ini Keliling Segitiga Siku-Siku: ");
    System.out.println(hasilKeliling);
  }

  @Override
  public void luas() {
    double hasilLuas =(horizontal * vertikal)/2;
    System.out.println("ini Luas Segitiga Siku-Siku: ");
    System.out.println(hasilLuas);
  }
  
}
