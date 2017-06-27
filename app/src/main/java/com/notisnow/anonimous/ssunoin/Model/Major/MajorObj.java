package com.notisnow.anonimous.ssunoin.Model.Major;

/**
 * Created by yang-gichang on 2017. 6. 27..
 */

public class MajorObj implements MajorContract.Model{
    private String EngName;
    private String Name;
    private String url;

   public MajorObj(String Name,String EngName,String Url){
       this.Name=Name;
       this.EngName=EngName;
       this.url=Url;
   }

    @Override
    public String getEngName() {
        return EngName;
    }

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public String getUrl() {
        return url;
    }
}
