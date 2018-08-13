package com.example.uuzaz.haningya;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.EventListener;

public class SideBarView extends LinearLayout implements View.OnClickListener {
    public EventListener listener;

    public void setEventListener(EventListener I) {
        listener = I;
    }

    /**
     * 메뉴버튼 클릭 이벤트 리스너 인터페이스
     */
    public interface EventListener {
        // 닫기 버튼 클릭 이벤트
        void btnCancel();


    }
    public SideBarView(Context context) {
        this(context, null);
        init();
    }
    public SideBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.side_menu, this, true);
        findViewById(R.id.btn_cancel).setOnClickListener(this);

    }
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_cancel:
                listener.btnCancel();
                break;

            default:
                break;
        }
    }
}

