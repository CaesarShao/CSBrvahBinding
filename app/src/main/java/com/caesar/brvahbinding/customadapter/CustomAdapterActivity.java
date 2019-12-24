package com.caesar.brvahbinding.customadapter;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.caesar.brvahbinding.R;
import com.caesar.brvahbinding.databinding.ActivityCustomAdapterBinding;

public class CustomAdapterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCustomAdapterBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_custom_adapter);
        binding.rvShow.setLayoutManager(new LinearLayoutManager(this));
        CustomAdapterViewModel customAdapterViewModel = new CustomAdapterViewModel();
        binding.setVm(customAdapterViewModel);
        customAdapterViewModel.load();
    }
}
