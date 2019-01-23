package com.example.administrator.chunhui.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.chunhui.R;

public class HomeDetailActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView black;
    private TextView detailtitle;
    private WebView web;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_detail);
        initView();
    }

    private void initView() {
        //接受数据
        Intent intent = getIntent();
        String bbb = intent.getStringExtra("bbb");
        String ccc = intent.getStringExtra("ccc");
        //id
        black = (ImageView) findViewById(R.id.black);
        //点击事件
        black.setOnClickListener(this);
        detailtitle = (TextView) findViewById(R.id.detailtitle);
        web = (WebView) findViewById(R.id.web);
        //设置给界面
        detailtitle.setText(bbb);
        web.loadUrl(ccc);
        web.getSettings().setJavaScriptEnabled(true);
        web.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.black:
                //返回
                finish();
                break;
        }
    }
}
