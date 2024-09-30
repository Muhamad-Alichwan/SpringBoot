package logicPhase.Day08.bangundatar;

public class Jajargenjang extends BangunDatar{
  public Jajargenjang(){
  }
  public Jajargenjang(double horizontal, double vertikal, double diagonal){
    setHorizontal(horizontal);
    setVertikal(vertikal);
    setDiagonal(diagonal);
    
  }
  @Override
  public double keliling() {
    double hasilKeliling =(getHorizontal() + getDiagonal())*2;
    return hasilKeliling;
  }

  @Override
  public double luas() {
    double hasilLuas =getHorizontal() * getVertikal();
    return hasilLuas;
  }
  
}
