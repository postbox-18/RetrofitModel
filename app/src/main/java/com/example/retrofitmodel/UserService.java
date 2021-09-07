package com.example.retrofitmodel;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface UserService {
    @GET("/test/retro")
    Call<ArrayList<ResObj>> login();
}
