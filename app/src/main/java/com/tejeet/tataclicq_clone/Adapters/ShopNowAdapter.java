package com.tejeet.tataclicq_clone.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tejeet.tataclicq_clone.DataNModels.ModelShowNowImages;
import com.tejeet.tataclicq_clone.DataNModels.ModelTopHeaderImages;
import com.tejeet.tataclicq_clone.Listners.CategoryClickListner;
import com.tejeet.tataclicq_clone.R;
import com.tejeet.tataclicq_clone.ViewHolders.HomeScreenTitleViewHolder;
import com.tejeet.tataclicq_clone.ViewHolders.ShopNowViewHolder;

import java.util.ArrayList;

public class ShopNowAdapter extends RecyclerView.Adapter<ShopNowViewHolder> {

    private ArrayList mImagesList;
    private CategoryClickListner categoryClickListner;

    private static final String TAG = "tag";

    public ShopNowAdapter(ArrayList mImagesList, CategoryClickListner categoryClickListner) {
        this.mImagesList = mImagesList;
        this.categoryClickListner = categoryClickListner;
    }

    @NonNull
    @Override
    public ShopNowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_shownow_images_items, parent, false);
        return new ShopNowViewHolder(view, categoryClickListner);

    }

    @Override
    public void onBindViewHolder(@NonNull ShopNowViewHolder holder, int position) {

        ModelShowNowImages data = (ModelShowNowImages) mImagesList.get(position);
        holder.setData(data);

    }

    @Override
    public int getItemCount() {
       // Log.d(TAG, "List Size is "+ mImagesList.size());
        return mImagesList.size();
    }
}
