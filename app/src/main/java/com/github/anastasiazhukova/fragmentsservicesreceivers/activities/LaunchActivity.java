package com.github.anastasiazhukova.fragmentsservicesreceivers.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.github.anastasiazhukova.fragmentsservicesreceivers.MyApplication;
import com.github.anastasiazhukova.fragmentsservicesreceivers.R;

public class LaunchActivity extends AppCompatActivity {

    private MyApplication mMyApplication;

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

    private void startAuthorizationActivity() {
        //TODO implement AuthorizationActivity
    }

    private void startMyApplicationActivity() {
        //TODO implement MyApplicationActivity
    }

}
