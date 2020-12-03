package com.example.nbdongvat;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class dongco extends AppCompatActivity {
    DatabaseHandler db = new DatabaseHandler(this);
    ArrayList<Dongvat> arrList = null;
    ArrayAdapter<Dongvat> adap = null;
    Dongvat ob = new Dongvat();

    private ListView lv;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dongco);

        db.copyDB2SDCard();

        anhxa();
        LoadQuestion();
// ấn vào lisview thì nó đọc
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent it=new Intent(dongco.this,chitietthunuoi.class);
                it.putExtra("iddv",arrList.get(position).getId());
                startActivity(it);
                overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
            }
        });
    }

    public void anhxa() {
        lv = (ListView) findViewById(R.id.lvdongco);
    }

    public void LoadQuestion() {
//        Doc();
        arrList = new ArrayList<Dongvat>();
        Dongvat row;
        // Cursor c = db.getCursor("select * from tbDongVat");
        Cursor c = db.getCursor("select * from DongVat where chude ='dongco'");
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
