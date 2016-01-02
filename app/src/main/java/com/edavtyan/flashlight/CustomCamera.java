package com.edavtyan.flashlight;

import android.content.Context;
import android.content.pm.PackageManager;
import android.hardware.Camera;

public final class CustomCamera {
    private CustomCamera() {};

    private static Camera camera;

    static {
        camera = Camera.open();
    }


    public static void setFlashlightEnabled(boolean enabled) {
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

    public static boolean hasSupport(Context context) {
        return context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH);
    }

    public static boolean isFlashlightEnabled() {
        return camera.getParameters().getFlashMode().equals(Camera.Parameters.FLASH_MODE_TORCH);
    }
}
