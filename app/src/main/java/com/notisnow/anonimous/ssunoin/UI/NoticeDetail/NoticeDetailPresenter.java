package com.notisnow.anonimous.ssunoin.UI.NoticeDetail;

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

    }

    @Override
    public void UpdateView(Elements downloadList,String url){
        view.updateWebView(url);
        //TODO:다운로드 리스트에서 타이틀,링크 추출하기,뷰에 업데이트 시키기
    }
}
