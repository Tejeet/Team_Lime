package com.tejeet.tataclicq_clone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.tejeet.tataclicq_clone.Adapters.HomeScreenTitleAdapter;
import com.tejeet.tataclicq_clone.Adapters.ProductsAdapter;
import com.tejeet.tataclicq_clone.ApiClients.ApiClient;
import com.tejeet.tataclicq_clone.DataNModels.DataNConstants;
import com.tejeet.tataclicq_clone.DataNModels.ProductDetailsDTO;
import com.tejeet.tataclicq_clone.DataNModels.ResponseDTO;
import com.tejeet.tataclicq_clone.Networks.Network;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Products extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ProductsAdapter mAdapter;
    private ProgressBar mProgress;

    private ArrayList productList = new ArrayList<ProductDetailsDTO>();

    private static final String TAG = "tag";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mRecyclerView = findViewById(R.id.rcvProducts);
        mProgress = findViewById(R.id.pbProgressBar);

        setRecyclerView();

        mProgress.setVisibility(View.VISIBLE);

        if (getIntent() != null){
            callApi(getIntent().getStringExtra(DataNConstants.KEY_CATEGORY));
        }

    }

    public boolean onSupportNavigateUp() {
        startActivity(new Intent(Products.this, MainActivity.class));
        overridePendingTransition(R.anim.exit_first, R.anim.exit_second);
        finish();
        return true;
    }

    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Products.this, MainActivity.class));
        overridePendingTransition(R.anim.exit_first, R.anim.exit_second);
        finish();
    }

    private void setRecyclerView() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new ProductsAdapter(productList, this);
        mRecyclerView.setAdapter(mAdapter);

    }

    private void callApi(String productCategory) {

        ApiClient apiClient = Network.getInstance().create(ApiClient.class);
        apiClient.getProductsByCategory(productCategory).enqueue(new Callback<ResponseDTO>() {
            @Override
            public void onResponse(Call<ResponseDTO> call, Response<ResponseDTO> response) {
                if (response.body() != null) {

                    Log.d(TAG, "response is " + response.body().toString());

                    int sizedata = response.body().getProductDetails().size();

                    for(int i = 0; i< sizedata; i++){

                        productList.add(response.body().getProductDetails().get(i));

                    }
                    mAdapter.notifyDataSetChanged();
                    mProgress.setVisibility(View.GONE);
                }
            }

            @Override
            public void onFailure(Call<ResponseDTO> call, Throwable t) {

                Log.d(TAG, "Response Error  ");
            }
        });

    }


}