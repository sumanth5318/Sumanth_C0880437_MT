package com.example.sumanth_c0880437_mt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView amount;
    TextView days;
    TextView car_model;
    TextView age;
    TextView options;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        amount = findViewById(R.id.txtvw_amount);
        days = findViewById(R.id.txtvw_days);
        car_model = findViewById(R.id.txtvw_model);
        age = findViewById(R.id.txtvw_age);
        options = findViewById(R.id.options_txtvw);
        Double ans = getIntent().getDoubleExtra("Total_amount",0.00);
        int daysno =  getIntent().getIntExtra("days",0);
        String s = getIntent().getStringExtra("car_model");
        String s1 = getIntent().getStringExtra("age");
        String s2 = getIntent().getStringExtra("options");
        amount.setText(""+String.format("%.2f", ans));
        days.setText(""+daysno);
        car_model.setText(s);
        age.setText(s1);
        if(s2.isEmpty()){
            options.setText("No extra options selected");
        }else {
            options.setText(s2 + "  added to the car");
        }
    }
}