package com.notisnow.anonimous.ssunoin.UI.Splash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.notisnow.anonimous.ssunoin.R;

public class SplashActivity extends AppCompatActivity implements SplashContract.View{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        SplashContract.Presenter pre=new SplashPresenter(this);
        pre.seizeTime();
    }

    @Override
    public void updateCondition() {
        finish();
    }
}
