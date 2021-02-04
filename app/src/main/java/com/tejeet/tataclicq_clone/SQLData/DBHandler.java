package com.tejeet.tataclicq_clone.SQLData;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 3;
    //Database Name
    private static final String DATABASE_NAME = "EngineeringProject";
    //You will declare all your table names here.


//---------------------------------------------------------------------------

    private static final String TABLE_NOTIFICATION = "notification";

    // Notification Table Columns names
    private static final String KEY_NID = "nid";
    private static final String KEY_NOTIFICATION_TITLE = "notificationTitle";
    private static final String KEY_NOTIFICATION_DESCRIPTIION = "notificationDescription";
    private static final String KEY_NOTIFICATION_TYPE = "notificationType";
    private static final String KEY_NOTIFICATION_STATUS = "notificationStatus";
    private static final String KEY_NOTIFICATION_TIME = "notificationTime";

    private final String CREATE_NOTIFICATION_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_NOTIFICATION + "("
            + KEY_NID + " INTEGER (100)  PRIMARY KEY, " + KEY_NOTIFICATION_TITLE + " TEXT,"
            + KEY_NOTIFICATION_DESCRIPTIION + " TEXT, " + KEY_NOTIFICATION_TYPE + " TEXT, "
            + KEY_NOTIFICATION_STATUS + " TEXT, " + KEY_NOTIFICATION_TIME + " TEXT" + ")";

    public DBHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
