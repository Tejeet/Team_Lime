package com.tejeet.tataclicq_clone.DataNModels;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefData {

    public static final String SERVER = "https://teamlime.tejeet.com/";
    public static final String HOST = "https://teamlime.tejeet.com/api.php?";


    SharedPreferences sharedpreferences;
    private static final String MY_PREF = "My_TATA_Cliq_PREF";

    private static final String LOGIN_STATUS_KEY = "LoginStatus";

    private static final String USER_NAME_KEY = "usernamekey";
    private static final String USER_EMAIL_KEY = "useremailkey";
    private static final String USER_PASS_KEY = "userpasskey";
    private static final String USER_MOBILE_KEY = "mobileKey";




    public String getLoginStatus(Context context){
        sharedpreferences = context.getSharedPreferences(MY_PREF, Context.MODE_PRIVATE);
        return sharedpreferences.getString(LOGIN_STATUS_KEY, "0");
    }

    public void setLoginStatus(Context context, String loginStatus) {
        sharedpreferences = context.getSharedPreferences(MY_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(LOGIN_STATUS_KEY, loginStatus);
        editor.commit();
    }


    public String getName(Context context){
        sharedpreferences = context.getSharedPreferences(MY_PREF, Context.MODE_PRIVATE);
        return sharedpreferences.getString(USER_NAME_KEY, "0");
    }

    public String getMobile(Context context){
        sharedpreferences = context.getSharedPreferences(MY_PREF, Context.MODE_PRIVATE);
        return sharedpreferences.getString(USER_MOBILE_KEY, "0");
    }

    public String getEmail(Context context){
        sharedpreferences = context.getSharedPreferences(MY_PREF, Context.MODE_PRIVATE);
        return sharedpreferences.getString(USER_EMAIL_KEY, "0");
    }


    public void SaveProfile(Context context, String pname, String pemail, String pmobile) {
        sharedpreferences = context.getSharedPreferences(MY_PREF, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(USER_NAME_KEY, pname);
        editor.putString(USER_EMAIL_KEY, pemail);
        editor.putString(USER_MOBILE_KEY, pmobile);

        editor.commit();
    }






}
