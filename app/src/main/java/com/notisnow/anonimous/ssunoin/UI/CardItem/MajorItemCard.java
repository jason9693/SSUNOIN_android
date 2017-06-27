package com.notisnow.anonimous.ssunoin.UI.CardItem;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.notisnow.anonimous.ssunoin.R;

/**
 * Created by yang-gichang on 2017. 6. 27..
 */

public class MajorItemCard extends LinearLayout{
    TextView majorName;
    TextView engMajorName;
    ImageView next;
    RecyclerView.ViewHolder viewHolder;
    public MajorItemCard(Context context) {
        super(context);
        init(context);
    }
    public void init(Context context){

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.list_major_card,this);
        majorName=(TextView)findViewById(R.id.title);
        engMajorName=(TextView)findViewById(R.id.engtitle);

    }

    public void setMajorName(String majorName) {
        this.majorName.setText(majorName);
    }

    public void setEngMajorName(String engMajorName) {
        this.engMajorName.setText(engMajorName);
    }



}
