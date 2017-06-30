package com.notisnow.anonimous.ssunoin.UI.Main.StudentUnion;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.notisnow.anonimous.ssunoin.Model.StudentUnion.UnionInfo;
import com.notisnow.anonimous.ssunoin.Model.StudentUnion.UnionInfoList;
import com.notisnow.anonimous.ssunoin.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * <p>
 * to handle interaction events.
 * Use the {@link StudentUnionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StudentUnionFragment extends Fragment implements StudentUnionContract.View{
    ArrayList<UnionInfo> list;

    public StudentUnionFragment() {
        // Required empty public constructor
    }


    public static StudentUnionFragment newInstance(String param1, String param2) {
        StudentUnionFragment fragment = new StudentUnionFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        list = new UnionInfoList().getInfoList();

        View v = inflater.inflate(R.layout.fragment_student_union, container, false);
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        recyclerView.setAdapter(new Adapter());

        return v;
    }



    class UnionHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView area;
        CircleImageView imgLogo;
        ImageButton kakao;
        ImageButton facebook;
        int position;

        public UnionHolder(final View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.textName);
            area = (TextView) itemView.findViewById(R.id.textArea);
            imgLogo = (CircleImageView) itemView.findViewById(R.id.imageLogo);

            kakao = (ImageButton) itemView.findViewById(R.id.imgKakao);
            kakao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + list.get(position).getCall()));
                    try {
                        startActivity(callIntent);
                        Log.d("callingClicked","execute");
                    }catch (Exception e){
                        if(ContextCompat.checkSelfPermission(getActivity(),
                                Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                            if(ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),Manifest.permission.CALL_PHONE)){
                                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE},
                                        110);
                            }else {
                                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CALL_PHONE},
                                        110);
                            }
                        }
                    }

                }
            });

            facebook = (ImageButton) itemView.findViewById(R.id.imgFacebook);
            facebook.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    Intent facebookIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(list.get(position).getFacebookLink()));
                                                    startActivity(facebookIntent);
                                                }
                                            }
                );

        }

        public void setPosition(int position) {
            this.position = position;
        }
    }

    class Adapter extends RecyclerView.Adapter<UnionHolder> implements UnionAdapterContract.View {

        @Override
        public UnionHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_student_union_card, parent, false);

            UnionHolder viewHolder = new UnionHolder(v);

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(UnionHolder holder, int position) {
            holder.name.setText(list.get(position).getSlogun());
            holder.area.setText(list.get(position).getArea());
            holder.imgLogo.setImageResource(list.get(position).getImgId());
            if (list.get(position).getCall().equals("")) holder.kakao.setVisibility(View.GONE);
            else holder.kakao.setVisibility(View.VISIBLE);
            if (list.get(position).getFacebookLink().equals("")) holder.facebook.setVisibility(View.GONE);
            else  holder.facebook.setVisibility(View.VISIBLE);
            holder.setPosition(position);
        }


        @Override
        public int getItemCount() {
            return list.size();
        }
    }


}
