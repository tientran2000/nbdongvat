package com.example.nhanbietdongvat;

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

//            case R.id.btnhinhkhoi:
//                i = new Intent(this, NbHinhKhoi.class);
//                startActivity(i);
//                break;
//
//            case R.id.btndongvat:
//                i = new Intent(this, NbDongVat.class);
//                startActivity(i);
//                break;
//            case R.id.btnbekiemtra:
//                i = new Intent(this, BeKiemTra.class);
//                startActivity(i);
//                break;
        }
    }
}
