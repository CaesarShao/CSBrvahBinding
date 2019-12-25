package com.caesar.brvahbinding.drag;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.caesar.brvahbinding.R;
import com.caesar.brvahbinding.databinding.ActivityDragAswipeBinding;

public class DragASwipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDragAswipeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_drag_aswipe);
        DragASwipeViewModel dragASwipeViewModel = new DragASwipeViewModel();
        binding.setVm(dragASwipeViewModel);
        dragASwipeViewModel.load();
    }
}
