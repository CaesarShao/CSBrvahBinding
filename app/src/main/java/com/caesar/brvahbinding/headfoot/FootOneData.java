package com.caesar.brvahbinding.headfoot;

import android.databinding.ObservableField;
import android.view.View;

public class FootOneData {
    public ObservableField<String> name = new ObservableField<>();


    public FootOneData() {
        name.set("点击我改变数据");
    }

    public void oncli(View view) {
        name.set("我不做人了jojo");
    }

}
