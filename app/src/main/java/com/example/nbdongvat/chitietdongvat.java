package com.example.nbdongvat;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;

import java.util.Locale;

public class chitietdongvat extends AppCompatActivity {
    TextView tendv;
    ImageView anh;
    ImageButton lui,tieng,docten,trangchu,tiep;
    int id;
    TextToSpeech textToSpeech;
    DatabaseHandler db=new DatabaseHandler(this);
    MediaPlayer md;
    Dongvat s;
    Drawable bt_thuong,bt_khong;
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chitietdongvat);
        anhxa();getDrawable();
        Event();
        db.copyDB2SDCard();
//        Bundle bundle = getIntent().getExtras();
//        id = bundle.getInt("iddv");
//        Cursor cursor = db.getCursor("SELECT * FROM dongvat where id ='" + id + "'");
//
//        cursor.moveToFirst();
//        s = new Dongvat();
//        s.setId(cursor.getInt(0));
//        s.setTen(cursor.getString(1));
//        s.setAnh(cursor.getBlob(2));
//        s.setTiengkeu(cursor.getString(3));
//        s.setChude(cursor.getString(4));
//
//        tendv.setText(""+s.getTen());
//        Bitmap a = BitmapFactory.decodeByteArray(s.getAnh(), 0, s.getAnh().length);
//        anh.setImageBitmap(a);
        //phattieng();
laydl();
        lui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dvTruoc();
            }
        });
        tiep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dvSau();
            }
        });

    }
    public void laydl(){
        Bundle bundle = getIntent().getExtras();
        id = bundle.getInt("iddv");
        Cursor cursor = db.getCursor("SELECT * FROM dongvat where id ='" + id + "'");

        cursor.moveToFirst();
        s = new Dongvat();
        s.setId(cursor.getInt(0));
        s.setTen(cursor.getString(1));
        s.setAnh(cursor.getBlob(2));
        s.setTiengkeu(cursor.getString(3));
        s.setChude(cursor.getString(4));

        tendv.setText(""+s.getTen());
        Bitmap a = BitmapFactory.decodeByteArray(s.getAnh(), 0, s.getAnh().length);
        anh.setImageBitmap(a);
    }
    private void getDrawable(){

        try {
            bt_thuong = AppCompatResources.getDrawable(this, R.drawable.loa);
            bt_khong=AppCompatResources.getDrawable(this, R.drawable.tatam);
        }
        catch (Exception ex) {
            Log.e("Error", "Exception loading drawable");}

    }
    public void Event(){
        docten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //laydl();
                if(!s.getTiengkeu().equals("")) {
                    phattieng();
                    if(!md.isPlaying()){

                        Doc();
                    }
                    if(md.isPlaying()){
                        md.pause();
                        Doc();
                    }
                    }
                if(s.getTiengkeu().equals("")){
                    Doc();
                }

            }
        });
        trangchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(chitietdongvat.this,MainActivity.class);
                startActivity(it);
                md.pause();
            }
        });
        tieng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
laydl();
                if(!s.getTiengkeu().equals("")) {
                    phattieng();
                    md.start();}
                if(s.getTiengkeu().equals("")){
                    //tieng.setImageDrawable(bt_khong);
                    tieng.setEnabled(false);
                }
            }
        });
    }
    public void phattieng(){

        if(md!=null){
            md.release();
        }
        int resId=getResources().getIdentifier(s.getTiengkeu(),"raw",getPackageName());
        md= MediaPlayer.create(chitietdongvat.this,resId);
    }
    public void anhxa(){
        tendv=findViewById(R.id.tvten);
        anh=findViewById(R.id.anhct);
        lui=findViewById(R.id.luilai);
        tieng=findViewById(R.id.nghetiengkeu);
        docten=findViewById(R.id.ngheten);
        trangchu=findViewById(R.id.trangchu);
        tiep=findViewById(R.id.tieptheo);
    }
    public void Doc() {
        textToSpeech = new TextToSpeech(chitietdongvat.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.ROOT);
                } else {
                    Toast.makeText(chitietdongvat.this, "Errol", Toast.LENGTH_LONG).show();
                }
                if (tendv != null) {
                    textToSpeech.speak(tendv.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
                }

            }
        });
    }
    }
