package com.github.anastasiazhukova.fragmentsservicesreceivers.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.github.anastasiazhukova.fragmentsservicesreceivers.Constants;
import com.github.anastasiazhukova.fragmentsservicesreceivers.services.NotificationService;

public class LowBatteryReceiver extends BroadcastReceiver {

    public static final String MESSAGE_FROM_RECEIVER = "Message from receiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intentToSend=new Intent(context,NotificationService.class);
        intentToSend.putExtra(Constants.NOTIFICATION_KEY, MESSAGE_FROM_RECEIVER);
        context.startService(intentToSend);
    }
}
