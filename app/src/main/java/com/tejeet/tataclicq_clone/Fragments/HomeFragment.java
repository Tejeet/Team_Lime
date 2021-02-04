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

import com.tejeet.tataclicq_clone.Adapters.HomeScreenTitleAdapter;
import com.tejeet.tataclicq_clone.Adapters.ShopNowAdapter;
import com.tejeet.tataclicq_clone.DataNModels.DataNConstants;
import com.tejeet.tataclicq_clone.DataNModels.ModelClicqFavoritemages;
import com.tejeet.tataclicq_clone.DataNModels.ModelShowNowImages;
import com.tejeet.tataclicq_clone.DataNModels.ModelTopHeaderImages;
import com.tejeet.tataclicq_clone.Listners.CategoryClickListner;
import com.tejeet.tataclicq_clone.Products;
import com.tejeet.tataclicq_clone.R;

import java.util.ArrayList;


public class HomeFragment extends Fragment implements CategoryClickListner {

    private static final String TAG = "tag";

    private RecyclerView mTitleRecyclerView;
    private HomeScreenTitleAdapter mTitleAdapter;
    private ModelTopHeaderImages mTopImages;

    private ArrayList titleImagesList = new ArrayList<ModelTopHeaderImages>();


    private RecyclerView mShopNowRecyclerView;
    private ShopNowAdapter mShopNowAdapter;
    private ModelShowNowImages mShopImages;

    private ArrayList shopNowImagesList = new ArrayList<ModelShowNowImages>();




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mTitleRecyclerView = view.findViewById(R.id.rcvTitleImages);
        mShopNowRecyclerView = view.findViewById(R.id.rcvShopNowImages);
        setTitleRecyclerView();
        setShopNowRecyclerView();


    }

    private void setTitleRecyclerView() {

        buildTitleImageData();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mTitleRecyclerView.setLayoutManager(linearLayoutManager);
        mTitleAdapter = new HomeScreenTitleAdapter(titleImagesList, this);
        mTitleRecyclerView.setAdapter(mTitleAdapter);

    }

    private void buildTitleImageData() {


        titleImagesList.add(new ModelTopHeaderImages(R.drawable.top_appliances, "electronics"));
        titleImagesList.add(new ModelTopHeaderImages(R.drawable.top_audio, "electronics"));
        titleImagesList.add(new ModelTopHeaderImages(R.drawable.top_electronics,"electronics"));
        titleImagesList.add(new ModelTopHeaderImages(R.drawable.top_footwear,"mens"));
        titleImagesList.add(new ModelTopHeaderImages(R.drawable.top_hairstyle, "mens"));
        titleImagesList.add(new ModelTopHeaderImages(R.drawable.top_luxury,"watch"));
        titleImagesList.add(new ModelTopHeaderImages(R.drawable.top_menswear, "mens"));
        titleImagesList.add(new ModelTopHeaderImages(R.drawable.top_smartphone,"samrtphone"));
        titleImagesList.add(new ModelTopHeaderImages(R.drawable.top_westside, "ladies"));
        titleImagesList.add(new ModelTopHeaderImages(R.drawable.top_womenwear,"ladies"));

    }

    private void setShopNowRecyclerView() {

        buildShopNowData();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mShopNowRecyclerView.setLayoutManager(linearLayoutManager);
        mShopNowAdapter = new ShopNowAdapter(shopNowImagesList, this);
        mShopNowRecyclerView.setAdapter(mShopNowAdapter);

    }

    private void buildShopNowData() {

        shopNowImagesList.add(new ModelShowNowImages(R.drawable.shopnow_buds, "electronics"));
        shopNowImagesList.add(new ModelShowNowImages(R.drawable.shopnow_earpods, "samrtphone"));
        shopNowImagesList.add(new ModelShowNowImages(R.drawable.shopnow_galaxy, "samrtphone"));
        shopNowImagesList.add(new ModelShowNowImages(R.drawable.shopnow_mobile, "samrtphone"));
        shopNowImagesList.add(new ModelShowNowImages(R.drawable.shopnow_shampoo, "ladies"));
        shopNowImagesList.add(new ModelShowNowImages(R.drawable.shopnow_swatshirts, "mens"));
        shopNowImagesList.add(new ModelShowNowImages(R.drawable.shopnow_tantra, "ladies"));
        shopNowImagesList.add(new ModelShowNowImages(R.drawable.shopnow_trueforge, "ladies"));
        shopNowImagesList.add(new ModelShowNowImages(R.drawable.shopnow_vivo, "samrtphone"));
        shopNowImagesList.add(new ModelShowNowImages(R.drawable.shopnow_watch, "watch"));

    }


    @Override
    public void onCategoryClick(String name) {
        Log.d(TAG, "Selcted Category "+name);

        Intent intent = new Intent(getActivity(), Products.class);
        intent.putExtra(DataNConstants.KEY_CATEGORY, name);
        startActivity(intent);
    }
}