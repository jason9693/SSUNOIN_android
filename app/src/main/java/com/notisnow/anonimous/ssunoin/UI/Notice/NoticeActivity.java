package com.notisnow.anonimous.ssunoin.UI.Notice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.notisnow.anonimous.ssunoin.Model.Notice.NoticeObj;
import com.notisnow.anonimous.ssunoin.R;
import com.notisnow.anonimous.ssunoin.StaticField.Data;
import com.notisnow.anonimous.ssunoin.UI.NoticeDetail.NoticeDetailActivity;

import java.util.ArrayList;

public class NoticeActivity extends AppCompatActivity implements NoticeContract.View {
    private int FOOTER = 1;
    private int NOFOOTER = 0;
    SwipeRefreshLayout swpLayout;
    NoticeContract.Presenter presenter;
    ArrayList<NoticeObj> noticeObjs = new ArrayList<>();
    RecyclerView recyclerView;
    NoticeAdapter adapter;
    private int page = 1;
    TextView titleName;
    private EndlessRecyclerViewScrollListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
        swpLayout = (SwipeRefreshLayout) findViewById(R.id.refresh);
        int majorId = getIntent().getIntExtra("majorId", 0);
        titleName = (TextView) findViewById(R.id.major);
        titleName.setText(Data.getDepartmentOf().get(majorId).getName());

        presenter = new NoticePresenter(this, majorId);
        adapter = new NoticeAdapter();


        presenter.loadItems(noticeObjs, page++);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        RecyclerView.ItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                linearLayoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        listener = new EndlessRecyclerViewScrollListener(linearLayoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                loadNextDataFromApi(page);
            }
        };
        recyclerView.addOnScrollListener(listener);


        swpLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                noticeObjs.clear();
                noticeObjs = new ArrayList<NoticeObj>();
                page = 0;
                presenter.loadItems(noticeObjs, page++);
            }
        });
    }


    public void loadNextDataFromApi(int offset) {
        Log.d("offset:", "" + offset);

        presenter.loadItems(noticeObjs, page++);
        presenter.setFooterCount(true);
        adapter.notifyDataSetChanged();
        listener.resetState();

        Log.d("NoticeObjsSize", "" + noticeObjs.size());
    }

    @Override
    public RecyclerView.Adapter getAdapter() {
        return adapter;
    }

    @Override
    public void clearHeadRefreshIcon() {
        swpLayout.setRefreshing(false);
    }


    class NHolder extends RecyclerView.ViewHolder {
        //========================
        int nPosition;
        TextView title;
        TextView date;
        ImageView imageView;
        //=========================

        public void setContentHolder() {
            title = (TextView) itemView.findViewById(R.id.title);
            date = (TextView) itemView.findViewById(R.id.date);
            imageView = (ImageView) itemView.findViewById(R.id.contained);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(getApplicationContext(), NoticeDetailActivity.class);
                    intent.putExtra("title", noticeObjs.get(nPosition).getTitle());
                    intent.putExtra("date", noticeObjs.get(nPosition).getDate());
                    intent.putExtra("url", noticeObjs.get(nPosition).getUrl());

                    startActivity(intent);
                }
            });
        }

        public void setFooterHolder() {

        }

        public NHolder(View itemView) {
            super(itemView);
            if (nPosition>=noticeObjs.size()) {
                setFooterHolder();
            }else{
                setContentHolder();
            }
        }
    }

    class NoticeAdapter extends RecyclerView.Adapter<NHolder> implements NoticeAdapterContract.View {
        private int FOOTER= -21;
        private int CONTENTS=-1;

        @Override
        public NHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            NHolder holder;
            if(viewType==CONTENTS){
                View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_notice_card, parent, false);
                holder= new NHolder(v);
            } else{
                View Fv=LayoutInflater.from(parent.getContext()).inflate(R.layout.scroll_loading_item,parent,false);
                holder= new NHolder(Fv);
            }
            return holder;
        }

        @Override
        public int getItemViewType(int position) {
            if(position==noticeObjs.size()) return FOOTER;
            else return CONTENTS;
        }

        @Override
        public void onBindViewHolder(NHolder holder, int position) {
         if(position<noticeObjs.size()) onBindContentsViewHolder(holder,position);
            else onBindFooterViewHolder();
        }

        @Override
        public int getItemCount() {
            return noticeObjs.size() + presenter.getFooterCount();
        }

        public void onBindContentsViewHolder(NHolder holder,int position){
            String title = noticeObjs.get(position).getTitle();
            if (title.length() >= 26) {
                title = title.substring(0, 25);
                title = title + "...";
            }
            holder.nPosition = position;
            holder.title.setText(title);
            holder.date.setText(noticeObjs.get(position).getDate());
            if (!noticeObjs.get(position).isContainFile())
                holder.imageView.setVisibility(View.INVISIBLE);
            else holder.imageView.setVisibility(View.VISIBLE);
        }
        public void onBindFooterViewHolder(){

        }
    }
}
