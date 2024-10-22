package logicPhase.Day08.bangundatar;

public class PersegiPanjang extends BangunDatar {
  public PersegiPanjang(){
  }
  public PersegiPanjang(double horizontal, double vertikal){
    setHorizontal(horizontal);
    setVertikal(vertikal);
  }
  @Override
  public double keliling() {
    double hasilKeliling =(getHorizontal() + getVertikal())*2;
    return hasilKeliling;
  }

  @Override
  public double luas() {
    double hasilLuas =getHorizontal() * getVertikal();
    return hasilLuas;
  }

  
}
