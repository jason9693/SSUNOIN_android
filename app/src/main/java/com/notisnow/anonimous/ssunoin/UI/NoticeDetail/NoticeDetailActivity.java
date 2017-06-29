package com.notisnow.anonimous.ssunoin.UI.NoticeDetail;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

    RecyclerView downloadListView;
    RecyclerView.Adapter adapter;
    ArrayList<DownloadItem> items=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice_detail);

        Intent receiveIntent=getIntent();


        NoticeDetailContract.Presenter presenter=new NoticeDetailPresenter(this);

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
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.loadDataWithBaseURL(null, url, "text/html", "utf-8", null);
    }

    @Override
    public void updateDownloadListView(DownloadItem item) {
        items.add(item);
        //adapter.notifyDataSetChanged();
    }

    class FileListHolder extends RecyclerView.ViewHolder{
        TextView fileName;
        String downloadLink;

        public FileListHolder(View itemView) {
            super(itemView);
            fileName=(TextView)itemView.findViewById(R.id.fileName);
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
