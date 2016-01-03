package com.edavtyan.flashlight;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;

public class CustomCamera {
    private static Camera camera = null;


    public CustomCamera() {
        if (camera == null) camera = Camera.open();
    }

    public void setFlashlightEnabled(boolean enabled) {
        Camera.Parameters params = camera.getParameters();

        if (enabled) {
            params.setFlashMode(Camera.Parameters.FLASH_MODE_TORCH);
            camera.setParameters(params);
            camera.startPreview();
        } else {
            params.setFlashMode(Camera.Parameters.FLASH_MODE_OFF);
            camera.setParameters(params);
            camera.stopPreview();
        }
    }

    public boolean hasSupport(Context context) {
        return context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
    }

    public boolean isFlashlightEnabled() {
        return camera.getParameters().getFlashMode().equals(Camera.Parameters.FLASH_MODE_TORCH);
    }
}
