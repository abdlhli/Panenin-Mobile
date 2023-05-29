package com.example.paneninmobile.Models;

import com.google.gson.annotations.SerializedName;

public class BannerModel {
    @SerializedName("id_banner")
    private String idBanner;

    @SerializedName("nama_banner")
    private String namaBanner;

    @SerializedName("foto_banner")
    private String fotoBanner;

    @SerializedName("tgl_banner")
    private String tglBanner;

    @SerializedName("status")
    private String status;

    @SerializedName("id_user")
    private String idUser;

    public String getIdBanner() {
        return idBanner;
    }

    public void setIdBanner(String idBanner) {
        this.idBanner = idBanner;
    }

    public String getNamaBanner() {
        return namaBanner;
    }

    public void setNamaBanner(String namaBanner) {
        this.namaBanner = namaBanner;
    }

    public String getFotoBanner() {
        return fotoBanner;
    }

    public void setFotoBanner(String fotoBanner) {
        this.fotoBanner = fotoBanner;
    }

    public String getTglBanner() {
        return tglBanner;
    }

    public void setTglBanner(String tglBanner) {
        this.tglBanner = tglBanner;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
}