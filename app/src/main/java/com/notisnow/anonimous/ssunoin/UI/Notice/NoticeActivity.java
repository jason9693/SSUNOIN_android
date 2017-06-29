package com.notisnow.anonimous.ssunoin.UI.Notice;

import android.content.Intent;
import android.os.Bundle;
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
import com.notisnow.anonimous.ssunoin.Utils.BaseApplication;

import java.util.ArrayList;

public class NoticeActivity extends AppCompatActivity implements NoticeContract.View {

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
        int majorId = getIntent().getIntExtra("majorId", 0);
        titleName = (TextView) findViewById(R.id.major);
        titleName.setText(Data.getDepartmentOf().get(majorId).getName());

        BaseApplication application = new BaseApplication();

        presenter = new NoticePresenter(this, majorId);
        adapter = new NoticeAdapter();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        presenter.loadItems(noticeObjs, page++);

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
    }


    public void loadNextDataFromApi(int offset) {
        Log.d("offset:", "" + offset);

        presenter.loadItems(noticeObjs, page++);

        adapter.notifyDataSetChanged();
        listener.resetState();

        Log.d("NoticeObjsSize", "" + noticeObjs.size());
    }

    @Override
    public RecyclerView.Adapter getAdapter() {
        return adapter;
    }


    class NHolder extends RecyclerView.ViewHolder {
        //========================
            int nPosition;
            TextView title;
            TextView date;
            ImageView imageView;
        //=========================

        public NHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            date = (TextView) itemView.findViewById(R.id.date);
            imageView = (ImageView) itemView.findViewById(R.id.contained);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(getApplicationContext(), NoticeDetailActivity.class);
                    intent.putExtra("title",noticeObjs.get(nPosition).getTitle());
                    intent.putExtra("date",noticeObjs.get(nPosition).getDate());
                    intent.putExtra("url",noticeObjs.get(nPosition).getUrl());

                    startActivity(intent);
                }
            });
        }
    }

    class NoticeAdapter extends RecyclerView.Adapter<NHolder> implements NoticeAdapterContract.View {


        @Override
        public NHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_notice_card, parent, false);
            NHolder holder = new NHolder(v);

            return holder;
        }

        @Override
        public void onBindViewHolder(NHolder holder, int position) {
            String title=noticeObjs.get(position).getTitle();
            if(title.length()>=26){
                title=title.substring(0,25);
                title=title+"...";
            }
            holder.nPosition=position;
            holder.title.setText(title);
            holder.date.setText(noticeObjs.get(position).getDate());
            if (!noticeObjs.get(position).isContainFile())
                holder.imageView.setVisibility(View.INVISIBLE);
        }

        @Override
        public int getItemCount() {
            return noticeObjs.size();
        }
    }
}
