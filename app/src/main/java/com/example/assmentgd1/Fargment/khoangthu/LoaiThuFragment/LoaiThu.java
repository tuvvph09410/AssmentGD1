package com.example.assmentgd1.Fargment.khoangthu.LoaiThuFragment;

public class LoaiThu {
    private String MaLT;
    private String NameLT;
    public LoaiThu (){}

    public LoaiThu(String maLT, String nameLT) {
        MaLT = maLT;
        NameLT = nameLT;
    }

    public String getMaLT() {
        return MaLT;
    }

    public void setMaLT(String maLT) {
        MaLT = maLT;
    }

    public String getNameLT() {
        return NameLT;
    }

    public void setNameLT(String nameLT) {
        NameLT = nameLT;
    }
}
