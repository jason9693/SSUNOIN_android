package com.notisnow.anonimous.ssunoin.StaticField;

import com.notisnow.anonimous.ssunoin.Model.Major.MajorObj;

import java.util.ArrayList;

/**
 * Created by yang-gichang on 2017. 6. 27..
 */

public class Data {
    private static ArrayList<MajorObj> DepartmentOf = new ArrayList<>();
    static {
        DepartmentOf.add(new MajorObj(
                "국어국문학과",
                "Korean Language & Literature",
                "http://korlan.ssu.ac.kr/web/korlan/notice_a?p_p_id=EXT_BBS&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id="
                        + "column-1&p_p_col_count=1&_EXT_BBS_struts_action=%2Fext%2Fbbs%2Fview&_EXT_BBS_sCategory=&_EXT_BBS_sTitle="
                        + "&_EXT_BBS_sWriter=&_EXT_BBS_sTag=&_EXT_BBS_sContent=&_EXT_BBS_sCategory2=&_EXT_BBS_sKeyType="
                        + "&_EXT_BBS_sKeyword=&_EXT_BBS_curPage="
        ));
        DepartmentOf.add(new MajorObj(
                        "영어영문학과",
                        "English Language & Literature",
                        "http://englan.ssu.ac.kr/web/englan/10?p_p_id=EXT_BBS&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id="
                                + "column-1&p_p_col_count=1&_EXT_BBS_struts_action=%2Fext%2Fbbs%2Fview&_EXT_BBS_sCategory="
                                + "&_EXT_BBS_sTitle=&_EXT_BBS_sWriter=&_EXT_BBS_sTag=&_EXT_BBS_sContent=&_EXT_BBS_sCategory2="
                                + "&_EXT_BBS_sKeyType=&_EXT_BBS_sKeyword=&_EXT_BBS_curPage="
                )
        );
        DepartmentOf.add(new MajorObj(
                        "불어불문학과",
                        "French Language & Literature",
                        "http://france.ssu.ac.kr/web/france/21?p_p_id=EXT_BBS&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id="
                                + "column-1&p_p_col_count=1&_EXT_BBS_struts_action=%2Fext%2Fbbs%2Fview&_EXT_BBS_sCategory="
                                + "&_EXT_BBS_sTitle=&_EXT_BBS_sWriter=&_EXT_BBS_sTag=&_EXT_BBS_sContent=&_EXT_BBS_sCategory2="
                                + "&_EXT_BBS_sKeyType=&_EXT_BBS_sKeyword=&_EXT_BBS_curPage="
                )
        );
        DepartmentOf.add(new MajorObj(
                "독어독문학과",
                "German Language & Literature",
                "http://gerlan.ssu.ac.kr/web/gerlan/notice_b?p_p_id=EXT_BBS&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id="
                        + "column-1&p_p_col_count=1&_EXT_BBS_struts_action=%2Fext%2Fbbs%2Fview&_EXT_BBS_sCategory="
                        + "&_EXT_BBS_sTitle=&_EXT_BBS_sWriter=&_EXT_BBS_sTag=&_EXT_BBS_sContent=&_EXT_BBS_sCategory2="
                        + "&_EXT_BBS_sKeyType=&_EXT_BBS_sKeyword=&_EXT_BBS_curPage="
        ));
        DepartmentOf.add(new MajorObj(
                "일어일문학과",
                "Japanese Language & Literature",
                "http://japanstu.ssu.ac.kr/web/japanstu/notice?p_p_id=EXT_BBS&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id="
                        + "column-1&p_p_col_count=1&_EXT_BBS_struts_action=%2Fext%2Fbbs%2Fview&_EXT_BBS_sCategory="
                        + "&_EXT_BBS_sTitle=&_EXT_BBS_sWriter=&_EXT_BBS_sTag=&_EXT_BBS_sContent=&_EXT_BBS_sCategory2="
                        + "&_EXT_BBS_sKeyType=&_EXT_BBS_sKeyword=&_EXT_BBS_curPage="
        ));
        DepartmentOf.add(new MajorObj(
                "사학과",
                "Department Of History",
                "http://history.ssu.ac.kr/web/history/community_a?p_p_id=EXT_BBS&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id="
                        +"column-1&p_p_col_count=1&_EXT_BBS_struts_action=%2Fext%2Fbbs%2Fview&_EXT_BBS_sCategory="
                        +"&_EXT_BBS_sTitle=&_EXT_BBS_sWriter=&_EXT_BBS_sTag=&_EXT_BBS_sContent=&_EXT_BBS_sCategory2="
                        +"&_EXT_BBS_sKeyType=&_EXT_BBS_sKeyword=&_EXT_BBS_curPage="
        ));
        DepartmentOf.add(new MajorObj(
                "철학과",
                "Department Of Philosophy",
                "http://www.ssu.ac.kr/web/phil/13?p_p_id=EXT_BBS&p_p_lifecycle=0&p_p_state=normal&p_p_mode=view&p_p_col_id="
                        +"column-1&p_p_col_count=1&_EXT_BBS_struts_action=%2Fext%2Fbbs%2Fview&_EXT_BBS_sCategory="
                        +"&_EXT_BBS_sTitle=&_EXT_BBS_sWriter=&_EXT_BBS_sTag=&_EXT_BBS_sContent=&_EXT_BBS_sCategory2="
                        +"&_EXT_BBS_sKeyType=&_EXT_BBS_sKeyword=&_EXT_BBS_curPage="
        ));
    }

    public static ArrayList<MajorObj> getDepartmentOf() {
        return DepartmentOf;
    }
}
