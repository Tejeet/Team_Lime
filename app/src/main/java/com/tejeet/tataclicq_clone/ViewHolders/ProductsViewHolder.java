package com.tejeet.tataclicq_clone.ViewHolders;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tejeet.tataclicq_clone.DataNModels.ProductDetailsDTO;
import com.tejeet.tataclicq_clone.Listners.ProductClickListner;
import com.tejeet.tataclicq_clone.R;

public class ProductsViewHolder extends RecyclerView.ViewHolder {

    ImageView mProductImage;
    TextView mBrandName, mProductName, mProductPrice;
    CardView mProductRowRow;

    private static final String TAG = "tag";

    private ProductClickListner productClickListner;

    public ProductsViewHolder(@NonNull View itemView, ProductClickListner productClickListner) {
        super(itemView);

        this.productClickListner = productClickListner;
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

        mProductRowRow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Product Clicked is "+data.getName() );
               productClickListner.onProductClick(data);
            }
        });
    }
}
