package logicPhase.Day08.bangunDatar;

public class lingkaran extends bangunDatar{
  public lingkaran(){
  }
  public lingkaran(double jariJari){
    setJariJari(jariJari);
  }
  @Override
  public void keliling() {
    double hasilKeliling = 2 * 3.14 * getJariJari();
    System.out.println("ini Keliling Lingkaran: ");
    System.out.println(hasilKeliling);
  }
  @Override
  public void luas() {
    double hasilLuas = 3.14 * (getJariJari()*getJariJari());
    System.out.println("ini Luas Lingkaran: ");
    System.out.println(hasilLuas);
  }
  
}
