package com.example.assmentgd1.Fargment.khoangthu.LoaiThuFragment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.assmentgd1.R;

public class Main_ThongKe extends AppCompatActivity {
    private TextView tv_malt;
    private TextView tv_tenlt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__thong_ke);
        tv_malt=(TextView)findViewById(R.id.tv_malt);
        tv_tenlt=(TextView)findViewById(R.id.tv_namelt);
        Intent intent=getIntent();
        String intentmalt=intent.getStringExtra("malt");
        String intenttenlt=intent.getStringExtra("tenlt");
        tv_malt.setText(intentmalt);
        tv_tenlt.setText(intenttenlt);

    }
}
