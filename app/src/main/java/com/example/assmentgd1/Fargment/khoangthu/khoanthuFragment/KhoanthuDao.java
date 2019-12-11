package com.example.assmentgd1.Fargment.khoangthu.khoanthuFragment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.assmentgd1.Fargment.khoangthu.DatabaseHelperFragmentKhoanThu;

import java.util.ArrayList;
import java.util.List;

public class KhoanthuDao {
    private SQLiteDatabase sqLiteDatabase;
    private DatabaseHelperFragmentKhoanThu databaseHelperFragmentKhoanThu;
    private Context context;
    public KhoanthuDao (Context context){
        this.context=context;
        databaseHelperFragmentKhoanThu=new DatabaseHelperFragmentKhoanThu(context);
        sqLiteDatabase=databaseHelperFragmentKhoanThu.getWritableDatabase();
    }
    public Boolean InsertKhoanThu(Khoanthu khoanthu){
        try {
            ContentValues values=new ContentValues();
            values.put("maKT",khoanthu.getMaKT());
            values.put("tenKT",khoanthu.getNameKT());
            values.put("maLT",khoanthu.getMaLT());
            values.put("soTien",khoanthu.getSoTien());
            values.put("ngayThu",khoanthu.getNgayThu());
            long numInsert=sqLiteDatabase.insert("Khoanthu",null,values);
            if (numInsert <=0){
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public List<Khoanthu> getAllKhoanthu(){
        List<Khoanthu> khoanthuList=new ArrayList<>();
        String sql=" SELECT * FROM " + "Khoanthu";
        Cursor cursor=sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst()){
            do {
                Khoanthu khoanthu=new Khoanthu();
                khoanthu.setMaKT(cursor.getString(0));
                khoanthu.setNameKT(cursor.getString(1));
                khoanthu.setMaLT(cursor.getString(2));
                khoanthu.setSoTien(cursor.getInt(3));
                khoanthu.setNgayThu(cursor.getString(4));
                khoanthuList.add(khoanthu);
                } while (cursor.moveToNext());
        }
        return khoanthuList ;
    }
    public long updateKhoanthu(Khoanthu khoanthu){
        ContentValues values=new ContentValues();
        values.put("maKT",khoanthu.getMaKT());
        values.put("tenKT",khoanthu.getNameKT());
        values.put("maLT",khoanthu.getMaLT());
        values.put("soTien",khoanthu.getSoTien());
        values.put("ngayThu",khoanthu.getNgayThu());
        long numUpdate=sqLiteDatabase.update("Khoanthu",values,"maKT"+"=?",new String[]{khoanthu.getMaKT()});
        return numUpdate;
    }
    public long deleteKhoanthu(String makt){
        long numDelete=sqLiteDatabase.delete("Khoanthu","maKT"+"=?",new String[]{makt});
        return numDelete;
    }
}
