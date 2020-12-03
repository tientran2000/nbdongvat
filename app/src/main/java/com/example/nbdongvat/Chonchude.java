package com.example.nbdongvat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Chonchude extends AppCompatActivity {
    ImageButton thunuoi,thurung,dvduoinuoc,contrung,longvu,dongco;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chonchude);
        thunuoi=(ImageButton) findViewById(R.id.thunuoi);
        thurung=(ImageButton) findViewById(R.id.thurung);
        dvduoinuoc=(ImageButton) findViewById(R.id.duoinuoc);
        contrung=(ImageButton) findViewById(R.id.dvkhac);
        longvu=(ImageButton) findViewById(R.id.longvu);
        dongco=(ImageButton) findViewById(R.id.dongco);

    }
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.thunuoi:
                i = new Intent(this, thunuoi.class);
                startActivity(i);

                break;

            case R.id.thurung:
                i = new Intent(this, thurung.class);
                startActivity(i);

                break;

            case R.id.duoinuoc:
                i = new Intent(this, dvduoinuoc.class);
                startActivity(i);
                break;
            case R.id.longvu:
                i = new Intent(this, longvu.class);
                startActivity(i);
                break;
            case R.id.dvkhac:
                i = new Intent(this, dvkhac.class);
                startActivity(i);
                break;
            case R.id.dongco:
                i = new Intent(this, dongco.class);
                startActivity(i);
                break;
        }
    }
}
