package com.example.administrator.chunhui.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.chunhui.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Project_DetailsActivity extends AppCompatActivity {


    @BindView(R.id.project_web)
    WebView projectWeb;
    @BindView(R.id.ic_arrow_back)
    ImageView icArrowBack;
    @BindView(R.id.details_title)
    TextView detailsTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project__details);

        ButterKnife.bind(this);
        Intent intent = getIntent();
        String link = intent.getStringExtra("link");
        String title = intent.getStringExtra("title");
        detailsTitle.setText(title);
        projectWeb.setWebViewClient(new WebViewClient());
        projectWeb.loadUrl(link);
    }

    @OnClick(R.id.ic_arrow_back)
    public void onViewClicked() {
        finish();
    }
}
