package com.example.jgallardo.smc_mp.camera;

import android.content.Context;
import android.hardware.Camera;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;


public class CameraView extends SurfaceView implements SurfaceHolder.Callback {

    private SurfaceHolder registry_holder;
    private Camera registry_camera;

    public CameraView(Context context, Camera camera){
        super(context);

        registry_camera = camera;
        registry_camera.setDisplayOrientation(90);
        registry_holder = getHolder();
        registry_holder.addCallback(this);
        registry_holder.setType(SurfaceHolder.SURFACE_TYPE_NORMAL);
    }

    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        try{
            registry_camera.setPreviewDisplay(surfaceHolder);
            registry_camera.startPreview();
        }catch (IOException e){
            Log.d("ERROR", "No se encontro la camara" + e.getMessage());
        }
    }
//
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        if(registry_holder.getSurface() == null)
            return;

            try{
                registry_camera.stopPreview();
            }catch (Exception e){

            }

            try {
                registry_camera.setPreviewDisplay(registry_holder);
                registry_camera.startPreview();
            }catch (IOException e){

            }
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        registry_camera.startPreview();
        registry_camera.release();
    }
}
