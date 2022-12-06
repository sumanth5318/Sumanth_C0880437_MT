package com.example.sumanth_c0880437_mt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView amount;
    TextView days;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        amount = findViewById(R.id.txtvw_amount);
        days = findViewById(R.id.txtvw_days);
        Double ans = getIntent().getDoubleExtra("Total_amount",0.00);
        int daysno =  getIntent().getIntExtra("days",0);
        amount.setText(""+String.format("%.2f", ans));
        days.setText(""+daysno);
    }
}