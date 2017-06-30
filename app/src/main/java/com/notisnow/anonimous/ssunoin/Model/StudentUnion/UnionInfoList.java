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
        list.add(new UnionInfo("인문대학 학생회","조만식기념관 325호",R.mipmap.ic_launcher));
        list.add(new UnionInfo("국어국문학과 학생회 '동화국문'","조만식기념관 301호",R.mipmap.ic_launcher));
        list.add(new UnionInfo("일어일문학과 학생회","조만식기념관 320호",R.mipmap.ic_launcher));
        list.add(new UnionInfo("영어영문학과 학생회","조만식기념관 324호",R.mipmap.ic_launcher));
        list.add(new UnionInfo("불어불문학과 학생회","조만식기념관 317호",R.mipmap.ic_launcher));
        list.add(new UnionInfo("독어독문학과 학생회","조만식기념관 318호",R.mipmap.ic_launcher));
        list.add(new UnionInfo("사학과 학생회","조만식기념관 319호",R.mipmap.ic_launcher));
        list.add(new UnionInfo("철학과 학생회","조만식기념관 322호",R.mipmap.ic_launcher));
        list.add(new UnionInfo("기독교학과 학생회","조만식기념관 303호",R.mipmap.ic_launcher));
    }

    public ArrayList<UnionInfo> getInfoList(){
        return list;
    }
}
