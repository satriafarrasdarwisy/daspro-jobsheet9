import java.util.Scanner;

public class Tugas2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String[] menu = {"Nasi Goreng", "Mie Goreng", "Roti Bakar", "Kentang Goreng", "Teh Tarik", "Cappucino", "Chocolate Ice"};
        int[] harga = {15000, 13000, 10000, 12000, 8000, 18000, 20000};

        System.out.println("===== DAFTAR MENU KAFE KAMPUS =====");
        for (int i = 0; i < menu.length; i++) {
            System.out.printf("%d. %-16s Rp%,d%n", (i + 1), menu[i], harga[i]);
        }

        System.out.println("\n===== PENCARIAN MENU =====");
        System.out.print("Masukkan nama menu yang dicari: ");
        String cari = input.nextLine();

        int indeks = -1;
        for (int i = 0; i < menu.length; i++) {
            if (menu[i].equalsIgnoreCase(cari)) {
                indeks = i;
                break;
            }
        }
        if (indeks != -1) {
            System.out.println("Menu " + menu[indeks] + " tersedia, harganya Rp" + harga[indeks]);
        } else {
            System.out.println("Maaf, menu \"" + cari + "\" tidak tersedia.");
        }

        System.out.println("\n===== PEMESANAN =====");
        System.out.print("Masukkan jumlah item yang dipesan: ");
        int jumlah = input.nextInt();
        input.nextLine();

        String[] pesanan = new String[jumlah];
        int[] hargaPesanan = new int[jumlah];
        int total = 0;

        for (int i = 0; i < jumlah; i++) {
            boolean valid = false;
            while (!valid) {
                System.out.print("Pesanan ke-" + (i + 1) + " (nama menu): ");
                String nama = input.nextLine();

                for (int j = 0; j < menu.length; j++) {
                    if (menu[j].equalsIgnoreCase(nama)) {
                        pesanan[i] = menu[j];
                        hargaPesanan[i] = harga[j];
                        valid = true;
                        break;
                    }
                }
                if (!valid) {
                    System.out.println("Menu tidak tersedia, silakan masukkan lagi.");
                }
            }
            total += hargaPesanan[i];
        }

        System.out.println("\n===== DAFTAR PESANAN =====");
        System.out.printf("%-4s %-16s %12s%n", "No", "Menu", "Harga");
        System.out.println("-------------------------------------");
        for (int i = 0; i < pesanan.length; i++) {
            System.out.printf("%-4d %-16s Rp%,10d%n", (i + 1), pesanan[i], hargaPesanan[i]);
        }
        System.out.println("-------------------------------------");
        System.out.printf("%-21s Rp%,10d%n", "TOTAL BIAYA", total);
    }
}