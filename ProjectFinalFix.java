import java.util.Scanner;
import java.util.Random;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProjectFinalFix {
    // Variabel Global--------------------------------------------------------------------------------------------------------------------------------------
    static Scanner input = new Scanner(System.in);
    static Scanner inputString = new Scanner(System.in);
    static Scanner userInput = new Scanner(System.in);
    static int  hargaPelayanan, hargaPerawatan, metodBayar, login, biayaAdmin, pilihKamar, pilihPerawatan, hargaObat, jumlahObat;
    static long totalTagihan, cash, tagihan;
    static double pajak, totalPajak,diskon,totalDiskon;
    static String namaPasien, kodePasien, gejala, dokter, vA, nik, alamatPasien, umurPasien, jenisKPasien, tingkatPerawatan,tipePelayanan, bank, golBpjs, kamar, tingkatRawat,poli, obat;
    static char pilih, bayar, cetakNota, ulang = 'y';
    static String[][] dataPasien = {
            { "P0001", "Achmad Mufid", "Laki-laki", "30 Tahun", "Tuban" },
            { "P0002", "Alifia Bilqi", "Perempuan", "25 Tahun", "Sumawe" },
            { "P0003", "Andreagazy", "Laki-laki", "29 Tahun", "Tulungagung" },
            { "P0004", "Athalah A.", "Laki-laki", "24 Tahun", "Tidar Malang" },
            { "P0005", "Athena NurH.", "Perempuan", "21 Tahun", "Pakisaji" },
            { "P0006", "Cyndu Fathur","Laki-laki", "17 Tahun", "Blitar" },
            { "P0007", "Denny Malik", "Laki-laki", "26 Tahun", "Lawang" },
            { "P0008", "Diva Aji", "Laki-laki", "19 Tahun", "Bumiaji" },
            { "P0009", "Elvaretta S.", "Perempuan", "19 Tahun", "Malang" },
            { "P0010", "Fadly Nugraha", "Laki-laki", "19 Tahun", "Singosari" },
            { "P0011", "Fidiyah M.", "Perempuan", "19 Tahun", "Dampit" },
            { "P0012", "Filla R.",   "Laki-laki", "20 Tahun", "Blitar" },
            { "P0013", "Hilmi Irfan","Laki-laki", "18 Tahun", "Madiun" },
            { "P0014", "Juan Felix", "Laki-laki", "19 Tahun", "Blitar" },
            { "P0015", "Larasati P.", "Perempuan", "20 Tahun", "Kediri" },
            { "P0016", "Muhamad Anang", "Laki-laki", "27 Tahun", "Blitar" },
            { "P0017", "Muhammad Faiz", "Laki-laki", "34 Tahun", "Sawojajar II" },
            { "P0018", "M. Irfan N.H.","Laki-laki", "19 Tahun", "Tumpang" },
            { "P0019", "Mulki Hakim",  "Laki-laki", "29 Tahun", "Blimbing Malang" },
            { "P0020", "Najwa Azzahra", "Perempuan", "22 Tahun", "Singosari" }
    };

    // =======================================================================================================================================
    public static void main(String[] args) {
        do{
            System.out.println("===============================================================");
            System.out.println("\n\t ======== RUMAH SAKIT UMUM MINH CARE ========");
            System.out.println("\tJl. Raya Tumpang No.122, Kab.Malang, JawaTimur ");
            System.out.println("-------................................................--------");
            System.out.println("\t   Selamat datang! Pilih Menu Untuk Masuk.");
            System.out.println("\n\t --------------------------------------------");
            System.out.println("\t | (1) Sign In - Masuk                      |");
            System.out.println("\t |     => (Cari Data Pasien Lama)           |");
            System.out.println("\t | (2) Sign Up - Daftar                     |");
            System.out.println("\t |     => (Tambah Data Pasien Baru)         |");
            System.out.println("\t | (3) Display Data - Tampil Data           |");
            System.out.println("\t |     => (Cek Data Semua Pasien)           |");
            System.out.println("\t | (4) Exit - Keluar                        |");
            System.out.println("\t --------------------------------------------");
            System.out.println("\t   (0) - Tentang Program Ini");
            System.out.println("===============================================================");
            System.out.print("\nPilih menu [1|2|3|4|0] = ");
            login = input.nextInt();
            switch (login) {
                case 1:
                    System.out.println("\n-- Pilih Menu No.3 Apabila Lupa No/Kode Pasien --");
                    System.out.print("\nMasukkan No/Kode Pasien: ");
                    kodePasien = inputString.next();
                    namaPasien = cariPasien(dataPasien, kodePasien);
                    System.out.println("Apakah Data anda berikut ini sudah benar?\t");
                    System.out.println("-----------------------------------------");
                    System.out.println("| Nama pasien\t|\t"+namaPasien+"\t|");
                    System.out.println("| Jenis Kelamin\t|\t"+jenisKPasien+"\t|");
                    System.out.println("| Umur Pasien\t|\t"+umurPasien +"\t|" );
                    System.out.println("| Alamat Pasien\t|\t"+alamatPasien+"\t\t|");
                    System.out.println("-----------------------------------------");
                    System.out.print("Pilih 'Y'(Yes)||'N'(No)? => ");
                    pilih = input.next().charAt(0);
                    if (pilih=='Y'||pilih=='y') {
                        main_menu(namaPasien);
                    } else {
                        main(args);
                    }
                    break;
                case 2:
                    do {
                        System.out.println("---------------------------------");
                        System.out.println("|" + " NO. PASIEN YANG SUDAH TERISI " + " |");
                        System.out.println("---------------------------------");
                        for (int i = 0; i < dataPasien.length; i++) {
                            System.out.println("|\t\t" + dataPasien[i][0] + "\t\t|");

                        }
                        System.out.println("---------------------------------");
                        String[] pasienBaru = new String[dataPasien[0].length];
                        // input
                        System.out.println("\n=================== INPUT DATA PASIEN BARU ======================\n");
                        System.out.print("Nomer Pasien Baru [Selain Nomer di atas]  : ");
                        pasienBaru[0] = inputString.nextLine();

                        System.out.print("Nama Lengkap Anda [Maks 13]               : ");
                        pasienBaru[1] = inputString.nextLine();

                        System.out.print("Jenis Kelamin [Ketik Laki-laki/Perempuan] : ");
                        pasienBaru[2] = inputString.nextLine();
                        System.out.print("Umur Anda  [Ketik Disertai kata tahun]    : ");
                        pasienBaru[3] = inputString.nextLine();
                        System.out.print("Alamat Rumah Anda [Ketik Kota/Kabupaten]  : ");
                        pasienBaru[4] = inputString.nextLine();
                        System.out.println("\n=================================================================\n");
                        // memasukkan pasien baru dan menyimpan ke data pasien
                        dataPasien = tambahPasien(dataPasien, pasienBaru);
                        System.out.print("Tambah Data Pasien Baru lagi (y/t) ? ");
                        ulang = input.next().charAt(0);
                    } while (ulang == 'y');
                    break;
                case 3:
                    System.out.println("---------------------------------------------------------------------------------------------------------------------");
                    System.out.println("| " + "  NO. PASIEN  " + "|" + "\tNAMA PASIEN\t" + "| " + "\tJENIS KELAMIN\t"+ "| " + "\tUMUR\t\t" + " | " + "\t ALAMAT RUMAH\t");
                    System.out.println("---------------------------------------------------------------------------------------------------------------------");
                    for (int i = 0; i < dataPasien.length; i++) {
                        for (int j = 0; j < dataPasien[0].length; j++) {
                            System.out.print("|\t" + dataPasien[i][j] + "\t");
                        }
                        System.out.println();
                    }
                    System.out.println("---------------------------------------------------------------------------------------------------------------------");
                    main(args);
                case 4:
                    char pilih;
                    System.out.println("Apakah Kamu yakin ingin keluar? Y (Yes)/ N (No): ");
                    pilih = input.next().charAt(0);
                    if ((pilih == 'y' || pilih == 'Y')) {
                        System.out.printf("\n\n\n\t\tSYSTEM AKAN KELUAR\n\t\t  TERIMA KASIH!!!\n\n\n\n");
                        System.exit(pilih);
                    } else if ((pilih == 'N' || pilih == 'n')) {
                        main(args);
                    } else {
                        System.out.printf("\n\n\n\t\tInput Tidak Valid\n\t  System Program akan keluar.\n\n\n");
                        System.exit(pilih);
                        break;
                    }
                case 0:
                    System.out.println("\n\t              TENTANG PROGRAM             ");
                    System.out.println("\n\t ------------------------------------------");
                    System.out.println("\t | ===== RUMAH SAKIT UMUM MINH CARE ===== |");
                    System.out.println("\t |              Version : 1.0             |");
                    System.out.println("\t |         Copyright(c) 2022-2023         |");
                    System.out.println("\t |             Programmmers by:           |");
                    System.out.println("\t |        Muhammad Irfan Nur Hakim        |");
                    System.out.println("\t |               Kelas 1C/18              |");
                    System.out.println("\t |            --- Deskripsi ---           |");
                    System.out.println("\t |(Program ini merupakan Kasir Rumah Sakit|");
                    System.out.println("\t |   pada project akhir Dasar Pemrogaman  |");
                    System.out.println("\t |    dengan Dosen Bu Mustika Mentari.)   |");
                    System.out.println("\t |      -----------------------------     |");
                    System.out.println("\t |       Prodi D4-Teknik Informatika      |");
                    System.out.println("\t |       Jurusan Teknologi Informasi      |");
                    System.out.println("\t |        Politeknik Negeri Malang        |");
                    System.out.println("\t |                2022/2023               |");
                    System.out.println("\t ------------------------------------------\n");

            }
        }while(true);
    }
    // --------------------------------------------------------------------------------------------------------------------------------------
    static String cariPasien(String[][] dataPasien, String kodePasien) {
        String namaPasien = "";
        for (int i = 0; i < dataPasien.length; i++) {
            if (dataPasien[i][0].equals(kodePasien.trim())) {
                namaPasien = dataPasien[i][1];
                jenisKPasien = dataPasien[i][2];
                umurPasien = dataPasien[i][3];
                alamatPasien = dataPasien[i][4];
                return namaPasien;
            } else {
                namaPasien = "";
            }
        }

        return namaPasien;
    }

    // --------------------------------------------------------------------------------------------------------------------------------------
    static String[][] tambahPasien(String[][] pasienLama, String[] pasienBaru) {
        String[][] dataBaru = new String[pasienLama.length + 1][pasienLama[0].length];

        for (int i = 0; i < pasienLama.length; i++) {
            for (int j = 0; j < pasienLama[0].length; j++) {
                dataBaru[i][j] = pasienLama[i][j];
            }
        }
        // Memasukkan data baru
        for (int i = 0; i < dataBaru[0].length; i++) {
            dataBaru[dataBaru.length - 1][i] = pasienBaru[i];
        }
        return dataBaru;
    }

    // --------------------------------------------------------------------------------------------------------------------------------------
    static int main_menu(String namaPasien) {
        int menu;
        System.out.println("===================================================================");
        System.out.println("\n\t\t    Selamat datang,\n\t\t    " + namaPasien);
        System.out.println("\n\t\t  Menu Rawat RS. MINH CARE");
        System.out.println("\t ------------------------------------------");
        System.out.println("\t |\t (1) - Rawat Inap                 |");
        System.out.println("\t |\t (2) - Rawat Jalan                |");
        System.out.println("\t |\t (3) - Keluar                     |");
        System.out.println("\t ------------------------------------------");
        System.out.println("===================================================================");
        System.out.print("\nPilih menu [1|2|3] = ");
        menu = input.nextInt();
        switch (menu) {
            case 1:
                rawat_inap();
                break;
            case 2:
                rawat_jalan();
                break;
            case 3:
                char pilih;
                System.out.println("Apakah anda yakin ingin keluar? Y (Yes)/ N (No): ");
                pilih = input.next().charAt(0);
                if ((pilih == 'y' || pilih == 'Y')) {
                    System.out.println("\n\n\n\t\tSYSTEM AKAN KEMBALI\n\t\tKE MENU UNTUK MASUK\n\n\n\n");
                    main(null);
                } else if ((pilih == 'N' || pilih == 'n')) {
                    main_menu(namaPasien);
                } else {
                    System.out.println("\n\n\n\t\tInput Tidak Valid\n\t\tSystem Program akan keluar.\n\n\n");
                    main(null);
                    break;
                }
            default:
                System.out.println("-");
                break;
        }
        return menu;
    }

    // --------------------------------------------------------------------------------------------------------------------------------------
    static void rawat_inap() {
        int total = 0, lama_inap = 0;
        String tipeKamar[] = {"ICU", "VVIP", "VIP", "Kelas 1", "Kelas 2", "Kelas 3" };
        int hargaKamar[][] = {
                { 680000, 850000, 935000 },
                { 520000, 650000, 715000 },
                { 466000, 582000, 412000 },
                { 300000, 375000, 412000 },
                { 236000, 295000, 324000 },
                { 120000, 150000, 165000 },
        };
        String tingkatPerawatan[] = {"Ringan","Sedang","Berat"};
        int hargaRawat[] ={50000,75000,100000};

        System.out.println("-------------------------------------------------------------------------");
        System.out.println("| " +"No  |" +"\tJenis Pelayanan\t" + "|" + "   Umum/Gigi  " + " | " + "  Spesialis  " + " | "+ "Sub Spesialis" + " |");
        System.out.println("-------------------------------------------------------------------------");
        for (int i = 0; i < hargaKamar.length; i++) {
            System.out.print("| "+(i+1)+" |\t" + tipeKamar[i] + "\t\t|\t ");
            for (int j = 0; j < hargaKamar[0].length; j++) {
                System.out.print(hargaKamar[i][j] + "\t|\t");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------------------------------");
        System.out.print("\nMasukkan jenis pelayanan tipe kamar [1|2|3|4|5] : ");
        pilihKamar = input.nextInt();

        if (pilihKamar == 1) { //icu
            kamar = tipeKamar[0];
            System.out.println("Tipe kamar = " + tipeKamar[0] +" (Bagi Pasien Tingkat Perawatan Berat)");
            
            System.out.print("\n======== Tarif Pelayanan ========\n|\t-> Umum/Gigi \t\t|\n|\t-> Spesialis \t\t|\n|\t-> Sub Spesialis\t|\n");
            System.out.println("---------------------------------");
            System.out.print("Masukkan jenis tarif pelayanan anda [Ketik Kata] : ");
            tipePelayanan = input.next();
            if (tipePelayanan.equalsIgnoreCase("UMUM")) {
                hargaPelayanan = hargaKamar[0][0];
            } else if (tipePelayanan.equalsIgnoreCase("Spesialis")) {
                hargaPelayanan = hargaKamar[0][1];
            } else if (tipePelayanan.equalsIgnoreCase("Sub Spesialis")) {
                hargaPelayanan = hargaKamar[0][2];
            } else {
                System.out.println("Pilihan yang anda pilih tidak valid");
            }
        }
        else if(pilihKamar==2){
            kamar = tipeKamar[1];
            System.out.println("Tipe kamar = " + tipeKamar[1]);
            
            System.out.print("\n======== Tarif Pelayanan ========\n|\t-> Umum/Gigi \t\t|\n|\t-> Spesialis \t\t|\n|\t-> Sub Spesialis\t|\n");
            System.out.println("---------------------------------");
            System.out.print("Masukkan jenis tarif pelayanan anda [Ketik Kata] : ");
            tipePelayanan = input.next();
            if (tipePelayanan.equalsIgnoreCase("UMUM")) {
                hargaPelayanan = hargaKamar[1][0];
            } else if (tipePelayanan.equalsIgnoreCase("Spesialis")) {
                hargaPelayanan = hargaKamar[1][1];
            } else if (tipePelayanan.equalsIgnoreCase("Sub Spesialis")) {
                hargaPelayanan = hargaKamar[1][2];
            } else {
                System.out.println("Pilihan yang anda pilih tidak valid");
            }
        }
        else if(pilihKamar==3){
            kamar = tipeKamar[2];
            System.out.println("Tipe kamar = " + tipeKamar[2]);
            
            System.out.print("\n======== Tarif Pelayanan ========\n|\t-> Umum/Gigi \t\t|\n|\t-> Spesialis \t\t|\n|\t-> Sub Spesialis\t|\n");
            System.out.println("---------------------------------");
            System.out.print("Masukkan jenis tarif pelayanan anda [Ketik Kata] : ");
            tipePelayanan = input.next();
            if (tipePelayanan.equalsIgnoreCase("UMUM")) {
                hargaPelayanan = hargaKamar[2][0];
            } else if (tipePelayanan.equalsIgnoreCase("Spesialis")) {
                hargaPelayanan = hargaKamar[2][1];
            } else if (tipePelayanan.equalsIgnoreCase("Sub Spesialis")) {
                hargaPelayanan = hargaKamar[2][2];
            } else {
                System.out.println("Pilihan yang anda pilih tidak valid");
            }
        }
        else if(pilihKamar==4){
            kamar = tipeKamar[3];
            System.out.println("Tipe kamar = " + tipeKamar[3]);
            
            System.out.print("\n======== Tarif Pelayanan ========\n|\t-> Umum/Gigi \t\t|\n|\t-> Spesialis \t\t|\n|\t-> Sub Spesialis\t|\n");
            System.out.println("---------------------------------");
            System.out.print("Masukkan jenis tarif pelayanan anda [Ketik Kata] : ");
            tipePelayanan = input.next();
            if (tipePelayanan.equalsIgnoreCase("UMUM")) {
                hargaPelayanan = hargaKamar[3][0];
            } else if (tipePelayanan.equalsIgnoreCase("Spesialis")) {
                hargaPelayanan = hargaKamar[3][1];
            } else if (tipePelayanan.equalsIgnoreCase("Sub Spesialis")) {
                hargaPelayanan = hargaKamar[3][2];
            } else {
                System.out.println("Pilihan yang anda pilih tidak valid");
            }
        }
        else if(pilihKamar==5) {
            kamar = tipeKamar[4];
            System.out.println("Tipe kamar = " + tipeKamar[4]);
            
            System.out.print("\n======== Tarif Pelayanan ========\n|\t-> Umum/Gigi \t\t|\n|\t-> Spesialis \t\t|\n|\t-> Sub Spesialis\t|\n");
            System.out.println("---------------------------------");
            System.out.print("Masukkan jenis tarif pelayanan anda [Ketik Kata] : ");
            tipePelayanan = input.next();
            if (tipePelayanan.equalsIgnoreCase("UMUM")) {
                hargaPelayanan = hargaKamar[4][0];
            } else if (tipePelayanan.equalsIgnoreCase("Spesialis")) {
                hargaPelayanan = hargaKamar[4][1];
            } else if (tipePelayanan.equalsIgnoreCase("Sub Spesialis")) {
                hargaPelayanan = hargaKamar[4][2];
            } else {
                System.out.println("Pilihan yang anda pilih tidak valid");
            }
        }
        else if(pilihKamar==6) {
            kamar = tipeKamar[5];
            System.out.println("Tipe kamar = " + tipeKamar[5]);
            
            System.out.print("\n======== Tarif Pelayanan ========\n|\t-> Umum/Gigi \t\t|\n|\t-> Spesialis \t\t|\n|\t-> Sub Spesialis\t|\n");
            System.out.println("---------------------------------");
            System.out.print("Masukkan jenis tarif pelayanan anda [Ketik Kata] : ");
            tipePelayanan = input.next();
            if (tipePelayanan.equalsIgnoreCase("UMUM".trim())) {
                hargaPelayanan = hargaKamar[5][0];
            } else if (tipePelayanan.equalsIgnoreCase("Spesialis".trim())) {
                hargaPelayanan = hargaKamar[5][1];
            } else if (tipePelayanan.equalsIgnoreCase("Sub Spesialis".trim())) {
                hargaPelayanan = hargaKamar[5][2];
            } else {
                System.out.println("Pilihan yang anda pilih tidak valid");
            }
        }
        else {
            System.out.println("Pilihan yang anda pilih tidak valid");
        }

        System.out.println("\n======= Tingkat Perawatan =======\n|\t1. Ringan \t\t|\n|\t2. Sedang \t\t|\n|\t3. Berat \t\t|");
        System.out.println("---------------------------------");
        System.out.print("Masukkan tingkat perawatan anda [1|2|3] : ");
        pilihPerawatan = input.nextInt();
        if (pilihPerawatan == 1) {
            tingkatRawat = tingkatPerawatan[0]; 
            hargaPerawatan = hargaRawat[0];// ringan
        } else if (pilihPerawatan==2) {
            tingkatRawat = tingkatPerawatan[1]; 
            hargaPerawatan = hargaRawat[1];// ringan
            
        } else if (pilihPerawatan==3) {
            tingkatRawat = tingkatPerawatan[2]; 
            hargaPerawatan = hargaRawat[2];// ringan

        } else {
            System.out.println("Pilihan yang anda pilih tidak valid");
        }
        total = hargaPelayanan + hargaPerawatan;

        System.out.println("\n-------------- INPUT - MASUKKAN ---------------");
        System.out.print("Lama menginap anda (hari)\t: ");
        lama_inap = input.nextInt();
        System.out.print("\nApa Gejala Penyakit anda?\t: ");
        gejala = inputString.next().trim();
        System.out.print("\nNama Dokter yang melayani anda\t: dr.");
        dokter = userInput.nextLine().trim();
        tagihan = total * lama_inap;
        System.out.println("\n-----------------------------------------------");
        System.out.print("Apakah anda ingin membayar sekarang (Y/N) : ");
        bayar = input.next().charAt(0);
        if (bayar == 'Y' || bayar == 'y') {
            System.out.println("\n=========== Metode Pembayaran ===========\n|\t1. Cash/Tunai\t\t\t|\n|\t2. BPJS\t\t\t\t|\n|\t3. Transfer Bank\t\t|");
            System.out.println("-----------------------------------------");
            System.out.print("Pilih Metode pembayaran [1|2|3] : ");
            metodBayar = input.nextInt();
            if (metodBayar == 1) {
                System.out.println("------------------------------------");
                System.out.println("|            CASH/TUNAI            |");
                System.out.println("------------------------------------");
                pajak = 0.05;
                totalPajak = pajak * tagihan;
                totalTagihan = (long)(tagihan + totalPajak);
                //----------------------------------------------------cetaknota
                    System.out.println("\n\n----------------------------");
                    System.out.println("|   STRUK NOTA RAWAT INAP  |");
                    System.out.println("----------------------------");
                    LocalDateTime tglWaktu_hariIni = LocalDateTime.now();
                    DateTimeFormatter tglFormat = DateTimeFormatter.ofPattern("\tdd-MM-yyyy\t|\tHH:mm:ss");
                    String format_tgl = tglWaktu_hariIni.format(tglFormat);
                    System.out.println("\n\t  ======= RUMAH SAKIT UMUM MINH CARE =======");
                    System.out.println("\t Jl. Raya Tumpang No.122, Kab.Malang, JawaTimur \n");
                    System.out.println("==========================================================================");
                    System.out.println("Tanggal | Waktu\t: " + format_tgl);
                    System.out.println("--------------------------------------------------------------------------");
                    System.out.println("| Nama Pasien\t: " + namaPasien +"\t\t| No/Kode Pasien\t: "+kodePasien);
                    System.out.println("| Jenis Kelamin\t: " + jenisKPasien+"\t\t| Nama Dokter\t: "+dokter);
                    System.out.println("| Usia Pasien\t: " +umurPasien+"\t\t| Metode Bayar\t: "+metodBayar+" (Cash/Tunai)");
                    System.out.println("| Alamat Pasien\t: " + alamatPasien+"\t\t| Nama Kasir\t: Admin");           
                    System.out.println("==========================================================================");
                    System.out.println("\t\t\t| Tindakan dan Layanan Transaksi |");
                    System.out.println("\t\t\t----------------------------------");
                    System.out.println("Gejala Sakit\t\t\t " + gejala );
                    System.out.println("Tipe Kamar\t\t\t " + kamar + "\t\t");
                    System.out.println("Jenis Pelayanan\t\t\t " + tipePelayanan+"\t\t@\tRp"+hargaPelayanan);
                    System.out.println("Tingkat Perawatan+Include Obat " + tingkatRawat +"\t\t@\tRp"+hargaPerawatan);
                    System.out.println("Lama Menginap\t\t\t " + lama_inap + " Hari x Rp"+ total +" :\tRp"+ tagihan);
                    System.out.println("--------------------------------------------------------------------------");
                    System.out.println("\t\t\t\tTotal Biaya\t:\tRp" + tagihan);
                    System.out.println("\t\t\t\tPajak PPN 5%\t:\tRp" + totalPajak);
                    System.out.println("\t\t\t\t------------------------------------------");
                    System.out.println("\t\t\t\tTotal Tagihan\t:\tRp" + totalTagihan + "\n");
                    System.out.print("\t\t\t\tCash Anda\t:\tRp");
                    cash = input.nextLong();
                    totalTagihan = (long)(cash - totalTagihan);
                    System.out.println("\t\t\t\t------------------------------------------");
                    System.out.println("\t\t\t\tKembali\t\t:\tRp " + totalTagihan);
                    System.out.println("\n==========================================================================\n\n");
                    System.out.print("Kembali ke menu utama (y/n) : ");
                    pilih = input.next().charAt(0);
                    switch (pilih) {
                        case 'y':
                            main_menu(namaPasien);
                            break;
                        case 'n':
                            main(tipeKamar);
                        default:
                            main(tipeKamar);
                            break;
                    }
            }
            else if(metodBayar==2){
                System.out.println("------------------------------------");
                System.out.println("|              B P J S             |");
                System.out.println("------------------------------------");
                System.out.print("Masukkan NIK (16 Digit)\t: ");
                nik = userInput.nextLine();
                System.out.print("\n========= Golongan BPJS =========\n|\t- VVIP \t\t\t|\n|\t- VIP \t\t\t|\n|\t- Kelas 1 \t\t|\n|\t- Kelas 2 \t\t|\n|\t- Kelas 3 \t\t|\n");
                System.out.println("---------------------------------");
                System.out.print("\nKetikkan Golongan BPJS [Ketik Kata]\t: ");
                golBpjs = userInput.next();
                if(golBpjs.equalsIgnoreCase("VVIP".trim())){
                    golBpjs="VVIP";
                }
                else if(golBpjs.equalsIgnoreCase("VIP".trim())){
                    golBpjs="VIP";
                }
                else if(golBpjs.equalsIgnoreCase("Kelas 1".trim())){
                    golBpjs="Kelas 1";
                }
                else if(golBpjs.equalsIgnoreCase("Kelas 2".trim())){
                    golBpjs="Kelas 2";

                }
                else if(golBpjs.equalsIgnoreCase("Kelas 3".trim())){
                    golBpjs="Kelas 3";
                }
                pajak = 0.00;
                totalPajak = pajak * tagihan;
                totalTagihan = (long)(tagihan + totalPajak);
                biayaAdmin = 10000;
                totalTagihan=(totalTagihan-totalTagihan)+biayaAdmin;
                System.out.println("\n\n----------------------------");
                System.out.println("|   STRUK NOTA RAWAT INAP  |");
                System.out.println("----------------------------");
                    LocalDateTime tglWaktu_hariIni = LocalDateTime.now();
                    DateTimeFormatter tglFormat = DateTimeFormatter.ofPattern("\tdd-MM-yyyy\t|\tHH:mm:ss");
                    String format_tgl = tglWaktu_hariIni.format(tglFormat);
                    System.out.println("\n\t  ======= RUMAH SAKIT UMUM MINH CARE =======");
                    System.out.println("\t Jl. Raya Tumpang No.122, Kab.Malang, JawaTimur \n");
                    System.out.println("====================================================================");
                    System.out.println("Tanggal | Waktu\t: " + format_tgl);
                    System.out.println("--------------------------------------------------------------------");
                    System.out.println("Nama Pasien\t: " + namaPasien +"\t\tNo/Kode Pasien\t: "+kodePasien);
                    System.out.println("Jenis Kelamin\t: " + jenisKPasien+"\t\tNama Dokter\t: "+dokter);
                    System.out.println("Usia Pasien\t: " +umurPasien+"\t\tMetode Bayar\t: "+metodBayar+" (BPJS)");
                    System.out.println("Alamat Pasien\t: " + alamatPasien+"\t\t\tGol. BPJS\t: "+golBpjs);           
                    System.out.println("NIK Pasien\t: " + nik+"\tNama Kasir\t: Admin");           
                    System.out.println("====================================================================");
                    System.out.println("\t\t\t| Tindakan dan Layanan Transaksi |");
                    System.out.println("\t\t\t----------------------------------");
                    System.out.println("Gejala Sakit\t:\t\t " + gejala );
                    System.out.println("Tipe Kamar\t:\t\t " + pilihKamar + "\t\t");
                    System.out.println("Tipe Pelayanan\t:\t\t " + tipePelayanan+"\t\t"+hargaPelayanan);
                    System.out.println("Tingkat Perawatan+Include obat : " + tingkatRawat+"\t\t"+hargaPerawatan);
                    System.out.println("Lama Menginap\t:\t\t " + lama_inap + " Hari x Rp"+ total +" = Rp"+ tagihan);
                    System.out.println("--------------------------------------------------------------------");
                    System.out.println("\t\t\t\tTotal Biaya\t:\tRp" + tagihan);
                    System.out.println("\t\t\t\tPajak PPN "+pajak+"\t:\tRp" + totalPajak);
                    System.out.println("\t\t\t\tBiaya Admin\t:\tRp" + biayaAdmin);
                    System.out.println("\t\t\t\t-------------------------------------");
                    System.out.println("\t\t\t\tTOTAL TAGIHAN\t:\tRp" + totalTagihan );
                    System.out.println("\t\t\t\t(Anda Mendapat Potongan 100% dari BPJS)");
                    System.out.print("\n\t\t\t\tCash Anda\t:\tRp");
                    cash = input.nextLong();
                    totalTagihan = cash - totalTagihan;
                    System.out.println("\t\t\t\t-------------------------------------");
                    System.out.println("\t\t\t\tKembali\t\t:\tRp " + totalTagihan);
                    System.out.println("\n====================================================================\n");
                    System.out.print("Kembali ke menu utama (y/n) : ");
                    pilih = input.next().charAt(0);
                    switch (pilih) {
                        case 'y':
                            main_menu(namaPasien);
                            break;
                        case 'n':
                            main(tipeKamar);
                        default:
                            main(tipeKamar);
                            break;
                    }
                }
            else if(metodBayar==3){
                System.out.println("------------------------------------------");
                System.out.println("|              TRANSFER BANK             |");
                System.out.println("------------------------------------------");
                String bank[] = {"Mandiri","BRI","BNI","BCA"}; 
                String hasilBank;
                System.out.println("\n========= BANK ==========\n|\t1. Mandiri \t|\n|\t2. BRI \t\t|\n|\t3. BNI \t\t|\n|\t4. BCA \t\t|");
                System.out.println("-------------------------");
                System.out.print("\nPilih Bank [1|2|3|4]\t: ");
                int pilihBank = input.nextInt();
                if(pilihBank==1){
                    hasilBank=bank[0];
                    diskon = 0.06;
                    totalDiskon = diskon*totalTagihan;
                }
                else if(pilihBank==2){
                    hasilBank=bank[1]; 
                    diskon = 0.04; 
                    totalDiskon = diskon*totalTagihan;
                }
                else if(pilihBank==3){
                    hasilBank=bank[2]; 
                    diskon = 0.03; 
                    totalDiskon = diskon*totalTagihan;
                }
                else{
                    hasilBank=bank[3]; 
                    diskon = 0.02; 
                    totalDiskon = diskon*totalTagihan;
                }

                Random virtualAccount = new Random();
                System.out.println("* NOMOR VIRTUAL ACCOUNT ANDA *");
                System.out.println("\n-------------------------------");
                for (int i = 1; i <= 10; i++) { 
                    int cetakVA = virtualAccount.nextInt(9);
                    System.out.print(" "+cetakVA);
                }
                System.out.println("\n-------------------------------"); 
                System.out.print("\nMasukkan No Virtual Account seperti tampilan diatas\t: ");
                vA = userInput.nextLine();
                pajak = 0.11;
                totalPajak = pajak * tagihan;
                totalTagihan = (long)(tagihan + totalPajak);
                //----------------------------------------------------cetaknota
                System.out.println("\n\n----------------------------");
                System.out.println("|   STRUK NOTA RAWAT INAP  |");
                System.out.println("----------------------------");
                    LocalDateTime tglWaktu_hariIni = LocalDateTime.now();
                    DateTimeFormatter tglFormat = DateTimeFormatter.ofPattern("\tdd-MM-yyyy\t|\tHH:mm:ss");
                    String format_tgl = tglWaktu_hariIni.format(tglFormat);
                    System.out.println("\n\t  ======= RUMAH SAKIT UMUM MINH CARE =======");
                    System.out.println("\t Jl. Raya Tumpang No.122, Kab.Malang, JawaTimur \n");
                    System.out.println("====================================================================");
                    System.out.println("Tanggal | Waktu\t: " + format_tgl);
                    System.out.println("--------------------------------------------------------------------");
                    System.out.println("Nama Pasien\t: " + namaPasien +"\t\t| No/Kode Pasien\t: "+kodePasien);
                    System.out.println("Jenis Kelamin\t: " + jenisKPasien+"\t\t| Nama Dokter\t: "+dokter);
                    System.out.println("Usia Pasien\t: " +umurPasien+"\t\t| Metode Bayar\t: "+metodBayar+" (Bank)");
                    System.out.println("Alamat Pasien\t: " + alamatPasien+"\t\t\t| Nama Bank\t: "+ hasilBank);           
                    System.out.println("Virtual Account\t: " + vA+"\t\t| Nama Kasir\t: Admin");           
                    System.out.println("====================================================================");
                    System.out.println("\t\t\t| Tindakan dan Layanan Transaksi |");
                    System.out.println("\t\t\t----------------------------------");
                    System.out.println("Gejala Sakit\t\t\t: " + gejala );
                    System.out.println("Tipe Kamar\t\t\t: " + pilihKamar + "\t\t");
                    System.out.println("Tipe Pelayanan\t\t\t: " + tipePelayanan+"\t\t@ Rp"+hargaPelayanan);
                    System.out.println("Tingkat Perawatan+Include obat: " + tingkatRawat+"\t\t@ Rp"+hargaPerawatan);
                    System.out.println("Lama Menginap\t\t\t: " + lama_inap + " Hari x Rp"+ total +" : Rp"+ tagihan);
                    System.out.println("--------------------------------------------------------------------");
                    System.out.println("\t\t\t\tTotal Biaya\t:\tRp" + tagihan);
                    System.out.println("\t\t\t\tPajak Transfer 11%:\tRp" + totalPajak);
                    System.out.println("\t\t\t\tDiskon"+diskon+"\t:\tRp" + totalDiskon);
                    System.out.println("\t\t\t\t-------------------------------------");
                    System.out.println("\t\t\t\tTOTAL TAGIHAN\t:\tRp" + totalTagihan + "\n");
                    System.out.print("\t\t\t\tCash Anda\t:\tRp");
                    cash = input.nextLong();
                    totalTagihan = cash - totalTagihan;
                    System.out.println("\t\t\t\t-------------------------------------");
                    System.out.println("\t\t\t\tKembali\t\t:\tRp " + totalTagihan);
                    System.out.println("\n====================================================================\n");
                    System.out.print("Kembali ke menu utama (y/n) : ");
                    pilih = input.next().charAt(0);
                    switch (pilih) {
                        case 'y':
                            main_menu(namaPasien);
                            break;
                        case 'n':
                            main(tipeKamar);
                        default:
                            main(tipeKamar);
                            break;
                    }
            
            } 

        } else {
            main_menu(namaPasien);
        }

    }
    // --------------------------------------------------------------------------------------------------------------------------------------
    static void rawat_jalan() {
        int pilihPoli=0, pilihDokter,pilihObat, totalObat=0, hargaPoli=0, hargaPoliUmum=25000, hargaPoliSpesialis=50000;
        long total=0, tagihanTotal=0;
        String tingkatSakit[] = {"Ringan","Sedang","Berat"};
        String obatUmum[] =  {"Milanta Cair 50 ml","Paracetamol 10 Tablet","Ambroxol isi 10 Tablet","Antibiotik Amoxxilin","Oralit 200 1 Sachet","Vitamin b Complex"};
        int hargaUmum[] = {18000,6000,5000,4500,1000,17000}; 
        String obatGigi[] = {"Betadine Mouthwash","Ponstan Obat Gigi","Ibuprofen Obat Gigi","Dentasol Obat Gigi","Gumafixa Obat Gigi"};
        int hargaGigi[] = {38000, 40000, 30000,25000,255000};
        String obatAnak[] = {"Cetahpil Baby Gentle", "Autan Kids Tube","Hamsaplast Kids Kompres","Salicyl Fresh","Sterimar Baby Nasal"};
        int hargaAnak[] = {92000,24000,1200,22000,162000};
        String obatTHT[] = {"Pysiomer Hypertonic","Roche Bactrim Forte","Sterimar Nose","Cefspan 200","Propolis SM"};
        int hargaTHT[]= {145000,30000,140000,262000,85000};
        String obatJiwa[] = {"Anti-Depresan","Benzodiazepine","Stimulan","AntiPsikotik","Valproic Acid"};
        int hargaJiwa[] = {175000,371000,525000,90000,220000};

        String jenisPoli[] ={"Poli Umum","Poli Gigi","Poli Anak","Poli THT","Poli Jiwa"}; 
        String dataDokter[][] = {
            {"dr. Andi Nirmalasari","dr. Irda Yulianti","dr. Maulina Yunus","dr. Nurul Indah P."},
            {"drg. Vita Nirmala A.","drg. Eva Sutyowati","drg. Christianie Z","drg. Sandy Trimelda"},
            {"dr. Sri Lilijanti W.","dr. Septin Widiretna","dr. Ismiranti Anda","dr. Muh. Riza Hadi"},
            {"dr. Yetty Hambarsari","dr. Rivan Danuaji","dr. Baarid Luqman","dr. Subandi Wijaya"},
            {"DR.dr.Made Setiamika","dr. Ahmad NurHadi","dr. Aziza Viquisa","dr. Putu Wijaya K"},
            {"Elina Raharisti R, Psi","Risa Suryanti, Psi","Syarif Bakri, Psi","Aristianti Wida, Psi"},
        };

        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|" +"No |" +"\tJenis Poli\t" + "|"  +"\tDokter ke-1\t" + "|" +"\tDokter ke-2\t\t" + "|"+"\tDokter ke-3\t\t"+ "|"+"\tDokter ke-4\t\t|");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i < jenisPoli.length; i++) {
            System.out.print("| "+(i+1)+" |\t" + jenisPoli[i] + "\t| ");
            for (int j = 0; j < dataDokter[0].length; j++) {
                System.out.print(dataDokter[i][j] + "\t|\t ");
            }
            System.out.println();
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.print("Silahkan Pilih Poli : ");
        pilihPoli = input.nextInt();
        if(pilihPoli==1){
            poli = jenisPoli[0];
            hargaPoli = hargaPoliUmum;
            System.out.println("Poli yang anda pilih : "+poli);
            System.out.println("\n---------------------------------");
            System.out.println("|No |\tNama Dokter Umum\t|");
            System.out.println("---------------------------------");
            for (int j = 0; j < dataDokter[0].length; j++) {
                System.out.println("| "+(j+1)+" |\t"+dataDokter[0][j]+"\t|");
            }
            System.out.println("---------------------------------");
            System.out.print("Silahkan Pilih Dokter : ");
            pilihDokter = input.nextInt();
            if (pilihDokter==1) {
                dokter=dataDokter[0][0];
                System.out.println("Dokter yang menangani anda : "+dokter);                
            } 
            else if(pilihDokter==2){
                dokter=dataDokter[0][1];
                System.out.println("Dokter yang menangani anda : "+dokter);                
            }
            else if(pilihDokter==3){
                dokter=dataDokter[0][2];
                System.out.println("Dokter yang menangani anda : "+dokter);                
            }
            else if(pilihDokter==4){
                dokter=dataDokter[0][3];
                System.out.println("Dokter yang menangani anda : "+dokter);                
            }
            else {
                System.out.println("Data yang anda inputkan tidak valid");
            }
            System.out.println("\n-------------- INPUT - MASUKKAN ---------------");
            System.out.print("Apa gejala sakit anda? : ");
            gejala=inputString.next();
            do {
                System.out.println("\n-------------------------------------------------");
                System.out.println("|No |\tNama Obat Poli Umum\t|\tHarga\t|");
                System.out.println("-------------------------------------------------");
                for (int i = 0; i < obatUmum.length; i++) {
                    System.out.print("| "+(i+1)+" |\t" + obatUmum[i] + "\t|\t");
                    System.out.print(hargaUmum[i] + "\t|\t\n");
                }
                System.out.println("-------------------------------------------------");
                System.out.print("Masukkan obat yang akan anda beli [1|2|3|4|5|6] : ");
                pilihObat = input.nextInt();
                if (pilihObat==1) {
                    obat = obatUmum[0];
                    System.out.println("Obat Yang anda beli -> "+obat);
                    hargaObat = hargaUmum[0];
                    System.out.print("\nBerapa obat yang anda beli? : ");
                    jumlahObat = input.nextInt();
                    totalObat = hargaObat*jumlahObat;
                } 
                else if (pilihObat==2) {
                    obat = obatUmum[1];
                    System.out.println("Obat Yang anda beli -> "+obat);
                    hargaObat = hargaUmum[1];
                    System.out.print("\nBerapa obat yang anda beli? : ");
                    jumlahObat = input.nextInt();
                    totalObat = hargaObat*jumlahObat;   
                } 
                else if (pilihObat==3) {
                    obat = obatUmum[2];
                    System.out.println("Obat Yang anda beli -> "+obat);
                    hargaObat = hargaUmum[2];
                    System.out.print("\nBerapa obat yang anda beli? : ");
                    jumlahObat = input.nextInt();
                    totalObat = hargaObat*jumlahObat;   
                    
                } 
                else if (pilihObat==4) {
                    obat = obatUmum[3];
                    System.out.println("Obat Yang anda beli -> "+obat);
                    hargaObat = hargaUmum[3];
                    System.out.print("\nBerapa obat yang anda beli? : ");
                    jumlahObat = input.nextInt();
                    totalObat = hargaObat*jumlahObat;                           
                } 
                else if (pilihObat==5) {
                    obat = obatUmum[4];
                    System.out.println("Obat Yang anda beli -> "+obat);
                    hargaObat = hargaUmum[4];
                    System.out.print("\nBerapa obat yang anda beli? : ");
                    jumlahObat = input.nextInt();
                    totalObat = hargaObat*jumlahObat;                                 
                } 
                else if (pilihObat==6) {
                    obat = obatUmum[5];
                    System.out.println("Obat Yang anda beli -> "+obat);
                    hargaObat = hargaUmum[5];
                    System.out.print("\nBerapa obat yang anda beli? : ");
                    jumlahObat = input.nextInt();
                    totalObat = hargaObat*jumlahObat;                                   
                } 
                else {
                    System.out.println("Pilihan obat tidak tersedia");
                }
              System.out.print("Apakah ada tambahan obat? [y/t]: ");
              ulang = input.next().charAt(0);  
            } while(ulang=='y');

            total = hargaPoli + totalObat;
        }
        //GIGI
        else if(pilihPoli==2){
            poli = jenisPoli[1];
            hargaPoli = hargaPoliSpesialis;
            System.out.println("Poli yang anda pilih : "+poli);
            System.out.println("\n---------------------------------");
            System.out.println("|No |\tNama Dokter Umum\t|");
            System.out.println("---------------------------------");
            for (int j = 0; j < dataDokter[1].length; j++) {
                System.out.println("| "+(j+1)+" |\t"+dataDokter[1][j]+"\t|");
            }
            System.out.println("---------------------------------");
            System.out.print("Silahkan Pilih Dokter : ");
            pilihDokter = input.nextInt();
            if (pilihDokter==1) {
                dokter=dataDokter[1][0];
                System.out.println("Dokter yang menangani anda : "+dokter);                
            } 
            else if(pilihDokter==2){
                dokter=dataDokter[1][1];
                System.out.println("Dokter yang menangani anda : "+dokter);                
            }
            else if(pilihDokter==3){
                dokter=dataDokter[1][2];
                System.out.println("Dokter yang menangani anda : "+dokter);                
            }
            else if(pilihDokter==4){
                dokter=dataDokter[1][3];
                System.out.println("Dokter yang menangani anda : "+dokter);                
            }
            else {
                System.out.println("Data yang anda inputkan tidak valid");
            }
            System.out.println("\n-------------- INPUT - MASUKKAN ---------------");
            System.out.print("Apa gejala sakit anda? : ");
            gejala=inputString.next();
            do {
                System.out.println("\n-------------------------------------------------");
                System.out.println("|No |\tNama Obat Poli Umum\t|\tHarga\t|");
                System.out.println("-------------------------------------------------");
                for (int i = 0; i < obatGigi.length; i++) {
                    System.out.print("| "+(i+1)+" |\t" + obatGigi[i] + "\t|\t");
                    System.out.print(hargaGigi[i] + "\t|\t\n");
                }
                System.out.println("-------------------------------------------------");
                System.out.print("Masukkan obat yang akan anda beli [1|2|3|4|5] : ");
                pilihObat = input.nextInt();
                if (pilihObat==1) {
                    obat = obatGigi[0];
                    System.out.println("Obat Yang anda beli -> "+obat);
                    hargaObat = hargaGigi[0];
                    System.out.print("\nBerapa obat yang anda beli? : ");
                    jumlahObat = input.nextInt();
                    totalObat = hargaObat*jumlahObat;
                } 
                else if (pilihObat==2) {
                    obat = obatGigi[1];
                    System.out.println("Obat Yang anda beli -> "+obat);
                    hargaObat = hargaGigi[1];
                    System.out.print("\nBerapa obat yang anda beli? : ");
                    jumlahObat = input.nextInt();
                    totalObat = hargaObat*jumlahObat;   
                } 
                else if (pilihObat==3) {
                    obat = obatGigi[2];
                    System.out.println("Obat Yang anda beli -> "+obat);
                    hargaObat = hargaGigi[2];
                    System.out.print("\nBerapa obat yang anda beli? : ");
                    jumlahObat = input.nextInt();
                    totalObat = hargaObat*jumlahObat;   
                    
                } 
                else if (pilihObat==4) {
                    obat = obatGigi[3];
                    System.out.println("Obat Yang anda beli -> "+obat);
                    hargaObat = hargaGigi[3];
                    System.out.print("\nBerapa obat yang anda beli? : ");
                    jumlahObat = input.nextInt();
                    totalObat = hargaObat*jumlahObat;                             
                } 
                else if (pilihObat==5) {
                    obat = obatGigi[4];
                    System.out.println("Obat Yang anda beli -> "+obat);
                    hargaObat = hargaGigi[4];
                    System.out.print("\nBerapa obat yang anda beli? : ");
                    jumlahObat = input.nextInt();
                    totalObat = hargaObat*jumlahObat;                                  
                } 
                else {
                    System.out.println("Pilihan obat tidak tersedia");
                }
              System.out.print("Apakah ada tambahan obat? [y/t]: ");
              ulang = input.next().charAt(0);  
            } while(ulang=='y');

            total = hargaPoli + totalObat;
        }
        else if(pilihPoli==3){
            poli = jenisPoli[2];
            hargaPoli = hargaPoliSpesialis;
            System.out.println("Poli yang anda pilih : "+poli);
            System.out.println("\n---------------------------------");
            System.out.println("|No |\tNama Dokter Anak\t|");
            System.out.println("---------------------------------");
            for (int j = 0; j < dataDokter[2].length; j++) {
                System.out.println("| "+(j+1)+" |\t"+dataDokter[2][j]+"\t|");
            }
            System.out.println("---------------------------------");
            System.out.print("Silahkan Pilih Dokter : ");
            pilihDokter = input.nextInt();
            if (pilihDokter==1) {
                dokter=dataDokter[2][0];
                System.out.println("Dokter yang menangani anda : "+dokter);                
            } 
            else if(pilihDokter==2){
                dokter=dataDokter[2][1];
                System.out.println("Dokter yang menangani anda : "+dokter);                
            }
            else if(pilihDokter==3){
                dokter=dataDokter[2][2];
                System.out.println("Dokter yang menangani anda : "+dokter);                
            }
            else if(pilihDokter==4){
                dokter=dataDokter[2][3];
                System.out.println("Dokter yang menangani anda : "+dokter);                
            }
            else {
                System.out.println("Data yang anda inputkan tidak valid");
            }
            System.out.println("\n-------------- INPUT - MASUKKAN ---------------");
            System.out.print("Apa gejala sakit anda? : ");
            gejala=inputString.next().trim();
            do {
                System.out.println("\n-------------------------------------------------");
                System.out.println("|No |\tNama Obat Poli Umum\t|\tHarga\t|");
                System.out.println("-------------------------------------------------");
                for (int i = 0; i < obatAnak.length; i++) {
                    System.out.print("| "+(i+1)+" |\t" + obatAnak[i] + "\t|\t");
                    System.out.print(hargaAnak[i] + "\t|\t\n");
                }
                System.out.println("-------------------------------------------------");
                System.out.print("Masukkan obat yang akan anda beli [1|2|3|4|5] : ");
                pilihObat = input.nextInt();
                if (pilihObat==1) {
                    obat = obatAnak[0];
                    System.out.println("Obat Yang anda beli -> "+obat);
                    hargaObat = hargaAnak[0];
                    System.out.print("\nBerapa obat yang anda beli? : ");
                    jumlahObat = input.nextInt();
                    totalObat = hargaObat*jumlahObat;
                } 
                else if (pilihObat==2) {
                    obat = obatAnak[1];
                    System.out.println("Obat Yang anda beli -> "+obat);
                    hargaObat = hargaAnak[1];
                    System.out.print("\nBerapa obat yang anda beli? : ");
                    jumlahObat = input.nextInt();
                    totalObat = hargaObat*jumlahObat;   
                } 
                else if (pilihObat==3) {
                    obat = obatAnak[2];
                    System.out.println("Obat Yang anda beli -> "+obat);
                    hargaObat = hargaAnak[2];
                    System.out.print("\nBerapa obat yang anda beli? : ");
                    jumlahObat = input.nextInt();
                    totalObat = hargaObat*jumlahObat;   
                } 
                else if (pilihObat==4) {
                    obat = obatAnak[3];
                    System.out.println("Obat Yang anda beli -> "+obat);
                    hargaObat = hargaAnak[3];
                    System.out.print("\nBerapa obat yang anda beli? : ");
                    jumlahObat = input.nextInt();
                    totalObat = hargaObat*jumlahObat;   
                } 
                else if (pilihObat==5) {
                    obat = obatAnak[4];
                    System.out.println("Obat Yang anda beli -> "+obat);
                    hargaObat = hargaAnak[4];
                    System.out.print("\nBerapa obat yang anda beli? : ");
                    jumlahObat = input.nextInt();
                    totalObat = hargaObat*jumlahObat;   
                } 
                else {
                    System.out.println("Pilihan obat tidak tersedia");
                }
              System.out.print("Apakah ada tambahan obat? [y/t]: ");
              ulang = input.next().charAt(0);  
            } while(ulang=='y');

            total = hargaPoli + totalObat;
        }
        else if(pilihPoli==4){
            poli = jenisPoli[3];
            hargaPoli = hargaPoliSpesialis;
            System.out.println("Poli yang anda pilih : "+poli);
            System.out.println("\n---------------------------------");
            System.out.println("|No |      Nama Dokter THT      |");
            System.out.println("---------------------------------");
            for (int j = 0; j < dataDokter[3].length; j++) {
                System.out.println("| "+(j+1)+" |\t"+dataDokter[3][j]+"\t|");
            }
            System.out.println("---------------------------------");
            System.out.print("Silahkan Pilih Dokter : ");
            pilihDokter = input.nextInt();
            if (pilihDokter==1) {
                dokter=dataDokter[3][0];
                System.out.println("Dokter yang menangani anda : "+dokter);                
            } 
            else if(pilihDokter==2){
                dokter=dataDokter[3][1];
                System.out.println("Dokter yang menangani anda : "+dokter);                
            }
            else if(pilihDokter==3){
                dokter=dataDokter[3][2];
                System.out.println("Dokter yang menangani anda : "+dokter);                
            }
            else if(pilihDokter==4){
                dokter=dataDokter[3][3];
                System.out.println("Dokter yang menangani anda : "+dokter);                
            }
            else {
                System.out.println("Data yang anda inputkan tidak valid");
            }
            System.out.println("\n-------------- INPUT - MASUKKAN ---------------");
            System.out.print("Apa gejala sakit anda? : ");
            gejala=inputString.next();
            do {
                System.out.println("\n-------------------------------------------------");
                System.out.println("|No |\tNama Obat Poli Umum\t|\tHarga\t|");
                System.out.println("-------------------------------------------------");
                for (int i = 0; i < obatTHT.length; i++) {
                    System.out.print("| "+(i+1)+" |\t" + obatTHT[i] + "\t|\t");
                    System.out.print(hargaTHT[i] + "\t|\t\n");
                }
                System.out.println("-------------------------------------------------");
                System.out.print("Masukkan obat yang akan anda beli [1|2|3|4|5] : ");
                pilihObat = input.nextInt();
                if (pilihObat==1) {
                    obat = obatTHT[0];
                    System.out.println("Obat Yang anda beli -> "+obat);
                    hargaObat = hargaTHT[0];
                    System.out.print("\nBerapa obat yang anda beli? : ");
                    jumlahObat = input.nextInt();
                    totalObat = hargaObat*jumlahObat;
                } 
                else if (pilihObat==2) {
                    obat = obatTHT[1];
                    System.out.println("Obat Yang anda beli -> "+obat);
                    hargaObat = hargaTHT[1];
                    System.out.print("\nBerapa obat yang anda beli? : ");
                    jumlahObat = input.nextInt();
                    totalObat = hargaObat*jumlahObat;
                } 
                else if (pilihObat==3) {
                    obat = obatTHT[2];
                    System.out.println("Obat Yang anda beli -> "+obat);
                    hargaObat = hargaTHT[2];
                    System.out.print("\nBerapa obat yang anda beli? : ");
                    jumlahObat = input.nextInt();
                    totalObat = hargaObat*jumlahObat;  
                } 
                else if (pilihObat==4) {
                    obat = obatTHT[3];
                    System.out.println("Obat Yang anda beli -> "+obat);
                    hargaObat = hargaTHT[3];
                    System.out.print("\nBerapa obat yang anda beli? : ");
                    jumlahObat = input.nextInt();
                    totalObat = hargaObat*jumlahObat; 
                } 
                else if (pilihObat==5) {
                    obat = obatTHT[4];
                    System.out.println("Obat Yang anda beli -> "+obat);
                    hargaObat = hargaTHT[4];
                    System.out.print("\nBerapa obat yang anda beli? : ");
                    jumlahObat = input.nextInt();
                    totalObat = hargaObat*jumlahObat;
                } 
                else {
                    System.out.println("Pilihan obat tidak tersedia");
                }
              System.out.print("Apakah ada tambahan obat? [y/t]: ");
              ulang = input.next().charAt(0);  
            } while(ulang=='y');

            total = hargaPoli + totalObat;
        
        }
        else if(pilihPoli==5){
            poli = jenisPoli[4];
            hargaPoli = hargaPoliSpesialis;
            System.out.println("Poli yang anda pilih : "+poli);
            System.out.println("\n---------------------------------");
            System.out.println("|No |\tNama Dokter Jiwa\t|");
            System.out.println("---------------------------------");
            for (int j = 0; j < dataDokter[4].length; j++) {
                System.out.println("| "+(j+1)+" |\t"+dataDokter[4][j]+"\t|");
            }
            System.out.println("---------------------------------");
            System.out.print("Silahkan Pilih Dokter : ");
            pilihDokter = input.nextInt();
            if (pilihDokter==1) {
                dokter=dataDokter[4][0];
                System.out.println("Dokter yang menangani anda : "+dokter);                
            } 
            else if(pilihDokter==2){
                dokter=dataDokter[4][1];
                System.out.println("Dokter yang menangani anda : "+dokter);                
            }
            else if(pilihDokter==3){
                dokter=dataDokter[4][2];
                System.out.println("Dokter yang menangani anda : "+dokter);                
            }
            else if(pilihDokter==4){
                dokter=dataDokter[4][3];
                System.out.println("Dokter yang menangani anda : "+dokter);                
            }
            else {
                System.out.println("Data yang anda inputkan tidak valid");
            }
            System.out.println("\n-------------- INPUT - MASUKKAN ---------------");
            System.out.print("Apa gejala sakit anda? : ");
            gejala=inputString.next();
            do {
                System.out.println("\n-------------------------------------------------");
                System.out.println("|No |\tNama Obat Poli Umum\t|\tHarga\t|");
                System.out.println("-------------------------------------------------");
                for (int i = 0; i < obatJiwa.length; i++) {
                    System.out.print("| "+(i+1)+" |\t" + obatJiwa[i] + "\t|\t");
                    System.out.print(hargaJiwa[i] + "\t|\t\n");
                }
                System.out.println("-------------------------------------------------");
                System.out.print("Masukkan obat yang akan anda beli [1|2|3|4|5] : ");
                pilihObat = input.nextInt();
                if (pilihObat==1) {
                    obat = obatJiwa[0];
                    System.out.println("Obat Yang anda beli -> "+obat);
                    hargaObat = hargaJiwa[0];
                    System.out.print("\nBerapa obat yang anda beli? : ");
                    jumlahObat = input.nextInt();
                    totalObat = hargaObat*jumlahObat;
                } 
                else if (pilihObat==2) {
                    obat = obatJiwa[1];
                    System.out.println("Obat Yang anda beli -> "+obat);
                    hargaObat = hargaJiwa[1];
                    System.out.print("\nBerapa obat yang anda beli? : ");
                    jumlahObat = input.nextInt();
                    totalObat = hargaObat*jumlahObat;
                } 
                else if (pilihObat==3) {
                    obat = obatJiwa[2];
                    System.out.println("Obat Yang anda beli -> "+obat);
                    hargaObat = hargaJiwa[2];
                    System.out.print("\nBerapa obat yang anda beli? : ");
                    jumlahObat = input.nextInt();
                    totalObat = hargaObat*jumlahObat;
                } 
                else if (pilihObat==4) {
                    obat = obatJiwa[3];
                    System.out.println("Obat Yang anda beli -> "+obat);
                    hargaObat = hargaJiwa[3];
                    System.out.print("\nBerapa obat yang anda beli? : ");
                    jumlahObat = input.nextInt();
                    totalObat = hargaObat*jumlahObat; 
                } 
                else if (pilihObat==5) {
                    obat = obatTHT[4];
                    System.out.println("Obat Yang anda beli -> "+obat);
                    hargaObat = hargaTHT[4];
                    System.out.print("\nBerapa obat yang anda beli? : ");
                    jumlahObat = input.nextInt();
                    totalObat = hargaObat*jumlahObat;
                } 
                else {
                    System.out.println("Pilihan obat tidak tersedia");
                }
              System.out.print("Apakah ada tambahan obat? [y/t]: ");
              ulang = input.next().charAt(0);  
            } while(ulang=='y');

            total = hargaPoli + totalObat;

        }
        else{
            System.out.println("Jenis Poli yang anda pilih tidak Valid");
            System.out.printf("\n\n\n\t\tSYSTEM AKAN KEMBALI\n\t\tKE MENU UTAMA\n\n\n\n");
            main_menu(namaPasien);
        }
        System.out.println("\n======= Tingkat Perawatan =======\n|\t1. Ringan \t\t|\n|\t2. Sedang \t\t|\n|\t3. Berat \t\t|");
        System.out.println("---------------------------------");
        System.out.print("Masukkan tingkat perawatan anda [1|2|3] : ");
        pilihPerawatan = input.nextInt();
        if (pilihPerawatan == 1) {
            tingkatRawat = tingkatSakit[0]; 
            System.out.println("\n---------------------------------------------------------------------");
            System.out.println("|   Anda diperbolehkan untuk pulang dan minum obat dirumah secara   |");
            System.out.println("|               teratur serta selalu jaga kesehatan                 |");
            System.out.println("---------------------------------------------------------------------");
        } else if (pilihPerawatan==2) {
            tingkatRawat = tingkatSakit[1]; 
            System.out.println("\n---------------------------------------------------------------------");
            System.out.println("| Anda diperbolehkan untuk pulang, tetapi setiap 2 minggu sekali    |");
            System.out.println("| anda dianjurkan untuk ke rawat jalan dan konsultasi dengan dokter |");
            System.out.println("| Minumlah obat dirumah secara teratur serta selalu jaga kesehatan  |");
            System.out.println("---------------------------------------------------------------------");
        } else if (pilihPerawatan==3) {
            tingkatRawat = tingkatSakit[2]; 
            System.out.println("\n---------------------------------------------------------");
            System.out.println("|       Anda dianjurkan untuk pergi ke rawat inap       |");
            System.out.println("|       untuk mendapat penanganganan yang lebih         |");
            System.out.println("---------------------------------------------------------");
            System.out.println("Apakah anda bersedia untuk pergi ke rawat Inap? [y/t]:");
            pilih = input.next().charAt(0);
            if (pilih=='y') {
                rawat_inap();
            }
        } else {
            System.out.println("Pilihan yang anda pilih tidak valid");
        }

        System.out.print("\nApakah anda ingin membayar sekarang (Y/N) : ");
        bayar = input.next().charAt(0);
        if (bayar == 'Y' || bayar == 'y') {
            System.out.println("\n=========== Metode Pembayaran ===========\n|\t1. Cash/Tunai\t\t\t|\n|\t2. BPJS\t\t\t\t|\n|\t3. Transfer Bank\t\t|");
            System.out.println("-----------------------------------------");
            System.out.print("Pilih Metode pembayaran [1|2|3] : ");
            metodBayar = input.nextInt();
            if (metodBayar == 1) {
                System.out.println("------------------------------------");
                System.out.println("|            CASH/TUNAI            |");
                System.out.println("------------------------------------");
                pajak = 0.05;
                totalPajak = pajak * total;
                tagihanTotal = (long)(total + totalPajak);
                                //----------------------------------------------------cetaknota
                                System.out.println("\n\n----------------------------");
                                System.out.println("|   STRUK NOTA RAWAT JALAN  |");
                                System.out.println("----------------------------");
                                LocalDateTime tglWaktu_hariIni = LocalDateTime.now();
                                DateTimeFormatter tglFormat = DateTimeFormatter.ofPattern("\tdd-MM-yyyy\t|\tHH:mm:ss");
                                String format_tgl = tglWaktu_hariIni.format(tglFormat);
                                System.out.println("\n\t\t  ======= RUMAH SAKIT UMUM MINH CARE =======");
                                System.out.println("\t\t Jl. Raya Tumpang No.122, Kab.Malang, JawaTimur \n");
                                System.out.println("=============================================================================");
                                System.out.println("Tanggal | Waktu\t: " + format_tgl);
                                System.out.println("-----------------------------------------------------------------------------");
                                System.out.println("| Nama Pasien\t: " + namaPasien +"\t\t| No/Kode Pasien: "+kodePasien);
                                System.out.println("| Jenis Kelamin\t: " + jenisKPasien+"\t\t| Nama Dokter\t: "+dokter);
                                System.out.println("| Usia Pasien\t: " +umurPasien+"\t\t| Metode Bayar\t: "+metodBayar+" (Cash/Tunai)");
                                System.out.println("| Alamat Pasien\t: " + alamatPasien+"\t\t| Nama Kasir\t: Admin");           
                                System.out.println("=============================================================================");
                                System.out.println("\t\t| Tindakan dan Layanan Transaksi |                                     ");
                                System.out.println("\t\t----------------------------------                                     ");
                                System.out.println("Gejala Sakit\t\t\t " + gejala );
                                System.out.println("Tingkat Sakit\t\t\t " + tingkatRawat);
                                System.out.println("Jenis Poli\t\t\t " + poli + "\t\t@\tRp"+hargaPoli);
                                System.out.println("-----------------------------------------------------------------------------");
                                System.out.println("|\tNama Obat\t|\tHarga Obat\t|  Jumlah Obat  |   Total   |");
                                System.out.println("-----------------------------------------------------------------------------");
                                System.out.println("| "+obat+"\t|\t@ Rp"+hargaObat+"\t|\t "+jumlahObat+" \t|  Rp"+totalObat+"  |");
                                System.out.println("-----------------------------------------------------------------------------");
                                System.out.println("-----------------------------------------------------------------------------");
                                System.out.println("\t\t\t\tTotal Biaya\t:\tRp" + total);
                                System.out.println("\t\t\t\tPajak PPN 5%\t:\tRp" + totalPajak);
                                System.out.println("\t\t\t\t---------------------------------------------");
                                System.out.println("\t\t\t\tTotal Tagihan\t:\tRp" + tagihanTotal + "\n");
                                System.out.print("\t\t\t\tCash Anda\t:\tRp");
                                cash = input.nextLong();
                                tagihanTotal = (long)(cash - tagihanTotal);
                                System.out.println("\t\t\t\t---------------------------------------------");
                                System.out.println("\t\t\t\tKembali\t\t:\tRp " + tagihanTotal);
                                System.out.println("\n=============================================================================\n");
                                System.out.print("Kembali ke menu utama (y/n) : ");
                                pilih = input.next().charAt(0);
                                switch (pilih) {
                                    case 'y':
                                        main_menu(namaPasien);
                                        break;
                                    case 'n':
                                        main(jenisPoli);
                                    default:
                                        main(jenisPoli);
                                        break;
                                }
                        
            }
            else if(metodBayar==2){
                System.out.println("------------------------------------");
                System.out.println("|              B P J S             |");
                System.out.println("------------------------------------");
                System.out.print("\n\t========= Golongan BPJS =========\n\t|\t- VVIP \t\t\t|\n\t|\t- VIP \t\t|\n\t|\t- Kelas 1 \t\t|\n\t|\t- Kelas 2 \t\t|\n\t|\t- Kelas 3 \t\t|\n");
                System.out.println("\t---------------------------------");
                System.out.print("\nKetikkan Golongan BPJS [Ketik Kata]\t: ");
                golBpjs = userInput.next();
                System.out.print("Masukkan NIK (16 Digit)\t: ");
                nik = userInput.nextLine();
                if(golBpjs.equalsIgnoreCase("VVIP".trim())){
                    golBpjs="VVIP";
                }
                else if(golBpjs.equalsIgnoreCase("VIP".trim())){
                    golBpjs="VIP";
                }
                else if(golBpjs.equalsIgnoreCase("Kelas 1".trim())){
                    golBpjs="Kelas 1";
                }
                else if(golBpjs.equalsIgnoreCase("Kelas 2".trim())){
                    golBpjs="Kelas 2";

                }
                else if(golBpjs.equalsIgnoreCase("Kelas 3".trim())){
                    golBpjs="Kelas 3";
                }
                pajak = 0.00;
                totalPajak = pajak * total;
                tagihanTotal = (long)(total + totalPajak);
                biayaAdmin = 10000;
                tagihanTotal=(tagihanTotal-tagihanTotal)+biayaAdmin;
                 System.out.println("\n\n----------------------------");
                 System.out.println("|   STRUK NOTA RAWAT JALAN  |");
                 System.out.println("----------------------------");
                 LocalDateTime tglWaktu_hariIni = LocalDateTime.now();
                 DateTimeFormatter tglFormat = DateTimeFormatter.ofPattern("\tdd-MM-yyyy\t|\tHH:mm:ss");
                 String format_tgl = tglWaktu_hariIni.format(tglFormat);
                 System.out.println("\n\t\t  ======= RUMAH SAKIT UMUM MINH CARE =======");
                 System.out.println("\t\t Jl. Raya Tumpang No.122, Kab.Malang, JawaTimur \n");
                 System.out.println("=============================================================================");
                 System.out.println("Tanggal | Waktu\t: " + format_tgl);
                 System.out.println("-----------------------------------------------------------------------------");
                 System.out.println("| Nama Pasien\t: " + namaPasien +"\t\t| No/Kode Pasien: "+kodePasien);
                 System.out.println("| Jenis Kelamin\t: " + jenisKPasien+"\t\t| Nama Dokter\t: "+dokter);
                 System.out.println("| Usia Pasien\t: " +umurPasien+"\t\t| Metode Bayar\t: "+metodBayar+" (BPJS)");
                 System.out.println("| Alamat Pasien\t: " + alamatPasien+"\t\t| Gol. BPJS\t: "+golBpjs);           
                 System.out.println("| NIK Pasien\t: " + nik+"\t| Nama Kasir\t: Admin");           
                 System.out.println("=============================================================================");
                 System.out.println("\t\t| Tindakan dan Layanan Transaksi |                                     ");
                 System.out.println("\t\t----------------------------------                                     ");
                 System.out.println("Gejala Sakit\t\t\t " + gejala );
                 System.out.println("Tingkat Sakit\t\t\t " + tingkatRawat);
                 System.out.println("Jenis Poli\t\t\t " + poli + "\t\t@\tRp"+hargaPoli);
                 System.out.println("-----------------------------------------------------------------------------");
                 System.out.println("|\tNama Obat\t|\tHarga Obat\t|  Jumlah Obat  |   Total   |");
                 System.out.println("-----------------------------------------------------------------------------");
                 System.out.println("| "+obat+"\t|\t@ Rp"+hargaObat+"\t|\t "+jumlahObat+" \t|  Rp"+totalObat+"  |");
                 System.out.println("-----------------------------------------------------------------------------");
                 System.out.println("-----------------------------------------------------------------------------");
                 System.out.println("\t\t\t\tTotal Biaya\t:\tRp" + total);
                 System.out.println("\t\t\t\tPajak PPN "+pajak+"\t:\tRp" + totalPajak);
                 System.out.println("\t\t\t\tBiaya Admin\t:\tRp" + biayaAdmin);
                 System.out.println("\t\t\t\t---------------------------------------------");
                 System.out.println("\t\t\t\tTotal Tagihan\t:\tRp" + tagihanTotal + "\n");
                 System.out.print("\t\t\t\tCash Anda\t:\tRp");
                 cash = input.nextLong();
                 tagihanTotal = (long)(cash - tagihanTotal);
                 System.out.println("\t\t\t\t---------------------------------------------");
                 System.out.println("\t\t\t\tKembali\t\t:\tRp " + tagihanTotal);
                 System.out.println("\n=============================================================================\n");
                 System.out.print("Kembali ke menu utama (y/n) : ");
                 pilih = input.next().charAt(0);
                 switch (pilih) {
                     case 'y':
                         main_menu(namaPasien);
                         break;
                     case 'n':
                         main(jenisPoli);
                     default:
                         main(jenisPoli);
                         break;
                 }
            }
            else if(metodBayar==3){
                System.out.println("------------------------------------------");
                System.out.println("|              TRANSFER BANK             |");
                System.out.println("------------------------------------------");
                String bank[] = {"Mandiri","BRI","BNI","BCA"}; 
                String hasilBank;
                System.out.println("\n\t========= BANK ==========\n\t|\t1. Mandiri \t|\n\t|\t2. BRI \t\t|\n\t|\t3. BNI \t\t|\n\t|\t4. BCA \t\t|");
                System.out.println("\t-------------------------");
                System.out.print("\nPilih Bank [1|2|3|4]\t: ");
                int pilihBank = input.nextInt();
                if(pilihBank==1){
                    hasilBank=bank[0];
                    diskon = 0.06;
                    totalDiskon = diskon*totalTagihan;
                }
                else if(pilihBank==2){
                    hasilBank=bank[1]; 
                    diskon = 0.04; 
                    totalDiskon = diskon*totalTagihan;
                }
                else if(pilihBank==3){
                    hasilBank=bank[2]; 
                    diskon = 0.03; 
                    totalDiskon = diskon*totalTagihan;
                }
                else{
                    hasilBank=bank[3]; 
                    diskon = 0.02; 
                    totalDiskon = diskon*totalTagihan;
                }

                Random virtualAccount = new Random();
                System.out.println("    * NOMOR VIRTUAL ACCOUNT ANDA *  ");
                System.out.println("------------------------------------");
                for (int i = 1; i <= 10; i++) { 
                    int cetakVA = virtualAccount.nextInt(9);
                    System.out.print(" "+cetakVA);
                }
                System.out.println("\n------------------------------------"); 
                System.out.println("Masukkan Nomer Virtual Account seperti tampilan diatas\t: ");
                vA = userInput.nextLine();
                pajak = 0.11;
                totalPajak = pajak * total;
                tagihanTotal = (long)(total + totalPajak);
                System.out.println("\n\n----------------------------");
                 System.out.println("|   STRUK NOTA RAWAT JALAN  |");
                 System.out.println("----------------------------");
                 LocalDateTime tglWaktu_hariIni = LocalDateTime.now();
                 DateTimeFormatter tglFormat = DateTimeFormatter.ofPattern("\tdd-MM-yyyy\t|\tHH:mm:ss");
                 String format_tgl = tglWaktu_hariIni.format(tglFormat);
                 System.out.println("\n\t\t  ======= RUMAH SAKIT UMUM MINH CARE =======");
                 System.out.println("\t\t Jl. Raya Tumpang No.122, Kab.Malang, JawaTimur \n");
                 System.out.println("=============================================================================");
                 System.out.println("Tanggal | Waktu\t: " + format_tgl);
                 System.out.println("-----------------------------------------------------------------------------");
                 System.out.println("| Nama Pasien\t: " + namaPasien +"\t\t| No/Kode Pasien: "+kodePasien);
                 System.out.println("| Jenis Kelamin\t: " + jenisKPasien+"\t\t| Nama Dokter\t: "+dokter);
                 System.out.println("| Usia Pasien\t: " +umurPasien+"\t\t| Metode Bayar\t: "+metodBayar+" (Transfer Bank)");
                 System.out.println("| Virtual Acc\t: " +vA+"\t\t| Nama Bank\t: "+hasilBank);
                 System.out.println("| Alamat Pasien\t: " + alamatPasien+"\t\t| Nama Kasir\t: Admin");           
                 System.out.println("=============================================================================");
                 System.out.println("\t\t| Tindakan dan Layanan Transaksi |                                     ");
                 System.out.println("\t\t----------------------------------                                     ");
                 System.out.println("Gejala Sakit\t\t\t " + gejala );
                 System.out.println("Tingkat Sakit\t\t\t " + tingkatRawat);
                 System.out.println("Jenis Poli\t\t\t " + poli + "\t\t@\tRp"+hargaPoli);
                 System.out.println("-----------------------------------------------------------------------------");
                 System.out.println("|\tNama Obat\t|\tHarga Obat\t|  Jumlah Obat  |   Total   |");
                 System.out.println("-----------------------------------------------------------------------------");
                 System.out.println("| "+obat+"\t|\t@ Rp"+hargaObat+"\t|\t "+jumlahObat+" \t|  Rp"+totalObat+"  |");
                 System.out.println("-----------------------------------------------------------------------------");
                 System.out.println("-----------------------------------------------------------------------------");
                 System.out.println("\t\t\t\tTotal Biaya\t:\tRp" + total);
                 System.out.println("\t\t\t\tPajak PPN "+pajak+"\t:\tRp" + totalPajak);
                 System.out.println("\t\t\t\tBiaya Admin\t:\tRp" + biayaAdmin);
                 System.out.println("\t\t\t\t---------------------------------------------");
                 System.out.println("\t\t\t\tTotal Tagihan\t:\tRp" + tagihanTotal + "\n");
                 System.out.println("\n=============================================================================\n");
                 System.out.print("Kembali ke menu utama (y/n) : ");
                 pilih = input.next().charAt(0);
                 switch (pilih) {
                     case 'y':
                         main_menu(namaPasien);
                         break;
                     case 'n':
                         main(jenisPoli);
                     default:
                         main(jenisPoli);
                         break;
                 }
            
            }
        }

    }
    // --------------------------------------------------------------------------------------------------------------------------------------
}
