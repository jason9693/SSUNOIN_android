package com.notisnow.anonimous.ssunoin.UI.NoticeDetail;

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
    }
    interface Presenter{
        void startDownloadTask(String url);
        void Connection(String url);
        void UpdateView(Elements downloadList, String ur);
    }
}
