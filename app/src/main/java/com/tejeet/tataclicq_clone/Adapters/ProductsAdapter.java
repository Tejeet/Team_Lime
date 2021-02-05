package com.tejeet.tataclicq_clone.Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.tejeet.tataclicq_clone.DataNModels.ProductDetailsDTO;
import com.tejeet.tataclicq_clone.Listners.ProductClickListner;
import com.tejeet.tataclicq_clone.ProductDetails;
import com.tejeet.tataclicq_clone.R;
import com.tejeet.tataclicq_clone.ViewHolders.ProductsViewHolder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsViewHolder> {

    private static final String TAG = "tag";

    private List<ProductDetailsDTO> productItems;
    private List<ProductDetailsDTO> productItemsUnfiltered;
    private Context mContext;

    public ProductsAdapter(List<ProductDetailsDTO> listItems , Context mContext) {
        this.productItems = listItems;
        this.productItemsUnfiltered = new ArrayList<>(listItems);
        this.mContext = mContext;

    }


    @NonNull
    @Override
    public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_product_items, parent, false);

        return new ProductsViewHolder(view, (ProductClickListner) mContext);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsViewHolder holder, int position) {

         ProductDetailsDTO data = productItems.get(position);
         holder.setData(data);

    }

    @Override
    public int getItemCount() {
        return productItems.size();
    }



}
