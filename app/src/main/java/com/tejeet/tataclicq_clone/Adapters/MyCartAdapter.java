package com.tejeet.tataclicq_clone.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tejeet.tataclicq_clone.DataNModels.MyCartModel;
import com.tejeet.tataclicq_clone.Fragments.MyBagFragment;
import com.tejeet.tataclicq_clone.Listners.MyCartProductClickListner;
import com.tejeet.tataclicq_clone.R;
import com.tejeet.tataclicq_clone.ViewHolders.MyCartViewHolder;

import java.util.ArrayList;

public class MyCartAdapter extends RecyclerView.Adapter<MyCartViewHolder> {

    private ArrayList<MyCartModel> mproductList;
    private MyBagFragment mContext;

    public MyCartAdapter(ArrayList<MyCartModel> mproductList, MyBagFragment mContext) {
        this.mproductList = mproductList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyCartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_mycart_items, parent, false);
        return new MyCartViewHolder(view, (MyCartProductClickListner) mContext);

    }

    @Override
    public void onBindViewHolder(@NonNull MyCartViewHolder holder, int position) {
        MyCartModel data = mproductList.get(position);
        holder.setData(data, position);
    }

    @Override
    public int getItemCount() {
        return mproductList.size();
    }
}
