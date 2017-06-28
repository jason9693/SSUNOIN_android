package com.notisnow.anonimous.ssunoin.Model.Notice;

import com.notisnow.anonimous.ssunoin.UI.Notice.NoticeContract;

/**
 * Created by yang-gichang on 2017. 6. 28..
 */

public class NoticeObj implements NoticeContract.Model{
    String Date;
    String title;
    boolean isContainFile=true;
    String url;
    public String getDate() {
        return Date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isContainFile() {
        return isContainFile;
    }

    public void setContainFile(boolean containFile) {
        isContainFile = containFile;
    }
}
