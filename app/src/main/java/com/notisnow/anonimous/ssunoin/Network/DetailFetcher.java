package com.notisnow.anonimous.ssunoin.Network;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.notisnow.anonimous.ssunoin.UI.NoticeDetail.NoticeDetailContract;
import com.notisnow.anonimous.ssunoin.Utils.BaseApplication;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

/**
 * Created by yang-gichang on 2017. 6. 29..
 */

public class DetailFetcher {
    String url;
    NoticeDetailContract.Presenter presenter;
    public DetailFetcher(NoticeDetailContract.Presenter presenter,String url){
        this.url=url;
        this.presenter=presenter;
        fetch();
    }

    void fetch(){
        RequestQueue queue= BaseApplication.getRequestQueue();
        StringRequest request=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Document document= Jsoup.parse(url);
                Elements downloadList=document.select("tbody").select("tr").select("td").select("a");
                String content = document.select(".frame-box").html();
                presenter.UpdateView(downloadList,content);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        queue.add(request);
    }
}
