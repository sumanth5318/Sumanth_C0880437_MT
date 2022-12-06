package com.example.sumanth_c0880437_mt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Spinner carmenulist;
    EditText daily_rent;
    TextView no_of_days;
    SeekBar days;
    Button details;
    TextView total_amount;
    LinearLayout ll_chkbox;
    CheckBox gps;
    CheckBox childseat;
    CheckBox milage;
    RadioButton young;
    RadioButton middle;
    RadioButton old;
    int options_price= 0;
    Double[] pricelist = {0.00,300.00,400.00,399.00,249.99,299.99,199.99,149.99};
    double temp = 0.00;
    int noofdays ;
    int rent;
    String age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        carmenulist = findViewById(R.id.spinner_carlist);
        daily_rent = findViewById(R.id.et_dailytrent);
        no_of_days = findViewById(R.id.txtvw_days);
        days = findViewById(R.id.seekbardays);
        total_amount = findViewById(R.id.txtvw_totalamount);
        ll_chkbox = findViewById(R.id.ll_options_chkbox);
        gps = findViewById(R.id.chkbox_gps);
        childseat = findViewById(R.id.chkbox_childseat);
        milage = findViewById(R.id.chkbox_mileage);
        young = findViewById(R.id.radio_young);
        middle = findViewById(R.id.radio_middle);
        old = findViewById(R.id.radio_old);
        details = findViewById(R.id.btn_view_details);
        carmenulist.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        daily_rent.setText(""+pricelist[i]);
                    case 1:
                        daily_rent.setText(""+pricelist[i]);
                    case 2:
                        daily_rent.setText(""+pricelist[i]);
                    case 3:
                        daily_rent.setText(""+pricelist[i]);
                    case 4:
                        daily_rent.setText(""+pricelist[i]);
                    case 5:
                        daily_rent.setText(""+pricelist[i]);
                    case 6:
                        daily_rent.setText(""+pricelist[i]);
                    case 7:
                        daily_rent.setText(""+pricelist[i]);
                    case 8:
                        daily_rent.setText(""+pricelist[i]);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        days.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress,
                                          boolean fromUser) {
                no_of_days.setText(""+progress);
                noofdays = progress;
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Started days selection", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, "Selection Stopped", Toast.LENGTH_SHORT).show();
            }
        });
        onclickradiobtn();
        checked();
        details.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("Total_amount",temp);
            intent.putExtra("car_model",carmenulist.getSelectedItem().toString());
            intent.putExtra("days",noofdays);
            intent.putExtra("age",age);
//            intent.putExtra("total amount",temp);
            startActivity(intent);
        });
    }
    public void onclickradiobtn(){
        young.setOnClickListener(view -> {
            if(young.isChecked()){
                rent = 5;
                temp = noofdays*(Double.parseDouble(daily_rent.getText().toString())+rent);
                age = "Below 20 years";
            }
        });
        middle.setOnClickListener(view -> {
            if(middle.isChecked()){
                rent = 7;
                temp = noofdays*(Double.parseDouble(daily_rent.getText().toString()));
                age = "Between 21 to 60";
            }
        });
        old.setOnClickListener(view -> {
            if(old.isChecked()){
                rent = 10;
                temp = noofdays*(Double.parseDouble(daily_rent.getText().toString())-rent);
                age = "Above 60";
            }
        });
    }
    public void checked(){
        gps.setOnClickListener(view ->  {
            if(gps.isChecked()){
                Toast.makeText(this,"5$",Toast.LENGTH_SHORT).show();
                options_price += 5;
                temp += options_price;
                temp = 1.13*temp;
                total_amount.setText(""+String.format("%.2f", temp));
            }
        });
        childseat.setOnClickListener(view ->  {
            if(childseat.isChecked()){
                Toast.makeText(this,"7$",Toast.LENGTH_SHORT).show();
                options_price += 7;
                temp = 1.13*temp;
                total_amount.setText(""+String.format("%.2f", temp));
            }
        });
        milage.setOnClickListener(view ->  {
            if(milage.isChecked()){
                Toast.makeText(this,"9$",Toast.LENGTH_SHORT).show();
                options_price += 10;
                temp = 1.13*temp;
                total_amount.setText(""+String.format("%.2f", temp));
            }
        });
    }
}