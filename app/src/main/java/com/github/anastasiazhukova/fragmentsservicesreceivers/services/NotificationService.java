package com.github.anastasiazhukova.fragmentsservicesreceivers.services;

import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

import com.github.anastasiazhukova.fragmentsservicesreceivers.Constants;
import com.github.anastasiazhukova.fragmentsservicesreceivers.R;

public class NotificationService extends Service {
    public static final String MY_NOTIFICATION_TITLE = "MyApplication";
    private NotificationManager mNotificationManager;

    @Nullable
    @Override
    public IBinder onBind(final Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        super.onCreate();
    }

    @Override
    public int onStartCommand(final Intent intent, final int flags, final int startId) {

        final String message=intent.getStringExtra(Constants.NOTIFICATION_KEY);

        final NotificationCompat.Builder notificationBuilder=
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.ic_stat_name)
                        .setContentTitle(MY_NOTIFICATION_TITLE)
                        .setContentText(message);

        mNotificationManager.notify(1, notificationBuilder.build());

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
