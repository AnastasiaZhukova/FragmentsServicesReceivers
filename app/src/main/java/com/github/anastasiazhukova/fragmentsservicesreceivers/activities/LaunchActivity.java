package com.github.anastasiazhukova.fragmentsservicesreceivers.activities;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;

import com.github.anastasiazhukova.fragmentsservicesreceivers.Constants;
import com.github.anastasiazhukova.fragmentsservicesreceivers.MyApplication;
import com.github.anastasiazhukova.fragmentsservicesreceivers.R;

public class LaunchActivity extends AppCompatActivity {

    private MyApplication mMyApplication;

    BroadcastReceiver authorizedReceiver = new BroadcastReceiver() {

        @Override
        public void onReceive(final Context context, final Intent intent) {
            startMyApplicationActivity();
        }
    };

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);
        mMyApplication = ((MyApplication) getApplicationContext());
        if (mMyApplication.getData() == null) {
            startAuthorizationActivity();

        } else {
            startMyApplicationActivity();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(authorizedReceiver, new IntentFilter(Constants.AUTHORIZED_KEY));
    }

    private void startAuthorizationActivity() {
        Intent intent = new Intent(this, AuthorizationActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
    }

    private void startMyApplicationActivity() {
        //TODO implement MyApplicationActivity
    }

    @Override
    protected void onDestroy() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(authorizedReceiver);
        super.onDestroy();
    }

}
