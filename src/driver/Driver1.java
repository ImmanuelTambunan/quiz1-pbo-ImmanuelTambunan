import java.util.ArrayList;
import java.util.Scanner;

public class Driver1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Pesanan> daftarPesanan = new ArrayList<>();

        // Membaca input sampai "END"
        while (sc.hasNext()) {
            String kode = sc.next();
            if (kode.equalsIgnoreCase("END")) break;
            
            int porsiButet = sc.nextInt();
            
            // Logika Porsi: Berat Ucok (100kg) & Butet (50kg) = Rasio 2:1. 
            // Total porsi yang dipesan adalah 3 kali porsi Butet
            int porsiTotal = porsiButet * 3;

            String nama = "";
            int harga = 0;

            // Mapping Kode Menu & Harga (Satuan Rupiah)
            switch (kode.toUpperCase()) {
                case "NGS": nama = "Nasi Goreng Spesial"; harga = 15000; break;
                case "AP":  nama = "Ayam Penyet";        harga = 20000; break;
                case "SA":  nama = "Sate Ayam (10 Tusuk)"; harga = 25000; break;
                case "BU":  nama = "Bakso Urat";         harga = 18000; break;
                case "MAP": nama = "Mie Ayam Pangsit";   harga = 15000; break;
                case "GG":  nama = "Gado-Gado";          harga = 15000; break;
                case "SAM": nama = "Soto Ayam";          harga = 17000; break;
                case "RD":  nama = "Rendang Daging";     harga = 25000; break;
                case "IB":  nama = "Ikan Bakar";         harga = 35000; break;
                case "NUK": nama = "Nasi Uduk Komplit";  harga = 20000; break;
            }
            daftarPesanan.add(new Pesanan(nama, porsiTotal, harga));
        }

        // Output format tabel sesuai contoh terminal
        System.out.println();
        System.out.printf("%-20s %-10s %-10s %-10s\n", "Menu", "Porsi", "Harga", "Total");
        System.out.println("==========================================================");
        
        int totalKotor = 0;
        for (Pesanan p : daftarPesanan) {
            System.out.printf("%-20s %-10d %-10d %-10d\n", p.nama, p.porsiTotal, p.hargaSatuan, p.subTotal);
            totalKotor += p.subTotal;
        }
        System.out.println("==========================================================");

        // Hitung Diskon berdasarkan Kupon Lebaran
        double diskonPersen = 0;
        if (totalKotor >= 500000) diskonPersen = 0.25;
        else if (totalKotor >= 400000) diskonPersen = 0.20;
        else if (totalKotor >= 300000) diskonPersen = 0.15;
        else if (totalKotor >= 200000) diskonPersen = 0.10;
        else if (totalKotor >= 100000) diskonPersen = 0.05;

        int nilaiDiskon = (int) (totalKotor * diskonPersen);
        int totalAkhir = totalKotor - nilaiDiskon;

        if (nilaiDiskon > 0) {
            System.out.printf("%-42s %-10d\n", "Diskon (" + (int)(diskonPersen * 100) + "%)", nilaiDiskon);
        }
        System.out.printf("%-42s %-10d\n", "Total Pembayaran", totalAkhir);
        
        sc.close();
    }
}
