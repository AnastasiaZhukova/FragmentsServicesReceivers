package com.github.anastasiazhukova.fragmentsservicesreceivers.activities;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;

import com.github.anastasiazhukova.fragmentsservicesreceivers.Constants;
import com.github.anastasiazhukova.fragmentsservicesreceivers.MyApplication;
import com.github.anastasiazhukova.fragmentsservicesreceivers.R;
import com.github.anastasiazhukova.fragmentsservicesreceivers.data.Data;
import com.github.anastasiazhukova.fragmentsservicesreceivers.fragments.StartAuthorizationFragment;

public class AuthorizationActivity extends AppCompatActivity {

    private MyApplication mMyApplication;
    public static final String CURRENT_FRAGMENT_KEY = "CurrentFragment";
    private Fragment mCurrentFragment;
    FragmentTransaction mFragmentTransaction = getFragmentManager().beginTransaction();

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authorization);

        mMyApplication = ((MyApplication) getApplicationContext());

        if (savedInstanceState == null) {
            mCurrentFragment = new StartAuthorizationFragment();
        } else {
            mCurrentFragment = getFragmentManager().getFragment(savedInstanceState, CURRENT_FRAGMENT_KEY);
        }
        showFragment(mCurrentFragment);

    }

    public void showFragment(final Fragment fragment) {
        mCurrentFragment = fragment;
        mFragmentTransaction = getFragmentManager().beginTransaction();
        mFragmentTransaction.replace(R.id.container, fragment);
        mFragmentTransaction.commit();
    }

    public void hideFragment() {
        if (!(mCurrentFragment instanceof StartAuthorizationFragment)) {
            mFragmentTransaction.hide(mCurrentFragment);
        }

    }

    public void setData(final String pName, final String pEmail) {
        mMyApplication.setData(new Data(pName, pEmail));
        LocalBroadcastManager.getInstance(this).sendBroadcast(new Intent(Constants.AUTHORIZED_KEY));
    }

    @Override
    public void onBackPressed() {
        hideFragment();
        showFragment(new StartAuthorizationFragment());
    }

    @Override
    protected void onSaveInstanceState(final Bundle outState) {

        getFragmentManager().putFragment(outState, CURRENT_FRAGMENT_KEY, mCurrentFragment);
        super.onSaveInstanceState(outState);
    }

}
