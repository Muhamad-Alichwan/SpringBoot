
import java.util.HashMap;
import java.util.Map;
public class test {
  // public static void main(String[] args) {
  //     // Teks input untuk dianalisis
  //     String text = "Letter";

  //     // Mengubah teks menjadi array karakter
  //     char[] characters = text.toLowerCase().toCharArray();

  //     // Array untuk menyimpan karakter yang sudah dihitung
  //     char[] uniqueCharacters = new char[characters.length];
  //     int[] charCount = new int[characters.length];
  //     int uniqueCharCount = 0;

  //     // Menghitung frekuensi kemunculan setiap karakter
  //     for (int i = 0; i < characters.length; i++) {
  //         char currentCharacter = characters[i];
  //         int j;
  //         // Mencari apakah karakter sudah ada di uniqueCharacters
  //         for (j = 0; j < uniqueCharCount; j++) {
  //             if (uniqueCharacters[j] == currentCharacter) {
  //                 // Jika karakter ditemukan, tingkatkan jumlah kemunculannya
  //                 charCount[j]++;
  //                 break;
  //             }
  //         }
  //         // Jika karakter tidak ditemukan, tambahkan ke daftar karakter unik
  //         if (j == uniqueCharCount) {
  //             uniqueCharacters[uniqueCharCount] = currentCharacter;
  //             charCount[uniqueCharCount] = 1;
  //             uniqueCharCount++;
  //         }
  //     }

  //     // Menemukan karakter yang paling sering muncul
  //     char mostFrequentCharacter = ' ';
  //     int maxCount = 0;
  //     for (int i = 0; i < uniqueCharCount; i++) {
  //         if (charCount[i] > maxCount) {
  //             maxCount = charCount[i];
  //             mostFrequentCharacter = uniqueCharacters[i];
  //         }
  //     }

  //     // Menampilkan karakter yang paling sering muncul
  //     System.out.println("Huruf yang paling sering muncul: " + mostFrequentCharacter + " dengan jumlah: " + maxCount);
  // }

    // public static void main(String[] args) {
    //     // Teks input untuk dianalisis
    //     String text = "Letter";

    //     // Mengubah teks menjadi huruf kecil untuk menghindari perbedaan antara huruf besar dan kecil
    //     text = text.toLowerCase();

    //     // Menggunakan HashMap untuk menyimpan frekuensi karakter
    //     Map<Character, Integer> charFrequencyMap = new HashMap<>();

    //     // Menghitung frekuensi setiap karakter dalam teks
    //     for (int i = 0; i < text.length(); i++) {
    //         char currentChar = text.charAt(i);
    //         // Memperbarui frekuensi karakter dalam HashMap
    //         charFrequencyMap.put(currentChar, charFrequencyMap.getOrDefault(currentChar, 0) + 1);
    //     }

    //     // Menemukan karakter yang paling sering muncul
    //     char mostFrequentCharacter = 'z';
    //     int maxCount = 0;
    //     for (Map.Entry<Character, Integer> entry : charFrequencyMap.entrySet()) {
    //       char currentChar = entry.getKey();
    //       int currentCount = entry.getValue();

    //       // Memperbarui jika jumlah kemunculan lebih besar atau jumlah sama tapi huruf lebih kecil secara abjad
    //       if (currentCount > maxCount || (currentCount == maxCount && currentChar < mostFrequentCharacter)) {
    //           maxCount = currentCount;
    //           mostFrequentCharacter = currentChar;
    //       }
    //   }

    //     // Menampilkan karakter yang paling sering muncul
    //     System.out.println("Huruf yang paling sering muncul: " + mostFrequentCharacter + " dengan jumlah: " + maxCount);
    // }

    public static void main(String[] args) {
      // Teks input untuk dianalisis
      String text = "Letter";

      // Menghitung frekuensi kemunculan setiap karakter
      Map<Character, Integer> charFrequency = new HashMap<Character, Integer>();
      for (char c : text.toLowerCase().toCharArray()) {
          charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
      }

      // Menemukan karakter yang paling sering muncul
      char mostFrequentCharacter = ' ';
      int maxCount = 0;
      for (Map.Entry<Character, Integer> entry : charFrequency.entrySet()) {
          if (entry.getValue() > maxCount) {
              maxCount = entry.getValue();
              mostFrequentCharacter = entry.getKey();
          }
      }

      System.out.println("Karakter yang paling sering muncul: " + mostFrequentCharacter);
  }

}
