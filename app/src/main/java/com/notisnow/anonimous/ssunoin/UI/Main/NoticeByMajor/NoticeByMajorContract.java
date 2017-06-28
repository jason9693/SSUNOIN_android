package com.notisnow.anonimous.ssunoin.UI.Main.NoticeByMajor;

/**
 * Created by yang-gichang on 2017. 6. 27..
 */

public interface NoticeByMajorContract {
    interface View{
        void setPresenter();
    }
    interface Presenter{
        void setView(View v);

    }
}
