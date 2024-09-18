package logicPhase.Day01;

public class nearHundred {
  public static void main(String[] args) {
    System.out.println(nearhundred(89));
  }
    public static boolean nearhundred(int n) {
      if(Math.abs(100 - n) <= 10 || Math.abs(200 - n) <= 10){
        return true;
      }
      else{
        return false;
      }
    }
}
