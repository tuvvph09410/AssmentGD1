package com.example.assmentgd1.Fargment.khoangthu.LoaiThuFragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.assmentgd1.R;

import java.util.List;

public class ApdapterLoaiThu extends ArrayAdapter<LoaiThu> {
    private Context context;
    private int resource;
    private List<LoaiThu> loaiThuList;
    public ApdapterLoaiThu(@NonNull Context context, int resource, @NonNull List<LoaiThu> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.loaiThuList=objects;
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewHolder;
        final LoaiThuDAO loaiThuDAO=new LoaiThuDAO(context);
        if (convertView == null){
            convertView= LayoutInflater.from(context).inflate(R.layout.listview_fragment_loaithu,parent,false);
            viewHolder= new ViewHolder();
            viewHolder.tv_MaLT=(TextView)convertView.findViewById(R.id.tv_MaLT);
            viewHolder.tv_NameLT=(TextView)convertView.findViewById(R.id.tv_NameLT);
            viewHolder.imgBtn_update=(ImageView)convertView.findViewById(R.id.imageButton_update);
            viewHolder.imgBtn_delete=(ImageView)convertView.findViewById(R.id.imageButton_detele);
            viewHolder.imgBtn_ghichu=(ImageView)convertView.findViewById(R.id.imageButton_Thongtin);
            convertView.setTag(viewHolder);
        }else {
        viewHolder=(ViewHolder)convertView.getTag();
        }
        final LoaiThu loaiThu=loaiThuList.get(position);
        viewHolder.tv_MaLT.setText(loaiThu.getMaLT());
        viewHolder.tv_NameLT.setText(loaiThu.getNameLT());
        viewHolder.imgBtn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context, android.R.style.Theme_DeviceDefault_Dialog);
                builder.setTitle("Bạn có muốn xóa hay không ?");
                builder.setMessage("Chọn Để Thực Hiện!");
                builder.setIcon(android.R.drawable.ic_dialog_dialer);
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        long NumDelete=loaiThuDAO.DeletLoaiThu(loaiThu.getMaLT());
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
        viewHolder.imgBtn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,Main_LoaiThu_Fragment.class);
                LoaiThu loaiThu=loaiThuList.get(position);
                intent.putExtra("malt",loaiThu.getMaLT());
                intent.putExtra("tenlt",loaiThu.getNameLT());
                context.startActivity(intent);
            }
        });
            viewHolder.imgBtn_ghichu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent=new Intent(context,Main_ThongKe.class);
                    LoaiThu loaiThu=loaiThuList.get(position);
                    intent.putExtra("malt",loaiThu.getMaLT());
                    intent.putExtra("tenlt",loaiThu.getNameLT());
                    context.startActivity(intent);
                }
            });
        return convertView;
    }
    private class ViewHolder{
            private TextView tv_MaLT;
            private TextView tv_NameLT;
            private ImageView imgBtn_delete;
            private ImageView imgBtn_update;
            private ImageView imgBtn_ghichu;
    }
}
