package com.caesar.brvahbinding.drag;


import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;

import com.caesar.brvahbinding.nonMultiple.NonMultiViewModel;
import com.caesarlib.brvahbinding.CSDragAndSwipeCallBack;
import com.chad.library.adapter.base.DraggableController;
import com.chad.library.adapter.base.listener.OnItemDragListener;

public class DragViewModel extends NonMultiViewModel {
    private boolean isSwipe = true;

    @Override
    public OnItemDragListener getItemDragListener() {
        return new OnItemDragListener() {
            @Override
            public void onItemDragStart(RecyclerView.ViewHolder viewHolder, int i) {

            }

            @Override
            public void onItemDragMoving(RecyclerView.ViewHolder viewHolder, int i, RecyclerView.ViewHolder viewHolder1, int i1) {

            }

            @Override
            public void onItemDragEnd(RecyclerView.ViewHolder viewHolder, int i) {

            }
        };
    }

    public void onSwi(View view) {
        if (isSwipe) {
            isSwipe = false;
            bindingAdapter.getDraggableController().disableDragItem();
        } else {
            isSwipe = true;
            bindingAdapter.getDraggableController().enableDragItem(bindingAdapter.getItemTouchHelper(null));
        }
    }
}
