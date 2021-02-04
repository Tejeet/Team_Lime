package com.tejeet.tataclicq_clone.Fragments;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tejeet.tataclicq_clone.DataNModels.SharedPrefData;
import com.tejeet.tataclicq_clone.LoginActivity;
import com.tejeet.tataclicq_clone.R;

public class MyAccountFragment extends Fragment {

    private TextView mUserName, mLogoutBtn;

    private SharedPrefData cn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_account, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        cn = new SharedPrefData();

        mUserName = view.findViewById(R.id.tvUserName);
        mLogoutBtn = view.findViewById(R.id.tvLogout);

        mUserName.setText(cn.getName(getActivity()));

        mLogoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder1 = new AlertDialog.Builder(getActivity());
                builder1.setTitle("Logout from App !");
                builder1.setMessage("Are you sure wants to logout from app ?");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                cn.setLoginStatus(getActivity(), "0");
                                startActivity(new Intent(getActivity(), LoginActivity.class));
                                dialog.cancel();
                            }
                        });

                builder1.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });

                AlertDialog alert11 = builder1.create();
                alert11.show();

            }
        });
    }
}