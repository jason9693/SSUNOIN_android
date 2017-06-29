package com.notisnow.anonimous.ssunoin.UI.NoticeDetail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.notisnow.anonimous.ssunoin.R;

public class NoticeDetailActivity extends AppCompatActivity implements NoticeDetailContract.View{
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_detail);

        NoticeDetailContract.Presenter presenter=new NoticeDetailPresenter(this);

    }

    @Override
    public void updateWebView(String url) {

    }

    @Override
    public void updateDownloadListView(String title, String url) {

    }
}
