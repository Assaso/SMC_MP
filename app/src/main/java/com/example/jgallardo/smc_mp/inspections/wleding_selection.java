package com.example.jgallardo.smc_mp.inspections;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jgallardo.smc_mp.R;
import com.example.jgallardo.smc_mp.list_adapter;
import com.example.jgallardo.smc_mp.registrys.registry_general;

import java.util.ArrayList;

public class wleding_selection extends AppCompatActivity{

    public final static String ELEGIDO = "elegido";

    @Override
    protected void onCreate(Bundle saveInstancesStatus){
        super.onCreate(saveInstancesStatus);
        setContentView(R.layout.wleding_selecction_screen);

        ArrayList<inspections_source> object = new ArrayList<>();

        object.add(new inspections_source("Inspección visual", R.drawable.logo));
        object.add(new inspections_source("Porosidad", R.drawable.logo));
        object.add(new inspections_source("Fisuras", R.drawable.logo));
        object.add(new inspections_source("Acabado", R.drawable.logo));

        ListView wleding_list = (ListView) findViewById(R.id.wleding_list);
        wleding_list.setAdapter(new list_adapter(this, R.layout.list_text_image1_sameline, object) {

            @Override
            protected void onEntrance(Object in, View view) {
                if (in != null) {
                    TextView inspecction = (TextView) view.findViewById(R.id.inspecction);
                    if (inspecction != null)
                        inspecction.setText(((inspections_source) in).getAdd_item());
                    ImageView inspection_status = (ImageView) view.findViewById(R.id.inspection_status);
                    if (inspection_status != null)
                        inspection_status.setImageResource(((inspections_source) in).getAdd_image());
                }
            }
        });

       wleding_list.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id){
                inspections_source elegido = (inspections_source) pariente.getItemAtPosition(posicion);
                String text = elegido.getAdd_item();
                Toast toast = Toast.makeText(wleding_selection.this, text, Toast.LENGTH_LONG);
                toast.show();
                Intent intent = new Intent(wleding_selection.this, registry_general.class);
                intent.putExtra("SELECTED", text);
                startActivity(intent);
            }
       });
    }
}
