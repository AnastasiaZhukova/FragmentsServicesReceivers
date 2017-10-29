package com.github.anastasiazhukova.fragmentsservicesreceivers.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.anastasiazhukova.fragmentsservicesreceivers.R;
import com.github.anastasiazhukova.fragmentsservicesreceivers.activities.AuthorizationActivity;

public class StartAuthorizationFragment extends Fragment {

    private View mView;

    private View mLogInButton;
    private View mRegisterButton;

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container,
                             final Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_startauthorization, null);
        intiViews();

        return mView;
    }

    private void intiViews() {
        mLogInButton = mView.findViewById(R.id.button_login);
        mRegisterButton = mView.findViewById(R.id.button_register);

        mLogInButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (getActivity() instanceof AuthorizationActivity) {
                    ((AuthorizationActivity) getActivity()).showFragment(new LogInFragment());
                }
            }
        });

        mRegisterButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (getActivity() instanceof AuthorizationActivity) {
                    ((AuthorizationActivity) getActivity()).showFragment(new RegistrationFragment());
                }
            }
        });
    }

}
