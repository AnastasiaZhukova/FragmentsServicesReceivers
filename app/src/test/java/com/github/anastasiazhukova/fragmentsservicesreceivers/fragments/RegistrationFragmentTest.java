package com.github.anastasiazhukova.fragmentsservicesreceivers.fragments;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.github.anastasiazhukova.fragmentsservicesreceivers.BuildConfig;
import com.github.anastasiazhukova.fragmentsservicesreceivers.R;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.robolectric.util.FragmentTestUtil.startFragment;

@RunWith(RobolectricTestRunner.class)
@Config(
        constants = BuildConfig.class,
        sdk = 21
)
public class RegistrationFragmentTest {

    RegistrationFragment mFragment;
    View mFragmentView;
    private EditText mName;
    private EditText mEmail;
    private EditText mPassword;
    private View mSubmitButton;

    @Before
    public void setUp() throws Exception {

        mFragment = new RegistrationFragment();
        startFragment(mFragment, AppCompatActivity.class);
        assertNotNull(mFragment);

        mFragmentView = mFragment.getView();
        assertNotNull(mFragmentView);

        mName = mFragmentView.findViewById(R.id.editText_name);
        mEmail = mFragmentView.findViewById(R.id.editText_email);
        mPassword = mFragmentView.findViewById(R.id.editText_password);

        mSubmitButton = mFragmentView.findViewById(R.id.button_submit);

    }

    @Test
    public void testViews() {

        assertTrue(mName.isEnabled());
        assertTrue(mEmail.isEnabled());
        assertFalse(mSubmitButton.isEnabled());

    }

    @Test
    public void testSubmitButton() {

        assertFalse(mSubmitButton.isEnabled());
        mEmail.setText("email");
        assertFalse(mSubmitButton.isEnabled());
        mName.setText("name");
        assertFalse(mSubmitButton.isEnabled());
        mPassword.setText("password");
        assertTrue(mSubmitButton.isEnabled());
        mPassword.setText("");
        assertFalse(mSubmitButton.isEnabled());
    }

}