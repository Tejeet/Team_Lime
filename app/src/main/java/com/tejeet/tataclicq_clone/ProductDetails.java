package com.tejeet.tataclicq_clone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.transition.DrawableCrossFadeFactory;
import com.tejeet.tataclicq_clone.DataNModels.DataNConstants;
import com.tejeet.tataclicq_clone.DataNModels.ProductDetailsDTO;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

public class ProductDetails extends AppCompatActivity {


    private TextView mBrandName, mProductPrice, mProductTitle;
    private ImageView mProductImage;
    private Button mAddtoCart;

    private ProductDetailsDTO pd;

    private LinearLayout mAddtoCartView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("Product Details");

        mProductImage = findViewById(R.id.ivproductDetails);
        mBrandName = findViewById(R.id.tvbrandName);
        mProductPrice = findViewById(R.id.tvProductPrice);
        mProductTitle = findViewById(R.id.tvProductName);

        mAddtoCart = findViewById(R.id.btnaddtocart);
        mAddtoCartView = findViewById(R.id.lottieAddtoCard);

        mAddtoCartView.setVisibility(View.INVISIBLE);


        Bundle bundle = getIntent().getExtras();
        pd = (ProductDetailsDTO) bundle.getSerializable(DataNConstants.KEY_PRODUCT_DETAILS_MODEL);

        if (!bundle.isEmpty()){

            if (!pd.getFileurl().contains("NULL")){

                DrawableCrossFadeFactory factory =
                        new DrawableCrossFadeFactory.Builder().setCrossFadeEnabled(true).build();

                Glide.with(this)
                        .load(pd.getFileurl())
                        .transition(withCrossFade(factory))
                        .placeholder(R.drawable.top_smartphone)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .error(R.drawable.shopnow_mobile)
                        .into(mProductImage);
            }

            mBrandName.setText(pd.getBrandname());
            mProductTitle.setText(pd.getName());
            mProductPrice.setText("₹ "+pd.getPrice()+" INR");

        }

        mAddtoCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mAddtoCartView.setVisibility(View.VISIBLE);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mAddtoCartView.setVisibility(View.INVISIBLE);
                        startActivity(new Intent(ProductDetails.this, MainActivity.class));
                    }
                }, 1000);

            }
        });




    }


    public boolean onSupportNavigateUp() {
        startActivity(new Intent(ProductDetails.this, MainActivity.class));
        overridePendingTransition(R.anim.exit_first, R.anim.exit_second);
        finish();
        return true;
    }

    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(ProductDetails.this, MainActivity.class));
        overridePendingTransition(R.anim.exit_first, R.anim.exit_second);
        finish();
    }
}