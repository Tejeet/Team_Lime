package com.tejeet.tataclicq_clone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.app.ActionBar;
import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.tejeet.tataclicq_clone.Fragments.BrandsFragment;
import com.tejeet.tataclicq_clone.Fragments.CategoryFragment;
import com.tejeet.tataclicq_clone.Fragments.HomeFragment;
import com.tejeet.tataclicq_clone.Fragments.MyAccountFragment;
import com.tejeet.tataclicq_clone.Fragments.MyBagFragment;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "tag";

    private BottomNavigationView mBotoomNavigation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Welcome Tejeet");

        mBotoomNavigation = (BottomNavigationView) findViewById(R.id.nav_view);

        mBotoomNavigation.setSelectedItemId(R.id.navigation_Brands);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();

        mBotoomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                Fragment selctedFragment = null;

                switch (menuItem.getItemId()) {

                    case R.id.navigation_home:
                        vibrateSense();
                        getSupportActionBar().setTitle("Home");
                        selctedFragment = new HomeFragment();
                        Log.d(TAG, "Show Home Fragment ");
                        break;

                    case R.id.navigation_category:
                        vibrateSense();
                        getSupportActionBar().setTitle("Category");
                        selctedFragment = new CategoryFragment();
                        Log.d(TAG, "Show Category Fragment ");
                        break;

                    case R.id.navigation_Brands:
                        vibrateSense();
                        getSupportActionBar().setTitle("Brand");
                        selctedFragment = new BrandsFragment();
                        Log.d(TAG, "Show Brand Fragment ");
                        break;

                    case R.id.navigation_myaccount:
                        vibrateSense();
                        getSupportActionBar().setTitle("My Account");
                        selctedFragment = new MyAccountFragment();
                        Log.d(TAG, "Show My Account Fragment ");
                        break;

                    case R.id.navigation_mybag:
                        vibrateSense();
                        getSupportActionBar().setTitle("My Cart");
                        selctedFragment = new MyBagFragment();
                        Log.d(TAG, "Show My Cart Fragment ");
                        break;

                }

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selctedFragment).commit();
                return true;

            }
        });

    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnected();
    }

    public void mt(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        Log.d("tag", text);
    }

    public static void vibrate(Fragment fragment) {

        Vibrator vibrator = (Vibrator) fragment.getActivity().getSystemService(Context.VIBRATOR_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            vibrator.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            //deprecated in API 26
            vibrator.vibrate(50);
        }

    }

    void vibrateSense() {
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE));
        } else {
            //deprecated in API 26
            v.vibrate(50);
        }
    }
}