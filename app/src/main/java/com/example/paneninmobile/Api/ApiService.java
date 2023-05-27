package com.example.paneninmobile.Api;

import com.example.paneninmobile.Models.BannerResponse;
import com.example.paneninmobile.Models.KategoriResponse;
import com.example.paneninmobile.Models.ProdukResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("api/jenisproduk")
    Call<KategoriResponse> getAllKategori();

    @GET("api/banner")
    Call<BannerResponse> getAllBanner();

    @GET("api/produk")
    Call<ProdukResponse> getAllProduk();
}
