package com.example.highwaybus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class secondView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_view);
        final AutoCompleteTextView actv=findViewById(R.id.townText);

        ArrayAdapter<String> adpt1=new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,cities);
        actv.setAdapter(adpt1);

        actv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                actv.showDropDown();
            }
        });
    }

    private static final String[] cities=new String[]{"Baduraliya","Kadawatha","Bulathsinhala","Gampaha","Nawinna(Maharagama)","Horana","Ingiriya", "Kaluthara","Katubedda(Moratuwa)","Matara","Mathugama","Panadura","Nittambuwa"};
    public void toMain(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }
}
