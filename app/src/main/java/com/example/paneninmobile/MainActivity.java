package com.example.paneninmobile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn_login, btn_register;

    private ImageSlider imageSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.home);

        imageSlider = findViewById(R.id.imageSlider);
        RecyclerView recyclerView = findViewById(R.id.recyclerkategori);

        //list for images

        ArrayList<SlideModel> slideModels = new ArrayList<>();

        slideModels.add(new SlideModel("https://akcdn.detik.net.id/visual/2020/02/19/f8950d9c-3861-4f03-8b21-04c96b6744e3_169.jpeg?w=650", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://i.ytimg.com/vi/Ie3B7Ms9klM/hqdefault.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://dafunda.com/wp-content/uploads/2021/09/fakta-unik-saitama-one-punch-man.jpg", ScaleTypes.FIT));

        imageSlider.setImageList(slideModels, ScaleTypes.FIT);

        //recycle card

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(layoutManager);



    }
}