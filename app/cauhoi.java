package com.example.nhanbietdongvat;

public class cauhoi {
    public int id;
    public String loihoi;
    public byte [] dapan1;
    public byte [] dapan2;
    public byte [] dapan3;
    public byte [] dapan4;
    public int dapandung;
    public byte [] tiengkeu;

    public byte[] getTiengkeu() {
        return tiengkeu;
    }

    public void setTiengkeu(byte[] tiengkeu) {
        this.tiengkeu = tiengkeu;
    }

    public cauhoi() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoihoi() {
        return loihoi;
    }

    public void setLoihoi(String loihoi) {
        this.loihoi = loihoi;
    }

    public byte[] getDapan1() {
        return dapan1;
    }

    public void setDapan1(byte[] dapan1) {
        this.dapan1 = dapan1;
    }

    public byte[] getDapan2() {
        return dapan2;
    }

    public void setDapan2(byte[] dapan2) {
        this.dapan2 = dapan2;
    }

    public byte[] getDapan3() {
        return dapan3;
    }

    public void setDapan3(byte[] dapan3) {
        this.dapan3 = dapan3;
    }

    public byte[] getDapan4() {
        return dapan4;
    }

    public void setDapan4(byte[] dapan4) {
        this.dapan4 = dapan4;
    }

    public int getDapandung() {
        return dapandung;
    }

    public cauhoi(int id, String loihoi, byte[] dapan1, byte[] dapan2, byte[] dapan3, byte[] dapan4, int dapandung, byte[] tiengkeu) {
        this.id = id;
        this.loihoi = loihoi;
        this.dapan1 = dapan1;
        this.dapan2 = dapan2;
        this.dapan3 = dapan3;
        this.dapan4 = dapan4;
        this.dapandung = dapandung;
        this.tiengkeu = tiengkeu;
    }

    public cauhoi(int id, String loihoi, byte[] dapan1, byte[] dapan2, byte[] dapan3, byte[] dapan4, int dapandung) {
        this.id = id;
        this.loihoi = loihoi;
        this.dapan1 = dapan1;
        this.dapan2 = dapan2;
        this.dapan3 = dapan3;
        this.dapan4 = dapan4;
        this.dapandung = dapandung;
    }

    public void setDapandung(int dapandung) {
        this.dapandung = dapandung;
    }
}
