package com.tejeet.tataclicq_clone.ViewHolders;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.tejeet.tataclicq_clone.DataNModels.MyCartModel;
import com.tejeet.tataclicq_clone.Listners.MyCartProductClickListner;
import com.tejeet.tataclicq_clone.R;

public class MyCartViewHolder extends RecyclerView.ViewHolder {

    private static final String TAG = "tag";
    private CardView mCartRow;
    private TextView mProductName, mProductPrice, mRemoveBtn;
    private ImageView mProductImage;
    private MyCartProductClickListner myCartProductClickListner;


    public MyCartViewHolder(@NonNull View itemView, MyCartProductClickListner myCartProductClickListner) {
        super(itemView);

        this.myCartProductClickListner = myCartProductClickListner;

        mCartRow = itemView.findViewById(R.id.cvMyCartRow);
        mProductName = itemView.findViewById(R.id.tvProductTitle);
        mProductPrice = itemView.findViewById(R.id.tvProductPrice);
        mRemoveBtn = itemView.findViewById(R.id.tvProductRemove);

        mProductImage = itemView.findViewById(R.id.ivmycartProductImage);

    }

    public void setData(MyCartModel data, int position){

        mProductName.setText(data.getProductName());
        mProductPrice.setText("₹ "+data.getPrice()+" INR");

        Glide.with(mProductImage.getContext())
                .load(data.getFileUrl())
                .into(mProductImage);



        mRemoveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "Remove from cart Product is "+data.getProductName() );
                myCartProductClickListner.onProductRemove(data, position);
            }
        });


    }
}
