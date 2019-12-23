package com.caesar.brvahbinding.multiple;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.caesar.brvahbinding.R;
import com.caesar.brvahbinding.databinding.ActivityMultipleLineBinding;

public class MultipleLineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMultipleLineBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_multiple_line);
        MultiLineViewModel multiLineViewModel = new MultiLineViewModel();
        binding.setVm(multiLineViewModel);
        multiLineViewModel.load();
    }
}
