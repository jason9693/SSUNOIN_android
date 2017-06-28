package com.notisnow.anonimous.ssunoin.UI.Main.NoticeByMajor;

/**
 * Created by yang-gichang on 2017. 6. 28..
 */

public class NoticeByMajorPresenter implements NoticeByMajorContract.Presenter{
    NoticeByMajorContract.View v;

    @Override
    public void setView(NoticeByMajorContract.View v) {
        this.v=v;
    }
}
