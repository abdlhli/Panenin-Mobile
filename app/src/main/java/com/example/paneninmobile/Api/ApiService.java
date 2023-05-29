package com.example.paneninmobile.Api;

import com.example.paneninmobile.Models.BannerResponse;
import com.example.paneninmobile.Models.DetailPemesananResponse;
import com.example.paneninmobile.Models.KategoriResponse;
import com.example.paneninmobile.Models.PemesananResponse;
import com.example.paneninmobile.Models.ProdukResponse;
import com.example.paneninmobile.Models.StatusPemesananResponse;
import com.example.paneninmobile.Models.TerlarisResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("api/jenisproduk")
    Call<KategoriResponse> getAllKategori();

    @GET("api/banner")
    Call<BannerResponse> getAllBanner();

    @GET("api/produk")
    Call<ProdukResponse> getAllProduk();

    @GET("api/produkterlaris")
    Call<TerlarisResponse> getProdukTerlaris();

    @GET("api/pemesanan/PLG00001")
    Call<PemesananResponse> getAllPemesanan();
    Call<DetailPemesananResponse> getAllDetailPemesanan();
    Call<StatusPemesananResponse> getAllStatusPemesanan();
}
