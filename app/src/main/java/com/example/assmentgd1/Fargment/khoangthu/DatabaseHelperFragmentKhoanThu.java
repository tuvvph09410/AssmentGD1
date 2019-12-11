package com.example.assmentgd1.Fargment.khoangthu;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.assmentgd1.Fargment.khoangthu.LoaiThuFragment.LTFragment;

public class DatabaseHelperFragmentKhoanThu extends SQLiteOpenHelper {
   public DatabaseHelperFragmentKhoanThu(Context context) {
        super(context, "dbChiTieu", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableLoaiThu = "create table Loaithu (maLT text primary key, tenLT text)";
        String createTableKhoanThu = "create table Khoanthu (maKT text primary key, " +
                "tenKT text, maLT text, soTien decimal, ngayThu text)";
        db.execSQL(createTableKhoanThu);
        db.execSQL(createTableLoaiThu);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists KhoanThu");
        db.execSQL("drop table if exists LoaiThu");
        onCreate(db);
    }
}
