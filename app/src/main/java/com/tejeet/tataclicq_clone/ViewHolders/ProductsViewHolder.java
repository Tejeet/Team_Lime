package com.tejeet.tataclicq_clone.ViewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tejeet.tataclicq_clone.DataNModels.ProductDetailsDTO;
import com.tejeet.tataclicq_clone.R;

public class ProductsViewHolder extends RecyclerView.ViewHolder {

    ImageView mProductImage;
    TextView mBrandName, mProductName, mProductPrice;
    CardView mProductRowRow;

    public ProductsViewHolder(@NonNull View itemView) {
        super(itemView);

        mProductImage = itemView.findViewById(R.id.ivproductImage);

        mBrandName = itemView.findViewById(R.id.tvBrandName);
        mProductName = itemView.findViewById(R.id.tvProductTitle);
        mProductPrice = itemView.findViewById(R.id.tvProductPrice);

        mProductRowRow = itemView.findViewById(R.id.cvProductRow);
    }

    public void setData(ProductDetailsDTO data){

        mBrandName.setText(data.getBrandname());
        mProductName.setText(data.getName());
        mProductPrice.setText("₹ "+data.getPrice()+" INR");

        Glide.with(mProductImage.getContext())
                .load(data.getFileurl())
                .into(mProductImage);
    }
}
