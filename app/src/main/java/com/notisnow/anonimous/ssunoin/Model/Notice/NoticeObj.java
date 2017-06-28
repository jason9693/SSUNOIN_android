package com.notisnow.anonimous.ssunoin.Model.Notice;

import com.notisnow.anonimous.ssunoin.UI.Notice.NoticeContract;

import java.io.Serializable;

/**
 * Created by yang-gichang on 2017. 6. 28..
 */

public class NoticeObj implements Serializable,NoticeContract.Model{
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
        this.Date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title.length()>=26){
            title=title.substring(0,25);
            title=title+"...";
        }

        this.title = title;
    }

    public boolean isContainFile() {
        return isContainFile;
    }

    public void setContainFile(boolean containFile) {
        isContainFile = containFile;
    }
}
