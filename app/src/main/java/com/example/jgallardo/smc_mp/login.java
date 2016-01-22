package com.example.jgallardo.smc_mp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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
                InputStream is = com.example.jgallardo.smc_mp.login.this.getResources().openRawResource(R.raw.users);
                BufferedReader br = new BufferedReader(new InputStreamReader(is));

                String content;
                int user_number = 0;
                String line;
                String parts[] = new String[0];
                String user_pass1[], user_pass2[], user_pass3[];
                try{
                    while((line = br.readLine()) != null){
                        content = line;
                        parts = content.split(":");
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }

                try{
                    is.close();
                    br.close();
                }catch (IOException ex){
                    ex.printStackTrace();
                }

                user_pass1 = parts[0].split("\\-");
                user_pass2 = parts[1].split("\\-");
                user_pass3 = parts[2].split("\\-");

                if (user.getText().toString().equals(user_pass1[0]) && pass.getText().toString().equals(user_pass1[1])){
                    user_number = 1;
                }else{
                    if (user.getText().toString().equals(user_pass2[0]) && pass.getText().toString().equals(user_pass2[1])){
                        user_number = 2;
                    }else{
                        if ( user.getText().toString().equals(user_pass3[0]) && pass.getText().toString().equals(user_pass3[1])){
                            user_number = 3;
                        }else{
                            Toast.makeText(getApplicationContext(), "Datos equibocados, favor de verificar", Toast.LENGTH_LONG).show();
                        }
                    }
                }

                if (user_number != 0) {
                    Intent intent = new Intent(com.example.jgallardo.smc_mp.login.this, start_screen.class);
                    intent.putExtra("NO", user_number);
                    startActivity(intent);
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
