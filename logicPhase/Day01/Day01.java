package logicPhase.Day01;

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
// public class Day01 {
//   public static void main(String[] args) {
//     Day01 obj = new Day01();
//     System.out.println(obj.nearHundred(89));
//   }
//     public boolean nearHundred(int n) {
//       if(Math.abs(100 - n) <= 10 || Math.abs(200 - n) <= 10){
//         return true;
//       }
//       else{
//         return false;
//       }
//     }
    
// }

//dif21
public class Day01 {
  public static void main(String[] args) {
    Day01 obj = new Day01();
    System.out.println(obj.diff21(89));
  }
  public int diff21(int n) {
    if(n>21){
      return Math.abs((21-n) *2);
    }
    else{
      return Math.abs(21-n);
    }
  }
}