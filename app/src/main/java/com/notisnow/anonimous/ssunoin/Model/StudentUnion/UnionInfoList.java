package com.notisnow.anonimous.ssunoin.Model.StudentUnion;

import com.notisnow.anonimous.ssunoin.R;

import java.util.ArrayList;

/**
 * Created by yang-gichang on 2017. 6. 30..
 */

public class UnionInfoList {
    ArrayList<UnionInfo> list;
    public UnionInfoList(){
        list=new ArrayList<>();
        list.add(new UnionInfo("인문대학 학생회","조만식기념관 325호","https://www.facebook.com/soongsilinmun","02-820-0872",R.mipmap.union_inmoon));
        list.add(new UnionInfo("국어국문학과 학생회 '동화국문'","조만식기념관 301호","https://www.facebook.com/숭실대학교-국어국문학과-학생회-413890638693677/?fref=ts","",R.mipmap.union_korea));
        list.add(new UnionInfo("일어일문학과 학생회","조만식기념관 320호",R.mipmap.uniun_jap));
        list.add(new UnionInfo("중어중문학과 학생회","조만식기념관 302호",R.mipmap.ic_launcher));
        list.add(new UnionInfo("영어영문학과 학생회","조만식기념관 324호","https://www.facebook.com/ssueng/?fref=ts","",R.mipmap.union_eng));
        list.add(new UnionInfo("불어불문학과 학생회","조만식기념관 317호","https://www.facebook.com/ssufrancais/","",R.mipmap.ic_launcher));
        list.add(new UnionInfo("독어독문학과 학생회","조만식기념관 318호",R.mipmap.ic_launcher));
        list.add(new UnionInfo("사학과 학생회","조만식기념관 319호","https://www.facebook.com/숭실대학교-사학과-355749764472974/?fref=ts","",R.mipmap.ic_launcher));
        list.add(new UnionInfo("철학과 학생회","조만식기념관 322호","https://m.facebook.com/ssuph25s/","",R.mipmap.ic_launcher));
        list.add(new UnionInfo("기독교학과 학생회","조만식기념관 303호",R.mipmap.union_chr));
    }

    public ArrayList<UnionInfo> getInfoList(){
        return list;
    }
}
