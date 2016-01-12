package com.example.jgallardo.smc_mp.camera;


import android.app.ActionBar;
import android.app.Activity;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.example.jgallardo.smc_mp.R;

public class camera_smc extends Activity {

    private Camera registry_camera = null;
    private CameraView registry_cameraview = null;

    @Override
    protected void onCreate(Bundle saveInstanceStatus){
        super.onCreate(saveInstanceStatus);
        setContentView(R.layout.camera_surface);


        try{
            registry_camera = Camera.open();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Error al coectar a camara", Toast.LENGTH_SHORT).show();
        }

        if(registry_camera != null){
            registry_cameraview = new CameraView(this, registry_camera);
            FrameLayout camera_view = (FrameLayout)findViewById(R.id.photo);
            camera_view.addView(registry_cameraview);
        }


    }

}
