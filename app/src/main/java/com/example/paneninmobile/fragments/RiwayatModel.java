package com.example.paneninmobile.fragments;

public class RiwayatModel {

    private String barang ,id, jumlah, total;


    public RiwayatModel(String barang, String id, String jumlah, String total) {
        this.barang = barang;
        this.id = id;
        this.jumlah = jumlah;
        this.total = total;
    }

    public String getbarang() {
        return barang;
    }

    public void setbarang(String barang) {
        this.barang = barang;
    }

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public String getJumlah() {
        return jumlah;
    }
    public void setJumlah(String jumlah) {
        this.jumlah = jumlah;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
