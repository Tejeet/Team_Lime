package com.tejeet.tataclicq_clone.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.tejeet.tataclicq_clone.Adapters.MyCartAdapter;
import com.tejeet.tataclicq_clone.Adapters.ProductsAdapter;
import com.tejeet.tataclicq_clone.DataNModels.DataNConstants;
import com.tejeet.tataclicq_clone.DataNModels.MyCartModel;
import com.tejeet.tataclicq_clone.DataNModels.ProductDetailsDTO;
import com.tejeet.tataclicq_clone.Listners.MyCartProductClickListner;
import com.tejeet.tataclicq_clone.R;
import com.tejeet.tataclicq_clone.SQLData.DBHandler;

import java.util.ArrayList;

public class MyBagFragment extends Fragment implements MyCartProductClickListner {

    private static final String TAG = "tag";

    private Button mContineShopping;
    private LinearLayout mEmptyBagView, mMyCartView, mTotalView;

    private RecyclerView mRecyclerView;
    private MyCartAdapter mAdapter;

    private DBHandler dbHandler;
    private ArrayList mMyCartList = new ArrayList<MyCartModel>();
    private DataNConstants cn;

    private TextView mCartTotal;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_bag, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cn = new DataNConstants();
        dbHandler = new DBHandler(getContext());

        mContineShopping = view.findViewById(R.id.btnContineShopping);
        mEmptyBagView = view.findViewById(R.id.llemptyView);
        mMyCartView = view.findViewById(R.id.llmyCartView);
        mTotalView = view.findViewById(R.id.llTotalView);
        mCartTotal = view.findViewById(R.id.tvcartTotal);

        mRecyclerView = view.findViewById(R.id.rcvMyCart);

        if (dbHandler.getmycartItems().size() >= 1){
            mEmptyBagView.setVisibility(View.GONE);
            mMyCartView.setVisibility(View.VISIBLE);
            mTotalView.setVisibility(View.VISIBLE);

            mCartTotal.setText("₹ "+dbHandler.getCartTotal());

            setRecyclerView();

            Log.d(TAG, "Total Cart Items "+ dbHandler.getmycartItems().size() );

            for (int i =0 ; i< dbHandler.getmycartItems().size();i++ ){

                mMyCartList.add(new MyCartModel(
                        dbHandler.getmycartItems().get(i).getCid(),
                        dbHandler.getmycartItems().get(i).getBrandName(),
                        dbHandler.getmycartItems().get(i).getProductName(),
                        dbHandler.getmycartItems().get(i).getPrice(),
                        dbHandler.getmycartItems().get(i).getDescription(),
                        dbHandler.getmycartItems().get(i).getFileUrl()
                ));
            }


            mAdapter.notifyDataSetChanged();

        }
        else{
            mEmptyBagView.setVisibility(View.VISIBLE);
            mMyCartView.setVisibility(View.GONE);
            mTotalView.setVisibility(View.GONE);

        }



        mContineShopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    public void setRecyclerView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mAdapter = new MyCartAdapter(mMyCartList, this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onProductRemove(MyCartModel data, int position) {

        dbHandler.delteItemFromCart(data.getCid());
        mAdapter.notifyDataSetChanged();

    }
}