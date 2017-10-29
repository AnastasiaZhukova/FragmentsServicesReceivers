package com.github.anastasiazhukova.fragmentsservicesreceivers;

import android.app.Application;

import com.github.anastasiazhukova.fragmentsservicesreceivers.data.Data;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //Toast.makeText(this,"Application created",Toast.LENGTH_SHORT).show();
    }

    private Data mData;

    public Data getData() {
        return mData;
    }

    public void setData(Data pData) {
        mData = pData;
    }
}
