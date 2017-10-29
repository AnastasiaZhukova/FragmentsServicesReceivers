package com.github.anastasiazhukova.fragmentsservicesreceivers.activities;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.github.anastasiazhukova.fragmentsservicesreceivers.Constants;
import com.github.anastasiazhukova.fragmentsservicesreceivers.MyApplication;
import com.github.anastasiazhukova.fragmentsservicesreceivers.R;
import com.github.anastasiazhukova.fragmentsservicesreceivers.services.DownloadService;

public class MyApplicationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_myapplication);
        initViews();

    }

    private void initViews() {
        findViewById(R.id.button_show).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                final StringBuilder toastMessage = new StringBuilder("Hello ");
                final String name = ((MyApplication) getApplicationContext()).getData().getName();
                if (name != null) {
                    toastMessage.append(name);
                }
                Toast.makeText(MyApplicationActivity.this, toastMessage.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.button_download).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                final PendingIntent pendingIntent = createPendingResult(Constants.DOWNLOAD_SERVICE_RESULT, new Intent(), 0);
                final Intent intent = new Intent(MyApplicationActivity.this, DownloadService.class);
                intent.putExtra(Constants.PENDING_INTENT_KEY, pendingIntent);
                startService(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        if (requestCode == Constants.DOWNLOAD_SERVICE_RESULT) {
            Toast.makeText(this, data.getStringExtra(Constants.DOWNLOAD_SERVICE_KEY), Toast.LENGTH_SHORT).show();
        }
    }

}
