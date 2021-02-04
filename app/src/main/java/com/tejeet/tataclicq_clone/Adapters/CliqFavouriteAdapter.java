package com.tejeet.tataclicq_clone.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tejeet.tataclicq_clone.DataNModels.ModelClicqFavoritemages;
import com.tejeet.tataclicq_clone.DataNModels.ModelTopHeaderImages;
import com.tejeet.tataclicq_clone.Listners.CategoryClickListner;
import com.tejeet.tataclicq_clone.R;
import com.tejeet.tataclicq_clone.ViewHolders.ClickFavouriteViewHolder;
import com.tejeet.tataclicq_clone.ViewHolders.HomeScreenTitleViewHolder;

import java.util.ArrayList;

public class CliqFavouriteAdapter extends RecyclerView.Adapter<ClickFavouriteViewHolder> {

    private ArrayList mImagesList;
    private CategoryClickListner categoryClickListner;

    private static final String TAG = "tag";

    public CliqFavouriteAdapter(ArrayList mImagesList, CategoryClickListner categoryClickListner) {
        this.mImagesList = mImagesList;
        this.categoryClickListner = categoryClickListner;
    }

    @NonNull
    @Override
    public ClickFavouriteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_clickfavorite_images_items, parent, false);
        return new ClickFavouriteViewHolder(view, categoryClickListner);

    }

    @Override
    public void onBindViewHolder(@NonNull ClickFavouriteViewHolder holder, int position) {

        ModelClicqFavoritemages data = (ModelClicqFavoritemages) mImagesList.get(position);
        holder.setData(data);

    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "List Size is "+ mImagesList.size());
        return mImagesList.size();
    }
}
