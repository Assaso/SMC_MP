package com.example.jgallardo.smc_mp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jgallardo.smc_mp.met_mec.selection_met_mec;

import java.io.OutputStreamWriter;
import java.util.Calendar;

public class registry_data extends AppCompatActivity{

    TextView otmp, area;
    EditText description, date, quantity;
    Button today, create, cancel;
    int user;
    String project;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.registry_data);

        Intent extras = getIntent();
        Bundle b = extras.getExtras();
        if(b != null){
            user = b.getInt("AREA");
            project =  b.getString("OTMP");
        }

        otmp = (TextView)findViewById(R.id.otmp_show);
        area = (TextView)findViewById(R.id.area_show);
        description = (EditText)findViewById(R.id.description);
        date = (EditText)findViewById(R.id.start_date);
        quantity = (EditText)findViewById(R.id.quantity);
        today = (Button)findViewById(R.id.set_today);
        create = (Button)findViewById(R.id.create_data);
        cancel = (Button)findViewById(R.id.cancel_data);

        otmp.setText(project);
        if(user == 1){
            area.setText("METAL - MECANICA");
        }else{
            area.setText("ENSAMBLE");
        }

        today.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                String date_today = c.get(Calendar.DAY_OF_MONTH)+"/"+c.get(Calendar.MONTH)+"/"+c.get(Calendar.YEAR);
                date.setText(date_today);
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user == 1) {
                    try {
                        OutputStreamWriter osw = new OutputStreamWriter(openFileOutput(otmp.getText().toString() + ".txt", Context.MODE_PRIVATE));
                        osw.write(otmp.getText().toString() + ":" + description.getText().toString() + "-" + date.getText().toString() + "-?-" + "" + user + "-" + quantity.getText().toString() + ":0:0#?-0#?#?:0#?#?:0#?-0#?-0#?-0#?#?:0#?-0#?-0#?#?");
                        osw.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    Intent intent = new Intent(registry_data.this, selection_met_mec.class);
                    startActivity(intent);
                }else{

                }
            }
        });
    }
}
