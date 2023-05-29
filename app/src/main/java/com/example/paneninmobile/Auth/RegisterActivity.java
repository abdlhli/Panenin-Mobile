package com.example.paneninmobile.Auth;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.paneninmobile.Api.ApiClient;
import com.example.paneninmobile.Api.UserRequest;
import com.example.paneninmobile.Api.UserResponse;
import com.example.paneninmobile.MainActivity;
import com.example.paneninmobile.R;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegisterActivity extends AppCompatActivity {
    ImageView btn_back;
    TextView btn_tologin;
    Button btn_register;
    EditText firstname, lastname, alamat, email, no_telp, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        firstname = findViewById(R.id.nama);
        lastname = findViewById(R.id.nama2);
        email = findViewById(R.id.email);
        alamat = findViewById(R.id.alamat);
        no_telp = findViewById(R.id.nohp);
        password = findViewById(R.id.password);


        btn_back = findViewById(R.id.back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, OnBoarding.class));
            }
        });

        btn_tologin = findViewById(R.id.tologin);
        btn_tologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });


        btn_register = findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveUser(createRequest());
            }
        });
    }

    public UserRequest createRequest() {
        UserRequest userRequest = new UserRequest();
        userRequest.setEmail(email.getText().toString());
        userRequest.setAlamat(alamat.getText().toString());
        userRequest.setFirstname(firstname.getText().toString());
        userRequest.setLastname(lastname.getText().toString());
        userRequest.setNo_telp(no_telp.getText().toString());
        userRequest.setPassword(password.getText().toString());


        return userRequest;
    }

    public void saveUser(UserRequest userRequest) {
        Call<UserResponse> userResponseCall = ApiClient.getUserService().saveUser(userRequest);
        userResponseCall.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if (response.isSuccessful()) {
                    // Tanggapan berhasil diterima
                    UserResponse userResponse = response.body();
                    String responseData = userResponse != null ? userResponse.getMessage() : "";
                    Toast.makeText(RegisterActivity.this, responseData, Toast.LENGTH_LONG).show();
                    startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                } else {
                    // Tanggapan gagal diterima
                    try {
                        String errorBody = response.errorBody().string();
                        Toast.makeText(RegisterActivity.this, errorBody, Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                        Toast.makeText(RegisterActivity.this, "IOException", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(RegisterActivity.this, "Throwable: " + t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                Log.e("ErrorAPI", "onFailure:" + t.getMessage() + t.getLocalizedMessage());
            }
        });
    }
}