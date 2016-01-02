package com.edavtyan.flashlight;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private static final int COLOR_OFF = Color.parseColor("#E65100");
    private static final int COLOR_ON = Color.parseColor("#33691E");

    private ImageView toggleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        WindowUtils.hideStatusBar(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleView = (ImageView) findViewById(R.id.toggleView);
        syncFlashView();
    }

    public void toggle(View view) {
        if (CustomCamera.isFlashlightEnabled()) {
            CustomCamera.setFlashlightEnabled(false);
        } else {
            CustomCamera.setFlashlightEnabled(true);
        }

        syncFlashView();
    }

    private void syncFlashView() {
        toggleView.setColorFilter(CustomCamera.isFlashlightEnabled() ? COLOR_ON : COLOR_OFF);
    }
}
