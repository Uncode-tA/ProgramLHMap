import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CustomerManagementSystem {
    public static void main(String[] args) {
        LinkedHashMap<String, String> customerList = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Sistem Manajemen Pelanggan Apotik Cahaya");
        System.out.println("Masukkan pelanggan (ID dan Nama). Ketik 'selesai' untuk berhenti.\n");

        // Input pelanggan
        while (true) {
            System.out.print("Masukkan ID pelanggan: ");
            String id = scanner.nextLine();
            if (id.equalsIgnoreCase("selesai")) {
                break; // Keluar dari loop input pelanggan
            }

            System.out.print("Masukkan nama pelanggan: ");
            String name = scanner.nextLine();
            customerList.put(id, name); // Menyimpan ID dan nama pelanggan
        }

        // Menampilkan daftar pelanggan
        System.out.println("\nDaftar pelanggan (urutan pendaftaran):");
        for (Map.Entry<String, String> entry : customerList.entrySet()) {
            System.out.println("ID Pelanggan: " + entry.getKey() + ", Nama: " + entry.getValue());
        }

        // Menu penghapusan pelanggan
        System.out.println("\nHapus pelanggan dengan mengetikkan ID atau Ketik 'selesai' untuk mengakhiri.");
        while (true) {
            System.out.print("\nMasukkan ID pelanggan yang ingin dihapus: ");
            String deleteID = scanner.nextLine();

            if (deleteID.equalsIgnoreCase("selesai")) {
                System.out.println("Selesai mengelola pelanggan.");
                break; // Keluar dari loop penghapusan
            }

            if (customerList.containsKey(deleteID)) {
                String removedName = customerList.remove(deleteID); // Menghapus pelanggan
                System.out.println("Pelanggan dengan ID '" + deleteID + "' dan Nama '" + removedName + "' telah dihapus.");
            } else {
                System.out.println("Tidak ada pelanggan dengan ID '" + deleteID + "'.");
            }

            // Menampilkan daftar pelanggan setelah penghapusan
            System.out.println("\nDaftar pelanggan setelah penghapusan:");
            for (Map.Entry<String, String> entry : customerList.entrySet()) {
                System.out.println("ID Pelanggan: " + entry.getKey() + ", Nama: " + entry.getValue());
            }
        }

        scanner.close(); // Menutup scanner untuk menghindari kebocoran sumber daya
    }
}
