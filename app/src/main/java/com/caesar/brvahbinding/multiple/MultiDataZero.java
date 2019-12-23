package com.caesar.brvahbinding.multiple;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class MultiDataZero implements MultiItemEntity {
    public ObservableField<String> title = new ObservableField<>();
    public ObservableField<String>  discribe = new ObservableField<>();
    public ObservableInt resId = new ObservableInt();

    public MultiDataZero(String title, String discribe, int resId) {
        this.title.set(title);
        this.discribe.set(discribe);
        this.resId.set(resId);
    }

    public ObservableField<String> getTitle() {
        return title;
    }

    public void setTitle(ObservableField<String> title) {
        this.title = title;
    }

    public ObservableField<String> getDiscribe() {
        return discribe;
    }

    public void setDiscribe(ObservableField<String> discribe) {
        this.discribe = discribe;
    }

    public ObservableInt getResId() {
        return resId;
    }

    public void setResId(ObservableInt resId) {
        this.resId = resId;
    }


    @Override
    public int getItemType() {
        return 0;
    }
}
