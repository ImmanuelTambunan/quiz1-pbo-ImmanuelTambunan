public class Pesanan {
    public String nama;
    public int porsiTotal;
    public int hargaSatuan;
    public int subTotal;

    public Pesanan(String nama, int porsiTotal, int hargaSatuan) {
        this.nama = nama;
        this.porsiTotal = porsiTotal;
        this.hargaSatuan = hargaSatuan;
        this.subTotal = porsiTotal * hargaSatuan;
    }
}