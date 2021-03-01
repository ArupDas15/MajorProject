package com.main.project.smartshop;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;


public class SQLiteDemo extends SQLiteOpenHelper {

    public static String dbName = "user_info";
    public static int dbVersion = 1;
    public static String dbTable = "register";
    public static String dbUserName = "user_name";
    public static String dbUserEmail = "user_email";
    public static String dbUserPass = "user_pass";
    public static String dbUserPhone = "user_phone";
    public static String dbUserDob = "user_dob";
    public static String dbUserGender = "user_sex";


    public SQLiteDemo(Context context) {
        super(context, dbName, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTable = "create table " + dbTable + "(" +
                dbUserName + " TEXT," + dbUserEmail + " TEXT," +
                dbUserPass + " TEXT," + dbUserPhone + " TEXT," +
                dbUserDob + " TEXT," + dbUserGender + " TEXT )";

        db.execSQL(createTable);
        Log.d("table", "Table Created Successfully...");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + dbTable);

        /* Create tables again */
        onCreate(db);
    }

    public long regData(String name, String email, String pass, String phone, String dob, String gender) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cnv = new ContentValues();
        cnv.put(dbUserName, name);
        cnv.put(dbUserEmail, email);
        cnv.put(dbUserPass, pass);
        cnv.put(dbUserPhone, phone);
        cnv.put(dbUserDob, dob);
        cnv.put(dbUserGender, gender);

        final long insert = db.insert(dbTable, null, cnv);
        db.close();

        return insert;
    }

    public String getMobileNo(String email) {

        String phone = "";
        String qry = "select * from " + dbTable + " where user_email = '" + email + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(qry, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        do {
            phone = cursor.getString(3);
        }
        while (cursor.moveToNext());

        db.close();

        return phone;
    }


    public ArrayList<String[]> getData() {

        String qry = "select * from " + dbTable;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(qry, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        ArrayList<String[]> arr = new ArrayList<>();

        do {
            String name = cursor.getString(0);
            String email = cursor.getString(1);
            String pass = cursor.getString(2);
            String phone = cursor.getString(3);
            String dob = cursor.getString(4);
            String sex = cursor.getString(5);

            String[] details = {name, email, pass, phone, dob, sex};
            arr.add(details);
        }
        while (cursor.moveToNext());

        db.close();

        return arr;
    }

}
