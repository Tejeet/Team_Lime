package com.tejeet.tataclicq_clone.Fragments;

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

import com.tejeet.tataclicq_clone.Adapters.CliqFavouriteAdapter;
import com.tejeet.tataclicq_clone.Adapters.HomeScreenTitleAdapter;
import com.tejeet.tataclicq_clone.DataNModels.DataNConstants;
import com.tejeet.tataclicq_clone.DataNModels.ModelClicqFavoritemages;
import com.tejeet.tataclicq_clone.DataNModels.ModelTopHeaderImages;
import com.tejeet.tataclicq_clone.Listners.CategoryClickListner;
import com.tejeet.tataclicq_clone.Products;
import com.tejeet.tataclicq_clone.R;

import java.util.ArrayList;

public class BrandsFragment extends Fragment implements CategoryClickListner {

    private RecyclerView mBrandRecyclerView;
    private CliqFavouriteAdapter mBrandAdapter;
    private ModelClicqFavoritemages mTopImages;

    private static final String TAG = "tag";

    private ArrayList brandImageList = new ArrayList<ModelClicqFavoritemages>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_brands, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mBrandRecyclerView = view.findViewById(R.id.rcvbrandHub);
        setBrandRecyclerView();
        mBrandRecyclerView.scrollToPosition(2);

    }

    private void setBrandRecyclerView() {
        buildBrandImageData();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mBrandRecyclerView.setLayoutManager(linearLayoutManager);
        mBrandAdapter = new CliqFavouriteAdapter(brandImageList, this);
        mBrandRecyclerView.setAdapter(mBrandAdapter);
    }

    private void buildBrandImageData() {

        brandImageList.add(new ModelClicqFavoritemages(R.drawable.click_fav_westside, "ladies"));
        brandImageList.add(new ModelClicqFavoritemages(R.drawable.click_fav_voltas, "electronics"));
        brandImageList.add(new ModelClicqFavoritemages(R.drawable.click_fav_whirlpool, "electronics"));
        brandImageList.add(new ModelClicqFavoritemages(R.drawable.click_fav_khadi, "ladies"));
        brandImageList.add(new ModelClicqFavoritemages(R.drawable.click_fav_titan, "watch"));
        brandImageList.add(new ModelClicqFavoritemages(R.drawable.click_fav_refrigrator, "samrtphone"));


    }

    @Override
    public void onCategoryClick(String name) {

        Log.d(TAG, "Selcted Category "+name);

        Intent intent = new Intent(getActivity(), Products.class);
        intent.putExtra(DataNConstants.KEY_CATEGORY, name);
        startActivity(intent);
    }
}