package com.notisnow.anonimous.ssunoin.UI.Splash;

/**
 * Created by yang-gichang on 2017. 6. 30..
 */

public class SplashPresenter implements SplashContract.Presenter{

    SplashContract.View view;

    public SplashPresenter(SplashContract.View view){
        this.view=view;
    }
    @Override
    public void seizeTime() {

        class time extends Thread{
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                }
                view.updateCondition();
            }
        }
        time t=new time();
        t.start();
    }
}
