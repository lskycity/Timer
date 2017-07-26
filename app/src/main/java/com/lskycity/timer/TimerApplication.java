package com.lskycity.timer;

import android.app.Application;

/**
 * Created by zhaofliu on 7/25/17.
 */

public class TimerApplication extends Application {

    private static TimerApplication instance;

    private TimerProvider provider;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        provider = new TimerProvider();
    }

    public static TimerApplication get() {
        return instance;
    }

    public TimerProvider getProvider() {
        return provider;
    }

}
