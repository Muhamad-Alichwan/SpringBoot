package logicPhase.Day08.bangunDatar;

public class persegiPanjang extends bangunDatar {
  public persegiPanjang(){
  }
  public persegiPanjang(double horizontal, double vertikal){
    this.horizontal=horizontal;
    this.vertikal=vertikal;
  }
  @Override
  public void keliling() {
    double hasilKeliling =(horizontal + vertikal)*2;
    System.out.println("ini Keliling Persegi Panjang: ");
    System.out.println(hasilKeliling);
  }

  @Override
  public void luas() {
    double hasilLuas =horizontal * vertikal;
    System.out.println("ini Luas Persegi Panjang: ");
    System.out.println(hasilLuas);
  }

  
}
