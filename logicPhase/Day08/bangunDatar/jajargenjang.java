package logicPhase.Day08.bangunDatar;

public class jajargenjang extends bangunDatar{
  public jajargenjang(){
  }
  public jajargenjang(double horizontal, double vertikal, double diagonal){
    this.horizontal = horizontal;
    this.vertikal = vertikal;
    this.diagonal = diagonal;
  }
  @Override
  public void keliling() {
    double hasilKeliling =(horizontal + diagonal)*2;
    System.out.println("ini Keliling Segitiga Sama Sisi: ");
    System.out.println(hasilKeliling);
  }

  @Override
  public void luas() {
    double hasilLuas =horizontal * vertikal;
    System.out.println("ini Luas Segitiga Sama Sisi: ");
    System.out.println(hasilLuas);
  }
  
}
