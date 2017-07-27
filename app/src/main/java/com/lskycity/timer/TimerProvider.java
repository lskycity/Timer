package com.lskycity.timer;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.SystemClock;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by zhaofliu on 7/25/17.
 */

public class TimerProvider {

    private CountDownTimer timer;

    private long startTime = 0;

    public void startTimer(long millisInFuture) {
        timer = new CountDownTimer(millisInFuture + 1000, 1000){

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
        startTime = SystemClock.elapsedRealtime();
    }

    private void notifyTimeOut() {
        EventBus.getDefault().post(new Millis(0));
    }

    public long getStartTime() {
        return startTime;
    }

    public long resetStartTime() {
        return startTime = 0;
    }

    public boolean isStarting() {
        return startTime != 0;
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
