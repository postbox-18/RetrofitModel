package com.example.retrofitmodel.modelusers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.example.retrofitmodel.Apiutils;
import com.example.retrofitmodel.CustomAdapter;
import com.example.retrofitmodel.MainActivity;
import com.example.retrofitmodel.R;
import com.example.retrofitmodel.ResObj;
import com.example.retrofitmodel.UserService;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecycleRetro extends AppCompatActivity {
    UserService userService;
    String TAG = "userexecuter";
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_retro);
        recyclerView = findViewById(R.id.recyclerView1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        userService = Apiutils.getUserService();
        //  Call<ResponseBody> call = userService.login();
        Call<List<ResponseRetro>> call = userService.retrouser();
        ProgressDialog progressBar = new ProgressDialog(this);
        progressBar.setMessage("Loading");
        progressBar.setCancelable(false);
        progressBar.show();
        call.enqueue(new Callback<List<ResponseRetro>>() {
            @Override
            public void onResponse(Call<List<ResponseRetro>> call, Response<List<ResponseRetro>> response) {
                ResponseRetro responseRetro=response.body().get(0);
                List<Users> users1=responseRetro.users;
                //users1.get
                Log.i(TAG, "Response=="+new Gson().toJson(responseRetro));
                Log.i(TAG, "Response=="+new Gson().toJson(users1));
                Log.i(TAG, "Response=="+users1);
                progressBar.dismiss();
                CustomAdapter customAdapter = new CustomAdapter(RecycleRetro.this,users1);
                recyclerView.setAdapter(customAdapter);


            }

            @Override
            public void onFailure(Call<List<ResponseRetro>> call, Throwable t) {
                    Log.e(TAG,"ERROR"+t.getMessage());
            }
        });


    }
}