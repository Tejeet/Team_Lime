package com.tejeet.tataclicq_clone.ViewHolders;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tejeet.tataclicq_clone.DataNModels.ModelCategory;
import com.tejeet.tataclicq_clone.DataNModels.ModelTopHeaderImages;
import com.tejeet.tataclicq_clone.Listners.CategoryClickListner;
import com.tejeet.tataclicq_clone.R;

public class CategoryViewHolder extends RecyclerView.ViewHolder {

    private static final String TAG = "tag";
    private TextView mCategoryName;
    private LinearLayout mCategoryView;
    private CategoryClickListner categoryClickListner;

    public CategoryViewHolder(@NonNull View itemView, CategoryClickListner categoryClickListner) {
        super(itemView);

        mCategoryName = itemView.findViewById(R.id.tvCategoryName);
        mCategoryView = itemView.findViewById(R.id.llCategotyRow);
        this.categoryClickListner = categoryClickListner;

    }

    public void setData(ModelCategory data, int position){

      //  Log.d(TAG, "Category Name is "+data.getName());
        mCategoryName.setText(data.getName());

        mCategoryView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                categoryClickListner.onCategoryClick(data.getCategory());
            }
        });

    }
}
