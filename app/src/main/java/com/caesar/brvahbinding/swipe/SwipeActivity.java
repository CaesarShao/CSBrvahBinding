package com.caesar.brvahbinding.swipe;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.caesar.brvahbinding.R;
import com.caesar.brvahbinding.databinding.ActivitySwipeBinding;

public class SwipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe);
        ActivitySwipeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_swipe);
        SwipeViewModel swipeViewModel = new SwipeViewModel(binding.rvShow);
        binding.setVm(swipeViewModel);
        swipeViewModel.load();
    }
}
