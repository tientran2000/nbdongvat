package com.example.nhanbietdongvat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phatnhac();
        ImageButton imgnb = (ImageButton) findViewById(R.id.imgtgdv);
        ImageButton imgkt = (ImageButton) findViewById(R.id.imgkiemtra);


        imgnb.setOnClickListener(this);
        imgkt.setOnClickListener(this);

    }
    public void amthanh(int nhac) {
        mediaPlayer = MediaPlayer.create(this, nhac);
        mediaPlayer.start();
    }
    public void phatnhac(){
        amthanh(R.raw.nhacnen);


    }
    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.imgkiemtra:
                i = new Intent(this, Kiemtra.class);
                startActivity(i);
                break;

            case R.id.imgtgdv:
                i = new Intent(this, Chonchude.class);
                startActivity(i);
                break;

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
