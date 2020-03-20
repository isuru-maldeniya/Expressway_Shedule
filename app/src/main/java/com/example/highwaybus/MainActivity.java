package com.example.highwaybus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
//        new AddData().setList();
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
    private static final String[] cities=new String[]{"Baduraliya","Kadawatha","Bulathsinhala","Gampaha","Nawinna(Maharagama)","Horana","Ingiriya", "Kaluthara","Katubedda(Moratuwa)","Matara","Mathugama","Panadura","Nittambuwa"};

    public void onClick(View view) {
        startActivity(new Intent(this,secondView.class));
    }

    public void onClick1(View view) {
        Log.d("appBus","not entered");
        Intent ti=new Intent(this,ExpandableList1.class);
        Log.d("appBus","not entered_1");
        startActivity(ti);
    }
}
