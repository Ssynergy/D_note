package com.example.a.dailynote;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;

public class ItemView  extends FrameLayout {
    public  ItemView(Context context) {
        super(context);
        init();
    }
    public ItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    TextView TView;
    EditText EView;
    //View View1, View2;
    CheckBox checkBox;

    //리스너
  /*  public interface OnCheckClickListener {
        public void onCheckClick(View view, ItemData itemData, int position);
    }

    OnCheckClickListener mListener;
    public void setOnCheckClickListener(OnCheckClickListener listener) {
        mListener = listener;
    }*/







    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.listitem, this);
        TView = (TextView)findViewById(R.id.dataItem01);
        EView = (EditText)findViewById(R.id.dataItem_);
        // View1 = (View)findViewById(R.id.dataItem03);
        checkBox = (CheckBox) findViewById(R.id.chb);


    }

    ItemData mData;
    public void setItemData(ItemData data) {
        mData = data;
        TView.setText(data.time);
        EView.setText(data.desc);

    }

   /* boolean isChecked = false;

    @Override
    public void setChecked(boolean checked) {
        if (isChecked != checked) {
            isChecked = checked;
            drawCheck();
        }
    }

    private void drawCheck() {
        if (isChecked) {
            drawCheck();
        } else {

        }
    }

    @Override
    public boolean isChecked() {
        return isChecked();
    }

    @Override
    public void  toggle() {
        setChecked(!isChecked);
    }*/
}
