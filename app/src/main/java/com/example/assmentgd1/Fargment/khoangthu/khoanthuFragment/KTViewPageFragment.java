package com.example.assmentgd1.Fargment.khoangthu.khoanthuFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.assmentgd1.Fargment.khoangthu.MyViewPage;
import com.example.assmentgd1.R;

public class KTViewPageFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_khoangthu, container, false);
        ViewPager vpPager=root.findViewById(R.id.vpPager);
        MyViewPage fragmentPagerAdapter = new MyViewPage(getFragmentManager());
        vpPager.setAdapter(fragmentPagerAdapter);
        vpPager.addOnAdapterChangeListener(new ViewPager.OnAdapterChangeListener() {
            @Override
            public void onAdapterChanged(@NonNull ViewPager viewPager, @Nullable PagerAdapter oldAdapter, @Nullable PagerAdapter newAdapter) {
            }
        });
        return root;
    }
}