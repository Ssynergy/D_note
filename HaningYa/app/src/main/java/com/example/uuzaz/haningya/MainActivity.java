package com.example.uuzaz.haningya;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //오늘 날짜 계산후 표시
    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd");
    TextView mTextView;
    ImageButton btn_menu;
    /**drawer button**/
    Button btn_Lookback, button_viewALL;

    //db
    TextView editTextR_1, editTextR_2, editTextR_3, editTextR_4, editTextR_5, editTextR_6, editTextR_7, editTextR_8, editTextR_9, editTextR_10, editTextR_11, editTextR_12,
            editTextR_13, editTextR_14, editTextR_15, editTextR_16, editTextR_17, editTextR_18, editTextR_19, editTextR_20, editTextR_21, editTextR_22, editTextR_23, editTextR_24;

    Planning.myDBHelper myHelper;
    SQLiteDatabase sqlDB;




    /** drawer **/
    private String TAG = "MainActivity";
    private Context mContext = MainActivity.this;
    private ViewGroup mainLayout;   //사이드 나왔을때 클릭방지할 영역
    private ViewGroup viewLayout;   //전체 감싸는 영역
    private ViewGroup sideLayout;   //사이드바만 감싸는 영역
    private Boolean isMenuShow = false;
    private Boolean isExitFlag = false;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            onBackPressed();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        if (isMenuShow) {
            closeMenu();
        } else {
            if (isExitFlag) {
                finish();
            } else {
                isExitFlag = true;
                Toast.makeText(this, "뒤로가기를 한번더 누르시면 앱이 종료안될껄요.", Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        isExitFlag = false;
                    }
                }, 2000);
            }
        }
    }
    /** end of drawer **/
  

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**bind view 날짜 나타내기**/
        mTextView = (TextView) findViewById(R.id.today_date);
        mTextView.setText(getTime());
        init();
        addSideView();  //사이드바 add
        /**drawer**/
        /*btn_Lookback = (Button) findViewById(R.id.btn_lookback);*/
        button_viewALL = (Button) findViewById(R.id.button_viewAll);
        /**일주일보기 intent**/
        /*btn_Lookback = (Button) findViewById(R.id.btn_lookback);
        btn_Lookback.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "일주일 돌아보기", 1000).show();
                Intent MyIntent = new Intent(MainActivity.this, Look_Back.class);
                startActivity(MyIntent);
            }
        });*/
        /**과거일정 intent**/
        button_viewALL.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("WrongConstant")
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "일주일 돌아보기", 1000).show();
                Intent MyIntent = new Intent(MainActivity.this, PastSchedule.class);
                startActivity(MyIntent);
            }
        });

        //db
        myHelper = new Planning.myDBHelper(this);


        editTextR_1 = (TextView) findViewById(R.id.editTextR_1);
        editTextR_2 = (TextView) findViewById(R.id.editTextR_2);
        editTextR_3 = (TextView) findViewById(R.id.editTextR_3);
        editTextR_4 = (TextView) findViewById(R.id.editTextR_4);
        editTextR_5 = (TextView) findViewById(R.id.editTextR_5);
        editTextR_6 = (TextView) findViewById(R.id.editTextR_6);
        editTextR_7 = (TextView) findViewById(R.id.editTextR_7);
        editTextR_8 = (TextView) findViewById(R.id.editTextR_8);
        editTextR_9 = (TextView) findViewById(R.id.editTextR_9);
        editTextR_10 = (TextView) findViewById(R.id.editTextR_10);
        editTextR_11 = (TextView) findViewById(R.id.editTextR_11);
        editTextR_12 = (TextView) findViewById(R.id.editTextR_12);
        editTextR_13 = (TextView) findViewById(R.id.editTextR_13);
        editTextR_14 = (TextView) findViewById(R.id.editTextR_14);
        editTextR_15 = (TextView) findViewById(R.id.editTextR_15);
        editTextR_16 = (TextView) findViewById(R.id.editTextR_16);
        editTextR_17 = (TextView) findViewById(R.id.editTextR_17);
        editTextR_18 = (TextView) findViewById(R.id.editTextR_18);
        editTextR_19 = (TextView) findViewById(R.id.editTextR_19);
        editTextR_20 = (TextView) findViewById(R.id.editTextR_20);
        editTextR_21 = (TextView) findViewById(R.id.editTextR_21);
        editTextR_22 = (TextView) findViewById(R.id.editTextR_22);
        editTextR_23 = (TextView) findViewById(R.id.editTextR_23);
        editTextR_24 = (TextView) findViewById(R.id.editTextR_24);


        sqlDB = myHelper.getReadableDatabase();
        Cursor cursor;
        cursor = sqlDB.rawQuery("SELECT * FROM groupTBL;", null);

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



        editTextR_1.setText(editTextRs_1);
        editTextR_2.setText(editTextRs_2);
        editTextR_3.setText(editTextRs_3);
        editTextR_4.setText(editTextRs_4);
        editTextR_5.setText(editTextRs_5);
        editTextR_6.setText(editTextRs_6);
        editTextR_7.setText(editTextRs_7);
        editTextR_8.setText(editTextRs_8);
        editTextR_9.setText(editTextRs_9);
        editTextR_10.setText(editTextRs_10);
        editTextR_11.setText(editTextRs_11);
        editTextR_12.setText(editTextRs_12);
        editTextR_13.setText(editTextRs_13);
        editTextR_14.setText(editTextRs_14);
        editTextR_15.setText(editTextRs_15);
        editTextR_16.setText(editTextRs_16);
        editTextR_17.setText(editTextRs_17);
        editTextR_18.setText(editTextRs_18);
        editTextR_19.setText(editTextRs_19);
        editTextR_20.setText(editTextRs_20);
        editTextR_21.setText(editTextRs_21);
        editTextR_22.setText(editTextRs_22);
        editTextR_23.setText(editTextRs_23);
        editTextR_24.setText(editTextRs_24);


        cursor.close();
        sqlDB.close();



    } /** end of onCreate**/


    /**오늘 날짜 계산후 표시**/
    private String getTime() {
        mNow = System.currentTimeMillis();
        mDate = new Date(mNow);
        return mFormat.format(mDate);
    }

    /** drawer **/
    private void init() {
        findViewById(R.id.btn_menu).setOnClickListener(this);
        mainLayout = findViewById(R.id.id_main);
        viewLayout = findViewById(R.id.fl_silde);
        sideLayout = findViewById(R.id.view_sildebar);
    }
    private void addSideView() {
        SideBarView sidebar = new SideBarView(mContext);
        sideLayout.addView(sidebar);
        viewLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        sidebar.setEventListener(new SideBarView.EventListener() {
            @Override
            public void btnCancel() {
                Log.e(TAG, "btnCancel");
                closeMenu();
            }
        });
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_menu:
                showMenu();
                break;
        }
    }
    public void closeMenu() {
        isMenuShow = false;
        Animation slide = AnimationUtils.loadAnimation(mContext, R.anim.sidebar_hidden);
        sideLayout.startAnimation(slide);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                viewLayout.setVisibility(View.GONE);
                viewLayout.setEnabled(false);
                mainLayout.setEnabled(true);
            }
        }, 450);
    }

    public void showMenu() {
        isMenuShow = true;
        Animation slide = AnimationUtils.loadAnimation(this, R.anim.sidebar_show);
        sideLayout.startAnimation(slide);
        viewLayout.setVisibility(View.VISIBLE);
        viewLayout.setEnabled(true);
        mainLayout.setEnabled(false);
        Log.e(TAG, "메뉴버튼 클릭");
    }
    /** end of drawer **/

}
/**MainActivity Bracket**/


