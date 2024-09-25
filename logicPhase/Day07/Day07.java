package logicPhase.Day07;

import java.util.Scanner;

public class Day07 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    atm(input);
    input.close();
  }
  public static void atm(Scanner input) {
    double saldo=0;
    int pin = 123456;
    System.out.println("Masukkan PIN Anda: ");
    int pinMasukkan = input.nextInt();
    if(pinMasukkan==pin){
      int pilihanAtm=-1;
      while (pilihanAtm!=0) {
        System.out.println("Menu ATM");
        System.out.println("1. Setor Tunai");
        System.out.println("2. Transfer");
        System.out.println("3. Cek saldo");
        System.out.println("0. keluar");
        System.out.println("Masukkan pilihan Anda: ");
        pilihanAtm= input.nextInt();

        switch (pilihanAtm) {
          case 1:
            System.out.print("Masukan Jumlah Uang Setoran: ");
            double jumlahSetor = input.nextDouble();
            saldo += jumlahSetor;
            System.out.printf("Uang telah di setor %.2f. Saldo Sekarang: %.2f\n",jumlahSetor,saldo);
            break;
          case 2:
            System.out.println("Menu Transfer");
            System.out.println("1. Antar Rekening");
            System.out.println("2. Antar Bank");
            System.out.println("Masukkan pilihan Anda: ");
            int pilihanTransfer = input.nextInt();
            
            switch (pilihanTransfer) {
              case 1:
                System.out.print("Masukan Rekening Tujuan: ");
                int antarRekening = input.nextInt();
                while (String.valueOf(antarRekening).length() != 10) {
                  System.out.println("Rekening harus berjumlah 10 digit. Silakan ulangi.");
                  System.out.print("Masukan Rekening Tujuan (10 digit): ");
                  antarRekening = input.nextInt();
                }
                System.out.print("Masukan Nominal Transfer: ");
                int nominalTransfer = input.nextInt();
                while (saldo < nominalTransfer) {
                  System.out.printf("Saldo tidak cukup untuk melakukan transfer. Saldo anda : %.2f\n", saldo);
                  System.out.print("Masukan Nominal Transfer yang tepat: ");
                  nominalTransfer = input.nextInt();
                }
                saldo -= nominalTransfer;
                System.out.printf("Rekening Tujuan : %d\nNominal Transfer : %d\n", antarRekening, nominalTransfer);
                System.out.printf("Transaksi berhasil, saldo anda saat ini Rp. %.2f\n",saldo);
                break;

              case 2:
                System.out.println("Masukan kode bank");
                int kodeBank = input.nextInt();
                System.out.print("Masukan Rekening Tujuan: ");
                int antarBank = input.nextInt();
                System.out.print("Masukan Nominal Transfer: ");
                int nominalTransferAntarBank = input.nextInt();
                while (saldo < nominalTransferAntarBank) {
                  System.out.printf("Saldo tidak cukup untuk melakukan transfer. Saldo anda : %.2f\n", saldo);
                  System.out.print("Masukan Nominal Transfer yang tepat: ");
                  nominalTransferAntarBank = input.nextInt();
                }
                saldo -= nominalTransferAntarBank;
                saldo -= 7500;
                System.out.printf("Kode bank : %d\nRekening Tujuan : %d\nNominal Transfer : %d\n", kodeBank, antarBank, nominalTransferAntarBank);
                System.out.printf("Transaksi berhasil, saldo anda saat ini Rp. %.2f\n",saldo);
                break;
            
              default:
                break;
            }
            
            break;
          case 3:
            System.out.printf("Saldo Sekarang: %.2f\n",saldo);
            break;
          case 0:
            System.out.println("Keluar dari sistem");
            break;
        
          default:
            System.out.println("Pilihan tidak valid. Silakan coba lagi.");
        }
      }
    }
    else{
      System.out.println("PIN SALAH");
      System.out.println("Keluar dari sistem");
    }
  }

}
