package com.edavtyan.flashlight;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG_DIALOG_NOT_SUPPORTED = "dialog_notSupported";

    private static final int COLOR_OFF = Color.parseColor("#E65100");
    private static final int COLOR_ON = Color.parseColor("#33691E");

    private ImageView toggleView;
    private CustomCamera camera;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        WindowUtils.hideStatusBar(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        camera = new CustomCamera();
        toggleView = (ImageView) findViewById(R.id.toggleView);
        if (camera.hasSupport(this)) {
            syncFlashView();
        } else {
            new NotSupportedDialogFragment().show(getFragmentManager(), TAG_DIALOG_NOT_SUPPORTED);
        }
    }

    public void toggle(View view) {
        if (camera.isFlashlightEnabled()) {
            camera.setFlashlightEnabled(false);
        } else {
            camera.setFlashlightEnabled(true);
        }

        syncFlashView();
    }


    private void syncFlashView() {
        toggleView.setColorFilter(camera.isFlashlightEnabled() ? COLOR_ON : COLOR_OFF);
    }
}
