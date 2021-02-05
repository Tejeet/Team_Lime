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
import com.tejeet.tataclicq_clone.DataNModels.SignupResponseDTO;
import com.tejeet.tataclicq_clone.Networks.Network;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {

    private static final String TAG = "tag";

    private EditText mUserName, mUserEmail, mUserMobile;
    private Button mSignupBtn, mLoginBackBtn;

    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        mUserName = findViewById(R.id.etUserName);
        mUserEmail = findViewById(R.id.etUserEmail);
        mUserMobile = findViewById(R.id.etUserMobile);

        mSignupBtn = findViewById(R.id.btnSignup);
        mLoginBackBtn = findViewById(R.id.btnLoginBack);


        mSignupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if ((!mUserName.getText().toString().isEmpty()) && (!mUserEmail.getText().toString().isEmpty())
                        && (!mUserMobile.getText().toString().isEmpty())) {

                    progressDialog = new ProgressDialog(SignupActivity.this);
                    progressDialog.setTitle("Creating Account...");
                    progressDialog.setCancelable(false);
                    progressDialog.show();

                    createAccount(mUserName.getText().toString(), mUserEmail.getText().toString(), mUserMobile.getText().toString());
                }


            }
        });


        mLoginBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                overridePendingTransition(R.anim.exit_first, R.anim.exit_second);
                finish();

            }
        });


    }

    private void createAccount(String name, String email, String mobile) {

        ApiClient apiClient = Network.getInstance().create(ApiClient.class);
        apiClient.addNewUser(name, email, mobile).enqueue(new Callback<SignupResponseDTO>() {
            @Override
            public void onResponse(Call<SignupResponseDTO> call, Response<SignupResponseDTO> response) {
                Log.d(TAG, "Response is " + response.body().toString());

                progressDialog.dismiss();

                if (response.body() != null) {

                    if (response.body().getRequeststatus() == 1) {

                        Toast.makeText(SignupActivity.this, "Account Created Success", Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(SignupActivity.this, LoginActivity.class));

                    } else {

                        Toast.makeText(SignupActivity.this,"Connection Error Please Try Again", Toast.LENGTH_SHORT).show();

                    }

                }
            }

            @Override
            public void onFailure(Call<SignupResponseDTO> call, Throwable t) {

            }
        });

    }


}