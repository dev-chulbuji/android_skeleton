package com.example.ladmusiciankim.searchimage.presentation.ui;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.example.ladmusiciankim.searchimage.R;
import com.example.ladmusiciankim.searchimage.presentation.ui.base.BaseActivity;

public class MainActivity extends BaseActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private boolean isBackPressedOnce = false;
    private Handler timerHandler;

    @Override
    public int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initView() {

    }

    /**
     * 5초안에 백버튼 2번 클릭 시 앱 종료
     */
    @Override
    public void onBackPressed() {
        if (isBackPressedOnce) {
            super.onBackPressed();
        } else {
            Toast.makeText(this, getString(R.string.back_pressed), Toast.LENGTH_LONG).show();
            isBackPressedOnce = true;
            timerHandler.postDelayed(timerTask, 50000);
        }
    }

    private final Runnable timerTask = new Runnable() {
        @Override
        public void run() {
            isBackPressedOnce = false;
        }
    };
}
