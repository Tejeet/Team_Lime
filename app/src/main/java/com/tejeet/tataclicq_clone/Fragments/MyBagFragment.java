package com.tejeet.tataclicq_clone.Fragments;

import android.app.ProgressDialog;
import android.content.Intent;
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
import android.widget.Toast;

import com.tejeet.tataclicq_clone.Adapters.MyCartAdapter;
import com.tejeet.tataclicq_clone.Adapters.ProductsAdapter;
import com.tejeet.tataclicq_clone.ApiClients.ApiClient;
import com.tejeet.tataclicq_clone.DataNModels.CallResponseDTO;
import com.tejeet.tataclicq_clone.DataNModels.DataNConstants;
import com.tejeet.tataclicq_clone.DataNModels.LoginResponseDTO;
import com.tejeet.tataclicq_clone.DataNModels.MyCartModel;
import com.tejeet.tataclicq_clone.DataNModels.ProductDetailsDTO;
import com.tejeet.tataclicq_clone.DataNModels.SharedPrefData;
import com.tejeet.tataclicq_clone.Listners.MyCartProductClickListner;
import com.tejeet.tataclicq_clone.LoginActivity;
import com.tejeet.tataclicq_clone.MainActivity;
import com.tejeet.tataclicq_clone.Networks.Network;
import com.tejeet.tataclicq_clone.R;
import com.tejeet.tataclicq_clone.SQLData.DBHandler;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyBagFragment extends Fragment implements MyCartProductClickListner {

    private static final String TAG = "tag";

    private Button mContineShopping, mCheckout;
    private LinearLayout mEmptyBagView, mMyCartView, mTotalView;

    private RecyclerView mRecyclerView;
    private MyCartAdapter mAdapter;

    private DBHandler dbHandler;
    private ArrayList mMyCartList = new ArrayList<MyCartModel>();
    private DataNConstants cn;

    private String gTotal;

    private TextView mCartTotal;

    private SharedPrefData mystoredData;

    private ProgressDialog progressDialog;

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
        mystoredData = new SharedPrefData();

        mContineShopping = view.findViewById(R.id.btnContineShopping);
        mEmptyBagView = view.findViewById(R.id.llemptyView);
        mMyCartView = view.findViewById(R.id.llmyCartView);
        mTotalView = view.findViewById(R.id.llTotalView);
        mCartTotal = view.findViewById(R.id.tvcartTotal);

        mCheckout = view.findViewById(R.id.btnCheckout);


        mRecyclerView = view.findViewById(R.id.rcvMyCart);

        gTotal = dbHandler.getCartTotal();

        if (dbHandler.getmycartItems().size() >= 1){
            mEmptyBagView.setVisibility(View.GONE);
            mMyCartView.setVisibility(View.VISIBLE);
            mTotalView.setVisibility(View.VISIBLE);

            mCartTotal.setText("₹ "+gTotal);

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


        mCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                progressDialog = new ProgressDialog(getActivity());
                progressDialog.setTitle("Paying Now ...");
                progressDialog.setCancelable(false);
                progressDialog.show();

                sendOrder(mystoredData.getName(getContext()), gTotal, mystoredData.getMobile(getContext()));
            }
        });



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


    private void sendOrder(String ordeName, String amount, String mobile){

        ApiClient apiClient = Network.getInstance().create(ApiClient.class);
        apiClient.sendConfirmCall(ordeName, amount, mobile).enqueue(new Callback<CallResponseDTO>() {
            @Override
            public void onResponse(Call<CallResponseDTO> call, Response<CallResponseDTO> response) {

                progressDialog.dismiss();

                if (response.body() != null){
                    Toast.makeText(getContext(), "Payment Done Order Placed Successfully", Toast.LENGTH_SHORT).show();
                    dbHandler.deleteWholeCart();
                }
            }

            @Override
            public void onFailure(Call<CallResponseDTO> call, Throwable t) {

            }
        });

    }
}