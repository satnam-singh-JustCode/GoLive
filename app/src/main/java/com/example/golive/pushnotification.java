package com.example.golive;

import android.app.Application;

import com.onesignal.OneSignal;

public class pushnotification extends Application {
    private static final String ONESIGNAL_APP_ID = "fe77708f-cd28-4b6f-b33e-4d1f3dabfc8b";
    @Override
    public void onCreate() {
        super.onCreate();

        // Enable verbose OneSignal logging to debug issues if needed.
        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE);

        // OneSignal Initialization
        OneSignal.initWithContext(this);
        OneSignal.setAppId(ONESIGNAL_APP_ID);    }
}
