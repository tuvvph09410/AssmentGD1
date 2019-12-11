package com.example.assmentgd1.Fargment.thoat;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import com.example.assmentgd1.R;

public class TFragment extends DialogFragment {
public TFragment(){
}
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("Thoát");
        builder.setMessage("Bạn muốn thoát ứng dụng ko ?");
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        Dialog dialog=builder.create();
        return dialog;
    }
    /*public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_thoat, container, false);
        final TextView tv_text=root.findViewById(R.id.text_thoat);
        tv_text.setText("Thoát");
        return root;
    }*/
}