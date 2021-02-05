package com.tejeet.tataclicq_clone.ViewHolders;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tejeet.tataclicq_clone.DataNModels.ModelTopHeaderImages;
import com.tejeet.tataclicq_clone.Listners.CategoryClickListner;
import com.tejeet.tataclicq_clone.R;

public class HomeScreenTitleViewHolder extends RecyclerView.ViewHolder {

    private static final String TAG = "tag";
    private ImageView mImageTitle;
    private CategoryClickListner categoryClickListner;

    public HomeScreenTitleViewHolder(@NonNull View itemView, CategoryClickListner categoryClickListner) {
        super(itemView);

        mImageTitle = itemView.findViewById(R.id.ivtopImages);
        this.categoryClickListner = categoryClickListner;

    }

    public void setData(ModelTopHeaderImages data){

       // Log.d(TAG, "Setting Image with ID is "+data.getImageID());
        mImageTitle.setImageResource(data.getImageID());

        mImageTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categoryClickListner.onCategoryClick(data.getCategory());
            }
        });

    }
}
