package logicPhase.Day08.bangunDatar;

public class persegi extends bangunDatar{
  public persegi(){
  }
  public persegi(double horizontal, double vertikal){
    this.horizontal=horizontal;
    this.vertikal=vertikal;
  }
  @Override
  public void keliling() {
    double hasilKeliling =horizontal * 4;
    System.out.println("ini keliling Persegi: ");
    System.out.println(hasilKeliling);
  }

  @Override
  public void luas() {
    double hasilLuas = horizontal * vertikal;
    System.out.println("ini luas Persegi: ");
    System.out.println(hasilLuas);

  }
  
}
