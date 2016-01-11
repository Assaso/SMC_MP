package com.example.jgallardo.smc_mp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jgallardo.smc_mp.met_mec.selection_met_mec;

public class login extends AppCompatActivity{

    Button login, cancel;
    EditText user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        login = (Button)findViewById(R.id.login_button);
        cancel = (Button)findViewById(R.id.cancel_button);

        user = (EditText)findViewById(R.id.get_user);
        pass = (EditText)findViewById(R.id.get_password);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user.getText().toString().equals("qc003") && pass.getText().toString().equals("qc16")){
                    Toast.makeText(getApplicationContext(), "Se ha iniciado sesión", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(login.this, selection_met_mec.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(getApplicationContext(), "Datos equibocados, favor de verificar", Toast.LENGTH_LONG).show();
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
