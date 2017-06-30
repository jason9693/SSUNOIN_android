package com.notisnow.anonimous.ssunoin.UI.Main.NoticeByMajor;

import com.notisnow.anonimous.ssunoin.Network.NoticeFetcher;

/**
 * Created by yang-gichang on 2017. 6. 28..
 */

public class NoticeByMajorPresenter implements NoticeByMajorContract.Presenter{
    NoticeByMajorContract.View v;
    public NoticeByMajorPresenter(NoticeByMajorContract.View v){
        this.v=v;
    }
    @Override
    public void setView(NoticeByMajorContract.View v) {
        this.v=v;
    }

    @Override
    public void initLoad(int position, NoticeByMajorContract.View v) {
        NoticeFetcher fetcher = new NoticeFetcher(position);
        //fetcher.initFetch(position,v);
    }


}
