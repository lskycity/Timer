package com.lskycity.timer;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;

import com.lskycity.support.utils.SharedPreUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

/**
 * Created by zhaofliu on 7/26/17.
 */

public class TimerService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        EventBus.getDefault().register(this);

        long time = SharedPreUtils.getLong(this, Constant.KEY_START_TIME, 2*60*1000);
        showForegroundNotification(new Millis(time));
    }

    private void showForegroundNotification(Millis time) {
        Notification.Builder builder = new Notification.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle(getString(R.string.app_name));
        builder.setContentText(time.toString());

        final Intent notificationIntent = new Intent(this, FullscreenActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);
        builder.setContentIntent(pendingIntent);

        startForeground(0x11, builder.build());
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int result = super.onStartCommand(intent, flags, startId);
        return result;
    }

    @Subscribe
    public void onEvent(Millis event) {
        updateNotification(event);
    }

    private void updateNotification(Millis event) {
        showForegroundNotification(event);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        removeForegroundNotification();
    }

    private void removeForegroundNotification() {
        stopForeground(true);
    }
}
