package com.example.assmentgd1.Fargment.khoangthu.khoanthuFragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.assmentgd1.Fargment.khoangthu.LoaiThuFragment.LoaiThu;
import com.example.assmentgd1.R;

import java.util.List;

public class ApdapterKhoanThu extends ArrayAdapter<Khoanthu> {
    private Context context;
    private int resource;
    private List<Khoanthu> khoanthuList;
    public ApdapterKhoanThu(@NonNull Context context, int resource, @NonNull List<Khoanthu> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.khoanthuList=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        final KhoanthuDao khoanthuDao=new KhoanthuDao(context);
        if (convertView == null){
            convertView= LayoutInflater.from(context).inflate(R.layout.listview_khoanthu,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.textViewmakt=(TextView)convertView.findViewById(R.id.tv_makt);
            viewHolder.textViewtenkt=(TextView)convertView.findViewById(R.id.tv_tenkt);
            viewHolder.textViewmalt=(TextView)convertView.findViewById(R.id.tv_malt);
            viewHolder.textViewsotien=(TextView)convertView.findViewById(R.id.tv_sotien);
            viewHolder.textViewngaythu=(TextView)convertView.findViewById(R.id.tv_ngaythu);
            viewHolder.btn_sua=(ImageButton)convertView.findViewById(R.id.IGB_sua);
            viewHolder.btn_xoa=(ImageButton)convertView.findViewById(R.id.IGB_xoa);
            viewHolder.btn_thongtin=(ImageButton)convertView.findViewById(R.id.IGB_xem);
            convertView.setTag(viewHolder);
        }else {
            viewHolder=(ViewHolder)convertView.getTag();
        }
            final Khoanthu khoanthu=khoanthuList.get(position);
            viewHolder.textViewmakt.setText(khoanthu.getMaKT());
            viewHolder.textViewtenkt.setText(khoanthu.getNameKT());
            viewHolder.textViewmalt.setText(khoanthu.getMaLT());
            viewHolder.textViewsotien.setText(String.valueOf(khoanthu.getSoTien()));
            viewHolder.textViewngaythu.setText(khoanthu.getNgayThu());
            viewHolder.btn_xoa.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context, android.R.style.Theme_DeviceDefault_Dialog);
                    builder.setTitle("Bạn có muốn xóa hay không ?");
                    builder.setMessage("Chọn Để Thực Hiện!");
                    builder.setIcon(android.R.drawable.ic_dialog_dialer);
                    builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            long NumDelete=khoanthuDao.deleteKhoanthu(khoanthu.getMaKT());
                            if (NumDelete >0){
                                Toast.makeText(context, "Xóa Thành Công", Toast.LENGTH_SHORT).show();

                            }else {
                                Toast.makeText(context, "Xóa Thất Bại", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                    builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builder.show();
                }
            });
            viewHolder.btn_sua.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context,Main_Khoanthu_Fragment.class);
                    intent.putExtra("makt",khoanthu.getMaKT());
                    intent.putExtra("tenkt",khoanthu.getNameKT());
                    intent.putExtra("malt",khoanthu.getMaLT());
                    intent.putExtra("sotien",String.valueOf(khoanthu.getSoTien()));
                    intent.putExtra("ngaythu",khoanthu.getNgayThu());
                    context.startActivity(intent);
                }
            });
            viewHolder.btn_thongtin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context,Main_khoanthu_thongtin.class);
                    intent.putExtra("makt",khoanthu.getMaKT());
                    intent.putExtra("tenkt",khoanthu.getNameKT());
                    intent.putExtra("malt",khoanthu.getMaLT());
                    intent.putExtra("sotien",String.valueOf(khoanthu.getSoTien()));
                    intent.putExtra("ngaythu",khoanthu.getNgayThu());
                    context.startActivity(intent);
                }
            });
        return convertView;
    }
    private class ViewHolder{
        TextView textViewmakt;
        TextView textViewtenkt;
        TextView textViewmalt;
        TextView textViewsotien;
        TextView textViewngaythu;
        ImageButton btn_xoa;
        ImageButton btn_sua;
        ImageButton btn_thongtin;
    }
}
