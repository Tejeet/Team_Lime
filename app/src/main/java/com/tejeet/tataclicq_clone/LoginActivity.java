package com.tejeet.tataclicq_clone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tejeet.tataclicq_clone.ApiClients.ApiClient;
import com.tejeet.tataclicq_clone.DataNModels.LoginResponseDTO;
import com.tejeet.tataclicq_clone.DataNModels.ResponseDTO;
import com.tejeet.tataclicq_clone.DataNModels.SharedPrefData;
import com.tejeet.tataclicq_clone.Networks.Network;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private SharedPrefData cn;
    private EditText mUserID, mUserPass;
    private Button mLoginBtn;
    private ProgressDialog progressDialog;

    private static final String TAG = "tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        cn = new SharedPrefData();
        mUserID = findViewById(R.id.etUserID);
        mUserPass = findViewById(R.id.etUserPass);

        mLoginBtn = findViewById(R.id.btnLogin);

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ((!mUserID.getText().toString().isEmpty()) && (!mUserPass.getText().toString().isEmpty()) ){

                    progressDialog = new ProgressDialog(LoginActivity.this);
                    progressDialog.setTitle("Loggin In ...");
                    progressDialog.setCancelable(false);
                    progressDialog.show();

                    loginAuthenticate(mUserID.getText().toString(), mUserPass.getText().toString());
                }
            }
        });



    }


    private void loginAuthenticate(String email, String pass){

        ApiClient apiClient = Network.getInstance().create(ApiClient.class);
        apiClient.getUserDetails(email, pass).enqueue(new Callback<LoginResponseDTO>() {
            @Override
            public void onResponse(Call<LoginResponseDTO> call, Response<LoginResponseDTO> response) {

                Log.d(TAG, "Response is "+response.body().toString());

                progressDialog.dismiss();

                if (response.body() != null){

                    if (response.body().getRequeststatus() == 1){

                        Toast.makeText(LoginActivity.this, "Login Success", Toast.LENGTH_SHORT).show();
                        cn.SaveProfile(LoginActivity.this,  response.body().getUsername(), response.body().getEmail(), response.body().getMobile());
                        cn.setLoginStatus(LoginActivity.this, "1");

                        startActivity(new Intent(LoginActivity.this, MainActivity.class));

                    }
                    else{

                        cn.setLoginStatus(LoginActivity.this, "1");
                        Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                        mUserID.setError("Please Check User ID");
                        mUserPass.setError("Please Check Password");

                    }

                }

            }

            @Override
            public void onFailure(Call<LoginResponseDTO> call, Throwable t) {

            }
        });

    }
}