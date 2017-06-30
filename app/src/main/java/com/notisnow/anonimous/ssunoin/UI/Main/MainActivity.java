package com.notisnow.anonimous.ssunoin.UI.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.notisnow.anonimous.ssunoin.Model.CustomComponent.MainViewPager;
import com.notisnow.anonimous.ssunoin.R;
import com.notisnow.anonimous.ssunoin.UI.Main.NoticeByMajor.NoticeByMajorFragment;
import com.notisnow.anonimous.ssunoin.UI.Main.StudentUnion.StudentUnionFragment;
import com.notisnow.anonimous.ssunoin.UI.Splash.SplashActivity;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private TextView mTextMessage;
    private Fragment fragment;
    private MainViewPager viewPager;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_notice:
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.navigation_student_union:
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.navigation_more:

                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent StartIntent=new Intent(this, SplashActivity.class);
        startActivity(StartIntent);

        viewPager=(MainViewPager)findViewById(R.id.content);
        viewPager.setAdapter(new PAdapter(getSupportFragmentManager()));
        viewPager.setPagingEnabled(false);

       // mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    class PAdapter extends FragmentPagerAdapter {
        public PAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return new NoticeByMajorFragment();
                case 1:
                    return new StudentUnionFragment();
                default:
                    return null;
            }

        }



        @Override
        public int getCount() {
            return 2;
        }


    }
}
