package logicPhase.Day08.bangunDatar;

public class SegitigaSiku extends BangunDatar{
  public SegitigaSiku(){
  }
  public SegitigaSiku(double horizontal, double vertikal, double diagonal ){
    setHorizontal(horizontal);
    setVertikal(vertikal);
    setDiagonal(diagonal);
  }

  @Override
  public double keliling() {
    double hasilKeliling = getHorizontal() + getVertikal() + getDiagonal();
    return hasilKeliling;
  }

  @Override
  public double luas() {
    double hasilLuas = (getHorizontal() * getVertikal())/2;
    return hasilLuas;
  }
  
}
