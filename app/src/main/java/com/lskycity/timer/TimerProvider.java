package com.lskycity.timer;

import android.content.Context;
import android.os.CountDownTimer;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by zhaofliu on 7/25/17.
 */

public class TimerProvider {

    private CountDownTimer timer;

    public void startTimer(long millisInFuture) {
        timer = new CountDownTimer(millisInFuture, 1000){

            @Override
            public void onTick(long millisUntilFinished) {
                notifyUI(millisUntilFinished);
            }

            @Override
            public void onFinish() {
                timer = null;
                notifyTimeOut();
            }
        };
        timer.start();
    }

    private void notifyTimeOut() {
        EventBus.getDefault().post(new Millis(0));
    }


    private void notifyUI(long millisUntilFinished) {
        EventBus.getDefault().post(new Millis(millisUntilFinished));
    }

    public boolean isTimeOut() {
        return timer == null;
    }

    public void start() {
        if(timer!=null) {
            timer.start();
        }
    }

    public void cancelTime() {
        if(timer!=null) {
            timer.cancel();
        }
        timer = null;
    }

}
