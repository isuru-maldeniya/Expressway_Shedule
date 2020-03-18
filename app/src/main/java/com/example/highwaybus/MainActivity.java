package com.example.highwaybus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button swap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final AutoCompleteTextView actv1=(AutoCompleteTextView) findViewById(R.id.startText);
        final AutoCompleteTextView actv2=(AutoCompleteTextView) findViewById(R.id.desText);
        swap=findViewById(R.id.swapBtn);
        swap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s=actv1.getText().toString();
                actv1.setText(actv2.getText().toString());
                actv2.setText(s);
            }
        });
        actv1.setThreshold(1);
        actv2.setThreshold(1);

        ArrayAdapter<String>adpt1=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,cities);
        actv1.setAdapter(adpt1);


        ArrayAdapter<String>adpt2=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,cities);
        actv2.setAdapter(adpt2);

        actv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actv1.showDropDown();
            }
        });


        actv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actv2.showDropDown();
            }
        });
    }
    private static final String[] cities=new String[]{"Katunayake","Ja-Ela","Kerawalapitiya","Kadawatha","Kaduwela","Kothalawala","Athurugiriya", "Kottawa","Kahathuduwa","Dodangoda","Gelanigama","Welipenna","KurudugahaHAthamma", "Baddegama","Pinnaduwa","Imaduwa","Kokmaduwa","Godagama","beliaththa","Kasagala","AgunukolaPalassa","Barawakubura","Suriyawewa","Andarawewa"};

    public void onClick(View view) {
        Intent si=new Intent(this,secondView.class);
        startActivity(si);
    }
}
