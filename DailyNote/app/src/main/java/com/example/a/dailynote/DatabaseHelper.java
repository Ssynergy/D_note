package com.example.a.dailynote;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.SQLData;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "student.db";
    public static final String TABLE_NAME = "student_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "one";
    public static final String COL_3 = "two";
    public static final String COL_4 = "three";
    public static final String COL_5 = "four";
    public static final String COL_6 = "five";
    public static final String COL_7 = "six";
    public static final String COL_8 = "seven";
    public static final String COL_9 = "eight";
    public static final String COL_10 = "nine";
    public static final String COL_11 = "ten";
    public static final String COL_12 = "eleven";
    public static final String COL_13 = "twelve";
    public static final String COL_14= "thirteen";
    public static final String COL_15= "fourteen";
    public static final String COL_16= "fifteen";
    public static final String COL_17= "sixteen";
    public static final String COL_18= "seventeen";
    public static final String COL_19= "eighteen";
    public static final String COL_20= "nineteen";
    public static final String COL_21= "twenty";
    public static final String COL_22= "twentyone";
    public static final String COL_23= "twentytwo";
    public static final String COL_24= "twentythree";
    public static final String COL_25= "twentyfour";


    //constructor called, database will be created
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    //create table when oncreate called
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "NAME TEXT, SUBNAME TEXT, MARKS INTEGER)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String one, String two, String three, String four,String five ,String six, String seven, String eight, String nine, String ten
    ,String eleven ,String twelve,String thirteen, String fourteen, String fifteen, String sixteen, String seventeen, String eighteen, String nineteen, String twenty
    ,String twentyone, String twentytwo, String twentythree, String twentyfour) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, one);
        contentValues.put(COL_3, two);
        contentValues.put(COL_4, three);
        contentValues.put(COL_5, four);
        contentValues.put(COL_6, five);
        contentValues.put(COL_7, six);
        contentValues.put(COL_8, seven);
        contentValues.put(COL_9, eight);
        contentValues.put(COL_10, nine);
        contentValues.put(COL_11, ten);
        contentValues.put(COL_12, eleven);
        contentValues.put(COL_13, twelve);
        contentValues.put(COL_14, thirteen);
        contentValues.put(COL_15, fourteen);
        contentValues.put(COL_16, fifteen);
        contentValues.put(COL_17, sixteen);
        contentValues.put(COL_18, seventeen);
        contentValues.put(COL_19, eighteen);
        contentValues.put(COL_20, nineteen);
        contentValues.put(COL_21, twenty);
        contentValues.put(COL_22, twentyone);
        contentValues.put(COL_23, twentytwo);
        contentValues.put(COL_24, twentythree);
        contentValues.put(COL_25, twentyfour);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from " + TABLE_NAME, null);
        return res;
    }
}
