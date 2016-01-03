package com.edavtyan.flashlight;

import android.app.Application;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        CustomCamera camera = new CustomCamera();
        if (camera.hasSupport(this) && !camera.isFlashlightEnabled()) {
            camera.setFlashlightEnabled(true);
        }
    }
}
