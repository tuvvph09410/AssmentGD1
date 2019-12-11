package com.example.assmentgd1.Fargment.khoangthu.khoanthuFragment;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assmentgd1.Fargment.khoangthu.LoaiThuFragment.LoaiThu;
import com.example.assmentgd1.Fargment.khoangthu.LoaiThuFragment.LoaiThuDAO;
import com.example.assmentgd1.Fargment.khoangthu.LoaiThuFragment.Main_LoaiThu_Fragment;
import com.example.assmentgd1.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class Main_Khoanthu_Fragment extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private EditText editTextMaKT;
    private EditText editTextTenKT;
    private Spinner spinnerLT;
    private EditText editTextSoTien;
    private TextView tvNgayThu;
    private Button btn_savekt;
    private Button btn_updatekt;
    private Calendar cal;
    private List<LoaiThu> loaiThuList;
    private LoaiThuDAO loaiThuDAO;
    private LoaiThu loaiThu;
    private KhoanthuDao khoanthuDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__khoanthu__fragment);
        moder();
        loaiThuDAO=new LoaiThuDAO(Main_Khoanthu_Fragment.this);
        khoanthuDao=new KhoanthuDao(Main_Khoanthu_Fragment.this);
        getDefaultInfor();
        addEventFormWidgets();
        addSpinner();
        getIntentKT();
    }

    private void moder() {
        editTextMaKT=(EditText)findViewById(R.id.ed_Makt);
        editTextTenKT=(EditText)findViewById(R.id.ed_Tenkt);
        editTextSoTien=(EditText)findViewById(R.id.ed_sotien);
        tvNgayThu=(TextView)findViewById(R.id.tv_ngaythu);
        spinnerLT=(Spinner)findViewById(R.id.sp_LoaiTThu);
        btn_savekt=(Button)findViewById(R.id.btn_savekt);
        btn_updatekt=(Button)findViewById(R.id.btn_updatekt);
    }
    public void getDefaultInfor() {
        cal = Calendar.getInstance();
        SimpleDateFormat dft= null;
        dft=new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String strDate=dft.format(cal.getTime());
        tvNgayThu.setText(strDate);
    }
    public void addEventFormWidgets() {
        tvNgayThu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });
        btn_savekt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Khoanthu khoanthu=create();
                boolean isSuccess=khoanthuDao.InsertKhoanThu(khoanthu);
                if (isSuccess){
                    Toast.makeText(Main_Khoanthu_Fragment.this,"Chèm Thành Công", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(Main_Khoanthu_Fragment.this,"Chèn Thất Bại", Toast.LENGTH_LONG).show();
                }
            }
        });
        btn_updatekt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Khoanthu khoanthu=new Khoanthu();
            khoanthu.setMaKT(editTextMaKT.getText().toString());
            khoanthu.setNameKT(editTextTenKT.getText().toString());
            khoanthu.setMaLT(loaiThu.getMaLT());
            khoanthu.setSoTien(Integer.parseInt(editTextSoTien.getText().toString()));
            khoanthu.setNgayThu(tvNgayThu.getText().toString());
            long numUpdate=khoanthuDao.updateKhoanthu(khoanthu);
                if (numUpdate > 0){
                    Toast.makeText(Main_Khoanthu_Fragment.this,"Sửa Thành Công", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void showDatePickerDialog() {
        DatePickerDialog.OnDateSetListener callback=new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year,
                                  int monthOfYear,
                                  int dayOfMonth) {
                tvNgayThu.setText(
                        (dayOfMonth) +"/"+(monthOfYear+1)+"/"+year);
                cal.set(year, monthOfYear, dayOfMonth);
                Date dateFinish = cal.getTime();
            }
        };
        String s=tvNgayThu.getText()+"";
        String strArrtmp[]=s.split("/");
        int ngay=Integer.parseInt(strArrtmp[0]);
        int thang=Integer.parseInt(strArrtmp[1])-1;
        int nam=Integer.parseInt(strArrtmp[2]);
        DatePickerDialog pic=new DatePickerDialog(
                Main_Khoanthu_Fragment.this,
                callback, nam, thang, ngay);
        pic.setTitle("Chọn ngày hoàn thành");
        pic.show();
    }
    public void addSpinner() {
        loaiThuList = new ArrayList<>(loaiThuDAO.GetAllLoaiThu());
        ArrayAdapter<LoaiThu> arrayAdapter = new ArrayAdapter<LoaiThu>(Main_Khoanthu_Fragment.this, android.R.layout.simple_spinner_item, loaiThuList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLT.setAdapter(arrayAdapter);
        spinnerLT.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                loaiThu=loaiThuList.get(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item=parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),"Selected: "+item,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public Khoanthu create(){
        String makt=editTextMaKT.getText().toString();
        String tenkt=editTextTenKT.getText().toString();
        String malt=loaiThu.getMaLT();
        int sotien= Integer.parseInt(editTextSoTien.getText().toString());
        String ngaythu=tvNgayThu.getText().toString();
        Khoanthu khoanthu=new Khoanthu(makt,tenkt,malt,sotien,ngaythu);
        return khoanthu;
    }
    public void getIntentKT(){
        Intent intent=getIntent();
        String intentmakt=intent.getStringExtra("makt");
        String intenttenkt=intent.getStringExtra("tenkt");
        String intentmalt=intent.getStringExtra("malt");
        String intentsotien=intent.getStringExtra("sotien");
        String intentngaythu=intent.getStringExtra("ngaythu");
        editTextMaKT.setText(intentmakt);
        editTextTenKT.setText(intenttenkt);
        editTextSoTien.setText(intentsotien);
        tvNgayThu.setText(intentngaythu);

    }
}
