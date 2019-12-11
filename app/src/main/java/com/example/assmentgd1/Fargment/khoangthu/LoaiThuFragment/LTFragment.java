package com.example.assmentgd1.Fargment.khoangthu.LoaiThuFragment;

        import android.app.AlertDialog;
        import android.content.DialogInterface;
        import android.content.Intent;
        import android.os.Bundle;
        import android.os.Handler;
        import android.view.LayoutInflater;

        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.AdapterView;
        import android.widget.ListView;
        import android.widget.Toast;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.fragment.app.Fragment;
        import com.example.assmentgd1.R;

        import java.util.ArrayList;
        import java.util.List;

public class LTFragment extends Fragment {
    private String title;
    private int page;
    private List<LoaiThu> loaiThuList;
    private ApdapterLoaiThu apdapterLoaiThu;
    private LoaiThuDAO loaiThuDAO;
    private ListView lv_fragmentLoaithu;
    public static LTFragment newInFragment(int page,String title){
        LTFragment ltFragment= new LTFragment();
        Bundle bundle=new Bundle();
        bundle.putString("someString",title);
        bundle.putInt("someInt",page);
        ltFragment.setArguments(bundle);
        return ltFragment;
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
        View view = inflater.inflate(R.layout.fragment_loaithu, container, false);
        lv_fragmentLoaithu=(ListView)view.findViewById(R.id.lv_fragmentLoaiThu);
        loaiThuDAO=new LoaiThuDAO(getActivity());
        setListView();

        return view;
    }

    private void setListView(){
        loaiThuList=new ArrayList<>(loaiThuDAO.GetAllLoaiThu());
        apdapterLoaiThu=new ApdapterLoaiThu(getActivity(),R.layout.listview_fragment_loaithu,loaiThuList);
        lv_fragmentLoaithu.setAdapter(apdapterLoaiThu);
        refreshListView(500);
    }
    private void refreshListView(int milisecond){
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                setListView();
            }
        };
        handler.postDelayed(runnable,milisecond);
    }

}