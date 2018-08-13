package com.example.uuzaz.haningya;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PastSchedule extends AppCompatActivity {

    Button btnInit,btnS,btnU,btnC;
    EditText editDate;
    EditText editText_1, editText_2, editText_3, editText_4, editText_5, editText_6, editText_7, editText_8, editText_9, editText_10, editText_11, editText_12,
            editText_13, editText_14, editText_15, editText_16, editText_17, editText_18, editText_19, editText_20, editText_21, editText_22, editText_23, editText_24;

    Planning.myDBHelper myHelper;
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
        setContentView(R.layout.activity_past_schedule);

        myHelper = new Planning.myDBHelper(this);

        btnInit = (Button) findViewById(R.id.btnInit);
        btnS = (Button) findViewById(R.id.btnS);
        btnU = (Button) findViewById(R.id.btnU);
        btnC = (Button) findViewById(R.id.btnC);

        editDate = (EditText) findViewById(R.id.editDate);
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

        myHelper = new Planning.myDBHelper(this);
        btnInit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sqlDB = myHelper.getWritableDatabase();
                myHelper.onUpgrade(sqlDB, 1, 2); // 인수는 아무거나 입력하면 됨.
                sqlDB.close();
            }
        });

        btnS.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sqlDB = myHelper.getReadableDatabase();
                Cursor cursor;
                cursor = sqlDB.rawQuery("SELECT * FROM groupTBL Where date = '"+editDate.getText().toString()+"'", null);
                //date = '"+editDate.getText().toString()+"'
                //String editDateR = " ";
                String editTextRs_1 = " ";
                String editTextRs_2 = " ";
                String editTextRs_3 = " ";
                String editTextRs_4 = " ";
                String editTextRs_5 = " ";
                String editTextRs_6 = " ";
                String editTextRs_7 = " ";
                String editTextRs_8 = " ";
                String editTextRs_9 = " ";
                String editTextRs_10 = " ";
                String editTextRs_11 = " ";
                String editTextRs_12 = " ";
                String editTextRs_13 = " ";
                String editTextRs_14 = " ";
                String editTextRs_15 = " ";
                String editTextRs_16 = " ";
                String editTextRs_17 = " ";
                String editTextRs_18 = " ";
                String editTextRs_19 = " ";
                String editTextRs_20 = " ";
                String editTextRs_21 = " ";
                String editTextRs_22 = " ";
                String editTextRs_23 = " ";
                String editTextRs_24 = " ";


                while (cursor.moveToNext()) {
                   // editDateR = cursor.getString(1);
                    editTextRs_1 = cursor.getString(2);
                    editTextRs_2 = cursor.getString(3);
                    editTextRs_3 = cursor.getString(4);
                    editTextRs_4 = cursor.getString(5);
                    editTextRs_5 = cursor.getString(6);
                    editTextRs_6 = cursor.getString(7);
                    editTextRs_7 = cursor.getString(8);
                    editTextRs_8 = cursor.getString(9);
                    editTextRs_9 = cursor.getString(10);
                    editTextRs_10 = cursor.getString(11);
                    editTextRs_11 = cursor.getString(12);
                    editTextRs_12 = cursor.getString(13);
                    editTextRs_13 = cursor.getString(14);
                    editTextRs_14 = cursor.getString(15);
                    editTextRs_15 = cursor.getString(16);
                    editTextRs_16 = cursor.getString(17);
                    editTextRs_17 = cursor.getString(18);
                    editTextRs_18 = cursor.getString(19);
                    editTextRs_19 = cursor.getString(20);
                    editTextRs_20 = cursor.getString(21);
                    editTextRs_21 = cursor.getString(22);
                    editTextRs_22 = cursor.getString(23);
                    editTextRs_23 = cursor.getString(24);
                    editTextRs_24 = cursor.getString(25);

                }


                //editDate.setText(editDateR);
                editText_1.setText(editTextRs_1);
                editText_2.setText(editTextRs_2);
                editText_3.setText(editTextRs_3);
                editText_4.setText(editTextRs_4);
                editText_5.setText(editTextRs_5);
                editText_6.setText(editTextRs_6);
                editText_7.setText(editTextRs_7);
                editText_8.setText(editTextRs_8);
                editText_9.setText(editTextRs_9);
                editText_10.setText(editTextRs_10);
                editText_11.setText(editTextRs_11);
                editText_12.setText(editTextRs_12);
                editText_13.setText(editTextRs_13);
                editText_14.setText(editTextRs_14);
                editText_15.setText(editTextRs_15);
                editText_16.setText(editTextRs_16);
                editText_17.setText(editTextRs_17);
                editText_18.setText(editTextRs_18);
                editText_19.setText(editTextRs_19);
                editText_20.setText(editTextRs_20);
                editText_21.setText(editTextRs_21);
                editText_22.setText(editTextRs_22);
                editText_23.setText(editTextRs_23);
                editText_24.setText(editTextRs_24);


                cursor.close();
                sqlDB.close();
            }
        });


        btnU.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "저장되었습니다.", 1000).show();

                sqlDB = myHelper.getWritableDatabase();
                myHelper.onUpgrade(sqlDB, 1, 2); // 인수는 아무거나 입력하면 됨.



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
                Toast.makeText(getApplicationContext(), "수정됨",
                        Toast.LENGTH_SHORT).show();


            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "저장되었습니다.", 1000).show();
                sqlDB = myHelper.getWritableDatabase();


                Intent MyIntent = new Intent(PastSchedule.this, MainActivity.class);
                startActivity(MyIntent);
            }
        });
    }
}
