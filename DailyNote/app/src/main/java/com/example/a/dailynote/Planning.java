package com.example.a.dailynote;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Planning extends AppCompatActivity {

    Button btnInsert;
    EditText editText_1, editText_2, editText_3, editText_4, editText_5, editText_6, editText_7, editText_8, editText_9, editText_10, editText_11, editText_12,
            editText_13, editText_14, editText_15, editText_16, editText_17, editText_18, editText_19, editText_20, editText_21, editText_22, editText_23, editText_24;

    myDBHelper myHelper;
    SQLiteDatabase sqlDB;
    //오늘 날짜 계산후 표시
    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd");


    //오늘 날짜 계산후 표시
    private String getTime() {
        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);
        return mFormat.format(mDate);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);

        //db
        myHelper = new myDBHelper(this);
        btnInsert = (Button) findViewById(R.id.btn_insert);

        editText_1 = (EditText) findViewById(R.id.editText_1);
        editText_2 = (EditText) findViewById(R.id.editText_2);
        editText_3 = (EditText) findViewById(R.id.editText_3);
        editText_4 = (EditText) findViewById(R.id.editText_4);
        editText_5 = (EditText) findViewById(R.id.editText_5);
        editText_6 = (EditText) findViewById(R.id.editText_6);
        editText_7 = (EditText) findViewById(R.id.editText_7);
        editText_8 = (EditText) findViewById(R.id.editText_8);
        editText_9 = (EditText) findViewById(R.id.editText_9);
        editText_10 = (EditText) findViewById(R.id.editText_10);
        editText_11 = (EditText) findViewById(R.id.editText_11);
        editText_12 = (EditText) findViewById(R.id.editText_12);
        editText_13 = (EditText) findViewById(R.id.editText_13);
        editText_14 = (EditText) findViewById(R.id.editText_14);
        editText_15 = (EditText) findViewById(R.id.editText_15);
        editText_16 = (EditText) findViewById(R.id.editText_16);
        editText_17 = (EditText) findViewById(R.id.editText_17);
        editText_18 = (EditText) findViewById(R.id.editText_18);
        editText_19 = (EditText) findViewById(R.id.editText_19);
        editText_20 = (EditText) findViewById(R.id.editText_20);
        editText_21 = (EditText) findViewById(R.id.editText_21);
        editText_22 = (EditText) findViewById(R.id.editText_22);
        editText_23 = (EditText) findViewById(R.id.editText_23);
        editText_24 = (EditText) findViewById(R.id.editText_24);


        btnInsert.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "저장되었습니다.", 1000).show();
                sqlDB = myHelper.getWritableDatabase();
                sqlDB.execSQL("INSERT INTO groupTBL VALUES (null,'"
                        + getTime() + "' , '"
                        + editText_1.getText().toString() + "' , '"
                        + editText_2.getText().toString() + "' , '"
                        + editText_3.getText().toString() + "' , '"
                        + editText_4.getText().toString() + "' , '"
                        + editText_5.getText().toString() + "' , '"
                        + editText_6.getText().toString() + "' , '"
                        + editText_7.getText().toString() + "' , '"
                        + editText_8.getText().toString() + "' , '"
                        + editText_9.getText().toString() + "' , '"
                        + editText_10.getText().toString() + "' , '"
                        + editText_11.getText().toString() + "' , '"
                        + editText_12.getText().toString() + "' , '"
                        + editText_13.getText().toString() + "' , '"
                        + editText_14.getText().toString() + "' , '"
                        + editText_15.getText().toString() + "' , '"
                        + editText_16.getText().toString() + "' , '"
                        + editText_17.getText().toString() + "' , '"
                        + editText_18.getText().toString() + "' , '"
                        + editText_19.getText().toString() + "' , '"
                        + editText_20.getText().toString() + "' , '"
                        + editText_21.getText().toString() + "' , '"
                        + editText_22.getText().toString() + "' , '"
                        + editText_23.getText().toString() + "' , '"
                        + editText_24.getText().toString() + "');");
                sqlDB.close();
                Toast.makeText(getApplicationContext(), "입력됨",
                        Toast.LENGTH_SHORT).show();


                Intent MyIntent = new Intent(Planning.this, MainActivity.class);
                startActivity(MyIntent);
            }
        });


    }/**end of oncreate **/

    public static class myDBHelper extends SQLiteOpenHelper {
        public myDBHelper(Context context) {
            super(context, "groupDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE  groupTBL ( _id INTEGER PRIMARY KEY AUTOINCREMENT ,date DATETIME, gOne CHAR(50) , gTwo CHAR(50) ,gThree CHAR(50) " +
                    ", gFour CHAR(50) , gFive CHAR(50) , gSix CHAR(50) , gSeven CHAR(50) , gEight CHAR(50)" +
                    " ,gNine CHAR(50) , gTen CHAR(50) ,gElven CHAR(50) ,gTwelve CHAR(50), gThirte CHAR(50) " +
                    ",gFourte CHAR(50) , gFifte CHAR(50) , gSixte CHAR(50), gSevente CHAR(50), gEighte CHAR(50) " +
                    ",gNineTe CHAR(50) , gThenty CHAR(50), gTwentyone CHAR(50) ,gTwentytwo CHAR(50) , gTwentythree CHAR(50)" +
                    ",gTwentyfour CHAR(50));");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS groupTBL");
            onCreate(db);
        }
    }



}

