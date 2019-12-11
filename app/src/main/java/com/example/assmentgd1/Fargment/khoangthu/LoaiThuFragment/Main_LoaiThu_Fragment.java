package com.example.assmentgd1.Fargment.khoangthu.LoaiThuFragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assmentgd1.Fargment.khoangthu.DatabaseHelperFragmentKhoanThu;
import com.example.assmentgd1.Fargment.khoangthu.khoanthuFragment.Main_Khoanthu_Fragment;
import com.example.assmentgd1.R;

import java.util.ArrayList;
import java.util.List;

public class Main_LoaiThu_Fragment extends AppCompatActivity {
    private EditText editTextMaLT;
    private EditText editTextNameLT;
    private Button btn_Save;
    private Button btn_Update;
    private DatabaseHelperFragmentKhoanThu databaseHelperFragmentKhoanThu;
    private LoaiThuDAO loaiThuDAO;
    private List<LoaiThu> loaiThuList;
    private ApdapterLoaiThu apdapterLoaiThu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__loai_thu__fragment);
        loaiThuDAO=new LoaiThuDAO(Main_LoaiThu_Fragment.this);
        loaiThuList=new ArrayList<>(loaiThuDAO.GetAllLoaiThu());
        databaseHelperFragmentKhoanThu =new DatabaseHelperFragmentKhoanThu(Main_LoaiThu_Fragment.this);
        moder();
        getintent();
        btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoaiThu loaiThu=Create();
                boolean isSuccess=loaiThuDAO.InsertLoaiThu(loaiThu);
                if (isSuccess){
                    Toast.makeText(Main_LoaiThu_Fragment.this,"Chèm Thành Công", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(Main_LoaiThu_Fragment.this,"Chèn Thất Bại", Toast.LENGTH_LONG).show();
                }
            }
        });
        btn_Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoaiThu loaiThu=new LoaiThu();
                loaiThu.setMaLT(editTextMaLT.getText().toString());
                loaiThu.setNameLT(editTextNameLT.getText().toString());
                long NumUpdate=loaiThuDAO.UpdateLoaiThu(loaiThu);
                if (NumUpdate > 0){
                    Toast.makeText(Main_LoaiThu_Fragment.this,"Sửa Thành Công", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void moder() {
        editTextMaLT=(EditText)findViewById(R.id.ed_maLT);
        editTextNameLT=(EditText)findViewById(R.id.ed_nameLT);
        btn_Save=(Button)findViewById(R.id.btn_saveLT);
        btn_Update=(Button)findViewById(R.id.btn_updateLT);

    }
    private LoaiThu Create(){
    String mlt=editTextMaLT.getText().toString();
    String tlt=editTextNameLT.getText().toString();
    LoaiThu loaiThu=new LoaiThu(mlt,tlt);
    return loaiThu;
    }
    public void getintent(){
        Intent intent=getIntent();
        String intentmalt=intent.getStringExtra("malt");
        String intenttenlt=intent.getStringExtra("tenlt");
        editTextMaLT.setText(intentmalt);
        editTextNameLT.setText(intenttenlt);
    }
}
