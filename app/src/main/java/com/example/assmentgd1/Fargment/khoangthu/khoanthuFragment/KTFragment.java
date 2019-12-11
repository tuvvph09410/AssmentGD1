package com.example.assmentgd1.Fargment.khoangthu.khoanthuFragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.assmentgd1.R;

import java.util.ArrayList;
import java.util.List;

public class KTFragment extends Fragment {
    private String title;
    private int page;
    private ListView listViewKhoanthu;
    private KhoanthuDao khoanthuDao;
    private List<Khoanthu> khoanthuList;
    private ApdapterKhoanThu apdapterKhoanThu;
    public static KTFragment newInFragment(String title,int page){
        KTFragment ktFragment=new KTFragment();
        Bundle bundle=new Bundle();
        bundle.putString("someString",title);
        bundle.putInt("someInt",page);
        ktFragment.setArguments(bundle);
        return ktFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        title=getArguments().getString("someString");
        page=getArguments().getInt("someInt",0);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_kthu,container,false);
        listViewKhoanthu=(ListView)view.findViewById(R.id.lv_khoanthu);
        khoanthuDao=new KhoanthuDao(getActivity());
        setListview();
        return view;
    }
    public void setListview(){
    khoanthuList=new ArrayList<>(khoanthuDao.getAllKhoanthu());
    apdapterKhoanThu=new ApdapterKhoanThu(getActivity(),R.layout.listview_khoanthu,khoanthuList);
    listViewKhoanthu.setAdapter(apdapterKhoanThu);
    refreshListView(500);
    }
    private void refreshListView(int milisecond){
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                setListview();
            }
        };
        handler.postDelayed(runnable,milisecond);
    }
}
