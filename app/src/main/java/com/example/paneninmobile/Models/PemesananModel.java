package com.example.paneninmobile.Models;

public class PemesananModel {
    private String id_pemesanan;
    private String tgl_pemesanan;
    private String total_harga_pemesanan;
    private String id_user;
    private String id_status_pemesanan;

    public String getId_pemesanan() {
        return id_pemesanan;
    }

    public void setId_pemesanan(String id_pemesanan) {
        this.id_pemesanan = id_pemesanan;
    }

    public String getTgl_pemesanan() {
        return tgl_pemesanan;
    }

    public void setTgl_pemesanan(String tgl_pemesanan) {
        this.tgl_pemesanan = tgl_pemesanan;
    }

    public String getTotal_harga_pemesanan() {
        return total_harga_pemesanan;
    }

    public void setTotal_harga_pemesanan(String total_harga_pemesanan) {
        this.total_harga_pemesanan = total_harga_pemesanan;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getId_status_pemesanan() {
        return id_status_pemesanan;
    }

    public void setId_status_pemesanan(String id_status_pemesanan) {
        this.id_status_pemesanan = id_status_pemesanan;
    }
}
