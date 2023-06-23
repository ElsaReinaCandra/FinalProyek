import java.util.Scanner;
class buku {
    String judul;
    String author;
    int nomorRak;
    public buku (String judul, String author, int nomorRak){
        this.judul = judul;
        this.author = author;
        this.nomorRak = nomorRak;
    }
}
class perpustakaan{
    buku[] listBuku;
    int jumlahBuku;
    int kapasitas;
    public perpustakaan (int kapasitas){
        this.kapasitas = kapasitas;
        this.listBuku = new buku [kapasitas];
        this.jumlahBuku = 0;
    }
    public void tambahBuku (String judul, String author, int nomorRak){
        if (jumlahBuku == kapasitas){
            System.out.println("Kapasitas penuh");
            return;
        }
        buku newBuku = new buku (judul, author, nomorRak);
        listBuku[jumlahBuku] = newBuku;
        jumlahBuku++;

        insertionSort();
        System.out.println("Buku berhasil ditambahkan");
    }
    private void insertionSort(){
        for (int a = 1; a < jumlahBuku; a++){
            buku bukuYangAda = listBuku[a];
            int b = a - 1;
            while (b >= 0 && listBuku[b].judul.compareTo(bukuYangAda.judul) > 0){
                listBuku[b + 1] = listBuku[b];
                b--;
            }
            listBuku[b + 1] = bukuYangAda;
        }
    }
    public void tampilkanBuku() {
        System.out.println("List Buku :");
        for(int a = 0; a < jumlahBuku; a++){
            System.out.println("Judul     : " + listBuku[a].judul);
            System.out.println("Author    : " + listBuku[a].author);
            System.out.println("Nomor Rak : " + listBuku[a].nomorRak);
            System.out.println();
        }
    }
    public void hapusBuku (int indeks){
        if (indeks < 0 || indeks >= jumlahBuku){
            System.out.println("Tidak ditemukan");
            return;
        }
        buku hapusBuku = listBuku[indeks];
        for(int a = indeks; a < jumlahBuku - 1; a++){
            listBuku[a] = listBuku[a + 1];
        }
        jumlahBuku--;
        listBuku[jumlahBuku] = null;
        System.out.println("Berhasil menghapus buku");
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan kapasitas buku : ");
        int kapasitas = scanner.nextInt();
        perpustakaan perpus = new perpustakaan(kapasitas);
        int pilihan = 0;

        while (pilihan != 4){
            System.out.println();
            System.out.println("----------menu----------");
            System.out.println("1. Memasukkan buku");
            System.out.println("2. Menghapus buku");
            System.out.println("3. Tampilkan semua buku");
            System.out.println("4. Exit");
            System.out.println("------------------------");
            System.out.print("Pilih : ");
            pilihan = scanner.nextInt();

            switch (pilihan){
                case 1:
                    scanner.nextLine();
                    System.out.print("Masukkan judul buku : ");
                    String judul = scanner.nextLine();
                    System.out.print("Masukkan nama author buku : ");
                    String author = scanner.nextLine();
                    System.out.print("Masukkan nomor rak buku : ");
                    int nomorRak = scanner.nextInt();
                    perpus.tambahBuku(judul, author, nomorRak);
                    break;

                case 2:
                    System.out.print("Masukkan indeks buku yang akan dihapus : ");
                    int indeks = scanner.nextInt();
                    perpus.hapusBuku(indeks);
                    break;

                case 3:
                    perpus.tampilkanBuku();
                    break;

                case 4:
                    System.out.println("Keluar");
                    break;

                default:
                    System.out.println("Tidak ada dalam pilihan");
                    break;
            }
        }
        scanner.close();
    }
}