package com.tejeet.tataclicq_clone.ApiClients;

import com.tejeet.tataclicq_clone.DataNModels.LoginResponseDTO;
import com.tejeet.tataclicq_clone.DataNModels.ResponseDTO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiClient {

    @GET("api.php")
    Call<ResponseDTO> getProductsByCategory(@Query("category") String productCategory);

    @GET("api.php")
    Call<LoginResponseDTO> getUserDetails(@Query("email") String email, @Query("pass") String pass);


}
