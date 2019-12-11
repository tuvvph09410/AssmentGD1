package com.example.assmentgd1.Fargment.khoangchi;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class KCViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public KCViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Khoảng chi");
    }

    public LiveData<String> getText() {
        return mText;
    }
}