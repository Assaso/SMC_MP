package com.example.jgallardo.smc_mp.registrys;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.jgallardo.smc_mp.R;
import com.example.jgallardo.smc_mp.inspections.wleding_selection;

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

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String elegido = extras.getString(wleding_selection.ELEGIDO, "");

        final boolean title = requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);

        setContentView(R.layout.registry_general);

        if(title){
            getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.titlebar);
        }

        final TextView titletext = (TextView)findViewById(R.id.titletext);
        if(titletext != null){
            titletext.setText(elegido);
        }

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
