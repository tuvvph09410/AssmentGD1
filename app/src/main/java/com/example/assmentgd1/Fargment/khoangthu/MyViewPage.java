package com.example.assmentgd1.Fargment.khoangthu;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.assmentgd1.Fargment.khoangthu.khoanthuFragment.KTFragment;
import com.example.assmentgd1.Fargment.khoangthu.LoaiThuFragment.LTFragment;

public class MyViewPage extends FragmentPagerAdapter {
        private static int NUM_ITEMS=2;
        public MyViewPage(FragmentManager fragmentManager){super(fragmentManager);}
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return KTFragment.newInFragment("Khoản Thu",0);
            case 1:
                return LTFragment.newInFragment(1,"Loại Thu");
                default:
                    return null;
        }
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "Khoản Thu";
                case 1:
                    return "Loai Thu";
                    default:
                return null;
            }
    }
}
