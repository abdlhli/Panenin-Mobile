package com.example.paneninmobile.Models;

public class DetailPemesananModel {
    private String id_pemesanan;
    private String id_produk;
    private String jumlah_produk;
    private String total_harga_produk;

    public String getId_pemesanan() {
        return id_pemesanan;
    }

    public void setId_pemesanan(String id_pemesanan) {
        this.id_pemesanan = id_pemesanan;
    }

    public String getId_produk() {
        return id_produk;
    }

    public void setId_produk(String id_produk) {
        this.id_produk = id_produk;
    }

    public String getJumlah_produk() {
        return jumlah_produk;
    }

    public void setJumlah_produk(String jumlah_produk) {
        this.jumlah_produk = jumlah_produk;
    }

    public String getTotal_harga_produk() {
        return total_harga_produk;
    }

    public void setTotal_harga_produk(String total_harga_produk) {
        this.total_harga_produk = total_harga_produk;
    }
}
