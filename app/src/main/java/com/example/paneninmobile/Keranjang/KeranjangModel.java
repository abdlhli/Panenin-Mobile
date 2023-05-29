package com.example.paneninmobile.Keranjang;

public class KeranjangModel {

    private String harga ,barang;


    public KeranjangModel(String harga, String barang) {
        this.harga = harga;
        this.barang = barang;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {

        this.harga = harga;
    }

    public String getbarang() {
        return barang;
    }

    public void setBarang(String barang) {

        this.barang = barang;
    }
}
