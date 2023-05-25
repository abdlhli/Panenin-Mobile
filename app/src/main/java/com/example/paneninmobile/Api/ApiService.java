package com.example.paneninmobile.Api;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("kategori")
    Call<ArrayList<String>> getKategori();
}
