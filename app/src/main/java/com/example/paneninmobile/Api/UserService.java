package com.example.paneninmobile.Api;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface UserService {

    @POST("api/login")
    Call<LoginResponse> userLogin(@Body LoginRequest loginRequest);

    @POST("api/adduser")
    Call<UserResponse> saveUser(@Body UserRequest userRequest);
}
