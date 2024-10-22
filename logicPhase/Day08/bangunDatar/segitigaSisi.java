package logicPhase.Day08.bangundatar;

public class SegitigaSisi extends BangunDatar {
  public SegitigaSisi(){
  }
  public SegitigaSisi(double horizontal, double vertikal, double diagonal){
    setHorizontal(horizontal);
    setVertikal(vertikal);
    setDiagonal(diagonal);
  }
  @Override
  public double keliling() {
    double hasilKeliling =getHorizontal() + getVertikal()+getDiagonal();
    return hasilKeliling;
  }
  @Override
  public double luas() {
    double hasilLuas =(getHorizontal() * getVertikal())/2;
    return hasilLuas;
  }
  

}
