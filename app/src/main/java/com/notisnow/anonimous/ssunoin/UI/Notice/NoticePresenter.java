package com.notisnow.anonimous.ssunoin.UI.Notice;

import com.notisnow.anonimous.ssunoin.Model.Notice.NoticeObj;
import com.notisnow.anonimous.ssunoin.Network.NoticeFetcher;

import java.util.ArrayList;

/**
 * Created by yang-gichang on 2017. 6. 28..
 */

public class NoticePresenter implements NoticeContract.Presenter{
    private NoticeContract.View view;
    NoticeFetcher noiticeFetcher;
    int id=0;
    public NoticePresenter(NoticeContract.View view,int id){

        this.view=view;
        this.id=id;

    }



    @Override
    public void loadItems(ArrayList<NoticeObj> objList,int cur) {
        noiticeFetcher= new NoticeFetcher(id);
        noiticeFetcher.setPresenter(this);
        noiticeFetcher.getObjList(cur,objList,view.getAdapter());
    }

    @Override
    public void setView(NoticeContract.View view) {
        this.view=view;
    }

    @Override
    public void fetchSucced() {
        view.clearHeadRefreshIcon();
    }
}
