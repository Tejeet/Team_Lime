package com.tejeet.tataclicq_clone.SQLData;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.tejeet.tataclicq_clone.DataNModels.MyCartModel;
import com.tejeet.tataclicq_clone.DataNModels.ProductDetailsDTO;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {

    private static final String TAG = "tag";

    private static final int DATABASE_VERSION = 1;
    //Database Name
    private static final String DATABASE_NAME = "tataClickDatabase";
    //You will declare all your table names here.

//---------------------------------------------------------------------------

    private static final String TABLE_MY_CART = "mycart";


    // Notification Table Columns names
    private static final String KEY_CID = "cid";
    private static final String KEY_BRAND_NAME = "brandName";
    private static final String KEY_NAME = "productName";
    private static final String KEY_PRICE = "productPrice";
    private static final String KEY_DESCRIPTION = "productDescripton";
    private static final String KEY_FILE_URL = "productFileURL";

    private final String CREATE_MYCART_TABLE = "CREATE TABLE IF NOT EXISTS " + TABLE_MY_CART + "("
            + KEY_CID + " INTEGER (100)  PRIMARY KEY, " + KEY_BRAND_NAME + " TEXT,"
            + KEY_NAME + " TEXT, " + KEY_PRICE + " TEXT, "
            + KEY_DESCRIPTION + " TEXT, " + KEY_FILE_URL + " TEXT" + ")";

    public DBHandler(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d(TAG, "On Db Handler");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_MYCART_TABLE);
        Log.d(TAG, "On Database Create");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        Log.d(TAG, "Database Updates");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MY_CART);
        onCreate(db);
    }


    ///  ---------------------------------------------------------------------------------------


    // add Diet Plan
    public void addtoCart(MyCartModel data) {
        SQLiteDatabase db = this.getWritableDatabase();


        ContentValues values = new ContentValues();
        values.put(KEY_CID, data.getCid());
        values.put(KEY_BRAND_NAME, data.getBrandName() );
        values.put(KEY_NAME, data.getProductName() );
        values.put(KEY_PRICE, data.getPrice());
        values.put(KEY_DESCRIPTION, data.getDescription());
        values.put(KEY_FILE_URL, data.getFileUrl());

        db.insert(TABLE_MY_CART, null, values);
        db.close();

        Log.d(TAG, "Adding product to Cart ");
    }

    // Getting All Diet Plans
    public List<MyCartModel> getmycartItems() {
        List<MyCartModel> mycartData = new ArrayList<MyCartModel>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_MY_CART ;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // Looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                MyCartModel data = new MyCartModel(
                        cursor.getString(0),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3),
                        cursor.getString(4),
                        cursor.getString(5)

                );

                mycartData.add(data);
            } while (cursor.moveToNext());
        }

        return mycartData;
    }


    // delete single DietPlan
    public void delteItemFromCart(String cartid) {

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_MY_CART, KEY_CID + " = ?",
                new String[] { cartid });
        Log.d("tag","Deleting ID "+cartid);
        db.close();
    }

    public String getCartTotal() {

        String Amount;

        String selectQuery = "SELECT SUM("+KEY_PRICE+") as grandTotal  FROM " + TABLE_MY_CART;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            Amount = String.valueOf(cursor.getInt(0));
        }

        else{
            Amount = "0";
        }

        Log.d(TAG, "Cart Total Is  "+ Amount);


        db.close();
        return Amount;
    }

    // delete all My Cart record
    public void deleteWholeCart() {

        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_MY_CART, null, null);
        db.close();

    }





}
