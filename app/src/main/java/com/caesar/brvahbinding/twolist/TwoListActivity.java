package com.caesar.brvahbinding.twolist;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import com.caesar.brvahbinding.R;
import com.caesar.brvahbinding.databinding.ActivityTwoListBinding;

public class TwoListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_list);
        ActivityTwoListBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_two_list);
        TwoListViewModel twoListViewModel = new TwoListViewModel(binding.rvShow);
        binding.setVm(twoListViewModel);
        twoListViewModel.loadA();
        twoListViewModel.loadB();
    }
}
