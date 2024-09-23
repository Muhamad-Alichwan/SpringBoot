public class test {
  public static void main(String[] args) {
    System.out.println("Hello World");
    //sum2([1, 2, 3])
    System.out.println("sum2([1, 1]) → " + sum2(new int[]{1, 1}));

  }

  public static int sum2(int[] nums) {
        // Jika panjang array adalah 0, kembalikan 0
        if (nums.length == 0) {
          return 0;
      }
      // Jika panjang array adalah 1, kembalikan elemen pertama
      else if (nums.length == 1) {
          return nums[0];
      }
      // Jika panjang array lebih dari atau sama dengan 2, kembalikan jumlah dua elemen pertama
      else {
          return nums[0] + nums[1];
      }
  }
}
