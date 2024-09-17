package logicPhase;

public class diff21 {
  public static void main(String[] args) {
    System.out.println(Diff21(89));
  }
  public static int Diff21(int n) {
    if(n>21){
      return Math.abs((21-n) *2);
    }
    else{
      return Math.abs(21-n);
    }
  }
}
