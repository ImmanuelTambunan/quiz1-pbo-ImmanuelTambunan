import java.util.Scanner;

public class Driver2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        int[] deretNilai = new int[n];
        for (int i = 0; i < n; i++) {
            if (sc.hasNextInt()) {
                deretNilai[i] = sc.nextInt();
            }
        }

        String kodeKelompok = sc.next();
        int totalNilai = 0;

        for (int i = 0; i < n; i++) {
            int urutan = i + 1;
            // Pola: Ganjil (Perempuan), Genap (Laki-laki)
            if (kodeKelompok.equalsIgnoreCase("Perempuan")) {
                if (urutan % 2 != 0) totalNilai += deretNilai[i];
            } else if (kodeKelompok.equalsIgnoreCase("Laki-laki")) {
                if (urutan % 2 == 0) totalNilai += deretNilai[i];
            }
        }
        System.out.println(totalNilai);
        sc.close();
    }
}