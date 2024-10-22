package logicPhase.Day08.bangundatar;

public class Persegi extends BangunDatar{
  public Persegi(){
  }
  public Persegi(double horizontal){
    setHorizontal(horizontal);
  }
  @Override
  public double keliling() {
    double hasilKeliling = getHorizontal() * 4;
    return hasilKeliling;
  }

  @Override
  public double luas() {
    double hasilLuas = getHorizontal()*getHorizontal();
    return hasilLuas;
  }
  
}
