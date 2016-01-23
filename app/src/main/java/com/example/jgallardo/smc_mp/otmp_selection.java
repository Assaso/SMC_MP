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
                if(otmp_project.getText().toString().equals("")){
                    Toast toast = Toast.makeText(otmp_selection.this, "NO se ha declarado nombre de proyecto", Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    if(otmp_project.getText().toString().matches("OTMP-(([0-9]{2})?)-([0-9]{4})?$") || otmp_project.getText().toString().matches("OSMP-(([0-9]{2})?)-([0-9]{4})?$")){
                        project_serial = otmp_project.getText().toString();
                    }else{
                        if(otmp_project.getText().toString().matches("Stock") || otmp_project.getText().toString().matches("stock")){
                            identifier = "stock";
                            project_serial = set_name_stock();
                            project_serial = identifier + project_serial;
                        }else{
                            if (otmp_project.getText().toString().matches("Especial") || otmp_project.getText().toString().matches("especial")){
                                identifier = "especial";
                                project_serial = set_name_special();
                                project_serial = identifier + project_serial;
                            }else{
                                Toast toast = Toast.makeText(otmp_selection.this, "El proyecto introducido no coincide con un formato valido, favor de verificar", Toast.LENGTH_SHORT);
                                toast.show();
                            }
                        }
                    }
                }

                if(project_serial.equals("")){
                }else{
                    Intent intent = new Intent(otmp_selection.this, registry_data.class);
                    intent.putExtra("AREA", to_registry);
                    intent.putExtra("OTMP", project_serial);
                    startActivity(intent);
                }
            }
        });
    }

    public String set_name_stock(){
        String content;
        String total_files[];
        String temp_name;
        int count = 0;

        total_files = fileList();

        for(int i = 0; i <= total_files.length; i++){
            temp_name = total_files[i].substring(0,1);
            if(temp_name.equals("s")){
                count = count + 1;
            }
        }

        if(count <= 9){
            content = "0"+count;
        }else{
            content = ""+count;
        }

        return content;
    }

    public String set_name_special(){
        String content;
        String total_files[];
        String temp_name;
        int count = 0;

        total_files = fileList();

        for(int i = 0; i <= total_files.length; i++){
            temp_name = total_files[i].substring(0,1);
            if(temp_name.equals("e")){
                count = count + 1;
            }
        }

        if(count <= 9){
            content = "0"+count;
        }else{
            content = ""+count;
        }

        return content;
    }
}
