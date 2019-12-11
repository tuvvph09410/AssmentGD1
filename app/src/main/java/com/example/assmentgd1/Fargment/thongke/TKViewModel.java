package com.example.assmentgd1.Fargment.thongke;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TKViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public TKViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Thông kê");
    }

    public LiveData<String> getText() {
        return mText;
    }
}