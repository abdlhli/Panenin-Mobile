package com.example.paneninmobile.Profile;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.paneninmobile.R;

public class ProfileFragment extends Fragment {
    Button btn_edit;
    TextView btn_pesanan;
    Button btn_pesanan2;
    Button btn_belum_bayar;
    Button btn_dikemas;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        btn_edit = view.findViewById(R.id.btnEdit);
        btn_pesanan = view.findViewById(R.id.btnRiwayat);
        btn_pesanan2 = view.findViewById(R.id.btnRiwayat2);
        btn_belum_bayar = view.findViewById(R.id.btnBelumbayar);
        btn_dikemas = view.findViewById(R.id.btnDikemas);

        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), UpdateProfileActivity.class));
            }
        });

        btn_pesanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DetailRiwayatActivity.class);
                startActivity(intent);
            }
        });

        btn_pesanan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DetailRiwayatActivity.class);
                startActivity(intent);
            }
        });

        btn_belum_bayar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DetailRiwayatActivity.class);
                startActivity(intent);
            }
        });

        btn_dikemas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), DetailRiwayatActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }
}
