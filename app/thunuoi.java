package com.example.nhanbietdongvat;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class thunuoi extends AppCompatActivity {
    DatabaseHandler db = new DatabaseHandler(this);
    ArrayList<Dongvat> arrList = null;
    ArrayAdapter<Dongvat> adap = null;
    Dongvat ob = new Dongvat();

    private ListView lv;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thunuoi);

            db.copyDB2SDCard();

        anhxa();
        LoadQuestion();
// ấn vào lisview thì nó đọc
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it=new Intent(thunuoi.this,chitietthunuoi.class);
                startActivity(it);

            }
        });
    }

    public void anhxa() {
        lv = (ListView) findViewById(R.id.lvthunuoi);
    }

    public void LoadQuestion() {
//        Doc();
        arrList = new ArrayList<Dongvat>();
        Dongvat row;
        // Cursor c = db.getCursor("select * from tbDongVat");
        Cursor c = db.getCursor("select * from DongVat where chude ='thunuoi'");
        c.moveToFirst();
        while (!c.isAfterLast()) {
            row = new Dongvat();
            row.id = c.getInt(0);
            row.ten = c.getString(1);
            row.anh = c.getBlob(2);
            arrList.add(row);
            c.moveToNext();
        }
        adap = new DongvatAdapter(this, R.layout.itemdv, arrList);
        lv.setAdapter(adap);
        adap.notifyDataSetChanged();
        registerForContextMenu(lv);
        c.close();
    }

}
