package com.example.paneninmobile.Home;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.paneninmobile.Api.ApiClient;
import com.example.paneninmobile.Api.ApiService;
import com.example.paneninmobile.Models.BannerModel;
import com.example.paneninmobile.Models.BannerResponse;
import com.example.paneninmobile.Models.KategoriModel;
import com.example.paneninmobile.Models.KategoriResponse;
import com.example.paneninmobile.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BerandaFragment extends Fragment {

    private ImageSlider imageSlider;
    private RecyclerView recyclerView, recyclerViewTerlaris;

    private ArrayList<String> dataSource = new ArrayList<>();

    private ArrayList<ItemTerlaris> dataSourceTerlaris = new ArrayList<>();
    ArrayList<ItemTerlaris> dataTerlaris = new ArrayList<>();

    ProgressDialog progressDoalog;

    public BerandaFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dataTerlaris.add(new ItemTerlaris("Judul 1", "Harga 1"));
        dataTerlaris.add(new ItemTerlaris("Judul 2", "Harga 2"));
        dataTerlaris.add(new ItemTerlaris("Judul 3", "Harga 3"));
        dataTerlaris.add(new ItemTerlaris("Judul 4", "Harga 4"));
        dataTerlaris.add(new ItemTerlaris("Judul 5", "Harga 5"));
        dataTerlaris.add(new ItemTerlaris("Judul 6", "Harga 6"));

        dataSourceTerlaris.addAll(dataTerlaris);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        imageSlider = view.findViewById(R.id.imageSlider);
        recyclerView = view.findViewById(R.id.horizontalRv);
        recyclerViewTerlaris = view.findViewById(R.id.horizontalRv2);
        TextView textView = view.findViewById(R.id.textView5);

        //list for images
        loadBannerImages();

        //Kategori
        progressDoalog = new ProgressDialog(getActivity());
        progressDoalog.setMessage("Loading....");
        progressDoalog.show();

        // Create handle for the RetrofitInstance interface
        ApiService service = ApiClient.getClient().create(ApiService.class);
        Call<KategoriResponse> call = service.getAllKategori();
        call.enqueue(new Callback<KategoriResponse>() {
            @Override
            public void onResponse(Call<KategoriResponse> call, Response<KategoriResponse> response) {
                progressDoalog.dismiss();

                if (response.isSuccessful()) {
                    KategoriResponse kategoriResponse = response.body();
                    if (kategoriResponse != null) {
                        List<KategoriModel> kategoriModelList = kategoriResponse.getData();
                        Log.d("API Response", "Data berhasil diambil: " + kategoriModelList.toString());
                        generateDataList(kategoriModelList);
                    }
                } else {
                    String errorMessage = "Error: " + response.code() + " - " + response.message();
                    Log.e("API Response", errorMessage);
                }
            }

            @Override
            public void onFailure(Call<KategoriResponse> call, Throwable t) {
                progressDoalog.dismiss();
                Log.e("ErrorAPI", "onFailure: " + t.getMessage());
                Toast.makeText(getActivity(), "Something went wrong...Please try later!", Toast.LENGTH_LONG).show();
            }
        });



        // Tombol Mengarah ke produk list
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ProdukList.class);
                startActivity(intent);
            }
        });

        //Terlaris Adapter
        TerlarisAdapter terlarisAdapter = new TerlarisAdapter(dataSourceTerlaris);
        LinearLayoutManager linearLayoutManagerTerlaris = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewTerlaris.setAdapter(terlarisAdapter);
        recyclerViewTerlaris.setLayoutManager(linearLayoutManagerTerlaris);

        LinearLayoutManager layoutManagerTerlaris = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewTerlaris.setLayoutManager(layoutManagerTerlaris);

        return view;
    }

    // Method to generate List of data using RecyclerView with custom adapter
    private void generateDataList(List<KategoriModel> kategoriResponseList) {
        recyclerView = getView().findViewById(R.id.horizontalRv);
        KategoriAdapter adapter = new KategoriAdapter(getActivity(), kategoriResponseList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void loadBannerImages() {
        // Memanggil API untuk mendapatkan data banner
        ApiService service = ApiClient.getClient().create(ApiService.class);
        Call<BannerResponse> call = service.getAllBanner();
        call.enqueue(new Callback<BannerResponse>() {
            @Override
            public void onResponse(Call<BannerResponse> call, Response<BannerResponse> response) {
                if (response.isSuccessful()) {
                    List<BannerModel> banners = response.body().getData();

                    // Mengubah data banner menjadi SlideModel
                    ArrayList<SlideModel> slideModels = new ArrayList<>();
                    for (BannerModel banner : banners) {
                        String imageUrl = ApiClient.LINK_API + "assets/images/banner/" + banner.getFotoBanner();
                        slideModels.add(new SlideModel(imageUrl, ScaleTypes.FIT));
                        Log.d("URL Banner Debug", "Image URL: " + imageUrl);
                    }
                    // Mengatur slideModels ke imageSlider
                    imageSlider.setImageList(slideModels, ScaleTypes.FIT);

                } else {
                    // Menangani kesalahan jika ada
                    Log.e("API Response", "Error: " + response.code() + " - " + response.message());
                }
            }

            @Override
            public void onFailure(Call<BannerResponse> call, Throwable t) {
                // Menangani kesalahan jika terjadi kegagalan koneksi atau API tidak berhasil diakses
                Log.e("API Error", "onFailure: " + t.getMessage());
            }
        });
    }

}
