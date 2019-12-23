package com.caesar.brvahbinding.animation;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import com.caesar.brvahbinding.R;
import com.caesar.brvahbinding.databinding.ActivityAnimationBinding;

public class AnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityAnimationBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_animation);
        AnimationViewModel animationViewModel = new AnimationViewModel();
        binding.setVm(animationViewModel);
        animationViewModel.load();
    }
}
