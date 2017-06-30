package com.notisnow.anonimous.ssunoin.UI.Main.More;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.notisnow.anonimous.ssunoin.R;

import static android.content.Intent.ACTION_SENDTO;
import static com.notisnow.anonimous.ssunoin.UI.Main.More.MoreContract.mTIK;
import static com.notisnow.anonimous.ssunoin.UI.Main.More.MoreContract.mYKC;

public class MoreFragment extends Fragment implements MoreContract.View{
    ImageView mailTIK1;
    ImageView mailTIK2;
    ImageView mailYKC;
    TextView nameTIK;
    TextView nameYKC;
    MoreContract.Presenter mPresenter;
    public MoreFragment() {
        // Required empty public constructor
    }

    public static MoreFragment newInstance(String param1, String param2) {
        MoreFragment fragment = new MoreFragment();
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
        mPresenter=new MorePresenter(this);

        View v=inflater.inflate(R.layout.fragment_more, container, false);
        mailTIK1=(ImageView) v.findViewById(R.id.emailTIK1);
        mailTIK1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.sendEmail(mTIK);
            }
        });
        mailTIK2=(ImageView) v.findViewById(R.id.emailTIK2);
        mailTIK2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.sendEmail(mTIK);
            }
        });
        mailYKC=(ImageView)v.findViewById(R.id.emailYKC);
        mailYKC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.sendEmail(mYKC);
            }
        });

        nameTIK=(TextView)v.findViewById(R.id.nameTIK);
        nameTIK.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mPresenter.doEasterEgg(mTIK);
                return true;
            }
        });
        nameYKC=(TextView)v.findViewById(R.id.nameYKC);
        nameYKC.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.d("eastereggExecute","executed");
                mPresenter.doEasterEgg(mYKC);
                return true;
            }
        });

        return v;
    }


    @Override
    public void openToast(String message) {
        Toast.makeText(getActivity().getApplicationContext(),message,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void openEmailIntent(String address) {
        Intent intent=new Intent(ACTION_SENDTO, Uri.parse("mailto:" + address));
        startActivity(intent);
    }
}
