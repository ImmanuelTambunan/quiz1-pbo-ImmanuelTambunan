import java.util.Scanner;

public class Driver3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input sesuai urutan
        if (sc.hasNextLine()) {
            String gender = sc.nextLine();      // 1. Gender
            String hari = sc.nextLine();        // 2. Hari
            String adaList = sc.nextLine();     // 3. List
            String adaPlastik = sc.nextLine();  // 4. Plastik
            
            if (sc.hasNextDouble()) {
                double berat = sc.nextDouble(); // 5. Berat

                boolean layak = true;

                // Validasi Jadwal
                if (gender.equalsIgnoreCase("Laki-laki")) {
                    if (!hari.equalsIgnoreCase("Jumat")) layak = false;
                } else if (gender.equalsIgnoreCase("Perempuan")) {
                    if (!hari.equalsIgnoreCase("Selasa")) layak = false;
                } else {
                    layak = false;
                }

                // Validasi Syarat Tambahan (List, Plastik, Berat)
                if (!adaList.equalsIgnoreCase("Ada") || 
                    !adaPlastik.equalsIgnoreCase("Ada") || 
                    berat > 7.0) {
                    layak = false;
                }

                // Output sesuai permintaan
                if (layak) {
                    System.out.println("Sukses Laundry");
                } else {
                    System.out.println("Gagal Laundry");
                }
            }
        }
        sc.close();
    }
}