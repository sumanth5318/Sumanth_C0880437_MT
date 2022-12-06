package com.example.sumanth_c0880437_mt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
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
    Double[] pricelist = {0.00,300.00,400.00,399.00,249.99,299.99,199.99,149.99};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        carmenulist = findViewById(R.id.spinner_carlist);
        daily_rent = findViewById(R.id.et_dailytrent);
        no_of_days = findViewById(R.id.txtvw_days);
        days = findViewById(R.id.seekbardays);
        details = findViewById(R.id.btn_view_details);
        total_amount = findViewById(R.id.txtvw_totalamount);
        ll_chkbox = findViewById(R.id.ll_options_chkbox);
        gps = findViewById(R.id.chkbox_gps);
        childseat = findViewById(R.id.chkbox_childseat);
        milage = findViewById(R.id.chkbox_mileage);
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
                double temp;
                no_of_days.setText(""+progress);
                temp = 1.13*progress*Double.parseDouble(daily_rent.getText().toString());
                total_amount.setText(""+String.format("%.2f", temp));
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
        ll_chkbox.setOnClickListener(view ->{
            if(gps.isChecked()){
                Toast.makeText(this,"5 $",Toast.LENGTH_SHORT).show();
            }else if(childseat.isChecked()){
                Toast.makeText(this,"7 $",Toast.LENGTH_SHORT).show();
            }else if(milage.isChecked()){
                Toast.makeText(this,"10 $",Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void onclickradiobtn(){
        switch (R.id.radiobtns_age){
            case 0:
                Toast.makeText(this, "age is less than 20", Toast.LENGTH_SHORT).show();
            case 1:
                Toast.makeText(this, "age is less than 60", Toast.LENGTH_SHORT).show();
            case 2:
                Toast.makeText(this, "age is less than 100", Toast.LENGTH_SHORT).show();
        }

    }
}