package com.example.nbdongvat;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class Kiemtra extends AppCompatActivity {
    DatabaseHandler db = new DatabaseHandler(this);
    ArrayList<cauhoi> listCauHoi = null;
    private TextView tvCauHoi;
    ImageButton DaA, DaB, DaC, DaD,doc,tiengkeu,trangchu;
    int Dapandung, i;
    MediaPlayer mediaPlayer,md;
    TextToSpeech textToSpeech;
    Dialog dialog;
    int luotchoi=2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kiemtra);

        AnhXa();
        LoadQuestion();event();
        ViewQuestion(i++);

    }

    public void AnhXa() {
        DaA = (ImageButton) findViewById(R.id.dapanA);
        DaB = (ImageButton) findViewById(R.id.dapanB);
        DaC = (ImageButton) findViewById(R.id.dapanC);
        DaD = (ImageButton) findViewById(R.id.dapanD);
        tvCauHoi = (TextView) findViewById(R.id.tvloihoi);
        doc=findViewById(R.id.nghecauhoi);
        tiengkeu=findViewById(R.id.nghetiengkeu);
        trangchu=findViewById(R.id.trangchu);
    }
    public void event(){
        doc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Doc();
                md.pause();
            }
        });

        trangchu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it=new Intent(Kiemtra.this,MainActivity.class);
                startActivity(it);
            }
        });
        tiengkeu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(md!=null){
                md.release();
            }
            int resId=getResources().getIdentifier(listCauHoi.get(i-1).getTiengkeu(),"raw",getPackageName());
            md=MediaPlayer.create(Kiemtra.this,resId);
            md.start();
            }
        });
    }

public void LoadQuestion() {
    db.copyDB2SDCard();
    cauhoi ch;
    listCauHoi=new ArrayList<cauhoi>();
    String sql = "select * from cauhoi ";
    Cursor c = db.getCursor(sql);
    c.moveToFirst();
    while (!c.isAfterLast()) {

        ch = new cauhoi();
        ch.id=c.getInt(0);
        ch.loihoi=c.getString(1);
        ch.dapan1=c.getBlob(2);
        ch.dapan2=c.getBlob(3);
        ch.dapan3=c.getBlob(4);
        ch.dapan4=c.getBlob(5);
        ch.dapandung=c.getInt(6);
        ch.tiengkeu=c.getString(7);
        listCauHoi.add(ch);
        c.moveToNext();
    }
    //randomQ(listCauHoi);
}

    public cauhoi randomQ(ArrayList<cauhoi> questions) {
        cauhoi q;
        Random rd = new Random();
        if (questions.size() > 0) {
            int cs = rd.nextInt(questions.size());
            q = questions.get(cs);
            questions.remove(cs);
            return q;
        }
        return null;
    }

    public void ViewQuestion( int i) {


        Doc();
        tvCauHoi.setText(listCauHoi.get(i).getLoihoi());
        Bitmap a = BitmapFactory.decodeByteArray(listCauHoi.get(i).getDapan1(), 0, listCauHoi.get(i).getDapan1().length);
        DaA.setImageBitmap(a);
        DaA.setEnabled(true);

        Bitmap b = BitmapFactory.decodeByteArray(listCauHoi.get(i).getDapan2(), 0, listCauHoi.get(i).getDapan2().length);
        DaB.setImageBitmap(b);
        DaB.setEnabled(true);

        Bitmap c = BitmapFactory.decodeByteArray(listCauHoi.get(i).getDapan3(), 0, listCauHoi.get(i).getDapan3().length);
        DaC.setImageBitmap(c);
        DaC.setEnabled(true);
        Bitmap d = BitmapFactory.decodeByteArray(listCauHoi.get(i).getDapan4(), 0, listCauHoi.get(i).getDapan4().length);
        DaD.setImageBitmap(d);
        DaD.setEnabled(true);


        switch (listCauHoi.get(i).getDapandung()) {
            case 1:
                Dapandung = R.id.dapanA;
                break;
            case 2:
                Dapandung = R.id.dapanB;
                break;
            case 3:
                Dapandung = R.id.dapanC;
                break;
            case 4:
                Dapandung = R.id.dapanD;
                break;
        }//day la dung sai

    }
    public void animnButon(ImageButton btn) {
        Animation animationButton = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.nhay);
        btn.startAnimation(animationButton);
    }
    public void amthanh(int nhac) {
        mediaPlayer = MediaPlayer.create(this, nhac);
        mediaPlayer.start();
    }

    public void Ketthuc() {
        dialog = new Dialog(this, android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar_MinWidth);
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View view = layoutInflater.inflate(R.layout.activity_ketthuc, null);
        TextView tvFinish = (TextView) view.findViewById(R.id.ketthuc);
        amthanh(R.raw.ketthuc);
        Button btnFinish = (Button) view.findViewById(R.id.btnFinish);
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                dialog.dismiss();
            }
        });
        dialog.setCancelable(false);
        dialog.setContentView(view);
        dialog.show();
    }
    public void OnClick(View v) {
        switch (v.getId()) {

            case R.id.dapanA:
                md.pause();
                if (R.id.dapanA != Dapandung) {

                    if(luotchoi>0){
                        luotchoi = luotchoi - 1;
                    }
                    else if(luotchoi==0){
                        Ketthuc();
                    }

                    amthanh(R.raw.thuacuoc);
                } else {
                    animnButon(DaA);
                    amthanh(R.raw.traloidung);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ViewQuestion(i++);
                        }
                    }, 2500);
                }
                break;
            case R.id.dapanB:
                md.pause();
                if (R.id.dapanB != Dapandung) {

                    if(luotchoi>0){
                        luotchoi = luotchoi - 1;
                    }
                    else if(luotchoi==0){
                        Ketthuc();
                    }

                    amthanh(R.raw.thuacuoc);
                } else {
                    animnButon(DaB);
                    amthanh(R.raw.traloidung);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ViewQuestion(i++);
                        }
                    }, 2500);
                }
                break;

            case R.id.dapanC:
                md.pause();
                if (R.id.dapanC != Dapandung) {

                    if(luotchoi>0){
                        luotchoi = luotchoi - 1;
                    }
                    else if(luotchoi==0){
                        Ketthuc();
                    }

                    amthanh(R.raw.thuacuoc);
                } else {
                    animnButon(DaC);
                    amthanh(R.raw.traloidung);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ViewQuestion(i++);
                        }
                    }, 2500);
                }
                break;
            case R.id.dapanD:
                md.pause();
                if (R.id.dapanD != Dapandung) {

                    if(luotchoi>0){
                        luotchoi = luotchoi - 1;
                    }
                    else if(luotchoi==0){
                        Ketthuc();
                    }

                    amthanh(R.raw.thuacuoc);
                } else {
                    animnButon(DaD);
                    amthanh(R.raw.traloidung);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ViewQuestion(i++);
                        }
                    }, 1500);
                }
                break;
        }
    }
    public void Doc() {
        textToSpeech = new TextToSpeech(Kiemtra.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.ROOT);
                } else {
                    Toast.makeText(Kiemtra.this, "Errol", Toast.LENGTH_LONG).show();
                }
                if (tvCauHoi != null) {
                    textToSpeech.speak(tvCauHoi.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
                }

            }
        });
    }

}
