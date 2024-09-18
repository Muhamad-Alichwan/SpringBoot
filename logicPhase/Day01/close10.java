package logicPhase.Day01;

/* question:
Given 2 int values, return whichever value is nearest to the value 10, 
or return 0 in the event of a tie. 
Note that Math.abs(n) returns the absolute value of a number. */
public class close10 {
  public static int close_10(int a, int b) {
    if(Math.abs(a-10) < Math.abs(b-10)){
      return a;
    }
    else if(Math.abs(b-10) < Math.abs(a-10)){
      return b;
    }
  return 0;
}

  public static void main(String[] args) {
  /* test case:
  close10(8, 13) → 8
  close10(13, 8) → 8
  close10(13, 7) → 0
    */
    System.out.println(close_10(8, 13));
    System.out.println(close_10(13, 8));
    System.out.println(close_10(13, 7));
  }
}
