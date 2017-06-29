package com.notisnow.anonimous.ssunoin.UI.NoticeDetail;

import android.util.Log;

import com.notisnow.anonimous.ssunoin.Model.DownloadItem.DownloadItem;
import com.notisnow.anonimous.ssunoin.Network.DetailFetcher;

import org.jsoup.select.Elements;

/**
 * Created by yang-gichang on 2017. 6. 29..
 */

public class NoticeDetailPresenter implements NoticeDetailContract.Presenter {

    NoticeDetailContract.View view;
    public NoticeDetailPresenter(NoticeDetailContract.View v){
        this.view=v;
    }

    @Override
    public void startDownloadTask(String url) {

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
