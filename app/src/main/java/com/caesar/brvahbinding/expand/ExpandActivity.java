package com.caesar.brvahbinding.expand;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.caesar.brvahbinding.R;
import com.caesar.brvahbinding.databinding.ActivityExpandBinding;

public class ExpandActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expand);
        ActivityExpandBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_expand);
        ExpandViewModel expandViewModel = new ExpandViewModel();
        binding.setVm(expandViewModel);
        expandViewModel.load();

    }
}
