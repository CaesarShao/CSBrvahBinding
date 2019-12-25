package com.caesar.brvahbinding.drag;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.caesar.brvahbinding.R;
import com.caesar.brvahbinding.databinding.ActivityDragBinding;

public class DragActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag);
        ActivityDragBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_drag);
        DragViewModel dragViewModel = new DragViewModel();
        binding.setVm(dragViewModel);
        dragViewModel.load();
    }
}
