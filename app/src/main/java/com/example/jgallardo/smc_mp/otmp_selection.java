package com.example.jgallardo.smc_mp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class otmp_selection extends AppCompatActivity{

    int to_registry;
    String project_serial, identifier;
    EditText otmp_project;
    Button create, search;
    Spinner otmp_pendant_list;

    @Override
    protected void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);
        setContentView(R.layout.otmp_selection);

        Intent extras = getIntent();
        Bundle b = extras.getExtras();
        if (b != null){
            to_registry = b.getInt("area");
        }

        otmp_project = (EditText)findViewById(R.id.otmp_to_create);
        create = (Button)findViewById(R.id.create_registry);
        search = (Button)findViewById(R.id.search_registry);

        create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (otmp_project.getText().toString().equals("")) {
                    Toast toast = Toast.makeText(otmp_selection.this, "NO se ha declarado nombre de proyecto", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    project_serial = otmp_project.getText().toString();
                    Intent intent = new Intent(otmp_selection.this, registry_data.class);
                    intent.putExtra("AREA", to_registry);
                    intent.putExtra("OTMP", project_serial);
                    startActivity(intent);
                }
            }
        });
    }
}
