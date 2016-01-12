package com.example.jgallardo.smc_mp.registrys;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.jgallardo.smc_mp.R;

public class registry_general extends AppCompatActivity {

    Button ok;
    Button nc;
    Button cancel;
    Button save;
    ImageButton photo;
    EditText observations;

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

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
