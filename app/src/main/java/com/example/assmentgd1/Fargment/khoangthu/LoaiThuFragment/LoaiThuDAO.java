package com.example.assmentgd1.Fargment.khoangthu.LoaiThuFragment;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.assmentgd1.Fargment.khoangthu.DatabaseHelperFragmentKhoanThu;

import java.util.ArrayList;
import java.util.List;

public class LoaiThuDAO {
    private SQLiteDatabase sqLiteDatabase;
    private DatabaseHelperFragmentKhoanThu databaseHelperFragmentKhoanThu;
    private Context context;
    public LoaiThuDAO(Context context){
        this.context=context;
        databaseHelperFragmentKhoanThu=new DatabaseHelperFragmentKhoanThu(context);
        sqLiteDatabase=databaseHelperFragmentKhoanThu.getWritableDatabase();
    }
    public boolean InsertLoaiThu(LoaiThu loaiThu){
        try {
            ContentValues values=new ContentValues();
            values.put("maLT",loaiThu.getMaLT());
            values.put("tenLT",loaiThu.getNameLT());
            long numInsert=sqLiteDatabase.insert("Loaithu",null,values);
            if (numInsert <=0){
                return false;
            }
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }
    public List<LoaiThu> GetAllLoaiThu(){
        List<LoaiThu> loaiThuList=new ArrayList<>();
        String sql=" SELECT * FROM " + "Loaithu";
        Cursor cursor=sqLiteDatabase.rawQuery(sql,null);
        if (cursor.moveToFirst()){
            do {
            LoaiThu loaiThu=new LoaiThu();
            loaiThu.setMaLT(cursor.getString(0));
            loaiThu.setNameLT(cursor.getString(1));
            loaiThuList.add(loaiThu);
            }while (cursor.moveToNext());
        }
    return loaiThuList;
    }
    public long UpdateLoaiThu(LoaiThu loaiThu){
        ContentValues values=new ContentValues();
        values.put("maLT",loaiThu.getMaLT());
        values.put("tenLT",loaiThu.getNameLT());
        long numUpdate=sqLiteDatabase.update("Loaithu",values,"maLT"+"=?",new String[]{loaiThu.getMaLT()});
        return numUpdate;
    }
    public long DeletLoaiThu(String maLT){
        long numDelete=sqLiteDatabase.delete("Loaithu","maLT"+"=?",new String[]{maLT});
        return numDelete;
    }
}
