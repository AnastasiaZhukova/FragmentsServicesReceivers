package com.github.anastasiazhukova.fragmentsservicesreceivers.services;

import android.app.IntentService;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.github.anastasiazhukova.fragmentsservicesreceivers.Constants;

import java.util.concurrent.TimeUnit;

public class DownloadService extends IntentService {

    public static final String DOWNLOAD_SERVICE_NAME = "Download service";

    public DownloadService() {
        super(DOWNLOAD_SERVICE_NAME);
    }

    @Override
    protected void onHandleIntent(@Nullable final Intent intent) {

        final PendingIntent pendingIntent = intent.getParcelableExtra(Constants.PENDING_INTENT_KEY);

        try {
            TimeUnit.SECONDS.sleep(7);
            final String result = "Download completed";
            final Intent resultIntent = new Intent().putExtra(Constants.DOWNLOAD_SERVICE_KEY, result);
            pendingIntent.send(this, Constants.DOWNLOAD_SERVICE_RESULT, resultIntent);
        } catch (InterruptedException | PendingIntent.CanceledException pE) {
            pE.printStackTrace();
        }

    }
}
