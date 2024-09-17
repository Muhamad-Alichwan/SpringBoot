package logicPhase;

// Sum Double
// public class Day01 {
//   public static void main(String[] args) {
//     Day01 obj = new Day01();
//     System.out.println(obj.sumDouble(2, 3)); // Example usage
//   }

//   public int sumDouble(int a, int b) {
//     if (a == b) {
//       return (a + b) * 2;
//     } else {
//       return a + b;
//     }
//   }
// }

//nearHundred
public class Day01 {
  public static void main(String[] args) {
    Day01 obj = new Day01();
    System.out.println(obj.nearHundred(89));
  }
    public boolean nearHundred(int n) {
      if(Math.abs(100 - n) <= 10 || Math.abs(200 - n) <= 10){
        return true;
      }
      else{
        return false;
      }
    }
    
}
