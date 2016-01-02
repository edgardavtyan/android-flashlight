package com.edavtyan.flashlight;

import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

public final class WindowUtils {
    private WindowUtils() {};

    public static void hideStatusBar(AppCompatActivity activity) {
        activity.requestWindowFeature(Window.FEATURE_NO_TITLE);
        activity.getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }
}
