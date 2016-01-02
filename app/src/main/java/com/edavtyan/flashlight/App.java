package com.edavtyan.flashlight;

import android.app.Application;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        if (!CustomCamera.isFlashlightEnabled()) {
            CustomCamera.setFlashlightEnabled(true);
        }
    }
}
