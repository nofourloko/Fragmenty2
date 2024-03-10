package com.example.frgmenty20;

import android.view.View;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DataViewModel extends ViewModel {
    private final MutableLiveData<String> data = new MutableLiveData<>();

    public void setSharedText(String sharedText){
        data.setValue(sharedText);
    }

    public LiveData<String> getSharedData(){
        return data;
    }
}
