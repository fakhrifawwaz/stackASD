import java.util.Scanner;

public class SuratDemo15 {
    public static void main(String[] args) {
        StackSurat15 stack = new StackSurat15(10);
        Scanner scan = new Scanner(System.in);
        int pilih;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Terima Surat Izin");
            System.out.println("2. Proses Surat Izin");
            System.out.println("3. Lihat Surat Izin Terakhir");
            System.out.println("4. Cari Surat");
            System.out.println("5. Keluar");
            System.out.print("Pilih: ");
            pilih = scan.nextInt();
            scan.nextLine(); 

            switch (pilih) {
                case 1:
                    System.out.print("ID Surat       : ");
                    String idSurat = scan.nextLine();
                    System.out.print("Nama Mahasiswa : ");
                    String nama = scan.nextLine();
                    System.out.print("Kelas          : ");
                    String kelas = scan.nextLine();
                    System.out.print("Jenis Izin (S/I): ");
                    char jenisIzin = scan.nextLine().toUpperCase().charAt(0);
                    System.out.print("Durasi (hari)  : ");
                    int durasi = scan.nextInt();
                    scan.nextLine();
                    Surat15 surat = new Surat15(idSurat, nama, kelas, jenisIzin, durasi);
                    stack.push(surat);
                    System.out.printf("Surat izin %s berhasil diterima.%n", nama);
                    break;

                case 2:
                    Surat15 diproses = stack.pop();
                    if (diproses != null) {
                        System.out.println("Memproses surat dari  : " + diproses.namaMahasiswa);
                        System.out.println("Kelas                 : " + diproses.kelas);
                        System.out.println("Jenis Izin            : " + (diproses.jenisIzin == 'S' ? "Sakit" : "Izin"));
                        System.out.println("Durasi                : " + diproses.durasi + " hari");
                        System.out.println("Status                : Surat berhasil diverifikasi.");
                    }
                    break;

                case 3:
                    Surat15 terakhir = stack.peek();
                    if (terakhir != null) {
                        System.out.println("Surat izin terakhir dari : " + terakhir.namaMahasiswa);
                        System.out.println("ID Surat                 : " + terakhir.idSurat);
                        System.out.println("Kelas                    : " + terakhir.kelas);
                        System.out.println("Jenis Izin               : " + (terakhir.jenisIzin == 'S' ? "Sakit" : "Izin"));
                        System.out.println("Durasi                   : " + terakhir.durasi + " hari");
                    }
                    break;

                case 4:
                    System.out.print("Masukkan nama mahasiswa: ");
                    String cari = scan.nextLine();
                    stack.cariSurat(cari);
                    break;

                case 5:
                    System.out.println("Keluar dari program.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilih >= 1 && pilih <= 4);

        scan.close();
    }
}