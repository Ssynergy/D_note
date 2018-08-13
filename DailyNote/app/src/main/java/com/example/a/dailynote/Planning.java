package com.example.a.dailynote;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Planning extends AppCompatActivity {




    //DBhelper
    myDBHelper myHelper;
    EditText editone, edittwo, editthree, editfour, editfive, editsix, editseven, editeight, editnine, editten, editeleven, edittwelve, editthirteen,
            editfourteen, editfifteen, editsixteen, editseventeen, editeightteen, editnineteen, edittwenty, edittwentyone, edittwentytwo, edittwentythree,
            edittwentyfour;
   /* EditText edtone, edttwo, edtthree, edtfour, edtfive, edtsix, edtseven, edteight, edtnine, edtten, edteleven, edttwelve, edtthirteen,
            edtfourteen, edtfifteen, edtsixteen, edtseventeen, edteightteen, edtnineteen, edttwenty, edttwentyone, edttwentytwo, edttwentythree,
            edttwentyfour;*/
    Button btnAddData;
  /*  Button btnNext;*/
    SQLiteDatabase sqlDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planning);

        //db
        myHelper = new myDBHelper(this);

        editone = (EditText) findViewById(R.id.editText_one);
        edittwo = (EditText) findViewById(R.id.editText_two);
        editthree = (EditText) findViewById(R.id.editText_three);
        editfour = (EditText) findViewById(R.id.editText_four);
        editfive = (EditText) findViewById(R.id.editText_five);
        editsix = (EditText) findViewById(R.id.editText_six);
        editseven = (EditText) findViewById(R.id.editText_seven);
        editeight = (EditText) findViewById(R.id.editText_eight);
        editnine = (EditText) findViewById(R.id.editText_nine);
        editten = (EditText) findViewById(R.id.editText_ten);
        editeleven = (EditText) findViewById(R.id.editText_eleven);
        edittwelve = (EditText) findViewById(R.id.editText_twelve);
        editthirteen = (EditText) findViewById(R.id.editText_thirteen);
        editfourteen = (EditText) findViewById(R.id.editText_fourteen);
        editfifteen = (EditText) findViewById(R.id.editText_fifteen);
        editsixteen = (EditText) findViewById(R.id.editText_sixteen);
        editseventeen = (EditText) findViewById(R.id.editText_seventeen);
        editeightteen = (EditText) findViewById(R.id.editText_eighteen);
        editnineteen = (EditText) findViewById(R.id.editText_nineteen);
        edittwenty = (EditText) findViewById(R.id.editText_twenty);
        edittwentyone = (EditText) findViewById(R.id.editText_twentyone);
        edittwentytwo = (EditText) findViewById(R.id.editText_twentytwo);
        edittwentythree = (EditText) findViewById(R.id.editText_twentythree);
        edittwentyfour = (EditText) findViewById(R.id.editText_twentyfour);


        btnAddData = (Button) findViewById(R.id.btn_save);
       /* AddData();*/
        //다시보기

        btnAddData.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(), "저장되었습니다.", 1000).show();
                sqlDB = myHelper.getWritableDatabase();
                sqlDB.execSQL("INSERT INTO groupTBL VALUES ('"
                        + editone.getText().toString() + "' , '"
                        + edittwo.getText().toString() + "' , '"
                        + editthree.getText().toString() + "' , '"
                        + editfour.getText().toString() + "' , '"
                        + editfive.getText().toString() + "' , '"
                        + editsix.getText().toString() + "' , '"
                        + editseven.getText().toString() + "' , '"
                        + editeight.getText().toString() + "' , '"
                        + editnine.getText().toString() + "' , '"
                        + editten.getText().toString() + "' , '"
                        + editeleven.getText().toString() + "' , '"
                        + edittwelve.getText().toString() + "' , '"
                        + editthirteen.getText().toString() + "' , '"
                        + editfourteen.getText().toString() + "' ,'"
                        + editfifteen.getText().toString() + "' , '"
                        + editsixteen.getText().toString() + "' , '"
                        + editseventeen.getText().toString() + "' , '"
                        + editeightteen.getText().toString() + "' , '"
                        + editnineteen.getText().toString() + "' , '"
                        + edittwenty.getText().toString() + "' , '"
                        + edittwentyone.getText().toString() + "' , '"
                        + edittwentytwo.getText().toString() + "' , '"
                        + edittwentythree.getText().toString() + "' , "
                        + edittwentyfour.getText().toString() + ");");
                sqlDB.close();
                Toast.makeText(getApplicationContext(), "입력됨",
                        Toast.LENGTH_SHORT).show();


                Intent MyIntent = new Intent(Planning.this, MainActivity.class);
                startActivity(MyIntent);
            }
        });

    }


    //db method
    /*public void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myHelper.insertData
                                (editone.getText().toString(), edittwo.getText().toString(), editthree.getText().toString(),
                                        editfour.getText().toString(), editfive.getText().toString(), editsix.getText().toString(),
                                        editseven.getText().toString(), editeight.getText().toString(), editnine.getText().toString(),
                                        editten.getText().toString(), editeleven.getText().toString(), edittwelve.getText().toString(),
                                        editthirteen.getText().toString(), editfourteen.getText().toString(), editfifteen.getText().toString(),
                                        editsixteen.getText().toString(), editseventeen.getText().toString(), editeightteen.getText().toString(),
                                        editnineteen.getText().toString(), edittwenty.getText().toString(), edittwentyone.getText().toString(),
                                        edittwentytwo.getText().toString(), edittwentythree.getText().toString(), edittwentyfour.getText().toString()
                                );

                        if (isInserted = true)
                            Toast.makeText(Planning.this, "Data Inserted", Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Planning.this, "Data not Inserted", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }*/
    public class myDBHelper extends SQLiteOpenHelper {
        public myDBHelper(Context context) {
            super(context, "groupDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE  groupTBL ( gOne CHAR(50) , gTwo CHAR(50) ,gThree CHAR(50) " +
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




