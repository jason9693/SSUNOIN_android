package com.notisnow.anonimous.ssunoin.UI.NoticeDetail;

import android.app.DownloadManager;
import android.content.Context;

import com.notisnow.anonimous.ssunoin.Model.DownloadItem.DownloadItem;

import org.jsoup.select.Elements;

/**
 * Created by yang-gichang on 2017. 6. 29..
 */
public interface NoticeDetailContract {
    interface View{
        void refreshAdapter();
        void updateWebView(String url);
        void updateDownloadListView(DownloadItem item);
        void showDownload(DownloadManager.Request request);
        Object getSystemService(String name);
    }
    interface Presenter{
        void startDownloadTask(String url,String title);
        void Connection(String url);
        void UpdateView(Elements downloadList, String ur);
       // void setDownloadAccessInit(Context context);
    }
}
