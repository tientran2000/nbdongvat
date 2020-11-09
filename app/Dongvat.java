package com.example.nhanbietdongvat;

import java.io.Serializable;

public class Dongvat implements Serializable {
    public Dongvat(int id, String ten, byte[] anh, byte[] tiengkeu, String chude) {
        this.id = id;
        this.ten = ten;
        this.anh = anh;
        this.tiengkeu = tiengkeu;
        this.chude = chude;
    }

    int id;

    public Dongvat() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public byte[] getAnh() {
        return anh;
    }

    public void setAnh(byte[] anh) {
        this.anh = anh;
    }

    public byte[] getTiengkeu() {
        return tiengkeu;
    }

    public void setTiengkeu(byte[] tiengkeu) {
        this.tiengkeu = tiengkeu;
    }

    public String getChude() {
        return chude;
    }

    public void setChude(String chude) {
        this.chude = chude;
    }

    String ten;
    byte[] anh;
    byte [] tiengkeu;
    String chude;
}
