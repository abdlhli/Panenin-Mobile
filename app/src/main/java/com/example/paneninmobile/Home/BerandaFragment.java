package com.example.paneninmobile.Home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.paneninmobile.R;

import java.util.ArrayList;

public class BerandaFragment extends Fragment {

    private ImageSlider imageSlider;
    private RecyclerView recyclerView, recyclerViewTerlaris;

    private ArrayList<String> dataSource = new ArrayList<>();

    private ArrayList<ItemTerlaris> dataSourceTerlaris = new ArrayList<>();
    ArrayList<ItemTerlaris> dataTerlaris = new ArrayList<>();

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

        //data source kategori
        dataSource.add("Hello");
        dataSource.add("World");
        dataSource.add("To");
        dataSource.add("The");
        dataSource.add("Code");
        dataSource.add("City");
        dataSource.add("******");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        imageSlider = view.findViewById(R.id.imageSlider);
        recyclerView = view.findViewById(R.id.horizontalRv);
        recyclerViewTerlaris = view.findViewById(R.id.horizontalRv2);

        //list for images
        ArrayList<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel("https://akcdn.detik.net.id/visual/2020/02/19/f8950d9c-3861-4f03-8b21-04c96b6744e3_169.jpeg?w=650", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://i.ytimg.com/vi/Ie3B7Ms9klM/hqdefault.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://dafunda.com/wp-content/uploads/2021/09/fakta-unik-saitama-one-punch-man.jpg", ScaleTypes.FIT));

        imageSlider.setImageList(slideModels, ScaleTypes.FIT);

        //Kategori Adapter card
        KategoriAdapter kategoriAdapter = new KategoriAdapter(dataSource);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setAdapter(kategoriAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        //Terlaris Adapter
        TerlarisAdapter terlarisAdapter = new TerlarisAdapter(dataSourceTerlaris);
        LinearLayoutManager linearLayoutManagerTerlaris = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewTerlaris.setAdapter(terlarisAdapter);
        recyclerViewTerlaris.setLayoutManager(linearLayoutManagerTerlaris);

        LinearLayoutManager layoutManagerTerlaris = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewTerlaris.setLayoutManager(layoutManagerTerlaris);

        return view;
    }
}
