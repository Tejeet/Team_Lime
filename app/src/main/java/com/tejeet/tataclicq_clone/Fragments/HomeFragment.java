package com.tejeet.tataclicq_clone.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tejeet.tataclicq_clone.Adapters.HomeScreenTitleAdapter;
import com.tejeet.tataclicq_clone.DataNModels.ModelTopHeaderImages;
import com.tejeet.tataclicq_clone.R;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private RecyclerView mTitleRecyclerView;
    private HomeScreenTitleAdapter mTitleAdapter;
    private ModelTopHeaderImages mTopImages;

    private ArrayList titleImagesList = new ArrayList<ModelTopHeaderImages>();


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
        setTitleRecyclerView();


    }

    private void setTitleRecyclerView() {

        buildTitleImageData();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        mTitleRecyclerView.setLayoutManager(linearLayoutManager);
        mTitleAdapter = new HomeScreenTitleAdapter(titleImagesList, getActivity());
        mTitleRecyclerView.setAdapter(mTitleAdapter);

    }

    private void buildTitleImageData() {

        titleImagesList.add(new ModelTopHeaderImages(R.drawable.top_appliances));
        titleImagesList.add(new ModelTopHeaderImages(R.drawable.top_audio));
        titleImagesList.add(new ModelTopHeaderImages(R.drawable.top_electronics));
        titleImagesList.add(new ModelTopHeaderImages(R.drawable.top_footwear));
        titleImagesList.add(new ModelTopHeaderImages(R.drawable.top_hairstyle));
        titleImagesList.add(new ModelTopHeaderImages(R.drawable.top_luxury));
        titleImagesList.add(new ModelTopHeaderImages(R.drawable.top_menswear));
        titleImagesList.add(new ModelTopHeaderImages(R.drawable.top_smartphone));
        titleImagesList.add(new ModelTopHeaderImages(R.drawable.top_westside));
        titleImagesList.add(new ModelTopHeaderImages(R.drawable.top_womenwear));

    }


}