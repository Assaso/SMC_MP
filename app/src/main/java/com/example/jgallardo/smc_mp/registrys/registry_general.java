package com.example.jgallardo.smc_mp.registrys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.jgallardo.smc_mp.R;
import com.example.jgallardo.smc_mp.camera.camera_smc;

public class registry_general extends AppCompatActivity {

    Button ok;
    Button nc;
    Button cancel;
    Button save;
    ImageButton photo;
    EditText observations;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registry_general);


        ok = (Button)findViewById(R.id.registry_ok);
        nc = (Button)findViewById(R.id.registry_nc);
        cancel = (Button)findViewById(R.id.registry_cancel);
        save = (Button)findViewById(R.id.registry_save);
        photo = (ImageButton)findViewById(R.id.registry_photo);

        observations = (EditText)findViewById(R.id.registry_observation_text);

        title = (TextView)findViewById(R.id.registry_description);

        Intent registry_selection = getIntent();
        Bundle b = registry_selection.getExtras();

        if(b != null){
            String x = b.getString("SELECTED");
            title.setText(x);
        }

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        photo.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(registry_general.this, camera_smc.class);
                startActivity(intent);
            }
        });
    }
}
