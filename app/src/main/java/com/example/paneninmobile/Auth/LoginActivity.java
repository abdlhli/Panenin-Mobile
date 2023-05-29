package com.example.paneninmobile.Auth;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.paneninmobile.Api.ApiClient;
import com.example.paneninmobile.Api.LoginRequest;
import com.example.paneninmobile.Api.LoginResponse;
import com.example.paneninmobile.MainActivity;
import com.example.paneninmobile.PrefManager;
import com.example.paneninmobile.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
    ImageView btn_back;
    TextView btn_toregist;
    TextView btn_login;
    EditText email, password;
    private PrefManager prefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = findViewById(R.id.inputusername);
        password = findViewById(R.id.inputpass);

        btn_back = findViewById(R.id.back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, OnBoarding.class));
            }
        });

        btn_toregist = findViewById(R.id.toregist);
        btn_toregist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
            }
        });

        // Inisialisasi PrefManager
        prefManager = new PrefManager(this);

        if (prefManager.isLoggedIn()) {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
            finish();
        }

        btn_login = findViewById(R.id.btn_login);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String _email = email.getText().toString().trim();
                String _password = password.getText().toString().trim();
                if (!_email.equals("") && !_password.equals("")){
                    login();
                } else {
                    email.setError("email tidak boleh kosong");
                    password.setError("password tidak boleh kosong");

                }
            }
        });
    }

    public void login() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setEmail(email.getText().toString());
        loginRequest.setPassword(password.getText().toString());

        Call<LoginResponse> loginResponseCall = ApiClient.getUserService().userLogin(loginRequest);
        loginResponseCall.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {

                Log.d("API Response","Data Berhasil Diambil:");
                String errorMessage = "Error:" + response.code() + "-" + response.message();
                Log.e("API Response", errorMessage);
                if (response.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "Berhasil Login", Toast.LENGTH_LONG).show();
                    // Set status login ke true setelah login berhasil
                    prefManager.setLoggedIn(true);
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));

                } else {
                    Toast.makeText(LoginActivity.this, "Gagal Login", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Throwable" +t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();

                Log.d("API Response","Data Berhasil Diambil:");
                Log.e("ErrorAPI", "onFailure:" +t.getMessage());
            }

        });
    }
}


