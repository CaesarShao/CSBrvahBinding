package com.caesar.brvahbinding.headfoot;

import android.databinding.ObservableField;
import android.view.View;

public class FootTwoData {
    public ObservableField<String> name = new ObservableField<>();


    public FootTwoData() {
        name.set("点击我改变数据");
    }

    public void oncli(View view) {
        name.set("我不做人了jojo");
    }

}
