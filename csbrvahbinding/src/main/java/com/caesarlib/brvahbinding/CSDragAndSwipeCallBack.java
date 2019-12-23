package com.caesarlib.brvahbinding;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.DraggableController;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;

public class CSDragAndSwipeCallBack extends ItemDragAndSwipeCallback {
    public CSDragAndSwipeCallBack(DraggableController draggableController) {
        super(draggableController);
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder source, @NonNull RecyclerView.ViewHolder target) {
        return true;
    }
}
