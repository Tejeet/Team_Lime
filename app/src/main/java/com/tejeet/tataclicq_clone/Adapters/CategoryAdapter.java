package com.tejeet.tataclicq_clone.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tejeet.tataclicq_clone.DataNModels.ModelCategory;
import com.tejeet.tataclicq_clone.Listners.CategoryClickListner;
import com.tejeet.tataclicq_clone.R;
import com.tejeet.tataclicq_clone.ViewHolders.CategoryViewHolder;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryViewHolder> {

    private ArrayList<ModelCategory> mCategoryList;
    private CategoryClickListner categoryClickListner;

    public CategoryAdapter(ArrayList<ModelCategory> mCategoryList, CategoryClickListner categoryClickListner) {
        this.mCategoryList = mCategoryList;
        this.categoryClickListner = categoryClickListner;
    }


    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_category_items, parent, false);
        return new CategoryViewHolder(view, categoryClickListner);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {

        ModelCategory data = mCategoryList.get(position);
        holder.setData(data, position);
    }

    @Override
    public int getItemCount() {
        return mCategoryList.size();
    }
}
