package com.caesar.brvahbinding.headfoot;

import android.databinding.ObservableField;
import android.view.View;

public class HeadTwoData {
    public ObservableField<String> name = new ObservableField<>();


    public HeadTwoData() {
        name.set("点击我改变数据");
    }

    public void oncli(View view) {
        name.set("我是改变的数据");
    }

}
