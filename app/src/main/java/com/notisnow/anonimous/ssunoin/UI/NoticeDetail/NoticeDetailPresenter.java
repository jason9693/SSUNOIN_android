package com.notisnow.anonimous.ssunoin.UI.NoticeDetail;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import com.notisnow.anonimous.ssunoin.Model.DownloadItem.DownloadItem;
import com.notisnow.anonimous.ssunoin.Network.DetailFetcher;

import org.jsoup.select.Elements;

/**
 * Created by yang-gichang on 2017. 6. 29..
 */

public class NoticeDetailPresenter implements NoticeDetailContract.Presenter {

    NoticeDetailContract.View view;

    DownloadManager mDownloadManager;
    public NoticeDetailPresenter(NoticeDetailContract.View v){
        this.view=v;
        mDownloadManager=(DownloadManager)v.getSystemService(Context.DOWNLOAD_SERVICE);
    }


    @Override
    public void startDownloadTask(String url,String title) {
        Uri uriToDownload=Uri.parse(url);
        DownloadManager.Request mRequest = new DownloadManager.Request(uriToDownload);
        mRequest.setTitle(title);
        mRequest.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        mRequest.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, title);
        Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).mkdirs();

        //view.showDownload(mRequest);
        mDownloadManager.enqueue(mRequest);
    }

    @Override
    public void Connection(String url) {
        DetailFetcher fetcher=new DetailFetcher(this,url);
        fetcher.fetch();
    }

    @Override
    public void UpdateView(Elements downloadList,String url){
        view.updateWebView(url);

        for(int i=0;i<downloadList.size();i++){
            DownloadItem item=new DownloadItem();
            Log.d("item"+i,downloadList.get(i).toString());
            item.setDownloadUrl(downloadList.get(i).attr("href"));
            item.setTitle(downloadList.get(i).text());
            view.updateDownloadListView(item);
        }

        view.refreshAdapter();

    }
}
