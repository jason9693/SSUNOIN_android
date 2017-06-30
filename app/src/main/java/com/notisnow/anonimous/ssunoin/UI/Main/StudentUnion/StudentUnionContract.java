package com.notisnow.anonimous.ssunoin.UI.Main.StudentUnion;

import com.notisnow.anonimous.ssunoin.Model.StudentUnion.UnionInfo;

import java.util.ArrayList;

/**
 * Created by yang-gichang on 2017. 6. 30..
 */

public interface StudentUnionContract {
    interface View{
    }
    interface Presenter{
        void call(String number);
        ArrayList<UnionInfo> getUnionInfoList();
    }
}
