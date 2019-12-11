package com.example.assmentgd1;

import android.content.Intent;
import android.os.Bundle;

import com.example.assmentgd1.Fargment.khoangthu.LoaiThuFragment.Main_LoaiThu_Fragment;
import com.example.assmentgd1.Fargment.khoangthu.MyViewPage;
import com.example.assmentgd1.Fargment.khoangthu.khoanthuFragment.Main_Khoanthu_Fragment;
import com.example.assmentgd1.Fargment.thoat.TFragment;
import com.example.assmentgd1.Fargment.thongke.TKFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.Menu;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_share,R.id.nav_send)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.fragment,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.it_ThemLoaiThu:
                Intent intent = new Intent(MainActivity.this, Main_LoaiThu_Fragment.class);
                startActivity(intent);
                break;
            case R.id.it_ThemKhoanThu:
                Intent intent1 = new Intent(MainActivity.this, Main_Khoanthu_Fragment.class);
                startActivity(intent1);
                break;
            case R.id.it_ThemLoaiChi:
                Toast.makeText(MainActivity.this, "Thêm Loai Chi", Toast.LENGTH_LONG).show();
                break;
            case R.id.it_ThemKhoanChi:
                Toast.makeText(MainActivity.this, "Thêm Khoan Chi", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
