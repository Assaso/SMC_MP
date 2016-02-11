package com.example.jgallardo.smc_mp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class start_screen extends AppCompatActivity {

    int carry_user;
    String welcome;
    TextView user_welcome;
    Button registry, up, measure, inspections;

    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.start_screen);

        Intent extras = getIntent();
        Bundle b = extras.getExtras();
        if (b != null) {
            carry_user = b.getInt("NO");
        }

        user_welcome = (TextView)findViewById(R.id.title_grething);
        registry = (Button)findViewById(R.id.edit_registry);
        up = (Button)findViewById(R.id.up_registry);
        measure = (Button)findViewById(R.id.measure_registry);
        inspections = (Button)findViewById(R.id.inspections_in);

        welcome = "Bienvenido ";
        if (carry_user == 1){
            welcome = welcome + "Jefe de calidad";
            registry.setText("Resultados Metal-Mecanica");
            up.setText("Resultados Ensamble");
            measure.setText("Indicadores de equipos de medición");
            inspections.setVisibility(View.GONE);

        }else{
            if (carry_user == 2){
                welcome = welcome+ "Ruben Guajardo";
            }else{
                if (carry_user == 3){
                    welcome = welcome + "Ensamble";
                }
            }
        }

        user_welcome.setText(welcome);

        registry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (carry_user == 1){
                    Toast toast = Toast.makeText(start_screen.this, "Esta caracteristica no esta implementada aún", Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    if (carry_user == 2){
                        Intent intent = new Intent(start_screen.this, otmp_selection.class);
                        intent.putExtra("area", carry_user);
                        startActivity(intent);
                    }else{
                        if (carry_user == 3){
                        Intent intent = new Intent(start_screen.this, otmp_selection.class);
                            intent.putExtra("area", carry_user);
                            startActivity(intent);
                        }
                    }
                }
            }
        });

    }
}
