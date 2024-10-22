package logicPhase.Day09;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Jam {
  public static void main(String[] args) {
    ubahJam("12:35 AM"); // 00:35
    ubahJam("19:30"); // 07:30 PM
  }

  public static void ubahJam(String jam) {
    DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofPattern("hh:mm a");
    DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofPattern("HH:mm");

    // LocalTime AmPm = LocalTime.parse(jam, dateTimeFormatter1);
    // LocalTime nonAmPm = LocalTime.parse(jam, dateTimeFormatter2);

    if (jam.contains("AM") || jam.contains("PM")) {
      LocalTime AmPm = LocalTime.parse(jam, dateTimeFormatter1);
      System.out.println(AmPm.format(dateTimeFormatter2));
    }
    else{
      LocalTime nonAmPm = LocalTime.parse(jam, dateTimeFormatter2);
      System.out.println(nonAmPm.format(dateTimeFormatter1));
    }
  }
}
