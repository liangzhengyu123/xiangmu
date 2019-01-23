package com.example.administrator.chunhui.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.administrator.chunhui.R;
import com.example.frame.tools.StatusBarManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.btn_down)
    Button btnDown;
    private Unbinder mBind;
    private int i =4;
    private boolean mFage=true;
    private Thread mThread;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mBind = ButterKnife.bind(this);
        StatusBarManager.setStatusBarColor(this,R.color.splash_blue);
        countDown();
    }

    private void countDown() {

        mThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(mFage){
                    try {
                        Thread.sleep(1000);
                        mHandler.sendEmptyMessage(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        mThread.start();
    }


    MyHandler mHandler = new MyHandler();
    class MyHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            int what = msg.what;
            if(what==1){
                i--;
                if(i>0){
                    btnDown.setText(i+"");
                }else {
                    mFage=false;
                    mThread.interrupt();
                    startActivity(new Intent(SplashActivity.this,HomeActivity.class));
                }
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBind.unbind();
    }
}
