package com.github.anastasiazhukova.fragmentsservicesreceivers.data;

public class Data {

    private String mName;
    private String mEmail;

    public Data(final String pName, final String pEmail) {
        mName = pName;
        mEmail = pEmail;
    }

    public String getName() {
        return mName;
    }

    public String getEmail() {
        return mEmail;
    }

}
