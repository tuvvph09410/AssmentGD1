package com.example.assmentgd1.Fargment.gioithieu;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class GTViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public GTViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Giới Thiệu");
    }

    public LiveData<String> getText() {
        return mText;
    }
}