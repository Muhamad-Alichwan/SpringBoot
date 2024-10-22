package logicPhase.Day08.bangundatar;

public abstract class BangunDatar implements KelilingLuas{
  private double horizontal;
  private double vertikal;
  private double diagonal;
  private double jariJari;
  public double getJariJari() {
    return jariJari;
  }
  public void setJariJari(double jariJari) {
    this.jariJari = jariJari;
  }
  public double getHorizontal() {
    return horizontal;
  }
  public void setHorizontal(double horizontal) {
    this.horizontal = horizontal;
  }
  public double getVertikal() {
    return vertikal;
  }
  public void setVertikal(double vertikal) {
    this.vertikal = vertikal;
  }
  public double getDiagonal() {
    return diagonal;
  }
  public void setDiagonal(double diagonal) {
    this.diagonal = diagonal;
  }
  
}
