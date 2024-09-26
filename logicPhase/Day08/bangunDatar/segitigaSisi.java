package logicPhase.Day08.bangunDatar;

public class segitigaSisi extends bangunDatar {
  public segitigaSisi(){
  }
  public segitigaSisi(double horizontal, double vertikal, double diagonal){
    this.horizontal = horizontal;
    this.vertikal = vertikal;
    this.diagonal = diagonal;
  }
  @Override
  public void keliling() {
    double hasilKeliling =horizontal + vertikal+diagonal;
    System.out.println("ini Keliling Segitiga Sama Sisi: ");
    System.out.println(hasilKeliling);
  }
  @Override
  public void luas() {
    double hasilLuas =(horizontal * vertikal)/2;
    System.out.println("ini Luas Segitiga Sama Sisi: ");
    System.out.println(hasilLuas);
  }
  

}
