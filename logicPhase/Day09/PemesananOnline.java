package logicPhase.Day09;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.time.DayOfWeek;
import java.time.LocalDate;
public class PemesananOnline {
  public static void main(String[] args) {
    pesanOnline("25 Sabtu");
  }

  public static void pesanOnline(String pesanan) {
    String defaultBulanTahun = " 01 2020";
    String pesananLengkap = pesanan + defaultBulanTahun;
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd EEEE MM yyyy", Locale.forLanguageTag("id-ID"));
    LocalDate tanggalMulai = LocalDate.parse(pesananLengkap, dateTimeFormatter);
    LocalDate libur1 = LocalDate.of(tanggalMulai.getYear(), tanggalMulai.getMonth(), 26);
    LocalDate libur2 = LocalDate.of(tanggalMulai.getYear(), tanggalMulai.getMonth(), 29);
    
    int hariKerja = 0;
    LocalDate tanggalAkhir = tanggalMulai;

    while (hariKerja < 7) {
      tanggalAkhir = tanggalAkhir.plusDays(1);
      if(tanggalAkhir.getDayOfWeek() != DayOfWeek.SATURDAY && tanggalAkhir.getDayOfWeek() != DayOfWeek.SUNDAY &&
      !tanggalAkhir.equals(libur1) && !tanggalAkhir.equals(libur2)){
        hariKerja++;
      }
    }
    System.out.println("Tanggal barang dikirim: "+ tanggalAkhir.getDayOfMonth() + " pada Bulan berikutnya");
  }
}
