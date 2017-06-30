package com.notisnow.anonimous.ssunoin.UI.NoticeDetail;

import android.Manifest;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;

import com.notisnow.anonimous.ssunoin.Model.DownloadItem.DownloadItem;
import com.notisnow.anonimous.ssunoin.R;

import java.util.ArrayList;

public class NoticeDetailActivity extends AppCompatActivity implements NoticeDetailContract.View{
    WebView webView;
    TextView title;
    TextView date;
    TextView countAttatch;
    DownloadManager mDownloadManager;

    RecyclerView downloadListView;
    RecyclerView.Adapter adapter;
    ArrayList<DownloadItem> items=new ArrayList<>();
    NoticeDetailContract.Presenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_detail);

        Intent receiveIntent=getIntent();

        mDownloadManager=(DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
        presenter=new NoticeDetailPresenter(this);

        String receiveUrl=receiveIntent.getStringExtra("url");
        webView=(WebView)findViewById(R.id.webview);

        String receiveTitle=receiveIntent.getStringExtra("title");
        title=(TextView)findViewById(R.id.title);
        title.setText(receiveTitle);

        String receiveDate=receiveIntent.getStringExtra("date");
        date=(TextView)findViewById(R.id.date);
        date.setText(receiveDate);

        countAttatch=(TextView)findViewById(R.id.textAttach);


        downloadListView=(RecyclerView)findViewById(R.id.recyclerView);
        downloadListView.setLayoutManager(new LinearLayoutManager(this));


        presenter.Connection(receiveUrl);
    }

    @Override
    public void refreshAdapter() {

        if(items.size()==0){
            countAttatch.setText("첨부파일 없음");
            downloadListView.setVisibility(View.GONE);
        }
        else countAttatch.setText("첨부파일"+items.size()+"개");
        adapter=new FileListAdapter();
        downloadListView.setAdapter(adapter);
    }

    @Override
    public void updateWebView(String url) {
        //url=url.replaceAll("src=\"","src=\"www.ssu.ac.kr");

        Log.d("최종url",url);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setAllowContentAccess(true);
        //webView.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        webView.getSettings().setJavaScriptEnabled(true);
        //webView.setWebViewClient(new WebViewClient());
      //  webView.loadDataWithBaseURL(null, url, "text/html", "utf-8", null);
        webView.loadDataWithBaseURL("http://www.ssu.ac.kr",url,"text/html","utf-8",null);
    }

    @Override
    public void updateDownloadListView(DownloadItem item) {
        items.add(item);
        //adapter.notifyDataSetChanged();
    }

    @Override
    public void showDownload(DownloadManager.Request request) {
        mDownloadManager.enqueue(request);
    }

    class FileListHolder extends RecyclerView.ViewHolder{
        TextView fileName;
        String downloadLink;

        public FileListHolder(View itemView) {
            super(itemView);
            fileName=(TextView)itemView.findViewById(R.id.fileName);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    try {
                        presenter.startDownloadTask(downloadLink, fileName.getText().toString());
                        Log.d("downloadClicked","execute");
                    }catch (Exception e){
                        if(ContextCompat.checkSelfPermission(NoticeDetailActivity.this,
                                Manifest.permission.WRITE_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
                            if(ActivityCompat.shouldShowRequestPermissionRationale(NoticeDetailActivity.this,Manifest.permission.WRITE_EXTERNAL_STORAGE)){
                                ActivityCompat.requestPermissions(NoticeDetailActivity.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                        110);
                            }else {
                                ActivityCompat.requestPermissions(NoticeDetailActivity.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE},
                                        110);
                            }
                        }
                    }
                }
            });
        }
    }
    class FileListAdapter extends RecyclerView.Adapter<FileListHolder>{

        @Override
        public FileListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.download_file_item,parent,false);
            FileListHolder fileListHolder=new FileListHolder(v);

            return fileListHolder;
        }

        @Override
        public void onBindViewHolder(FileListHolder holder, int position) {
            holder.fileName.setText(items.get(position).getTitle());
            holder.downloadLink=items.get(position).getDownloadUrl();
        }

        @Override
        public int getItemCount() {
            return items.size();
        }
    }
}
