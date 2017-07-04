package com.notisnow.anonimous.ssunoin.UI.Notice;

import android.support.v7.widget.RecyclerView;

import com.notisnow.anonimous.ssunoin.Model.Notice.NoticeObj;

import java.util.ArrayList;

/**
 * Created by yang-gichang on 2017. 6. 28..
 */

public interface NoticeContract {
    interface View{
        RecyclerView.Adapter getAdapter();
        void clearHeadRefreshIcon();
    }
    interface Presenter{
       // void initLoad(ArrayList<NoticeObj> objList);
        void loadItems(ArrayList<NoticeObj> objList,int cur);
        void setView(View view);
        void fetchSucced();
        int getFooterCount();
        void setFooterCount(boolean flag);
    }
    interface Model{
    }
}
