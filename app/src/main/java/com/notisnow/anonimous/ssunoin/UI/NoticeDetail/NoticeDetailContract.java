package com.notisnow.anonimous.ssunoin.UI.NoticeDetail;

import org.jsoup.select.Elements;

/**
 * Created by yang-gichang on 2017. 6. 29..
 */

public interface NoticeDetailContract {
    interface View{
        void updateWebView(String url);
        void updateDownloadListView(String title,String url);
    }
    interface Presenter{
        void startDownloadTask(String url);
        void Connection(String url);
        void UpdateView(Elements downloadList, String url);
    }
}
