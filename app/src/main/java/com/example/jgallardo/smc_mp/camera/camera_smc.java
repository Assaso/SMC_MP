package com.example.jgallardo.smc_mp.camera;


import android.hardware.Camera;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.jgallardo.smc_mp.R;

public class camera_smc extends AppCompatActivity {

    ImageButton take_photo;

    private Camera registry_camera = null;

    @Override
    protected void onCreate(Bundle saveInstanceStatus){
        super.onCreate(saveInstanceStatus);
        setContentView(R.layout.camera_surface);

        take_photo = (ImageButton)findViewById(R.id.photo_button);

        try{
            registry_camera = Camera.open();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "Error al coectar a camara", Toast.LENGTH_SHORT).show();
        }

        if(registry_camera != null){
            CameraView registry_cameraView = new CameraView(this, registry_camera);
            FrameLayout camera_view = (FrameLayout)findViewById(R.id.photo);
            camera_view.addView(registry_cameraView);
        }

        take_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

}
