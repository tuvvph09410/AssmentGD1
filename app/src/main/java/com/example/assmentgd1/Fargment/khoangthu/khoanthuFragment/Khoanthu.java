package com.example.assmentgd1.Fargment.khoangthu.khoanthuFragment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Khoanthu {
    private String MaKT;
    private String NameKT;
    private String MaLT;
    private int SoTien;
    private String NgayThu;
    public Khoanthu(){};
    public Khoanthu(String maKT, String nameKT, String maLT, int soTien, String ngayThu) {
        MaKT = maKT;
        NameKT = nameKT;
        MaLT = maLT;
        SoTien = soTien;
        NgayThu = ngayThu;
    }

    public String getMaKT() {
        return MaKT;
    }

    public void setMaKT(String maKT) {
        MaKT = maKT;
    }

    public String getNameKT() {
        return NameKT;
    }

    public void setNameKT(String nameKT) {
        NameKT = nameKT;
    }

    public String getMaLT() {
        return MaLT;
    }

    public void setMaLT(String maLT) {
        MaLT = maLT;
    }

    public int getSoTien() {
        return SoTien;
    }

    public void setSoTien(int soTien) {
        SoTien = soTien;
    }

    public String getNgayThu() {
        return NgayThu;
    }

    public void setNgayThu(String ngayThu) {
        NgayThu = ngayThu;
    }
    public String getDateFormat(Date d)
    {
        SimpleDateFormat dft=new
                SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        return dft.format(d);
    }
}
