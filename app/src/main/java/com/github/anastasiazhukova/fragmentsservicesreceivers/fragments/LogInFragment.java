package com.github.anastasiazhukova.fragmentsservicesreceivers.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.github.anastasiazhukova.fragmentsservicesreceivers.R;
import com.github.anastasiazhukova.fragmentsservicesreceivers.activities.AuthorizationActivity;

public class LogInFragment extends Fragment {

    private EditText mEmailEditText;
    private EditText mPasswordEditText;
    private View mLogInButton;

    private View mView;

    @Override
    public void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable final ViewGroup container,
                             final Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_login, null);
        intiViews();

        return mView;
    }

    private void intiViews() {
        mEmailEditText = mView.findViewById(R.id.editText_email);
        mPasswordEditText = mView.findViewById(R.id.editText_password);
        mLogInButton = mView.findViewById(R.id.button_submit);

        mEmailEditText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(final CharSequence s, final int start, final int count, final int after) {

            }

            @Override
            public void onTextChanged(final CharSequence s, final int start, final int before, final int count) {

            }

            @Override
            public void afterTextChanged(final Editable pEditable) {
                final int email_textLength = pEditable.length();
                final int password_textLength = mPasswordEditText.getText().length();
                if (email_textLength > 0 && password_textLength > 0) {
                    mLogInButton.setEnabled(true);
                } else {
                    mLogInButton.setEnabled(false);
                }

            }
        });

        mPasswordEditText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(final CharSequence s, final int start, final int count, final int after) {

            }

            @Override
            public void onTextChanged(final CharSequence s, final int start, final int before, final int count) {

            }

            @Override
            public void afterTextChanged(final Editable pEditable) {
                final int password_textLength = pEditable.length();
                final int email_textLength = mEmailEditText.getText().length();
                if (email_textLength > 0 && password_textLength > 0) {
                    mLogInButton.setEnabled(true);
                } else {
                    mLogInButton.setEnabled(false);
                }

            }
        });

        mLogInButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                if (getActivity() instanceof AuthorizationActivity) {
                    final AuthorizationActivity authorizationActivity = (AuthorizationActivity) getActivity();
                    authorizationActivity.setData("UsersName",
                            mEmailEditText.getText().toString());

                }

            }
        });

    }

    @Nullable
    @Override
    public View getView() {
        return mView;
    }
}
