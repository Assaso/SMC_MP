package com.example.jgallardo.smc_mp.met_mec;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jgallardo.smc_mp.R;
import com.example.jgallardo.smc_mp.inspections.wleding_selection;
import com.example.jgallardo.smc_mp.list_adapter;

import java.util.ArrayList;

public class selection_met_mec extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle saveInstanceStatus){
        super.onCreate(saveInstanceStatus);
        setContentView(R.layout.met_mec_selection_screen);

        ArrayList<met_mec_source> object = new ArrayList<>();

        object.add(new met_mec_source("Habilitado", R.color.darkRedMP));
        object.add(new met_mec_source("Armado", R.color.darkRedMP));
        object.add(new met_mec_source("Soldadura", R.color.darkRedMP));
        object.add(new met_mec_source("Pintura", R.color.darkRedMP));

        ListView met_mec_list = (ListView) findViewById(R.id.met_mec_list);
        met_mec_list.setAdapter(new list_adapter(this, R.layout.list_text_only, object) {

            @Override
            protected void onEntrance(Object in, View view) {
                if (in != null) {
                    TextView area = (TextView) view.findViewById(R.id.area);
                    if (area != null) {
                        area.setText(((met_mec_source) in).getAdd_item());
                        area.setBackgroundColor(((met_mec_source) in).getAdd_color());
                    }
                }
            }
        });
        
        met_mec_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                met_mec_source selected = (met_mec_source) parent.getItemAtPosition(position);
                String text = selected.getAdd_item();
                if (text.equals("Soldadura")) {
                    Intent intent = new Intent(selection_met_mec.this, wleding_selection.class);
                    startActivity(intent);
                }
            }
        });

    }
}
