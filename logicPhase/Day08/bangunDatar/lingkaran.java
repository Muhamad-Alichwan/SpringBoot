package logicPhase.Day08.bangunDatar;

public class Lingkaran extends BangunDatar{
  public Lingkaran(){
  }
  public Lingkaran(double jariJari){
    setJariJari(jariJari);
  }
  @Override
  public double keliling() {
    double hasilKeliling = 2 * 3.14 * getJariJari();
    return hasilKeliling;
  }
  @Override
  public double luas() {
    double hasilLuas = 3.14 * (getJariJari()*getJariJari());
    return hasilLuas;
  }
  
}
