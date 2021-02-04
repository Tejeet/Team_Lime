package com.tejeet.tataclicq_clone.Fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tejeet.tataclicq_clone.Adapters.CategoryAdapter;
import com.tejeet.tataclicq_clone.Adapters.HomeScreenTitleAdapter;
import com.tejeet.tataclicq_clone.DataNModels.DataNConstants;
import com.tejeet.tataclicq_clone.DataNModels.ModelCategory;
import com.tejeet.tataclicq_clone.DataNModels.ModelTopHeaderImages;
import com.tejeet.tataclicq_clone.Listners.CategoryClickListner;
import com.tejeet.tataclicq_clone.Products;
import com.tejeet.tataclicq_clone.R;

import java.util.ArrayList;


public class CategoryFragment extends Fragment implements CategoryClickListner {


    private RecyclerView mRecyclerView;
    private CategoryAdapter mAdapter;

    private ArrayList mCategoryList = new ArrayList<ModelCategory>();
    private CategoryClickListner categoryClickListner;
    private static final String TAG = "tag";



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mRecyclerView = view.findViewById(R.id.rcvCategory);
        setBrandRecyclerView();

    }

    private void setBrandRecyclerView() {

        buildCategoryData();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new CategoryAdapter(mCategoryList, this);
        mRecyclerView.setAdapter(mAdapter);

    }

    private void buildCategoryData() {

        mCategoryList.add(new ModelCategory("Womens Fashion", "ladies"));
        mCategoryList.add(new ModelCategory("Mens Fashion", "mens"));
        mCategoryList.add(new ModelCategory("Electronics", "electronics"));
        mCategoryList.add(new ModelCategory("Smart Phones", "samrtphone"));
        mCategoryList.add(new ModelCategory("Tv and Appliances", "electronics"));
        mCategoryList.add(new ModelCategory("Kids Fashion", "mens"));
        mCategoryList.add(new ModelCategory("Jewellery", "jwellery"));
        mCategoryList.add(new ModelCategory("Connected Homes", "samrtphone"));
        mCategoryList.add(new ModelCategory("Home furnishing", "mens"));
        mCategoryList.add(new ModelCategory("Fragrances", "jwellery"));
        mCategoryList.add(new ModelCategory("Watches", "watch"));
        mCategoryList.add(new ModelCategory("Hair Care", "ladies"));
        mCategoryList.add(new ModelCategory("Mens Grooming", "mens"));
    }

    @Override
    public void onCategoryClick(String name) {

        Log.d(TAG, "Selcted Category "+name);

        Intent intent = new Intent(getActivity(), Products.class);
        intent.putExtra(DataNConstants.KEY_CATEGORY, name);
        startActivity(intent);
    }
}