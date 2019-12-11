package com.example.assmentgd1.Fargment.khoangthu.khoanthuFragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.assmentgd1.R;

public class Main_khoanthu_thongtin extends AppCompatActivity {
    private TextView tv_makt;
    private TextView tv_tenkt;
    private TextView tv_malt;
    private TextView tv_sotien;
    private TextView tv_ngaythu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_khoanthu_thongtin);
        moder();
        getIntentKT();
    }
    public void moder(){
        tv_makt=findViewById(R.id.tv_MAkt);
        tv_tenkt=findViewById(R.id.tv_TENkt);
        tv_malt=findViewById(R.id.tv_MAltt);
        tv_sotien=findViewById(R.id.tv_SOTIEN);
        tv_ngaythu=findViewById(R.id.tv_NGAYTHU);
    }
    public void getIntentKT(){
        Intent intent=getIntent();
        String intentmakt=intent.getStringExtra("makt");
        String intenttenkt=intent.getStringExtra("tenkt");
        String intentmalt=intent.getStringExtra("malt");
        String intentsotien=intent.getStringExtra("sotien");
        String intentngaythu=intent.getStringExtra("ngaythu");
       tv_makt.setText(intentmakt);
       tv_tenkt.setText(intenttenkt);
       tv_malt.setText(intentmalt);
       tv_sotien.setText(intentsotien);
       tv_ngaythu.setText(intentngaythu);
    }
}
